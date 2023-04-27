package com.dt.platform.relation;

import com.dt.platform.relation.modules.*;
import com.dt.platform.relation.modules.HrmRelationManager;
import com.foxnicweb.web.relation.modules.ContractRelationManager;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.relation.FoxnicWebRelationManager;
import org.github.foxnic.web.relation.modules.*;


public class PlatformRelationManager extends RelationManager {



	public PlatformRelationManager() {
		super(
				new FoxnicWebRelationManager(),
				//
				new HrmRelationManager(),
				new OaRelationManager(),
				new KnRelationManager(),
				new EamRelationManager(),
				new VehicleRelationManager(),
				new OpsRelationManager(),
				new CommonRelationManager(),
				new DatacenterRelationManager(),

				new MonitorRelationManager(),
				new MobileRelationManager(),
				new WmsRelationManager(),
				new WorkOrderRelationManager(),

				// 合同
				new ContractRelationManager()

		);
		//启动动态刷入
		startMonitor();
	}

	public void startMonitor() {
//		if(SpringUtil.isReady()) {
//			SimpleTaskManager tm=new SimpleTaskManager();
//			tm.doIntervalTask(new Runnable() {
//				@Override
//				public void run() {
//					doReConfigAndValidate();
//				}
//			}, 3000);
//		}
	}


	protected void doReConfigAndValidate() {
		PlatformRelationManager.this.reconfig();
//		FoxnicWebRelationManager.this.validate();
//		Logger.info("FoxnicWebRelationManager Reconfig");
	}


	@Override
	protected void config() {}






}
