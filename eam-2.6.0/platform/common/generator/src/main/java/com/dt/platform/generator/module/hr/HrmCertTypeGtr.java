package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.CertificateLevel;
import com.dt.platform.domain.hr.PositionType;
import com.dt.platform.domain.hr.meta.CertificateLevelMeta;
import com.dt.platform.domain.hr.meta.CertificateTypeMeta;
import com.dt.platform.domain.hr.meta.PositionMeta;
import com.dt.platform.domain.hr.meta.PositionTypeMeta;
import com.dt.platform.domain.ops.Certificate;
import com.dt.platform.domain.ops.CertificateType;
import com.dt.platform.domain.ops.meta.CertificateMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.CertificateTypePageController;
import com.dt.platform.proxy.hr.CertificateLevelServiceProxy;
import com.dt.platform.proxy.hr.CertificateTypeServiceProxy;
import com.dt.platform.proxy.hr.PositionTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmCertTypeGtr extends BaseCodeGenerator {
    public HrmCertTypeGtr() {
        super(HrTables.HR_CERTIFICATE_TYPE.$TABLE,"666923829754331136");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_CERTIFICATE_TYPE.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_CERTIFICATE_TYPE.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_CERTIFICATE_TYPE.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(HrTables.HR_CERTIFICATE_TYPE.NAME).form().validate().required();


        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_CERTIFICATE_TYPE.NAME,
                        HrTables.HR_CERTIFICATE_TYPE.SORT,
                        HrTables.HR_CERTIFICATE_TYPE.NOTE,
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
        HrmCertTypeGtr g=new HrmCertTypeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(CertificateTypeServiceProxy.class, CertificateTypePageController.class);
    }
}
