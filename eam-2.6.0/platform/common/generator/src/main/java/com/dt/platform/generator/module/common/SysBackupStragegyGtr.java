package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.BackupDbStrategyPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.BackupStatusEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.BackupDbStrategy;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.BackupDbStrategyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.storage.meta.FileMeta;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;

public class SysBackupStragegyGtr extends BaseCodeGenerator {

    public SysBackupStragegyGtr() {
        super(SysTables.SYS_BACKUP_DB_STRATEGY.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_BACKUP_DB.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_BACKUP_DB.NOTES).search().fuzzySearch();


        cfg.view().field(SysTables.SYS_BACKUP_DB_STRATEGY.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(SysTables.SYS_BACKUP_DB_STRATEGY.DATA_PATH).form().validate().required();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_BACKUP_DB_STRATEGY.STATUS,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(250);
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_BACKUP_DB_STRATEGY.STATUS,
                        SysTables.SYS_BACKUP_DB_STRATEGY.DATA_PATH,
                        SysTables.SYS_BACKUP_DB_STRATEGY.DATA_KEEP,
                        SysTables.SYS_BACKUP_DB_STRATEGY.NOTES
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysBackupStragegyGtr g=new SysBackupStragegyGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(BackupDbStrategyServiceProxy.class, BackupDbStrategyPageController.class);
    }

}
