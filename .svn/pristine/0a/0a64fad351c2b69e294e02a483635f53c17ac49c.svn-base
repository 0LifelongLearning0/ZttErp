//返回r
function goback(){
	tlocation("../xtDepartinfoController/loadXtDepartinfo");
}

$.ajax({
   type:"GET",
   url:"../xtDepartinfoController/getXtDepartinfoById",
   data:"xt_departinfo_id="+$('#xt_departinfo_parentId').val(),
   success: function(result){
	   result = eval("(" + result + ")");  
	   result = result.data;
	   if(result != null && result != ''){
		   $('#xt_departinfo_parentName').html(result.xt_departinfo_name);
	   }else{
		   $('#xt_departinfo_parentName').html("无");
	   }
   }
});