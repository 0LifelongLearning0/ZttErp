//返回r
function goback(){
	tlocation("../zttCodeversionController/loadZttCodeversion");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZttCodeversion(){
	submitBForm('defaultForm','../zttCodeversionController/addZttCodeversion','../zttCodeversionController/loadZttCodeversion');
}

