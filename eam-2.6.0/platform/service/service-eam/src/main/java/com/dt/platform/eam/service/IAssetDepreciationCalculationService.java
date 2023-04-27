package com.dt.platform.eam.service;

import com.dt.platform.constants.enums.eam.AssetDepreciationCodeEnum;
import com.github.foxnic.api.transter.Result;

public interface IAssetDepreciationCalculationService {

    public Result depreciationCalculation(String billId);

    public AssetDepreciationCodeEnum getCode();

    public Result fillAssetData(String billId);
}
