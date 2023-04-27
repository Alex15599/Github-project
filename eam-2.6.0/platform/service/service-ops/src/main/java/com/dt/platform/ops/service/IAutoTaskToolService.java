package com.dt.platform.ops.service;

import com.dt.platform.domain.ops.*;
import com.github.foxnic.api.transter.Result;
import java.util.List;


/**
 * <p>
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 16:09:08
*/

public interface IAutoTaskToolService  {


	Result executeNode(AutoNode node, AutoAction action,String taskId,String mLogId,String method);

	Result executeByTaskId(String taskId,String method);



}