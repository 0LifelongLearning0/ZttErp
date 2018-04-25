//返回r
function goback() {
	tlocation("../zttOrderController/loadZttOrder");
}
$('#defaultForm').bootstrapValidator({
	message : '此值不是有效的'
});
// 保存
function addZttOrder() {
	var flag = 0;
	var amount = $('#amount').val();
	var single_price = $('#single_price').val();
	if (!/^(?:[1-9]\d*|0)(?:\.\d+)?$/.test(amount)) {
		layer.alert('输入数量不合法')
		flag = 1;
	}
	if ($('#client').val() == "") {
		layer.alert('客户不能为空');
		flag = 1;
	}
	if ($('#product_name').val() == "") {
		layer.alert('产品名称不能为空');
		flag = 1;
	}
	if ($('#unit').val() == "") {
		layer.alert('单位不能为空');
		flag = 1;
	}
	if (single_price == "") {
		$('#single_price').val(0);
	}
	/*
	 * if(!/^(?:[1-9]\d*|0)(?:\.\d+)?$/.test(single_price)){
	 * layer.alert('输入的单价不合法') flag=1; }
	 */
	if (flag == 0) {
		submitBForm('defaultForm', '../zttOrderController/addZttOrder',
				'../zttOrderController/loadZttOrder');
	}

}
// 保存
function uploadattachment() {
	var upid="attachment";
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '确定', '取消' ],
		content : "../zttOrderController/uploadattachment?upid="+upid

	});
	/*
	 * var inputObj=document.createElement('input')
	 * inputObj.setAttribute('id','_ef'); inputObj.setAttribute('type','file');
	 * inputObj.setAttribute("style",'visibility:hidden');
	 * document.body.appendChild(inputObj); inputObj.click(); inputObj.value
	 */
}

$(function() {
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
	var upid="client";
	layer.open({
		title: '选择客户',
		type: 2, 
		area: ['800px', '500px'],
		content: "../zttOrderController/selectsuppler?upid="+upid
	 
	}); 
}

function edit_contract_number(){
	document.getElementById("product_order_number").readOnly = false;
	document.getElementById("product_order_number").placeholder = "输入的工令号不得超过当前最大工令号";
}