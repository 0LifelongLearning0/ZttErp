//返回r
function goback(){
	tlocation("../zxStaffRecordController/loadZxStaffRecord");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxStaffRecord(){
	submitBForm('defaultForm','../zxStaffRecordController/updateZxStaffRecord','../zxStaffRecordController/loadZxStaffRecord');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
	InitBDataComboSetV("whether","residence_permit","residence_permit_");
	InitBDataComboSetV("whether","social_security_cards","social_security_cards_");
	InitBDataComboSetV("xt_userinfo_highestDegree","userinfo_highestDegree","userinfo_highestDegree_");
});

