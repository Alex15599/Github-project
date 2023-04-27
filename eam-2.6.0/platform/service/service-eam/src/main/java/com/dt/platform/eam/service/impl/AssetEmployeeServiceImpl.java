package com.dt.platform.eam.service.impl;


import com.dt.platform.eam.service.IAssetEmployeeService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 领用申请 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-23 10:10:27
*/


@Service("EamAssetEmployeeService")
public class AssetEmployeeServiceImpl implements IAssetEmployeeService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Override
	public void queryMyAsset() {
	}
}