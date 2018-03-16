//返回r
function goback(){
	tlocation("../zxChangeContractController/loadZxChangeContract");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxChangeContract(){
	submitBForm('defaultForm','../zxChangeContractController/addZxChangeContract','../zxChangeContractController/loadZxChangeContract');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});
//员工选择器
function toChooseUser(){
	tlocation('../zxChangeContractController/toZxChangeContractUserChoose');
}
