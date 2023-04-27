package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.MonitorEnableEnum;
import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.SoftwareBaseType;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.domain.ops.meta.MonitorTplTypeMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.SoftwareBaseTypePageController;
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.dt.platform.proxy.ops.SoftwareBaseTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SoftwareBaseTypeGtr extends BaseCodeGenerator{


    public SoftwareBaseTypeGtr() {
        super(OpsTables.OPS_SOFTWARE_BASE_TYPE.$TABLE,"593811567112364032");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SOFTWARE_BASE_TYPE.NAME,

                }
        );
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.ID).table().disable(true);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.NOTES).form().textArea().height(Config.textAreaHeight);



        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SOFTWARE_BASE_TYPE.NAME,
                        OpsTables.OPS_SOFTWARE_BASE_TYPE.NOTES,
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
        SoftwareBaseTypeGtr g=new SoftwareBaseTypeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
     //   g.generateMenu(SoftwareBaseTypeServiceProxy.class, SoftwareBaseTypePageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
