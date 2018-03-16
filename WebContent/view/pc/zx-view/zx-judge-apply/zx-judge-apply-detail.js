//返回r
function goback(){
	tlocation("../zxSupplierController/loadZxSupplier");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});

//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});
