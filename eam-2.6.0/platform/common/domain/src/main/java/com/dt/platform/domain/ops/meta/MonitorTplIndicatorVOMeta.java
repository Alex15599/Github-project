package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorTplIndicatorVO;
import java.util.List;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicatorType;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 16:33:31
 * @sign C0886492D704913F5D2D80E8CED30CF8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorTplIndicatorVOMeta extends MonitorTplIndicatorMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 监控方式 , 类型: java.lang.String
	*/
	public static final String MONITOR_METHOD="monitorMethod";
	
	/**
	 * 监控方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> MONITOR_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,MONITOR_METHOD, java.lang.String.class, "监控方式", "监控方式", java.lang.String.class, null);
	
	/**
	 * 指标类型 , 类型: java.lang.String
	*/
	public static final String INDICATOR_TYPE="indicatorType";
	
	/**
	 * 指标类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> INDICATOR_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,INDICATOR_TYPE, java.lang.String.class, "指标类型", "指标类型", java.lang.String.class, null);
	
	/**
	 * 值行数 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN_ROWS="valueColumnRows";
	
	/**
	 * 值行数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> VALUE_COLUMN_ROWS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,VALUE_COLUMN_ROWS, java.lang.String.class, "值行数", "值行数", java.lang.String.class, null);
	
	/**
	 * 值列数 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN_COLS="valueColumnCols";
	
	/**
	 * 值列数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> VALUE_COLUMN_COLS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,VALUE_COLUMN_COLS, java.lang.String.class, "值列数", "值列数", java.lang.String.class, null);
	
	/**
	 * 数值类型 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN_TYPE="valueColumnType";
	
	/**
	 * 数值类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> VALUE_COLUMN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,VALUE_COLUMN_TYPE, java.lang.String.class, "数值类型", "数值类型", java.lang.String.class, null);
	
	/**
	 * 数值字段 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN="valueColumn";
	
	/**
	 * 数值字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> VALUE_COLUMN_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,VALUE_COLUMN, java.lang.String.class, "数值字段", "数值字段", java.lang.String.class, null);
	
	/**
	 * 数值字段映射 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN_MAP="valueColumnMap";
	
	/**
	 * 数值字段映射 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> VALUE_COLUMN_MAP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,VALUE_COLUMN_MAP, java.lang.String.class, "数值字段映射", "数值字段映射", java.lang.String.class, null);
	
	/**
	 * 字段名称 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN_NAME="valueColumnName";
	
	/**
	 * 字段名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> VALUE_COLUMN_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,VALUE_COLUMN_NAME, java.lang.String.class, "字段名称", "字段名称", java.lang.String.class, null);
	
	/**
	 * 超时(秒) , 类型: java.lang.Integer
	*/
	public static final String TIME_OUT="timeOut";
	
	/**
	 * 超时(秒) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> TIME_OUT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,TIME_OUT, java.lang.Integer.class, "超时(秒)", "超时(秒)", java.lang.Integer.class, null);
	
	/**
	 * 间隔时间(秒） , 类型: java.lang.Integer
	*/
	public static final String INTERVAL_TIME="intervalTime";
	
	/**
	 * 间隔时间(秒） , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> INTERVAL_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,INTERVAL_TIME, java.lang.Integer.class, "间隔时间(秒）", "间隔时间(秒）", java.lang.Integer.class, null);
	
	/**
	 * 数据保留天数 , 类型: java.lang.Integer
	*/
	public static final String DATA_KEEP_DAY="dataKeepDay";
	
	/**
	 * 数据保留天数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> DATA_KEEP_DAY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,DATA_KEEP_DAY, java.lang.Integer.class, "数据保留天数", "数据保留天数", java.lang.Integer.class, null);
	
	/**
	 * 命令 , 类型: java.lang.String
	*/
	public static final String COMMAND="command";
	
	/**
	 * 命令 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> COMMAND_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,COMMAND, java.lang.String.class, "命令", "命令", java.lang.String.class, null);
	
	/**
	 * 命令值 , 类型: java.lang.String
	*/
	public static final String COMMAND_VALUE="commandValue";
	
	/**
	 * 命令值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> COMMAND_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,COMMAND_VALUE, java.lang.String.class, "命令值", "命令值", java.lang.String.class, null);
	
	/**
	 * 变量 , 类型: java.lang.String
	*/
	public static final String INDICATOR_VARIABLE="indicatorVariable";
	
	/**
	 * 变量 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> INDICATOR_VARIABLE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,INDICATOR_VARIABLE, java.lang.String.class, "变量", "变量", java.lang.String.class, null);
	
	/**
	 * snmp元数据 , 类型: java.lang.String
	*/
	public static final String SNMP_OID="snmpOid";
	
	/**
	 * snmp元数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> SNMP_OID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,SNMP_OID, java.lang.String.class, "snmp元数据", "snmp元数据", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String ITEM_SORT="itemSort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> ITEM_SORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,ITEM_SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String TPL="tpl";
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,com.dt.platform.domain.ops.MonitorTpl> TPL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,TPL, com.dt.platform.domain.ops.MonitorTpl.class, "节点模版", "节点模版", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * 指标类型 , 类型: com.dt.platform.domain.ops.MonitorTplIndicatorType
	*/
	public static final String MONITOR_INDICATOR_TYPE="monitorIndicatorType";
	
	/**
	 * 指标类型 , 类型: com.dt.platform.domain.ops.MonitorTplIndicatorType
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicatorVO,com.dt.platform.domain.ops.MonitorTplIndicatorType> MONITOR_INDICATOR_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicatorVO.class ,MONITOR_INDICATOR_TYPE, com.dt.platform.domain.ops.MonitorTplIndicatorType.class, "指标类型", "指标类型", com.dt.platform.domain.ops.MonitorTplIndicatorType.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , STATUS , NAME , CODE , MONITOR_TPL_CODE , MONITOR_METHOD , INDICATOR_TYPE , VALUE_COLUMN_ROWS , VALUE_COLUMN_COLS , VALUE_COLUMN_TYPE , VALUE_COLUMN , VALUE_COLUMN_MAP , VALUE_COLUMN_NAME , TIME_OUT , INTERVAL_TIME , DATA_KEEP_DAY , COMMAND , COMMAND_VALUE , INDICATOR_VARIABLE , SNMP_OID , LABEL , ITEM_SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL , MONITOR_INDICATOR_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorTplIndicatorVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MonitorTplIndicatorVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorTplIndicator setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MonitorTplIndicator setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorTplIndicator setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorTplIndicator setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 监控方式
		 * @param monitorMethod 监控方式
		 * @return 当前对象
		*/
		public MonitorTplIndicator setMonitorMethod(String monitorMethod) {
			super.change(MONITOR_METHOD,super.getMonitorMethod(),monitorMethod);
			super.setMonitorMethod(monitorMethod);
			return this;
		}
		
		/**
		 * 设置 指标类型
		 * @param indicatorType 指标类型
		 * @return 当前对象
		*/
		public MonitorTplIndicator setIndicatorType(String indicatorType) {
			super.change(INDICATOR_TYPE,super.getIndicatorType(),indicatorType);
			super.setIndicatorType(indicatorType);
			return this;
		}
		
		/**
		 * 设置 值行数
		 * @param valueColumnRows 值行数
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumnRows(String valueColumnRows) {
			super.change(VALUE_COLUMN_ROWS,super.getValueColumnRows(),valueColumnRows);
			super.setValueColumnRows(valueColumnRows);
			return this;
		}
		
		/**
		 * 设置 值列数
		 * @param valueColumnCols 值列数
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumnCols(String valueColumnCols) {
			super.change(VALUE_COLUMN_COLS,super.getValueColumnCols(),valueColumnCols);
			super.setValueColumnCols(valueColumnCols);
			return this;
		}
		
		/**
		 * 设置 数值类型
		 * @param valueColumnType 数值类型
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumnType(String valueColumnType) {
			super.change(VALUE_COLUMN_TYPE,super.getValueColumnType(),valueColumnType);
			super.setValueColumnType(valueColumnType);
			return this;
		}
		
		/**
		 * 设置 数值字段
		 * @param valueColumn 数值字段
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumn(String valueColumn) {
			super.change(VALUE_COLUMN,super.getValueColumn(),valueColumn);
			super.setValueColumn(valueColumn);
			return this;
		}
		
		/**
		 * 设置 数值字段映射
		 * @param valueColumnMap 数值字段映射
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumnMap(String valueColumnMap) {
			super.change(VALUE_COLUMN_MAP,super.getValueColumnMap(),valueColumnMap);
			super.setValueColumnMap(valueColumnMap);
			return this;
		}
		
		/**
		 * 设置 字段名称
		 * @param valueColumnName 字段名称
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumnName(String valueColumnName) {
			super.change(VALUE_COLUMN_NAME,super.getValueColumnName(),valueColumnName);
			super.setValueColumnName(valueColumnName);
			return this;
		}
		
		/**
		 * 设置 超时(秒)
		 * @param timeOut 超时(秒)
		 * @return 当前对象
		*/
		public MonitorTplIndicator setTimeOut(Integer timeOut) {
			super.change(TIME_OUT,super.getTimeOut(),timeOut);
			super.setTimeOut(timeOut);
			return this;
		}
		
		/**
		 * 设置 间隔时间(秒）
		 * @param intervalTime 间隔时间(秒）
		 * @return 当前对象
		*/
		public MonitorTplIndicator setIntervalTime(Integer intervalTime) {
			super.change(INTERVAL_TIME,super.getIntervalTime(),intervalTime);
			super.setIntervalTime(intervalTime);
			return this;
		}
		
		/**
		 * 设置 数据保留天数
		 * @param dataKeepDay 数据保留天数
		 * @return 当前对象
		*/
		public MonitorTplIndicator setDataKeepDay(Integer dataKeepDay) {
			super.change(DATA_KEEP_DAY,super.getDataKeepDay(),dataKeepDay);
			super.setDataKeepDay(dataKeepDay);
			return this;
		}
		
		/**
		 * 设置 命令
		 * @param command 命令
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCommand(String command) {
			super.change(COMMAND,super.getCommand(),command);
			super.setCommand(command);
			return this;
		}
		
		/**
		 * 设置 命令值
		 * @param commandValue 命令值
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCommandValue(String commandValue) {
			super.change(COMMAND_VALUE,super.getCommandValue(),commandValue);
			super.setCommandValue(commandValue);
			return this;
		}
		
		/**
		 * 设置 变量
		 * @param indicatorVariable 变量
		 * @return 当前对象
		*/
		public MonitorTplIndicator setIndicatorVariable(String indicatorVariable) {
			super.change(INDICATOR_VARIABLE,super.getIndicatorVariable(),indicatorVariable);
			super.setIndicatorVariable(indicatorVariable);
			return this;
		}
		
		/**
		 * 设置 snmp元数据
		 * @param snmpOid snmp元数据
		 * @return 当前对象
		*/
		public MonitorTplIndicator setSnmpOid(String snmpOid) {
			super.change(SNMP_OID,super.getSnmpOid(),snmpOid);
			super.setSnmpOid(snmpOid);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public MonitorTplIndicator setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param itemSort 排序
		 * @return 当前对象
		*/
		public MonitorTplIndicator setItemSort(Integer itemSort) {
			super.change(ITEM_SORT,super.getItemSort(),itemSort);
			super.setItemSort(itemSort);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorTplIndicator setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorTplIndicator setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorTplIndicator setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorTplIndicator setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorTplIndicator setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorTplIndicator setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorTplIndicator setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版
		 * @param tpl 节点模版
		 * @return 当前对象
		*/
		public MonitorTplIndicator setTpl(MonitorTpl tpl) {
			super.change(TPL,super.getTpl(),tpl);
			super.setTpl(tpl);
			return this;
		}
		
		/**
		 * 设置 指标类型
		 * @param monitorIndicatorType 指标类型
		 * @return 当前对象
		*/
		public MonitorTplIndicator setMonitorIndicatorType(MonitorTplIndicatorType monitorIndicatorType) {
			super.change(MONITOR_INDICATOR_TYPE,super.getMonitorIndicatorType(),monitorIndicatorType);
			super.setMonitorIndicatorType(monitorIndicatorType);
			return this;
		}
	}
}