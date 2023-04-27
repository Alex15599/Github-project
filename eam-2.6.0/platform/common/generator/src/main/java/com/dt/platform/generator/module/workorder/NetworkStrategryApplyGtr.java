package com.dt.platform.generator.module.workorder;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.workorder.PeriodTypeEnum;
import com.dt.platform.constants.enums.workorder.ResourceRunEnvironmentEnum;
import com.dt.platform.domain.workorder.NetworkStrategyApply;
import com.dt.platform.domain.workorder.NetworkStrategyInfo;
import com.dt.platform.domain.workorder.meta.NetworkStrategyApplyMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.workorder.NetworkStrategyApplyServiceProxy;
import com.dt.platform.workorder.page.NetworkStrategyApplyPageController;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class NetworkStrategryApplyGtr extends BaseCodeGenerator {


    public NetworkStrategryApplyGtr() {
        super(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        cfg.getPoClassFile().addListProperty(NetworkStrategyInfo.class,"networkStrategyInfoList","networkStrategyInfoList","networkStrategyInfoList");
        cfg.getPoClassFile().addListProperty(String.class,"networkStrategyIds","NetworkStrategyIds","NetworkStrategyIds");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(String.class,"originatorUserName","申请人","申请人");

        cfg.bpm().form("wo_network_strategy_apply");
        cfg.bpm().integrate(IntegrateMode.FRONT);

        cfg.view().search().inputLayout(
                new Object[]{
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.STATUS,
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.NAME,
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.PROJECT_NAME
                }
        );
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.ID).basic().hidden(true);
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.ID).table().disable(true);
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.FILE_ID).table().disable(true);

        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.CONTENT).table().disable(true);
        cfg.view().field(NetworkStrategyApplyMeta.ORIGINATOR_USER_NAME).table().disable(true);

        cfg.view().field(NetworkStrategyApplyMeta.ORIGINATOR_USER_NAME).table().label("申请人").form().label("申请人")
                .form().fillBy("originator","name");
        cfg.view().field(NetworkStrategyApplyMeta.ORIGINATOR_ID).table().fillBy("originator","name");





        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.ENVIRONMENT_ID).form().validate().required().form()
                .radioBox().enumType(ResourceRunEnvironmentEnum.class).defaultIndex(0);

        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.PERIOD_TYPE).form().validate().required().form()
                .label("使用期限").radioBox().enumType(PeriodTypeEnum.class).defaultIndex(0);



        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.APPLY_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.EXPIRATION_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.EXPECTED_COMPLETION_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
 //       cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.COMPLETION_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.FILE_ID)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleImage().maxFileCount(1).displayFileName(false);

        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.CONTENT).form().textArea().height(Config.textAreaHeight).search().fuzzySearch();


        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.NAME).form().validate().required();
        cfg.view().field(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.PROJECT_NAME).form().validate().required();


        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.NAME,
                },
                new Object[] {
                        NetworkStrategyApplyMeta.ORIGINATOR_USER_NAME,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.PROJECT_NAME,
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.ENVIRONMENT_ID,
                },
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.PERIOD_TYPE,
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.EXPECTED_COMPLETION_DATE,
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.EXPIRATION_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.CONTENT,
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        WorkorderTables.WO_NETWORK_STRATEGY_APPLY.FILE_ID,
                }
        );


        cfg.view().list().disableBatchDelete();

        cfg.view().form().addPage("资源信息","assetSelectList");

        cfg.view().list().addJs("/extmodule/commonFunction/commonFunction.js");



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
        NetworkStrategryApplyGtr g=new NetworkStrategryApplyGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
    //  g.generateMenu(NetworkStrategyApplyServiceProxy.class, NetworkStrategyApplyPageController.class);



    }

}
