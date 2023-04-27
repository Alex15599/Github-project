package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsAutoActionTypeEnum;
import com.dt.platform.constants.enums.ops.OpsAutoExecuteTypeEnum;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoActionScriptPageController;
import com.dt.platform.proxy.ops.AutoActionScriptServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;

public class AutoActionScriptGtr extends BaseCodeGenerator{


    public AutoActionScriptGtr() {
        super(OpsTables.OPS_AUTO_ACTION_SCRIPT.$TABLE,"613727231390253056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_AUTO_ACTION.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.NOTES).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_ACTION_SCRIPT.NAME,
                        OpsTables.OPS_AUTO_ACTION_SCRIPT.NOTES,
                }
        );


        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_SCRIPT.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_SCRIPT.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_SCRIPT.FILE_NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_SCRIPT.FILE_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_SCRIPT.FILE_ID).table().form().validate().required().form().upload().acceptSingleFile().maxFileCount(1).acceptAllType();
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_SCRIPT.NOTES).table().form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_ACTION_SCRIPT.NAME,
                        OpsTables.OPS_AUTO_ACTION_SCRIPT.FILE_NAME,
                        OpsTables.OPS_AUTO_ACTION_SCRIPT.FILE_ID,
                        OpsTables.OPS_AUTO_ACTION_SCRIPT.NOTES,
                }
        );


        //A和B，一对多 ，AA。
        cfg.setRelationField(MonitorNode.class,OpsTables.OPS_MONITOR_NODE_TPL_ITEM.NODE_ID, MonitorTpl.class, OpsTables.OPS_MONITOR_NODE_TPL_ITEM.TPL_CODE,true);
        //cfg.setRelationField(Host.class,OpsTables.OPS_HOST_MID.HOST_ID, ServiceInfo.class, OpsTables.OPS_HOST_MID.SERVICE_INFO_ID,true);

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
        AutoActionScriptGtr g=new AutoActionScriptGtr();
        //生成代码
        g.generateCode();
       //g.generateMenu(AutoActionScriptServiceProxy.class, AutoActionScriptPageController.class);
    }
}
