//返回r
function goback(){
	tlocation("../zxStaffRecordController/loadZxStaffRecord");
}
//初始化日期选择器
$(document).ready(function(){
	InitBDataComboSetV("whether","residence_permit","residence_permit_");
	InitBDataComboSetV("whether","social_security_cards","social_security_cards_");
	InitBDataComboSetV("xt_userinfo_highestDegree","userinfo_highestDegree","userinfo_highestDegree_");
});
