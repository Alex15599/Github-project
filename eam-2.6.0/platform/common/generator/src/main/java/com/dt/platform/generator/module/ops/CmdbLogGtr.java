package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsCmdbLogLevelEnum;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;

public class CmdbLogGtr extends BaseCodeGenerator{


    public CmdbLogGtr() {
        super(OpsTables.OPS_CMDB_LOG.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CMDB_LOG.MODEL_ID,
                        OpsTables.OPS_CMDB_LOG.OBJ_ID,
                        OpsTables.OPS_CMDB_LOG.TRACE_ID,
                        OpsTables.OPS_CMDB_LOG.LOG_LEVEL,
                },
                new Object[]{
                        OpsTables.OPS_CMDB_LOG.RCD_TIME,

                }
        );

        cfg.getPoClassFile().addSimpleProperty(CmdbModelV.class,"cmdbModelV","cmdbModelV","cmdbModelV");
        cfg.getPoClassFile().addSimpleProperty(CmdbModel.class,"cmdbModel","cmdbModel","cmdbModel");


        cfg.view().field(OpsTables.OPS_CMDB_LOG.ID).basic().hidden(true);

        cfg.view().field(OpsTables.OPS_CMDB_LOG.TRACE_ID).basic().label("日志跟踪");
        cfg.view().field(OpsTables.OPS_CMDB_LOG.TRACE_ID).form().search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_CMDB_LOG.RCD_TIME).form().search().range();

        cfg.view().field(OpsTables.OPS_CMDB_LOG.MODEL_ID)
                .form().selectBox().queryApi(CmdbModelServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CmdbModelMeta.ID).textField(CmdbModelMeta.NAME).
                fillWith(CmdbLogMeta.CMDB_MODEL).muliti(false);


        cfg.view().field(OpsTables.OPS_CMDB_LOG.OBJ_ID)
                .form().selectBox().queryApi(CmdbModelVServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CmdbModelVMeta.ID).textField(CmdbModelVMeta.NAME).
                fillWith(CmdbLogMeta.CMDB_MODEL_V).muliti(false);

        cfg.view().field(OpsTables.OPS_CMDB_LOG.LOG_RECORD).form().textArea().height(300);
        cfg.view().field(OpsTables.OPS_CMDB_LOG.RCD_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();



        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableModify();


        cfg.view().field(OpsTables.OPS_CMDB_LOG.LOG_LEVEL).form().
                 radioBox().defaultIndex(0).enumType(OpsCmdbLogLevelEnum.class);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_LOG.MODEL_ID,
                        OpsTables.OPS_CMDB_LOG.OBJ_ID,
                        OpsTables.OPS_CMDB_LOG.TRACE_ID,
                        OpsTables.OPS_CMDB_LOG.LOG_LEVEL,
                        OpsTables.OPS_CMDB_LOG.LOG_RECORD,
                        OpsTables.OPS_CMDB_LOG.RCD_TIME,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CmdbLogGtr g=new CmdbLogGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
        //  g.generateMenu(CmdbLogServiceProxy.class, CmdbLogPageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
