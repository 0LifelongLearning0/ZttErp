var numbers = -1;
var t;
var counter;
$(document)
		.ready(
				function() {
					var ajaxobj = eval("(" + getbyapplyid(id) + ")").data;
					document.getElementById("client").innerText = ajaxobj.client;
					document.getElementById("zttordertime").innerText = ajaxobj.zttordertime;
					document.getElementById("order_number").innerText = ajaxobj.order_number;
					document.getElementById("product_order_number").innerText = ajaxobj.product_order_number;
					document.getElementById("contract_number").innerText = ajaxobj.contract_number;
					document.getElementById("linkman").innerText = ajaxobj.linkman;
					document.getElementById("product_name").innerText = ajaxobj.product_name;
					document.getElementById("stardard").innerText = ajaxobj.stardard;
					document.getElementById("unit").innerText = ajaxobj.unit;
					document.getElementById("amount").innerText = ajaxobj.amount;
					document.getElementById("sum_price").innerText = ajaxobj.sum_price;
					document.getElementById("single_price").innerText = ajaxobj.single_price;
					document.getElementById("end_data").innerText = ajaxobj.end_data;
					document.getElementById("attachment").value = ajaxobj.attachment;
					document.getElementById("techmanager_attachment").value = ajaxobj.techmanager_attachment;
					document.getElementById("checker_attachment").value = ajaxobj.checker_attachment;
					document.getElementById("state").value = ajaxobj.state;
					document.getElementById("order_id").value = ajaxobj.id;
					if (ajaxobj.state == "8") {
						document.getElementById("caption").innerText = "业务人员下单表--检验不通过,退回"
						document.getElementById("checkreport").style.display = "";
						document.getElementById("checkreport1").style.display = "";
					} else {
						document.getElementById("caption").innerText = "业务人员下单表"
					}
					/*
					 * var counter = 0; t.row.add([ i+1,
					 * document.getElementById("zxGoodsApplyDetail["+i+"].office_name").value,
					 * document.getElementById("zxGoodsApplyDetail["+i+"].standard").value,
					 * document.getElementById("zxGoodsApplyDetail["+i+"].amount").value,
					 * document.getElementById("zxGoodsApplyDetail["+i+"].reason").value
					 * ]).draw();
					 */

				});

// 返回r
function goback() {
	tlocation("../zxGoodsApplyController/loadZxGoodsApply");
}
$('#defaultForm').bootstrapValidator({
	message : '此值不是有效的'
});

/* 根据id得到 */
function getbyapplyid(id) {
	var obj = "";
	var params = {
		id : id
	};
	var url = "../zttOrderController/getZttOrderById";
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

function finisharrament(id) {
	var datatables = parent.$('#datatables').DataTable();
	var obj = "";
	var state='21';
	var params = {
		id : id,
		state:state
	};
	var url = "../zttOrderController/updateZttOrderstate";
	$.ajax({
		url : url,
		async : false,
		type : 'POST',
		data : params,
		success : function(result) {
			var index = parent.layer.getFrameIndex(window.name);
			datatables.ajax.reload();
			parent.layer.close(index);
		}
	});

	return obj;
}

function waitarrival(id) {
	var datatables = parent.$('#datatables').DataTable();
	var obj = "";
	var state='22';
	var params = {
		id : id,
		state:state
	};
	var url = "../zttOrderController/updateZttOrderstate";
	$.ajax({
		url : url,
		async : false,
		type : 'POST',
		data : params,
		success : function(result) {
			var index = parent.layer.getFrameIndex(window.name);
			datatables.ajax.reload();
			parent.layer.close(index);
		}
	});

	return obj;
}
// 保存
function approveZttOrderApply(taskid, status, obj) {
	var datatables = parent.$('#datatables').DataTable();
	var url = "../zttOrderController/approvalOrderApply";
	status = "selfwaitcheck";
	remark = "1";
	var path = document.getElementById("producter_selfcheck_attachment").value;
	var params = {
		task_id : taskid,
		task_status : status,
		remark : remark,
		path : path
	};
	$.ajax({
		url : url,
		async : false,
		type : 'POST',
		data : params,
		success : function(result) {
			var index = parent.layer.getFrameIndex(window.name);
			datatables.ajax.reload();
			parent.layer.close(index);
			

		}
	});

}
function productreload() {
	var datatables = parent.$('#datatables').DataTable();
	datatables.ajax.reload();
}

function uploadself_checkattachment() {
	var upid = "producter_selfcheck_attachment";
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '确定', '取消' ],
		content : "../zttOrderController/uploadattachment?upid=" + upid,

	});
}

function progressupload(id) {
	var index = parent.layer.getFrameIndex(window.name);
	var order_id=document.getElementById("order_id").value;
	parent.layer.open({
		title : '机械加工工艺过程卡片',
		type : 2,
		area : [ '80%', '80%' ],
		btn : [ '关闭' ],
		content : "../zttProcessproductParentController/loadZttProcessproductParent?id=" + id
				+ "&index=" + index+"&order_id=" + order_id,
				success: function (layero, index) {
	            	 //巧妙的地方在这里哦
					parent.layer.getChildFrame('body',index).contents().find("#order_id").val(order_id)
	            	

	            }
	});
}
// 保存
function downloadattachment(id) {
	var upid = "attachment";
	layer.open({
		title : '下载附件',
		type : 2,
		area : [ '500px', '500px' ],
		btn : [ '关闭' ],
		content : "../zttOrderController/Downloadattachment?id=" + id
				+ "&upid=" + upid

	})
};

// 保存
function downloadattachmenttech(id) {
	var upid = "techmanager_attachment";
	layer.open({
		title : '下载附件',
		type : 2,
		area : [ '500px', '500px' ],
		btn : [ '关闭' ],
		content : "../zttOrderController/Downloadattachment?id=" + id
				+ "&upid=" + upid

	})
};

function downloadattachmentcheck(id) {
	var upid = "checker_attachment";
	layer.open({
		title : '下载附件',
		type : 2,
		area : [ '500px', '500px' ],
		btn : [ '关闭' ],
		content : "../zttOrderController/Downloadattachment?id=" + id
				+ "&upid=" + upid

	})
};
// 保存
function selfcheckreport(id) {
	var index = parent.layer.getFrameIndex(window.name);
	var state = "38";
	layer.open({
		title : '下载附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '关闭' ],
		content : "../zttOrderController/toZttprocessingtechnicDetail?id=" + id
				+ "&state=" + state

	})
};