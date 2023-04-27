package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetStatus;
import com.dt.platform.domain.eam.AssetStatusRule;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.AssetStatusMeta;
import com.dt.platform.domain.eam.meta.AssetStatusRuleMeta;
import com.dt.platform.domain.eam.meta.AssetStatusRuleVMeta;
import com.dt.platform.eam.page.AssetStatusRulePageController;
import com.dt.platform.eam.page.AssetStatusRuleVPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStatusRuleServiceProxy;
import com.dt.platform.proxy.eam.AssetStatusRuleVServiceProxy;
import com.dt.platform.proxy.eam.AssetStatusServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetStatusRuleVGtr extends BaseCodeGenerator{
    public EamAssetStatusRuleVGtr() {
        super(EAMTables.EAM_ASSET_STATUS_RULE_V.$TABLE,"471986431431016449");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE_V.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(AssetStatus.class,"assetCycleStatus","assetCycleStatus","assetCycleStatus");


        cfg.getPoClassFile().addSimpleProperty(AssetStatusRule.class,"assetStatusRule","assetStatusRule","assetStatusRule");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STATUS_RULE_V.OPER_CODE,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE_V.OPER_CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE_V.STATUS_CODE).form().validate().required();

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(200);

        cfg.view().list().addJsVariable("OPER_CODE","[[${operCode}]]","OPER_CODE");


        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE_V.OPER_CODE).form().validate().required()
                .form().selectBox().queryApi(AssetStatusRuleServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(AssetStatusRuleMeta.OPER_CODE).
                textField(AssetStatusRuleMeta.OPER_CODE).
                fillWith(AssetStatusRuleVMeta.ASSET_STATUS_RULE).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE_V.STATUS_CODE).form().validate().required()
                .form().selectBox().queryApi(AssetStatusServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(AssetStatusMeta.CODE).
                textField(AssetStatusMeta.NAME).
                fillWith(AssetStatusRuleVMeta.ASSET_CYCLE_STATUS).muliti(false).defaultIndex(0);

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.EAM_ASSET_STATUS_RULE_V.OPER_CODE,
                        EAMTables.EAM_ASSET_STATUS_RULE_V.STATUS_CODE
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetStatusRuleVGtr g=new EamAssetStatusRuleVGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetStatusServiceProxy.class, AssetStatusPageController.class);
      //  g.generateMenu(AssetStatusRuleVServiceProxy.class, AssetStatusRuleVPageController.class);
    }
}
