package com.dt.platform.generator.module.workorder;

import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.constants.enums.workorder.ServiceDeskStatusEnum;
import com.dt.platform.constants.enums.workorder.ServiceDeskTypeEnum;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class ServiceMyPortalGtr extends BaseCodeGenerator {
    public ServiceMyPortalGtr() {
        super(WorkorderTables.WO_SERVICE_MY_PORTAL.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


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
        ServiceMyPortalGtr g=new ServiceMyPortalGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(ServiceDeskServiceProxy.class, ServiceDeskPageController.class);
    }
}
