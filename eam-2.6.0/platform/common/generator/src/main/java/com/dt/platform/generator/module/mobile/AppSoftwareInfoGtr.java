package com.dt.platform.generator.module.mobile;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.MobileTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.mobile.SoftwareTypeEnum;
import com.dt.platform.domain.mobile.ModuleGroup;
import com.dt.platform.domain.mobile.SoftwareGroup;
import com.dt.platform.domain.mobile.meta.ModuleGroupMeta;
import com.dt.platform.domain.mobile.meta.ModuleInfoMeta;
import com.dt.platform.domain.mobile.meta.SoftwareGroupMeta;
import com.dt.platform.domain.mobile.meta.SoftwareInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.mobile.page.SoftwareInfoPageController;
import com.dt.platform.proxy.mobile.ModuleGroupServiceProxy;
import com.dt.platform.proxy.mobile.SoftwareGroupServiceProxy;
import com.dt.platform.proxy.mobile.SoftwareInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;

public class AppSoftwareInfoGtr extends BaseCodeGenerator {


    public AppSoftwareInfoGtr() {
        super(MobileTables.APP_SOFTWARE_INFO.$TABLE,"593340389855854592");
    }
    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(SoftwareGroup.class,"group","组","组");

        cfg.view().search().inputLayout(
                new Object[]{
                        MobileTables.APP_SOFTWARE_INFO.GROUP_ID,
                        MobileTables.APP_SOFTWARE_INFO.STATUS,
                        MobileTables.APP_SOFTWARE_INFO.NAME
                }
        );

        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.STATUS).form().validate().required().form()
                .selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.TYPE).form().validate().required().form()
                .selectBox().enumType(SoftwareTypeEnum.class).defaultIndex(0);

        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.GROUP_ID).form().validate().required()
                .form().selectBox().queryApi(SoftwareGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(SoftwareGroupMeta.ID).
                textField(SoftwareGroupMeta.NAME).
                fillWith(SoftwareInfoMeta.GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.NAME).form().validate().required();
        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.SOFTWARE_VERSION).form().validate().required();
        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.CODE).form().validate().required();


        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.FILE_ID)
                .form().label("软件").upload().buttonLabel("选择软件").acceptSingleFile().maxFileCount(1).acceptAllType().displayFileName(false);

        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.PICTURE_ID).table().disable();
        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.CREATE_TIME).table().disable();
        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.FILE_ID).table().disable();

        cfg.view().field(MobileTables.APP_SOFTWARE_INFO.NOTES).form().textArea().height(50);

        cfg.view().formWindow().width("75%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[]{
                        MobileTables.APP_SOFTWARE_INFO.NAME,
                        MobileTables.APP_SOFTWARE_INFO.TYPE,
                        MobileTables.APP_SOFTWARE_INFO.SOFTWARE_VERSION,
                },
                new Object[]{
                        MobileTables.APP_SOFTWARE_INFO.CODE,
                        MobileTables.APP_SOFTWARE_INFO.STATUS,
                        MobileTables.APP_SOFTWARE_INFO.GROUP_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                  //      MobileTables.APP_SOFTWARE_INFO.PICTURE_ID,
                        MobileTables.APP_SOFTWARE_INFO.FILE_ID,
                        MobileTables.APP_SOFTWARE_INFO.NOTES,
                }
        );
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AppSoftwareInfoGtr g=new AppSoftwareInfoGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
   //      g.generateMenu(SoftwareInfoServiceProxy.class, SoftwareInfoPageController.class);
        //生成菜单

    }

}
