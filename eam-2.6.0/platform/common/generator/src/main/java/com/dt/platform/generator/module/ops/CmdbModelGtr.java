package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.*;
import com.dt.platform.domain.ops.*;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class CmdbModelGtr extends BaseCodeGenerator{


    public CmdbModelGtr() {
        super(OpsTables.OPS_CMDB_MODEL.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CMDB_MODEL.NAME,
                }
        );

        cfg.view().field(OpsTables.OPS_CMDB_MODEL.ID).basic().hidden(true);

        //当前属性
        cfg.getPoClassFile().addListProperty(CmdbObjAttribute.class,"cmdbObjAttributeList","cmdbObjAttributeList","cmdbObjAttribute");
        //当前Value
        cfg.getPoClassFile().addListProperty(CmdbModelV.class,"cmdbModelVList","cmdbModelVList","cmdbModelVList");

        // 父节点属性
        cfg.getPoClassFile().addListProperty(CmdbObjAttribute.class,"cmdbObjAttributeParentList","cmdbObjAttributeParentList","cmdbObjAttributeParentList");
       // 父节点元数据
        cfg.getPoClassFile().addSimpleProperty(CmdbModel.class,"cmdbModelParent","cmdbModelParent","cmdbModelParent");


        cfg.view().list().disableBatchDelete();

        cfg.view().field(OpsTables.OPS_CMDB_MODEL.CODE).form().validate().required();


        cfg.view().field(OpsTables.OPS_CMDB_MODEL.STATUS).form().validate().required().form().
                radioBox().defaultIndex(0).enumType(StatusEnableEnum.class);

        cfg.view().field(OpsTables.OPS_CMDB_MODEL.SOURCE_TYPE).form().validate().required().form().
                radioBox().defaultIndex(0).enumType(OpsCmdbSourceTypeEnum.class);

        cfg.view().field(OpsTables.OPS_CMDB_MODEL.DATA_SOURCE).form().validate().required().form().
                selectBox().defaultIndex(0).enumType(OpsCmdbDataFetchTypeEnum.class);

//        cfg.view().field(OpsTables.OPS_CMDB_MODEL.ASSOCIATION_TYPE).form().validate().required().form().
//                selectBox().defaultIndex(0).enumType(OpsCmdbAssociationTypeEnum.class);


        cfg.view().field(OpsTables.OPS_CMDB_MODEL.STORAGE_TYPE).form().validate().required().form().
                radioBox().defaultIndex(0).enumType(OpsCmdbStorageTypeEnum.class);

        cfg.view().field(OpsTables.OPS_CMDB_MODEL.HIERARCHY_NAME).form().readOnly();

        cfg.view().field(OpsTables.OPS_CMDB_MODEL.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL.FULL_NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_CMDB_MODEL.NOTES).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().field(OpsTables.OPS_CMDB_MODEL.SOURCE).form().textArea().height(Config.textAreaHeight_60);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL.CODE,
                        OpsTables.OPS_CMDB_MODEL.NAME,
                        OpsTables.OPS_CMDB_MODEL.FULL_NAME,
                        OpsTables.OPS_CMDB_MODEL.STATUS,
                },
                new Object[] {

                        OpsTables.OPS_CMDB_MODEL.SOURCE_TYPE,
                        OpsTables.OPS_CMDB_MODEL.STORAGE_TYPE,
                        OpsTables.OPS_CMDB_MODEL.DATA_SOURCE,
//                        OpsTables.OPS_CMDB_MODEL.ASSOCIATION_TYPE,
//                        OpsTables.OPS_CMDB_MODEL.RELATION_CODE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_MODEL.SOURCE,
                        OpsTables.OPS_CMDB_MODEL.NOTES
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.WRITE_TEMP_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.WRITE_TEMP_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CmdbModelGtr g=new CmdbModelGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
          //g.generateMenu(CmdbModelServiceProxy.class, CmdbModelPageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
