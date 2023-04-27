package com.dt.platform.ops.service;



import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.*;
import com.github.foxnic.api.transter.Result;

import com.github.foxnic.dao.entity.ISuperService;



/**
 * <p>
 * 主机 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:42
*/

public interface IOpsDatabaseService extends ISuperService<DbInfo> {

	Result recordDatabaseBackup(DbBackupRecord dbBackupRecord);

	Result<JSONObject> queryDatabaseData(String codes);



}