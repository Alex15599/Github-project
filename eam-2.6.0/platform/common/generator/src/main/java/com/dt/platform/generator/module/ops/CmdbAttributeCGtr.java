package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsCmdbAttributeTypeEnum;
import com.dt.platform.domain.ops.CmdbAttributeC;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.CmdbAttributeCPageController;
import com.dt.platform.proxy.ops.CmdbAttributeCServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CmdbAttributeCGtr extends BaseCodeGenerator{


    public CmdbAttributeCGtr() {
        super(OpsTables.OPS_CMDB_ATTRIBUTE_C.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CMDB_ATTRIBUTE_C.TYPE,
                        OpsTables.OPS_CMDB_ATTRIBUTE_C.NAME,
                }
        );

        cfg.view().field(OpsTables.OPS_CMDB_ATTRIBUTE_C.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CMDB_ATTRIBUTE_C.NAME).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_CMDB_ATTRIBUTE_C.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_CMDB_ATTRIBUTE_C.CODE).form().validate().required();

        cfg.view().field(OpsTables.OPS_CMDB_ATTRIBUTE_C.TYPE).form().validate().required().form().
                radioBox().defaultIndex(0).enumType(OpsCmdbAttributeTypeEnum.class);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CMDB_ATTRIBUTE_C.CODE,
                        OpsTables.OPS_CMDB_ATTRIBUTE_C.NAME,
                        OpsTables.OPS_CMDB_ATTRIBUTE_C.TYPE,
                        OpsTables.OPS_CMDB_ATTRIBUTE_C.SORT,
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
        CmdbAttributeCGtr g=new CmdbAttributeCGtr();
        //生成代码
        g.generateCode();
     //   g.generateMenu(CmdbAttributeCServiceProxy.class, CmdbAttributeCPageController.class);
        //移除之前生成的菜单，视情况执行
    //      g.generateMenu(SoftwareBaseVersionServiceProxy.class, SoftwareBaseVersionPageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
