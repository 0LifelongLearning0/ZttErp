var grid;
$(document)
		.ready(
				function() {
					// ///////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用）
					// 如弹窗分页查找根据条件
					// 可能此时的form发生变化 此时 可以解决该类问题
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
											'../zttOrderController/getZttOrdercheckhistory',
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
											render : function(data, type, full,
													meta) {
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
											data : 'product_check_time'
										},
										{
											data : 'product_check_comment'
											
										},
										{
											data : 'product_check_attachment',
											render : function(data, type, row,
													meta) {
												return covertpath(
														data);
											}
											
										},
										{
											data : 'product_check_attachment',
											render : function(data, type, row,
													meta) {
												return "<a href=\"javascript:downloadFile('"+ $.parseJSON(data).path +"')\"><span class='glyphicon glyphicon-arrow-down' title='下载'></span></a>&emsp;";
											}
											
										}
										]
							});
					grid = $('#datatables').dataTable(options);
					// 实现全选反选
					docheckboxall('checkall', 'checkchild');
					// 实现单击行选中
					clickrowselected('datatables');
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
function toZttOrderDetail(id,state) {
	tlocation("../zttOrderController/toZttOrderDetail?id=" + id+"&state="+state);
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
	if(status!=0){
		toastrBoot(4,"只有待申请状态的数据可以删除");
		return;
	}
	msgTishCallFnBoot("确定要删除所选择的数据？",
			function() {
				var id = returncheckIds('checkId').join(",");
				var params = {
					id : id
				};
				ajaxBReq('../zttOrderController/delZttOrder', params,
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
		btn : [ '关闭'],
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
function covertpath(data){
	var str=$.parseJSON(data).path.split("-----")[1];
	return str;
	
}
function downloadFile(fileName){
    if(fileName){
        var form=$("<form>");//定义一个form表单
        form.attr("style","display:none");
        form.attr("target","");
        form.attr("method","post");
        form.attr("action",'../zttOrderController/downloadfile');
        var fileInput=$("<input>");
        fileInput.attr("type","hidden");
        fileInput.attr("id","fileName");//设置属性的名字
        fileInput.attr("name","fileName");//设置属性的名字
        fileInput.attr("value",fileName);//设置属性的值
        $("body").append(form);//将表单放置在web中
        form.append(fileInput);
        form.submit();//表单提交   
        //form.remove();
    }
}