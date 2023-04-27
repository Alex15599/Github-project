package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.AutoModuleRoleItemPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.AutoModuleEnum;
import com.dt.platform.constants.enums.common.AutoModuleIDEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.AutoModuleRoleItemServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysAutoModuleRoleItemGtr extends BaseCodeGenerator {

    public SysAutoModuleRoleItemGtr() {
        super(SysTables.SYS_AUTO_MODULE_ROLE_ITEM.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE_ITEM.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE_ITEM.CREATE_TIME).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_AUTO_MODULE_ROLE_ITEM.ROLE_ID,
                        SysTables.SYS_AUTO_MODULE_ROLE_ITEM.MODULE_ROLE_ID,
                        SysTables.SYS_AUTO_MODULE_ROLE_ITEM.ROLE_NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE_ITEM.MODULE_ROLE_ID).form().validate().required().form().selectBox().enumType(AutoModuleIDEnum.class);
        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE_ITEM.ROLE_NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_AUTO_MODULE_ROLE_ITEM.ROLE_ID).form().validate().required();

        cfg.view().formWindow().bottomSpace(250);
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_AUTO_MODULE_ROLE_ITEM.ROLE_ID,
                        SysTables.SYS_AUTO_MODULE_ROLE_ITEM.ROLE_NAME,
                        SysTables.SYS_AUTO_MODULE_ROLE_ITEM.MODULE_ROLE_ID,
                }
        );


        cfg.view().list().disableBatchDelete();
       // cfg.view().list().disableSingleDelete();


        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysAutoModuleRoleItemGtr g=new SysAutoModuleRoleItemGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AutoModuleRoleItemServiceProxy.class, AutoModuleRoleItemPageController.class);
    }

}
