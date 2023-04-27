/**
 * 资产数据权限 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-17 08:50:09
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;
	const moduleURL="/service-eam/eam-asset-data-permissions";
	// 表单执行操作类型：view，create，edit
	var action=null;
	var disableCreateNew=false;
	var disableModify=false;
	var dataBeforeEdit=null;
	const bpmIntegrateMode="none";
	var categorySelect;
	var isInProcess=QueryString.get("isInProcess");

	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		action=admin.getTempData('eam-asset-data-permissions-form-data-form-action');
		//如果没有修改和保存权限
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(action=="view") {
			disableModify=true;
		}

		if(bpmIntegrateMode=="front" && isInProcess==1) {
			$(".model-form-footer").hide();
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit(action,admin.getTempData('eam-asset-data-permissions-form-data'));
		}

		//渲染表单组件
		renderFormFields();

		//填充表单数据
		fillFormData();

		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();


	}





	/**
	 * 自动调节窗口高度
	 * */
	var adjustPopupTask=-1;
	function adjustPopup() {
		if(window.pageExt.form.beforeAdjustPopup) {
			var doNext=window.pageExt.form.beforeAdjustPopup();
			if(!doNext) return;
		}



		clearTimeout(adjustPopupTask);
		var scroll=$(".form-container").attr("scroll");
		if(scroll=='yes') return;
		var prevBodyHeight=-1;
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			if(bpmIntegrateMode=="front" && isInProcess==1) {
				var updateFormIframeHeight=admin.getVar("updateFormIframeHeight");
				if(bodyHeight>0 && bodyHeight!=prevBodyHeight) {
					updateFormIframeHeight && updateFormIframeHeight(bodyHeight);
				} else {
					setTimeout(adjustPopup,1000);
				}
				prevBodyHeight = bodyHeight;
				return;
			}
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-asset-data-permissions-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-asset-data-permissions-form-area', area);
			window.adjustPopup=adjustPopup;
			if(area.tooHeigh) {
				var windowHeight=area.iframeHeight;
				var finalHeight=windowHeight-footerHeight-16;
				//console.log("windowHeight="+windowHeight+',bodyHeight='+bodyHeight+",footerHeight="+footerHeight+",finalHeight="+finalHeight);
				$(".form-container").css("display","");
				$(".form-container").css("overflow-y","scroll");
				$(".form-container").css("height",finalHeight+"px");
				$(".form-container").attr("scroll","yes");
			}
		},250);
	}

	/**
	 * 渲染表单组件
	 */
	function renderFormFields() {
		fox.renderFormInputs(form);

		form.on('radio(status)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=status]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("status",data,checked);
		});
		//渲染 ownerCode 下拉字段
		fox.renderSelectBox({
			el: "ownerCode",
			radio: true,
			filterable: false,
			layVerify: 'required',
			layVerType: 'msg',
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("ownerCode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues = "".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({data:data[i],name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		//渲染 roleCode 下拉字段
		fox.renderSelectBox({
			el: "roleCode",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			layVerify: 'required',
			layVerType: 'msg',
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("roleCode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues = "".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].name,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		form.on('radio(ownOrgAuthorityEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=ownOrgAuthorityEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("ownOrgAuthorityEnable",data,checked);
		});
		form.on('radio(ownOrgLocalEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=ownOrgLocalEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("ownOrgLocalEnable",data,checked);
		});
		form.on('radio(ownOrgCascadeEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=ownOrgCascadeEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("ownOrgCascadeEnable",data,checked);
		});
		form.on('radio(orgAuthorityEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=orgAuthorityEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("orgAuthorityEnable",data,checked);
		});
		form.on('radio(orgLocalEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=orgLocalEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("orgLocalEnable",data,checked);
		});
		form.on('radio(orgCascadeEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=orgCascadeEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("orgCascadeEnable",data,checked);
		});
		form.on('radio(catalogAuthorityEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=catalogAuthorityEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("catalogAuthorityEnable",data,checked);
		});
		form.on('radio(catalogCascadeEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=catalogCascadeEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("catalogCascadeEnable",data,checked);
		});
		form.on('radio(positionAuthorityEnable)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=positionAuthorityEnable]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("positionAuthorityEnable",data,checked);
		});
		//渲染 positionIds 下拉字段
		fox.renderSelectBox({
			el: "positionIds",
			radio: false,
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("positionIds",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "hierarchyName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues = "".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		categorySelect = xmSelect.render({
			el: '#categoryIds',
			prop: {
				name: 'name',
				value: 'id',
			},
			filterable: true,
			tree: {
				showFolderIcon: true,
				show: true,
				strict: false,
				expandedKeys: [],
			},
			//处理方式
			on: function(data){
			},
			//显示为text模式
			model: { label: { type: 'text' } },
			//单选模式
			//radio: true,
			//选中关闭
			//clickClose: true,
			height: '200px',
			data:ASSET_CATEGORY_DATA
		})

		//渲染 categoryIds 下拉字段
		// fox.renderSelectBox({
		// 	el: "categoryIds",
		// 	radio: false,
		// 	filterable: false,
		// 	on: function(data){
		// 		setTimeout(function () {
		// 			window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("categoryIds",data.arr,data.change,data.isAdd);
		// 		},1);
		// 	},
		// 	//转换数据
		// 	transform: function(data) {
		// 		//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
		// 		var defaultValues=[],defaultIndexs=[];
		// 		if(action=="create") {
		// 			defaultValues = "".split(",");
		// 			defaultIndexs = "".split(",");
		// 		}
		// 		var opts=[];
		// 		if(!data) return opts;
		// 		for (var i = 0; i < data.length; i++) {
		// 			if(!data[i]) continue;
		// 			opts.push({data:data[i],name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
		// 		}
		// 		return opts;
		// 	}
		// });
	}

	/**
	 * 根据id填充表单
	 * */
	function fillFormDataByIds(ids) {
		if(!ids) return;
		if(ids.length==0) return;
		var id=ids[0];
		if(!id) return;
		admin.post(moduleURL+"/get-by-id", { id : id }, function (r) {
			if (r.success) {
				fillFormData(r.data)
			} else {
				fox.showMessage(r);
			}
		});
	}

	/**
	 * 在流程提交前处理表单数据
	 * */
	function processFormData4Bpm (processInstanceId,param,cb) {
		window.pageExt.form.processFormData4Bpm && window.pageExt.form.processFormData4Bpm(processInstanceId,param,cb);
	}

	/**
	 * 填充表单数据
	 */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('eam-asset-data-permissions-form-data');
		}

		window.pageExt.form.beforeDataFill && window.pageExt.form.beforeDataFill(formData);

		var hasData=true;
		//如果是新建
		if(!formData || !formData.id) {
			adjustPopup();
			hasData=false;
		}
		var fm=$('#data-form');
		if (hasData) {
			fm[0].reset();
			form.val('data-form', formData);






			//设置  归属 设置下拉框勾选
			fox.setSelectValue4Enum("#ownerCode",formData.ownerCode,SELECT_OWNERCODE_DATA);
			//设置  业务角色 设置下拉框勾选
			fox.setSelectValue4QueryApi("#roleCode",formData.busiRole);
			//设置  存放位置 设置下拉框勾选
			fox.setSelectValue4QueryApi("#positionIds",formData.position);
			//设置  资产分类 设置下拉框勾选
			// fox.setSelectValue4QueryApi("#categoryIds",formData.category);

			//处理fillBy
			setTimeout(function(){
				if(categorySelect){
					if(formData.category&&formData.category.length>0){
						categorySelect.setValue(formData.categoryIds.split(","));
					}
				}
			},150)
			//
			fm.attr('method', 'POST');
			fox.fillDialogButtons();
			renderFormFields();

			window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);

		}

		if(action=="view") {
			//处理fillBy
			setTimeout(function(){
				if(categorySelect){
					categorySelect.update({disabled:true})
				}
			},150)
		}
		//渐显效果
		fm.css("opacity","0.0");
		fm.css("display","");
		setTimeout(function (){
			fm.animate({
				opacity:'1.0'
			},100,null,function (){
				fm.css("opacity","1.0");});
		},1);

		//禁用编辑
		if((hasData && disableModify) || (!hasData &&disableCreateNew)) {
			fox.lockForm($("#data-form"),true);
			$("#submit-button").hide();
			$("#cancel-button").css("margin-right","15px")
		} else {
			$("#submit-button").show();
			$("#cancel-button").css("margin-right","0px")
		}

		//调用 iframe 加载过程
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(window.pageExt.form){
				jsFn=window.pageExt.form[jsFn];
				jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,formData);
			}
		}

		dataBeforeEdit=getFormData();

	}

	function getFormData() {
		var data=form.val("data-form");



		//获取 归属 下拉框的值
		data["ownerCode"]=fox.getSelectedValue("ownerCode",false);
		//获取 业务角色 下拉框的值
		data["roleCode"]=fox.getSelectedValue("roleCode",false);
		//获取 存放位置 下拉框的值
		data["positionIds"]=fox.getSelectedValue("positionIds",true);
		//获取 资产分类 下拉框的值
		data["categoryIds"]=fox.getSelectedValue("categoryIds",true);

		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param,callback) {

		if(window.pageExt.form.beforeSubmit) {
			var doNext=window.pageExt.form.beforeSubmit(param);
			if(!doNext) return ;
		}

		param.dirtyFields=fox.compareDirtyFields(dataBeforeEdit,param);
		var action=param.id?"edit":"create";
		var api=moduleURL+"/"+(param.id?"update":"insert");
		admin.post(api, param, function (data) {
			if (data.success) {
				var doNext=true;
				var pkValues=data.data;
				if(pkValues) {
					for (var key in pkValues) {
						$("#"+key).val(pkValues[key]);
					}
				}
				if(window.pageExt.form.betweenFormSubmitAndClose) {
					doNext=window.pageExt.form.betweenFormSubmitAndClose(param,data);
				}

				if(callback) {
					doNext = callback(data,action);
				}

				if(doNext) {
					admin.finishPopupCenterById('eam-asset-data-permissions-form-data-win');
				}

				// 调整状态为编辑
				action="edit";

			} else {
				fox.showMessage(data);
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
		}, {delayLoading:1000,elms:[$("#submit-button")]});
	}

	function verifyAndSaveForm(data) {
		if(!data) data={};
		//debugger;
		data.field = getFormData();
		//校验表单
		if(!verifyForm(data.field)) return;
		saveForm(data.field);
		return false;
	}

	/**
	 * 保存数据，表单提交事件
	 */
	function bindButtonEvent() {

		form.on('submit(submit-button)', verifyAndSaveForm);

		// 请选择组织节点对话框
		$("#organizationIds-button").click(function(){
			var organizationIdsDialogOptions={
				field:"organizationIds",
				formData:getFormData(),
				inputEl:$("#organizationIds"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseOrgNode(organizationIdsDialogOptions);
		});
		// 请选择公司对话框
		$("#ownOrganizationIds-button").click(function(){
			var ownOrganizationIdsDialogOptions={
				field:"ownOrganizationIds",
				formData:getFormData(),
				inputEl:$("#ownOrganizationIds"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"com",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseOrgNode(ownOrganizationIdsDialogOptions);
		});

		//关闭窗口
		$("#cancel-button").click(function(){ admin.finishPopupCenterById('eam-asset-data-permissions-form-data-win',this); });

	}

	window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		verifyAndSaveForm:verifyAndSaveForm,
		fillFormData: fillFormData,
		fillFormDataByIds:fillFormDataByIds,
		processFormData4Bpm:processFormData4Bpm,
		adjustPopup: adjustPopup,
		action: action,
		setAction: function (act) {
			action = act;
		}
	};

	window.pageExt.form.ending && window.pageExt.form.ending();

}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});