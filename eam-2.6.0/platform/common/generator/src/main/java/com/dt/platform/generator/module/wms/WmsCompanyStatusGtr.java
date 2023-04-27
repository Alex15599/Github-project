package com.dt.platform.generator.module.wms;


import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.wms.CompanyStatusServiceProxy;
import com.dt.platform.wms.page.CompanyStatusPageController;
import com.github.foxnic.generator.config.WriteMode;

public class WmsCompanyStatusGtr extends BaseCodeGenerator {


    public WmsCompanyStatusGtr() {
        super(WmsTables.WMS_COMPANY_STATUS.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(WmsTables.WMS_COMPANY_STATUS.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        WmsTables.WMS_COMPANY_STATUS.CODE,
                        WmsTables.WMS_COMPANY_STATUS.NAME
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(WmsTables.WMS_COMPANY_STATUS.CODE).form().validate().required();
        cfg.view().field(WmsTables.WMS_COMPANY_STATUS.NAME).form().validate().required();
        cfg.view().field(WmsTables.WMS_COMPANY_STATUS.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WmsTables.WMS_COMPANY_STATUS.CODE,
                        WmsTables.WMS_COMPANY_STATUS.NAME,
                        WmsTables.WMS_COMPANY_STATUS.NOTES
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
        WmsCompanyStatusGtr g=new WmsCompanyStatusGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(CompanyStatusServiceProxy.class, CompanyStatusPageController.class);
    }

}
