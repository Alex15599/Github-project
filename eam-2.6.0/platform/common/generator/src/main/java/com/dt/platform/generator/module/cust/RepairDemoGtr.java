package com.dt.platform.generator.module.cust;


import com.dt.platform.constants.db.CustTables;
import com.dt.platform.constants.enums.cust.RepairStatusEnum;
import com.dt.platform.customer.page.RepiarDemoPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.customer.ClpsDemoServiceProxy;
import com.dt.platform.proxy.customer.RepiarDemoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class RepairDemoGtr extends BaseCodeGenerator {


    public RepairDemoGtr() {
        super(CustTables.CUST_REPIAR_DEMO.$TABLE,"463397133957988352");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(CustTables.CUST_REPIAR_DEMO.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        CustTables.CUST_REPIAR_DEMO.STATUS,
                        CustTables.CUST_REPIAR_DEMO.TITLE,
                        CustTables.CUST_REPIAR_DEMO.USER,
                        CustTables.CUST_REPIAR_DEMO.ORG,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(CustTables.CUST_REPIAR_DEMO.TITLE).search().fuzzySearch();
        cfg.view().field(CustTables.CUST_REPIAR_DEMO.USER).search().fuzzySearch();
        cfg.view().field(CustTables.CUST_REPIAR_DEMO.ORG).search().fuzzySearch();
        cfg.view().field(CustTables.CUST_REPIAR_DEMO.STATUS).form().selectBox().enumType(RepairStatusEnum.class);
        cfg.view().field(CustTables.CUST_REPIAR_DEMO.TITLE).form().validate().required();
        cfg.view().field(CustTables.CUST_REPIAR_DEMO.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(CustTables.CUST_REPIAR_DEMO.CONTENT).form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        CustTables.CUST_REPIAR_DEMO.TITLE,
                        CustTables.CUST_REPIAR_DEMO.USER,
                        CustTables.CUST_REPIAR_DEMO.ORG,
                        CustTables.CUST_REPIAR_DEMO.CONTENT,
                        CustTables.CUST_REPIAR_DEMO.NOTES
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
        RepairDemoGtr g=new RepairDemoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单


     //   g.generateMenu(RepiarDemoServiceProxy.class, RepiarDemoPageController.class);
    }

}
