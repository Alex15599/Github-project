package com.dt.platform.eam.service.bpm;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.AssetStorage;
import com.dt.platform.domain.eam.AssetTranfer;
import com.dt.platform.eam.service.IAssetStorageService;
import com.dt.platform.eam.service.IAssetTranferService;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.framework.bpm.BpmEventAdaptor;


/**
 * <p>
 * 资产报废 流程回调事件适配器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 11:07:39
*/

public class AssetTranferBpmEventAdaptor extends BpmEventAdaptor<AssetTranfer, IAssetTranferService> {

	public String BPM_TABLE="eam_asset_tranfer";

	private void updateBillStatus(String status ,String id){
		this.dao().execute("update "+BPM_TABLE+" set status=? where id=?", status, id);
	}


	public AssetTranferBpmEventAdaptor(IAssetTranferService service) {
		super(service);
	}

	/***
	 * 流程暂存开始，通过返回 BpmActionResult  的 success 或  failure 控制暂存过程是否继续进行
	 * */
	protected BpmActionResult onTemporarySaveStart(BpmEvent event) {

		Logger.info("onTemporarySaveStart nodeId:" + event.getNodeId());
		Logger.info("onTemporarySaveStart result:" + event.getActionResult().code());
		Logger.info("onTemporarySaveStart result:"+event.getActionResult().getData());
		Logger.info("onTemporarySaveStart result:"+event.getActionResult().getMessage());

		return event.getActionResult();
	}


	/***
	 * 流程提交/启动开始，通过返回 BpmActionResult  的 success 或  failure 控制流程提交/启动过程是否继续进行
	 * */
	protected BpmActionResult onProcessSubmitStart(BpmEvent event) {
		Logger.info("onProcessSubmitStart nodeId:" + event.getNodeId());
		Logger.info("onProcessSubmitStart result:"+event.getActionResult().code());
		Logger.info("onProcessSubmitStart result:"+event.getActionResult().getData());
		Logger.info("onProcessSubmitStart result:"+event.getActionResult().getMessage());
//		if(event.getActionResult().isSuccess()){
//			updateBillStatus(AssetHandleStatusEnum.APPROVAL.code(), event.getBillId());
//		}
		return event.getActionResult();
	}

	/***
	 * 流程待办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程待办处理过程是否继续进行
	 * */
	protected BpmActionResult onTaskStart(BpmEvent event) {
		Logger.info("onTaskStart nodeId:" + event.getNodeId());
		Logger.info("onTaskStart result:"+event.getActionResult().code());
		Logger.info("onTaskStart result:"+event.getActionResult().getData());
		Logger.info("onTaskStart result:"+event.getActionResult().getMessage());
		if(event.getActionResult().isSuccess()){
			updateBillStatus(AssetHandleStatusEnum.APPROVAL.code(), event.getBillId());
		}
		return event.getActionResult();
	}
	/***
	 * 流程节点执行前，此事件由 camunda 提供，返回值仅记录无意义
	 * */
	protected BpmActionResult onNodeStart(BpmEvent event) {
		Logger.info("onNodeStart nodeId:" + event.getNodeId());
		Logger.info("onNodeStart result:"+event.getActionResult().code());
		Logger.info("onNodeStart result:"+event.getActionResult().getData());
		Logger.info("onNodeStart result:"+event.getActionResult().getMessage());


		return event.getActionResult();
	}

	/***
	 * 流程节点执行后，此事件由 camunda 提供，返回值仅记录无意义
	 * */
	protected BpmActionResult onNodeEnd(BpmEvent event) {

		Logger.info("onNodeEnd nodeId:" + event.getNodeId());
		Logger.info("onNodeEnd result:"+event.getActionResult().code());
		Logger.info("onNodeEnd result:"+event.getActionResult().getData());
		Logger.info("onNodeEnd result:"+event.getActionResult().getMessage());




		if("END".equals(event.getNodeId())){
			updateBillStatus(AssetHandleStatusEnum.COMPLETE.code(), event.getBillId());
		}
		return event.getActionResult();
	}

