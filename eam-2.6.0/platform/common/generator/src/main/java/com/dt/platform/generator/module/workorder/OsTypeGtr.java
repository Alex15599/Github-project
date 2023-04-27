package com.dt.platform.generator.module.workorder;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.domain.workorder.meta.ServerApplyMeta;
import com.dt.platform.generator.config.Config;

import com.dt.platform.proxy.workorder.ServerOsTypeServiceProxy;
import com.dt.platform.workorder.page.ServerOsTypePageController;
import com.github.foxnic.generator.config.WriteMode;

public class OsTypeGtr extends BaseCodeGenerator {
    public OsTypeGtr() {
        super(WorkorderTables.WO_SERVER_OS_TYPE.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.view().field(WorkorderTables.WO_SERVER_OS_TYPE.NAME).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        WorkorderTables.WO_SERVER_OS_TYPE.NAME
                }
        );


        cfg.view().field(WorkorderTables.WO_SERVER_OS_TYPE.ID).basic().hidden(true);
        cfg.view().field(WorkorderTables.WO_SERVER_OS_TYPE.ID).table().disable(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field( WorkorderTables.WO_SERVER_OS_TYPE.NAME).form().validate().required();
        cfg.view().field( WorkorderTables.WO_SERVER_OS_TYPE.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SERVER_OS_TYPE.NAME,
                        WorkorderTables.WO_SERVER_OS_TYPE.SORT,
                        WorkorderTables.WO_SERVER_OS_TYPE.NOTES,

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
        OsTypeGtr g=new OsTypeGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
        //g.generateMenu(ServerOsTypeServiceProxy.class, ServerOsTypePageController.class);
    }
}
