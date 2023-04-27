package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsAutoTaskResultStatusEnum;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoTask;
import com.dt.platform.domain.ops.AutoTaskLog;
import com.dt.platform.domain.ops.AutoTaskMLog;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoTaskMLogPageController;
import com.dt.platform.proxy.ops.AutoActionServiceProxy;
import com.dt.platform.proxy.ops.AutoGroupServiceProxy;
import com.dt.platform.proxy.ops.AutoTaskMLogServiceProxy;
import com.dt.platform.proxy.ops.AutoTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;

public class AutoTaskMLogGtr extends BaseCodeGenerator{


    public AutoTaskMLogGtr() {
        super(OpsTables.OPS_AUTO_TASK_M_LOG.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.getPoClassFile().addSimpleProperty(AutoTask.class,"task","task","task");
        cfg.getPoClassFile().addSimpleProperty(AutoAction.class,"action","action","action");
        cfg.getPoClassFile().addListProperty(AutoTaskLog.class,"logList","logList","logList");

        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.STIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.STIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_TASK_M_LOG.STATUS,
                        OpsTables.OPS_AUTO_TASK_M_LOG.TASK_ID,
                        OpsTables.OPS_AUTO_TASK_M_LOG.CONTENT,

                },
                new Object[]{

                        OpsTables.OPS_AUTO_TASK_M_LOG.STIME,
                }
        );


        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.TASK_ID)
                .form().selectBox().queryApi(AutoTaskServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AutoTaskMeta.ID).
                textField(AutoTaskMeta.NAME).
                fillWith(AutoTaskMLogMeta.TASK).muliti(false);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.ACTION_ID)
                .form().selectBox().queryApi(AutoActionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AutoActionMeta.ID).
                textField(AutoActionMeta.NAME).
                fillWith(AutoTaskMLogMeta.ACTION).muliti(false);


        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.STATUS).table().form().selectBox().enumType(OpsAutoTaskResultStatusEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.ID).basic().hidden(true);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.CONTENT).form().textArea().height(Config.textAreaHeight);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.STIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(OpsTables.OPS_AUTO_TASK_M_LOG.ETIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().list().operationColumn().addActionButton("日志","autoTaskMLog",null,"ops_auto_task_m_log:log");


        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableModify();
        cfg.view().list().disableBatchDelete();

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_TASK_M_LOG.TASK_ID,
                        OpsTables.OPS_AUTO_TASK_M_LOG.STATUS,
                        OpsTables.OPS_AUTO_TASK_M_LOG.STIME,
                        OpsTables.OPS_AUTO_TASK_M_LOG.ETIME,
                        OpsTables.OPS_AUTO_TASK_M_LOG.CONTENT,
                }
        );

        cfg.view().list().addJsVariable("TASK_ID","[[${taskId}]]","taskId");
        cfg.view().list().operationColumn().addActionButton("日志下载","logDownload",null,"ops_auto_task_m_log:log-download");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AutoTaskMLogGtr g=new AutoTaskMLogGtr();
        //生成代码
        g.generateCode();
       // g.generateMenu(AutoTaskMLogServiceProxy.class, AutoTaskMLogPageController.class);
    }
}
