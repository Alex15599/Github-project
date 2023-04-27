package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.MonitorWarnLevelEnum;
import com.dt.platform.constants.enums.ops.MonitorWarnProcessStatusEnum;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorObjectGroupPageController;
import com.dt.platform.ops.page.MonitorTplTypePageController;
import com.dt.platform.proxy.ops.MonitorObjectGroupServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorObjectGroupGtr extends BaseCodeGenerator{


    public MonitorObjectGroupGtr() {
        super(OpsTables.OPS_MONITOR_OBJECT_GROUP.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_OBJECT_GROUP.CODE,
                        OpsTables.OPS_MONITOR_OBJECT_GROUP.NAME,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.CREATE_TIME).table().disable(true);


        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.CODE).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.CODE).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_GROUP.NOTES).form().textArea().height(Config.textAreaHeight);
        // cfg.view().list().disableBatchDelete();


       // cfg.view().list().disableBatchDelete();
        cfg.view().form().labelWidth(70);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_OBJECT_GROUP.NAME,
                        OpsTables.OPS_MONITOR_OBJECT_GROUP.CODE,
                        OpsTables.OPS_MONITOR_OBJECT_GROUP.NOTES,
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
        MonitorObjectGroupGtr g=new MonitorObjectGroupGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
 //       g.generateMenu(MonitorObjectGroupServiceProxy.class, MonitorObjectGroupPageController.class);
    }
}
