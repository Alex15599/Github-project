package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsCiphertextHistoryDataTypeEnum;
import com.dt.platform.domain.ops.CiphertextBox;
import com.dt.platform.domain.ops.meta.CiphertextBoxMeta;
import com.dt.platform.domain.ops.meta.CiphertextConfMeta;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.domain.ops.meta.MonitorTplTypeMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.CiphertextConfPageController;
import com.dt.platform.ops.page.CiphertextHistoryPageController;
import com.dt.platform.proxy.ops.CiphertextBoxServiceProxy;
import com.dt.platform.proxy.ops.CiphertextConfServiceProxy;
import com.dt.platform.proxy.ops.CiphertextHistoryServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class OpsCiphertextBoxConfGtr extends BaseCodeGenerator{


    public OpsCiphertextBoxConfGtr() {
        super(OpsTables.OPS_CIPHERTEXT_CONF.$TABLE,"635020464892149760");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","人员","人员");
        cfg.getPoClassFile().addSimpleProperty(CiphertextBox.class,"box","密码箱","密码箱");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CIPHERTEXT_CONF.BOX_ID,
                        OpsTables.OPS_CIPHERTEXT_CONF.USER_ID,
                        OpsTables.OPS_CIPHERTEXT_CONF.NOTES,
                }

        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(OpsTables.OPS_CIPHERTEXT_CONF.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_CONF.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_CONF.DECRYPTION_PERM_STATUS).form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_CIPHERTEXT_CONF.USER_ID).table().fillBy("user","name");
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_CONF.USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CIPHERTEXT_CONF.BOX_ID,
                        OpsTables.OPS_CIPHERTEXT_CONF.USER_ID,
                        OpsTables.OPS_CIPHERTEXT_CONF.DECRYPTION_PERM_STATUS,
                        OpsTables.OPS_CIPHERTEXT_CONF.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsCiphertextBoxConfGtr g=new OpsCiphertextBoxConfGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
      //  g.generateMenu(CiphertextConfServiceProxy.class, CiphertextConfPageController.class);
    }
}
