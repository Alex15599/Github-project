package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.constants.enums.wms.StatusEnableEnum;
import com.dt.platform.domain.wms.*;
import com.dt.platform.domain.wms.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.wms.*;
import com.dt.platform.wms.page.StorelocationPageController;
import com.github.foxnic.generator.config.WriteMode;

public class WmsStoreLocGtr extends BaseCodeGenerator {


    public WmsStoreLocGtr() {
        super(WmsTables.WMS_STORELOCATION.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_STORELOCATION.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(Storehouse.class,"storehouse","storehouse","storehouse");
        cfg.getPoClassFile().addSimpleProperty(Customer.class,"customer","customer","customer");

        cfg.getPoClassFile().addListProperty(ProductAttr.class,"productAttrList","productAttr","productAttr");
        cfg.getPoClassFile().addListProperty(String.class,"productAttrIds","productAttrIds","productAttrIds");

        cfg.getPoClassFile().addSimpleProperty(LocType.class,"locType","locType","locType");
        cfg.getPoClassFile().addSimpleProperty(TemperatureAttribute.class,"temperatureAttribute","temperatureAttribute","temperatureAttribute");

        cfg.view().search().inputLayout(
                new Object[]{
                        WmsTables.WMS_STORELOCATION.STOREHOUSE_ID,
                        WmsTables.WMS_STORELOCATION.CUSTOMER_ID,
                        WmsTables.WMS_STORELOCATION.STATUS,
                        WmsTables.WMS_STORELOCATION.NAME,

                },
                new Object[]{
                      //  WmsTables.WMS_STORELOCATION.PRODUCT_ATTRIBUTE,
                        WmsTables.WMS_STORELOCATION.LOCATION_ATTRIBUTE,
                        WmsTables.WMS_STORELOCATION.TYPE,
                        WmsTables.WMS_STORELOCATION.CODE,

                },
                new Object[]{
                        WmsTables.WMS_STORELOCATION.LOCATION_GROUP,
                        WmsTables.WMS_STORELOCATION.X_COORDINATE,
                        WmsTables.WMS_STORELOCATION.Y_COORDINATE,
                        WmsTables.WMS_STORELOCATION.Z_COORDINATE,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().rowsDisplay(1);

        cfg.view().field(WmsTables.WMS_STORELOCATION.BAR_CODE).form().validate().required();
        cfg.view().field(WmsTables.WMS_STORELOCATION.CODE).form().validate().required();
        cfg.view().field(WmsTables.WMS_STORELOCATION.NAME).form().validate().required();

        cfg.view().field(WmsTables.WMS_STORELOCATION.LOCATION_ATTRIBUTE).form().validate().required();

        cfg.view().field(WmsTables.WMS_STORELOCATION.NOTES1).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(WmsTables.WMS_STORELOCATION.NOTES2).form().textArea().height(Config.textAreaHeight);



        cfg.view().field(StorelocationMeta.PRODUCT_ATTR_IDS)
                .basic().label("属性")
                .form().selectBox().queryApi(ProductAttrServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(ProductAttrMeta.ID).
                textField(ProductAttrMeta.NAME).
                fillWith(StorelocationMeta.PRODUCT_ATTR_LIST).muliti(true);


        cfg.view().field(WmsTables.WMS_STORELOCATION.CUSTOMER_ID)
                .form().selectBox().queryApi(CustomerServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(CustomerMeta.ID).
                textField(CustomerMeta.NAME).
                fillWith(StorelocationMeta.CUSTOMER).muliti(false);


        cfg.view().field(WmsTables.WMS_STORELOCATION.STOREHOUSE_ID)
                .form().validate().form().selectBox().queryApi(StorehouseServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(StorehouseMeta.ID).
                textField(StorehouseMeta.NAME).
                fillWith(StorelocationMeta.STOREHOUSE).muliti(false);

        cfg.view().field(WmsTables.WMS_STORELOCATION.TYPE)
                .form().validate().form().form().selectBox().queryApi(LocTypeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(LocTypeMeta.ID).
                textField(LocTypeMeta.NAME).
                fillWith(StorelocationMeta.LOC_TYPE).muliti(false);

        cfg.view().field(WmsTables.WMS_STORELOCATION.LOCATION_ATTRIBUTE)
                .form().selectBox().queryApi(TemperatureAttributeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(TemperatureAttributeMeta.ID).
                textField(TemperatureAttributeMeta.NAME).
                fillWith(StorelocationMeta.TEMPERATURE_ATTRIBUTE).muliti(false);

        cfg.view().field(WmsTables.WMS_STORELOCATION.STATUS).form().validate().form().radioBox().enumType(StatusEnableEnum.class);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_STORELOCATION.STOREHOUSE_ID,
                        WmsTables.WMS_STORELOCATION.CODE,
                        WmsTables.WMS_STORELOCATION.TYPE,
                },
                new Object[] {
                        WmsTables.WMS_STORELOCATION.CUSTOMER_ID,
                        WmsTables.WMS_STORELOCATION.BAR_CODE,
                        WmsTables.WMS_STORELOCATION.LOCATION_ATTRIBUTE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_STORELOCATION.STATUS,

                },
                new Object[] {
                        StorelocationMeta.PRODUCT_ATTR_IDS
                }

        );

        cfg.view().form().addGroup("属性",
                new Object[] {
                        WmsTables.WMS_STORELOCATION.LOCATION_GROUP,
                        WmsTables.WMS_STORELOCATION.MAX_WEIGHT,
                        WmsTables.WMS_STORELOCATION.MAX_VOLUME,
                        WmsTables.WMS_STORELOCATION.MIN_BATCH,
                        WmsTables.WMS_STORELOCATION.MAX_BATCH,
                        WmsTables.WMS_STORELOCATION.RFID,
                },
                new Object[] {
                        WmsTables.WMS_STORELOCATION.LENGTH,
                        WmsTables.WMS_STORELOCATION.WIDTH,
                        WmsTables.WMS_STORELOCATION.HEIGHT,
                        WmsTables.WMS_STORELOCATION.X_COORDINATE,
                        WmsTables.WMS_STORELOCATION.Y_COORDINATE,
                        WmsTables.WMS_STORELOCATION.Z_COORDINATE
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_STORELOCATION.NOTES1,
                        WmsTables.WMS_STORELOCATION.NOTES2,
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
        WmsStoreLocGtr g=new WmsStoreLocGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(StorelocationServiceProxy.class, StorelocationPageController.class);
    }

}
