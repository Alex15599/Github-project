package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsCmdbAttributeTypeEnum;
import com.dt.platform.constants.enums.ops.OpsCmdbLogLevelEnum;
import com.dt.platform.constants.enums.ops.SoftwareBaseVersionStatusEnum;
import com.dt.platform.domain.ops.CmdbAttributeC;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.domain.ops.SoftwareBaseType;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.CmdbObjAttributePageController;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;

public class CmdbAttributeGtr extends BaseCodeGenerator{


    public CmdbAttributeGtr() {
        super(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(CmdbModel.class,"cmdbModel","cmdbModel","cmdbModel");
        cfg.getPoClassFile().addSimpleProperty(CmdbAttributeC.class,"cmdbAttributeC","cmdbAttributeC","cmdbAttributeC");


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.STATUS,
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_TYPE,
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_NAME,
                }
        );

        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ID).basic().hidden(true);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.STATUS).form().validate().required().form().
                radioBox().defaultIndex(0).enumType(StatusEnableEnum.class);


//        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_TYPE).form().validate().required().form().
//                radioBox().defaultIndex(0).enumType(OpsCmdbAttributeTypeEnum.class);

        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_NAME).form().validate().required().search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_COL_SOURCE).form().validate().required();
        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_COL_SHOW).form().validate().required();


        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_COL_FILL)
                .form().validate().required().form().selectBox().queryApi(CmdbAttributeCServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CmdbAttributeCVOMeta.CODE).textField(CmdbAttributeCVOMeta.NAME).
                fillWith(CmdbObjAttributeMeta.CMDB_ATTRIBUTE_C).muliti(false);

        cfg.view().field(OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.MODEL_ID)
                .form().selectBox().queryApi(CmdbModelServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CmdbModelMeta.ID).textField(CmdbModelMeta.NAME).
                fillWith(CmdbObjAttributeMeta.CMDB_MODEL).muliti(false);


        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_NAME,
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.STATUS,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_TYPE,
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_COL_SOURCE,
                },
                new Object[] {
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_COL_FILL,
                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.ATTRIBUTE_COL_SHOW,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {

                        OpsTables.OPS_CMDB_OBJ_ATTRIBUTE.NOTES,
                   }
               );

       // cfg.view().list().addToolButton("解析数据","parseData",null,"ops_cmdb_obj_attribute:parse_data");
        cfg.view().list().addJsVariable("MODEL_ID","[[${modelId}]]","modelId");
        cfg.view().form().addJsVariable("MODEL_ID","[[${modelId}]]","modelId");



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CmdbAttributeGtr g=new CmdbAttributeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       //   g.generateMenu(CmdbObjAttributeServiceProxy.class, CmdbObjAttributePageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
