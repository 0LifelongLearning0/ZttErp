var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zttPurchaseController/getZttPurchaseListByCondition',opt);},//渲染数据
			//在第一位置追加序列号
			fnRowCallback:function(nRow, aData, iDisplayIndex){
				jQuery('td:eq(1)', nRow).html(iDisplayIndex +1);  
				return nRow;
		},
		order:[],//取消默认排序查询,否则复选框一列会出现小箭头
		//列表表头字段
		colums:[
			{
				sClass:"text-center",
				width:"50px",
				data:"id",
				render:function (data, type, full, meta) {
					return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="'
					+ data
					+ ","
					+ full.state
					+ '" /><span></span></label>';
				},
				bSortable:false
			},
			{
				data : 'id'
			},
			{
				data:'apply_time'
			},
			{
				data:'erp_number'
			},
			{
				data:'product_order_number'
			},
			{
				data:'personname'
			},
			{
				data:'purchase_name'
			},
			{
				data:'purchase_stardard'
			},
			{
				data:'unit'
			},
			{
				data:'amount'
			},
			{
				data:'supply_name'
			},
			{
				data:'cost_single_price'
			},
			{
				data:'cost_sum_price'
			},
			{
				data:'supplier_bill_date'
			},
			{
				data:'supplier_bill_price'
			},
			{
				data:'hope_end_data'
			},
			{
				data:'end_data'
			},
			{
				data:'state',
				render : function(data, type, row,
						meta) {
					return InitBDataCallFnByKey(
							"ztt_purchase", data);
				}
			},
			{
				data:"id",
				width:"150px",
				render:function(data, type, row, meta) {
					return "<a href=\"javascript:toZttPurchaseDetail('"+ data +"')\"><span class='glyphicon glyphicon-eye-open'></span></a>";
				}
			},
			{
				data : "id",
				width : "150px",
				render : function(data, type, row,
						meta) {
					
					var opt;
					if (row.state == '0') {
						opt= "<a href=\"javascript:toApply('"
								+ data
								+ "')\"><span class='glyphicon glyphicon-transfer text-danger' title='申请审批'></span></a>&emsp;";
					} else {
						opt= "<a href=\"javascript:approvalfilehistory('"
								+ data
								+ "')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
					}
					return opt;
				}
			},
			{
				data : "id",
				width : "150px",
				render : function(data, type, row,
						meta) {
					
					var opt;
					if (row.state == '53'||row.state == '5') {
						opt= "<a href=\"javascript:toApplycheck('"
								+ data
								+ "')\"><span class='glyphicon glyphicon-transfer text-danger' title='申请审批'></span></a>&emsp;";
					} else {
						opt= "<a href=\"javascript:approvalcheckhistory('"
								+ data
								+ "')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
					}
					
					return opt;
				}
			}
		]
	});
	grid=$('#datatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkall','checkchild');
	//实现单击行选中
	clickrowselected('datatables');
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
//新增
function toZttPurchaseAdd(){
	tlocation('../zttPurchaseController/toZttPurchaseAdd');
}
//修改
function toZttPurchaseUpdate(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zttPurchaseController/toZttPurchaseUpdate?id="+id);
}
//详情
function toZttPurchaseDetail(id){
	tlocation("../zttPurchaseController/toZttPurchaseDetail?id="+id);
}
function ZttPurchasedeptcheck(id){
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	msgTishCallFnBoot("确定要申请审批吗？", function() {
		var params = {
			apply_id : id
		};
		ajaxBReq('../zttPurchaseController/toApplycheck', params, [ 'datatables' ]);
	})
}
//删除
function delZttPurchase(){
	if(returncheckedLength('checkchild') <= 0){
		toastrBoot(4,"请选择要删除的数据");
		return;
	}
	msgTishCallFnBoot("确定要删除所选择的数据？",function(){
		var id = returncheckIds('checkId').join(",");
		var params = {id:id};
		ajaxBReq('../zttPurchaseController/delZttPurchase',params,['datatables']);
	})
}
//申请
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
		ajaxBReq('../zttPurchaseController/toApply', params, [ 'datatables' ]);
	})
}

//申请
function toApplycheck(id) {
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	msgTishCallFnBoot("确定要申请审批吗？", function() {
		var params = {
			apply_id : id
		};
		ajaxBReq('../zttPurchaseController/toApplycheck', params, [ 'datatables' ]);
	})
}

function approvalcheckhistory(id){
	var state="7";
	layer.open({
		title: '检验记录',
		type: 2, 
		area: ['800px', '700px'],
		btn: ['关闭'],
	  content: "../zttPurchaseController/toZttpurchasecheck_history?id="+id+"&state="+state
	}); 
}

function approvalfilehistory(id){
	var state="8";
	layer.open({
		title: '文件记录',
		type: 2, 
		area: ['800px', '700px'],
		btn: ['关闭'],
	  content: "../zttPurchaseController/toZttpurchasecheck_history?id="+id+"&state="+state
	}); 
}
function export1(){
	/* $("#datatables").table2excel({
        // 不被导出的表格行的CSS class类
        exclude: ".noExl",
        // 导出的Excel文档的名称，（没看到作用）
        name: "Excel Document Name",
        // Excel文件的名称
        filename: "采购表"
    });*/
	var upid="purchase";
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '1500px', '700px' ],
		btn : [ '关闭'],
		content : "../zttOrderController/uploadattachment?upid="+upid,

	});
}