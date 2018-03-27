//返回r
function goback(){
	tlocation("../zttOrderbyselfController/loadZttOrderbyself");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttOrderbyself(){
	submitBForm('defaultForm','../zttOrderbyselfController/updateZttOrderbyself','../zttOrderbyselfController/loadZttOrderbyself');
}

