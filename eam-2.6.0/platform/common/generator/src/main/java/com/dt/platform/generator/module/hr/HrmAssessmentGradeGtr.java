package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.AssessmentGrade;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentGradePageController;
import com.dt.platform.proxy.hr.AssessmentGradeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmAssessmentGradeGtr extends BaseCodeGenerator {
    public HrmAssessmentGradeGtr() {
        super(HrTables.HR_ASSESSMENT_GRADE.$TABLE,"661509217017921536");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_ASSESSMENT_GRADE.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_GRADE.CODE).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_GRADE.CODE,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_GRADE.CODE,
                        HrTables.HR_ASSESSMENT_GRADE.NAME,
                        HrTables.HR_ASSESSMENT_GRADE.SORT,
                        HrTables.HR_ASSESSMENT_GRADE.NOTES
                }
        );




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmAssessmentGradeGtr g=new HrmAssessmentGradeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(AssessmentGradeServiceProxy.class, AssessmentGradePageController.class);
    }
}
