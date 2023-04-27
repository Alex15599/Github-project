package com.dt.platform.generator.constants;

import com.dt.platform.generator.config.PlatformConfigs;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;


public class WmsDbMetaGenerator {


	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		WmsDbMetaGenerator g = new WmsDbMetaGenerator();
		g.buildDBMeta();
	}

	private PlatformConfigs configs;
	private DAO dao;

	public WmsDbMetaGenerator() {
		this.configs=new PlatformConfigs("service-wms");
		this.dao=this.configs.getDAO();
	}


	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {

		// 第三个文件
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"WmsTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if( table.startsWith("wms_")) return true;
			return false;
		});
		dbMetaBuilder.save(true);

	}

}
