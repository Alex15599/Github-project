package com.dt.platform.relation.modules;

 
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import com.dt.platform.domain.vehicle.meta.ApplyMeta;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import com.dt.platform.domain.workorder.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class WorkOrderRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
		this.setupServerApply();
		this.setupServerInfo();
		this.setupNetworkStrategyApply();
		this.setupSlbStrategyApply();

		this.setupServicePortal();
	}

	public void setupServicePortal() {


		this.property(ServicePortalMeta.GROUP_PROP)
				.using(WorkorderTables.WO_SERVICE_PORTAL.GROUP_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='wo_portal_group'");

	}



	public void setupSlbStrategyApply() {
		//制单人
		this.property(SlbStrategyApplyMeta.ORIGINATOR_PROP)
				.using(WorkorderTables.WO_SLB_STRATEGY_APPLY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}



	public void setupServerApply() {
		//制单人
		this.property(ServerApplyMeta.ORIGINATOR_PROP)
				.using(WorkorderTables.WO_SERVER_APPLY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}

	public void setupServerInfo() {
		//制单人
		this.property(ServerInfoMeta.SERVER_OS_TYPE_PROP)
				.using(WorkorderTables.WO_SERVER_INFO.OS_VERSION).join(WorkorderTables.WO_SERVER_OS_TYPE.ID);

	}

	public void setupNetworkStrategyApply() {
		//制单人
		this.property(NetworkStrategyApplyMeta.ORIGINATOR_PROP)
				.using(WorkorderTables.WO_NETWORK_STRATEGY_APPLY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


	}



	public void setupProperties() {

	}

	private void setupRelations() {

	}

}
