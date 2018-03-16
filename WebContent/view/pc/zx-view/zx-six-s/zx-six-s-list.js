var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxSixSController/getZxSixSListByCondition',opt);},//渲染数据
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
				data:'title'
			},
			{
				data:'check_date',
				render:function (data, type, full, meta) {
					var col_text = '∨';
					if(data != ''){
						col_text =  data.substring(0,10);
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			},
			{
				data:'user_realname'
			},
			{
				data:'status',
				render:function (data, type, full, meta) {
					var col_text = '∨';
					if(data == '1'){
						col_text = '保存中';
					}else if(data == '2'){
						col_text = '改善中';
					}else if(data == '3'){
						col_text = '确认中';
					}else if(data == '4'){
						col_text = '已完结';
					}
					col_text += "<input type='hidden' class='hidden-status' value='"+ data +"'>";
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			},
			{
				data:'create_date'
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
function toZxSixSAdd(){
	tlocation('../zxSixSController/toZxSixSAdd');
}
//修改
function toZxSixSUpdate(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	if($(".checkchild:checked").parent().parent().parent().find('.hidden-status').eq(0).val()!='1'){
		toastrBoot(4,"不能修改");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zxSixSController/toZxSixSUpdate?id="+id);
}
//发布
function toZxSixSFabu(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	msgTishCallFnBoot("确定要发布？",function(){
		var id = $(".checkchild:checked").val();
		var params = {id:id,status:2};
		ajaxBReq('../zxSixSController/fabuZxSixS',params,['datatables']);
	})
}
//详情
function toZxSixSDetail(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zxSixSContentController/loadZxSixSContent?six_s_id="+id);
}
//删除
function delZxSixS(){
	if(returncheckedLength('checkchild') <= 0){
		toastrBoot(4,"请选择要删除的数据");
		return;
	}
	if($(".checkchild:checked").parent().parent().parent().find('.hidden-status').eq(0).val()!='1'){
		toastrBoot(4,"只能删除保存中数据");
		return;
	}
	msgTishCallFnBoot("确定要删除所选择的数据？",function(){
		var id = returncheckIds('checkId').join(",");
		var params = {id:id};
		ajaxBReq('../zxSixSController/delZxSixS',params,['datatables']);
	})
}
