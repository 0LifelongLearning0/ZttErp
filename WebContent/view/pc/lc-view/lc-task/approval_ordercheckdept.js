var numbers = -1;
var t;
var counter;
$(document)
		.ready(
				function() {
					var ajaxobj = eval("(" + getbyapplyid(id) + ")").data;
					document.getElementById("product_order_number").innerText = ajaxobj.product_order_number;
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
	var taskkind = document.getElementById("taskkind").value;
	var url;
	if(taskkind=="ztt_sales"){
		url = "../zttOrderController/getZttOrderById";
	}else if(taskkind=="ztt_purchase"){
		url = "../zttPurchaseController/getZttPurchaseById";
	}
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
	var datatables = parent.$('#datatables').DataTable();
	var url = "../zttOrderController/approvalOrderCheckApply";
	remark = "checkdept";
	var path = document.getElementById("checker_attachment").value;
	if (path == "") {
		layer.alert("请上传文件");
	} else {
		var checkcomment = document.getElementById("checkcomment").value;
		var params = {
			task_id : taskid,
			task_status : status,
			remark : remark,
			path : path,
			checkcomment : checkcomment
		};
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

function uploadattachment() {
	var upid = "checker_attachment";
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '确定', '取消' ],
		content : "../zttOrderController/uploadattachment?upid=" + upid,

	});
}

// 上传
// 保存
function progressupload(id) {
	var index = parent.layer.getFrameIndex(window.name);
	var state = "7";
	parent.layer.open({
		title : '机械加工工艺过程卡片',
		type : 2,
		area : [ '1500px', '700px' ],
		btn : [ '关闭' ],
		content : "../zttOrderController/toZttprocessingtechnicDetail?id=" + id
				+ "&state=" + state
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
// 保存
function downloadselfattachmenttech(id) {
	var upid = "selfchecker_attachment";
	layer.open({
		title : '下载附件',
		type : 2,
		area : [ '500px', '500px' ],
		btn : [ '关闭' ],
		content : "../zttOrderController/Downloadattachment?id=" + id
				+ "&upid=" + upid

	})
};

