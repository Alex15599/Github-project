package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.ops.AutoNode;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoBatchPageController;
import com.dt.platform.proxy.ops.AutoBatchServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AutoBatchGtr extends BaseCodeGenerator{


    public AutoBatchGtr() {
        super(OpsTables.OPS_AUTO_BATCH.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(AutoNode.class,"nodeList","nodeList","nodeList");
        cfg.getPoClassFile().addListProperty(String.class,"nodeIds","nodeIds","nodeIds");


        cfg.view().field(OpsTables.OPS_AUTO_BATCH.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_BATCH.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_BATCH.STATUS,
                        OpsTables.OPS_AUTO_BATCH.NAME,
                        OpsTables.OPS_AUTO_BATCH.NOTES,
                }
        );
        cfg.view().field(OpsTables.OPS_AUTO_BATCH.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_AUTO_BATCH.STATUS).table().form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_AUTO_BATCH.NAME).table().form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_BATCH.SELECTED_CODE).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_BATCH.NOTES).table().form().textArea().height(Config.textAreaHeight);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_BATCH.NAME,
                        OpsTables.OPS_AUTO_BATCH.STATUS,
                        OpsTables.OPS_AUTO_BATCH.NOTES,
                }
        );

        cfg.view().field(OpsTables.OPS_AUTO_BATCH.NOTES).table().form().textArea().height(Config.textAreaHeight);

        cfg.view().form().addPage("节点","nodeListSelect");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AutoBatchGtr g=new AutoBatchGtr();
        //生成代码
        g.generateCode();
      //  g.generateMenu(AutoBatchServiceProxy.class, AutoBatchPageController.class);
    }
}
