var numbers = -1;
var t;
var counter;
$(document)
		.ready(
				function() {
					$(":radio").click(function() {
						if ($(this).val() == "no") {
							$("#end_data_manual").attr("type", "text");
							$("#not_satisfy_reason").attr("type", "text");
						} else {
							$("#end_data_manual").attr("type", "hidden");
						}
					});
					var ajaxobj = eval("(" + getbyapplyid(id) + ")").data;
					document.getElementById("product_order_number").innerText = ajaxobj.product_order_number;
					document.getElementById("hope_end_data").innerText = ajaxobj.hope_end_data;
					document.getElementById("not_satisfy_reason").innerText = ajaxobj.not_satisfy_reason;

				});

// 返回r
function goback() {
	tlocation("../zxGoodsApplyController/loadZxGoodsApply");
}

/* 根据id得到 */
function getbyapplyid(id) {
	var obj = "";
	var params = {
		id : id
	};
	var url = "../zttPurchaseController/getZttPurchaseById";
	$.ajax({
		url : url,
		async : false,
		type : 'POST',
		data : params,
		success : function(result) {
			obj = result;
		}
	});

	return obj;
}
// 保存
function approveZttOrderApply(taskid, status, obj) {
	var status = $('input:radio:checked').val();
	var flag = 0;
	if (status == "no") {
		var end_data_manual = $('#end_data_manual').val();
		var not_satisfy_reason = $('#not_satisfy_reason').val();
		if (end_data_manual == "") {
			layer.alert("请输入日期");
			flag = 1;
		}
		if (not_satisfy_reason == "") {
			layer.alert("请输入日期不满足原因");
			flag = 1;
		}
	}
	if (flag == 0) {
		var datatables = parent.$('#datatables').DataTable();
		var url = "../zttPurchaseController/approvalOrderpurchaseApply";
		var remark;
		var params;
		if (status == "yes") {
			remark = "buydata";
			params = {
				task_id : taskid,
				task_status : status,
				remark : remark
			};
		}

		if (status == "no") {
			var end_date = document.getElementById("end_data_manual").value;
			remark = "buydata";
			params = {
				task_id : taskid,
				task_status : status,
				remark : remark,
				end_data_manual : end_data_manual,
				not_satisfy_reason:not_satisfy_reason
			};
		}
		$.ajax({
			url : url,
			async : false,
			type : 'POST',
			data : params,
			success : function(result) {
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
				datatables.ajax.reload();
			}
		});
	}

}
// 上传
// 保存
function uploadattachment() {
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '确定', '取消' ],
		content : "../zttOrderController/uploadattachment",

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
function checkdetail(id){
	parent.layer.open({
		title: '采购单详情',
		type: 2, 
		area: ['1500px', '700px'],
		btn: ['关闭'],
	  content: "../zttPurchaseController/toZttPurchaseDetail?id="+id
	})}; 
