package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class StockEamGoodsStock_dangan_Gtr extends BaseCodeGenerator {

    public StockEamGoodsStock_dangan_Gtr() {
        super(EAMTables.EAM_GOODS_STOCK.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Catalog.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addSimpleProperty(Manufacturer.class,"manufacturer","生产厂商","生产厂商");
        cfg.getPoClassFile().addSimpleProperty(Brand.class,"brand","品牌","品牌");
        cfg.getPoClassFile().addSimpleProperty(GoodsStock.class,"goods","物品","物品");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"source","来源","来源");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人","管理人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(GoodsStock.class,"realGoods","库存数据","库存数据");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsModel","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsName","名称","名称");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsCategoryName","分类","分类");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsUnit","计算单位","计算单位");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsCode","物品编码","物品编码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsBarCode","物品条码","物品条码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsStockMax","物品条码","物品条码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsStockMin","物品条码","物品条码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsStockSecurity","物品条码","物品条码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsStockNotes","库存备注","库存备注");




        cfg.view().field(GoodsStockMeta.GOODS_MODEL).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_NAME).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_CATEGORY_NAME).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_UNIT).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_CODE).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_BAR_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.REAL_STOCK_ID).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_STOCK_MAX).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_STOCK_MIN).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_STOCK_SECURITY).table().disable();


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NAME).basic().label("物品名称").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MODEL).basic().label("规格型号").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NOTES).basic().label("备注").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.BAR_CODE).basic().search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.CODE).basic().search().fuzzySearch();


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.PICTURE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.OWNER_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.OWNER_TYPE).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.SELECTED_CODE).table().disable();

        //档案时隐藏
        cfg.view().field(GoodsStockMeta.GOODS_MODEL).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_NAME).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_CATEGORY_NAME).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_UNIT).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_CODE).table().disable();
        cfg.view().field(GoodsStockMeta.GOODS_BAR_CODE).table().disable();

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.OWNER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.OWNER_TMP_ID).table().disable();

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.BUSINESS_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.BATCH_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.OWN_COMPANY_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.USE_ORG_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.SUPPLIER_NAME).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.WAREHOUSE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.SOURCE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.GOODS_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.STOCK_IN_NUMBER).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.STOCK_CUR_NUMBER).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MANAGER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.STORAGE_DATE).table().disable();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.AMOUNT).table().disable();

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.STATUS).table().disable();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_GOODS_STOCK.MANUFACTURER_ID,
                        EAMTables.EAM_GOODS_STOCK.BRAND_ID,
                        EAMTables.EAM_GOODS_STOCK.MODEL,
                        EAMTables.EAM_GOODS_STOCK.NAME,
                },
                new Object[]{
                        EAMTables.EAM_GOODS_STOCK.GOODS_STATUS,
                        EAMTables.EAM_GOODS_STOCK.WAREHOUSE_ID,
                        EAMTables.EAM_GOODS_STOCK.CODE,
                        EAMTables.EAM_GOODS_STOCK.BAR_CODE,
                },
                new Object[]{
                        EAMTables.EAM_GOODS_STOCK.STORAGE_DATE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.PICTURE_ID)
                .form().label("图片").upload().acceptSingleImage().maxFileCount(1).displayFileName(false);

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(GoodsStockMeta.GOODS_MODEL)
                .basic().label("物品型号")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.MODEL).fillWith(GoodsStockMeta.GOODS).muliti(false);

        cfg.view().field(GoodsStockMeta.GOODS_UNIT)
                .basic().label("计量单位")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.UNIT).fillWith(GoodsStockMeta.GOODS).muliti(false);

        cfg.view().field(GoodsStockMeta.GOODS_CODE)
                .basic().label("物品编码")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.CODE).fillWith(GoodsStockMeta.GOODS).muliti(false);


        cfg.view().field(GoodsStockMeta.GOODS_BAR_CODE)
                .basic().label("物品条码")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.BAR_CODE).fillWith(GoodsStockMeta.GOODS).muliti(false);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.STORAGE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.SOURCE_ID)
                .basic().label("来源")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_source")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(GoodsStockMeta.SOURCE).muliti(false).defaultValue("purchase");


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.GOODS_ID)
                .basic().label("物品")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.NAME).fillWith(GoodsStockMeta.GOODS).muliti(false);



        cfg.view().field(EAMTables.EAM_GOODS_STOCK.CATEGORY_ID)
                .basic().label("分类")
                .form().validate().required()
                .form().selectBox().queryApi(CategoryServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME).fillWith(GoodsMeta.CATEGORY).muliti(false);

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.BRAND_ID)
                .basic().label("品牌")
                .form().validate().required()
                .form().selectBox().queryApi(BrandServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(BrandMeta.ID).textField(BrandMeta.BRAND_NAME).fillWith(GoodsStockMeta.BRAND).muliti(false);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MANUFACTURER_ID)
                .basic().label("厂商")
                .form().validate().required()
                .form().selectBox().queryApi(ManufacturerServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(ManufacturerMeta.ID).textField(ManufacturerMeta.MANUFACTURER_NAME).fillWith(GoodsMeta.MANUFACTURER).muliti(false);

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.GOODS_STATUS).basic().label("状态")
                .form().validate().required().form().selectBox().enumType(StatusEnableEnum.class);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.WAREHOUSE_ID)
                .basic().label("仓库")
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField( WarehouseMeta.WAREHOUSE_NAME).fillWith(GoodsStockMeta.WAREHOUSE).muliti(false);



        cfg.view().field(EAMTables.EAM_GOODS_STOCK.OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.USE_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.USE_ORG_ID).table().fillBy("useOrganization","fullName");



        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MANAGER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);



        cfg.view().field(EAMTables.EAM_GOODS_STOCK.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.BAR_CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MODEL).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NOTES).form().textArea().height(Config.textAreaHeight);


        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");
        cfg.view().list().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");

        cfg.view().form().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");
        cfg.view().form().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");

        cfg.view().form().addJsVariable("ASSET_CATEGORY_DATA","[[${assetCategoryData}]]","ASSET_CATEGORY_DATA");
        cfg.view().form().addJsVariable("CATEGORY_CODE","[[${categoryCode}]]","CATEGORY_CODE");
        cfg.view().list().addJsVariable("CATEGORY_CODE","[[${categoryCode}]]","CATEGORY_CODE");


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);
//                cfg.view().form().addGroup(null,
//                new Object[] {
//                        EAMTables.EAM_GOODS_STOCK.STOCK_IN_NUMBER,
//
//
//                }, new Object[] {
//                        EAMTables.EAM_GOODS_STOCK.AMOUNT,
//                }
//
//        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.CATEGORY_ID,
                        EAMTables.EAM_GOODS_STOCK.GOODS_STATUS,
                        EAMTables.EAM_GOODS_STOCK.UNIT,
                }, new Object[] {
                        EAMTables.EAM_GOODS_STOCK.CODE,
                        EAMTables.EAM_GOODS_STOCK.BAR_CODE,
                },
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.MANUFACTURER_ID,
                        EAMTables.EAM_GOODS_STOCK.BRAND_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.NAME,
                        EAMTables.EAM_GOODS_STOCK.MODEL,
                },
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.STOCK_MIN,
                        EAMTables.EAM_GOODS_STOCK.STOCK_MAX,
                }, new Object[] {
                        EAMTables.EAM_GOODS_STOCK.STOCK_SECURITY,
                        EAMTables.EAM_GOODS_STOCK.UNIT_PRICE,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.NOTES,
                        EAMTables.EAM_GOODS_STOCK.PICTURE_ID

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
        //生成代码
        cfg.buildAll();
    }




    public static void main(String[] args) throws Exception {
        StockEamGoodsStock_dangan_Gtr g=new StockEamGoodsStock_dangan_Gtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
         //g.generateMenu(GoodsStockServiceProxy.class, GoodsStockPageController.class);
    }


}
