package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.generator.config.Config;
import com.foxnicweb.web.constants.enums.contract.StatusEnum;
import com.github.foxnic.generator.config.WriteMode;

public class CInspectTplAssetGtr extends BaseCodeGenerator{
    public CInspectTplAssetGtr() {
        super(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.$TABLE,"694836581814501376");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.OWNER_ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("60%");;
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.OWNER_ID,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CInspectTplAssetGtr g=new CInspectTplAssetGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(CodeRuleServiceProxy.class, CodeRulePageController.class);
       // g.generateMenu(CCustInspectTplServiceProxy.class, CCustInspectTplPageController.class);
    }
}
