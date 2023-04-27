package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.VoucherPrivPageController;
import com.dt.platform.proxy.ops.VoucherPrivServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.constants.db.OpsTables;
public class OpsVoucherPrivGtr extends BaseCodeGenerator{


    public OpsVoucherPrivGtr() {
        super(OpsTables.OPS_VOUCHER_PRIV.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"employee","人员","人员");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_VOUCHER_PRIV.TYPE,
                        OpsTables.OPS_VOUCHER_PRIV.STATUS,
                        OpsTables.OPS_VOUCHER_PRIV.EMPL_ID
                }
        );
        cfg.view().search().inputWidth(180);


        cfg.view().field(OpsTables.OPS_VOUCHER_PRIV.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_VOUCHER_PRIV.EMPL_ID).form().validate().required().form().button().chooseEmployee(true);
        cfg.view().field(OpsTables.OPS_VOUCHER_PRIV.EMPL_ID).table().fillBy("employee","name");

        cfg.view().field(OpsTables.OPS_VOUCHER_PRIV.TYPE).form().validate().required().form()
                .selectBox().dict(DictEnum.OPS_VOUCHER_TYPE)
                .paging(false).muliti(true).filter(true).toolbar(true).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_VOUCHER_PRIV.STATUS).form().validate().required().form()
                .radioBox().enumType(StatusValidEnum.class).defaultIndex(0);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_VOUCHER_PRIV.TYPE,
                        OpsTables.OPS_VOUCHER_PRIV.STATUS,
                },
                new Object[] {
                        OpsTables.OPS_VOUCHER_PRIV.EMPL_ID,
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsVoucherPrivGtr g=new OpsVoucherPrivGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(VoucherPrivServiceProxy.class, VoucherPrivPageController.class);
    }
}
