package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetItem;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetItemGtr extends BaseCodeGenerator {

    public EamAssetItemGtr() {
        super(EAMTables.EAM_ASSET_ITEM.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_ITEM.ID,
                }
        );

        //指定该表为关系表
       // cfg.setRelationField(Asset.class,EAMTables.EAM_ASSET_ITEM.HANDLE_ID, AssetItem.class,EAMTables.EAM_ASSET_ITEM.ASSET_ID,true);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        ; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetItemGtr g=new EamAssetItemGtr();

        //生成代码
        g.generateCode();
        //生成菜单
//        g.generateMenu(MaintainerServiceProxy.class,MaintainerPageController.class);
    }

}
