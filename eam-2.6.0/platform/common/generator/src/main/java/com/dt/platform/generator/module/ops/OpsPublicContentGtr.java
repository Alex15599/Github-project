package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.ops.PublicContent;
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import com.dt.platform.domain.ops.meta.PublicContentMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.PublicContentPageController;
import com.dt.platform.proxy.ops.PublicContentServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsPublicContentGtr extends BaseCodeGenerator{


    public OpsPublicContentGtr() {
        super(OpsTables.OPS_PUBLIC_CONTENT.$TABLE,"472819614665932801");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        //ops_public_list_type
        cfg.getPoClassFile().addListProperty(DictItem.class,"typeData","typeData","typeData");

        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.NOTES).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.FILES).form().upload().maxFileCount(1).acceptSingleFile();
        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.NAME).form().validate().required();

        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_PUBLIC_CONTENT.TYPE,
                        OpsTables.OPS_PUBLIC_CONTENT.STATUS
                }

        );



        




        cfg.view().field(OpsTables.OPS_PUBLIC_CONTENT.TYPE)

                .table().sort(false)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_public_list_type")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(PublicContentMeta.TYPE_DATA).muliti(false).defaultValue("single");


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(100);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_PUBLIC_CONTENT.NAME,
                        OpsTables.OPS_PUBLIC_CONTENT.TYPE,
                        OpsTables.OPS_PUBLIC_CONTENT.STATUS,
                        OpsTables.OPS_PUBLIC_CONTENT.ADDRESS,
                        OpsTables.OPS_PUBLIC_CONTENT.SORT,
                        OpsTables.OPS_PUBLIC_CONTENT.FILES,
                        OpsTables.OPS_PUBLIC_CONTENT.NOTES,

                }
        );

        cfg.view().list().addToolButton("搜索","dataShare","data-share","ops_public_content:share");
        cfg.view().list().addJsVariable("SHOW_TYPE","[[${showType}]]","showType");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsPublicContentGtr g=new OpsPublicContentGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(PublicContentServiceProxy.class, PublicContentPageController.class);
    }
}
