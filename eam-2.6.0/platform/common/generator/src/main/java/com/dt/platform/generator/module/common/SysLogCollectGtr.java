package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.LogCollectPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.CollectStatusEnum;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.LogCollectServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;

public class SysLogCollectGtr extends BaseCodeGenerator {

    public SysLogCollectGtr() {
        super(SysTables.SYS_LOG_COLLECT.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(SysTables.SYS_LOG_COLLECT.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_LOG_COLLECT.CREATE_TIME).search().range();
        cfg.view().field(SysTables.SYS_LOG_COLLECT.STATUS).form().validate().required().form().radioBox().enumType(CollectStatusEnum.class).defaultIndex(0);
        cfg.view().field(SysTables.SYS_LOG_COLLECT.FILE_ID).form().validate().required().form().upload().maxFileCount(1);
        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_LOG_COLLECT.STATUS,
                        SysTables.SYS_LOG_COLLECT.CREATE_TIME
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
                        SysTables.SYS_LOG_COLLECT.STATUS,
                        SysTables.SYS_LOG_COLLECT.FILE_ID,
                        SysTables.SYS_LOG_COLLECT.NOTES
                }
        );

        cfg.view().list().disableCreateNew();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().addToolButton("收集日志","collectLog","collect-log","sys_log_collect:collect");
        cfg.view().list().operationColumn().addActionButton("下载","collectDownload","collect-download","sys_log_collect:download");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysLogCollectGtr g=new SysLogCollectGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(LogCollectServiceProxy.class, LogCollectPageController.class);
    }

}
