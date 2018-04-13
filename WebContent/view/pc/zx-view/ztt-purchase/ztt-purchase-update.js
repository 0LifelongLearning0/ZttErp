//返回r
function goback(){
	tlocation("../zttPurchaseController/loadZttPurchase");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttPurchase(){
	submitBForm('defaultForm','../zttPurchaseController/updateZttPurchase','../zttPurchaseController/loadZttPurchase');
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