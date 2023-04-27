package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.WmsTables;


import com.dt.platform.domain.wms.meta.SupplierMeta;
import com.dt.platform.generator.config.Config;

import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class WmsSupplierGtr extends BaseCodeGenerator {


    public WmsSupplierGtr() {
        super(WmsTables.WMS_SUPPLIER.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {


        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_SUPPLIER.ID).basic().hidden(true);
        cfg.view().field(WmsTables.WMS_SUPPLIER.SUPPLIER_NAME).search().fuzzySearch();
        cfg.view().field(WmsTables.WMS_SUPPLIER.SUPPLIER_NOTES).search().fuzzySearch();
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"gradeDict","gradeDict","gradeDict");

        cfg.view().search().inputLayout(
                new Object[]{
                        WmsTables.WMS_SUPPLIER.CODE,
                        WmsTables.WMS_SUPPLIER.SUPPLIER_NAME,
                        WmsTables.WMS_SUPPLIER.GRADE,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //eam_tpl_file

        cfg.view().field(WmsTables.WMS_SUPPLIER.SUPPLIER_NAME).form().validate().required();


        cfg.view().field(WmsTables.WMS_SUPPLIER.GRADE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=wms_supplier_grade")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(SupplierMeta.GRADE_DICT).muliti(false).defaultIndex(0);


        cfg.view().field(WmsTables.WMS_SUPPLIER.ADDRESS).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(WmsTables.WMS_SUPPLIER.SUPPLIER_NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().width(Config.baseFormWidth);;

        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_SUPPLIER.SUPPLIER_NAME,
                        WmsTables.WMS_SUPPLIER.CODE,
                        WmsTables.WMS_SUPPLIER.UNIT_CODE,
                },
                new Object[] {
                        WmsTables.WMS_SUPPLIER.GRADE,
                        WmsTables.WMS_SUPPLIER.BUSINESS_CONTACTS,
                        WmsTables.WMS_SUPPLIER.BUSINESS_CONTACTS_INFO,
                },
                new Object[] {
                        WmsTables.WMS_SUPPLIER.AFTER_SALES_CONTACTS,
                        WmsTables.WMS_SUPPLIER.AFTER_SALES_CONTACTS_INFO,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_SUPPLIER.ADDRESS,
                        WmsTables.WMS_SUPPLIER.SUPPLIER_NOTES,
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
        cfg.buildAll();

    }

    public static void main(String[] args) throws Exception {
        WmsSupplierGtr g=new WmsSupplierGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
    //   g.generateMenu(SupplierServiceProxy.class, SupplierPageController.class);
    }

}
