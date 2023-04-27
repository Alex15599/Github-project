package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.MobileTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.mobile.ModuleGroup;
import com.dt.platform.domain.mobile.SoftwareGroup;
import com.dt.platform.domain.mobile.SoftwareInfo;
import com.dt.platform.domain.mobile.meta.ModuleGroupMeta;
import com.dt.platform.domain.mobile.meta.ModuleInfoMeta;
import com.dt.platform.domain.mobile.meta.SoftwareGroupMeta;
import com.dt.platform.domain.mobile.meta.SoftwareInfoMeta;
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.github.foxnic.dao.relation.RelationManager;


public class MobileRelationManager extends RelationManager {


    @Override
    protected void config() {
        this.setupRelations();
        this.setupAppModuleInfo();
        this.setupAppModuleGroup();
        this.setupAppSoftwareInfo();
        this.setupAppSoftwareGroup();

    }

    private void setupRelations() {

    }

    private void setupAppSoftwareGroup() {
        this.property(SoftwareGroupMeta.SOFTWARE_INFO_LIST_PROP)
                .using(MobileTables.APP_SOFTWARE_GROUP.ID).join(MobileTables.APP_SOFTWARE_INFO.GROUP_ID);
    }

    private void setupAppSoftwareInfo() {
        this.property(SoftwareInfoMeta.GROUP_PROP)
                .using(MobileTables.APP_SOFTWARE_INFO.GROUP_ID).join(MobileTables.APP_SOFTWARE_GROUP.ID);
    }

    private void setupAppModuleInfo() {
        this.property(ModuleInfoMeta.MODULE_GROUP_PROP)
                .using(MobileTables.APP_MODULE_INFO.GROUP_ID).join(MobileTables.APP_MODULE_GROUP.ID);
    }

    private void setupAppModuleGroup() {
        this.property(ModuleGroupMeta.MODULE_INFO_LIST_PROP)
                .using(MobileTables.APP_MODULE_GROUP.ID).join(MobileTables.APP_MODULE_INFO.GROUP_ID);
    }


}
