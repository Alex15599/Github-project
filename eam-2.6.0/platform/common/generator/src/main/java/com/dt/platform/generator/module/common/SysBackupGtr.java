package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.BackupDbPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.BackupStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.common.BackupDb;
import com.dt.platform.domain.common.meta.BackupDbMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.ops.meta.DbBackupInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.BackupDbServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.storage.meta.FileMeta;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;

public class SysBackupGtr extends BaseCodeGenerator {

    public SysBackupGtr() {
        super(SysTables.SYS_BACKUP_DB.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_BACKUP_DB.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_BACKUP_DB.NOTES).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_BACKUP_DB.CREATE_TIME).search().range();


//        cfg.view().field(SysTables.SYS_BACKUP_DB.FILE_ID)
//                .form().selectBox().queryApi(FileServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
//                .valueField(MenuMeta.ID).textField(FileMeta.ID).fillWith(BackupDbMeta.FILE).muliti(false);


        cfg.view().field(SysTables.SYS_BACKUP_DB.STATUS).form().radioBox().enumType(BackupStatusEnum.class);
        cfg.view().field(SysTables.SYS_BACKUP_DB.CONTENT).form().textArea().height(120);
        cfg.view().field(SysTables.SYS_BACKUP_DB.NOTES).form().textArea().height(120);
        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_BACKUP_DB.STATUS,
                        SysTables.SYS_BACKUP_DB.CREATE_TIME,
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
                        SysTables.SYS_BACKUP_DB.DB_NAME,
                        SysTables.SYS_BACKUP_DB.STATUS,
                        SysTables.SYS_BACKUP_DB.FILE_ROUTE,
                        SysTables.SYS_BACKUP_DB.CONTENT,
                        SysTables.SYS_BACKUP_DB.START_TIME ,
                        SysTables.SYS_BACKUP_DB.END_TIME ,
                        SysTables.SYS_BACKUP_DB.INVALID_TIME ,
                        SysTables.SYS_BACKUP_DB.CREATE_TIME,
                        SysTables.SYS_BACKUP_DB.NOTES,
                }
        );


        cfg.view().list().addToolButton("执行备份","executeBackup","execute-backup","sys_backup_db:bakcup");
        cfg.view().list().operationColumn().addActionButton("下载","downFile","down-file","sys_backup_db:down-file");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysBackupGtr g=new SysBackupGtr();

        //生成代码
        g.generateCode();
        //生成菜单
      //  g.generateMenu(BackupDbServiceProxy.class, BackupDbPageController.class);
    }

}
