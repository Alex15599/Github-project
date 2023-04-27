package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.CertificateLevel;
import com.dt.platform.domain.hr.meta.CertificateLevelMeta;
import com.dt.platform.domain.hr.meta.CertificateTypeMeta;
import com.dt.platform.domain.hr.CertificateType;
import com.dt.platform.domain.hr.meta.CertificateMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.hr.CertificateLevelServiceProxy;
import com.dt.platform.proxy.hr.CertificateTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmCertGtr extends BaseCodeGenerator {
    public HrmCertGtr() {
        super(HrTables.HR_CERTIFICATE.$TABLE,"666923829754331136");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(CertificateType.class,"certificateType","certificateType","certificateType");
        cfg.getPoClassFile().addSimpleProperty(CertificateLevel.class,"certificateLevel","certificateLevel","certificateLevel");



        cfg.view().field(HrTables.HR_CERTIFICATE.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_CERTIFICATE.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_CERTIFICATE.TYPE,
                        HrTables.HR_CERTIFICATE.CERT_LEVEL,
                        HrTables.HR_CERTIFICATE.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);




        cfg.view().field(HrTables.HR_CERTIFICATE.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_CERTIFICATE.TYPE).form().validate().required()
                .form().selectBox().queryApi(CertificateTypeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(CertificateTypeMeta.ID).
                textField(CertificateTypeMeta.NAME).
                fillWith(CertificateMeta.CERTIFICATE_TYPE).muliti(false);


        cfg.view().field(HrTables.HR_CERTIFICATE.CERT_LEVEL).form().validate().required()
                .form().selectBox().queryApi(CertificateLevelServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(CertificateLevelMeta.ID).
                textField(CertificateLevelMeta.NAME).
                fillWith(CertificateMeta.CERTIFICATE_LEVEL).muliti(false);

        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_CERTIFICATE.TYPE,
                        HrTables.HR_CERTIFICATE.NAME,
                        HrTables.HR_CERTIFICATE.CERT_LEVEL,
                        HrTables.HR_CERTIFICATE.NOTE,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmCertGtr g=new HrmCertGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(CertificateServiceProxy.class, CertificatePageController.class);
    }
}
