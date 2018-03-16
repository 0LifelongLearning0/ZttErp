//返回r
function goback(){
	tlocation("../zxSixSController/loadZxSixS");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxSixS(status){
	if($('#check_date').val() == ''){
		toastrBoot(4,"请选择检查日期");
		return;
	}
	submitBForm('defaultForm','../zxSixSController/updateZxSixS','../zxSixSController/loadZxSixS');
}

//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});
