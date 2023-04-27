package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.KnTables;
import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.wms.ProductCategoryServiceProxy;
import com.dt.platform.wms.page.ProductCategoryPageController;
import com.github.foxnic.generator.config.WriteMode;

public class WmsProductCategoryGtr extends BaseCodeGenerator {


    public WmsProductCategoryGtr() {
        super(WmsTables.WMS_PRODUCT_CATEGORY.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.ID).basic().hidden(true);

        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.ID).basic().hidden(true);
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.CATEGORY_CODE).search().hidden(true);
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.CATEGORY_NAME).search().hidden(true);
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.SORT).search().hidden(true);
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.PARENT_ID).search().hidden(true);
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.HIERARCHY).search().hidden(true);
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.HIERARCHY_NAME).search().hidden(true);
        cfg.view().field(WmsTables.WMS_PRODUCT_CATEGORY.NOTES).search().hidden(true);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        WmsProductCategoryGtr g=new WmsProductCategoryGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
      // g.generateMenu(ProductCategoryServiceProxy.class, ProductCategoryPageController.class);
    }

}