	/***
	 * 流程撤回开始，通过返回 BpmActionResult  的 success 或  failure 控制流程撤回处理过程是否继续进行
	 * */
	protected BpmActionResult onFetchBackStart(BpmEvent event) {

		Logger.info("onFetchBackStart nodeId:" + event.getNodeId());
		Logger.info("onFetchBackStart result:"+event.getActionResult().code());
		Logger.info("onFetchBackStart result:"+event.getActionResult().getData());
		Logger.info("onFetchBackStart result:"+event.getActionResult().getMessage());



		return event.getActionResult();
	}

	/***
	 * 流程撤回结束，返回值无意义
	 * */
	protected BpmActionResult onFetchBackEnd(BpmEvent event) {
		Logger.info("onFetchBackEnd nodeId:" + event.getNodeId());
		Logger.info("onFetchBackEnd result:"+event.getActionResult().code());
		Logger.info("onFetchBackEnd result:"+event.getActionResult().getData());
		Logger.info("onFetchBackEnd result:"+event.getActionResult().getMessage());
		updateBillStatus(AssetHandleStatusEnum.INCOMPLETE.code(), event.getBillId());
		return event.getActionResult();
	}

	/***
	 * 流程跳转开始，通过返回 BpmActionResult  的 success 或  failure 控制流程跳转处理过程是否继续进行
	 * */
	protected BpmActionResult onJumpStart(BpmEvent event) {

		Logger.info("onJumpStart nodeId:" + event.getNodeId());
		Logger.info("onJumpStart result:"+event.getActionResult().code());
		Logger.info("onJumpStart result:"+event.getActionResult().getData());
		Logger.info("onJumpStart result:"+event.getActionResult().getMessage());

		return event.getActionResult();
	}

	/***
	 * 流程跳转结束， 返回值无意义
	 * */
	protected BpmActionResult onJumpEnd(BpmEvent event) {

		Logger.info("onJumpEnd nodeId:" + event.getNodeId());
		Logger.info("onJumpEnd result:"+event.getActionResult().code());
		Logger.info("onJumpEnd result:"+event.getActionResult().getData());
		Logger.info("onJumpEnd result:"+event.getActionResult().getMessage());


		return event.getActionResult();
	}

	/***
	 * 流程转办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程转办处理过程是否继续进行
	 * */
	protected BpmActionResult onDelegateStart(BpmEvent event) {

		Logger.info("onDelegateStart nodeId:" + event.getNodeId());
		Logger.info("onDelegateStart result:"+event.getActionResult().code());
		Logger.info("onDelegateStart result:"+event.getActionResult().getData());
		Logger.info("onDelegateStart result:"+event.getActionResult().getMessage());



		return event.getActionResult();
	}

	/***
	 * 流程转办处理结束，返回值无意义
	 * */
	protected BpmActionResult onDelegateEnd(BpmEvent event) {


		Logger.info("onDelegateEnd nodeId:" + event.getNodeId());
		Logger.info("onDelegateEnd result:"+event.getActionResult().code());
		Logger.info("onDelegateEnd result:"+event.getActionResult().getData());
		Logger.info("onDelegateEnd result:"+event.getActionResult().getMessage());

		return event.getActionResult();
	}

	/***
	 * 流程废弃开始，通过返回 BpmActionResult  的 success 或  failure 控制流程废弃处理过程是否继续进行
	 * */
	protected BpmActionResult onProcessAbandonStart(BpmEvent event) {

		Logger.info("onProcessAbandonStart nodeId:" + event.getNodeId());
		Logger.info("onProcessAbandonStart result:"+event.getActionResult().code());
		Logger.info("onProcessAbandonStart result:"+event.getActionResult().getData());
		Logger.info("onProcessAbandonStart result:"+event.getActionResult().getMessage());

		updateBillStatus(AssetHandleStatusEnum.CANCEL.code(), event.getBillId());
		return event.getActionResult();
	}

	/***
	 *
	 * 流程废弃结束，返回值无意义
	 * */
	protected BpmActionResult onProcessAbandonEnd(BpmEvent event) {

		Logger.info("onProcessAbandonEnd nodeId:" + event.getNodeId());
		Logger.info("onProcessAbandonEnd result:"+event.getActionResult().code());
		Logger.info("onProcessAbandonEnd result:"+event.getActionResult().getData());
		Logger.info("onProcessAbandonEnd result:"+event.getActionResult().getMessage());

		return event.getActionResult();
	}
}