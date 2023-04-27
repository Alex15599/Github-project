/**
 * 维保更新记录 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 15:12:34
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;
	const moduleURL="/service-eam/eam-asset-maintenance-record-u";
	// 表单执行操作类型：view，create，edit
	var action=null;
	var disableCreateNew=false;
	var disableModify=false;
	var dataBeforeEdit=null;
	const bpmIntegrateMode="none";
	var isInProcess=QueryString.get("isInProcess");

	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		action=admin.getTempData('eam-asset-maintenance-record-u-form-data-form-action');
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
			window.pageExt.form.beforeInit(action,admin.getTempData('eam-asset-maintenance-record-u-form-data'));
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
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-asset-maintenance-record-u-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-asset-maintenance-record-u-form-area', area);
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

		//渲染 maintainerId 下拉字段
		fox.renderSelectBox({
			el: "maintainerId",
			radio: true,
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("maintainerId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "maintainerName", //请自行调整用于搜索的字段名称
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
					opts.push({data:data[i],name:data[i].maintainerName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		form.on('radio(sMaintainerId)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sMaintainerId]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sMaintainerId",data,checked);
		});
		form.on('radio(uMaintainerId)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uMaintainerId]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uMaintainerId",data,checked);
		});
		form.on('radio(uSMaintainerId)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSMaintainerId]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSMaintainerId",data,checked);
		});
		form.on('radio(sMaintainerName)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sMaintainerName]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sMaintainerName",data,checked);
		});
		form.on('radio(uMaintainerName)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uMaintainerName]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uMaintainerName",data,checked);
		});
		form.on('radio(uSMaintainerName)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSMaintainerName]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSMaintainerName",data,checked);
		});
		//渲染 maintenanceStatus 下拉字段
		fox.renderSelectBox({
			el: "maintenanceStatus",
			radio: true,
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("maintenanceStatus",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
					opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		form.on('radio(sMaintenanceStatus)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sMaintenanceStatus]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sMaintenanceStatus",data,checked);
		});
		form.on('radio(uMaintenanceStatus)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uMaintenanceStatus]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uMaintenanceStatus",data,checked);
		});
		form.on('radio(uSMaintenanceStatus)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSMaintenanceStatus]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSMaintenanceStatus",data,checked);
		});
		//渲染 maintenanceMethod 下拉字段
		fox.renderSelectBox({
			el: "maintenanceMethod",
			radio: true,
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("maintenanceMethod",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
					opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		form.on('radio(sMaintenanceMethod)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sMaintenanceMethod]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sMaintenanceMethod",data,checked);
		});
		form.on('radio(uMaintenanceMethod)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uMaintenanceMethod]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uMaintenanceMethod",data,checked);
		});
		form.on('radio(uSMaintenanceMethod)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSMaintenanceMethod]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSMaintenanceMethod",data,checked);
		});
		form.on('radio(sContactInformation)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sContactInformation]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sContactInformation",data,checked);
		});
		form.on('radio(uContactInformation)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uContactInformation]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uContactInformation",data,checked);
		});
		form.on('radio(uSContactInformation)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSContactInformation]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSContactInformation",data,checked);
		});
		//渲染 suggestMaintenanceMethod 下拉字段
		fox.renderSelectBox({
			el: "suggestMaintenanceMethod",
			radio: true,
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("suggestMaintenanceMethod",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
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
					opts.push({data:data[i],name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		form.on('radio(sSuggestMaintenanceMethod)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sSuggestMaintenanceMethod]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sSuggestMaintenanceMethod",data,checked);
		});
		form.on('radio(uSuggestMaintenanceMethod)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSuggestMaintenanceMethod]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSuggestMaintenanceMethod",data,checked);
		});
		form.on('radio(uSSuggestMaintenanceMethod)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSSuggestMaintenanceMethod]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSSuggestMaintenanceMethod",data,checked);
		});
		form.on('radio(sContacts)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sContacts]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sContacts",data,checked);
		});
		form.on('radio(uContacts)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uContacts]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uContacts",data,checked);
		});
		form.on('radio(uSContacts)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSContacts]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSContacts",data,checked);
		});
		form.on('radio(sDirector)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sDirector]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sDirector",data,checked);
		});
		form.on('radio(uDirector)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uDirector]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uDirector",data,checked);
		});
		form.on('radio(uSDirector)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSDirector]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSDirector",data,checked);
		});
		laydate.render({
			elem: '#maintenanceStartDate',
			format:"yyyy-MM-dd",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("maintenanceStartDate",value, date, endDate);
			}
		});
		form.on('radio(sMaintenanceStartDate)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sMaintenanceStartDate]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sMaintenanceStartDate",data,checked);
		});
		form.on('radio(uMaintenanceStartDate)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uMaintenanceStartDate]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uMaintenanceStartDate",data,checked);
		});
		form.on('radio(uSMaintenanceStartDate)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSMaintenanceStartDate]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSMaintenanceStartDate",data,checked);
		});
		laydate.render({
			elem: '#maintenanceEndDate',
			format:"yyyy-MM-dd",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("maintenanceEndDate",value, date, endDate);
			}
		});
		form.on('radio(sMaintenanceEndDate)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sMaintenanceEndDate]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sMaintenanceEndDate",data,checked);
		});
		form.on('radio(uMaintenanceEndDate)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uMaintenanceEndDate]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uMaintenanceEndDate",data,checked);
		});
		form.on('radio(uSMaintenanceEndDate)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSMaintenanceEndDate]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSMaintenanceEndDate",data,checked);
		});
		form.on('radio(sMaintenanceNotes)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=sMaintenanceNotes]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("sMaintenanceNotes",data,checked);
		});
		form.on('radio(uMaintenanceNotes)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uMaintenanceNotes]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uMaintenanceNotes",data,checked);
		});
		form.on('radio(uSMaintenanceNotes)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=uSMaintenanceNotes]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("uSMaintenanceNotes",data,checked);
		});
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
			formData = admin.getTempData('eam-asset-maintenance-record-u-form-data');
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




			//设置 维保开始时间 显示复选框勾选
			if(formData["maintenanceStartDate"]) {
				$("#maintenanceStartDate").val(fox.dateFormat(formData["maintenanceStartDate"],"yyyy-MM-dd"));
			}
			//设置 维保到期时间 显示复选框勾选
			if(formData["maintenanceEndDate"]) {
				$("#maintenanceEndDate").val(fox.dateFormat(formData["maintenanceEndDate"],"yyyy-MM-dd"));
			}


			//设置  维保商 设置下拉框勾选
			fox.setSelectValue4QueryApi("#maintainerId",formData.maintnainer);
			//设置  维保状态 设置下拉框勾选
			fox.setSelectValue4QueryApi("#maintenanceStatus",formData.assetMaintenanceStatus);
			//设置  维保方式 设置下拉框勾选
			fox.setSelectValue4QueryApi("#maintenanceMethod",formData.maintenanceMethodData);
			//设置  建议维保方式 设置下拉框勾选
			fox.setSelectValue4QueryApi("#suggestMaintenanceMethod",formData.suggestMaintenanceMethodData);

			//处理fillBy

			//
	     	fm.attr('method', 'POST');
	     	fox.fillDialogButtons();
	     	renderFormFields();

			window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);

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



		//获取 维保商 下拉框的值
		data["maintainerId"]=fox.getSelectedValue("maintainerId",false);
		//获取 维保状态 下拉框的值
		data["maintenanceStatus"]=fox.getSelectedValue("maintenanceStatus",false);
		//获取 维保方式 下拉框的值
		data["maintenanceMethod"]=fox.getSelectedValue("maintenanceMethod",false);
		//获取 建议维保方式 下拉框的值
		data["suggestMaintenanceMethod"]=fox.getSelectedValue("suggestMaintenanceMethod",false);

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
					admin.finishPopupCenterById('eam-asset-maintenance-record-u-form-data-win');
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


	    //关闭窗口
	    $("#cancel-button").click(function(){ admin.finishPopupCenterById('eam-asset-maintenance-record-u-form-data-win',this); });

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