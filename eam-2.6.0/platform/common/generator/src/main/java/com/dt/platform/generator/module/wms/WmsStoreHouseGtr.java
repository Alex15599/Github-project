package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.wms.ProductAttr;
import com.dt.platform.domain.wms.Storehouse;
import com.dt.platform.domain.wms.meta.ProductAttrMeta;
import com.dt.platform.domain.wms.meta.StorehouseMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.wms.ProductAttrServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class WmsStoreHouseGtr extends BaseCodeGenerator {


    public WmsStoreHouseGtr() {
        super(WmsTables.WMS_STOREHOUSE.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_STOREHOUSE.ID).basic().hidden(true);

        cfg.getPoClassFile().addListProperty(ProductAttr.class,"productAttrList","productAttr","productAttr");
        cfg.getPoClassFile().addListProperty(String.class,"productAttrIds","productAttrIds","productAttrIds");

        cfg.view().search().inputLayout(
                new Object[]{
                        StorehouseMeta.PRODUCT_ATTR_IDS,
                        WmsTables.WMS_STOREHOUSE.CODE,
                        WmsTables.WMS_STOREHOUSE.NAME
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(WmsTables.WMS_STOREHOUSE.CODE).form().validate().required();
        cfg.view().field(WmsTables.WMS_STOREHOUSE.NAME).form().validate().required();
        cfg.view().field(WmsTables.WMS_STOREHOUSE.NOTES).form().textArea().height(Config.textAreaHeight);



        cfg.view().field(StorehouseMeta.PRODUCT_ATTR_IDS)
                .basic().label("属性")
                .form().selectBox().queryApi(ProductAttrServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(ProductAttrMeta.ID).
                textField(ProductAttrMeta.NAME).
                fillWith(StorehouseMeta.PRODUCT_ATTR_LIST).muliti(true);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {

                        WmsTables.WMS_STOREHOUSE.CODE,
                        WmsTables.WMS_STOREHOUSE.NAME,
                        StorehouseMeta.PRODUCT_ATTR_IDS,
                        WmsTables.WMS_STOREHOUSE.NOTES
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
        WmsStoreHouseGtr g=new WmsStoreHouseGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(StorehouseServiceProxy.class, StorehousePageController.class);
    }

}
