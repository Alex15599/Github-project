package com.dt.platform.generator.module.mobile;

import com.dt.platform.constants.db.MobileTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.mobile.SoftwareGroup;
import com.dt.platform.domain.mobile.SoftwareInfo;
import com.dt.platform.domain.mobile.meta.ModuleGroupMeta;
import com.dt.platform.domain.mobile.meta.ModuleInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.mobile.page.SoftwareGroupPageController;
import com.dt.platform.proxy.mobile.ModuleGroupServiceProxy;
import com.dt.platform.proxy.mobile.SoftwareGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AppSoftwareGroupGtr extends BaseCodeGenerator {


    public AppSoftwareGroupGtr() {
        super(MobileTables.APP_SOFTWARE_GROUP.$TABLE,"593340389855854592");
    }
    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(MobileTables.APP_SOFTWARE_GROUP.ID).basic().hidden(true);
        cfg.view().field(MobileTables.APP_SOFTWARE_GROUP.NAME).search().fuzzySearch();
        cfg.view().field(MobileTables.APP_SOFTWARE_GROUP.CODE).search().fuzzySearch();

        cfg.getPoClassFile().addListProperty(SoftwareInfo.class,"softwareInfoList","softwareInfoList","softwareInfoList");


        cfg.view().search().inputLayout(
                new Object[]{
                        MobileTables.APP_SOFTWARE_GROUP.CODE,
                        MobileTables.APP_SOFTWARE_GROUP.NAME,
                }
        );

        cfg.view().field(MobileTables.APP_SOFTWARE_GROUP.NAME).form().validate().required();
        cfg.view().field(MobileTables.APP_SOFTWARE_GROUP.CODE).form().validate().required();
        cfg.view().field(MobileTables.APP_SOFTWARE_GROUP.NOTES).form().textArea().height(50);

        cfg.view().formWindow().width("75%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[]{
                        MobileTables.APP_SOFTWARE_GROUP.NAME,
                },
                new Object[]{
                        MobileTables.APP_SOFTWARE_GROUP.CODE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        MobileTables.APP_SOFTWARE_GROUP.NOTES,
                }
        );

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AppSoftwareGroupGtr g=new AppSoftwareGroupGtr();
        //生成代码
        g.generateCode();
       // g.generateMenu(SoftwareGroupServiceProxy.class, SoftwareGroupPageController.class);
        //生成菜单

    }

}
