package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetMaintenanceUpdateHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusTypeEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.AssetStatusMeta;
import com.dt.platform.domain.eam.meta.MaintainerMeta;
import com.dt.platform.domain.ops.meta.HostExByHostMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.eam.page.AssetMaintenanceRecordPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetMaintenanceRecordServiceProxy;
import com.dt.platform.proxy.eam.AssetStatusServiceProxy;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamAssetMaintenanceRecordGtr extends BaseCodeGenerator{
    public EamAssetMaintenanceRecordGtr() {
        super(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.$TABLE,"638424019464355840");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");

        cfg.getPoClassFile().addSimpleProperty(String.class,"assetAssetName","资产名称","资产名称");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetAssetCode","资产编码","资产编码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetAssetModel","资产型号","资产型号");


        cfg.getPoClassFile().addSimpleProperty(AssetStatus.class,"assetStatus","资产状态","资产状态");
        cfg.getPoClassFile().addSimpleProperty(Catalog.class,"category","资产分类","资产分类");

        cfg.getPoClassFile().addSimpleProperty(String.class,"assetAssetStatus","资产状态","资产状态");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetAssetCatalog","资产状态","资产状态");



        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");
        cfg.getPoClassFile().addSimpleProperty(Maintainer.class,"maintnainer","维保商","维保商");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"assetMaintenanceStatus","维保状态","维保状态");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"suggestMaintenanceMethodData","建议维保方式","建议维保方式");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintenanceMethodData","维保方式","维保方式");

        cfg.getPoClassFile().addSimpleProperty(AssetMaintenanceUpdate.class,"assetMaintenanceUpdate","assetMaintenanceUpdate","assetMaintenanceUpdate");

        cfg.view().field(AssetMaintenanceRecordMeta.ASSET_ASSET_NAME)
                .basic().label("资产名称")
                .table().fillBy(AssetMaintenanceRecordMeta.ASSET, "name");


        cfg.view().field(AssetMaintenanceRecordMeta.ASSET_ASSET_CODE)
                .basic().label("资产编码")
                .table().fillBy(AssetMaintenanceRecordMeta.ASSET, "assetCode");

        cfg.view().field(AssetMaintenanceRecordMeta.ASSET_ASSET_MODEL)
                .basic().label("资产型号")
                .table().fillBy(AssetMaintenanceRecordMeta.ASSET, "model");


        cfg.view().field(AssetMaintenanceRecordMeta.ASSET_ASSET_STATUS)
                .basic().label("资产状态")
                .table().fillBy(AssetMaintenanceRecordMeta.ASSET_STATUS, "name");

        cfg.view().field(AssetMaintenanceRecordMeta.ASSET_ASSET_CATALOG)
                .basic().label("资产分类")
                .table().fillBy(AssetMaintenanceRecordMeta.CATEGORY, "name");

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTAINER_ID,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_STATUS,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_METHOD,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.SUGGEST_MAINTENANCE_METHOD,
                }

        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        //分成分组布局
       // cfg.view().list().disableCreateNew();
      //  cfg.view().list().disableModify();
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTAINER_ID).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTAINER_NAME).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_METHOD).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_SUGGEST_MAINTENANCE_METHOD).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_CONTACTS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_CONTACT_INFORMATION).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_DIRECTOR).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_START_DATE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_END_DATE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_NOTES).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultValue(StatusEnableEnum.DISABLE.code());


        cfg.view().form().labelWidth(200);
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_UPDATE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.ASSET_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_END_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_START_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTAINER_ID)
                .basic().label("维保商")
                .form().selectBox().queryApi(MaintainerServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(MaintainerMeta.ID).
                textField(MaintainerMeta.MAINTAINER_NAME).
                fillWith(AssetMaintenanceRecordMeta.MAINTNAINER).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_STATUS)
                .basic().label("维保状态")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintenance_status")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_STATUS).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_METHOD)
                .basic().label("维保方式")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintenance_method")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD_DATA).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.SUGGEST_MAINTENANCE_METHOD)
                .basic().label("建议维保方式")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_suggest_maintenance_method")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD_DATA).muliti(false);


        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTAINER_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTAINER_ID,
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTAINER_NAME,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTAINER_NAME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_STATUS,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_STATUS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_METHOD,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_METHOD,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.SUGGEST_MAINTENANCE_METHOD,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_SUGGEST_MAINTENANCE_METHOD,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.CONTACTS,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_CONTACTS,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.CONTACT_INFORMATION,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_CONTACT_INFORMATION,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.DIRECTOR,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_DIRECTOR,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_START_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_START_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_END_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_END_DATE
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_NOTES,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD.S_MAINTENANCE_NOTES,
                }
        );
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableFormView();
        cfg.view().list().addToolButton( "选择资产","selectAsset",null,null);
        cfg.view().list().addToolButton( "导入资产","importAsset",null,null);
        cfg.view().list().addToolButton( "批量修改","batchModify",null,null);
        cfg.view().list().addToolButton( "数据填充","dataFill",null,null);
        cfg.view().list().addToolButton( "完成操作","finish",null,null);

        cfg.view().form().addJsVariable("MAINTENANCE_UPDATE_ID","[[${maintenanceUpdateId}]]","maintenanceUpdateId");
        cfg.view().list().addJsVariable("MAINTENANCE_UPDATE_ID","[[${maintenanceUpdateId}]]","maintenanceUpdateId");
        cfg.view().list().addJsVariable("MAINTENANCE_UPDATE_DATA","[[${maintenanceUpdateData}]]","maintenanceUpdateData");

        cfg.view().search().rowsDisplay(1);
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetMaintenanceRecordGtr g=new EamAssetMaintenanceRecordGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(AssetMaintenanceRecordServiceProxy.class, AssetMaintenanceRecordPageController.class);
    }
}
