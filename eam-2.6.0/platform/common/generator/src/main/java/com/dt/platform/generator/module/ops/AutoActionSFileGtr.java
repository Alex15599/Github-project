package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoActionFile;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class AutoActionSFileGtr extends BaseCodeGenerator{


    public AutoActionSFileGtr() {
        super(OpsTables.OPS_AUTO_ACTION_S_FILE.$TABLE,"613727231390253056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());





        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_ACTION_S_FILE.ID,
                }
        );


        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_AUTO_ACTION_S_FILE.ID).basic().hidden(true);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_ACTION_S_FILE.ID,

                }
        );


        //一对多， A=Apply B=Info，  中间保存表VehicleTables.VEHICLE_A_SELECT_ITEM.HANDLE_ID
        cfg.setRelationField(AutoAction.class,OpsTables.OPS_AUTO_ACTION_S_FILE.OWNER_ID, AutoActionFile.class, OpsTables.OPS_AUTO_ACTION_S_FILE.FILE_ID,true);

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
        AutoActionSFileGtr g=new AutoActionSFileGtr();
        //生成代码
        g.generateCode();
     //   g.generateMenu(AutoActionFileServiceProxy.class, AutoActionFilePageController.class);
    }
}
