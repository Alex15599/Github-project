package com.dt.platform.eam.service.impl;
import com.dt.platform.constants.enums.eam.AssetDepreciationCalculationMethodTypeEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationCodeEnum;
import com.dt.platform.eam.service.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AssetDepreciationCalculationFactory implements ApplicationContextAware {


    private static Map<AssetDepreciationCodeEnum, IAssetDepreciationCalculationService> assetDepreciationCalculationServiceMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,IAssetDepreciationCalculationService> map = applicationContext.getBeansOfType(IAssetDepreciationCalculationService.class);
        assetDepreciationCalculationServiceMap = new HashMap<>();
        map.forEach((key,value) -> assetDepreciationCalculationServiceMap.put(value.getCode(),value));
    }

    public IAssetDepreciationCalculationService getService(AssetDepreciationCodeEnum typeEnum) {
        return assetDepreciationCalculationServiceMap.get(typeEnum);

    }

}
