//返回r
function goback(){
	tlocation("../zxMeetingHouseController/loadZxMeetingHouse");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxMeetingHouse(status){
	submitBForm('defaultForm','../zxMeetingHouseController/addZxMeetingHouse','../zxMeetingHouseController/loadZxMeetingHouse');
}

//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
	InitMyDataCombo("zx_meeting_house","status");
});
function InitMyDataCombo(ckey,id){
	var str = "<option value=''>请选择</option>";
	$.ajax({
	   type:"GET",
	   url:"../xtCommonController/getXtDataDictionaryList",
	   data:"ckey="+ckey,
	   success: function(data){
//		   result = eval("(" + result + ")");  
//		   result = result.data;
//		   result.xt_data_dictionary_name;
		   //从服务器获取数据进行绑定
         $.each(data, function(i, item){
         	 str += "<option value=" + item.xt_data_dictionary_id + ">" + item.xt_data_dictionary_name + "</option>";
         })
         $("#"+id).append(str);
	   }
	});
}
