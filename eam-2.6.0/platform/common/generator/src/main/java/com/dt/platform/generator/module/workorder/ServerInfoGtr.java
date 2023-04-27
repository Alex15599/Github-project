package com.dt.platform.generator.module.workorder;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.constants.enums.workorder.NetworkStrategySessionTypeEnum;
import com.dt.platform.constants.enums.workorder.ServerTypeEnum;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.domain.workorder.ServerOsType;
import com.dt.platform.domain.workorder.meta.ServerInfoMeta;
import com.dt.platform.domain.workorder.meta.ServerOsTypeMeta;
import com.dt.platform.generator.config.Config;

import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.dt.platform.proxy.workorder.ServerInfoServiceProxy;
import com.dt.platform.proxy.workorder.ServerOsTypeServiceProxy;
import com.dt.platform.workorder.page.ServerInfoPageController;
import com.github.foxnic.generator.config.WriteMode;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class ServerInfoGtr extends BaseCodeGenerator {


    public ServerInfoGtr() {
        super(WorkorderTables.WO_SERVER_INFO.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        cfg.getPoClassFile().addSimpleProperty(ServerOsType.class,"serverOsType","serverOsType","serverOsType");


        cfg.view().field(WorkorderTables.WO_SERVER_INFO.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        WorkorderTables.WO_SERVER_INFO.SERVER_TYPE,
                        WorkorderTables.WO_SERVER_INFO.NAME,
                }
        );
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.ID).basic().hidden(true);
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.ID).table().disable(true);
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.SELECTED_CODE).table().disable(true);
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.OWNER_ID).table().disable(true);


        cfg.view().field(WorkorderTables.WO_SERVER_INFO.SERVER_TYPE).form().label("类型").validate().required().form()
                .radioBox().enumType(ServerTypeEnum.class).defaultIndex(0);


        cfg.view().list().addJsVariable("ownerId",   "[[${ownerId}]]","ownerId");
        cfg.view().list().addJsVariable("pageType",   "[[${pageType}]]","pageType");

        cfg.view().field(WorkorderTables.WO_SERVER_INFO.NOTES).form().textArea().height(Config.textAreaHeight).search().fuzzySearch();

        cfg.view().field(WorkorderTables.WO_SERVER_INFO.OS_VERSION)

                .form().selectBox().queryApi(ServerOsTypeServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(ServerOsTypeMeta.ID).textField( ServerOsTypeMeta.NAME).fillWith(ServerInfoMeta.SERVER_OS_TYPE).muliti(false).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_SERVER_INFO.CPU).form().validate().required().form().numberInput().defaultValue(2.0);
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.MEMORY).form().validate().required().form().numberInput().defaultValue(4.0);
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.SERVER_NUMBER).form().validate().required().form().numberInput().defaultValue(1.0);
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.SPACE_SIZE).form().validate().required().form().numberInput().defaultValue(100);
        cfg.view().field(WorkorderTables.WO_SERVER_INFO.NAME).form().validate().required().search().fuzzySearch();
        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SERVER_INFO.NAME,
                },
                new Object[] {
                        WorkorderTables.WO_SERVER_INFO.SERVER_TYPE,
                }
        );
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        WorkorderTables.WO_SERVER_INFO.OS_VERSION,
                        WorkorderTables.WO_SERVER_INFO.CPU,
                        WorkorderTables.WO_SERVER_INFO.MEMORY,
                        WorkorderTables.WO_SERVER_INFO.SPACE_SIZE,

                },
                new Object[] {
                        WorkorderTables.WO_SERVER_INFO.MIDDLEWARE_VERSION,
                        WorkorderTables.WO_SERVER_INFO.DATABASE_VERSION,
                        WorkorderTables.WO_SERVER_INFO.SERVER_NUMBER
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SERVER_INFO.IP,
                        WorkorderTables.WO_SERVER_INFO.USERLIST,
                        WorkorderTables.WO_SERVER_INFO.PORTLIST,
                        WorkorderTables.WO_SERVER_INFO.NOTES,
                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().list().addJsVariable("ownerId",   "[[${ownerId}]]","ownerId");
        cfg.view().list().addJsVariable("pageType",   "[[${pageType}]]","pageType");
        cfg.view().list().addJsVariable("selectedCode",   "[[${selectedCode}]]","selectedCode");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        ServerInfoGtr g=new ServerInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
        //g.generateMenu(ServerInfoServiceProxy.class, ServerInfoPageController.class);



    }

}
