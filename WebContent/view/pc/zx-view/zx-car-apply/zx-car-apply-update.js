//返回r
function goback(){
	tlocation("../zxCarApplyController/loadZxCarApply");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxCarApply(){
	submitBForm('defaultForm','../zxCarApplyController/updateZxCarApply','../zxCarApplyController/loadZxCarApply');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
	InitBDataComboSetV("zx_car_apply_type","apply_type","apply_type_");
});

