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

