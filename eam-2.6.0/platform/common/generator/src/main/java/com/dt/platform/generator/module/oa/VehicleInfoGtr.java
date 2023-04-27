package com.dt.platform.generator.module.oa;
import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.generator.config.Config;

import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class VehicleInfoGtr extends BaseCodeGenerator {


    public VehicleInfoGtr() {
        super(OaTables.OA_VEHICLE_INFO.$TABLE,CAR_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"vehicleTypeDict","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"vehicleStatusDict","状态","状态");



        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","使用人","使用人");

        cfg.getPoClassFile().addSimpleProperty(String.class,"selectIds","车辆列表","车辆列表");

        cfg.view().field(OaTables.OA_VEHICLE_INFO.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.NAME).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.VEHICLE_CODE).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.REGISTRANT).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.ENGINE_NUMBER).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.FRAME_NUMBER).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.DRIVING_LICENSE).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.NOTES).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.INSURANCE_COMPANY).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.LICENSING_TIME).search().search().range();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.SCRAP_TIME).search().search().range();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.INSURANCE_EXPIRE_DATE).search().search().range();

        cfg.view().field(OaTables.OA_VEHICLE_INFO.NOTES).table().disable();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.TECHNICAL_PARAMETER).table().disable();

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_VEHICLE_INFO.VEHICLE_STATUS,
                        OaTables.OA_VEHICLE_INFO.TYPE,
                        OaTables.OA_VEHICLE_INFO.VEHICLE_CODE,
                        OaTables.OA_VEHICLE_INFO.MODEL,
                },
                new Object[]{
                        OaTables.OA_VEHICLE_INFO.ENGINE_NUMBER,
                        OaTables.OA_VEHICLE_INFO.FRAME_NUMBER,
                        OaTables.OA_VEHICLE_INFO.DRIVING_LICENSE,
                        OaTables.OA_VEHICLE_INFO.REGISTRANT,
                },
                new Object[]{
                        OaTables.OA_VEHICLE_INFO.INSURANCE_EXPIRE_DATE,
                        OaTables.OA_VEHICLE_INFO.INSURANCE_COMPANY,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        //form
        cfg.view().field(OaTables.OA_VEHICLE_INFO.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.MODEL).form().validate().required();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.VEHICLE_CODE).form().validate().required();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.TYPE).form().validate().required();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.VEHICLE_STATUS).form().validate().required();
//


        cfg.view().field(OaTables.OA_VEHICLE_INFO.RESCUE_MONEY).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.PICTURES).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.COLOR).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.COMMERCIAL_INSURANCE_MONEY).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.CREATE_TIME).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.ORIGINATOR_ID).table().disable(true);

        //前端还在
        cfg.view().field(OaTables.OA_VEHICLE_INFO.LICENSING_TIME).table().hidden(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.SCRAP_TIME).table().hidden(true);


        cfg.view().field(OaTables.OA_VEHICLE_INFO.LICENSING_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.SCRAP_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.INSURANCE_EXPIRE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OaTables.OA_VEHICLE_INFO.RESCUE_DUE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(OaTables.OA_VEHICLE_INFO.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OaTables.OA_VEHICLE_INFO.TECHNICAL_PARAMETER).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OaTables.OA_VEHICLE_INFO.COMMERCIAL_INSURANCE_MONEY).form().numberInput().decimal().scale(2);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.CAR_BOAT_TAX).form().numberInput().decimal().scale(2);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.RESCUE_MONEY).form().numberInput().decimal().scale(2);

        cfg.view().field(OaTables.OA_VEHICLE_INFO.VEHICLE_STATUS)
                .basic().label("车辆状态")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=vehicle_status")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InfoMeta.VEHICLE_STATUS_DICT ).muliti(false);

        cfg.view().field(OaTables.OA_VEHICLE_INFO.TYPE)
                .basic().label("车辆类型")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=vehicle_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InfoMeta.VEHICLE_TYPE_DICT).muliti(false);


        cfg.view().field(OaTables.OA_VEHICLE_INFO.OWNER_ORG_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.OWNER_ORG_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(OaTables.OA_VEHICLE_INFO.USE_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(OaTables.OA_VEHICLE_INFO.USE_ORG_ID).table().fillBy("useOrganization","fullName");



        cfg.view().field(OaTables.OA_VEHICLE_INFO.USE_USER_ID).table().fillBy("useUser","name");
        cfg.view().field(OaTables.OA_VEHICLE_INFO.USE_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(OaTables.OA_VEHICLE_INFO.PICTURES)
                .form().label("图片").upload().buttonLabel("选择图片").maxFileCount(3).displayFileName(false);



        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.VEHICLE_STATUS,
                        OaTables.OA_VEHICLE_INFO.TYPE,
                        OaTables.OA_VEHICLE_INFO.REGISTRANT,
                        OaTables.OA_VEHICLE_INFO.VEHICLE_COUNT,
                },

                new Object[] {
                        OaTables.OA_VEHICLE_INFO.INSURANCE_COMPANY,
                        OaTables.OA_VEHICLE_INFO.INSURANCE_EXPIRE_DATE,
                        OaTables.OA_VEHICLE_INFO.RESCUE_DUE_DATE,
                        OaTables.OA_VEHICLE_INFO.POSITION_DETAIL,
                },
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.OWNER_ORG_ID,
                        OaTables.OA_VEHICLE_INFO.USE_ORG_ID,
                        OaTables.OA_VEHICLE_INFO.USE_USER_ID,

                },
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.RESCUE_MONEY,
                        OaTables.OA_VEHICLE_INFO.CAR_BOAT_TAX,

                        OaTables.OA_VEHICLE_INFO.COMMERCIAL_INSURANCE_MONEY,
                }

        );

        cfg.view().form().addGroup("车辆信息",
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.NAME,
                        OaTables.OA_VEHICLE_INFO.MODEL,
                        OaTables.OA_VEHICLE_INFO.COLOR,
                },
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.VEHICLE_CODE,
                        OaTables.OA_VEHICLE_INFO.DRIVING_LICENSE,
                        OaTables.OA_VEHICLE_INFO.KILOMETERS,
                },
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.ENGINE_NUMBER,
                        OaTables.OA_VEHICLE_INFO.FRAME_NUMBER,
                },
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.LICENSING_TIME,
                        OaTables.OA_VEHICLE_INFO.SCRAP_TIME,
                }
        );
        cfg.view().form().addGroup(null ,
                new Object[] {
                        OaTables.OA_VEHICLE_INFO.TECHNICAL_PARAMETER,
                        OaTables.OA_VEHICLE_INFO.NOTES,
                        OaTables.OA_VEHICLE_INFO.PICTURES,
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        VehicleInfoGtr g=new VehicleInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(InfoServiceProxy.class, InfoPageController.class);
    }

}
