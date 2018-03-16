//返回r
function goback(){
	tlocation("../zxChangeContractController/loadZxChangeContract");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxChangeContract(){
	submitBForm('defaultForm','../zxChangeContractController/updateZxChangeContract','../zxChangeContractController/loadZxChangeContract');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});

