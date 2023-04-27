package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoVoucherPageController;
import com.dt.platform.proxy.ops.AutoVoucherServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AutoVoucherGtr extends BaseCodeGenerator{


    public AutoVoucherGtr() {
        super(OpsTables.OPS_AUTO_VOUCHER.$TABLE,"613727231390253056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(OpsTables.OPS_AUTO_VOUCHER.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_VOUCHER.NOTES).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_VOUCHER.NAME,
                        OpsTables.OPS_AUTO_VOUCHER.NOTES,
                }
        );


        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_AUTO_VOUCHER.ID).basic().hidden(true);


        cfg.view().field(OpsTables.OPS_AUTO_VOUCHER.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_VOUCHER.ACCOUNT).form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_VOUCHER.VOUCHER).form().validate().required();
         cfg.view().field(OpsTables.OPS_AUTO_VOUCHER.NOTES).table().form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_VOUCHER.NAME,
                        OpsTables.OPS_AUTO_VOUCHER.ACCOUNT,
                        OpsTables.OPS_AUTO_VOUCHER.VOUCHER,
                        OpsTables.OPS_AUTO_VOUCHER.NOTES,
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
        AutoVoucherGtr g=new AutoVoucherGtr();
        //生成代码
        g.generateCode();
       // g.generateMenu(AutoVoucherServiceProxy.class, AutoVoucherPageController.class);
    }
}
