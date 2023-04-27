package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetDepreciationMethodEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.domain.workorder.meta.NetworkStrategyApplyMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class AssetDepreciationHistoryGtr extends BaseCodeGenerator {


    public AssetDepreciationHistoryGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.$TABLE,"475955437510852608");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetName","名称","名称");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetModel","类型","类型");

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.ASSET_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.DEPRECIATION_METHOD).form().validate().required().
                form().selectBox().enumType(AssetDepreciationMethodEnum.class);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.DEPRECIATION_METHOD,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.ASSET_CODE
                }
        );

        cfg.view().field(NetworkStrategyApplyMeta.ORIGINATOR_USER_NAME).table().label("申请人").form().label("申请人")
                .form().fillBy("originator","name");
        cfg.view().field(NetworkStrategyApplyMeta.ORIGINATOR_ID).table().fillBy("originator","name");

        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.ASSET_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.CREATE_TIME).table().disable(true);
        cfg.view().field(AssetDepreciationHistoryMeta.ASSET_NAME)
                .basic().label("资产名称")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.MODEL).fillWith(AssetDepreciationHistoryMeta.ASSET).muliti(false);

        cfg.view().field(AssetDepreciationHistoryMeta.ASSET_MODEL)
                .basic().label("资产型号")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.MODEL).fillWith(AssetDepreciationHistoryMeta.ASSET).muliti(false);



        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableModify();
        cfg.view().list().disableCreateNew();


         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.DEPRECIATION_METHOD,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.DEPRECIATION_PRICE,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.BEFORE_PRICE,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.AFTER_PRICE,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.ORIGINAL_UNIT_PRICE,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.RECORD_TIME,
                        EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.NOTES,
                }
        );



        cfg.view().list().addJsVariable("ASSET_ID","[[${assetId}]]","ASSET_ID");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AssetDepreciationHistoryGtr g=new AssetDepreciationHistoryGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
    //  g.generateMenu(AssetDepreciationHistoryServiceProxy.class, AssetDepreciationHistoryPageController.class);
        //生成菜单

    }

}
