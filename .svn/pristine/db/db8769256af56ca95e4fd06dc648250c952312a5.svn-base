var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxMeetingHouseController/getZxMeetingHouseListByCondition',opt);},//渲染数据
			//在第一位置追加序列号
			fnRowCallback:function(nRow, aData, iDisplayIndex){
				jQuery('td:eq(1)', nRow).html(iDisplayIndex +1);  
				return nRow;
		},
		order:[],//取消默认排序查询,否则复选框一列会出现小箭头
		//列表表头字段
		colums:[
			{
				sClass:"col_text-center",
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
				data:'house_name'
			},
			{
				data:'max_num'
			},
			{
				data:'status',
				render:function (data, type, full, meta) {
					var col_text = '∨';
					if(data != ''){
						var json = eval('('+$('#dic_list').val()+')');
						var list = json.items;
						for(var i = 0;i < list.length;i++){
							if(list[i].xt_data_dictionary_id == data){
								col_text = list[i].xt_data_dictionary_name;
								break;
							}
						}
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			},
			{
				data:'remark'
			}
		]
	});
	grid=$('#datatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkall','checkchild');
	//实现单击行选中
	clickrowselected('datatables');
});
//新增
function toZxMeetingHouseAdd(){
	tlocation('../zxMeetingHouseController/toZxMeetingHouseAdd');
}
//修改
function toZxMeetingHouseUpdate(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zxMeetingHouseController/toZxMeetingHouseUpdate?id="+id);
}
//详情
function toZxMeetingHouseDetail(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zxMeetingHouseController/toZxMeetingHouseDetail?id="+id);
}
//删除
function delZxMeetingHouse(){
	if(returncheckedLength('checkchild') <= 0){
		toastrBoot(4,"请选择要删除的数据");
		return;
	}
	msgTishCallFnBoot("确定要删除所选择的数据？",function(){
		var id = returncheckIds('checkId').join(",");
		var params = {id:id};
		ajaxBReq('../zxMeetingHouseController/delZxMeetingHouse',params,['datatables']);
	})
}
