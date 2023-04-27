package com.dt.platform.generator.constants;

import com.dt.platform.generator.config.PlatformConfigs;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;


public class CustDBMetaGenerator {


	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		CustDBMetaGenerator g = new CustDBMetaGenerator();
		g.buildDBMeta();
	}

	private PlatformConfigs configs;
	private DAO dao;

	public CustDBMetaGenerator() {
		this.configs=new PlatformConfigs("service-customer");
		this.dao=this.configs.getDAO();
	}


	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {

		// 主文件
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"CustTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if( table.startsWith("cust_") ) return true;
			return false;
		});
		dbMetaBuilder.save(true);



	}

}
