//返回r
function goback(){
	tlocation("../zttOrderbybuyController/loadZttOrderbybuy");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZttOrderbybuy(){
	submitBForm('defaultForm','../zttOrderbybuyController/addZttOrderbybuy','../zttOrderbybuyController/loadZttOrderbybuy');
}

