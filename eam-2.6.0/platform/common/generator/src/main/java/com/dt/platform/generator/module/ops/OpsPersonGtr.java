package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.domain.ops.meta.PersonMeta;
import com.dt.platform.domain.ops.meta.VoucherMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.PersonPageController;
import com.dt.platform.proxy.ops.PersonServiceProxy;
import com.dt.platform.proxy.ops.VoucherPrivServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsPersonGtr extends BaseCodeGenerator{


    public OpsPersonGtr() {
        super(OpsTables.OPS_PERSON.$TABLE,"591565695548915712");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_PERSON.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"personTypeDict","人员类型","人员类型");

        cfg.view().field(OpsTables.OPS_PERSON.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_PERSON.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_PERSON.LABEL).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_PERSON.COMPANY_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_PERSON.CONTACT_INFORMATION).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_PERSON.PERSON_TYPE,
                        OpsTables.OPS_PERSON.COMPANY_NAME,
                        OpsTables.OPS_PERSON.NAME,
                        OpsTables.OPS_PERSON.CONTACT_INFORMATION,
                },
                new Object[]{
                        OpsTables.OPS_PERSON.LABEL,
                        OpsTables.OPS_PERSON.NOTES,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OpsTables.OPS_PERSON.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_PERSON.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_PERSON.COMPANY_NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_PERSON.PERSON_TYPE)
                .basic().label("人员类型")
                .table().sort(false)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_person_type")
                .valueField("code").textField("label")
                .toolbar(false).paging(false)
                .fillWith(PersonMeta.PERSON_TYPE_DICT).muliti(false);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_PERSON.NAME,
                        OpsTables.OPS_PERSON.PERSON_TYPE,
                        OpsTables.OPS_PERSON.LABEL,
                }, new Object[] {
                        OpsTables.OPS_PERSON.COMPANY_NAME,
                        OpsTables.OPS_PERSON.CONTACT_INFORMATION,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_PERSON.NOTES,
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
        OpsPersonGtr g=new OpsPersonGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //g.generateMenu(PersonServiceProxy.class, PersonPageController.class);
    }
}
