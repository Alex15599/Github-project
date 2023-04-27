package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.domain.cms.Category;
import com.dt.platform.domain.wms.Customer;
import com.dt.platform.domain.wms.ProductAttr;
import com.dt.platform.domain.wms.ProductCategory;
import com.dt.platform.domain.wms.Unit;
import com.dt.platform.domain.wms.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.wms.*;
import com.dt.platform.wms.page.ProductPageController;
import com.github.foxnic.generator.config.WriteMode;

public class WmsProductGtr extends BaseCodeGenerator {


    public WmsProductGtr() {
        super(WmsTables.WMS_PRODUCT.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_PRODUCT.ID).basic().hidden(true);

        cfg.getPoClassFile().addListProperty(ProductAttr.class,"productAttrList","productAttr","productAttr");
        cfg.getPoClassFile().addListProperty(String.class,"productAttrIds","productAttrIds","productAttrIds");

        cfg.getPoClassFile().addSimpleProperty(Customer.class,"customer","customer","customer");
        cfg.getPoClassFile().addSimpleProperty(Unit.class,"unitData","UnitData","UnitData");
        cfg.getPoClassFile().addSimpleProperty(ProductCategory.class,"productCategory","productCategory","productCategory");
        cfg.view().search().inputLayout(
                new Object[]{
                        WmsTables.WMS_PRODUCT.CUST_ID,
                        WmsTables.WMS_PRODUCT.CATEGORY,
                        WmsTables.WMS_PRODUCT.NAME,
                        WmsTables.WMS_PRODUCT.PRODUCT_SKU
                },
                new Object[]{
                        WmsTables.WMS_PRODUCT.PRODUCT_MODEL,
                        WmsTables.WMS_PRODUCT.CODE,
                        WmsTables.WMS_PRODUCT.BAR_CODE,
                        WmsTables.WMS_PRODUCT.CUST_PRODUCT_CODE,
                }

        );


        cfg.view().field(ProductMeta.PRODUCT_ATTR_IDS)
                .basic().label("属性")
                .form().selectBox().queryApi(ProductAttrServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(ProductAttrMeta.ID).
                textField(ProductAttrMeta.NAME).
                fillWith(ProductMeta.PRODUCT_ATTR_LIST).muliti(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(WmsTables.WMS_PRODUCT.CODE).form().validate().required();
        cfg.view().field(WmsTables.WMS_PRODUCT.NAME).form().validate().required();
        cfg.view().field(WmsTables.WMS_PRODUCT.NOTES).form().textArea().height(Config.textAreaHeight);


        cfg.view().field(WmsTables.WMS_PRODUCT.UNIT).form().validate().required();

        cfg.view().field(WmsTables.WMS_PRODUCT.CATEGORY)
                .form().validate().required().form().selectBox().queryApi(ProductCategoryServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(ProductCategoryMeta.ID).
                textField(ProductCategoryMeta.CATEGORY_NAME).
                fillWith(ProductMeta.PRODUCT_CATEGORY).muliti(false);

        cfg.view().field(WmsTables.WMS_PRODUCT.UNIT)
                .form().validate().required().form().selectBox().queryApi(UnitServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(UnitMeta.ID).
                textField(UnitMeta.NAME).
                fillWith(ProductMeta.UNIT_DATA).muliti(false);


        cfg.view().field(WmsTables.WMS_PRODUCT.CUST_ID)
                .form().validate().required().form().selectBox().queryApi(CustomerServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(CustomerMeta.ID).
                textField(CustomerMeta.NAME).
                fillWith(ProductMeta.CUSTOMER).muliti(false);


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        WmsTables.WMS_PRODUCT.CUST_ID,
                        WmsTables.WMS_PRODUCT.NAME,
                        WmsTables.WMS_PRODUCT.PRODUCT_BRAND,
                        ProductMeta.PRODUCT_ATTR_IDS,

                },
                new Object[] {
                        WmsTables.WMS_PRODUCT.CATEGORY,
                        WmsTables.WMS_PRODUCT.CUST_PRODUCT_CODE,
                        WmsTables.WMS_PRODUCT.CODE,
                        WmsTables.WMS_PRODUCT.PRODUCT_SKU,
                        WmsTables.WMS_PRODUCT.UNIT,

                }
        );

        cfg.view().form().addGroup("属性",
                new Object[] {
                        WmsTables.WMS_PRODUCT.KEEP_DATE,
                        WmsTables.WMS_PRODUCT.MAX_VOLUME,
                        WmsTables.WMS_PRODUCT.MAX_WEIGHT,
                        WmsTables.WMS_PRODUCT.MIN_STOCK_NUMBER,
                },
                new Object[] {
                        WmsTables.WMS_PRODUCT.PERIOD,
                        WmsTables.WMS_PRODUCT.LENGTH,
                        WmsTables.WMS_PRODUCT.WIDTH,
                        WmsTables.WMS_PRODUCT.HEIGHT,
                }
        );



        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_PRODUCT.NOTES,
                }

        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        WmsProductGtr g=new WmsProductGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //  g.generateMenu(ProductServiceProxy.class, ProductPageController.class);
    }

}
