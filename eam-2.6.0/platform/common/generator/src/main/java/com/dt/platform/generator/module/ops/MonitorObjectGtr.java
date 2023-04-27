package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.MonitorObjectGrafana;
import com.dt.platform.domain.ops.MonitorObjectGroup;
import com.dt.platform.domain.ops.MonitorObjectModel;
import com.dt.platform.domain.ops.meta.MonitorObjectGrafanaMeta;
import com.dt.platform.domain.ops.meta.MonitorObjectGroupMeta;
import com.dt.platform.domain.ops.meta.MonitorObjectMeta;
import com.dt.platform.domain.ops.meta.MonitorObjectModelMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorObjectPageController;

import com.dt.platform.proxy.ops.MonitorObjectGrafanaServiceProxy;
import com.dt.platform.proxy.ops.MonitorObjectGroupServiceProxy;
import com.dt.platform.proxy.ops.MonitorObjectServiceProxy;

import com.github.foxnic.generator.config.WriteMode;

public class MonitorObjectGtr extends BaseCodeGenerator{


    public MonitorObjectGtr() {
        super(OpsTables.OPS_MONITOR_OBJECT.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_OBJECT.NAME,
                }
        );

        cfg.getPoClassFile().addSimpleProperty(MonitorObjectGroup.class,"group","group","group");
        cfg.getPoClassFile().addSimpleProperty(MonitorObjectModel.class,"objectModel","objectModel","objectModel");


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.GROUP_CODE).table().hidden();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.OBJECT_MODEL_ID).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.IP).table().disable(true);


        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.GROUP_CODE).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.OBJECT_MODEL_ID).form().validate().required();

        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.GROUP_CODE).search().fuzzySearch();


        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.GROUP_CODE)
                .form().validate().required().form().selectBox().queryApi(MonitorObjectGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorObjectGroupMeta.CODE).
                textField(MonitorObjectGroupMeta.NAME).
                fillWith(MonitorObjectMeta.GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT.OBJECT_MODEL_ID)
                .form().selectBox().queryApi(MonitorObjectGrafanaServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorObjectGrafanaMeta.ID).
                textField(MonitorObjectGrafanaMeta.NAME).
                fillWith(MonitorObjectMeta.OBJECT_MODEL).muliti(false).defaultIndex(0);

        cfg.view().list().operationColumn().addActionButton("分析","analyze","analyze-button","ops_monitor_object:analyze");
        cfg.view().list().disableFormView();

        cfg.view().form().labelWidth(70);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_OBJECT.NAME,
                        OpsTables.OPS_MONITOR_OBJECT.GROUP_CODE,
                        OpsTables.OPS_MONITOR_OBJECT.OBJECT_MODEL_ID,
                }

        );

        cfg.view().list().addJsVariable("GROUP_CODE","[[${groupCode}]]","GROUP_CODE");


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
        MonitorObjectGtr g=new MonitorObjectGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
      //   g.generateMenu(MonitorObjectServiceProxy.class, MonitorObjectPageController.class);
    }
}
