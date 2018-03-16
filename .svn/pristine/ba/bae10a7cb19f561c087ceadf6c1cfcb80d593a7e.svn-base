//返回r
function goback(){
	tlocation("../zxApplyPhoneCardController/loadZxGrantPhoneCard");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxApplyPhoneCardBySelective(){
	var zz= /^[1][3,4,5,7,8][0-9]{9}$/;
	var phone_card = $("#phone_card").val();
	if(zz.test(phone_card)){
		submitBForm('defaultForm','../zxApplyPhoneCardController/updateZxApplyPhoneCardBySelective','../zxApplyPhoneCardController/loadZxGrantPhoneCard');
	}else{
		toastrBoot(4,"请输入正确的手机号码");
		return;
	}
}
$(function(){
	InitBDataComboSetV("zx_apply_phone_card_status","status","status_");
	InitBDataCombo("zx_phone_card_set","phone_card_set");
});
$("input[name='apply_matter']").each(function(j,item){
    // 你要实现的业务逻辑
	var apply_matter = $("#id1").val();
	var a1 = apply_matter.substring(0,1);
    if(item.value==a1){
	   item.checked=true;
    }
    if(a1==5){
    	var a2 = apply_matter.substring(2,apply_matter.length);
    	$("#other").val(a2);
		$("#other").show();
	}
});
