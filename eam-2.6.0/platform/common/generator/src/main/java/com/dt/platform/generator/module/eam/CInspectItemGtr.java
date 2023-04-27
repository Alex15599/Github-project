package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.CCustInspectItemStatusEnum;
import com.dt.platform.constants.enums.eam.CCustRepairStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.CCustInspectTpl;
import com.dt.platform.eam.page.CCustInspectItemPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.CCustInspectItemServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CInspectItemGtr extends BaseCodeGenerator{
    public CInspectItemGtr() {
        super(EAMTables.EAM_C_CUST_INSPECT_ITEM.$TABLE,"694836581814501376");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.OWNER_ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.PICTURE_ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.POS).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.POS).table().disable(true);

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"inspectUser","inspectUser","inspectUser");
        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","asset","asset");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.STATUS,
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_CODE,
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_NAME,
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_MODEL,
                }


        );
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.INSPECT_USER_ID).table().fillBy("inspectUser","name");
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.INSPECT_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.OWNER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.PICTURE_ID).table().disable(true);



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_MODEL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.STATUS).form().validate().required().form().radioBox().enumType(CCustInspectItemStatusEnum.class);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.CT).form().textArea().height(120);

        cfg.view().formWindow().width("60%");;
        cfg.view().formWindow().bottomSpace(200);

        cfg.view().list().addToolButton("增加设备","assetaAdd","asset-add","eam_cust_inspect_add");
        cfg.view().list().addToolButton("开始","actionStart","actionStart","eam_cust_inspect_start");

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_CODE).form().readOnly();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_MODEL).form().readOnly();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_SEQ).form().readOnly();

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_ITEM.RECORD_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().form().addGroup("设备记录",
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.STATUS,
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.RECORD_TIME,
                },
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.INSPECT_USER_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.CT,
                }
        );

        cfg.view().form().addGroup("设备信息",
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_CODE,
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_NAME
                },
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_MODEL,
                        EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_SEQ
                }
        );



        cfg.view().list().addJsVariable("INSPECT_ID","[[${inspectId}]]","INSPECT_ID");
        cfg.view().form().addJsVariable("INSPECT_ID","[[${inspectId}]]","INSPECT_ID");

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
        CInspectItemGtr g=new CInspectItemGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(CodeRuleServiceProxy.class, CodeRulePageController.class);
        //g.generateMenu(CCustInspectItemServiceProxy.class, CCustInspectItemPageController.class);
    }
}
