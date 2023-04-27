package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.AutoRoleGrantRcdPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.AutoModuleIDEnum;
import com.dt.platform.domain.common.AutoRoleGrantRcd;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.AutoRoleGrantRcdServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class SysAutoRoleRcdGtr extends BaseCodeGenerator {

    public SysAutoRoleRcdGtr() {
        super(SysTables.SYS_AUTO_ROLE_GRANT_RCD.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_AUTO_ROLE_GRANT_RCD.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_AUTO_ROLE_GRANT_RCD.CREATE_TIME).search().range();


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","人员","人员");
        cfg.view().search().inputLayout(
                new Object[] {
                        SysTables.SYS_AUTO_ROLE_GRANT_RCD.MODULE_ROLE_ID,
                        SysTables.SYS_AUTO_ROLE_GRANT_RCD.USER_ID,
                },
                new Object[] {
                        SysTables.SYS_AUTO_ROLE_GRANT_RCD.CREATE_TIME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_AUTO_ROLE_GRANT_RCD.MODULE_ROLE_ID).form().selectBox().enumType(AutoModuleIDEnum.class);

        cfg.view().field(SysTables.SYS_AUTO_ROLE_GRANT_RCD.USER_ID).table().fillBy("user","name");
        cfg.view().field(SysTables.SYS_AUTO_ROLE_GRANT_RCD.USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().formWindow().bottomSpace(250);
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_AUTO_ROLE_GRANT_RCD.MODULE_ROLE_ID,
                        SysTables.SYS_AUTO_ROLE_GRANT_RCD.USER_ID,
                }
        );

        cfg.view().search().rowsDisplay(1);
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableBatchDelete();
       // cfg.view().list().disableSingleDelete();
        cfg.view().list().disableModify();

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
        SysAutoRoleRcdGtr g=new SysAutoRoleRcdGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AutoRoleGrantRcdServiceProxy.class, AutoRoleGrantRcdPageController.class);
    }

}
