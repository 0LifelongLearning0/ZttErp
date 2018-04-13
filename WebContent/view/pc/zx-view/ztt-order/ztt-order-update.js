//返回r
function goback() {
	tlocation("../zttOrderController/loadZttOrder");
}
// 保存
function updateZttOrder() {
	submitBForm('defaultForm', '../zttOrderController/updateZttOrder',
			'../zttOrderController/loadZttOrder');
}
// 发起提交表单
function submitBForm(formid, url, callUrl) {
	var bill=document.getElementById("bill_date_open").value;

	if (null == formid || '' == formid) {
		window.parent.toastrBoot(4, "未能获取到formid!");
		return;
	}
	var bootform = $('#' + formid);
	if (typeof (bootform) == "undefined" || null == bootform || '' == bootform) {
		window.parent.toastrBoot(4, "未能获取到form对象!");
		return;
	}
	msgTishCallFnBoot("确定要提交该表单信息？", function() {
		$.ajax({
			url : url,
			// async:false,//同步，会阻塞操作
			type : 'POST',// PUT DELETE POST
			data : bootform.serialize(),
			success : function(result) {
				try {
					result = eval("(" + result + ")");
					if (typeof (result.success) != "undefined") {
						if (result.success) {
							window.parent.toastrBoot(3, result.msg);
							if (null != callUrl) {
								// 默认返回页面
								tlocation(callUrl);
							}
						} else {
							// 失败还在原位置页面
							window.parent.toastrBoot(4, result.msg);
						}
					}
				} catch (e) {

				}
			},
			error : function() {

			}
		})
	})
}
$(function() {
	
	$(".form_datetime").datepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		todayHighlight : true,
		showMeridian : true,
		pickerPosition : "bottom-left",
		language : 'zh-CN',// 中文，需要引用zh-CN.js包
	});

});
