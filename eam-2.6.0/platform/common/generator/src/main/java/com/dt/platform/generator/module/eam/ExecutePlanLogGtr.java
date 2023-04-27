package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class ExecutePlanLogGtr extends BaseCodeGenerator{
    public ExecutePlanLogGtr() {
        super(EAMTables.EAM_PLAN_EXECUTE_LOG.$TABLE,"694836581814501376");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_PLAN_EXECUTE_LOG.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                      EAMTables.EAM_PLAN_EXECUTE_LOG.EXECUTE_TIME,
                }

        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width("60%");;
        cfg.view().form().addGroup(null,
                new Object[] {
                       EAMTables.EAM_PLAN_EXECUTE_LOG.EXECUTE_TIME,
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
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        ExecutePlanLogGtr g=new ExecutePlanLogGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
     //   g.generateMenu(CCustInspectPlanServiceProxy.class, CCustInspectPlanPageController.class);
    }
}
