package com.dt.platform.generator.module.mobile;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.MobileTables;

//import com.dt.platform.domain.workorder.ModuleGroup;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.mobile.ModuleGroup;
import com.dt.platform.domain.mobile.ModuleInfo;
import com.dt.platform.domain.mobile.meta.ModuleGroupMeta;
import com.dt.platform.domain.mobile.meta.ModuleInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.mobile.page.ModuleInfoPageController;
import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.dt.platform.proxy.mobile.ModuleGroupServiceProxy;
import com.dt.platform.proxy.mobile.ModuleInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AppModuleInfoGtr extends BaseCodeGenerator {


    public AppModuleInfoGtr() {
        super(MobileTables.APP_MODULE_INFO.$TABLE,BASIC_MOBILE);
    }
    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(MobileTables.APP_MODULE_INFO.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(ModuleGroup.class,"moduleGroup","组","组");
        cfg.view().search().inputLayout(
                new Object[]{
                        MobileTables.APP_MODULE_INFO.GROUP_ID,
                        MobileTables.APP_MODULE_INFO.STATUS,
                        MobileTables.APP_MODULE_INFO.NAME
                }
        );

        cfg.view().field(MobileTables.APP_MODULE_INFO.STATUS).form().validate().required().form()
                .radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(MobileTables.APP_MODULE_INFO.PATH).form().validate().required();

        cfg.view().field(MobileTables.APP_MODULE_INFO.GROUP_ID).form().validate().required()
                .form().selectBox().queryApi(ModuleGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(ModuleGroupMeta.ID).
                textField(ModuleGroupMeta.NAME).
                fillWith(ModuleInfoMeta.MODULE_GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(MobileTables.APP_MODULE_INFO.NAME).form().validate().required();
        cfg.view().field(MobileTables.APP_MODULE_INFO.LABEL).form().validate().required();

        cfg.view().field(MobileTables.APP_MODULE_INFO.CODE).form().validate().required();

        cfg.view().field(MobileTables.APP_MODULE_INFO.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[]{
                        MobileTables.APP_MODULE_INFO.CODE,
                        MobileTables.APP_MODULE_INFO.LABEL,
                        MobileTables.APP_MODULE_INFO.GROUP_ID,
                        MobileTables.APP_MODULE_INFO.STATUS,
                },
                new Object[]{
                        MobileTables.APP_MODULE_INFO.PATH,
                        MobileTables.APP_MODULE_INFO.NAME,
                        MobileTables.APP_MODULE_INFO.SORT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        MobileTables.APP_MODULE_INFO.NOTES
                }
        );


        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AppModuleInfoGtr g=new AppModuleInfoGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
        // g.generateMenu(ModuleInfoServiceProxy.class, ModuleInfoPageController.class);
        //生成菜单

    }

}
