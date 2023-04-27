package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.constants.enums.eam.AssetRackTreeTypeEnum;
import com.dt.platform.domain.eam.AssetRackInfo;
import com.dt.platform.domain.eam.meta.AssetRackInfoMeta;
import com.dt.platform.domain.eam.meta.AssetRackMeta;

import com.dt.platform.generator.config.Config;


import com.dt.platform.proxy.eam.AssetRackInfoServiceProxy;

import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;


public class EamAssetRackGtr extends BaseCodeGenerator{
    public EamAssetRackGtr() {
        super(EAMTables.EAM_ASSET_RACK.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_ASSET_RACK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_RACK.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_RACK.NOTES).search().fuzzySearch();


        cfg.getPoClassFile().addSimpleProperty(AssetRackInfo.class,"rackInfo","rackInfo","rackInfo");


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_RACK.NAME,
                        EAMTables.EAM_ASSET_RACK.CODE,
                        EAMTables.EAM_ASSET_RACK.NOTES,
                }
        );



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_ASSET_RACK.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_RACK.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_RACK.HIERARCHY_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_ASSET_RACK.HIERARCHY).form().textInput();
        cfg.view().field(EAMTables.EAM_ASSET_RACK.HIERARCHY_NAME).form().textInput();
        cfg.view().field(EAMTables.EAM_ASSET_RACK.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(EAMTables.EAM_ASSET_RACK.TYPE).form().validate().required().form().radioBox().enumType(AssetRackTreeTypeEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_ASSET_RACK.RACK_ID)
                .form().selectBox().queryApi(AssetRackInfoServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssetRackInfoMeta.ID).
                textField(AssetRackInfoMeta.RACK_NAME).
                fillWith(AssetRackMeta.RACK_INFO).muliti(false);

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_RACK.NAME,
                        EAMTables.EAM_ASSET_RACK.CODE,
                        EAMTables.EAM_ASSET_RACK.TYPE,
                        EAMTables.EAM_ASSET_RACK.RACK_ID,
                        EAMTables.EAM_ASSET_RACK.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetRackGtr g=new EamAssetRackGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(AssetRackServiceProxy.class, AssetRackPageController.class);
    }
}
