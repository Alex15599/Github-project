//======项目名=============///
var appPath;
// ===========================通用============================//

// 转到其他页面
function turnTo(url) {
	window.location = url;
}

//=======================首页闪动图片==========================//
function setPic(obj){
	$("#content_1_pic").html(setScrollPhoto(obj, 300,150, 4, 3000, 1, '000000', 'dddddd',appPath));
}

// 画投票统计图
function drawBar(maxBallot, width) {
	var bar = $(".bar");
	bar.each(function(i) {
				var thisBallot = $(this).attr("title");
				$(this).css("width", thisBallot / maxBallot * width);
			});
}

// ===========================后台页面============================//

// 投票活动表单验证
function checkVoteForm() {
	var endTime = $("#endTime");
	if (endTime.val() == null || endTime.val() == "") {
		alert("请选择结束时间！");
		return false;
	}
	buildVoteLimit();
	if ($("input[id=voterName][value=1]").attr("checked") == true) {
		buildVoterInfo();
	}
	return true;
}

// 创建投票限制
function buildVoteLimit() {
	var limit = "";
	var limitRadio = $("input[name=limit]");
	var voteLimit = $("#voteLimit");
	limitRadio.each(function(i) {
				if ($(this).attr("checked") == true) {
					limit += i;
					var interval;
					switch (i) {
						case 0 :
							interval = "";
							break;
						case 1 :
							interval = $("#selectLimit1").val();
							break;
						case 2 :
							interval = $("#macAmount1").val();
							break;
						case 3 :
							interval = $("#selectLimit3").val();
							interval += "&" + $("#macAmount2").val();
							break;
					}
					limit += "&" + interval;
					return false;
				}
			});
	voteLimit.val(limit);
}

// 恢复投票限制
function getbackVoteLimit() {
	var voteLimit = $("#voteLimit").val();
	var limitString = voteLimit.split("&");
	switch (limitString[0]) {
		case "0" :
			$("input[id=limit][value=0]").click();
			break;
		case "1" :
			$("input[id=limit][value=1]").click();
			$("#selectLimit1").val(limitString[1]);
			break;
		case "2" :
			$("input[id=limit][value=2]").click();
			$("#macAmount1").val(limitString[1]);
			break;
		case "3" :
			$("input[id=limit][value=3]").click();
			$("#selectLimit3").val(limitString[1]);
			$("#macAmount2").val(limitString[2]);
			break;
	}
}

// 创建投票者信息
function buildVoterInfo() {
	var voter = "";
	var voterName = $("#voterName");
	var voterInfo = $("#voterInfo");
	if (voterName.attr("checked") == false) {
		var elem = $(":checkbox");
		elem.each(function(i) {
					if ($(this).attr("checked") == true) {
						voter += (i + 1) + "$";
					} else {
						voter += 0 + "$";
					}
					var info = $("#info" + (i + 1)).val();
					voter += info + "&";
				});
	}
	voterInfo.val(voter);
}

// 恢复投票者信息
function getbackVoterInfo() {
	var voterInfo = $("#voterInfo").val();
	var infos = voterInfo.split("&");
	$.each(infos, function(i, n) {
				// var cell = infos[i].split("$");
				var cell = n.split("$");
				if (cell[0] == (i + 1)) {
					$("#isInfo" + (i + 1)).click();
				}
				$("#info" + (i + 1)).val(cell[1]);
			});
}

// 投票限制 - 不限制
function limit0() {
	limitInputDisable();
}

// 投票限制 - n小时内禁止同一IP重复投票
function limit1() {
	limitInputDisable();
	var select = $("#selectLimit1");
	select.removeAttr("disabled");
}

// 投票限制 - 每台电脑只能投m票
function limit2() {
	limitInputDisable();
	var macAmount1 = $("#macAmount1");
	macAmount1.removeAttr("disabled");
}

// 投票限制 - n小时内禁止同一IP重复投票且每台电脑只能投m票
function limit3() {
	limitInputDisable();
	var select3 = $("#selectLimit3");
	var macAmount2 = $("#macAmount2");
	select3.removeAttr("disabled");
	macAmount2.removeAttr("disabled");
}

// 投票限制 - input项失效
function limitInputDisable() {
	var select1 = $("#selectLimit1");
	var select3 = $("#selectLimit3");
	var macAmount1 = $("#macAmount1");
	var macAmount2 = $("#macAmount2");
	select1.attr("disabled", "disabled");
	select3.attr("disabled", "disabled");
	macAmount1.attr("disabled", "disabled");
	macAmount2.attr("disabled", "disabled");
}

// 投票者信息失效
function voterInfoDisable(id) {
	var voter = $("#" + id);
	voter.hide();
}

// 投票者信息启用
function voterInfoAble(id) {
	var voter = $("#" + id);
	voter.show();
}

