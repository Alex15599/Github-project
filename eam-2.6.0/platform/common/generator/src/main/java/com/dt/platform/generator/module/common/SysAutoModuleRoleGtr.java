package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.AutoModuleRolePageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.AutoModuleEnum;
import com.dt.platform.constants.enums.common.AutoModuleRoleTypeEnum;
import com.dt.platform.constants.enums.common.BackupStatusEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.AutoModuleRoleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysAutoModuleRoleGtr extends BaseCodeGenerator {

    public SysAutoModuleRoleGtr() {
        super(SysTables.SYS_AUTO_MODULE_ROLE.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_AUTO_MODULE_ROLE.STATUS,
                        SysTables.SYS_AUTO_MODULE_ROLE.TYPE,
                        SysTables.SYS_AUTO_MODULE_ROLE.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE.TYPE).form().validate().required().form().radioBox().enumType(AutoModuleRoleTypeEnum.class);
        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE.MODULE).form().validate().required().form().selectBox().enumType(AutoModuleEnum.class);
        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE.NAME).form().validate().required();


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_AUTO_MODULE_ROLE.STATUS,
                        SysTables.SYS_AUTO_MODULE_ROLE.TYPE,
                        SysTables.SYS_AUTO_MODULE_ROLE.MODULE,
                        SysTables.SYS_AUTO_MODULE_ROLE.NAME,
                }
        );
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();


        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysAutoModuleRoleGtr g=new SysAutoModuleRoleGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AutoModuleRoleServiceProxy.class, AutoModuleRolePageController.class);
    }

}
