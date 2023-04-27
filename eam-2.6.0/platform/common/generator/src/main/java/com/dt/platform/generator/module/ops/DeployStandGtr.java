package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.SoftwareBaseVersionStatusEnum;
import com.dt.platform.domain.ops.SoftwareBaseType;
import com.dt.platform.domain.ops.meta.SoftwareBaseTypeMeta;
import com.dt.platform.domain.ops.meta.SoftwareBaseVersionMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DeployStandardPageController;
import com.dt.platform.proxy.ops.DeployStandardServiceProxy;
import com.dt.platform.proxy.ops.SoftwareBaseTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DeployStandGtr extends BaseCodeGenerator{


    public DeployStandGtr() {
        super(OpsTables.OPS_DEPLOY_STANDARD.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DEPLOY_STANDARD.NAME,

                }
        );

        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.ID).basic().hidden(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.DEPLOY_CONTENT).table().disable(true);
        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.CREATE_DB_CONTENT).table().disable(true);
        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.ATTACH_ID).table().disable(true);

        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.USER_CONTENT).form().textArea().height(200);
        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.DIR_CONTENT).form().textArea().height(200);

        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.DEPLOY_CONTENT).form().textArea().height(300);
        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.CREATE_DB_CONTENT).form().textArea().height(300);

        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.MAINTENANCE_CONTENT).form().textArea().height(300);
        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.BACKUP_SCRIPT).form().textArea().height(400);

        cfg.view().field(OpsTables.OPS_DEPLOY_STANDARD.ATTACH_ID).form().upload().acceptAllType().maxFileCount(6);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth_95);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DEPLOY_STANDARD.NAME,
                        OpsTables.OPS_DEPLOY_STANDARD.TYPE_ID,
                },
                new Object[] {
                        OpsTables.OPS_DEPLOY_STANDARD.RELEASE_VERSION,
                        OpsTables.OPS_DEPLOY_STANDARD.ATTACH_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DEPLOY_STANDARD.NOTES,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DEPLOY_STANDARD.USER_CONTENT,
                },
                new Object[] {
                        OpsTables.OPS_DEPLOY_STANDARD.DIR_CONTENT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DEPLOY_STANDARD.DEPLOY_CONTENT,
                        OpsTables.OPS_DEPLOY_STANDARD.CREATE_DB_CONTENT,
                        OpsTables.OPS_DEPLOY_STANDARD.MAINTENANCE_CONTENT,
                        OpsTables.OPS_DEPLOY_STANDARD.BACKUP_SCRIPT,
                }
        );
        cfg.view().form().addJsVariable("TYPE_ID","[[${typeId}]]","typeId");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DeployStandGtr g=new DeployStandGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
 //         g.generateMenu(DeployStandardServiceProxy.class, DeployStandardPageController.class);
//        delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id='541696318553194496');
//        delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id='541696318553194496');
//        delete from sys_menu where batch_id='541696318553194496';
//        delete from sys_resourze where batch_id='541696318553194496'

    }
}
