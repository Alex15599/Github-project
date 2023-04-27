package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.IpAddressRange;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.meta.IpAddressRangeMeta;
import com.dt.platform.domain.ops.meta.ServiceCategoryMeta;
import com.dt.platform.domain.ops.meta.ServiceGroupMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.IpAddressRangePageController;
import com.dt.platform.proxy.ops.IpAddressRangeServiceProxy;
import com.dt.platform.proxy.ops.ServiceCategoryServiceProxy;
import com.dt.platform.proxy.ops.ServiceGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsIpAddressSegGtr extends BaseCodeGenerator{


    public OpsIpAddressSegGtr() {
        super(OpsTables.OPS_IP_ADDRESS_RANGE.$TABLE,"605507841310064640");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"regionDict","regionDict","regionDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"classDict","classDict","classDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"prodDict","prodDict","prodDict");

        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.SCENE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_IP_ADDRESS_RANGE.STATUS,
                        OpsTables.OPS_IP_ADDRESS_RANGE.PROD_ID,
                        OpsTables.OPS_IP_ADDRESS_RANGE.REGION_ID,
                        OpsTables.OPS_IP_ADDRESS_RANGE.CLASS_ID,
                },
                new Object[]{
                        OpsTables.OPS_IP_ADDRESS_RANGE.ADDRESS_SEGMENT,
                        OpsTables.OPS_IP_ADDRESS_RANGE.SCENE,
                        OpsTables.OPS_IP_ADDRESS_RANGE.NOTES,
                }
        );


        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.ADDRESS_SEGMENT).form().validate().required();

        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.STATUS).basic()
                .form().validate().required()
                .form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.REGION_ID)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_network_ip_region")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(IpAddressRangeMeta.REGION_DICT).muliti(false).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.PROD_ID)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_network_ip_prod")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(IpAddressRangeMeta.PROD_DICT).muliti(false).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_IP_ADDRESS_RANGE.CLASS_ID)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_network_ip_class")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(IpAddressRangeMeta.CLASS_DICT).muliti(false).defaultIndex(0);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);

        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_IP_ADDRESS_RANGE.ADDRESS_SEGMENT,
                        OpsTables.OPS_IP_ADDRESS_RANGE.STATUS,
                        OpsTables.OPS_IP_ADDRESS_RANGE.VLAN,
                }, new Object[] {
                        OpsTables.OPS_IP_ADDRESS_RANGE.PROD_ID,
                        OpsTables.OPS_IP_ADDRESS_RANGE.REGION_ID,
                        OpsTables.OPS_IP_ADDRESS_RANGE.CLASS_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_IP_ADDRESS_RANGE.SCENE,
                        OpsTables.OPS_IP_ADDRESS_RANGE.NOTES,
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
        OpsIpAddressSegGtr g=new OpsIpAddressSegGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
    //     g.generateMenu(IpAddressRangeServiceProxy.class, IpAddressRangePageController.class);
    }
}
