var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxCarApplyController/getZxCarApplyListByCondition',opt);},//渲染数据
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
				width:"50px"
			},
			{
				data:'state',
				render:function(data, type, row, meta) {
					return InitBDataCallFnByKey("zx_car_apply_status",data);
				}
			},
			{
				data:'apply_type',
				render:function(data, type, row, meta) {
					return InitBDataCallFnByKey("zx_car_apply_type",data);
				}
			},
			{
				data:'apply_time'
			},
			{
				data:'item',
				render:function(data, type, row, meta) {
					if(data != null){
						return data.car_no;
					}else{
						return "";
					}
					
				}
			},
			{
				data:'apply_time_begin'
			},
			{
				data:'apply_time_end'
			},
			{
				data:'apply_car_address'
			},
			{
				data:"id",
				width:"150px",
				render:function(data, type, row, meta) {
					var opt = "<a href=\"javascript:toZxCarApplyDetail('"+ data +"')\"><span class='glyphicon glyphicon-eye-open' title='详情'></span></a>&emsp;";
					if(row.state == '1'){
						opt += "<a href=\"javascript:toApply('"+ data +"','"+ row.state +"')\"><span class='glyphicon glyphicon-transfer text-danger' title='申请审批'></span></a>&emsp;";
					}else{
						opt += "<a href=\"javascript:approval('"+ data +"','"+ row.state +"')\"><span class='glyphicon glyphicon-list-alt text-warning' title='审批记录'></span></a>&emsp;";
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
	InitBDataCombo("zx_car_apply_status","state");
	InitBDataCombo("zx_car_apply_type","apply_type");
});
//新增
function toZxCarApplyAdd(){
	tlocation('../zxCarApplyController/toZxCarApplyAdd');
}
//修改
function toZxCarApplyUpdate(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"请选择一条需修改项");
		return;
	}
	 var nTrs = grid.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
	 for(var i = 0; i < nTrs.length; i++){
	     if($(nTrs[i]).hasClass('row_selected')){
	    	 var rowData = grid.fnGetData(nTrs[i]);
	    	 if(rowData.state != "1"){
	    		 toastrBoot(4,"待申请状态才能修改！");
	    		 return;
	    	 }
	         var id = $(".checkchild:checked").val();
	      	 tlocation("../zxCarApplyController/toZxCarApplyUpdate?id="+id);
	         break;
	     }
	 }
}
//详情
function toZxCarApplyDetail(id){
	tlocation("../zxCarApplyController/toZxCarApplyDetail?id="+id);
}
//删除
function delZxCarApply(){
	if(returncheckedLength('checkchild') <= 0){
		toastrBoot(4,"请选择要删除的数据");
		return;
	}
	var nTrs = grid.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
	 for(var i = 0; i < nTrs.length; i++){
	     if($(nTrs[i]).hasClass('row_selected')){
	    	 var rowData = grid.fnGetData(nTrs[i]);
	    	 if(rowData.state != 1){
	    		 toastrBoot(4,"已申请数据不能删除！");
	    		 return;
	    	 }
	     }
	 }
	msgTishCallFnBoot("确定要删除所选择的数据？",function(){
		var id = returncheckIds('checkId').join(",");
		var params = {id:id};
		ajaxBReq('../zxCarApplyController/delZxCarApply',params,['datatables']);
	})
}

//申请审批
function toApply(id,state){
	 if(state != "1"){
		 toastrBoot(4,"已申请！");
		 return;
	 }
	 msgTishCallFnBoot("确定要申请审批吗？",function(){
		var params = {id:id};
		ajaxBReq('../zxCarApplyController/applyZxCarApply',params,['datatables']);
	})
}
var approval_grid;
//审批记录
function approval(id,state){
	if(state == "1"){
		 return;
	 }
	approval_record(id);
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});
