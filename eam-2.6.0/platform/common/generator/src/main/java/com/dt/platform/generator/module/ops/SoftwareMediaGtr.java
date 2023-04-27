package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.SoftwareMedia;
import com.dt.platform.domain.ops.meta.SoftwareMediaMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.SoftwareMediaPageController;
import com.dt.platform.proxy.ops.SoftwareMediaServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class SoftwareMediaGtr extends BaseCodeGenerator{


    public SoftwareMediaGtr() {
        super(OpsTables.OPS_SOFTWARE_MEDIA.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeData","typeData","typeData");
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_SOFTWARE_BASE_TYPE.NOTES).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SOFTWARE_MEDIA.TYPE,
                        OpsTables.OPS_SOFTWARE_MEDIA.STATUS,
                        OpsTables.OPS_SOFTWARE_MEDIA.NAME,
                        OpsTables.OPS_SOFTWARE_MEDIA.NOTES,

                }
        );
        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.ID).table().disable(true);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
       // cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.TYPE).form().validate().required().form().selectBox().d
        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.FILE_ID).basic().label("介质").form().upload().buttonLabel("附件").maxFileCount(1).acceptAllType();



        cfg.view().field(OpsTables.OPS_SOFTWARE_MEDIA.TYPE).form().validate().required()
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_software_media")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(SoftwareMediaMeta.TYPE_DATA).muliti(false);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SOFTWARE_MEDIA.NAME,
                        OpsTables.OPS_SOFTWARE_MEDIA.STATUS,
                        OpsTables.OPS_SOFTWARE_MEDIA.CODE,
                        OpsTables.OPS_SOFTWARE_MEDIA.TYPE,
                        OpsTables.OPS_SOFTWARE_MEDIA.FILE_ID,
                        OpsTables.OPS_SOFTWARE_MEDIA.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SoftwareMediaGtr g=new SoftwareMediaGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       //g.generateMenu(SoftwareMediaServiceProxy.class, SoftwareMediaPageController.class);


    }
}
