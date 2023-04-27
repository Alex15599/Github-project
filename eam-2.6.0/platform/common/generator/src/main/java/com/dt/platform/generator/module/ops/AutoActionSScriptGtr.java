package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoActionFile;
import com.dt.platform.domain.ops.AutoActionScript;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class AutoActionSScriptGtr extends BaseCodeGenerator{


    public AutoActionSScriptGtr() {
        super(OpsTables.OPS_AUTO_ACTION_S_SCRIPT.$TABLE,"613727231390253056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());





        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_ACTION_S_SCRIPT.ID,
                }
        );


        cfg.setRelationField(AutoAction.class,OpsTables.OPS_AUTO_ACTION_S_SCRIPT.OWNER_ID, AutoActionScript.class, OpsTables.OPS_AUTO_ACTION_S_SCRIPT.SCRIPT_ID,true);


        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_S_SCRIPT.ID).basic().hidden(true);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_ACTION_S_SCRIPT.ID,

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
        AutoActionSScriptGtr g=new AutoActionSScriptGtr();
        //生成代码
        g.generateCode();
     //   g.generateMenu(AutoActionFileServiceProxy.class, AutoActionFilePageController.class);
    }
}
