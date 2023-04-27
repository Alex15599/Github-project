package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetAllocation;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetAllocationMeta;
import com.dt.platform.domain.eam.meta.AssetAllocationVOMeta;
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.dt.platform.domain.eam.meta.AssetEmployeeApplyMeta;
import com.dt.platform.eam.page.AssetAllocationPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.proxy.eam.AssetAllocationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetAllocationGtr extends BaseCodeGenerator {

    public EamAssetAllocationGtr() {
        super(EAMTables.EAM_ASSET_ALLOCATION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.bpm().form("eam_asset_stock_allocate");


        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人","管理人");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"outOwnerCompany","调出公司","调出公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"inOwnerCompany","调入公司","调入公司");
        cfg.getPoClassFile().addSimpleProperty(String.class,"originatorUserName","申请人","申请人");

        //cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetAllocationVOMeta.ASSET_IDS);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.SELECTED_CODE).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE).search().range();


        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ATTACH).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).form().textArea().height(Config.textAreaHeight).search().fuzzySearch();


     //   cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_allocation:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_allocation:confirm");
    //    cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_allocation:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_allocation:bill");

        cfg.view().list().operationColumn().width(350);

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID).table().fillBy("outOwnerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID).table().fillBy("inOwnerCompany","fullName");

        cfg.view().field(AssetAllocationMeta.ORIGINATOR_USER_NAME).table().disable(true);
        cfg.view().field(AssetAllocationMeta.ORIGINATOR_USER_NAME).table().label("申请人").form().label("申请人")
                .form().fillBy("originator","name");


        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ORIGINATOR_ID).table().fillBy("originator","name");


        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleFile().displayFileName(false);


        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.NAME).form().validate().required();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_ALLOCATION.STATUS,
                        EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID,

                },
                new Object[]{
                        EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE,
                        EAMTables.EAM_ASSET_ALLOCATION.CONTENT,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().search().rowsDisplay(1);

        //分成分组布局
        cfg.view().form().labelWidth(70);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.NAME
                },
                new Object[] {
                        AssetAllocationMeta.ORIGINATOR_USER_NAME
                }
        );
        cfg.view().form().addGroup(null,
                 new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID,
                         EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID,
                }, new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.CONTENT,
                        EAMTables.EAM_ASSET_ALLOCATION.ATTACH,
                }
        );
        cfg.view().list().addJs("/extmodule/commonFunction/commonFunction.js");
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
//        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
//        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetAllocationGtr g=new EamAssetAllocationGtr();

        //生成代码
        g.generateCode();
        //生成菜单
      //  g.generateMenu(AssetAllocationServiceProxy.class, AssetAllocationPageController.class);
    }

}
