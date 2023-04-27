package com.dt.platform.generator.module.eam;

import com.dt.platform.generator.config.PlatformConfigs;
import com.dt.platform.generator.menu.MenuGenerator;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.sql.meta.DBTable;

public class BaseCodeGenerator {



    public static final String BASIC_INSP="568078307707326464";


    public static final String BASIC_ASSET_STOCK_ID="513733380219600896";

    public static final String BASIC_BUY_ID="566986193363795968";

    public static final String BASIC_STOCK_GOODS_ID="568725500025896960";

    public static final String BASIC_CY_MENU_ID="475955437510852608";


    public static final String EQ_ID="568076619713875968";




    public static final String BASIC_DATA_MENU_ID="471620638545543168";
    public static final String BASIC_SETTING_MENU_ID="471986431431016449";

    public static final String BASIC_ASSET_MGR_MENU_ID="471985490283724800";

    public static final String BASIC_ASSET_CHANGE_MENU_ID="479208678382108672";

    public static final String BASIC_ASSET_NZ_MENU_ID="489424103724285952";

    public static final String BASIC_ASSET_REAPIR_MENU_ID="479208678382108672";


    public static final String BASIC_ASSET_INVENTORY_MENU_ID="471985681850171393";


    public static final String BASIC_ASSET_SOFT_MENU_ID="479388413435314177";



    public static final String BASIC_MOBILE="471985681850171393";


    //
    private String appId="service-eam";

    private String appConfigPrefix= "service-eam";

    private String tablePrefix="eam_";

    private PlatformConfigs configs;

    private DBTable table;

    private String parentMenuId;

    protected ModuleContext cfg;

    public BaseCodeGenerator(DBTable table,String parentMenuId) {
        this.table=table;
        this.parentMenuId=parentMenuId;
        configs=new PlatformConfigs(appConfigPrefix);
        cfg=createModuleConfig();
    }

    private Class proxyType;
    private Class pageType;
    public BaseCodeGenerator(Class proxyType,Class pageType,DBTable table, String parentMenuId) {
        this.pageType=pageType;
        this.proxyType=proxyType;
        this.table=table;
        this.parentMenuId=parentMenuId;
        configs=new PlatformConfigs(appConfigPrefix);
        cfg=createModuleConfig();

    }
    public BaseCodeGenerator(Class proxyType,Class pageType,DBTable table, String parentMenuId,String tabPrefix) {
        this.pageType=pageType;
        this.proxyType=proxyType;

        if(tablePrefix!=null){
            this.tablePrefix=tabPrefix;
        }
        this.table=table;
        this.parentMenuId=parentMenuId;
        configs=new PlatformConfigs(appConfigPrefix);
        cfg=createModuleConfig();
    }
    public void generateMenu(){
        generateMenu(proxyType,pageType);
    }
    public void reGenerateMenu(){
        DAO dao= this.configs.getDAO();
        System.out.println("current table:"+ this.table.name());
        RcdSet resource_rs= dao.query("select * from sys_resourze where table_name=? and deleted=0",this.table.name());
        if(resource_rs.size()>0){
            String batch_id=resource_rs.getRcd(0).getString("batch_id");
            System.out.println("current batch_id:"+batch_id);
            RcdSet menu_rs=dao.query("select * from sys_menu where batch_id=?",batch_id);
            if(menu_rs.size()>0){
                String parent_id=menu_rs.getRcd(0).getString("parent_id");
                System.out.println("current parent_id:"+parent_id);
                removeByBatchId(batch_id);
                this.parentMenuId=parent_id;
                generateMenu(proxyType,pageType);
            }
        }
    }


    public ModuleContext createModuleConfig(DBTable table, String tablePrefix, int apiSort) {

        //项目配置
        PlatformConfigs.ProjectConfigs procfg=this.configs.getProjectConfigs();

        ModuleContext mdu=new ModuleContext(this.configs.getSettings(),table,tablePrefix,procfg.getAppPackageName());
        //设置页面的代码文件路径
        mdu.setViewPrefixPath(procfg.getAppViewPrefixPath());
        //设置页面访问的基础URI
        mdu.setViewPrefixURI(procfg.getAppViewPrefixURI());
        //设置 DAO
        mdu.setDAO(this.configs.getDAO());
        //设置 Domain Project
        mdu.setDomainProject(this.configs.getDomianProject());
        //设置 Proxy Project
        mdu.setProxyProject(this.configs.getProxyProject());
        //设置 Service Project
        mdu.setServiceProject(this.configs.getServiceProject());
        //设置 View Project
        mdu.setViewProject(this.configs.getViewProject());
        //设置 Wrapper Project
        mdu.setWrapperProject(this.configs.getWrapperProject());
        //设置DAO名称常量
        mdu.setDAONameConsts(procfg.getDAONameConst());
        //设置微服务命名常量
        mdu.setMicroServiceNameConst(ServiceNames.class.getName()+"."+procfg.getAppMicroServiceNameConst());
        return mdu;
    }

    public ModuleContext createModuleConfig(int apiSort) {
        return createModuleConfig(this.table, tablePrefix, apiSort);
    }

    public ModuleContext createModuleConfig() {
        return createModuleConfig(this.table, tablePrefix, 1);
    }

    public void removeByBatchId(String batchId) {
        MenuGenerator mg=new MenuGenerator(appId,MenuGenerator.SUPER_ADMIN_ROLE_ID,table, null, null);
        mg.removeByBatchId(batchId);
    }

    public void generateMenu(Class proxyType, Class pageType){
        MenuGenerator mg=new MenuGenerator(appId,MenuGenerator.SUPER_ADMIN_ROLE_ID,table, proxyType, pageType);
        mg.generate(parentMenuId);
    }


}
