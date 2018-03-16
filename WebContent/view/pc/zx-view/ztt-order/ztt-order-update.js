//返回r
function goback(){
	tlocation("../zttOrderController/loadZttOrder");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttOrder(){
	submitBForm('defaultForm','../zttOrderController/updateZttOrder','../zttOrderController/loadZttOrder');
}

