package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.eam.page.PositionPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamPositionGtr extends BaseCodeGenerator{
    public EamPositionGtr() {
        super(EAMTables.EAM_POSITION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_POSITION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_POSITION.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_POSITION.NOTES).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_POSITION.NAME,
                        EAMTables.EAM_POSITION.CODE,
                        EAMTables.EAM_POSITION.NOTES,
                }
        );



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_POSITION.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_POSITION.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_POSITION.HIERARCHY_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_POSITION.HIERARCHY).form().textInput();
        cfg.view().field(EAMTables.EAM_POSITION.HIERARCHY_NAME).form().textInput();
        cfg.view().field(EAMTables.EAM_POSITION.NOTES).form().textArea().height(Config.textAreaHeight);


        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_POSITION.NAME,
                        EAMTables.EAM_POSITION.HIERARCHY_NAME,
                        EAMTables.EAM_POSITION.CODE,
                        EAMTables.EAM_POSITION.NOTES,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamPositionGtr g=new EamPositionGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(PositionServiceProxy.class, PositionPageController.class);
    }
}
