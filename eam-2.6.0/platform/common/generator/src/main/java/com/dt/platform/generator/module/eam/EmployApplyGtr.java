package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetEmployeeApplyMeta;
import com.dt.platform.domain.eam.meta.AssetEmployeeHandoverMeta;
import com.dt.platform.domain.eam.meta.AssetEmployeeRepairMeta;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EmployApplyGtr extends BaseCodeGenerator {


    public EmployApplyGtr() {
        super(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {




        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(String.class,"originatorUserName","申请人","申请人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","使用公司/部门","使用公司/部门");
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME).search().fuzzySearch();


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.STATUS,
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME,
                }
        );

        cfg.view().list().disableBatchDelete();
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().labelWidth(70);
        cfg.view().formWindow().bottomSpace(30);


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.RECORD_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.APPLY_COUNT).table().disable(true);
        cfg.view().field(AssetEmployeeApplyMeta.ORIGINATOR_USER_NAME).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.CONTENT).form().validate().required().form().textArea().height(Config.textAreaHeight);


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORG_ID).table().fillBy("organization","fullName");



        cfg.view().field(AssetEmployeeApplyMeta.ORIGINATOR_USER_NAME).table().label("申请人").form().label("申请人")
                .form().fillBy("originator","name");
        cfg.view().field(AssetEmployeeApplyMeta.ORIGINATOR_ID).table().fillBy("originator","name");
//        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORIGINATOR_ID).form().validate().required().form()
//                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.STATUS).basic().label("办理状态")
                .form().selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME,
                }
        );
        cfg.view().form().addGroup(null,

                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORG_ID,
                },
                new Object[] {
                        AssetEmployeeApplyMeta.ORIGINATOR_USER_NAME
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.CONTENT,
                }
        );


        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");

//        cfg.view().form().addPage("资产列表","goodsSelectList");
//        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().addJs("/extmodule/commonFunction/commonFunction.js");

        cfg.bpm().form("eam_asset_employee_apply");
        cfg.bpm().integrate(IntegrateMode.FRONT);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.WRITE_TEMP_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EmployApplyGtr g=new EmployApplyGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(AssetEmployeeApplyServiceProxy.class, AssetEmployeeApplyPageController.class);

        //生成菜单

    }

}
