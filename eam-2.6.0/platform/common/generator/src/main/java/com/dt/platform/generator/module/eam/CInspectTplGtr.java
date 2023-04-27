package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.CCustRepairStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.CCustInspectTpl;
import com.dt.platform.eam.page.CCustInspectTplPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.CCustInspectTplServiceProxy;
import com.foxnicweb.web.constants.enums.contract.StatusEnum;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CInspectTplGtr extends BaseCodeGenerator{
    public CInspectTplGtr() {
        super(EAMTables.EAM_C_CUST_INSPECT_TPL.$TABLE,"694836581814501376");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TPL.ID).basic().hidden(true);


        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","assetList","assetList");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","assetIds","assetIds");


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_C_CUST_INSPECT_TPL.STATUS,
                        EAMTables.EAM_C_CUST_INSPECT_TPL.NAME,
                        EAMTables.EAM_C_CUST_INSPECT_TPL.NOTES,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TPL.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TPL.NOTES).search().fuzzySearch();



        cfg.view().formWindow().width("60%");;
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TPL.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TPL.STATUS).form().validate().required().form().radioBox().enumType(StatusEnum.class).defaultIndex(0);



        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_TPL.NAME,

                },
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_TPL.STATUS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_TPL.NOTES,

                }
        );

        cfg.view().list().operationColumn().addActionButton("设备列表","inspectAssetList","eam_cust_inspect_tpl_asset","eam_cust_inspect_tpl_asset");


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
        CInspectTplGtr g=new CInspectTplGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(CodeRuleServiceProxy.class, CodeRulePageController.class);
       // g.generateMenu(CCustInspectTplServiceProxy.class, CCustInspectTplPageController.class);
    }
}
