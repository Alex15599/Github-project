package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetCodeSeqNumberTypeEnum;
import com.dt.platform.constants.enums.eam.CCustRepairStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.CCustRepairApply;
import com.dt.platform.domain.eam.CCustRepiarItem;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.CCustRepairApplyMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.eam.page.CCustRepairApplyPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.CCustRepairApplyServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CRepiarGtr extends BaseCodeGenerator{
    public CRepiarGtr() {
        super(EAMTables.EAM_C_CUST_REPAIR_APPLY.$TABLE,"694492212972486656");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(CCustRepiarItem.class,"repiarItemData","repiarItemData","repiarItemData");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"processUser","处理人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"reportUser","发起人","发起人");
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产列表","资产列表");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.CREATE_TIME).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PICTURE_ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PROCESS_USER_ID).basic().hidden(true);
      //  cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_ID).basic().hidden(true);


        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PROCESS_USER_ID).table().fillBy("processUser","name");
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PROCESS_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_ID).table().fillBy("reportUser","name");
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_ID).form()
                .button().chooseEmployee(true);



        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PICTURE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PROCESS_USER_ID).table().disable();
   //     cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_ID).table().disable();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.STATUS,
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.BUSINESS_CODE,
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.NAME,
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.CONTACT,
                },
                new Object[]{
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.START_DATE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.CONTACT).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.START_DATE).search().range();

        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.STATUS).form().radioBox().enumType(CCustRepairStatusEnum.class);

        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.START_DATE).form().dateInput();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.FINISH_DATE).form().dateInput();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PLAN_FINISH_DATE).form().dateInput();


        cfg.view().field(CCustRepairApplyMeta.ASSET_IDS)
                .basic().label("资产")
                .table().sort(false)
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST+"?ownerCode=asset")
                .valueField(AssetMeta.ID).textField(AssetMeta.NAME)
                .toolbar(false).paging(true).filter(false)
                .fillWith(CCustRepairApplyMeta.ASSET_LIST).muliti(true);


        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.PICTURE_ID)
                .form().label("图片").upload().buttonLabel("图片").acceptSingleImage();

        cfg.view().formWindow().width("60%");;


        cfg.view().formWindow().bottomSpace(300);

        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.CONTACT).form().validate().required();
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.CONTENT).form().textArea().height(135);

      //  cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.CONTACT).form().validate().required();
      //  cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_NAME).form().validate().required();

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.NAME,
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_NAME,
                },
                new Object[] {
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.PLAN_FINISH_DATE,
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.CONTACT,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.POS,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_ID,

                },
                new Object[] {
                        CCustRepairApplyMeta.ASSET_IDS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.CONTENT,
                        EAMTables.EAM_C_CUST_REPAIR_APPLY.RESULT,
                }
        );


        cfg.view().list().disableFormView();


        cfg.view().list().operationColumn().addActionButton("查看","viewFull","viewFull");
        cfg.view().list().operationColumn().addActionButton("接单","receiveAction","receiveAction","eam_cust_repiar_receive");

 //        cfg.view().form().addPage("资产列表","assetSelectList");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
                .setListPage(WriteMode.WRITE_TEMP_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CRepiarGtr g=new CRepiarGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(CodeRuleServiceProxy.class, CodeRulePageController.class);
    //    g.generateMenu(CCustRepairApplyServiceProxy.class, CCustRepairApplyPageController.class);
    }
}
