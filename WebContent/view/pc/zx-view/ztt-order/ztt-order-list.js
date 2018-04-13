
var flag=0;
$(document)
		.ready(
				function() {
					// ///////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用）
					// 如弹窗分页查找根据条件
					// 可能此时的form发生变化 此时 可以解决该类问题
					show();
				});
// 新增
function toZttOrderAdd() {
	tlocation('../zttOrderController/toZttOrderAdd');
}
// 修改
function toZttOrderUpdate() {
	if ($(".checkchild:checked").length != 1) {
		toastrBoot(4, "选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zttOrderController/toZttOrderUpdate?id=" + id);
}
// 详情
function toZttOrderDetail(id, state) {
	tlocation("../zttOrderController/toZttOrderDetail?id=" + id + "&state="
			+ state);
}
// 删除
function delZttOrder() {
	if (returncheckedLength('checkchild') <= 0) {
		toastrBoot(4, "请选择要删除的数据");
		return;
	}
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	/*
	 * if (status != 0) { toastrBoot(4, "只有待申请状态的数据可以删除"); return; }
	 */
	msgTishCallFnBoot("确定要删除所选择的数据？",
			function() {
				var id = returncheckIds('checkId').join(",");
				var params = {
					id : id
				};
				ajaxBReq('../zttOrderController/delZttOrderf', params,
						[ 'datatables' ]);
			})
}
// 申请
function toApply(id) {
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	if (status != 0) {
		toastrBoot(4, "只有待申请状态的数据可以申请");
		return;
	}
	msgTishCallFnBoot("确定要申请审批吗？", function() {
		var params = {
			apply_id : id
		};
		ajaxBReq('../zttOrderController/toApply', params, [ 'datatables' ]);
	})
}
function approval(id, state) {
	if (state == "1") {
		return;
	}
	approval_record(id);
}
// 保存
function downloadattachment(id) {
	layer.open({
		title : '下载附件',
		type : 2,
		area : [ '500px', '500px' ],
		btn : [ '关闭' ],
		content : "../zttOrderController/Downloadattachment?id=" + id

	})
};

function approval_record(id) {
	$('#approvalModal').modal();
	// ///////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件
	// 可能此时的form发生变化 此时 可以解决该类问题
	var options = DataTablesPaging.pagingOptions({
		ajax : function(data, callback, settings) {
			datatablesCallBack(data, callback, settings,
					'../lcApprovalController/getLcApprovalListByCondition?model_biz_id='
							+ id, null);
		},// 渲染数据
		// 在第一位置追加序列号
		fnRowCallback : function(nRow, aData, iDisplayIndex) {
			jQuery('td:eq(0)', nRow).html(iDisplayIndex + 1);
			return nRow;
		},
		order : [],// 取消默认排序查询,否则复选框一列会出现小箭头
		// 列表表头字段
		colums : [ {
			sClass : "text-center",
			width : "50px",
			data : "lc_approval_id",
			render : function(data, type, full, meta) {
				return '';
			},
			bSortable : false
		}, {
			data : 'lc_status_id',
			render : function(data, type, row, meta) {
				if (data == "yes") {
					return "主管审批通过";
				} else if (data == "no") {
					return "审批不通过";
				} else if (data == "madebyself") {
					return "自制单,进入工艺流程";
				} else if (data == "outside") {
					return "外协单,进入采购流程";
				} else if (data == "outsidecheck") {
					return "外协单,进入采购检验流程";
				} else if (data == "selftech") {
					return "自制单,进入生产调度流程";
				}

			}
		}, {
			data : 'lc_approval_remark'
		}, {
			data : 'lc_approval_time',
			render : function(data, type, row, meta) {
				return dateformat(data);
			}
		}, {
			data : 'xt_userinfo_realName'
		} ]
	});
	approval_grid = $('#datatables_approval').dataTable(options);
}
function showLcProcessInstance(id) {
	$
			.ajax({

				type : 'POST',
				url : "../zttOrderController/getZttOrderInstanceById",
				data : {
					id : id
				},
				success : function(data) {
					var id = data;
					layer
							.open({
								title : '查看流程图',
								type : 2,
								area : [ '1500px', '600px' ],
								btn : [ '关闭' ],
								content : "../lcProcessController/loadLcProcessInstanceImg?processInstanceId="
										+ id

							})
				}
			});

}

// 申请
function toApplycheck(id) {
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	msgTishCallFnBoot("确定要申请审批吗？",
			function() {
				var params = {
					apply_id : id
				};
				ajaxBReq('../zttOrderController/toApplycheck', params,
						[ 'datatables' ]);
			})
}
// 申请
function toApplysendcage(id) {
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	msgTishCallFnBoot("确定要申请审批吗？", function() {
		var params = {
			apply_id : id
		};
		ajaxBReq('../zttOrderController/toApplysendcage', params,
				[ 'datatables' ]);
	})
}
function approvalcheckhistory(id) {
	var state = "7";
	layer.open({
		title : '检验记录',
		type : 2,
		area : [ '800px', '700px' ],
		btn : [ '关闭' ],
		content : "../zttPurchaseController/toZttpurchasecheck_history?id="
				+ id + "&state=" + state
	});
}
function approvalfilehistory(id) {
	var state = "8";
	layer.open({
		title : '文件记录',
		type : 2,
		area : [ '800px', '700px' ],
		btn : [ '关闭' ],
		content : "../zttPurchaseController/toZttpurchasecheck_history?id="
				+ id + "&state=" + state
	});
}
function show(){
	
		if (flag == 0) {
			var grid;
			var opt = {
					searchformId : 'searchForm'
				};
			var options = DataTablesPaging
					.pagingOptions({
						ajax : function(data, callback, settings) {
							datatablesCallBack(
									data,
									callback,
									settings,
									'../zttOrderController/getZttOrderListByCondition',
									opt);
						},// 渲染数据
						// 在第一位置追加序列号
						fnRowCallback : function(nRow, aData,
								iDisplayIndex) {
							jQuery('td:eq(1)', nRow).html(
									iDisplayIndex + 1);
							return nRow;
						},
						order : [],// 取消默认排序查询,否则复选框一列会出现小箭头
						// 列表表头字段
						colums : [
								{
									sClass : "text-center",
									width : "50px",
									data : "id",
									render : function(data, type,
											full, meta) {
										return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="'
												+ data
												+ ","
												+ full.state
												+ '" /><span></span></label>';
									},
									bSortable : false
								},

								{
									data : 'id'
								},
								{
									data : 'zttordertime'
								},
								{
									data : 'product_order_number',
									render : function(data, type,
											row, meta) {
										if (row.product_order_number == '') {
											return "无工令号";
										} else {
											return row.product_order_number;
										}

									}

								},
								{
									data : 'client'
								},

								{
									data : 'product_name'
								},
								{
									data : 'amount'
								},

								{
									data : 'personname'
								},
								{
									data : 'erp_number'
								},
								{
									data : 'order_number'
								},
								{
									data : 'contract_number'
								},
								{
									data : 'cato_type',
									render : function(data, type,
											row, meta) {
										if (data == "outside") {
											return "外协"
										} else if (data == "madebyself") {
											return "自制"
										} else if (data == "warehouse") {
											return "仓库"
										} else if (data == "PD") {
											return "生产部"
										} else if (data == "others") {
											return "其他"
										} else {
											return data;
										}
									}
								},
								{
									data : 'supplier_name'
								},
								{
									data : 'cost_single_price'
								},
								{
									data : 'cost_sum_price'
								},
								{
									data : 'supplier_bill_date'
								},
								{
									data : 'supplier_bill_price'
								},
								{
									data : 'unit'
								},
								{
									data : 'single_price'
								},
								{
									data : 'sum_price'
								},
								{
									data : 'end_data'
								},
								{
									data : 'send_time'
								},
								{
									data : 'send_amount'
								},
								{
									data : 'bill_date_open'
								},
								{
									data : 'bill_price'
								},
								{
									data : 'cost_share'
								},
								{
									data : 'state',
									render : function(data, type,
											row, meta) {
										return InitBDataCallFnByKey(
												"ZttOrder", data);
									}
								},
								{
									data : "id",
									width : "150px",
									render : function(data, type,
											row, meta) {

										var opt = "<a href=\"javascript:toZttOrderDetail('"
												+ data
												+ "','"
												+ row.state
												+ "')\"><span class='glyphicon glyphicon-eye-open' title='详情'></span></a>&emsp;";
										return opt;
									}
								},
								{
									data : "id",
									width : "150px",
									render : function(data, type,
											row, meta) {

										var opt;
										if (row.state == '0') {
											opt = "<a href=\"javascript:toApply('"
													+ data
													+ "')\"><span class='glyphicon glyphicon-transfer text-danger' title='申请审批'></span></a>&emsp;";
										} else {
											opt = "<a href=\"javascript:approvalfilehistory('"
													+ data
													+ "')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
										}
										return opt;
									}
								},
								{
									data : "id",
									width : "150px",
									render : function(data, type,
											row, meta) {

										var opt;
										if (row.state == '19'
												|| row.state == '53') {
											opt = "<a href=\"javascript:toApplycheck('"
													+ data
													+ "')\"><span class='glyphicon glyphicon-transfer text-danger' title='申请审批'></span></a>&emsp;";
										} else {
											opt = "<a href=\"javascript:approvalcheckhistory('"
													+ data
													+ "')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
										}

										return opt;
									}
								},
								{
									data : "id",
									width : "150px",
									render : function(data, type,
											row, meta) {

										var opt;
										if (row.state == '54') {
											opt = "<a href=\"javascript:toApplysendcage('"
													+ data
													+ "')\"><span class='glyphicon glyphicon-transfer text-danger' title='申请审批'></span></a>&emsp;";
										} else {
											opt = "<a href=\"javascript:approvalfilehistory('"
													+ data
													+ "')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
										}

										return opt;
									}
								} ]
					});
			grid = $('#datatables').dataTable(options);
			// 实现全选反选
			docheckboxall('checkall', 'checkchild');
			// 实现单击行选中
			clickrowselected('datatables');
			InitBDataCombo("ZttOrder", "state");
			InitBDataCombo("cato_type", "cato_type");
		}else{
			
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
}
function export1() {
	/*
	 * $("#datatables").table2excel({ // 不被导出的表格行的CSS class类 exclude: ".noExl", //
	 * 导出的Excel文档的名称，（没看到作用） name: "Excel Document Name", // Excel文件的名称
	 * filename: "业务人员下单表" });
	 */
	var upid="order";
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '1500px', '700px' ],
		btn : [ '关闭'],
		content : "../zttOrderController/uploadattachment?upid"+upid

	});
}
