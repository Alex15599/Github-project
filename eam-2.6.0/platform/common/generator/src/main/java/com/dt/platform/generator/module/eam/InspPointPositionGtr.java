package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class InspPointPositionGtr extends BaseCodeGenerator{
    public InspPointPositionGtr() {
        super(EAMTables.EAM_INSPECTION_POINT_POS.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.CODE).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_POINT_POS.NAME,
                        EAMTables.EAM_INSPECTION_POINT_POS.CODE,
                        EAMTables.EAM_INSPECTION_POINT_POS.NOTES,
                }
        );



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.HIERARCHY_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.HIERARCHY).form().textInput();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.HIERARCHY_NAME).form().textInput();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_POS.NOTES).form().textArea().height(Config.textAreaHeight);


        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT_POS.NAME,
                        EAMTables.EAM_INSPECTION_POINT_POS.HIERARCHY_NAME,
                        EAMTables.EAM_INSPECTION_POINT_POS.CODE,
                        EAMTables.EAM_INSPECTION_POINT_POS.NOTES,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        InspPointPositionGtr g=new InspPointPositionGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
        //g.generateMenu(InspectionPointPosServiceProxy.class, InspectionPointPosPageController.class);
    }
}
