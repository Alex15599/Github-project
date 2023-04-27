package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationCodeEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationMethodEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationResidualValueSelectEnum;
import com.dt.platform.constants.enums.eam.AssetFirstDepreciationMethodTypeEnum;
import com.dt.platform.domain.eam.AssetDepreciationCalRule;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.dt.platform.generator.config.Config;

import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;

public class AssetDepreciationGtr extends BaseCodeGenerator {


    public AssetDepreciationGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION.$TABLE,BASIC_CY_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(Catalog.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addListProperty(String.class,"categoryIds","资产分类Ids","资产分类Ids");

        cfg.getPoClassFile().addListProperty(AssetDepreciationCalRule.class,"calRuleList","calRuleList","calRuleList");
        cfg.getPoClassFile().addListProperty(String.class,"calRuleIds","calRuleIds","calRuleIds");
//        cfg.getPoClassFile().addListProperty(.class,"categoryIds","资产分类Ids","资产分类Ids");


       // cfg.getPoClassFile().addListProperty(String.class,"categoryEntityIds","分类","分类");

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NAME).form().validate().required();


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.STATUS).form().validate().required().
                form().selectBox().enumType(StatusEnableEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.METHOD).form().validate().required().
                form().selectBox().enumType(AssetDepreciationMethodEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.RESIDUAL_VALUE_SELECT).form().validate().required().
                form().selectBox().enumType(AssetDepreciationResidualValueSelectEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.FIRST_DEPRECIATION_METHOD).form().validate().required().
                form().selectBox().enumType(AssetFirstDepreciationMethodTypeEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.SELECTED_CODE).table().disable(true);

        cfg.view().field(AssetDepreciationMeta.CATEGORY_IDS)
                .basic().label("资产分类")
                .table().sort(false)
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_NODES)
                .paging(false).filter(false).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME)
                .fillWith(AssetDepreciationMeta.CATEGORY).muliti(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DEPRECIATION.STATUS,
                        EAMTables.EAM_ASSET_DEPRECIATION.METHOD,
                        EAMTables.EAM_ASSET_DEPRECIATION.NAME,
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.CATEGORY_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.OWN_COMPANY_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.CREATE_TIME).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.CODE).form().validate().required().form().selectBox().enumType(AssetDepreciationCodeEnum.class);


        cfg.view().form().addJsVariable("ASSET_CATEGORY_DATA","[[${assetCategoryData}]]","ASSET_CATEGORY_DATA");
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.PRE_RESIDUAL_RATE).form().validate().required().
                form().numberInput().defaultValue(0);
        cfg.view().list().disableBatchDelete();
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION.CODE,
                        EAMTables.EAM_ASSET_DEPRECIATION.NAME,
                        EAMTables.EAM_ASSET_DEPRECIATION.STATUS,
                        EAMTables.EAM_ASSET_DEPRECIATION.PRE_RESIDUAL_RATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION.RESIDUAL_VALUE_SELECT,
                        EAMTables.EAM_ASSET_DEPRECIATION.METHOD,
                        EAMTables.EAM_ASSET_DEPRECIATION.FIRST_DEPRECIATION_METHOD,
                },
                new Object[] {
                     AssetDepreciationMeta.CATEGORY_IDS
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION.NOTES,
                }

        );

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AssetDepreciationGtr g=new AssetDepreciationGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
    //  g.generateMenu(AssetDepreciationServiceProxy.class, AssetDepreciationPageController.class);
        //生成菜单

    }

}
