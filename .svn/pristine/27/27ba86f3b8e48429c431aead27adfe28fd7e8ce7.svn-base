//返回r
function goback(){
	tlocation("../zxSupplierController/loadZxSupplier");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxSupplier(){
	submitBForm('defaultForm','../zxSupplierController/addZxSupplier','../zxSupplierController/loadZxSupplier');
}

//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
    $("#classify").append("<option value=''>请选择</option><option value='A'>A</option><option value='B'>B</option><option value='C'>C</option><option value='D'>D</option>");
    $("#type").append("<option value=''>请选择</option><option value='1'>供应商</option><option value='2'>加工商</option>");
    InitMyDataCombo("zx_zhiwu","title");
    $("#pay_type").append("<option value=''>请选择</option><option value='1'>全款</option><option value='2'>货到付款</option><option value='3'>预付款</option>");
    $("#is_connect").append("<option value=''>请选择</option><option value='1'>是</option><option value='0'>否</option>");
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