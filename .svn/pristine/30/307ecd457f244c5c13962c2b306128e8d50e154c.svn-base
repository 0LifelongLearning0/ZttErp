var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxCarApplyController/getZxCarApplyCheckListByCondition',opt);},//渲染数据
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
				data:'apply_type',
				render:function(data, type, row, meta) {
					return InitBDataCallFnByKey("zx_car_apply_type",data);
				}
			},
			{
				data:'apply_car_address'
			},
			{
				data:'apply_time'
			},
			{
				data:'usecar_outtime'
			},
			{
				data:'out_mileage'
			},
			{
				data:'usercar_backtime'
			},
			{
				data:'back_mileage'
			},
			{
				data:"id",
				width:"150px",
				render:function(data, type, row, meta) {
					var opt = "<a href=\"javascript:toZxCarApplyDetail('"+ data +"')\"><span class='glyphicon glyphicon-eye-open' title='详情'></span></a>&emsp;";
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
	InitBDataCombo("zx_car_apply_type","apply_type");
});
//详情
function toZxCarApplyDetail(id){
	tlocation("../zxCarApplyController/toZxCarApplyDetail?fromUrl=toCheck&id="+id);
}
//出门登记
function toCarOut(id){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	 var nTrs = grid.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
	 for(var i = 0; i < nTrs.length; i++){
	     if($(nTrs[i]).hasClass('row_selected')){
	    	 var rowData = grid.fnGetData(nTrs[i]);
	    	 if(rowData.state != "3"){
	    		 toastrBoot(4,"审核通过的才能出门！");
	    		 return;
	    	 }
	         var id = $(".checkchild:checked").val();
	      	 tlocation("../zxCarApplyController/toCheckOut?id="+id);
	         break;
	     }
	 }
}
//出门登记
function toCarBack(id){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	 var nTrs = grid.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
	 for(var i = 0; i < nTrs.length; i++){
	     if($(nTrs[i]).hasClass('row_selected')){
	    	 var rowData = grid.fnGetData(nTrs[i]);
	    	 if(rowData.state != "5"){
	    		 toastrBoot(4,"已出门的车辆才能登记回司信息！");
	    		 return;
	    	 }
	         var id = $(".checkchild:checked").val();
	      	 tlocation("../zxCarApplyController/toCheckBack?id="+id);
	         break;
	     }
	 }
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});
