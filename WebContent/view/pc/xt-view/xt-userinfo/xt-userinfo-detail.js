//返回r
function goback(){
	tlocation("../xtUserinfoController/loadXtUserinfo");
}

//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
	InitBDataComboCallFn('gender',function(data){
		$.each(data, function(i, item){
			if($("#gender").val() == item.xt_data_dictionary_value){
				$("#gender_text").html(item.xt_data_dictionary_name);
				return;
			}
        })
	});
	InitBDataComboCallFn('xt_userinfo_state',function(data){
		$.each(data, function(i, item){
			if($("#xt_userinfo_state").val() == item.xt_data_dictionary_value){
				$("#xt_userinfo_state_text").html(item.xt_data_dictionary_name);
				return;
			}
        })
	});
});
