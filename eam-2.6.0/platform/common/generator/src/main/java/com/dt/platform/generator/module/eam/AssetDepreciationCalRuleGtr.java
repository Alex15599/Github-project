package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationCalculationMethodTypeEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationCalculationReturnTypeEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationRuleActionCodeEnum;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetDepreciationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AssetDepreciationCalRuleGtr extends BaseCodeGenerator{
    public AssetDepreciationCalRuleGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.$TABLE,BASIC_CY_MENU_ID);
    }


    public void generateCode() throws Exception {


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.ID)
                .basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(AssetDepreciation.class,"assetDepreciation","方案","方案");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.STATUS,
                        EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.DEPRECIATION_ID,
                        EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.ACTION_CODE,
                        EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.COLUMN_NAME,
                }
        );


        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().list().disableBatchDelete();


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.DEPRECIATION_ID)
                .form().selectBox().queryApi(AssetDepreciationServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AssetDepreciationMeta.ID).
                textField(AssetDepreciationMeta.NAME).
                fillWith(AssetDepreciationCalRuleMeta.ASSET_DEPRECIATION).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.CALCULATION_TYPE).
                form().validate().required().form().radioBox().enumType(AssetDepreciationCalculationMethodTypeEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.RETURN_TYPE).
                form().validate().required().form().radioBox().enumType(AssetDepreciationCalculationReturnTypeEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.ACTION_CODE).
                form().validate().required().form().radioBox().enumType(AssetDepreciationRuleActionCodeEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.COLUMN_NAME).
                form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.COLUMN_VALUE).
                form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.STATUS).
                form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.RULE_NUMBER).
                form().validate().required();


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
        AssetDepreciationCalRuleGtr g=new AssetDepreciationCalRuleGtr();
        //生成代码
        g.generateCode();
        //生成菜单
      //  g.removeByBatchId("");
    //    g.generateMenu(AssetDepreciationCalRuleServiceProxy.class, AssetDepreciationCalRulePageController.class);


    }
}
