package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.CertificateStatusEnum;
import com.dt.platform.constants.enums.ops.OpsAutoAuthMethodEnum;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoNodePageController;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class AutoNodeGtr extends BaseCodeGenerator{


    public AutoNodeGtr() {
        super(OpsTables.OPS_AUTO_NODE.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","typeDict","typeDict");
        cfg.getPoClassFile().addSimpleProperty(AutoGroup.class,"group","group","group");
        cfg.getPoClassFile().addSimpleProperty(AutoVoucher.class,"voucher","voucher","voucher");

        cfg.view().field(OpsTables.OPS_AUTO_NODE.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_NODE.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_NODE.IP).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_NODE.STATUS,
                        OpsTables.OPS_AUTO_NODE.GROUP_ID,
                        OpsTables.OPS_AUTO_NODE.NAME,
                        OpsTables.OPS_AUTO_NODE.IP,
                }
        );


        cfg.view().field(OpsTables.OPS_AUTO_NODE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.STATUS).table().form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.NAME).table().form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_NODE.OWNER_CODE).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.NOTES).table().form().textArea().height(Config.textAreaHeight);


        cfg.view().field(OpsTables.OPS_AUTO_NODE.AUTHENTICATION_METHOD).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.PUB_KEY).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.PASSWORD).table().disable(true);

        cfg.view().field(OpsTables.OPS_AUTO_NODE.IP).table().form().validate().required();


        cfg.view().field(OpsTables.OPS_AUTO_NODE.AUTHENTICATION_METHOD).table().form().validate().required().form().radioBox().enumType(OpsAutoAuthMethodEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.PORT).table().form().validate().required().form().numberInput().defaultValue(22);


        cfg.view().field(OpsTables.OPS_AUTO_NODE.TYPE)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_PAGED_LIST+"?dictCode=ops_auto_node_type")
                .paging(true).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AutoNodeMeta.TYPE_DICT).muliti(false).defaultIndex(0);


        cfg.view().field(OpsTables.OPS_AUTO_NODE.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(AutoGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(AutoGroupMeta.ID).
                textField(AutoGroupMeta.NAME).
                fillWith(AutoNodeMeta.GROUP).muliti(false).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_AUTO_NODE.VOUCHER_ID)
                .basic().label("凭证").form().validate().form()
                .form().selectBox().queryApi(AutoVoucherServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AutoVoucherMeta.ID).
                textField(AutoVoucherMeta.NAME).
                fillWith(AutoNodeMeta.VOUCHER).muliti(false);



        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_NODE.NAME,
                        OpsTables.OPS_AUTO_NODE.IP,
                        OpsTables.OPS_AUTO_NODE.PORT,
                },
                new Object[] {
                        OpsTables.OPS_AUTO_NODE.STATUS,
                        OpsTables.OPS_AUTO_NODE.GROUP_ID,
                        OpsTables.OPS_AUTO_NODE.TYPE,
                }
        );


        cfg.view().form().addGroup("凭证",
                new Object[] {
                        OpsTables.OPS_AUTO_NODE.AUTHENTICATION_METHOD,
                        OpsTables.OPS_AUTO_NODE.VOUCHER_ID,
                },
                new Object[] {
                        OpsTables.OPS_AUTO_NODE.USER_NAME,
                        OpsTables.OPS_AUTO_NODE.PASSWORD,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_NODE.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AutoNodeGtr g=new AutoNodeGtr();
        //生成代码
        g.generateCode();
      //  g.generateMenu(AutoNodeServiceProxy.class, AutoNodePageController.class);
    }
}
