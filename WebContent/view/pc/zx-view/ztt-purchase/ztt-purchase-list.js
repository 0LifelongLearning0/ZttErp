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
				data:'product_order_number'
			},
			{
				data:'purchase_name'
			},
			{
				data:'purchase_stardard'
			},
			{
				data:'material'
			},
			{
				data:'unit'
			},
			{
				data:'amount'
			},
			{
				data:'hope_end_data'
			},
			{
				data:'state'
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
						opt= "<a href=\"javascript:approval('"
								+ data
								+ "')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
					}
					
					opt+="<a href=\"javascript:showLcProcessInstance('"
					+ data
						+"')\"><span class='glyphicon glyphicon-tag text-warning' title='查看流程图'></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					if (row.state == '4'){
						opt+="<a href=\"javascript:ZttPurchasedeptcheck('"
							+ data
								+"')\"><span class='glyphicon glyphicon-transfer text-danger' title='进入质检部审批'></span>";
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
	var n = new Notification("sir, you got a message", {  
		icon: 'img/icon.png',
	    body: 'you will have a meeting 5 minutes later.'  
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