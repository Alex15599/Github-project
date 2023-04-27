package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetBorrowReturnPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.proxy.eam.AssetBorrowReturnServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EamAssetBorrowReturnGtr extends BaseCodeGenerator {

    public EamAssetBorrowReturnGtr() {
        super(EAMTables.EAM_ASSET_BORROW_RETURN.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(AssetItem.class,"assetItemList","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(String.class,"originatorUserName","归还人","归还人");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人","管理人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","使用人","使用人");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","归还后公司","归还后公司");


      //  cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetBorrowReturnVOMeta.ASSET_IDS);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.SELECTED_CODE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.USE_ORGANIZATION_ID).form()
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.USE_ORGANIZATION_ID).table().fillBy("useOrganization","fullName");

        cfg.view().field(AssetBorrowReturnMeta.ORIGINATOR_USER_NAME).table().disable(true);
        cfg.view().field(AssetBorrowReturnMeta.ORIGINATOR_USER_NAME).table().label("申请人").form().label("申请人")
                .form().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.ORIGINATOR_ID).table().fillBy("originator","name");


        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.MANAGER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.USE_USER_ID).table().fillBy("useUser","name");
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.USE_USER_ID).form()
                .button().chooseEmployee(true);



        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleFile().displayFileName(false);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW_RETURN.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_BORROW_RETURN.CONTENT,
                        EAMTables.EAM_ASSET_BORROW_RETURN.RETURN_DATE,
                }

        );



        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").defaultNow().search().range();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.RETURN_DATE).form().dateInput().format("yyyy-MM-dd").defaultNow().search().range();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.BUSINESS_CODE).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.ATTACH).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.CONTENT).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.CONTENT).form().textArea().height(Config.textAreaHeight).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.RETURN_DATE).form().validate().required().search().range();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW_RETURN.POSITION_ID)
                .basic().label("存放位置")
                 .form().selectBox().defaultIndex(0).queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField(PositionMeta.HIERARCHY_NAME).fillWith(AssetCollectionMeta.POSITION).muliti(false);



        //分成分组布局

        cfg.view().form().labelWidth(70);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW_RETURN.NAME,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW_RETURN.RETURN_DATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW_RETURN.USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_BORROW_RETURN.POSITION_ID,
                        EAMTables.EAM_ASSET_BORROW_RETURN.POSITION_DETAIL,

                },
                new Object[] {
                        AssetBorrowReturnMeta.ORIGINATOR_USER_NAME,
                        EAMTables.EAM_ASSET_BORROW_RETURN.MANAGER_ID,
                        EAMTables.EAM_ASSET_BORROW_RETURN.USE_USER_ID
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW_RETURN.CONTENT,
                        EAMTables.EAM_ASSET_BORROW_RETURN.ATTACH,
                }
        );

        cfg.view().search().rowsDisplay(1);
        cfg.view().list().addJs("/extmodule/commonFunction/commonFunction.js");
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_borrow_return:confirm");

        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_borrow_return:bill2");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetBorrowReturnGtr g=new EamAssetBorrowReturnGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AssetBorrowReturnServiceProxy.class, AssetBorrowReturnPageController.class);
    }

}
