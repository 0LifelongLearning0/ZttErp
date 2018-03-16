//返回r
function goback(){
	tlocation("../bStockController/loadBStock");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateBStock(){
	submitBForm('defaultForm','../bStockController/updateBStock','../bStockController/loadBStock');
}


//商户商品 品牌 品类选择器
function initBSellerProductList(){
	$('#bSellerProductSelectModal').modal();
	$('#searchBSellerProductForm')[0].reset();
	var opt = {
			searchformId:'searchBSellerProductForm'
		};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../bSellerProductController/getBSellerProductStockListByCondition',opt);},//渲染数据
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
					data:"b_seller_product_id",
					render:function (data, type, full, meta) {
						return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchildBSellerProduct" value="' + data + '" /><span></span></label>';
					},
					bSortable:false
				},
				{
					data:"b_seller_product_id",
					width:"50px"
				},
				{
					data:'b_seller_name'
				},
				{
					data:'b_product_name'
				},
				{
					data:'b_category_name'
				},
				{
					data:'b_brand_name'
				},
				{
					data:'b_seller_product_status',
	                render:function(data, type, row, meta) {
	                	if(data == 0){
	                        return '已关联';
	                    }else if(data == 1){
	                        return "已取消";
	                    }else{
	                    	return "缺省";
	                    }
	                }
				}
			]
	});
	grid=$('#bSellerProductDatatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkallBSellerProduct','checkchildBSellerProduct');
	//实现单击行选中
	clickrowselected('bSellerProductDatatables');
}

function doBSellerProductSelect(){
	if(returncheckedLength('checkchildBSellerProduct') != 1){
		toastrBoot(4,"请选择一条记录");
		return;
	}
	msgTishCallFnBoot("确定选择的该商户商品？",function(){
		var id = returncheckIds('checkId').join(",");
		var table = $('#bSellerProductDatatables').dataTable();
		var List = getTableContent(table);
		for(var i = 0; i < List.length; i++){
			var obj = List[i];
			if(obj.b_seller_product_id == id){
				$('#b_seller_product_id').val(obj.b_seller_product_id);
				$('#b_seller_name').val(obj.b_seller_name);
				$('#b_product_name').val(obj.b_product_name);
				$('#b_brand_name').val(obj.b_brand_name);
				$('#b_category_name').val(obj.b_category_name);
				$('#bSellerProductSelectModal').modal('hide');
				return;
			}
		}
	})
}