//返回r
function goback(){
	tlocation("../xtPostController/loadXtPost");
}

$.ajax({
   type:"GET",
   url:"../xtPostController/getXtPostById",
   data:"xt_post_id="+$('#xt_post_parentId').val(),
   success: function(result){
	   result = eval("(" + result + ")");  
	   result = result.data;
	   if(result != null && result != ''){
		   $('#xt_post_parentName').html(result.xt_post_name);
	   }else{
		   $('#xt_post_parentName').html("无");
	   }
   }
});