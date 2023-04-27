package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.CmdbModelVHPageController;
import com.dt.platform.proxy.ops.CmdbModelVHServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CmdbModelValueHistoryGtr extends BaseCodeGenerator{


    public CmdbModelValueHistoryGtr() {
        super(OpsTables.OPS_CMDB_MODEL_V_H.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(CmdbModel.class,"cmdbModel","cmdbModel","cmdbModel");
        cfg.getPoClassFile().addListProperty(CmdbObjAttribute.class,"cmdbObjAttributeList","cmdbObjAttributeList","cmdbObjAttributeList");
        cfg.getPoClassFile().addSimpleProperty(CmdbModelV.class,"cmdbModelVParent","cmdbModelVParent","cmdbModelVParent");


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CMDB_MODEL_V_H.NAME,
                        OpsTables.OPS_CMDB_MODEL_V_H.NOTES,
                }
        );

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.V_STATUS).form().validate().required().form().
                radioBox().defaultIndex(0).enumType(StatusEnableEnum.class);

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.NAME).basic().search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.NAME).form().validate().required().form().textInput();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.NOTES).basic().search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.NOTES).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.DESC).form().textArea().height(Config.textAreaHeight_60);


        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.BS1).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.BS2).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.BS3).form().textArea().height(Config.textAreaHeight_60);

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.DA1).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.DA2).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V_H.DA3).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V_H.V_STATUS,
                },
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V_H.V_VERSION,
                }
        );

        cfg.view().form().addGroup("对象描述",
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V_H.NAME,
                        OpsTables.OPS_CMDB_MODEL_V_H.DESC,
                        OpsTables.OPS_CMDB_MODEL_V_H.NOTES,
                }
        );
        cfg.view().form().addGroup("对象数据",
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V_H.S1,
                        OpsTables.OPS_CMDB_MODEL_V_H.S2,
                        OpsTables.OPS_CMDB_MODEL_V_H.S3,
                        OpsTables.OPS_CMDB_MODEL_V_H.S4,
                        OpsTables.OPS_CMDB_MODEL_V_H.S5,
                        OpsTables.OPS_CMDB_MODEL_V_H.S6,
                        OpsTables.OPS_CMDB_MODEL_V_H.S7,
                        OpsTables.OPS_CMDB_MODEL_V_H.S8,

                        OpsTables.OPS_CMDB_MODEL_V_H.M1,
                        OpsTables.OPS_CMDB_MODEL_V_H.M2,
                        OpsTables.OPS_CMDB_MODEL_V_H.M3,
                        OpsTables.OPS_CMDB_MODEL_V_H.M4,
                        OpsTables.OPS_CMDB_MODEL_V_H.M5,
                        OpsTables.OPS_CMDB_MODEL_V_H.M6,
                        OpsTables.OPS_CMDB_MODEL_V_H.M7,
                        OpsTables.OPS_CMDB_MODEL_V_H.M8,
                        OpsTables.OPS_CMDB_MODEL_V_H.M9,
                        OpsTables.OPS_CMDB_MODEL_V_H.M10,

                        OpsTables.OPS_CMDB_MODEL_V_H.I1,
                        OpsTables.OPS_CMDB_MODEL_V_H.I2,
                        OpsTables.OPS_CMDB_MODEL_V_H.I3,
                        OpsTables.OPS_CMDB_MODEL_V_H.I4,
                        OpsTables.OPS_CMDB_MODEL_V_H.I5,
                        OpsTables.OPS_CMDB_MODEL_V_H.I6,
                        OpsTables.OPS_CMDB_MODEL_V_H.I7,
                        OpsTables.OPS_CMDB_MODEL_V_H.I8,
                        OpsTables.OPS_CMDB_MODEL_V_H.I9,
                        OpsTables.OPS_CMDB_MODEL_V_H.I10,

                        OpsTables.OPS_CMDB_MODEL_V_H.D1,
                        OpsTables.OPS_CMDB_MODEL_V_H.D2,
                        OpsTables.OPS_CMDB_MODEL_V_H.D3,
                        OpsTables.OPS_CMDB_MODEL_V_H.D4,
                        OpsTables.OPS_CMDB_MODEL_V_H.D5,
                        OpsTables.OPS_CMDB_MODEL_V_H.D6,
                        OpsTables.OPS_CMDB_MODEL_V_H.D7,
                        OpsTables.OPS_CMDB_MODEL_V_H.D8,

                        OpsTables.OPS_CMDB_MODEL_V_H.DA1,
                        OpsTables.OPS_CMDB_MODEL_V_H.DA2,
                        OpsTables.OPS_CMDB_MODEL_V_H.DA3,

                        OpsTables.OPS_CMDB_MODEL_V_H.BS1,
                        OpsTables.OPS_CMDB_MODEL_V_H.BS2,
                        OpsTables.OPS_CMDB_MODEL_V_H.BS3,


                }
        );

        cfg.view().list().addJsVariable("MODEL_ID","[[${modelId}]]","modelId");
        cfg.view().form().addJsVariable("MODEL_ID","[[${modelId}]]","modelId");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CmdbModelValueHistoryGtr g=new CmdbModelValueHistoryGtr();
        //生成代码
        g.generateCode();
    //    g.generateMenu(CmdbModelVHServiceProxy.class, CmdbModelVHPageController.class);
        //移除之前生成的菜单，视情况执行
    //      g.generateMenu(SoftwareBaseVersionServiceProxy.class, SoftwareBaseVersionPageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
