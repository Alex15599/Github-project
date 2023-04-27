package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.domain.eam.Inventory;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.meta.ServiceCategoryMeta;
import com.dt.platform.domain.ops.meta.ServiceGroupMeta;
import com.dt.platform.domain.vehicle.Apply;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.ops.ServiceGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;

public class OpsServiceCategoryLabelGtr extends BaseCodeGenerator{


    public OpsServiceCategoryLabelGtr() {
        super(OpsTables.OPS_SERVICE_CATEGORY_LABEL.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        //    public void setRelationField(Class masterPoType, DBField masterIdField, Class slavePoType, DBField slaveIdField, boolean clearWhenEmpty) {
        //一对多， A=Apply B=Info，  中间保存表VehicleTables.VEHICLE_A_SELECT_ITEM.HANDLE_ID

        cfg.setRelationField(ServiceCategory.class, OpsTables.OPS_SERVICE_CATEGORY_LABEL.CATEGORY_ID , DictItem.class, OpsTables.OPS_SERVICE_CATEGORY_LABEL.LABEL_CODE,true);
    //    cfg.setRelationField(Host.class,OpsTables.OPS_HOST_MID.HOST_ID, ServiceInfo.class, OpsTables.OPS_HOST_MID.SERVICE_INFO_ID,true);
        //    public void setRelationField(Class masterPoType, DBField masterIdField, Class slavePoType, DBField slaveIdField, boolean clearWhenEmpty) {
        //一对多， A=Apply B=Info，  中间保存表VehicleTables.VEHICLE_A_SELECT_ITEM.HANDLE_ID
     //   cfg.setRelationField(Apply.class,VehicleTables.VEHICLE_A_SELECT_ITEM.HANDLE_ID, Info.class, VehicleTables.VEHICLE_A_SELECT_ITEM.ASSET_ID,true);

      //* from " + slavePoTable + " where " + masterIdField.name()

      //  cfg.setRelationField(Inventory.class, EAMTables.EAM_INVENTORY_DIRECTOR.INVENTORY_ID, Employee.class,EAMTables.EAM_INVENTORY_DIRECTOR.USER_ID,true);


        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SERVICE_CATEGORY_LABEL.CATEGORY_ID,
                        OpsTables.OPS_SERVICE_CATEGORY_LABEL.LABEL_CODE,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsServiceCategoryLabelGtr g=new OpsServiceCategoryLabelGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.removeByBatchId("474335473372758016");
     //   g.generateMenu(ServiceCategoryServiceProxy.class, ServiceCategoryPageController.class);
    }
}
