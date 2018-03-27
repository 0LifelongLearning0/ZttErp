//返回r
function goback(){
	tlocation("../zttOrderbybuyController/loadZttOrderbybuy");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttOrderbybuy(){
	submitBForm('defaultForm','../zttOrderbybuyController/updateZttOrderbybuy','../zttOrderbybuyController/loadZttOrderbybuy');
}

