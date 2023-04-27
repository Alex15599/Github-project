package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import com.dt.platform.domain.ops.meta.HostExByDbMeta;
import com.dt.platform.domain.ops.meta.HostExByHostMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.HostExByDbPageController;
import com.dt.platform.proxy.ops.HostExByDbServiceProxy;
import com.dt.platform.proxy.ops.HostServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsDbHostExcudeGtr extends BaseCodeGenerator{


    public OpsDbHostExcudeGtr() {
        super(OpsTables.OPS_HOST_EX_BY_DB.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Host.class,"host","host","host");


        cfg.view().field(OpsTables.OPS_HOST_EX_BY_DB.NOTE).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST_EX_BY_DB.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_HOST_EX_BY_DB.NOTE,
                }
        );

        cfg.view().field(OpsTables.OPS_HOST_EX_BY_DB.NOTE).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_HOST_EX_BY_DB.HOST_ID)
                .basic().label("主机")
                .table().sort(false)
                .form().validate().required().form().selectBox().queryApi(HostServiceProxy.QUERY_PAGED_LIST)
                .valueField(HostMeta.ID).textField(HostMeta.HOST_NAME)
                .toolbar(false).paging(true)
                .fillWith(HostExByDbMeta.HOST).muliti(false);


        String resourceNameField="res_"+OpsTables.OPS_HOST.HOST_IP;
        cfg.view().field(resourceNameField)
                .basic().label("IP")
                .table().fillBy(HostExByDbMeta.HOST, HostMeta.HOST_IP);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_HOST_EX_BY_DB.HOST_ID,
                        OpsTables.OPS_HOST_EX_BY_DB.NOTE,
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
        OpsDbHostExcudeGtr g=new OpsDbHostExcudeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.removeByBatchId("474335473372758016");
    //    g.generateMenu(HostExByDbServiceProxy.class, HostExByDbPageController.class);
    }
}
