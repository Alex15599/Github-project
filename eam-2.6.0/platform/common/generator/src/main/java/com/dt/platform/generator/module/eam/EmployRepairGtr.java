package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetEmployeeRepair;
import com.dt.platform.domain.eam.meta.AssetEmployeeRepairMeta;
import com.dt.platform.eam.page.AssetEmployeeRepairPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetEmployeeRepairServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EmployRepairGtr extends BaseCodeGenerator {


    public EmployRepairGtr() {
        super(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(String.class,"originatorUserName","申请人","申请人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","使用公司/部门","使用公司/部门");
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.STATUS,
                        EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.NAME,

                }
        );
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.RECORD_TIME).table().disable(true);
        cfg.view().field(AssetEmployeeRepairMeta.ORIGINATOR_USER_NAME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.PICTURE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.CONTENT).form().validate().required().form().textArea().height(Config.textAreaHeight);



        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.ORG_ID).table().fillBy("organization","fullName");



        cfg.view().field(AssetEmployeeRepairMeta.ORIGINATOR_USER_NAME).table().label("申请人").form().label("申请人").
                form().fillBy("originator","name");
        cfg.view().field(AssetEmployeeRepairMeta.ORIGINATOR_ID).table().fillBy("originator","name");

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.STATUS).basic().label("办理状态")
                .form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.PICTURE_ID).form().upload().acceptImageType().maxFileCount(3).buttonLabel("选择图片");

        cfg.bpm().form("eam_asset_employee_repair");
        cfg.bpm().integrate(IntegrateMode.FRONT);

        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.NAME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.ORG_ID,

                },
                new Object[] {
                        AssetEmployeeRepairMeta.ORIGINATOR_USER_NAME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.CONTENT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.PICTURE_ID,
                }
        );

        cfg.view().list().addJs("/extmodule/commonFunction/commonFunction.js");

        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
        cfg.view().form().addPage("资产列表","goodsSelectList");

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
        EmployRepairGtr g=new EmployRepairGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
    //   g.generateMenu(AssetEmployeeRepairServiceProxy.class, AssetEmployeeRepairPageController.class);

        //生成菜单

    }

}
