var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxApplyPhoneCardController/getZxApplyPhoneCardListByCondition',null);},//渲染数据
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
					return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="' + data + ","+full.status+'" /><span></span></label>';
				},
				bSortable:false
			},
			{
				data:"id",
				width:"150px"
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
					var opt = "<a href=\"javascript:toZxApplyPhoneCardDetail('"+ data +"')\"><span class='glyphicon glyphicon-eye-open' title='详情'></span></a>&emsp;"+
							  "<a href=\"javascript:toApply('"+ data +"','"+ row.status +"')\"><span class='glyphicon glyphicon-transfer text-danger' title='申请审批'></span></a>&emsp;"+
							  "<a href=\"javascript:approval('"+ data +"','"+row.status+"')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
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
//新增
function toZxApplyPhoneCardAdd(){
	tlocation('../zxApplyPhoneCardController/toZxApplyPhoneCardAdd');
}
////修改
function toZxApplyPhoneCardUpdate(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择一条需要修改的数据");
		return;
	}
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	if(status!=1){
		toastrBoot(4,"只有待申请状态的数据可以修改");
		return;
	}
	tlocation("../zxApplyPhoneCardController/toZxApplyPhoneCardUpdate?id="+id);
}
//详情
function toZxApplyPhoneCardDetail(id){
	tlocation("../zxApplyPhoneCardController/toZxApplyPhoneCardDetail?id="+id);
}
//删除
function delZxApplyPhoneCard(){
	if(returncheckedLength('checkchild') <= 0){
		toastrBoot(4,"请选择要删除的数据");
		return;
	}
	var str = $(".checkchild:checked").val();
	var strs = str.split(",");
	var id = strs[0];
	var status = strs[1];
	if(status!=1){
		toastrBoot(4,"只有待申请状态的数据可以删除");
		return;
	}
	msgTishCallFnBoot("确定要删除所选择的数据？",function(){
		var id = returncheckIds('checkId').join(",");
		var params = {id:id};
		ajaxBReq('../zxApplyPhoneCardController/delZxApplyPhoneCard',params,['datatables']);
	})
}
//申请审批
function toApply(id,status){
	if(status!=1){
		toastrBoot(4,"只有待申请状态可以申请审批");
		return;
	}
	msgTishCallFnBoot("确定要申请审批吗？",function(){
		var params = {id:id};
		ajaxBReq('../zxApplyPhoneCardController/applyZxApplyPhoneCard',params,['datatables']);
	})
}
//审批记录
function approval(id,status){
	if(status!=1){
		approval_record(id);
	}else{
		toastrBoot(4,"待申请状态无审批记录");
	}
}