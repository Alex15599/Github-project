package com.dt.platform.common.service;

import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.ISimpleIdService;

import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.dao.entity.ISuperService;
import com.dt.platform.domain.common.BackupDbStrategy;
import com.dt.platform.domain.common.BackupDbStrategyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import java.io.InputStream;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.data.SaveMode;
import java.util.Map;

/**
 * <p>
 * 备份策略服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-24 15:48:34
*/

public interface IBackupDbStrategyService extends  ISimpleIdService<BackupDbStrategy,String> {


	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param backupDbStrategy 数据对象
	 * @return 插入是否成功
	 * */
	Result insert(BackupDbStrategy backupDbStrategy);

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param backupDbStrategy  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	Result insert(BackupDbStrategy backupDbStrategy,boolean throwsException);

	/**
	 * 批量插入实体，事务内
	 * @param backupDbStrategyList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<BackupDbStrategy> backupDbStrategyList);


		
	/**
	 * 按主键删除备份策略
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除备份策略
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
	 * 按主键更新备份策略
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param backupDbStrategy 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(BackupDbStrategy backupDbStrategy , SaveMode mode);


	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param backupDbStrategy 数据对象
	 * @param mode SaveMode,数据更新的模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果
	 */
	Result update(BackupDbStrategy backupDbStrategy , SaveMode mode,boolean throwsException);


	/**
	 * 更新实体集，事务内
	 * @param backupDbStrategyList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<BackupDbStrategy> backupDbStrategyList, SaveMode mode);

	/**
	 * 保存实体，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param backupDbStrategy 实体数据
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	Result save(BackupDbStrategy backupDbStrategy , SaveMode mode,boolean throwsException);

	/**
	 * 保存实体，如果语句错误，则抛出异常
	 * @param backupDbStrategy 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(BackupDbStrategy backupDbStrategy , SaveMode mode);

	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param backupDbStrategyList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<BackupDbStrategy> backupDbStrategyList , SaveMode mode);

	/**
	 * 检查实体中的数据字段是否已经存在 . 判断 主键值不同，但指定字段的值相同的记录是否存在
	 * @param backupDbStrategy  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(BackupDbStrategy backupDbStrategy,DBField... field);

		
	/**
	 * 按主键获取备份策略
	 *
	 * @param id 主键
	 * @return BackupDbStrategy 数据对象
	 */
	BackupDbStrategy getById(String id);

	/**
	 * 按 id 获取多个对象
	 * @param ids  主键清单
	 * @return 实体集
	 * */
	List<BackupDbStrategy> queryListByIds(List<String> ids);

	/**
	 * 按 id 列表查询 Map
	 * @param ids  主键清单
	 * */
	Map<String, BackupDbStrategy> queryMapByIds(List<String> ids);



	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param backupDbStrategy 数据对象
	 * @return 判断结果
	 */
	Boolean checkExists(BackupDbStrategy backupDbStrategy);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(BackupDbStrategy sample);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(BackupDbStrategy sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<BackupDbStrategy> queryList(BackupDbStrategyVO sample);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<BackupDbStrategy> queryList(BackupDbStrategy sample,ConditionExpr condition,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<BackupDbStrategy> queryList(BackupDbStrategy sample,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<BackupDbStrategy> queryList(BackupDbStrategy sample,ConditionExpr condition);

	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	BackupDbStrategy queryEntity(BackupDbStrategy sample);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<BackupDbStrategy> queryPagedList(BackupDbStrategyVO sample,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<BackupDbStrategy> queryPagedList(BackupDbStrategy sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<BackupDbStrategy> queryPagedList(BackupDbStrategy sample,ConditionExpr condition,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<BackupDbStrategy> queryPagedList(BackupDbStrategy sample,OrderBy orderBy,int pageSize,int pageIndex);

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





}