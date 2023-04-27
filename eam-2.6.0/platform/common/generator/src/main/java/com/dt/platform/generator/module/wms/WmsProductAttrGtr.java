package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.wms.ProductAttrServiceProxy;
import com.dt.platform.wms.page.ProductAttrPageController;
import com.github.foxnic.generator.config.WriteMode;

public class WmsProductAttrGtr extends BaseCodeGenerator {


    public WmsProductAttrGtr() {
        super(WmsTables.WMS_PRODUCT_ATTR.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_PRODUCT_ATTR.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        WmsTables.WMS_PRODUCT_ATTR.CODE,
                        WmsTables.WMS_PRODUCT_ATTR.NAME
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(WmsTables.WMS_PRODUCT_ATTR.CODE).form().validate().required();
        cfg.view().field(WmsTables.WMS_PRODUCT_ATTR.NAME).form().validate().required();
        cfg.view().field(WmsTables.WMS_PRODUCT_ATTR.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(WmsTables.WMS_PRODUCT_ATTR.CODE).search().fuzzySearch();
        cfg.view().field(WmsTables.WMS_PRODUCT_ATTR.NAME).search().fuzzySearch();


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_PRODUCT_ATTR.CODE,
                        WmsTables.WMS_PRODUCT_ATTR.NAME,
                        WmsTables.WMS_PRODUCT_ATTR.NOTES
                }

        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
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
        WmsProductAttrGtr g=new WmsProductAttrGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(ProductAttrServiceProxy.class, ProductAttrPageController.class);
    }

}
