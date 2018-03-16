var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxApplyPhoneCardController/getZxApplyPhoneCardListByConditionHR',null);},//渲染数据
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
					return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="' + data + '" /><span></span></label>';
				},
				bSortable:false
			},
			{
				data:"id",
				width:"150px"
			},
			{
				data:'xt_user_name'
			},
			{
				data:'apply_time'
			},
			{
				data:'description'
			},
			{
				data:'status',
				render:function(data, type, row, meta) {
					return InitBDataCallFnByKey("zx_apply_phone_card_status",data);
				}
			},
			{
				data:"id",
				width:"150px",
				render:function(data, type, row, meta) {
					var opt = "<a href=\"javascript:toGrantZxApplyPhoneCard('"+ data +"')\"><span class='glyphicon glyphicon-transfer text-danger' title='发放电话卡'></span></a>&emsp;"+
							  "<a href=\"javascript:approval('"+ data +"')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
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
	InitBDataCombo("zx_apply_phone_card_status","status");
});
//审批记录
function approval(id){
	approval_record(id);
}
//发放
function toGrantZxApplyPhoneCard(id){
	tlocation("../zxApplyPhoneCardController/toGrantZxApplyPhoneCard?id="+id);
}