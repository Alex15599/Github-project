package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.ops.OpsDbBackupResultEnum;
import com.dt.platform.constants.enums.ops.OpsDbBackupStatusEnum;
import com.dt.platform.constants.enums.ops.OpsDbStatusEnum;
import com.dt.platform.domain.ops.DbBackupInfo;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.meta.DbBackupInfoMeta;
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbBackupInfoPageController;
import com.dt.platform.proxy.ops.DbBackupInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;

public class OpsDbInfoBackupGtr extends BaseCodeGenerator{


    public OpsDbInfoBackupGtr() {
        super(OpsTables.OPS_DB_BACKUP_INFO.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.BACKUP_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.getPoClassFile().addSimpleProperty(Host.class,"host","host","host");
        cfg.getPoClassFile().addSimpleProperty(DbInfo.class,"db","db","db");
        cfg.getPoClassFile().addSimpleProperty(ServiceInfo.class,"dbType","dbType","dbType");

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.BACKUP_STRATEGY).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_BACKUP_INFO.STATUS,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_TYPE,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_METHOD,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_STRATEGY,
                }
        );


        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.DATABASE_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.SELECTED_CODE).table().disable(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.STATUS).form().validate().required().form()
                .radioBox().enumType(OpsDbStatusEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.BACKUP_METHOD).basic().label("备份方式")
                .form().validate().required().form().selectBox().dict(DictEnum.OPS_DB_BACKUP_METHOD).paging(false).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.NAME).form().validate().required();

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.BACKUP_RESULT).basic().label("备份结果")
                .form().selectBox().enumType(OpsDbBackupResultEnum.class);

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.BACKUP_TYPE).basic().label("备份类型")
                .form().validate().required().form().radioBox().dict(DictEnum.OPS_DB_BACKUP_TYPE).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_DB_BACKUP_INFO.NOTES).form().textArea().height(Config.textAreaHeight);


        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);

        String resourceNameField="res_"+OpsTables.OPS_HOST.HOST_IP;
        cfg.view().field(resourceNameField)
                .basic().label("IP")
                .table().fillBy(DbBackupInfoMeta.HOST, HostMeta.HOST_IP);


        String resourceNameField2="res_"+OpsTables.OPS_HOST.HOST_NAME;
        cfg.view().field(resourceNameField2)
                .basic().label("主机名")
                .table().fillBy(DbBackupInfoMeta.HOST, HostMeta.HOST_NAME);



        String resourceNameField3="res_db_"+OpsTables.OPS_DB_INFO.NAME;
        cfg.view().field(resourceNameField3)
                .basic().label("数据库")
                .table().fillBy(DbBackupInfoMeta.DB, DbInfoMeta.NAME);


        String resourceNameField4="res_db_type_"+OpsTables.OPS_SERVICE_INFO.NAME;
        cfg.view().field(resourceNameField4)
                .basic().label("数据库类型")
                .table().fillBy(DbBackupInfoMeta.DB_TYPE, ServiceInfoMeta.NAME);



        cfg.view().list().addJsVariable("DB_ID","[[${dbId}]]","dbId");
        cfg.view().list().addJsVariable("PAGE_TYPE","[[${pageType}]]","pageType");

        cfg.view().form().addJsVariable("DB_ID","[[${dbId}]]","dbId");

        cfg.view().form().addJsVariable("SELECTED_CODE","[[${selectedCode}]]","selectedCode");
        cfg.view().list().addJsVariable("SELECTED_CODE","[[${selectedCode}]]","selectedCode");

        cfg.view().list().disableBatchDelete();


        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_INFO.NAME,
                        OpsTables.OPS_DB_BACKUP_INFO.UID,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_TYPE,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_METHOD,
                },
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_INFO.STATUS,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_STRATEGY,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_DATAKEEP,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_INFO.NOTES

                }

        );
cfg.view().form().addGroup("备份信息",
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_RESULT,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_SIZE,
                },
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_SOURCE,
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_TIME,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_BACKUP_INFO.BACKUP_RESULT_CT,
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsDbInfoBackupGtr g=new OpsDbInfoBackupGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.removeByBatchId("474335473372758016");
        //g.generateMenu(ServiceGroupServiceProxy.class, ServiceGroupPageController.class);
      //  g.generateMenu(DbBackupInfoServiceProxy.class, DbBackupInfoPageController.class);
    }
}
