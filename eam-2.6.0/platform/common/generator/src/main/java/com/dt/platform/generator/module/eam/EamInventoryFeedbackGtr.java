package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryActionStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDataStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.InventoryFeedback;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.InventoryVOMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.eam.page.InventoryFeedbackPageController;
import com.dt.platform.eam.service.impl.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InventoryFeedbackServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;

public class EamInventoryFeedbackGtr extends BaseCodeGenerator{

    public EamInventoryFeedbackGtr() {
        super(EAMTables.EAM_INVENTORY_FEEDBACK.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","用户","用户");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY_FEEDBACK.STATUS,
                        EAMTables.EAM_INVENTORY_FEEDBACK.CONTENT,
                        EAMTables.EAM_INVENTORY_FEEDBACK.NOTES,
                }
        );

        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.CONTENT).form().validate().required().form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.PICTURE_ID).form().upload().acceptImageType().maxFileCount(6);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;

        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.USER_ID).table().fillBy("user","name");
        cfg.view().field(EAMTables.EAM_INVENTORY_FEEDBACK.USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY_FEEDBACK.CONTENT,
                        EAMTables.EAM_INVENTORY_FEEDBACK.PICTURE_ID,
                        EAMTables.EAM_INVENTORY_FEEDBACK.NOTES,
                }
        );
        cfg.view().list().addJsVariable("INVENTORY_ID","[[${inventoryId}]]","inventoryId");

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
        EamInventoryFeedbackGtr g=new EamInventoryFeedbackGtr();
        g.generateCode();

        //生成菜单
        g.generateMenu(InventoryFeedbackServiceProxy.class, InventoryFeedbackPageController.class);
    }
}
