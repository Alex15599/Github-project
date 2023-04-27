package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.ops.*;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicatorType;
import com.dt.platform.domain.ops.MonitorVoucher;
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorMeta;
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorTypeMeta;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.domain.ops.meta.MonitorVoucherMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorTplIndicatorPageController;
import com.dt.platform.proxy.ops.MonitorTplIndicatorServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplIndicatorTypeServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.dt.platform.proxy.ops.MonitorVoucherServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class MonitorTplIndicatorGtr extends BaseCodeGenerator{


    public MonitorTplIndicatorGtr() {
        super(OpsTables.OPS_MONITOR_TPL_INDICATOR.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(MonitorTpl.class,"tpl","节点模版","节点模版");
        cfg.getPoClassFile().addSimpleProperty(MonitorTplIndicatorType.class,"monitorIndicatorType","指标类型","指标类型");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.STATUS,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NAME,

                },
                new Object[]{
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.LABEL,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NOTES,

                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.CODE).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND_VALUE).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.LABEL).search().fuzzySearch();


        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND_VALUE).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND_VALUE).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.CREATE_TIME).table().disable(true);



        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE)
                .basic().label("模版")
                .form().validate().required().form().selectBox().queryApi(MonitorTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorTplMeta.CODE).
                textField(MonitorTplMeta.NAME).
                fillWith(MonitorTplIndicatorMeta.TPL).muliti(false);


        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.INDICATOR_TYPE)
                .basic().label("指标类型")
                .form().validate().required().form().selectBox().queryApi(MonitorTplIndicatorTypeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorTplIndicatorTypeMeta.CODE).
                textField(MonitorTplIndicatorTypeMeta.NAME).
                fillWith(MonitorTplIndicatorMeta.MONITOR_INDICATOR_TYPE).muliti(false);



        cfg.view().field(OpsTables.OPS_MONITOR_TPL.CODE).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.STATUS).form().validate().required().form()
                .label("状态").radioBox().defaultIndex(0).enumType(MonitorEnableEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_METHOD).form().validate().required().form()
                .label("采集方式").selectBox().enumType(MonitorMethodEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_TYPE).form()
                .label("数值类型").selectBox().enumType(MonitorIndicatorValueColumnTypeEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_ROWS).form()
                .label("数值行数").selectBox().enumType(MonitorIndicatorValueColumnRowsEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_COLS).form()
                .label("数值列数").selectBox().enumType(MonitorIndicatorValueColumnColsEnum.class);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");


        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NAME,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.LABEL,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.STATUS,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.INDICATOR_TYPE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_METHOD,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.TIME_OUT,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.DATA_KEEP_DAY,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.ITEM_SORT,
                }
        );


        cfg.view().form().addGroup("填充信息",
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_TYPE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_NAME,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_COLS,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_ROWS,

                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_MAP,

                }
        );

        cfg.view().form().addGroup("SNMP信息",
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.SNMP_OID
                }
        );

        cfg.view().form().addGroup("其他信息",
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.INDICATOR_VARIABLE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NOTES
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MonitorTplIndicatorGtr g=new MonitorTplIndicatorGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
       //  g.generateMenu(MonitorTplIndicatorServiceProxy.class, MonitorTplIndicatorPageController.class);
    }
}
