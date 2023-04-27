package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.CCustInspectAssetAddEnum;
import com.dt.platform.constants.enums.eam.CCustInspectTaskStatusEnum;
import com.dt.platform.constants.enums.eam.CCustInspectTaskTypeEnum;
import com.dt.platform.constants.enums.eam.CCustRepairStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.CCustInspectTaskPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.CCustInspectTaskServiceProxy;
import com.dt.platform.proxy.eam.CCustInspectTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CInspectTaskGtr extends BaseCodeGenerator{
    public CInspectTaskGtr() {
        super(EAMTables.EAM_C_CUST_INSPECT_TASK.$TABLE,"694836581814501376");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(CCustInspectTpl.class,"custInspectTpl","custInspectTpl","custInspectTpl");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"leader","leader","leader");

        cfg.getPoClassFile().addListProperty(Employee.class,"memberList","巡检人","巡检人");
        cfg.getPoClassFile().addListProperty(String.class,"memberIds","巡检人","巡检人");


        cfg.getPoClassFile().addListProperty(Asset.class,"assetInTplList","assetInTplList","assetInTplList");

        cfg.getPoClassFile().addListProperty(CCustInspectItem.class,"custInspectItemList","custInspectItemList","custInspectItemList");
        cfg.getPoClassFile().addListProperty(String.class,"custInspectItemIds","custInspectItemIds","custInspectItemIds");

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.INSPECT_USER_ID).table().fillBy("leader","name");
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.INSPECT_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_C_CUST_INSPECT_TASK.STATUS,
                        EAMTables.EAM_C_CUST_INSPECT_TASK.INSPECT_USER_ID,
                        EAMTables.EAM_C_CUST_INSPECT_TASK.NAME,
                },
                new Object[]{
                        EAMTables.EAM_C_CUST_INSPECT_TASK.START_TIME,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.START_TIME).search().range();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.STATUS).form().radioBox().enumType(CCustInspectTaskStatusEnum.class);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.ACTION_ADD).form().validate().required().form().radioBox().enumType(CCustInspectAssetAddEnum.class).defaultIndex(1);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.NOTES).form().textArea().height(120);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.NOTES).table().disable();

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.TPL_ID)
                .form().validate().required().form().selectBox().queryApi(CCustInspectTplServiceProxy.QUERY_PAGED_LIST+"?status=valid")
                .valueField(CCustInspectTplMeta.ID).textField(CCustInspectTplMeta.NAME)
                .toolbar(false).paging(true).filter(false)
                .fillWith(CCustInspectTaskMeta.CUST_INSPECT_TPL).muliti(false);


        cfg.view().formWindow().width("60%");;
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TASK.NAME).form().validate().required();

        cfg.view().field(CCustInspectTaskMeta.MEMBER_IDS).basic().label("成员").form()
                .button().chooseEmployee(false);
        cfg.view().field(CCustInspectTaskMeta.MEMBER_IDS).table().disable(true);



        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_TASK.NAME,
                        EAMTables.EAM_C_CUST_INSPECT_TASK.INSPECT_USER_ID,
                        CCustInspectTaskMeta.MEMBER_IDS
                },
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_TASK.ACTION_ADD,
                        EAMTables.EAM_C_CUST_INSPECT_TASK.TPL_ID,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_TASK.NOTES,

                }
        );

        cfg.view().list().operationColumn().addActionButton("巡检明细","assetDetail","assetDetail","eam_cust_inspect_assets");
        cfg.view().list().operationColumn().addActionButton("完成","actionFinish","actionFinish","eam_cust_inspect_finish");
        cfg.view().list().operationColumn().addActionButton("取消","actionCancel","actionCancel","eam_cust_inspect_cancel");





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
        CInspectTaskGtr g=new CInspectTaskGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");

      //  g.generateMenu(CCustInspectTaskServiceProxy.class, CCustInspectTaskPageController.class);
    }
}
