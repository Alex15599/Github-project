package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.CCustInspectAssetAddEnum;
import com.dt.platform.constants.enums.eam.CCustInspectTaskStatusEnum;
import com.dt.platform.constants.enums.eam.CCustInspectTaskTypeEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.CCustInspectItem;
import com.dt.platform.domain.eam.CCustInspectTpl;
import com.dt.platform.domain.eam.meta.CCustInspectPlanMeta;
import com.dt.platform.domain.eam.meta.CCustInspectTaskMeta;
import com.dt.platform.domain.eam.meta.CCustInspectTplMeta;
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import com.dt.platform.eam.page.CCustInspectPlanPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.CCustInspectPlanServiceProxy;
import com.dt.platform.proxy.eam.CCustInspectTplServiceProxy;
import com.foxnicweb.web.constants.enums.contract.StatusEnum;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CInspectPlanGtr extends BaseCodeGenerator{
    public CInspectPlanGtr() {
        super(EAMTables.EAM_C_CUST_INSPECT_PLAN.$TABLE,"694836581814501376");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.LAST_TIME).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.NEXT_TIME).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.LAST_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.NEXT_TIME).table().disable(true);


        cfg.getPoClassFile().addSimpleProperty(CCustInspectTpl.class,"custInspectTpl","custInspectTpl","custInspectTpl");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"leader","leader","leader");
        cfg.getPoClassFile().addListProperty(Employee.class,"memberList","巡检人","巡检人");
        cfg.getPoClassFile().addListProperty(String.class,"memberIds","巡检人","巡检人");
        cfg.getPoClassFile().addListProperty(CCustInspectItem.class,"custInspectItemList","custInspectItemList","custInspectItemList");
        cfg.getPoClassFile().addListProperty(String.class,"custInspectItemIds","custInspectItemIds","custInspectItemIds");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetInTplList","assetInTplList","assetInTplList");


        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.INSPECT_USER_ID).table().fillBy("leader","name");
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.INSPECT_USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(CCustInspectPlanMeta.MEMBER_IDS).basic().label("成员").form()
                .button().chooseEmployee(false);
        cfg.view().field(CCustInspectPlanMeta.MEMBER_IDS).table().disable(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.STATUS,
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.INSPECT_USER_ID,
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.NAME,
                }

        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.STATUS).form().validate().required().form().radioBox().enumType(StatusEnum.class);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.ACTION_ADD).form().validate().required().form().radioBox().enumType(CCustInspectAssetAddEnum.class).defaultIndex(1);


        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.NOTES).form().textArea().height(120);

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.NOTES).table().disable();

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.TPL_ID)
                .form().selectBox().queryApi(CCustInspectTplServiceProxy.QUERY_PAGED_LIST+"?status=valid")
                .valueField(CCustInspectTplMeta.ID).textField(CCustInspectTplMeta.NAME)
                .toolbar(false).paging(true).filter(false)
                .fillWith(CCustInspectPlanMeta.CUST_INSPECT_TPL).muliti(false);


        cfg.view().formWindow().width("60%");;
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_PLAN.NAME).form().validate().required();


        cfg.view().list().operationColumn().addActionButton("执行","actionExecute","actionExecute","eam_cust_inspect_plan_exec");


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.NAME,
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.STATUS,
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.INSPECT_USER_ID,
                },
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.TPL_ID,
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.ACTION_ADD,
                        CCustInspectPlanMeta.MEMBER_IDS
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.CRONTAB,
                        EAMTables.EAM_C_CUST_INSPECT_PLAN.NOTES,

                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CInspectPlanGtr g=new CInspectPlanGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(CCustInspectPlanServiceProxy.class, CCustInspectPlanPageController.class);
    }
}
