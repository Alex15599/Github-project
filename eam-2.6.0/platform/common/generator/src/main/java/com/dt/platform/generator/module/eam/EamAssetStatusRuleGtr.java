package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetEquipmentStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusRuleConditionEnum;
import com.dt.platform.constants.enums.eam.AssetStatusTypeEnum;
import com.dt.platform.eam.page.AssetStatusRulePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStatusRuleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetStatusRuleGtr extends BaseCodeGenerator{
    public EamAssetStatusRuleGtr() {
        super(EAMTables.EAM_ASSET_STATUS_RULE.$TABLE,"471986431431016449");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE.ID).basic().hidden(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STATUS_RULE.OPER_CODE,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE.OPER_CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE.OPER_CONDITION).form().validate().required().form()
             .radioBox().enumType(AssetStatusRuleConditionEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_ASSET_STATUS_RULE.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().list().operationColumn().addActionButton("条目","item","item-button","eam_asset_status_rule:item");
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STATUS_RULE.OPER_CODE,
                        EAMTables.EAM_ASSET_STATUS_RULE.STATUS,

                }, new Object[] {
                        EAMTables.EAM_ASSET_STATUS_RULE.OPER_CONDITION,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STATUS_RULE.NOTES,

                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetStatusRuleGtr g=new EamAssetStatusRuleGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetStatusRuleServiceProxy.class, AssetStatusRulePageController.class);
    }
}
