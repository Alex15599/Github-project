package com.dt.platform.generator.module.workorder;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.constants.enums.workorder.ServiceDeskStatusEnum;
import com.dt.platform.constants.enums.workorder.ServiceDeskTypeEnum;
import com.dt.platform.constants.enums.workorder.ServicePortalTypeEnum;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.meta.ServiceGroupMeta;
import com.dt.platform.domain.workorder.meta.ServicePortalMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.workorder.ServicePortalServiceProxy;
import com.dt.platform.workorder.page.ServicePortalPageController;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class ServicePortalGtr extends BaseCodeGenerator {
    public ServicePortalGtr() {
        super(WorkorderTables.WO_SERVICE_PORTAL.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"group","group","group");
        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        WorkorderTables.WO_SERVICE_PORTAL.GROUP_ID,
                        WorkorderTables.WO_SERVICE_PORTAL.NAME
                }
        );


        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.ID).basic().hidden(true);
        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.ID).table().disable(true);
        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.NOTES).table().disable(true);



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field( WorkorderTables.WO_SERVICE_PORTAL.TYPE).form().validate()
                .required().form().radioBox().enumType(ServicePortalTypeEnum.class).defaultIndex(0);


        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.NAME).form().validate().required();
        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.GROUP_ID).form().validate().required();
        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.URL).form().validate().required();
        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.LABEL).form().validate().required();
        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.IMAGE).form().validate().required();

        cfg.view().field( WorkorderTables.WO_SERVICE_PORTAL.GROUP_ID)
                .form().validate().required()
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=wo_portal_group")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(ServicePortalMeta.GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_SERVICE_PORTAL.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SERVICE_PORTAL.NAME,
                        WorkorderTables.WO_SERVICE_PORTAL.GROUP_ID,
                        WorkorderTables.WO_SERVICE_PORTAL.URL,
                },
                new Object[] {
                        WorkorderTables.WO_SERVICE_PORTAL.LABEL,
                        WorkorderTables.WO_SERVICE_PORTAL.IMAGE,
                        WorkorderTables.WO_SERVICE_PORTAL.PERM,
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SERVICE_PORTAL.NOTES,
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
        ServicePortalGtr g=new ServicePortalGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(ServicePortalServiceProxy.class, ServicePortalPageController.class);
    }
}
