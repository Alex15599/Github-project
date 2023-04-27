package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AsseLabelTableCellTypeEnum;
import com.dt.platform.domain.eam.AssetLabelLayout;
import com.dt.platform.eam.page.AssetLabelLayoutPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetLabelLayoutServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class LabelLayutGtr extends BaseCodeGenerator{
    public LabelLayutGtr() {
        super(EAMTables.EAM_ASSET_LABEL_LAYOUT.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.view().field(EAMTables.EAM_ASSET_LABEL_LAYOUT.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_LABEL_LAYOUT.TYPE
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_ASSET_LABEL_LAYOUT.TYPE).form().validate().required().form().selectBox().enumType(AsseLabelTableCellTypeEnum.class);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        LabelLayutGtr g=new LabelLayutGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetLabelLayoutServiceProxy.class, AssetLabelLayoutPageController.class);
    }
}
