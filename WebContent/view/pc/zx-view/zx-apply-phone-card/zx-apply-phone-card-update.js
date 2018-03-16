//返回r
function goback(){
	tlocation("../zxApplyPhoneCardController/loadZxApplyPhoneCard");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxApplyPhoneCard(){
	submitBForm('defaultForm','../zxApplyPhoneCardController/updateZxApplyPhoneCard','../zxApplyPhoneCardController/loadZxApplyPhoneCard');
}
$(function(){
	  $(":radio").click(function(){
		  var v = $(this).val();
		  if(v==5){
			  $("#other").show();
		  }else{
			  $("#other").hide();
		  }
	  });
});
$("input[name='apply_matter']").each(function(j,item){
    // 你要实现的业务逻辑
	var apply_matter = $("#id1").val();
	var a1 = apply_matter.substring(0,1);
	var a2 = apply_matter.substring(2,apply_matter.length);
    if(item.value==a1){
	   item.checked=true;
    }
    if(a1==5){
    	$("#other").val(a2);
		$("#other").show();
	}
});