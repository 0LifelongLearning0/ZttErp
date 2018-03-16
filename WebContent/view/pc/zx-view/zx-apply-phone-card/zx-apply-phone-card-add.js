//返回r
function goback(){
	tlocation("../zxApplyPhoneCardController/loadZxApplyPhoneCard");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
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
//保存
function addZxApplyPhoneCard(){
	submitBForm('defaultForm','../zxApplyPhoneCardController/addZxApplyPhoneCard','../zxApplyPhoneCardController/loadZxApplyPhoneCard');
}