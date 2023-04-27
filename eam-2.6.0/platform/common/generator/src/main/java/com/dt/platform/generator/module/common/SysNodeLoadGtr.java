package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.NodeLoadPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.AutoModuleIDEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.NodeLoadServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysNodeLoadGtr extends BaseCodeGenerator {

    public SysNodeLoadGtr() {
        super(SysTables.SYS_NODE_LOAD.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_NODE_LOAD.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_NODE_LOAD.CREATE_TIME).search().range();

        cfg.view().field(SysTables.SYS_NODE_LOAD.NODE).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_NODE_LOAD.NODE,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_NODE_LOAD.NODE,
                        SysTables.SYS_NODE_LOAD.IP,
                        SysTables.SYS_NODE_LOAD.USER,
                        SysTables.SYS_NODE_LOAD.SYS,
                        SysTables.SYS_NODE_LOAD.IDLE,
                        SysTables.SYS_NODE_LOAD.WIO,
                        SysTables.SYS_NODE_LOAD.LOAD1,
                        SysTables.SYS_NODE_LOAD.LOAD5,
                        SysTables.SYS_NODE_LOAD.LOAD15,

                }
        );


      //  cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();


        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysNodeLoadGtr g=new SysNodeLoadGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(NodeLoadServiceProxy.class, NodeLoadPageController.class);
    }

}
