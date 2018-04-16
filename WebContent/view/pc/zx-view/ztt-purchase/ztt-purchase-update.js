//返回r
function goback(){
	tlocation("../zttPurchaseController/loadZttPurchase");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttPurchase(){
	submitBForm('defaultForm','../zttPurchaseController/updateZttPurchase','../zttPurchaseController/loadZttPurchase');
}

$(function() {
	var apply_id=document.getElementById("apply_id").value;
	
	if(apply_id=="7DA3010BC6F649F880C6838F27AF3B10"){
		document.getElementById("cost_single_price").style.display="none";
		document.getElementById("buttonsave").style.display="none";
		document.getElementById("supply").style.display="none";
		document.getElementById("supplier_bill_date").style.display="none";
		document.getElementById("supplier_bill_price").style.display="none";
		document.getElementById("erp_number").readOnly = true;
		document.getElementById("apply_id").readOnly = true;
		
	}
	if(apply_id=="B161C7E4F6E84D7B81D88BD3E9ED234F"){
		document.getElementById("erp_number").readOnly = true;
		document.getElementById("product_order_number").readOnly = true;
		document.getElementById("amount").readOnly = true;
	}
	$(".form_datetime").datepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		todayHighlight : true,
		showMeridian : true,
		pickerPosition : "bottom-left",
		language : 'zh-CN',// 中文，需要引用zh-CN.js包
	});

});


function selectsupplyer(){
	var upid="suppler";
	layer.open({
		title: '选择供应商',
		type: 2, 
		area: ['800px', '500px'],
		btn: ['关闭'],
		content: "../zttOrderController/selectsuppler?upid="+upid
	 
	}); 
}