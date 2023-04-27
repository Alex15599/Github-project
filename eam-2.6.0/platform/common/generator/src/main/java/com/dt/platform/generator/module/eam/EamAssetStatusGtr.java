package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusTypeEnum;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetStatusGtr extends BaseCodeGenerator{
    public EamAssetStatusGtr() {
        super(EAMTables.EAM_ASSET_STATUS.$TABLE,"471986431431016449");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_ASSET_STATUS.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_STATUS.NAME).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STATUS.TYPE,
                        EAMTables.EAM_ASSET_STATUS.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_ASSET_STATUS.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STATUS.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STATUS.NOTES).form().textArea().height(Config.textAreaHeight);



        cfg.view().field(EAMTables.EAM_ASSET_STATUS.TYPE).form()
                .validate().required().form().radioBox().enumType(AssetStatusTypeEnum.class).defaultIndex(1);


        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);


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
        EamAssetStatusGtr g=new EamAssetStatusGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetStatusServiceProxy.class, AssetStatusPageController.class);
    }
}
