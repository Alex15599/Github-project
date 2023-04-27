package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.constants.enums.ops.MonitorEnableEnum;
import com.dt.platform.constants.enums.ops.SoftwareBaseVersionStatusEnum;
import com.dt.platform.domain.mobile.meta.SoftwareInfoMeta;
import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.SoftwareBaseType;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.SoftwareBaseVersionPageController;
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.dt.platform.proxy.ops.SoftwareBaseTypeServiceProxy;
import com.dt.platform.proxy.ops.SoftwareBaseVersionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class SoftwareBaseLineGtr extends BaseCodeGenerator{


    public SoftwareBaseLineGtr() {
        super(OpsTables.OPS_SOFTWARE_BASE_VERSION.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(SoftwareBaseType.class,"softwareBaseType","softwareBaseType","softwareBaseType");

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.SOFTWARE_VERSION).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.STATUS,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.SOFTWARE_TYPE_ID,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.NAME,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.SOFTWARE_VERSION,
                }
        );

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.ID).basic().hidden(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.NOTES).table().disable(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.FILE_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.CREATE_TIME).table().disable(true);

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.STATUS).form().validate().required().form()
                .selectBox().enumType(SoftwareBaseVersionStatusEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.SOFTWARE_VERSION).form().validate().required();
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.NOTES).form().textArea().height(50);
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.USAGE_SCENARIOS).form().textArea().height(50);


        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.SOFTWARE_TYPE_ID).form().validate().required()
                .form().selectBox().queryApi(SoftwareBaseTypeServiceProxy.QUERY_LIST)
                .valueField(SoftwareBaseTypeMeta.ID).textField(SoftwareBaseTypeMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(SoftwareBaseVersionMeta.SOFTWARE_BASE_TYPE).muliti(false).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_VERSION.FILE_ID).form().upload().acceptSingleFile().acceptAllType().maxFileCount(1);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.NAME,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.SOFTWARE_VERSION,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.PATCH_INFO,
                },
                new Object[] {
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.STATUS,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.SOFTWARE_TYPE_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.USAGE_SCENARIOS,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.NOTES,
                        OpsTables.OPS_SOFTWARE_BASE_VERSION.FILE_ID,
                }
        );


        cfg.view().form().addJsVariable("BASE_TYPE_ID","[[${baseTypeId}]]","baseTypeId");


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
        SoftwareBaseLineGtr g=new SoftwareBaseLineGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
    //      g.generateMenu(SoftwareBaseVersionServiceProxy.class, SoftwareBaseVersionPageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
