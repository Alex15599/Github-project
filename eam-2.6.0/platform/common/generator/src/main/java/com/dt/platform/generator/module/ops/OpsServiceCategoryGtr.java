package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.ServiceTypeEnum;
import com.dt.platform.domain.ops.InformationSystem;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.ServiceCategoryPageController;
import com.dt.platform.ops.service.impl.HostDbServiceImpl;
import com.dt.platform.ops.service.impl.ServiceCategoryLabelServiceImpl;
import com.dt.platform.proxy.ops.ServiceCategoryServiceProxy;
import com.dt.platform.proxy.ops.ServiceGroupServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsServiceCategoryGtr extends BaseCodeGenerator{


    public OpsServiceCategoryGtr() {
        super(OpsTables.OPS_SERVICE_CATEGORY.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(ServiceGroup.class,"group","服务分组","服务分组");
        cfg.getPoClassFile().addListProperty(DictItem.class,"labelList","labelList","labelList");
        cfg.getPoClassFile().addListProperty(String.class,"labelIds","labelIds","labelIds");

        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.CREATE_TIME).table().hidden();
        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.NOTES).search().fuzzySearch();


        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.GROUP_ID)
                .basic().label("服务分组")
                .form().validate().required().form().selectBox().queryApi(ServiceGroupServiceProxy.QUERY_LIST)
                .valueField(ServiceGroupMeta.CODE).textField(ServiceGroupMeta.NAME)
                .toolbar(false).filter(true).paging(false).defaultIndex(0)
                .fillWith(ServiceCategoryMeta.GROUP).muliti(false);


        cfg.view().field(ServiceCategoryMeta.LABEL_IDS)
                .basic().label("标签")
                .table().sort(false)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_service_category_label")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(ServiceCategoryMeta.LABEL_LIST).muliti(true);

        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.NAME)
                .form().validate().required();

        cfg.view().field(OpsTables.OPS_SERVICE_CATEGORY.CODE)
                .form().validate().required();

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SERVICE_CATEGORY.GROUP_ID,
                        OpsTables.OPS_SERVICE_CATEGORY.NAME,
                        OpsTables.OPS_SERVICE_CATEGORY.NOTES
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);

       // cfg.service().addRelationSaveAction(ServiceCategoryLabelServiceImpl.class, ServiceCategoryVOMeta.LABEL_IDS);


        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SERVICE_CATEGORY.CODE,
                        OpsTables.OPS_SERVICE_CATEGORY.NAME,
                        OpsTables.OPS_SERVICE_CATEGORY.GROUP_ID,
                      //  ServiceCategoryMeta.LABEL_IDS,
                        OpsTables.OPS_SERVICE_CATEGORY.NOTES,

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
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsServiceCategoryGtr g=new OpsServiceCategoryGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.removeByBatchId("474335473372758016");
     //   g.generateMenu(ServiceCategoryServiceProxy.class, ServiceCategoryPageController.class);
    }
}
