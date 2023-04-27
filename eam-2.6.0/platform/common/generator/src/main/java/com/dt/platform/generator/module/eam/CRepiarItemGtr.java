package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetCodeSeqNumberTypeEnum;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.CCustRepiarItem;
import com.dt.platform.domain.eam.meta.CCustRepairApplyMeta;
import com.dt.platform.domain.eam.meta.CCustRepiarItemMeta;
import com.dt.platform.eam.page.CCustRepiarItemPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.CCustRepiarItemServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CRepiarItemGtr extends BaseCodeGenerator{
    public CRepiarItemGtr() {
        super(EAMTables.EAM_C_CUST_REPIAR_ITEM.$TABLE,"694492212972486656");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"processUser","处理人","制单人");

        cfg.view().field(EAMTables.EAM_C_CUST_REPIAR_ITEM.PROCESS_USER_ID).table().fillBy("processUser","name");
        cfg.view().field(EAMTables.EAM_C_CUST_REPIAR_ITEM.ID).basic().hidden(true);
        cfg.view().search().disable();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_C_CUST_REPIAR_ITEM.CT).form().validate().required().form().textArea().height(80);
        cfg.view().list().addJsVariable("REPAIR_ID","[[${repairId}]]","维修ID");
        cfg.view().form().addJsVariable("REPAIR_ID","[[${repairId}]]","维修ID");

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_REPIAR_ITEM.CT,
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
        CRepiarItemGtr g=new CRepiarItemGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
        //g.generateMenu(CCustRepiarItemServiceProxy.class, CCustRepiarItemPageController.class);
    }
}
