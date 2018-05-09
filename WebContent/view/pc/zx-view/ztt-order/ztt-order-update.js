//返回r
function goback() {
	tlocation("../zttOrderController/loadZttOrder");
}
// 保存
function updateZttOrder() {
	submitBForm('defaultForm', '../zttOrderController/updateZttOrder',
			'../zttOrderController/loadZttOrder');
	 
}
// 发起提交表单
function submitBForm(formid, url, callUrl) {
	var bill=document.getElementById("bill_date_open").value;

	if (null == formid || '' == formid) {
		window.parent.toastrBoot(4, "未能获取到formid!");
		return;
	}
	var bootform = $('#' + formid);
	if (typeof (bootform) == "undefined" || null == bootform || '' == bootform) {
		window.parent.toastrBoot(4, "未能获取到form对象!");
		return;
	}
	msgTishCallFnBoot("确定要提交该表单信息？", function() {
		$.ajax({
			url : url,
			// async:false,//同步，会阻塞操作
			type : 'POST',// PUT DELETE POST
			data : bootform.serialize(),
			success : function(result) {
				try {
					result = eval("(" + result + ")");
					if (typeof (result.success) != "undefined") {
						if (result.success) {
							window.parent.toastrBoot(3, result.msg);
							if (null != callUrl) {
								// 默认返回页面
								var index = parent.layer.getFrameIndex(window.name);  
							    parent.layer.close(index); 
							}
						} else {
							// 失败还在原位置页面
							window.parent.toastrBoot(4, result.msg);
						}
					}
				} catch (e) {

				}
			},
			error : function() {

			}
		})
	})
}
$(function() {
	var apply_id=document.getElementById("apply_id").value;
	if(apply_id=="3BEDDDB5F4A94C78AEFA53051FAD5468"||apply_id=="6424E51904264B94910A72D62454F5C4"||apply_id=="B89D3CEE77F4485ABFA14ACCEA1E9188"){
		document.getElementById("linkman").readOnly = false;
		document.getElementById("cost_single_price").readOnly = true;
		document.getElementById("amount").readOnly = false; 
		document.getElementById("erp_number").readOnly = true;
		document.getElementById("supplier_bill_date").readOnly = true;
		document.getElementById("supplier_bill_price").readOnly = true;
		document.getElementById("bill_date_open").readOnly = true;
		document.getElementById("bill_price").readOnly = true;
		document.getElementById("cost_share").readOnly = true;
	}
	if(apply_id=="9A5DF246FB4E4B3E824792E575263969"){
		document.getElementById("stardard").readOnly = true;
	}
	if(apply_id=="B161C7E4F6E84D7B81D88BD3E9ED234F"){
		document.getElementById("erp_number").readOnly = true;
		document.getElementById("sales").style.display="none";
		document.getElementById("send_amount").readOnly = true;
		document.getElementById("contract_number").readOnly = true;
		document.getElementById("stardard").readOnly = true;
		document.getElementById("single_price").readOnly = true;
	}
	if(apply_id=="B75750C01CAB4D0A88BD95A964D3BA2C"){
		document.getElementById("amount").readOnly = false;
		document.getElementById("product_name").readOnly = false;
		document.getElementById("linkman").readOnly = false;
		document.getElementById("end_data").disabled = false;
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
//保存
function downloadattachment(id){
	var upid="attachment";
	layer.open({
		title: '下载附件',
		type: 2, 
		area: ['500px', '500px'],
		btn: ['确定', '取消'],
	  content: "../zttOrderController/Downloadattachment?id="+id+"&upid="+upid
	 
	})}; 
	function selectsupplyer(){
		var upid="suppler";
		layer.open({
			title: '选择供应商',
			type: 2, 
			area: ['800px', '500px'],
			content: "../zttOrderController/selectsuppler?upid="+upid
		 
		}); 
	}
	function updateZttOrderbatch() {
		submitBForm('defaultForm', '../zttOrderController/updateZttOrderbatch',
				'../zttOrderController/loadZttOrder');
	}
	
	function selectclient(){
		var upid="client";
		layer.open({
			title: '选择客户',
			type: 2, 
			area: ['800px', '500px'],
			content: "../zttOrderController/selectsuppler?upid="+upid
		 
		}); 
	}