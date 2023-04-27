package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.ops.OpsDbBackupResultEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbBackupRecordPageController;
import com.dt.platform.proxy.ops.DbBackupRecordServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsDbInfoBackupRcdGtr extends BaseCodeGenerator{


    public OpsDbInfoBackupRcdGtr() {
        super(OpsTables.OPS_DB_BACKUP_RECORD.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_STIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_ETIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();


        cfg.getPoClassFile().addSimpleProperty(Host.class,"host","host","host");
        cfg.getPoClassFile().addSimpleProperty(DbInfo.class,"db","db","db");
        cfg.getPoClassFile().addSimpleProperty(DbBackupInfo.class,"backupInfo","backupInfo","backupInfo");
        cfg.getPoClassFile().addSimpleProperty(ServiceInfo.class,"dbType","dbType","dbType");
        cfg.view().field(OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_RESULT_CT).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_RESULT,
                }
        );
        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.BACKUP_RESULT).basic().label("备份结果")
                .form().selectBox().enumType(OpsDbBackupResultEnum.class);


        cfg.view().field(OpsTables.OPS_DB_BACKUP_RECORD.DB_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_BACKUP_RECORD.DB_BK_ID).table().disable(true);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);

        String resourceNameField="res_"+OpsTables.OPS_HOST.HOST_IP;
        cfg.view().field(resourceNameField)
                .basic().label("IP")
                .table().fillBy(DbBackupRecordMeta.HOST, HostMeta.HOST_IP);


        String resourceNameField2="res_"+OpsTables.OPS_HOST.HOST_NAME;
        cfg.view().field(resourceNameField2)
                .basic().label("主机名")
                .table().fillBy(DbBackupRecordMeta.HOST, HostMeta.HOST_NAME);



        String resourceNameField3="res_db_"+OpsTables.OPS_DB_INFO.NAME;
        cfg.view().field(resourceNameField3)
                .basic().label("数据库")
                .table().fillBy(DbBackupRecordMeta.DB, DbInfoMeta.NAME);


        String resourceNameField4="res_db_type_"+OpsTables.OPS_DB_INFO.NAME;
        cfg.view().field(resourceNameField4)
                .basic().label("数据库类型")
                .table().fillBy(DbBackupRecordMeta.DB_TYPE, ServiceInfoMeta.NAME);


        String resourceNameField5="res_db_backup_"+OpsTables.OPS_DB_BACKUP_INFO.NAME;
        cfg.view().field(resourceNameField5)
                .basic().label("备份策略")
                .table().fillBy(DbBackupRecordMeta.BACKUP_INFO, DbBackupInfoMeta.BACKUP_STRATEGY);

        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableCreateNew();

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_RESULT,
                        OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_SOURCE,
                        OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_SIZE,

                },
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_STIME,
                        OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_ETIME,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_RECORD.BACKUP_RESULT_CT

                }
        );

        cfg.view().list().addJsVariable("DB_ID","[[${dbId}]]","dbId");


        cfg.view().list().addJsVariable("BACKUP_RESULT","[[${backupResult}]]","backupResult");




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsDbInfoBackupRcdGtr g=new OpsDbInfoBackupRcdGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.removeByBatchId("474335473372758016");
        //g.generateMenu(ServiceGroupServiceProxy.class, ServiceGroupPageController.class);
       // g.generateMenu(DbBackupRecordServiceProxy.class, DbBackupRecordPageController.class);
    }
}
