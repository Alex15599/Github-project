package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorObjectMapGtr extends BaseCodeGenerator{


    public MonitorObjectMapGtr() {
        super(OpsTables.OPS_MONITOR_OBJECT_MAP.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_OBJECT_MAP.OBJECT_TYPE_ID,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MAP.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MAP.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_OBJECT_MAP.CREATE_TIME).table().disable(true);


       // cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_OBJECT_MAP.OBJECT_TYPE_ID
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
        MonitorObjectMapGtr g=new MonitorObjectMapGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
    //    g.generateMenu(MonitorObjectTypeMapServiceProxy.class, MonitorObjectTypeMapPageController.class);
    }
}
