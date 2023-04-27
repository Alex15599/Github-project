package com.dt.platform.generator.module.workorder;

import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.constants.enums.workorder.ServiceDeskStatusEnum;
import com.dt.platform.constants.enums.workorder.ServiceDeskTypeEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.workorder.ServiceDeskServiceProxy;
import com.dt.platform.workorder.page.ServiceDeskPageController;
import com.github.foxnic.generator.config.WriteMode;

public class ServiceDeskGtr extends BaseCodeGenerator {
    public ServiceDeskGtr() {
        super(WorkorderTables.WO_SERVICE_DESK.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.view().field(WorkorderTables.WO_SERVICE_DESK.NAME).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        WorkorderTables.WO_SERVICE_DESK.NAME
                }
        );


        cfg.view().field(WorkorderTables.WO_SERVICE_DESK.ID).basic().hidden(true);
        cfg.view().field(WorkorderTables.WO_SERVICE_DESK.ID).table().disable(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.TYPE).form().validate()
                .required().form().radioBox().enumType(ServiceDeskTypeEnum.class).defaultIndex(0);

        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.STATUS).form().validate()
                .required().form().radioBox().enumType(ServiceDeskStatusEnum.class).defaultIndex(0);


        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.LABEL).form().validate().required();
        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.CODE).form().validate().required();
        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.NAME).form().validate().required();
        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.PERM).form().validate().required();
        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.PROCESS_CODE).form().validate().required();
        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.PARAMETER).form().validate().required().form().textArea().height(Config.textAreaHeight);
        cfg.view().field( WorkorderTables.WO_SERVICE_DESK.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SERVICE_DESK.NAME,
                        WorkorderTables.WO_SERVICE_DESK.STATUS,
                        WorkorderTables.WO_SERVICE_DESK.TYPE,
                        WorkorderTables.WO_SERVICE_DESK.IMAGE,
                        WorkorderTables.WO_SERVICE_DESK.SORT
                },
                new Object[] {
                        WorkorderTables.WO_SERVICE_DESK.LABEL,
                        WorkorderTables.WO_SERVICE_DESK.CODE,
                        WorkorderTables.WO_SERVICE_DESK.PERM,
                        WorkorderTables.WO_SERVICE_DESK.PROCESS_CODE,


                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SERVICE_DESK.PARAMETER,
                        WorkorderTables.WO_SERVICE_DESK.NOTES,

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
        ServiceDeskGtr g=new ServiceDeskGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(ServiceDeskServiceProxy.class, ServiceDeskPageController.class);
    }
}
