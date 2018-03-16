//返回r
function goback(){
	tlocation("../zxPeriodTransactionController/loadZxPeriodTransaction");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxPeriodTransaction(){
	submitBForm('defaultForm','../zxPeriodTransactionController/addZxPeriodTransaction','../zxPeriodTransactionController/loadZxPeriodTransaction');
}
//初始化日期选择器
$(document).ready(function(){
	InitBDataCombo("zx_repeat_type","repetition_type");
	InitBDataCombo("zx_transaction_type","transaction_type");
	InitBDataCombo("whether","transaction_remind");
	InitBDataCombo("zx_week","repetition_week");
	InitBDataCombo("zx_day","repetition_day");
	datetimeInit();
});
$('#transaction_remind').change(function () {
	var transaction_remind =$("#transaction_remind").val();
	if(transaction_remind==1){
		$("#remind_day").show();
		$("#remind_hour").show();
		$("#remind_minute").show();
	}else{
		$("#remind_day").hide();
		$("#remind_hour").hide();
		$("#remind_minute").hide();
	}
})
$('#repetition_type').change(function () {
	var repetition_type =$("#repetition_type").val();
	if(repetition_type==2){
		$("#week").show();
		$("#day").hide();
	}else if(repetition_type==3){
		$("#week").hide();
		$("#day").show();
	}else{
		$("#week").hide();
		$("#day").hide();
	}
})
