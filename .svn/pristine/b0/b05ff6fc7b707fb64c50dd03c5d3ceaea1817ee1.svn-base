//返回r
function goback(){
	tlocation("../zxMeetingHouseController/loadZxMeetingHouse");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxMeetingHouse(status){
	submitBForm('defaultForm','../zxMeetingHouseController/updateZxMeetingHouse','../zxMeetingHouseController/loadZxMeetingHouse');
}

//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
	InitMyDataCombo("zx_meeting_house","status","status_");
});
function InitMyDataCombo(ckey,id,value_id){
	var str = "<option value=''>请选择</option>";
	$.ajax({
	   type:"GET",
	   url:"../xtCommonController/getXtDataDictionaryList",
	   data:"ckey="+ckey,
	   success: function(data){
         $.each(data, function(i, item){
         	 str += "<option value=" + item.xt_data_dictionary_id + ">" + item.xt_data_dictionary_name + "</option>";
         })
         $("#"+id).append(str);
         try {
      	   if(null != value_id && '' != value_id){
      		   if('undefined' != typeof($('#'+value_id).val()) && null != $('#'+value_id).val() && '' != $('#'+value_id).val() && '请选择' != $('#'+value_id).val()){
      			   $('#'+id).val($('#'+value_id).val());
      		   }
             }
		   } catch (e) {
				console.log("读取下拉框为数据字典类型并赋值出现异常，异常信息："+e);
		   }
	   }
	});
}