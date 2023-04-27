package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.domain.ops.meta.SystemConsoleInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.SystemConsoleInfoPageController;
import com.dt.platform.proxy.ops.SystemConsoleInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsSystemConsoleInfoGtr extends BaseCodeGenerator{


    public OpsSystemConsoleInfoGtr() {
        super(OpsTables.OPS_SYSTEM_CONSOLE_INFO.$TABLE,"472819614665932801");
    }

    public void generateCode() throws Exception {

        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.ID).basic().hidden(true);

        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.ID).table().disable(true);

        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.NOTES).search().fuzzySearch();
        cfg.getPoClassFile().addListProperty(DictItem.class,"typeDict","类型","类型");
        cfg.getPoClassFile().addListProperty(DictItem.class,"envDict","环境","环境");
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.STATUS,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.TYPE,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.NAME,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.NOTES
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.NAME).form().validate().required();


        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.NOTES).form()
                .textArea().height(Config.textAreaHeight);


        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.STATUS)
                .form().validate().required()
                .form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.ENV).basic().label("所在环境")
                .form().selectBox().dict(DictEnum.OPS_ENVIRONMENT).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_SYSTEM_CONSOLE_INFO.TYPE)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_system_console_type")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(SystemConsoleInfoMeta.TYPE_DICT).muliti(false).defaultIndex(0);


        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.NAME,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.ENV,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.STATUS,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.TYPE,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.ADDRESS,
                        OpsTables.OPS_SYSTEM_CONSOLE_INFO.NOTES
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
        OpsSystemConsoleInfoGtr g=new OpsSystemConsoleInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
      // g.generateMenu(SystemConsoleInfoServiceProxy.class, SystemConsoleInfoPageController.class);
    }
}
