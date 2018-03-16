var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxSixSContentController/getZxSixSContentListByCondition?six_s_id=' + $('#six_s_id').val(),opt);},//渲染数据
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
				data:'place_name'
			},
			{
				data:'dep_name'
			},
			{
				data:'user_realname'
			},
			{
				data:'problem'
			},
			{
				data:'problem_pic_name'
			},
			{
				data:'end_date',
				render:function (data, type, full, meta) {
					var col_text = '∨';
					if(data != ''&&data.length > 9){
						col_text = data.substring(0,10);
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			},
			{
				data:'measure'
			},
			{
				data:'result_pic_name'
			},
			{
				data:'status',
				render:function (data, type, full, meta) {
					var col_text = '∨';
					if(data == 1){
						col_text = '改善中';
					}else if(data == 2){
						col_text = '确认中';
					}else if(data == 3){
						col_text = '已确认';
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			}
		]
	});
	grid=$('#datatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkall','checkchild');
	//实现单击行选中
	clickrowselected('datatables');
});
//详情
function toZxSixSContentDetail(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zxSixSContentController/toZxSixSContentDetail?from=1&id="+id);
}
//改善
function toZxSixSContentGaishan(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	if($(".checkchild:checked").parent().parent().parent().find('.hidden-status').eq(0).val()!='1'){
		toastrBoot(4,"非改善中，不能操作");
		return;
	}
	var id = $(".checkchild:checked").val();
	$.post('../zxSixSController/getZxSixSById',{id:$('#six_s_id').val()}, function(data){
		var json = eval('('+ data +')');
		if(json.success&&json.data.status=='2'){
			tlocation("../zxSixSContentController/toCorrectZxSixSContent?from=1&id="+id);
		}else{
			toastrBoot(4,'操作失败！');
			return;
		}
	});
}
//返回r
function goback(){
	tlocation("../zxSixSController/loadZxSixSView");
}