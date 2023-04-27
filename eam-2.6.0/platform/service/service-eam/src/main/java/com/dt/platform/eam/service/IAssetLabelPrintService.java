package com.dt.platform.eam.service;


import com.dt.platform.constants.enums.eam.AsseLabelPrintCodeEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationCodeEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.meta.AssetLabelPrint;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.ISuperService;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * <p>
 * 变更明细 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:14
*/

public interface IAssetLabelPrintService  {


	public AsseLabelPrintCodeEnum getCode();

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param  printData 数据对象
	 * @param  code 数据对象
	 * @return 插入是否成功
	 * */
	Result print(AssetLabelPrint printData);

}