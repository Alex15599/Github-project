package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.DataCenterTables;
import com.dt.platform.constants.db.EAMTables;


import com.dt.platform.constants.enums.datacenter.AreaTypeEnum;
import com.dt.platform.datacenter.page.AreaPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.enums.DictEnum;


public class DcAreaGtr extends BaseCodeGenerator {
//
//    public DcAreaGtr() {
//        super(DataCenterTables.DC_AREA.$TABLE,BASIC_DATA_MENU_ID);
//    }

    public DcAreaGtr() {
        super(AreaServiceProxy.class, AreaPageController.class,DataCenterTables.DC_AREA.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(DataCenterTables.DC_AREA.ID).basic().hidden(true);

        cfg.view().field(DataCenterTables.DC_AREA.NAME).search().fuzzySearch();
        cfg.view().field(DataCenterTables.DC_AREA.POSITION).search().fuzzySearch();
        cfg.view().field(DataCenterTables.DC_AREA.NOTES).search().fuzzySearch();


        cfg.view().field(DataCenterTables.DC_AREA.TYPE).basic().label("类型")
              .form().validate().required().form().radioBox().enumType(AreaTypeEnum.class).defaultIndex(0);

        cfg.view().field(DataCenterTables.DC_AREA.NAME).form().validate().required();

        cfg.view().field(DataCenterTables.DC_AREA.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(DataCenterTables.DC_AREA.POSITION).form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(80);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DcAreaGtr g=new DcAreaGtr();
       // g.reGenerateMenu();
        //生成代码
        g.generateCode();
        //生成菜单
     //  g.generateMenu(AreaServiceProxy.class, AreaPageController.class);
     //  g.reGenerateMenu(AreaServiceProxy.class,AreaPageController.class);
    }
}
