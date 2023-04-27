package com.dt.platform.generator.module.workorder;
import com.dt.platform.constants.db.WorkorderTables;

import com.dt.platform.constants.enums.workorder.*;
import com.dt.platform.domain.workorder.SlbStrategyInfo;
import com.dt.platform.domain.workorder.meta.NetworkStrategyApplyMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.workorder.SlbStrategyInfoServiceProxy;
import com.dt.platform.workorder.page.SlbStrategyInfoPageController;
import com.github.foxnic.generator.config.WriteMode;

public class SlbStrategyInfoGtr extends BaseCodeGenerator {


    public SlbStrategyInfoGtr() {
        super(WorkorderTables.WO_SLB_STRATEGY_INFO.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_NAME).search().fuzzySearch();
        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_IP).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_NAME,
                        WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_IP,
                }
        );

        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.ID).basic().hidden(true);
        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.ID).table().disable(true);
        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.SELECTED_CODE).table().disable(true);
        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.OWNER_ID).table().disable(true);





        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.SESSION_KEEP_METHOD).form().validate().required().form()
                .radioBox().enumType(SlbSessionKeepMethodEnum.class).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.USED_PROTOCOL_TYPE).form().validate().required().form()
                .selectBox().enumType(SlbProtocolTypeEnum.class).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.BALANCE_STRATEGY).form().validate().required().form()
                .selectBox().enumType(BalanceStrategyEnum.class).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.SESSION_KEEP).form().validate().required().form()
                .radioBox().enumType(SlbSessionKeepEnum.class).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_NAME).form().validate().required();
        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_IP).form().validate().required();
        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.NODE_IP).form().validate().required();
        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.PORT).form().validate().required();

        cfg.view().field(WorkorderTables.WO_SLB_STRATEGY_INFO.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(50);



        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_NAME,
                        WorkorderTables.WO_SLB_STRATEGY_INFO.SERVICE_IP,
                },
                new Object[] {
                        WorkorderTables.WO_SLB_STRATEGY_INFO.NODE_IP,
                        WorkorderTables.WO_SLB_STRATEGY_INFO.PORT,
                }
        );



        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SLB_STRATEGY_INFO.BALANCE_STRATEGY,
                        WorkorderTables.WO_SLB_STRATEGY_INFO.SESSION_KEEP,
                },
                new Object[] {
                        WorkorderTables.WO_SLB_STRATEGY_INFO.SESSION_KEEP_METHOD,
                        WorkorderTables.WO_SLB_STRATEGY_INFO.USED_PROTOCOL_TYPE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_SLB_STRATEGY_INFO.NOTES,
                }
        );

        cfg.view().list().addJsVariable("ownerId",   "[[${ownerId}]]","ownerId");
        cfg.view().list().addJsVariable("pageType",   "[[${pageType}]]","pageType");
        cfg.view().list().addJsVariable("selectedCode",   "[[${selectedCode}]]","selectedCode");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SlbStrategyInfoGtr g=new SlbStrategyInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
        //   g.generateMenu(SlbStrategyInfoServiceProxy.class, SlbStrategyInfoPageController.class);
    }

}
