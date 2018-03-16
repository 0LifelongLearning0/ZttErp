//返回r
function goback(){
	tlocation("../zxScheduleDayController/loadZxScheduleDay");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxScheduleDay(){
	submitBForm('defaultForm','../zxScheduleDayController/updateZxScheduleDay','../zxScheduleDayController/loadZxScheduleDay');
}
//初始化日期选择器
$(document).ready(function(){
	InitBDataComboSetV("zx_transaction_type","transaction_type","transaction_type_");
	InitBDataComboSetV("whether","transaction_remind","transaction_remind_");
	datetimeInit();
	var transaction_remind =$("#transaction_remind_").val();
	if(transaction_remind==1){
		$("#remind_day").show();
		$("#remind_hour").show();
		$("#remind_minute").show();
	}else{
		$("#remind_day").hide();
		$("#remind_hour").hide();
		$("#remind_minute").hide();
	}
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
//删除
function delZxScheduleDay(){
	msgTishCallFnBoot("确定要删除这条数据？",function(){
		var params = {id:$("#scheduleId").val()};
		ajaxBRequestCallUrl('../zxScheduleDayController/delZxScheduleDay','../zxScheduleDayController/loadZxScheduleDay',params);
	})
}