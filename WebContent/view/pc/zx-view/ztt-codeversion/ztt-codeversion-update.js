//返回r
function goback(){
	tlocation("../zttCodeversionController/loadZttCodeversion");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttCodeversion(){
	submitBForm('defaultForm','../zttCodeversionController/updateZttCodeversion','../zttCodeversionController/loadZttCodeversion');
}

