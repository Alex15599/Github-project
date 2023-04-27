package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.ops.meta.PersonnelDivisionMeta;
import com.dt.platform.domain.ops.meta.PublicContentMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.PersonnelDivisionPageController;
import com.dt.platform.proxy.ops.PersonnelDivisionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsPersonDivGtr extends BaseCodeGenerator{


    public OpsPersonDivGtr() {
        super(OpsTables.OPS_PERSONNEL_DIVISION.$TABLE,"591565695548915712");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        //ops_public_list_type
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"ownerData","ownerData","ownerData");

        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.NOTES).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.ID).table().disable(true);

        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.RESPONSIBLE_CONTENT).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.JOB_CONTENT).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_PUBLIC_CONTENT.STATUS,
                        OpsTables.OPS_PERSONNEL_DIVISION.OWNER,
                        OpsTables.OPS_PERSONNEL_DIVISION.RESPONSIBLE_CONTENT,
                        OpsTables.OPS_PERSONNEL_DIVISION.JOB_CONTENT,
                        OpsTables.OPS_PERSONNEL_DIVISION.NOTES
                }
        );


        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.JOB_CONTENT).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.RESPONSIBLE_CONTENT).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.NOTES).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);


        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.OWNER)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_person_owner")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(PersonnelDivisionMeta.OWNER_DATA).muliti(false).defaultValue("single");


        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.POS).form().validate().required();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.USER_ID).table().fillBy("user","name");
        cfg.view().field(OpsTables.OPS_PERSONNEL_DIVISION.USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_PERSONNEL_DIVISION.USER_ID,
                        OpsTables.OPS_PERSONNEL_DIVISION.STATUS,

                },
                new Object[] {
                        OpsTables.OPS_PERSONNEL_DIVISION.OWNER,
                        OpsTables.OPS_PERSONNEL_DIVISION.POS,
                }

        );
//
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
                        OpsTables.OPS_PERSONNEL_DIVISION.RESPONSIBLE_CONTENT,
                        OpsTables.OPS_PERSONNEL_DIVISION.JOB_CONTENT,
                        OpsTables.OPS_PERSONNEL_DIVISION.NOTES,
                        OpsTables.OPS_PERSONNEL_DIVISION.SORT
                }


        );

        cfg.view().list().addToolButton("预览","review","review","ops_personnel_division:review");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsPersonDivGtr g=new OpsPersonDivGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
    //    g.generateMenu(PersonnelDivisionServiceProxy.class, PersonnelDivisionPageController.class);
    }
}
