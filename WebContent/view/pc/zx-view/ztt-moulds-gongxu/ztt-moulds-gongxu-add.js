//返回r
function goback(){
	tlocation("../zttMouldsGongxuController/loadZttMouldsGongxu");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZttMouldsGongxu(){
	submitBForm('defaultForm','../zttMouldsGongxuController/addZttMouldsGongxu','../zttMouldsGongxuController/loadZttMouldsGongxu');
}

function addZttMouldsDeiviceItems(){
	validatorDestroy('defaultForm');
	var numbers = $('#zttMouldsDeiviceFormNumber').val();
	numbers = parseInt(numbers)+1;
	$('#zttMouldsDeiviceFormNumber').val(numbers);
	//点击添加新一行
	var removeBtn = '<a class="btn btn-danger" href="javascript:delZttMouldsDeiviceItems(this,'+numbers+')" >删除该条信息</a>';
	var form = 
		'<div id="form_zttMouldsDeivice_'+numbers+'">'+
			'<fieldset>'+
			'<legend><h5>序号'+numbers+'</h5></legend>'+
			'<div class="form-group"><div class="col-lg-3">'+removeBtn+'</div></div>'+
			'<div class="form-group">'+
				'<label class="col-lg-3 control-label">设备名称</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="255"  id="zttMouldsDeivice_'+numbers+'_device_name" name="zttMouldsDeivice['+numbers+'].device_name"  placeholder="请输入设备名称">'+
				'</div>'+
			'</div>'+
				'</fieldset>'+
		'</div>'
	$(".form_zttMouldsDeivice").append(form);

	reValidator('defaultForm');
}
function delZttMouldsDeiviceItems(thiz,numbers){
	validatorDestroy('defaultForm');
	$("#form_zttMouldsDeivice_"+numbers).remove();
	var zttMouldsDeivice_removed_flag = $('#zttMouldsDeivice_removed_flag').val()
	if(null == zttMouldsDeivice_removed_flag || '' == zttMouldsDeivice_removed_flag){
		$('#zttMouldsDeivice_removed_flag').val(','+numbers+',');
	}else{
		$('#zttMouldsDeivice_removed_flag').val(zttMouldsDeivice_removed_flag+numbers+',')
	}
	reValidator('defaultForm');
}
