package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetMaintenanceRecordBatchUpdateTypeEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetMaintenanceUpdate;
import com.dt.platform.domain.eam.AssetStatus;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUMeta;
import com.dt.platform.domain.eam.meta.MaintainerMeta;
import com.dt.platform.eam.page.AssetMaintenanceRecordUPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetMaintenanceRecordUServiceProxy;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamAssetMaintenanceRecordUpdateGtr extends BaseCodeGenerator{
    public EamAssetMaintenanceRecordUpdateGtr() {
        super(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.$TABLE,"638424019464355840");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(String.class,"recordIdList","recordIdList","recordIdList");

        cfg.getPoClassFile().addSimpleProperty(Maintainer.class,"maintnainer","维保商","维保商");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"assetMaintenanceStatus","维保状态","维保状态");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"suggestMaintenanceMethodData","建议维保方式","建议维保方式");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintenanceMethodData","维保方式","维保方式");
        cfg.getPoClassFile().addSimpleProperty(AssetMaintenanceUpdate.class,"assetMaintenanceUpdate","assetMaintenanceUpdate","assetMaintenanceUpdate");

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTAINER_ID,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_STATUS,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_METHOD,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.SUGGEST_MAINTENANCE_METHOD,
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
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTAINER_ID).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTAINER_NAME).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_STATUS).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_METHOD).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_SUGGEST_MAINTENANCE_METHOD).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_CONTACTS).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_CONTACT_INFORMATION).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_DIRECTOR).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_START_DATE).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_END_DATE).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_NOTES).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTAINER_ID).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTAINER_NAME).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_STATUS).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_METHOD).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_SUGGEST_MAINTENANCE_METHOD).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_CONTACTS).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_CONTACT_INFORMATION).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_DIRECTOR).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_START_DATE).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_END_DATE).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_NOTES).form().validate().required().form().radioBox().enumType(AssetMaintenanceRecordBatchUpdateTypeEnum.class).defaultValue(AssetMaintenanceRecordBatchUpdateTypeEnum.NONE.code());



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



        cfg.view().form().labelWidth(150);
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_UPDATE_ID).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_END_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_START_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTAINER_ID)
                .basic().label("维保商")
                .form().selectBox().queryApi(MaintainerServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(MaintainerMeta.ID).
                textField(MaintainerMeta.MAINTAINER_NAME).
                fillWith(AssetMaintenanceRecordUMeta.MAINTNAINER).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_STATUS)
                .basic().label("维保状态")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintenance_status")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_STATUS).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_METHOD)
                .basic().label("维保方式")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintenance_method")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD_DATA).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.SUGGEST_MAINTENANCE_METHOD)
                .basic().label("建议维保方式")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_suggest_maintenance_method")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD_DATA).muliti(false);


        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup("维保商",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTAINER_ID,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_MAINTAINER_ID,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTAINER_ID,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTAINER_ID,
                }
        );
        cfg.view().form().addGroup("维保厂商名称",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTAINER_NAME,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_MAINTAINER_NAME,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTAINER_NAME,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTAINER_NAME,
                }
        );
        cfg.view().form().addGroup("维保状态",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_STATUS,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_MAINTENANCE_STATUS,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_STATUS,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_STATUS,
                }
        );
        cfg.view().form().addGroup("维保方式",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_METHOD,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_MAINTENANCE_METHOD,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_METHOD,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_METHOD,
                }
        );
        cfg.view().form().addGroup("建议维保方式",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.SUGGEST_MAINTENANCE_METHOD,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_SUGGEST_MAINTENANCE_METHOD,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_SUGGEST_MAINTENANCE_METHOD,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_SUGGEST_MAINTENANCE_METHOD,
                }
        );
        cfg.view().form().addGroup("联系人",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.CONTACTS,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_CONTACTS,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_CONTACTS,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_CONTACTS,
                }
        );
        cfg.view().form().addGroup("联系方式",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.CONTACT_INFORMATION,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_CONTACT_INFORMATION,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_CONTACT_INFORMATION,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_CONTACT_INFORMATION,
                }
        );

        cfg.view().form().addGroup("负责人",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.DIRECTOR,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_DIRECTOR,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_DIRECTOR,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_DIRECTOR,
                }
        );

        cfg.view().form().addGroup("维保开始时间",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_START_DATE,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_MAINTENANCE_START_DATE,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_START_DATE,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_START_DATE,
                }
        );

        cfg.view().form().addGroup("维保结束时间",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_END_DATE,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_MAINTENANCE_END_DATE
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_END_DATE,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_END_DATE

                }
        );
        cfg.view().form().addGroup("维保备注",
                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_NOTES,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.S_MAINTENANCE_NOTES,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_MAINTENANCE_NOTES,
                        EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.U_S_MAINTENANCE_NOTES,
                }
        );
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableFormView();


        cfg.view().form().addJsVariable("MAINTENANCE_UPDATE_ID","[[${maintenanceUpdateId}]]","maintenanceUpdateId");
        cfg.view().list().addJsVariable("MAINTENANCE_UPDATE_ID","[[${maintenanceUpdateId}]]","maintenanceUpdateId");
        cfg.view().form().addJsVariable("IDS","[[${ids}]]","ids");

        cfg.view().search().rowsDisplay(1);
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表q`HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetMaintenanceRecordUpdateGtr g=new EamAssetMaintenanceRecordUpdateGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetMaintenanceRecordUServiceProxy.class, AssetMaintenanceRecordUPageController.class);
    }
}
