//返回r
function goback(){
	tlocation("../zxSignContractController/loadZxSignContract");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxSignContract(){
	submitBForm('defaultForm','../zxSignContractController/updateZxSignContract','../zxSignContractController/loadZxSignContract');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});

