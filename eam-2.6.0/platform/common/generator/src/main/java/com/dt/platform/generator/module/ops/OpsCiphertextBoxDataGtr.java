package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsCiphertextHistoryDataTypeEnum;
import com.dt.platform.constants.enums.ops.OpsCiphertextTypeEnum;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.meta.CiphertextBoxMeta;
import com.dt.platform.domain.ops.meta.CiphertextConfMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.CiphertextBoxDataPageController;
import com.dt.platform.ops.page.CiphertextHistoryPageController;
import com.dt.platform.proxy.ops.CiphertextBoxDataServiceProxy;
import com.dt.platform.proxy.ops.CiphertextBoxServiceProxy;
import com.dt.platform.proxy.ops.CiphertextHistoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsCiphertextBoxDataGtr extends BaseCodeGenerator{


    public OpsCiphertextBoxDataGtr() {
        super(OpsTables.OPS_CIPHERTEXT_BOX_DATA.$TABLE,"635020464892149760");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CIPHERTEXT_BOX_DATA.SOURCE_ID,
                        OpsTables.OPS_CIPHERTEXT_BOX_DATA.NAME,
                }

        );



//        cfg.view().field(OpsTables.OPS_CIPHERTEXT_CONF.BOX_ID)
//                .form().validate().required().form().selectBox().queryApi(CiphertextBoxServiceProxy.QUERY_PAGED_LIST)
//                .paging(true).filter(true).toolbar(false)
//                .valueField(CiphertextBoxMeta.ID).
//                textField(CiphertextBoxMeta.NAME).
//                fillWith(CiphertextConfMeta.BOX).muliti(false).defaultValue(0);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.SOURCE_ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.NAME).form().search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.CONTENT).form().textArea().height(200);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.CIPHERTEXT).form().textArea().height(200);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.PLAINTEXT).table().disable(true);
        cfg.view().field(OpsTables.OPS_CIPHERTEXT_BOX_DATA.BOX_TYPE).form().selectBox().enumType(OpsCiphertextTypeEnum.class);

        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CIPHERTEXT_BOX_DATA.NAME,
                        OpsTables.OPS_CIPHERTEXT_BOX_DATA.PLAINTEXT,
                        OpsTables.OPS_CIPHERTEXT_BOX_DATA.NOTES
                }
        );




        cfg.view().list().addJsVariable("SOURCE_ID","[[${sourceId}]]","sourceId");
        cfg.view().list().addJsVariable("BOX_TYPE","[[${boxType}]]","boxType");


        cfg.view().form().addJsVariable("SOURCE_ID","[[${sourceId}]]","sourceId");
        cfg.view().form().addJsVariable("BOX_TYPE","[[${boxType}]]","boxType");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsCiphertextBoxDataGtr g=new OpsCiphertextBoxDataGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
     //   g.generateMenu(CiphertextBoxDataServiceProxy.class, CiphertextBoxDataPageController.class);
    }
}
