package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.SoftwareBaseVersionStatusEnum;
import com.dt.platform.domain.ops.SoftwareBaseType;
import com.dt.platform.domain.ops.meta.SafetyBaselineMeta;
import com.dt.platform.domain.ops.meta.SoftwareBaseTypeMeta;
import com.dt.platform.domain.ops.meta.SoftwareBaseVersionMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.SafetyBaselinePageController;
import com.dt.platform.proxy.ops.SafetyBaselineServiceProxy;
import com.dt.platform.proxy.ops.SoftwareBaseTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SoftwareSafetyBaseLineGtr extends BaseCodeGenerator{


    public SoftwareSafetyBaseLineGtr() {
        super(OpsTables.OPS_SAFETY_BASELINE.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(SoftwareBaseType.class,"baseType","baseType","baseType");

        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SAFETY_BASELINE.BASE_TYPE_ID,
                        OpsTables.OPS_SAFETY_BASELINE.STATUS,
                        OpsTables.OPS_SAFETY_BASELINE.NAME,
                }
        );

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.ID).basic().hidden(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.NOTES).table().disable(true);
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.FILE_ID).table().hidden(true);
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.CHECK_FILE_ID).table().hidden(true);
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.CREATE_TIME).table().hidden(true);

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.STATUS).form().validate().required().form()
                .radioBox().enumType(SoftwareBaseVersionStatusEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.BASE_TYPE_ID).form().validate().required()
                .form().selectBox().queryApi(SoftwareBaseTypeServiceProxy.QUERY_LIST)
                .valueField(SoftwareBaseTypeMeta.ID).textField(SoftwareBaseTypeMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(SafetyBaselineMeta.BASE_TYPE).muliti(false).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.FILE_ID).form().upload().acceptSingleFile().acceptAllType().maxFileCount(1);
        cfg.view().field(OpsTables.OPS_SAFETY_BASELINE.CHECK_FILE_ID).form().upload().acceptSingleFile().acceptAllType().maxFileCount(1);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SAFETY_BASELINE.NAME,
                        OpsTables.OPS_SAFETY_BASELINE.BASE_VERSION,
                        OpsTables.OPS_SAFETY_BASELINE.FILE_ID,

                },
                new Object[] {
                      OpsTables.OPS_SAFETY_BASELINE.BASE_TYPE_ID,
                        OpsTables.OPS_SAFETY_BASELINE.STATUS,
                        OpsTables.OPS_SAFETY_BASELINE.CHECK_FILE_ID


                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SAFETY_BASELINE.USAGE_SCENARIOS,


                        OpsTables.OPS_SAFETY_BASELINE.NOTES,
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
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SoftwareSafetyBaseLineGtr g=new SoftwareSafetyBaseLineGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
      //   g.generateMenu(SafetyBaselineServiceProxy.class, SafetyBaselinePageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