// 投票者信息名称输入框启用状况转换
function voterInfoTextAble(id) {
	var isInfo = $("#isInfo" + id);
	var voterInfoText = $("#info" + id);
	if (isInfo.attr("checked") == true) {
		voterInfoText.removeAttr("disabled");
	} else {
		voterInfoText.attr("disabled", "disabled");
	}
}

// 初始化投票活动设置页面
function initVoteManage() {
	$("#macDivid").hide();
	if ($("#voteId").val() == null || $("#voteId").val() == "") {
		$("#voteType").attr("checked", "checked");
		$("#isOpened").attr("checked", "checked");
		$("#limit").attr("checked", "checked");
		$("#arrangeMode").attr("checked", "checked");
		$("input[id=voterName][value=0]").click();
	} else {
		getbackVoteLimit();
		getbackVoterInfo();
		if ($("input[id=voterName][value=1]").attr("checked") == true) {
			voterInfoAble("voter");
		} else {
			voterInfoDisable("voter");
		}
	}

}

// 删除表单验证
function checkDeleteForm() {
	var checkbox = $(":checkbox");
	var flag = 0;
	checkbox.each(function(i) {
				if ($(this).attr("checked") == true) {
					flag = 1;
				}
			});
	if (flag == 0) {
		alert("请先选择！");
		return false;
	}
}

// ============================前台页面==============================//

// 首页 - 初始化投票选项列表 - 设置缩略图、设置投票者信息输入框
function initIndex(voterName, voterInfo,path) {
	rollpicService.queryDBRP(setPic);
	appPath= path;
	setPictures();
	setVoter(voterName, voterInfo);
}

// 投票区 - 初始化投票选项列表 - 设置缩略图、设置投票者信息输入框
function initListVoteInfos(voterName, voterInfo) {
	setPictures();
	setVoter(voterName, voterInfo);
}

// 设置缩略图
function setPictures() {
	var img = $("img[name=picture]");
	img.each(function(i, n) {
				var imageDest = new Image();
				imageDest.src = $(this).attr("src");
				imageDest = ResizeImage(imageDest, 177, 140);
				$(this).css("width", imageDest.width);
				$(this).css("height", imageDest.height);
			});
}

// 将imageDest图片的大小按比例缩放,适合显示在宽W和高H的区域内
function ResizeImage(imageDest, W, H) {
	// 显示框宽度W,高度H
	var image = new Image();
	image.src = imageDest.src;
	if (image.width > 0 && image.height > 0) {
		// 比较纵横比
		if (image.width / image.height >= W / H)// 相对显示框：宽>高
		{
			if (image.width > W) // 宽度大于显示框宽度W，应压缩高度
			{
				imageDest.width = W;
				imageDest.height = (image.height * W) / image.width;
			} else // 宽度少于或等于显示框宽度W，图片完全显示
			{
				imageDest.width = image.width;
				imageDest.height = image.height;
			}
		} else// 同理
		{
			if (image.height > H) {
				imageDest.height = H;
				imageDest.width = (image.width * H) / image.height;
			} else {
				imageDest.width = image.width;
				imageDest.height = image.height;
			}
		}
	}
	return imageDest;
}

// 设置投票者信息输入框
function setVoter(voterName, voterInfo) {
	if (voterName == 1) {
		// 记名投票
		var voter = $("#voter");
		var infos = voterInfo.split("&");
		$.each(infos, function(i, n) {
					// var cell = infos[i].split("$");
					var cell = n.split("$");
					if (cell[0] == (i + 1)) {
						voter.append("<tr><td align='right'>" + cell[1]
								+ "：</td><td><input type='text' name='info"
								+ (i + 1) + "' value=''></td></tr>");
						var myDiv = $(".mydiv");
						myDiv.height(myDiv.height() + 41);
					}
				});
	}
}

// 显示半透明层
function showDiv() {
	document.getElementById("popDiv").style.display = "block";
	document.getElementById("bg").style.display = "block";
	$("input[type=text]")[0].focus();
}

// 显示半透明层
function showDiv(voteInfoId) {
	document.getElementById("popDiv").style.display = "block";
	document.getElementById("bg").style.display = "block";
	$("input[type=text]")[0].focus();
	// 设置参数voteInfoId
	var id = $("#voteInfoId");
	id.val(voteInfoId);
}

// 隐藏半透明层
function closeDiv() {
	document.getElementById("popDiv").style.display = "none";
	document.getElementById("bg").style.display = "none";
}

// 投票表单验证
function checkVote() {
	var flag = 0;
	var input = $("input[type=text][id!=author][id!=validatecodeReq]");
	input.each(function(i) {
				if ($(this).val() == null || $(this).val() == "") {
					flag = 1;
					$(this).focus();
					return false;
				}
			});
	if (flag == 1) {
		alert("请输入所有信息！");
		return false;
	} else {
		return true;
	}
}

// 改变投票选项排列方式
function changeArrange(url) {
	var arrange = $("#arrange");
	url += "&arrange=" + arrange.val();
	window.location = url;
}