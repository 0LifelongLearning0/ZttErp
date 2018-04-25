//返回r
function goback(){
	tlocation("../zttProcessproductParentController/loadZttProcessproductParent");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZttProcessproductParent(){
	submitBForm('defaultForm','../zttProcessproductParentController/updateZttProcessproductParent','../zttProcessproductParentController/loadZttProcessproductParent');
}

function addZttProcessproductItems(){
	validatorDestroy('defaultForm');
	var numbers = $('#zttProcessproductFormNumber').val();
	numbers = parseInt(numbers)+1;
	$('#zttProcessproductFormNumber').val(numbers);
	//点击添加新一行
	var removeBtn = '<a class="btn btn-danger" href="javascript:delZttProcessproductItems(this,'+numbers+')" >删除该条信息</a>';
	var form = 
		'<div id="form_zttProcessproduct_'+numbers+'">'+
			'<fieldset>'+
			'<legend><h5>序号'+numbers+'</h5></legend>'+
			'<div class="form-group"><div class="col-lg-3">'+removeBtn+'</div></div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">序列号</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入序列号"  id="zttProcessproduct_'+numbers+'_id" name="zttProcessproduct['+numbers+'].id"  placeholder="请输入序列号">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">订单号id</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_order_id" name="zttProcessproduct['+numbers+'].order_id"  placeholder="请输入订单号id">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">父id</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_parentId" name="zttProcessproduct['+numbers+'].parentId"  placeholder="请输入父id">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">工序名称</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="4"  id="zttProcessproduct_'+numbers+'_Processname" name="zttProcessproduct['+numbers+'].Processname"  placeholder="请输入工序名称">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">工序内容</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="255"  id="zttProcessproduct_'+numbers+'_Processcontent" name="zttProcessproduct['+numbers+'].Processcontent"  placeholder="请输入工序内容">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">设备</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_equipment" name="zttProcessproduct['+numbers+'].equipment"  placeholder="请输入设备">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">工艺装备</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_tooling" name="zttProcessproduct['+numbers+'].tooling"  placeholder="请输入工艺装备">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">单价</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="20"  id="zttProcessproduct_'+numbers+'_single_price" name="zttProcessproduct['+numbers+'].single_price"  placeholder="请输入单价">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">总价</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="20"  id="zttProcessproduct_'+numbers+'_sum_price" name="zttProcessproduct['+numbers+'].sum_price"  placeholder="请输入总价">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">操作者</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_product_person_id" name="zttProcessproduct['+numbers+'].product_person_id"  placeholder="请输入操作者">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">操作者日期</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_product_date" name="zttProcessproduct['+numbers+'].product_date"  placeholder="请输入操作者日期">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">合格件数</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_qualified_number" name="zttProcessproduct['+numbers+'].qualified_number"  placeholder="请输入合格件数">'+
				'</div>'+
			'</div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">检验员日期</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct_'+numbers+'_qualified_date" name="zttProcessproduct['+numbers+'].qualified_date"  placeholder="请输入检验员日期">'+
				'</div>'+
			'</div>'+
				'</fieldset>'+
		'</div>'
	$(".form_zttProcessproduct").append(form);

	reValidator('defaultForm');
}
function delZttProcessproductItems(thiz,numbers){
	validatorDestroy('defaultForm');
	$("#form_zttProcessproduct_"+numbers).remove();
	var zttProcessproduct_removed_flag = $('#zttProcessproduct_removed_flag').val()
	if(null == zttProcessproduct_removed_flag || '' == zttProcessproduct_removed_flag){
		$('#zttProcessproduct_removed_flag').val(','+numbers+',');
	}else{
		$('#zttProcessproduct_removed_flag').val(zttProcessproduct_removed_flag+numbers+',')
	}
	reValidator('defaultForm');
}
