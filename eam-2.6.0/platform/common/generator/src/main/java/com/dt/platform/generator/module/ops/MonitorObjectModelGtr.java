package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.MaintainerMeta;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.MonitorObjectGrafanaMeta;
import com.dt.platform.domain.ops.meta.MonitorObjectGroupMeta;
import com.dt.platform.domain.ops.meta.MonitorObjectModelMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorObjectModelPageController;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.dt.platform.proxy.ops.MonitorObjectGrafanaServiceProxy;
import com.dt.platform.proxy.ops.MonitorObjectGroupServiceProxy;
import com.dt.platform.proxy.ops.MonitorObjectModelServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorObjectModelGtr extends BaseCodeGenerator{


    public MonitorObjectModelGtr() {
        super(OpsTables.OPS_MONITOR_OBJECT_MODEL.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(MonitorObjectGroup.class,"group","group","group");
        cfg.getPoClassFile().addSimpleProperty(MonitorObjectGrafana.class,"grafana","grafana","grafana");



        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_OBJECT_MODEL.GROUP_ID,
                        OpsTables.OPS_MONITOR_OBJECT_MODEL.CODE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.CREATE_TIME).table().disable(true);


        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(MonitorObjectGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorObjectGroupMeta.ID).
                textField(MonitorObjectGroupMeta.NAME).
                fillWith(MonitorObjectModelMeta.GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.GRAFANA_ID)
                .form().selectBox().queryApi(MonitorObjectGrafanaServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorObjectGrafanaMeta.ID).
                textField(MonitorObjectGrafanaMeta.NAME).
                fillWith(MonitorObjectModelMeta.GROUP).muliti(false).defaultIndex(0);


        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.CODE).form().validate().required();

        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MODEL.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().form().labelWidth(70);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_OBJECT_MODEL.NAME,
                        OpsTables.OPS_MONITOR_OBJECT_MODEL.CODE,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_OBJECT_MODEL.GROUP_ID,
                        OpsTables.OPS_MONITOR_OBJECT_MODEL.GRAFANA_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {

                        OpsTables.OPS_MONITOR_OBJECT_MODEL.NOTES
                }

        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MonitorObjectModelGtr g=new MonitorObjectModelGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //g.generateMenu(MonitorObjectModelServiceProxy.class, MonitorObjectModelPageController.class);
    }
}
