/**
 * 编码字段 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 20:46:24
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,transfer;
	const moduleURL="/service-eam/eam-code-rule";
	// 表单执行操作类型：view，create，edit
	var action=null;
	var disableCreateNew=false;
	var disableModify=false;
	var dataBeforeEdit=null;
	var tr=null;
	var data1 = [];
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		transfer=layui.transfer;
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		action=admin.getTempData('eam-code-rule-form-data-form-action');
		//如果没有修改和保存权限
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(action=="view") {
			disableModify=true;
		}

		disableModify=false;

		for(var i=0;i<CODE_PARTS.length;i++){
			var e={};
			e.value=CODE_PARTS[i].id;
			e.title=CODE_PARTS[i].name;
			console.log("tranfer",e);
			data1.push(e);
		}
		tr=transfer.render({
			elem: '#col'
			,title: ['未选择', '已选择']
			,data: data1
			,height: 550 //定义高度
		})


		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit(action,admin.getTempData('eam-code-rule-form-data'));
		}


		//关闭窗口
		$("#submit-button").click(function(){
			var dataF=form.val("data-form");
			var ps=dataF;
			ps.partIds=JSON.stringify(tr.config.value);
			var api="/service-eam/eam-code-rule/update";
			top.layer.confirm(fox.translate('是否保存当前资产编码规则？'), function (i) {
				top.layer.close(i);
				admin.post(api, ps, function (r) {
					if (r.success) {
						reload();
						top.layer.msg("操作成功", {time: 1000});
					} else {
						top.layer.msg(r.message, {time: 1000});
					}
				}, {delayLoading: 1000, elms: []});
			});
		});

		reload();

		//渲染表单组件
		renderFormFields();

		//填充表单数据
	//	fillFormData();

		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();
	}

	function reload(){
		admin.post(moduleURL+"/get-by-id", {id:""}, function (data) {
			if (data.success) {
				fillFormData(data.data);
			} else {
				fox.showMessage(data);
			}

		}, {delayLoading:1000,elms:[]});
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
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'eam-code-rule-form-data-win');
			if(area==null) return;
			admin.putTempData('eam-code-rule-form-area', area);
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

		form.on('radio(numberSeqType)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=numberSeqType]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("numberSeqType",data,checked);
		});

	}

	function ArrayIndexOf(arr,attr,value){
		//检测value在attr中出现的位置
		for (var i=0;i<arr.length;i++){
			if(arr[i][attr]===value){
				console.log("catch it");
				return i;
			}
		}
		return -1;
	}

	function transferRightSort(arr1,attr,arr2){
		var arr=[];
		for(var i=0;i<arr2.length;i++){
			var index=ArrayIndexOf(arr1,attr,arr2[i]);
			arr.push(arr1[index]);
			arr1.splice($.inArray(arr1[index],arr1),1);
		}
		arr1.push.apply(arr1,arr);
	}


	/**
	 * 填充表单数据
	 */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('eam-code-rule-form-data');
		}
		var ids=JSON.parse(formData.partIds);
		transferRightSort(data1,"value",ids);
		tr=transfer.render({
				elem: '#col'
				,title: ['未选择', '已选择']
				,data: data1
				,value: ids
				,height: 550 //定义高度
	})
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
			//处理fillBy
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
		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param) {
		param.dirtyFields=fox.compareDirtyFields(dataBeforeEdit,param);
		var api=moduleURL+"/"+(param.id?"update":"insert");
		admin.post(api, param, function (data) {
			if (data.success) {
				var doNext=true;
				if(window.pageExt.form.betweenFormSubmitAndClose) {
					doNext=window.pageExt.form.betweenFormSubmitAndClose(param,data);
				}
				if(doNext) {
					admin.finishPopupCenterById('eam-code-rule-form-data-win');
				}
			} else {
				fox.showMessage(data);
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
		}, {delayLoading:1000,elms:[$("#submit-button")]});
	}

	/**
	 * 保存数据，表单提交事件
	 */
	function bindButtonEvent() {

		form.on('submit(submit-button)', function (data) {
			var ps=data.field;
			ps.partIds=JSON.stringify(tr.config.value);
			var api="/service-eam/eam-code-rule/update";
			top.layer.confirm(fox.translate('是否保存当前资产编码规则？'), function (i) {
				top.layer.close(i);
				admin.post(api, ps, function (r) {
					if (r.success) {
						reload();
						top.layer.msg("操作成功", {time: 1000});
					} else {
						top.layer.msg(r.message, {time: 1000});
					}
				}, {delayLoading: 1000, elms: []});
			});
			return false;
		});



	}

	window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		fillFormData: fillFormData,
		adjustPopup: adjustPopup,
		action: action,
		setAction: function (act) {
			action = act;
		}
	};

	window.pageExt.form.ending && window.pageExt.form.ending();

}

layui.use(['transfer','form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});