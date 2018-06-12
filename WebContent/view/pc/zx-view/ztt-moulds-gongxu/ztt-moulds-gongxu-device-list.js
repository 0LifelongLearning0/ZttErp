var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zttMouldsDeiviceController/getZttMouldsDeiviceListByCondition',opt);},//渲染数据
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
					return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="' + data + ","
					+ full.device_name+'" /><span></span></label>';
				},
				bSortable:false
			},
			{
				data:'id'
			},
			{
				data:'device_name'
			},
			{
				data:"id",
				width:"150px",
				render:function(data, type, row, meta) {
					return "<a href=\"javascript:toZttMouldsGongxuDetail('"+ data +"')\"><span class='glyphicon glyphicon-eye-open'></span></a>";
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
//新增
function toZttMouldsGongxuAdd(){
	tlocation('../zttMouldsGongxuController/toZttMouldsGongxuAdd');
}

function toZxSupplierAdd(){
	if(returncheckedLength('checkchild') <= 0){
		layer.alert("请选择要选择的数据");
		return;
	}
	if($(".checkchild:checked").length != 1){
		layer.alert("只能选择一条数据");
		return;
	}
	msgTishCallFnBoot("确定要选择此供应商？",function(){
		var device_id=$(".checkchild:checked").val().split(',')[0];
		var device_name=$(".checkchild:checked").val().split(',')[1];
		parent.$('#xt_device').val(device_name);
		parent.$('#xt_device_id').val(device_id);
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	})
}
//修改
function toZttMouldsGongxuUpdate(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zttMouldsGongxuController/toZttMouldsGongxuUpdate?id="+id);
}
//详情
function toZttMouldsGongxuDetail(id){
	tlocation("../zttMouldsGongxuController/toZttMouldsGongxuDetail?id="+id);
}
//删除
function delZttMouldsGongxu(){
	if(returncheckedLength('checkchild') <= 0){
		toastrBoot(4,"请选择要删除的数据");
		return;
	}
	msgTishCallFnBoot("确定要删除所选择的数据？",function(){
		var id = returncheckIds('checkId').join(",");
		var params = {id:id};
		ajaxBReq('../zttMouldsGongxuController/delZttMouldsGongxu',params,['datatables']);
	})
}
