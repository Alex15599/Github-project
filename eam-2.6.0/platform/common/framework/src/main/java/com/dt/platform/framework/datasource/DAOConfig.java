package com.dt.platform.framework.datasource;

import com.dt.platform.domain.eam.AssetDataPermissions;
import com.dt.platform.domain.eam.meta.AssetDataPermissionsMeta;
import com.dt.platform.relation.PlatformRelationManager;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.cache.CacheProperties;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.dataperm.DataPermManager;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.dao.sql.loader.SQLoader;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.meta.DBDataType;
import com.github.foxnic.sql.treaty.DBTreaty;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.framework.cache.FoxnicDataCacheManager;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DAOConfig {

	@Value("${"+ DatasourceConfig.PRIMARY_DATASOURCE_CONFIG_KEY+".printSQL}")
	private Boolean printSQL;

	@Value("${"+DatasourceConfig.PRIMARY_DATASOURCE_CONFIG_KEY+".printSQLSimple}")
	private Boolean printSQLSimple;

	@Value("${"+DatasourceConfig.PRIMARY_DATASOURCE_CONFIG_KEY+".printSQLCallstack}")
	private Boolean printSQLCallstack;



	@Value("${develop.start-relation-monitor}")
	private  Boolean startRelationMonitor=false;

	@Bean(DBConfigs.PRIMARY_DAO)
	@Primary
	public DAO primaryDAO (
            @Qualifier(DatasourceConfig.PRIMARY_DATA_SOURCE_NAME) DataSource dataSource) {
		try {
			if(printSQL==null) printSQL=false;

			//解密数据库配置信息，并重新设置数据库连接
			DBConfigs.reset(dataSource,DatasourceConfig.PRIMARY_DATASOURCE_CONFIG_KEY,null);

			DAO dao= (new DAOBuilder().datasource(dataSource)).build();
			dao.setPrintSQL(printSQL);
			dao.setPrintSQLSimple(printSQLSimple);
			dao.setPrintSQLCallstack(printSQLCallstack);
			dao.setDBTreaty(getDBTreaty());
			PlatformRelationManager relationManager=new PlatformRelationManager();
			if(startRelationMonitor) {
				relationManager.startMonitor();
			}
			dao.setRelationManager(relationManager);

			//设置序列相关的配置
			dao.setSequenceTable(FoxnicWeb.SYS_SEQUENCE.$NAME);
			dao.setSequenceProcedure("NEXT_VAL");

			//设置缓存
			FoxnicDataCacheManager cacheManager=new FoxnicDataCacheManager();
			CacheProperties cacheProperties=new CacheProperties(SpringUtil.getEnvProperties("foxnic.cache"));
			cacheManager.setCacheProperties(cacheProperties);
			cacheManager.setRelationManager(relationManager);
			dao.setDataCacheManager(cacheManager);


			//数据权限管理器
			DataPermManager dataPermManager=getDataPermManager(dao);
			dao.setDataPermManager(dataPermManager);

			//设置SQL扫描
			SQLoader.addTQLScanPackage(dao,SpringUtil.getStartupClass().getPackage().getName());
			ComponentScan sc=(ComponentScan)SpringUtil.getStartupClass().getAnnotation(ComponentScan.class);
			for (String pkg : sc.basePackages()) {
				SQLoader.addTQLScanPackage(dao,pkg);
			}

			Logger.info("dao is ready : \n\n"+dao.toString()+"\n");

			return dao;
		} catch (Exception e) {
			Logger.error("创建DAO失败",e);
			return null;
		}
	}

	public DataPermManager getDataPermManager(DAO dao) {

		DataPermManager dataPermManager=new DataPermManager();

		//资产管理全局数据权限
		dataPermManager.registerGlobalContextGetter(AssetDataPermissions.class,"assetDataPermissions",()->{
			AssetDataPermissions dp=null;
			SessionUser user=(SessionUser)dao.getDBTreaty().getSubject();
			String employId=user.getActivatedEmployeeId();
			//数值越小，优先级越高
			String sql="select c.* from eam_asset_data_permissions c where c.status='enable' and  c.owner_code='asset' and c.deleted=0 " +
					"and c.role_code in (select distinct a.code from sys_busi_role a,sys_busi_role_member b where b.member_id=? and a.id=b.role_id and a.deleted=0) " +
					"order by c.priority";
			RcdSet rs= dao.query(sql,employId);
			List<AssetDataPermissions> list=rs.toEntityList(AssetDataPermissions.class);
			if(list.size()>0){
				dp=list.get(0);
			}

			//如果没有找到数据权限，则默认使用data_perm_0为0的数据权限
			if(dp==null){
				RcdSet rs2= dao.query("select * from eam_asset_data_permissions where code='data_perm_0' and deleted=0");
				List<AssetDataPermissions> list2=rs2.toEntityList(AssetDataPermissions.class);
				if(list2.size()>0){
					dp=list2.get(0);
				}
			}
			if(dp!=null){
				dao.fill(dp)
						.with(AssetDataPermissionsMeta.ORGANIZATION)
						.with(AssetDataPermissionsMeta.OWN_ORGANIZATION)
						.with(AssetDataPermissionsMeta.BUSI_ROLE)
						.with(AssetDataPermissionsMeta.POSITION)
						.with(AssetDataPermissionsMeta.CATEGORY)
						.execute();
			}
			return dp;
		});
		return dataPermManager;
	}

	public DBTreaty getDBTreaty() {

		DBTreaty dbTreaty=new DBTreaty();
		//
		dbTreaty.setAllowDeleteWithoutWhere(false);
		dbTreaty.setAllowUpdateWithoutWhere(false);

		//
		dbTreaty.setUserIdDataType(DBDataType.STRING);
		//
		dbTreaty.setTenantIdField("tenant_id");
		//
		dbTreaty.setCreateTimeField("create_time");
		dbTreaty.setCreateUserIdField("create_by");
		//
		dbTreaty.setUpdateTimeField("update_time");
		dbTreaty.setUpdateUserIdField("update_by");
		//
		dbTreaty.setDeletedField("deleted");
		dbTreaty.setDeleteTimeField("delete_time");
		dbTreaty.setDeleteUserIdField("delete_by");
		//
		dbTreaty.setVersionField("version");
		//
		dbTreaty.setAutoCastLogicField(false);
		//
		dbTreaty.setFalseValue(0);
		dbTreaty.setTrueValue(1);

		//设置获取当前用户的逻辑
		if(SpringUtil.isReady()) {
			dbTreaty.setSubjectHandler(()->{
				SessionUser user=SessionUser.getCurrent();
				return  user;
			});

			dbTreaty.setLoginUserIdHandler(()->{
				SessionUser user=SessionUser.getCurrent();
				if(user==null) return null;
				return  user.getUserId();
			});
		}

		dbTreaty.setTenantIdHandler(()->{
			SessionUser user=SessionUser.getCurrent();
			if(user==null) return null;
			if(user.getUser()!=null && user.getUser().getActivatedTenant()!=null) {
				return user.getActivatedTenantId();
			}
			return null;
		});

		//
		return dbTreaty;
	}

}
