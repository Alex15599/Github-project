package com.dt.platform.eam.service;


import com.dt.platform.domain.eam.*;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.dao.entity.ISuperService;

import java.util.HashMap;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import java.io.InputStream;
import java.util.Map;

import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.data.SaveMode;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.changes.ProcessStartVO;

/**
 * <p>
 * 资产转移 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 21:13:42
*/

public interface IAssetTranferService extends ISimpleIdService<AssetTranfer,String> {

	/**
	 * 表单定义代码
	 **/
	public static final String FORM_DEFINITION_CODE="eam_asset_tranfer";

	/**
	 * 处理流程回调
	 * */
	BpmActionResult onProcessCallback(BpmEvent event);


	void joinProcess(AssetTranfer assetTranfer);

	void joinProcess(List<AssetTranfer> assetTranferList);

	void joinProcess(PagedList<AssetTranfer> assetTranferList);

	/**
	 * 获取单据数据
	 * @param id ID
	 * @return 返回结果
	 * */
	Map<String, Object> getBill(String id);


 
	/**
	 * 确认操作
	 * @param id ID
	 * @return 是否成功
	 * */
	Result confirmOperation(String id);



	/**
	 * 插入实体
	 * @param assetTranfer 实体数据
	 * @return 插入是否成功
	 * */
	Result insert(AssetTranfer assetTranfer);
 
	/**
	 * 批量插入实体，事务内
	 * @param assetTranferList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<AssetTranfer> assetTranferList);
	
	
		
	/**
	 * 按主键删除 资产转移
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除 资产转移
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdLogical(String id);
	
	/**
	 * 批量物理删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsPhysical(List<T> ids);
	
	/**
	 * 批量逻辑删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsLogical(List<T> ids);
	
		
	/**
	 * 按主键更新字段 资产转移
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);
	
	/**
	 * 更新实体
	 * @param assetTranfer 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(AssetTranfer assetTranfer , SaveMode mode);
	
	
	/**
	 * 更新实体集，事务内
	 * @param assetTranferList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<AssetTranfer> assetTranferList, SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param assetTranfer 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(AssetTranfer assetTranfer , SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param assetTranferList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<AssetTranfer> assetTranferList , SaveMode mode);
	
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param assetTranfer  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(AssetTranfer assetTranfer,DBField... field);
 
		
	/**
	 * 按主键获取 资产转移
	 *
	 * @param id 主键
	 * @return AssetTranfer 数据对象
	 */
	AssetTranfer getById(String id);
		
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param ids  主键清单
	 * @return 实体集
	 * */
	List<AssetTranfer> getByIds(List<String> ids);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetTranfer 数据对象
	 * @return 判断结果
	 */
	Result<AssetTranfer> checkExists(AssetTranfer assetTranfer);

	/**
	 * 根据实体数构建默认的条件表达式，字符串使用模糊匹配
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(AssetTranfer sample);
	
	/**
	 * 根据实体数构建默认的条件表达式, 字符串是否使用模糊匹配
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(AssetTranfer sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<AssetTranfer> queryList(AssetTranfer sample);
 
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<AssetTranfer> queryList(AssetTranfer sample,ConditionExpr condition,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<AssetTranfer> queryList(AssetTranfer sample,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<AssetTranfer> queryList(AssetTranfer sample,ConditionExpr condition);
	
	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	AssetTranfer queryEntity(AssetTranfer sample);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<AssetTranfer> queryPagedList(AssetTranfer sample,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<AssetTranfer> queryPagedList(AssetTranfer sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<AssetTranfer> queryPagedList(AssetTranfer sample,ConditionExpr condition,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<AssetTranfer> queryPagedList(AssetTranfer sample,OrderBy orderBy,int pageSize,int pageIndex);
 
 	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field,Class<T> type, ConditionExpr condition);
 
	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @param ps 参数清单
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field, Class<T> type, String condition,Object... ps);

	/**
	 * 导出 Excel
	 * */
	ExcelWriter exportExcel(AssetTranfer sample);

	/**
	 * 导出用于数据导入的 Excel 模版
	 * */
	ExcelWriter  exportExcelTemplate();

	/**
	 * 构建 Excel 结构
	 * @param  isForExport 是否用于数据导出
	 * @return   ExcelStructure
	 * */
	ExcelStructure buildExcelStructure(boolean isForExport);

	/**
	 * 导入 Excel 数据
	 * @return  错误信息，成功时返回 null
	 * */
	List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch);

 
}