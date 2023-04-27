package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoGroupPageController;
import com.dt.platform.proxy.ops.AutoGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AutoGroupGtr extends BaseCodeGenerator{


    public AutoGroupGtr() {
        super(OpsTables.OPS_AUTO_GROUP.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OpsTables.OPS_AUTO_GROUP.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_GROUP.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_GROUP.STATUS,
                        OpsTables.OPS_AUTO_GROUP.NAME,
                        OpsTables.OPS_AUTO_GROUP.NOTES,
                }
        );
        cfg.view().field(OpsTables.OPS_AUTO_GROUP.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_AUTO_GROUP.STATUS).table().form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_AUTO_GROUP.NAME).table().form().validate().required();

        cfg.view().field(OpsTables.OPS_AUTO_GROUP.NOTES).table().form().textArea().height(Config.textAreaHeight);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_GROUP.NAME,
                        OpsTables.OPS_AUTO_GROUP.STATUS,
                        OpsTables.OPS_AUTO_GROUP.NOTES,
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
        AutoGroupGtr g=new AutoGroupGtr();
        //生成代码
        g.generateCode();
      //  g.generateMenu(AutoGroupServiceProxy.class, AutoGroupPageController.class);
    }
}
