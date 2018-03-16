//返回r
function goback(){
	tlocation("../zxSupplierController/loadZxSupplier");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxJudgeApply(status){
	var te = $('#judge_date_end').val();
	var ts = $('#judge_date_start').val();
	if(ts == ''){
		toastrBoot(4,"请选择开始日期");
		return;
	}
	if(te == ''){
		toastrBoot(4,"请选择结束日期");
		return;
	}
	if(ts > te){
		toastrBoot(4,'日期选择错误');
		return;
	}
	submitBForm('defaultForm','../zxJudgeApplyController/addZxJudgeApply?status=' + status,'../zxSupplierController/loadZxSupplier');
}

//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});
