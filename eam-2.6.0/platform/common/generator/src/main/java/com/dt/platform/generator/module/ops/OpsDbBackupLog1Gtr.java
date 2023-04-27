package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.MonitorWarnProcessStatusEnum;
import com.dt.platform.constants.enums.ops.OpsDbBackupLogProcessedEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbBackupLogPageController;
import com.dt.platform.proxy.ops.DbBackupLogServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsDbBackupLog1Gtr extends BaseCodeGenerator{


    public OpsDbBackupLog1Gtr() {
        super(OpsTables.OPS_DB_BACKUP_LOG.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.IP).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.CREATE_TIME).search().range();
        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.RECORD_TIME).search().range();
        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.ACTION).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.RESULT).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.SOURCE).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_BACKUP_LOG.PROCESSED,
                        OpsTables.OPS_DB_BACKUP_LOG.IP,
                        OpsTables.OPS_DB_BACKUP_LOG.STATUS,
                        OpsTables.OPS_DB_BACKUP_LOG.ACTION,
                },
                new Object[]{
                        OpsTables.OPS_DB_BACKUP_LOG.RESULT,
                        OpsTables.OPS_DB_BACKUP_LOG.PROCESS_RESULT,
                        OpsTables.OPS_DB_BACKUP_LOG.SOURCE,
                        OpsTables.OPS_DB_BACKUP_LOG.NOTES,

                },
                new Object[]{
                        OpsTables.OPS_DB_BACKUP_LOG.RECORD_TIME,
                        OpsTables.OPS_DB_BACKUP_LOG.CREATE_TIME,
                }

        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().list().addToolButton("处理数据","processData","process-data","ops_db_backup_log:process");

        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.PROCESSED).form().selectBox().enumType(OpsDbBackupLogProcessedEnum.class);
        cfg.view().field(OpsTables.OPS_DB_BACKUP_LOG.DB_ID).table().hidden();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_LOG.UID,
                        OpsTables.OPS_DB_BACKUP_LOG.DB_ID,
                        OpsTables.OPS_DB_BACKUP_LOG.IP,
                        OpsTables.OPS_DB_BACKUP_LOG.DB_NAME,
                        OpsTables.OPS_DB_BACKUP_LOG.ACTION,
                        OpsTables.OPS_DB_BACKUP_LOG.STATUS,
                        OpsTables.OPS_DB_BACKUP_LOG.RESULT,
                        OpsTables.OPS_DB_BACKUP_LOG.STIME,
                        OpsTables.OPS_DB_BACKUP_LOG.ETIME,
                        OpsTables.OPS_DB_BACKUP_LOG.SOURCE,
                        OpsTables.OPS_DB_BACKUP_LOG.RECORD_TIME,
                        OpsTables.OPS_DB_BACKUP_LOG.PROCESSED,
                        OpsTables.OPS_DB_BACKUP_LOG.PROCESS_RESULT,
                        OpsTables.OPS_DB_BACKUP_LOG.LAST_PROCESS_TIME,
                }
        );
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsDbBackupLog1Gtr g=new OpsDbBackupLog1Gtr();
        //生成代码
        g.generateCode();


    }
}
