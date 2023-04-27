/**
 * 财务分类 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 13:01:40
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-eam/eam-category-finance";

	var disableCreateNew=false;
	var disableModify=false;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;


		if(admin.getTempData('eam-category-finance-form-data-form-action')=="view") {
			disableModify=true;
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit();
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


	function loadFormData(id) {
		admin.request(moduleURL+"/get-by-id",{id:id},function(r) {
			if(r.success) {
				fillFormData(r.data)
			} else {
				admin.toast().error("获取数据失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
			}
		});
	};

	window.loadFormData=loadFormData;

	/**
	 * 自动调节窗口高度
	 * */
	var adjustPopupTask=-1;
	function adjustPopup() {
		clearTimeout(adjustPopupTask);
		var scroll=$(".form-container").attr("scroll");
		if(scroll=='yes') return;
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			var area=admin.changePopupArea(null,bodyHeight+footerHeight);
			if(area==null) return;
			admin.putTempData('eam-category-finance-form-area', area);
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

	}


	function fillFormData(formData) {


		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);
			fm.attr('method', 'POST');
			renderFormFields();
		}

		//渐显效果
		fm.css("opacity","0.0");
		fm.css("display","");
		setTimeout(function (){
			fm.animate({
				opacity:'1.0'
			},100);
		},1);

	}

	/**
      * 填充表单数据
      */
	// function fillFormData() {
	// 	var formData = admin.getTempData('eam-category-finance-form-data');
	//
	// 	window.pageExt.form.beforeDataFill && window.pageExt.form.beforeDataFill(formData);
	//
	// 	//如果是新建
	// 	if(!formData || !formData.id) {
	// 		adjustPopup();
	// 	}
	// 	var fm=$('#data-form');
	// 	if (formData) {
	// 		fm[0].reset();
	// 		form.val('data-form', formData);
	//
	//
	//      	fm.attr('method', 'POST');
	//      	renderFormFields();
	//
	// 		window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);
	//
	// 	}
	//
	// 	//渐显效果
	// 	fm.css("opacity","0.0");
    //     fm.css("display","");
    //     setTimeout(function (){
    //         fm.animate({
    //             opacity:'1.0'
    //         },100);
    //     },1);
	//
    //     //禁用编辑
	// 	if(disableModify || disableCreateNew) {
	// 		fox.lockForm($("#data-form"),true);
	// 		$("#submit-button").hide();
	// 		$("#cancel-button").css("margin-right","15px")
	// 	} else {
	// 		$("#submit-button").show();
	// 		$("#cancel-button").css("margin-right","0px")
	// 	}
	//
	// 	//调用 iframe 加载过程
	// 	var formIfrs=$(".form-iframe");
	// 	for (var i = 0; i < formIfrs.length; i++) {
	// 		var jsFn=$(formIfrs[i]).attr("js-fn");
	// 		if(window.pageExt.form){
	// 			jsFn=window.pageExt.form[jsFn];
	// 			jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,formData);
	// 		}
	// 	}
	//
	// }

	function getFormData() {
		var data=form.val("data-form");

		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(data) {
		var api=moduleURL+"/"+(data.id?"update":"insert");
		var task=setTimeout(function(){layer.load(2);},1000);
		admin.request(api, data, function (data) {
			clearTimeout(task);
			layer.closeAll('loading');
			if (data.success) {
				layer.msg(data.message, {icon: 1, time: 500});
				var index=admin.getTempData('eam-category-finance-form-data-popup-index');
				admin.finishPopupCenter(index);
			} else {
				layer.msg(data.message, {icon: 2, time: 1000});
			}
		}, "POST");
	}


	/**
	 * 保存数据，表单提交事件
	 */
	function bindButtonEvent() {

		form.on('submit(submit-button)', function (data) {
			//debugger;
			console.log('submit',data);
			if(data.field.id==""){
				layer.msg("请先选择", {icon: 2, time: 1000});
				return false;
			}

			var api=moduleURL+"/update";
			var task=setTimeout(function(){layer.load(2);},1000);
			admin.request(api, data.field, function (res) {
				clearTimeout(task);
				layer.closeAll('loading');
				if (res.success) {
					if (parent){
						parent.changeNodeName(data.field.id,data.field.categoryName);
					}
					layer.msg(res.message, {icon: 1, time: 500});
				} else {
					layer.msg(res.message, {icon: 2, time: 1000});
				}
			}, "POST");

			return false;
		});


	}

	//
	// /**
    //   * 保存数据，表单提交事件
    //   */
    // function bindButtonEvent() {
	//
	//     form.on('submit(submit-button)', function (data) {
	//     	//debugger;
	// 		data.field = getFormData();
	//
	// 		if(window.pageExt.form.beforeSubmit) {
	// 			var doNext=window.pageExt.form.beforeSubmit(data.field);
	// 			if(!doNext) return ;
	// 		}
	// 		//校验表单
	// 		if(!verifyForm(data.field)) return;
	//
	// 		saveForm(data.field);
	//         return false;
	//     });
	//
	//
	//     //关闭窗口
	//     $("#cancel-button").click(function(){admin.closePopupCenter();});
	//
    // }

    window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		adjustPopup: adjustPopup
	};

	window.pageExt.form.ending && window.pageExt.form.ending();

}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});