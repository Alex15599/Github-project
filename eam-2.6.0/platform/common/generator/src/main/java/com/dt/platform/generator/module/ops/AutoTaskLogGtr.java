package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsAutoTaskResultStatusEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoTaskLogPageController;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;

public class AutoTaskLogGtr extends BaseCodeGenerator{


    public AutoTaskLogGtr() {
        super(OpsTables.OPS_AUTO_TASK_LOG.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(AutoTask.class,"task","task","task");
        cfg.getPoClassFile().addSimpleProperty(AutoAction.class,"action","action","action");
        cfg.getPoClassFile().addSimpleProperty(AutoNode.class,"node","node","node");
        cfg.getPoClassFile().addSimpleProperty(AutoTaskMLog.class,"mLog","mLog","mLog");


        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.NOTES).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.RECORD_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.STIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.ETIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_TASK_LOG.STATUS,
                        OpsTables.OPS_AUTO_TASK_LOG.TASK_ID,
                        OpsTables.OPS_AUTO_TASK_LOG.NODE_ID,
                        OpsTables.OPS_AUTO_TASK_LOG.RECORD_CONTENT,

                },
                new Object[]{
                        OpsTables.OPS_AUTO_TASK_LOG.NOTES,
                        OpsTables.OPS_AUTO_TASK_LOG.RECORD_TIME,

                }
        );

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.STATUS).table().form().selectBox().enumType(OpsAutoTaskResultStatusEnum.class).defaultIndex(0);


        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableModify();
        cfg.view().list().disableBatchDelete();

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.M_LOG_ID)
                .form().selectBox().queryApi(AutoTaskMLogServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AutoTaskMLogMeta.ID).
                textField(AutoTaskMLogMeta.ID).
                fillWith(AutoTaskLogMeta.M_LOG).muliti(false);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.NODE_ID)
                .form().selectBox().queryApi(AutoNodeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AutoNodeMeta.ID).
                textField(AutoNodeMeta.NAME).
                fillWith(AutoTaskLogMeta.NODE).muliti(false);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.TASK_ID)
                .form().selectBox().queryApi(AutoTaskServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AutoTaskMeta.ID).
                textField(AutoTaskMeta.NAME).
                fillWith(AutoTaskLogMeta.TASK).muliti(false);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.ACTION_ID)
                .form().selectBox().queryApi(AutoActionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AutoActionMeta.ID).
                textField(AutoActionMeta.NAME).
                fillWith(AutoTaskLogMeta.ACTION).muliti(false);


        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.M_LOG_ID).basic().table().disable(true);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.RECORD_CONTENT).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.CONTENT_DETAIL).basic().table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG.CONTENT_DETAIL).form().textArea().height(Config.textAreaHeight*2);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_TASK_LOG.NODE_IP,
                        OpsTables.OPS_AUTO_TASK_LOG.STATUS,
                        OpsTables.OPS_AUTO_TASK_LOG.TASK_ID,
                        OpsTables.OPS_AUTO_TASK_LOG.NODE_ID,
                        OpsTables.OPS_AUTO_TASK_LOG.RECORD_TIME,
                        OpsTables.OPS_AUTO_TASK_LOG.STIME,
                        OpsTables.OPS_AUTO_TASK_LOG.ETIME,
                        OpsTables.OPS_AUTO_TASK_LOG.RECORD_CONTENT,
                        OpsTables.OPS_AUTO_TASK_LOG.CONTENT_DETAIL,
                        OpsTables.OPS_AUTO_TASK_LOG.NOTES,
                }
        );

        cfg.view().list().addJsVariable("M_LOG_ID","[[${mLogId}]]","mLogId");
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
        AutoTaskLogGtr g=new AutoTaskLogGtr();
        //生成代码
        g.generateCode();
   //     g.generateMenu(AutoTaskLogServiceProxy.class, AutoTaskLogPageController.class);
    }
}
