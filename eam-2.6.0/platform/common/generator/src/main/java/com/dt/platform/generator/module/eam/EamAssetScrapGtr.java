package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetScrap;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetScrapPageController;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamAssetScrapGtr extends BaseCodeGenerator {

    public EamAssetScrapGtr() {
        super(EAMTables.EAM_ASSET_SCRAP.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.bpm().form("eam_asset_scrap");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(DictItem.class,"methodDict","methodDict","methodDict");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(String.class,"originatorUserName","申请人","申请人");
//
//        cfg.bpm().form("eam_asset_scrap");
//        cfg.bpm().integrate(IntegrateMode.FRONT);

        //cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetScrapVOMeta.ASSET_IDS);
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addSimpleProperty(ChangeInstance.class,"changeInstance","变更实例","变更实例");

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SELECTED_CODE).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE).search().range();


        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.PROC_ID).table().disable();
       // cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.ATTACH).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.BUSINESS_DATE).table().hidden();
      //  cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CLEAN_STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CONTENT).form().textArea().height(Config.textAreaHeight);


        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).form().validate().required();


        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CHS_TYPE).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CHS_STATUS).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CHS_VERSION).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CHANGE_INSTANCE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SUMMARY).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.LATEST_APPROVER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.LATEST_APPROVER_NAME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NEXT_APPROVER_IDS).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NEXT_APPROVER_NAMES).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.APPROVAL_OPINION).table().disable();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SCRAP.STATUS,
                        EAMTables.EAM_ASSET_SCRAP.METHOD,
                        EAMTables.EAM_ASSET_SCRAP.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_SCRAP.NAME,

                },
                new Object[]{
                        EAMTables.EAM_ASSET_SCRAP.CONTENT,
                        EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CLEAN_STATUS).table().disable();
      //  cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).table().disable();

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.ATTACH).form().upload().acceptSingleFile().displayFileName(false);

        cfg.view().field(AssetScrapMeta.ORIGINATOR_USER_NAME).table().disable(true);
        cfg.view().field(AssetScrapMeta.ORIGINATOR_USER_NAME).table().label("申请人").form().label("申请人")
                .form().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
//        cfg.view().list().operationColumn().addActionButton("送审","forApproval",null);
//        cfg.view().list().operationColumn().addActionButton("确认","confirmData",null);
//        cfg.view().list().operationColumn().addActionButton("撤销","revokeData",null);
//        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);


        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.METHOD).basic().label("报废方式")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_scrap_method")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetScrapMeta.METHOD_DICT).muliti(false).defaultIndex(0);

     //   cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_scrap:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_scrap:confirm");
//        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_scrap:revoke");

        cfg.view().list().operationColumn().addActionButton("清理","cleanOut","clean-out-button","eam_asset_scrap:clean-out");

        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_scrap:bill");

        cfg.view().form().labelWidth(70);
        cfg.view().list().operationColumn().width(350);
        //分成分组布局
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SCRAP.NAME,
                        EAMTables.EAM_ASSET_SCRAP.METHOD
                },
                new Object[] {
                        AssetScrapMeta.ORIGINATOR_USER_NAME,
                }
        );

        cfg.view().form().addGroup(null,
              new Object[]
                      {
                        EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SCRAP.CONTENT,
                        EAMTables.EAM_ASSET_SCRAP.ATTACH,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("PAGE_TYPE","[[${pageType}]]","PAGE_TYPE");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");

//        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
//        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");
//
        cfg.view().search().rowsDisplay(1);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetScrapGtr g=new EamAssetScrapGtr();
        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AssetScrapServiceProxy.class, AssetScrapPageController.class);
    }

}
