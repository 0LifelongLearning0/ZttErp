//返回r
function goback(){
	tlocation("../zttMojuUserinfoController/loadZttMojuUserinfo");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttMojuUserinfo(){
	submitBForm('defaultForm','../zttMojuUserinfoController/updateZttMojuUserinfo','../zttMojuUserinfoController/loadZttMojuUserinfo');
}

function DeviceSelect(){
	var upid="device";
	layer.open({
		title: '选择供应商',
		type: 2, 
		area: ['800px', '500px'],
		content: "../zttOrderController/selectsuppler?upid="+upid
	 
	}); 
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