//返回r
function goback(){
	tlocation("../zxScheduleDayController/loadZxScheduleDay");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//初始化日期选择器
$(document).ready(function(){
	InitBDataCombo("zx_transaction_type","transaction_type");
	InitBDataCombo("whether","transaction_remind");
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
//保存
function addZxScheduleDay(){
	submitBForm('defaultForm','../zxScheduleDayController/addZxScheduleDay','../zxScheduleDayController/loadZxScheduleDay');
}