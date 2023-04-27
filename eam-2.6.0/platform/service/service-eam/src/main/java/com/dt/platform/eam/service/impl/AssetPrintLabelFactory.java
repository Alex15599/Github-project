package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.eam.AsseLabelPrintCodeEnum;
import com.dt.platform.eam.service.IAssetLabelPrintService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AssetPrintLabelFactory implements ApplicationContextAware {

    private static Map<AsseLabelPrintCodeEnum, IAssetLabelPrintService> assetLabelPrintServiceMap;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,IAssetLabelPrintService> map = applicationContext.getBeansOfType(IAssetLabelPrintService.class);
        assetLabelPrintServiceMap = new HashMap<>();
        map.forEach((key,value) -> assetLabelPrintServiceMap.put(value.getCode(),value));
    }
    public IAssetLabelPrintService getService(AsseLabelPrintCodeEnum typeEnum) {
        return assetLabelPrintServiceMap.get(typeEnum);
    }
}
