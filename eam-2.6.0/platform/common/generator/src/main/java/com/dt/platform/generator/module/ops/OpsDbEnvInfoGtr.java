package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsDbEnvEnum;
import com.dt.platform.constants.enums.ops.OpsDbStatusEnum;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.DbEnvInfo;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.meta.DbEnvInfoMeta;
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbEnvInfoPageController;
import com.dt.platform.proxy.ops.DbEnvInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsDbEnvInfoGtr extends BaseCodeGenerator{


    public OpsDbEnvInfoGtr() {
        super(OpsTables.OPS_DB_ENV_INFO.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.DB_INST_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.ID).table().disable(true);
        cfg.getPoClassFile().addSimpleProperty(Host.class,"host","host","host");
        cfg.getPoClassFile().addSimpleProperty(String.class,"hostName","hostName","hostName");
        cfg.getPoClassFile().addSimpleProperty(String.class,"hostIp","hostIp","hostIp");
        cfg.getPoClassFile().addSimpleProperty(DbInfo.class,"dbInfo","dbInfo","dbInfo");
        cfg.getPoClassFile().addSimpleProperty(String.class,"dbName","dbName","dbName");

        cfg.getPoClassFile().addSimpleProperty(CiphertextBoxData.class,"ciphertextBoxData","ciphertextBoxData","ciphertextBoxData");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_ENV_INFO.LABEL,
                        OpsTables.OPS_DB_ENV_INFO.IP,
                        OpsTables.OPS_DB_ENV_INFO.NOTES,
                }
        );



        cfg.view().field(DbEnvInfoMeta.HOST_NAME)
                .basic().label("主机名")
                .table().fillBy("host","hostName");

        cfg.view().field(DbEnvInfoMeta.HOST_IP)
                .basic().label("源IP")
                .table().fillBy("host","hostIp");

//        cfg.view().field(DbEnvInfoMeta.DB_NAME)
//                .basic().label("数据库名称")
//                .table().fillBy("dbInfo","dbName");




        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.IP).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.LABEL).form().validate().required().form()
                .radioBox().enumType(OpsDbEnvEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.NOTES).form().textArea().height(120);
        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.VOUCHER).form().textArea().height(150);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_ENV_INFO.LABEL,
                        OpsTables.OPS_DB_ENV_INFO.DB,
                        OpsTables.OPS_DB_ENV_INFO.IP,
                        OpsTables.OPS_DB_ENV_INFO.VOUCHER,
                        OpsTables.OPS_DB_ENV_INFO.NOTES,
                }
        );

        cfg.view().list().addJsVariable("INST_ID","[[${instId}]]","INST_ID");
        cfg.view().form().addJsVariable("INST_ID","[[${instId}]]","INST_ID");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsDbEnvInfoGtr g=new OpsDbEnvInfoGtr();
        //生成代码
        g.generateCode();
//        g.generateMenu(DbEnvInfoServiceProxy.class, DbEnvInfoPageController.class);

    }
}
