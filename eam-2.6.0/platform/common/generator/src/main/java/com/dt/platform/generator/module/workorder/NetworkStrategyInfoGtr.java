package com.dt.platform.generator.module.workorder;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.constants.enums.workorder.NetworkStrategySessionTypeEnum;
import com.dt.platform.constants.enums.workorder.PeriodTypeEnum;
import com.dt.platform.constants.enums.workorder.ProtocolTypeEnum;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class NetworkStrategyInfoGtr extends BaseCodeGenerator {


    public NetworkStrategyInfoGtr() {
        super(WorkorderTables.WO_NETWORK_STRATEGY_INFO.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {


        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.SOURCE_IP).search().fuzzySearch();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_IP).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.SOURCE_IP,
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.SOURCE_NAME,
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_NAME,
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_IP,
                }
        );


        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.ID).basic().hidden(true);
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.ID).table().disable(true);
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.SELECTED_CODE).table().disable(true);
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.OWNER_ID).table().disable(true);
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.NOTES).form().textArea().height(Config.textAreaHeight).search().fuzzySearch();

        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.SESSION_TYPE).form()
                .radioBox().enumType(NetworkStrategySessionTypeEnum.class).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.USED_PROTOCOL_TYPE).form()
                .selectBox().enumType(ProtocolTypeEnum.class).defaultIndex(0);




        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.USED_PROTOCOL_TYPE).form().validate().required();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.SESSION_TYPE).form().validate().required();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.SOURCE_NAME).form().validate().required().search().fuzzySearch();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.SOURCE_IP).form().validate().required().search().fuzzySearch();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_NAME).form().validate().required().search().fuzzySearch();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_IP).form().validate().required().search().fuzzySearch();

        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_PORTS).form().validate().required().search().fuzzySearch();

        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);

        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.USED_PROTOCOL_TYPE,
                },
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.SESSION_TYPE
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.SOURCE_NAME,
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.SOURCE_IP,
                },
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_NAME,
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_IP,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.TARGET_PORTS,
                        WorkorderTables.WO_NETWORK_STRATEGY_INFO.NOTES,
                }
        );

        cfg.view().list().addJsVariable("ownerId",   "[[${ownerId}]]","ownerId");
        cfg.view().list().addJsVariable("pageType",   "[[${pageType}]]","pageType");
        cfg.view().list().addJsVariable("selectedCode",   "[[${selectedCode}]]","selectedCode");


        cfg.view().list().disableBatchDelete();
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
        NetworkStrategyInfoGtr g=new NetworkStrategyInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
      //  g.generateMenu(NetworkStrategyInfoServiceProxy.class,  NetworkStrategyInfoPageController.class);
    }

}
