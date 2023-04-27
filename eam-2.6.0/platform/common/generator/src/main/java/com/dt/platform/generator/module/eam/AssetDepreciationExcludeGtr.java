package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.meta.AssetDepreciationExcludeMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetDepreciationServiceProxy;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AssetDepreciationExcludeGtr extends BaseCodeGenerator{
    public AssetDepreciationExcludeGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.$TABLE,BASIC_CY_MENU_ID);
    }


    public void generateCode() throws Exception {


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.ID)
                .basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(AssetDepreciation.class,"assetDepreciation","方案","方案");
        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetCode","assetCode","assetCode");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetName","assetName","assetName");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetModel","assetModel","assetModel");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.DEPRECIATION_ID,
                        EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.NOTES,
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.DEPRECIATION_ID)
                .form().validate().required().form().selectBox().queryApi(AssetDepreciationServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssetDepreciationMeta.ID).
                textField(AssetDepreciationMeta.NAME).
                fillWith(AssetDepreciationExcludeMeta.ASSET_DEPRECIATION).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.ASSET_ID).table().disable(true);

        cfg.view().field(AssetDepreciationExcludeMeta.ASSET_NAME)
        .basic().label("资产名称")
        .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
        .valueField(AssetMeta.ID).textField( AssetMeta.NAME).fillWith(AssetDepreciationExcludeMeta.ASSET).muliti(false);

        cfg.view().field(AssetDepreciationExcludeMeta.ASSET_CODE)
                .basic().label("资产编码")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.NAME).fillWith(AssetDepreciationExcludeMeta.ASSET).muliti(false);

        cfg.view().field(AssetDepreciationExcludeMeta.ASSET_MODEL)
                .basic().label("资产型号")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.NAME).fillWith(AssetDepreciationExcludeMeta.ASSET).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.NOTES).search().fuzzySearch();

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().list().disableModify();
        cfg.view().list().disableCreateNew();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AssetDepreciationExcludeGtr g=new AssetDepreciationExcludeGtr();
        //生成代码
        g.generateCode();
        //生成菜单
      //  g.removeByBatchId("");
      //  g.generateMenu(AssetDepreciationExcludeServiceProxy.class, AssetDepreciationExcludePageController.class);


    }
}
