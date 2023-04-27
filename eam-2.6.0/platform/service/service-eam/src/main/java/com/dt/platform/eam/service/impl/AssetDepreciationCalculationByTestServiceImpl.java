package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.eam.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import org.springframework.stereotype.Service;



@Service("AssetDepreciationCalculationByTestService")
public class AssetDepreciationCalculationByTestServiceImpl implements IAssetDepreciationCalculationService {


    @Override
    public AssetDepreciationCodeEnum getCode() {
        return AssetDepreciationCodeEnum.TEST;
    }

    @Override
    public Result depreciationCalculation(String billId) {
        return ErrorDesc.success();
    }

    @Override
    public Result fillAssetData(String billId) {
        return ErrorDesc.success();

    }
}
