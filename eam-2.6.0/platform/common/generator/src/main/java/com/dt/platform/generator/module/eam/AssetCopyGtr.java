package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.AssetCopyPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetCopyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class AssetCopyGtr extends BaseCodeGenerator{
    public AssetCopyGtr() {
        super(EAMTables.EAM_ASSET_COPY.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


//        1、为了保证复制速度，一次最多可复制500个资产
//        2、以下资产信息不可被复制：资产编码、资产编码（旧）、设备序列号、使用人、领用日期、入库时间、累计折旧、残值、净值
//        3、复制后的资产状态为空闲


        cfg.view().field(EAMTables.EAM_ASSET_COPY.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_COPY.ASSET_ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_ASSET_COPY.ASSET_NUMBER).form().validate().required().form().numberInput().integer().scale(0).defaultValue(1).allowNegative(false);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_COPY.ASSET_NUMBER,
                }
        );

        cfg.view().list().addJsVariable("ASSET_ID","[[${assetId}]]","assetId");
        cfg.view().form().addJsVariable("ASSET_ID","[[${assetId}]]","assetId");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AssetCopyGtr g=new AssetCopyGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetCopyServiceProxy.class, AssetCopyPageController.class);
    }
}
