package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsAutoActionNodeNumberTypeEnum;
import com.dt.platform.constants.enums.ops.OpsAutoActionTypeEnum;
import com.dt.platform.constants.enums.ops.OpsAutoExecuteTypeEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoActionPageController;
import com.dt.platform.ops.service.impl.*;
import com.dt.platform.proxy.ops.AutoActionFileServiceProxy;
import com.dt.platform.proxy.ops.AutoActionScriptServiceProxy;
import com.dt.platform.proxy.ops.AutoActionServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class AutoActionGtr extends BaseCodeGenerator{


    public AutoActionGtr() {
        super(OpsTables.OPS_AUTO_ACTION.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.getPoClassFile().addListProperty(AutoActionScript.class,"autoActionScriptList","autoActionScriptList","autoActionScriptList");
        cfg.getPoClassFile().addListProperty(String.class,"autoActionScriptIds","autoActionScriptIds","autoActionScriptIds");



        cfg.getPoClassFile().addListProperty(AutoActionFile.class,"autoActionFileList","autoActionFileList","autoActionFileList");
        cfg.getPoClassFile().addListProperty(String.class,"autoActionFileIds","autoActionFileIds","autoActionFileIds");


        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","typeDict","typeDict");
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_ACTION.STATUS,
                        OpsTables.OPS_AUTO_ACTION.TYPE,
                        OpsTables.OPS_AUTO_ACTION.EXECUTE_TOOL,
                        OpsTables.OPS_AUTO_ACTION.NAME,
                },
                new Object[]{

                        OpsTables.OPS_AUTO_ACTION.NOTES,
                }
        );
        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.ID).basic().hidden(true);


        cfg.view().field(OpsTables.OPS_AUTO_ACTION.EXECUTE_CONTENT).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.CONF_CONTENT).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.EXAMPLE_CONF_CONTENT).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.INFO).table().disable(true);


        cfg.view().field(OpsTables.OPS_AUTO_ACTION.STATUS).table().form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.NAME).table().form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.NOTES).table().form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.EXECUTE_TOOL).table().form().validate().required().form().radioBox().enumType(OpsAutoExecuteTypeEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.CONF_CONTENT).table().form().validate().required().form().textArea().height(Config.textAreaHeight*2);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION.EXAMPLE_CONF_CONTENT).table().form().validate().required().form().textArea().height(Config.textAreaHeight*2);

        cfg.view().field(OpsTables.OPS_AUTO_ACTION.EXECUTE_CONTENT).table().form().validate().required().form().textArea().height(Config.textAreaHeight*5);


        cfg.view().field(OpsTables.OPS_AUTO_ACTION.TYPE).table().form().validate().required().form().radioBox().enumType(OpsAutoActionTypeEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_AUTO_ACTION.FILE_STATUS).table().form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_AUTO_ACTION.NODE_NUMBER_TYPE).table().form().validate().required().form().radioBox().enumType(OpsAutoActionNodeNumberTypeEnum.class).defaultIndex(0);



        cfg.service().addRelationSaveAction(AutoActionSScriptServiceImpl.class, AutoActionVOMeta.AUTO_ACTION_SCRIPT_IDS);
        cfg.service().addRelationSaveAction(AutoActionSFileServiceImpl.class,AutoActionVOMeta.AUTO_ACTION_FILE_IDS);


        cfg.view().field(AutoActionMeta.AUTO_ACTION_SCRIPT_IDS).basic().label("脚本")
                .table().sort(false)
               .form().selectBox().queryApi(AutoActionScriptServiceProxy.QUERY_LIST)
                .valueField(AutoActionScriptMeta.ID).textField(AutoActionScriptMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(AutoActionMeta.AUTO_ACTION_SCRIPT_LIST).muliti(true);


        cfg.view().field(AutoActionMeta.AUTO_ACTION_FILE_IDS).basic().label("介质")
                .table().sort(false)
                .form().selectBox().queryApi(AutoActionFileServiceProxy.QUERY_LIST)
                .valueField(AutoActionFileMeta.ID).textField(AutoActionFileMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(AutoActionMeta.AUTO_ACTION_FILE_LIST).muliti(true);



        cfg.view().formWindow().bottomSpace(100);
        cfg.view().formWindow().width(Config.baseFormWidth_95);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_ACTION.NAME,
                        OpsTables.OPS_AUTO_ACTION.STATUS,
                        OpsTables.OPS_AUTO_ACTION.TYPE,
                        OpsTables.OPS_AUTO_ACTION.INFO,
                        OpsTables.OPS_AUTO_ACTION.SUPPORT,

                },
                new Object[] {
                        OpsTables.OPS_AUTO_ACTION.TPL_VERSION,
                        OpsTables.OPS_AUTO_ACTION.NODE_NUMBER_TYPE,
                        OpsTables.OPS_AUTO_ACTION.EXECUTE_TOOL,
                        OpsTables.OPS_AUTO_ACTION.FILE_STATUS,


                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        AutoActionMeta.AUTO_ACTION_SCRIPT_IDS,
                },
                new Object[] {
                        AutoActionMeta.AUTO_ACTION_FILE_IDS
                }
        );
//        cfg.view().form().addGroup(null,
//                new Object[] {
//
//                },
//                new Object[] {
//
//                }
//        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_ACTION.NOTES,
                        OpsTables.OPS_AUTO_ACTION.CONF_CONTENT,
                        OpsTables.OPS_AUTO_ACTION.EXAMPLE_CONF_CONTENT,
                        OpsTables.OPS_AUTO_ACTION.EXECUTE_CONTENT,
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
        AutoActionGtr g=new AutoActionGtr();
        //生成代码
        g.generateCode();
      //  g.generateMenu(AutoActionServiceProxy.class, AutoActionPageController.class);
    }
}
