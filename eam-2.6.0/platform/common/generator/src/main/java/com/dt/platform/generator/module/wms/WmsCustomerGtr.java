package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.domain.wms.CompanyAttr;
import com.dt.platform.domain.wms.meta.CompanyAttrMeta;
import com.dt.platform.domain.wms.meta.CustomerMeta;
import com.dt.platform.domain.wms.meta.LocTypeMeta;
import com.dt.platform.domain.wms.meta.StorelocationMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.wms.CompanyAttrServiceProxy;
import com.dt.platform.proxy.wms.CustomerServiceProxy;
import com.dt.platform.proxy.wms.LocTypeServiceProxy;
import com.dt.platform.proxy.wms.ProductServiceProxy;
import com.dt.platform.wms.page.CustomerPageController;
import com.dt.platform.wms.page.ProductPageController;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;

public class WmsCustomerGtr extends BaseCodeGenerator {


    public WmsCustomerGtr() {
        super(WmsTables.WMS_CUSTOMER.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_PRODUCT.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(CompanyAttr.class,"companyAttrData","companyAttrData","companyAttrData");

        cfg.view().search().inputLayout(
                new Object[]{
                        WmsTables.WMS_CUSTOMER.NAME,
                        WmsTables.WMS_CUSTOMER.COMPANY_ATTR,
                        WmsTables.WMS_CUSTOMER.CONTRACT_NUMBER,
                        WmsTables.WMS_CUSTOMER.ATTR,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(WmsTables.WMS_CUSTOMER.CODE).form().validate().required();
        cfg.view().field(WmsTables.WMS_CUSTOMER.NAME).form().validate().required();
        cfg.view().field(WmsTables.WMS_CUSTOMER.ADDRESS).form().validate().required();
        cfg.view().field(WmsTables.WMS_CUSTOMER.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(WmsTables.WMS_CUSTOMER.ATTACH).form().upload().acceptAllType().maxFileCount(1);


        cfg.view().field(WmsTables.WMS_CUSTOMER.COMPANY_ATTR)
                .form().validate().form().form().selectBox().queryApi(CompanyAttrServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(CompanyAttrMeta.ID).
                textField(CompanyAttrMeta.NAME).
                fillWith(CustomerMeta.COMPANY_ATTR_DATA).muliti(false);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_CUSTOMER.COMPANY_ATTR,
                        WmsTables.WMS_CUSTOMER.ATTR,
                        WmsTables.WMS_CUSTOMER.CONTRACT_NUMBER,

                },
                new Object[] {
                        WmsTables.WMS_CUSTOMER.CODE,
                        WmsTables.WMS_CUSTOMER.BILLING_METHOD,
                        WmsTables.WMS_CUSTOMER.CONTACT_INFORMATION,
                        WmsTables.WMS_CUSTOMER.BUSINESS_CONTACTS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_CUSTOMER.NAME,
                        WmsTables.WMS_CUSTOMER.ADDRESS,
                        WmsTables.WMS_CUSTOMER.NOTES,
                        WmsTables.WMS_CUSTOMER.ATTACH,
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
        WmsCustomerGtr g=new WmsCustomerGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
   //    g.generateMenu(CustomerServiceProxy.class, CustomerPageController.class);
    }

}
