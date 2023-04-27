package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class EamManufacturerGtr extends BaseCodeGenerator{

    public EamManufacturerGtr() {
        super(EAMTables.EAM_MANUFACTURER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_MANUFACTURER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_MANUFACTURER.MANUFACTURER_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MANUFACTURER.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MANUFACTURER.MANUFACTURER_NOTES).search().fuzzySearch();

        //eam_asset_change_data

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_MANUFACTURER.CODE,
                        EAMTables.EAM_MANUFACTURER.MANUFACTURER_NAME,
                        EAMTables.EAM_MANUFACTURER.MANUFACTURER_NOTES,

                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_MANUFACTURER.MANUFACTURER_NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_MANUFACTURER.MANUFACTURER_NOTES).form().textArea().height(Config.textAreaHeight);


        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MANUFACTURER.MANUFACTURER_NAME,
                        EAMTables.EAM_MANUFACTURER.CODE,
                        EAMTables.EAM_MANUFACTURER.LOCATION,
                        EAMTables.EAM_MANUFACTURER.MANUFACTURER_NOTES,
                }

        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //表单HTML页
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamManufacturerGtr g=new EamManufacturerGtr();

        g.generateCode();

        //生成菜单
//        g.generateMenu(ManufacturerServiceProxy.class, ManufacturerPageController.class);
    }
}
