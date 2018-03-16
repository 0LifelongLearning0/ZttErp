//返回r
function goback(){
	tlocation("../zxApplyPhoneCardController/loadZxApplyPhoneCard");
}
InitBDataComboSetV("zx_apply_phone_card_status","status","status_");

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