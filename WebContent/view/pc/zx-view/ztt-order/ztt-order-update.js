//返回r
function goback() {
	tlocation("../zttOrderController/loadZttOrder");
}
// 保存
function updateZttOrder() {
	var attachmentbefore=document.getElementById("attachmentbefore").value;
	var attachmentupload=document.getElementById("attachment").value;
	var attachment=document.getElementById("attachmentafter").value;
	if(attachmentbefore==""){
		attachment=attachmentupload;
	}
	else if(attachmentupload==""){
		attachment=attachmentbefore;
	}
	else{
		attachment=attachmentbefore+","+attachmentupload;
	}
	var cato_type_before=document.getElementById("cato_type_before").value;
	
	document.getElementById("cato_type").value=$("#selector").val();
	document.getElementById("attachment").value=attachment;
	var cato_type=document.getElementById("cato_type").value;
	if(cato_type_before=="madebyself"&&cato_type=='outside'){
		layer.alert("请确认已填写自制改外协时间和原因,原自制单生产状态");
		document.getElementById("change_state").value='1';
		document.getElementById("state").value='0';
	}
	if(cato_type_before=="outside"&&cato_type=='madebyself'){
		layer.alert("请确认已填写外协改自制时间和原因,原外协单状态,并电话通知相应采购员");
		document.getElementById("change_state").value='2';
		document.getElementById("state").value='0';
	}
	
	submitBForm('defaultForm', '../zttOrderController/updateZttOrder',
			'../zttOrderController/loadZttOrder');
	 
}
// 发起提交表单
function submitBForm(formid, url, callUrl) {

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
	var apply_id=document.getElementById("login_id").value;
	 if(document.getElementById( "cato_type").value=='outside'){
		 $("#selector").val("outside");
	 }
	 if(document.getElementById( "cato_type").value=='madebyself'){
		 $("#selector").val("madebyself");
	 }
	 if(document.getElementById( "cato_type").value==''){
		 $("#selector").val("");
	 }
	if(apply_id=="3BEDDDB5F4A94C78AEFA53051FAD5468"||apply_id=="6424E51904264B94910A72D62454F5C4"||apply_id=="B89D3CEE77F4485ABFA14ACCEA1E9188"){
	
		document.getElementById("attachmenttd1").style.display="";
		document.getElementById("attachmenttd2").style.display="";
		document.getElementById("linkman").readOnly = false;
		document.getElementById("amount").readOnly = false; 
		document.getElementById("erp_number").readOnly = true;
		document.getElementById("supplier_bill_date").readOnly = true;
		document.getElementById("supplier_bill_price").readOnly = true;
		document.getElementById("bill_date_open").readOnly = false;
		document.getElementById("bill_price").readOnly = false;
		document.getElementById("cost_share").readOnly = true;
		$("#end_data").datepicker({minDate:-1,maxDate:-2}).attr('readonly','readonly');  
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
		document.getElementById("attachmenttd1").style.display="";
		document.getElementById("attachmenttd2").style.display="";
		document.getElementById("amount").readOnly = false;
		 document.getElementById( "cato_typetd").style.display= "";
		 document.getElementById( "cato_typetd1").style.display= "";
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
function uploadattachment() {
	var upid="attachment";
	
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '确定', '取消' ],
		content : "../zttOrderController/uploadattachment?upid="+upid
		
	});
	
	
}
function updtachment() {
	var upid="update";
	layer.open({
		title : '修改附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '确定', '取消' ],
		content : "../zttOrderController/uploadattachment?upid="+upid
		
	});
	
	
}
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