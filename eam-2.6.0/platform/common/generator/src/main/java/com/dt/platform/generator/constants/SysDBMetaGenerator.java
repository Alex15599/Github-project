package com.dt.platform.generator.constants;

import com.dt.platform.generator.config.PlatformConfigs;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;


public class SysDBMetaGenerator {


	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		SysDBMetaGenerator g = new SysDBMetaGenerator();
		g.buildDBMeta();
	}

	private PlatformConfigs configs;
	private DAO dao;

	public SysDBMetaGenerator() {
		this.configs=new PlatformConfigs("service-eam");
		this.dao=this.configs.getDAO();
	}


	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {

		// 主文件
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"SysTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if( table.startsWith("sys_licence_switch")
					||table.startsWith("sys_backup_db_strategy")
					||table.startsWith("sys_backup_db")
					||table.startsWith("sys_auto_")
					||table.startsWith("sys_auto_module")
					||table.startsWith("sys_node_load")
					||table.startsWith("sys_log_collect")
					||table.startsWith("sys_auto_role") ) return true;
			return false;
		});
		dbMetaBuilder.save(true);



	}

}
