var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxCarController/getZxCarListBootByCondition',opt);},//渲染数据
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
				data:'state',
				render:function(data, type, row, meta) {
					return InitBDataCallFnByKey("zx_car_status",data);
				}
			},
			{
				data:'car_no'
			},
			{
				data:'people_num'
			},
			{
				data:'model'
			},
			{
				data:'brand'
			},
			{
				data:'summary'
			},
			{
				data:'buy_time',
				render:function(data, type, row, meta) {
					var ds = data.split(" ");
					return ds[0];
				}
			},
			{
				data:"id",
				width:"150px",
				render:function(data, type, row, meta) {
					return "<a href=\"javascript:toZxCarDetail('"+ data +"')\"><span class='glyphicon glyphicon-eye-open'></span></a>";
				}
			}
		]
	});
	grid=$('#datatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkall','checkchild');
	//实现单击行选中
	clickrowselected('datatables');
	InitBDataCombo("zx_car_status","state");
});
//新增
function toZxCarAdd(){
	tlocation('../zxCarController/toZxCarAdd');
}
//修改
function toZxCarUpdate(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zxCarController/toZxCarUpdate?id="+id);
}
//详情
function toZxCarDetail(id){
	tlocation("../zxCarController/toZxCarDetail?id="+id);
}
//删除
function delZxCar(){
	if(returncheckedLength('checkchild') <= 0){
		toastrBoot(4,"请选择要删除的数据");
		return;
	}
	msgTishCallFnBoot("确定要删除所选择的数据？",function(){
		var id = returncheckIds('checkId').join(",");
		var params = {id:id};
		ajaxBReq('../zxCarController/delZxCar',params,['datatables']);
	})
}
