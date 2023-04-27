package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class AutoTaskNodeGtr extends BaseCodeGenerator{


    public AutoTaskNodeGtr() {
        super(OpsTables.OPS_AUTO_TASK_NODE.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OpsTables.OPS_AUTO_TASK_NODE.NOTES).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_TASK_NODE.NOTES,
                }
        );
        cfg.view().field(OpsTables.OPS_AUTO_TASK_NODE.ID).basic().hidden(true);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_TASK_NODE.NOTES,
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
        AutoTaskNodeGtr g=new AutoTaskNodeGtr();
        //生成代码
        g.generateCode();
      //  g.generateMenu(AutoGroupServiceProxy.class, AutoGroupPageController.class);
    }
}
