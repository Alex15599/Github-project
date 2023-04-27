package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.generator.config.Config;

import com.github.foxnic.generator.config.WriteMode;

public class CmdbModelValueGtr extends BaseCodeGenerator{


    public CmdbModelValueGtr() {
        super(OpsTables.OPS_CMDB_MODEL_V.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(CmdbModel.class,"cmdbModel","cmdbModel","cmdbModel");
        cfg.getPoClassFile().addListProperty(CmdbObjAttribute.class,"cmdbObjAttributeList","cmdbObjAttributeList","cmdbObjAttributeList");
        cfg.getPoClassFile().addSimpleProperty(CmdbModelV.class,"cmdbModelVParent","cmdbModelVParent","cmdbModelVParent");


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CMDB_MODEL_V.NAME,
                        OpsTables.OPS_CMDB_MODEL_V.NOTES,
                }
        );

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.V_STATUS).form().validate().required().form().
                radioBox().defaultIndex(0).enumType(StatusEnableEnum.class);

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.NAME).basic().search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.NAME).form().validate().required().form().textInput();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.NOTES).basic().search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.NOTES).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.DESC).form().textArea().height(Config.textAreaHeight_60);


        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.BS1).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.BS2).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.BS3).form().textArea().height(Config.textAreaHeight_60);

        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.DA1).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.DA2).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL_V.DA3).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V.V_STATUS,
                },
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V.V_VERSION,
                }
        );

        cfg.view().form().addGroup("对象描述",
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V.NAME,
                        OpsTables.OPS_CMDB_MODEL_V.DESC,
                        OpsTables.OPS_CMDB_MODEL_V.NOTES,
                }
        );
        cfg.view().form().addGroup("对象数据",
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL_V.S1,
                        OpsTables.OPS_CMDB_MODEL_V.S2,
                        OpsTables.OPS_CMDB_MODEL_V.S3,
                        OpsTables.OPS_CMDB_MODEL_V.S4,
                        OpsTables.OPS_CMDB_MODEL_V.S5,
                        OpsTables.OPS_CMDB_MODEL_V.S6,
                        OpsTables.OPS_CMDB_MODEL_V.S7,
                        OpsTables.OPS_CMDB_MODEL_V.S8,

                        OpsTables.OPS_CMDB_MODEL_V.M1,
                        OpsTables.OPS_CMDB_MODEL_V.M2,
                        OpsTables.OPS_CMDB_MODEL_V.M3,
                        OpsTables.OPS_CMDB_MODEL_V.M4,
                        OpsTables.OPS_CMDB_MODEL_V.M5,
                        OpsTables.OPS_CMDB_MODEL_V.M6,
                        OpsTables.OPS_CMDB_MODEL_V.M7,
                        OpsTables.OPS_CMDB_MODEL_V.M8,
                        OpsTables.OPS_CMDB_MODEL_V.M9,
                        OpsTables.OPS_CMDB_MODEL_V.M10,

                        OpsTables.OPS_CMDB_MODEL_V.I1,
                        OpsTables.OPS_CMDB_MODEL_V.I2,
                        OpsTables.OPS_CMDB_MODEL_V.I3,
                        OpsTables.OPS_CMDB_MODEL_V.I4,
                        OpsTables.OPS_CMDB_MODEL_V.I5,
                        OpsTables.OPS_CMDB_MODEL_V.I6,
                        OpsTables.OPS_CMDB_MODEL_V.I7,
                        OpsTables.OPS_CMDB_MODEL_V.I8,
                        OpsTables.OPS_CMDB_MODEL_V.I9,
                        OpsTables.OPS_CMDB_MODEL_V.I10,

                        OpsTables.OPS_CMDB_MODEL_V.D1,
                        OpsTables.OPS_CMDB_MODEL_V.D2,
                        OpsTables.OPS_CMDB_MODEL_V.D3,
                        OpsTables.OPS_CMDB_MODEL_V.D4,
                        OpsTables.OPS_CMDB_MODEL_V.D5,
                        OpsTables.OPS_CMDB_MODEL_V.D6,
                        OpsTables.OPS_CMDB_MODEL_V.D7,
                        OpsTables.OPS_CMDB_MODEL_V.D8,

                        OpsTables.OPS_CMDB_MODEL_V.DA1,
                        OpsTables.OPS_CMDB_MODEL_V.DA2,
                        OpsTables.OPS_CMDB_MODEL_V.DA3,

                        OpsTables.OPS_CMDB_MODEL_V.BS1,
                        OpsTables.OPS_CMDB_MODEL_V.BS2,
                        OpsTables.OPS_CMDB_MODEL_V.BS3,


                }
        );

        cfg.view().list().addJsVariable("MODEL_ID","[[${modelId}]]","modelId");
        cfg.view().form().addJsVariable("MODEL_ID","[[${modelId}]]","modelId");

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
        CmdbModelValueGtr g=new CmdbModelValueGtr();
        //生成代码
        g.generateCode();
   //     g.generateMenu(CmdbModelVServiceProxy.class, CmdbModelVPageController.class);
        //移除之前生成的菜单，视情况执行
    //      g.generateMenu(SoftwareBaseVersionServiceProxy.class, SoftwareBaseVersionPageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
