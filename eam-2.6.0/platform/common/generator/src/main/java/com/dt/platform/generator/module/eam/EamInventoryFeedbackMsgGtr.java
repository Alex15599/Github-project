package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.InventoryFeedbackMsgPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InventoryFeedbackMsgServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamInventoryFeedbackMsgGtr extends BaseCodeGenerator{

    public EamInventoryFeedbackMsgGtr() {
        super(EAMTables.EAM_INVENTORY_FEEDBACK_MSG.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK_MSG.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","用户","用户");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY_FEEDBACK_MSG.CONTENT,
                }
        );

        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK_MSG.CONTENT).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK_MSG.CONTENT).form().validate().required().form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK_MSG.PICTURE_ID).form().upload().acceptImageType().maxFileCount(6);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;

        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK_MSG.USER_ID).table().fillBy("user","name");
        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK_MSG.USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY_FEEDBACK_MSG.CONTENT,
                        EAMTables.EAM_INVENTORY_FEEDBACK_MSG.PICTURE_ID,
                }
        );

        cfg.view().list().addJsVariable("FEEDBACK_ID","[[${feedbackId}]]","feedbackId");

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
        EamInventoryFeedbackMsgGtr g=new EamInventoryFeedbackMsgGtr();
        g.generateCode();

        //生成菜单
       // g.generateMenu(InventoryFeedbackMsgServiceProxy.class, InventoryFeedbackMsgPageController.class);
    }
}
