package com.dt.platform.eam.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.github.foxnic.api.transter.Result;
import com.dt.platform.domain.eam.AssetRepair;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;

public interface IAssetReportService extends ISuperService<Asset> {



      JSONArray queryOrganizationData(Asset sample);

      JSONArray queryOwnCompanyData(Asset sample);

      JSONArray queryCategoryData(Asset sample);

      JSONArray queryCategoryStatusData(Asset sample);

      Result<JSONObject> queryAssetDataByLabel(String label);

      Result<JSONObject> dashboard();

      Result<JSONObject> dashboardMro();

      JSONArray assetOperDataReport(Asset sample);

      PagedList<Asset> assetForLeaveEmployeeReport(Asset sample,int pageSize,int pageIndex);

      JSONArray queryAuxCategoryData();

}
