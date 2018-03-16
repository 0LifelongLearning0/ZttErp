var numbers=-1;
var t;
$(document).ready(function(){
	var size=document.getElementById("size").value;
	 t = $("#example").DataTable({
                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });
	for(var i=0;i<size;i++){
                t.row.add([
                    i+1,
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].goods_id"  value="'+document.getElementById("zxGoodsApplyDetail["+i+"].goods_id").value+'"/>'+
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].id"  value="'+document.getElementById("zxGoodsApplyDetail["+i+"].id").value+'"/>'+
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].office_name" value="'+document.getElementById("zxGoodsApplyDetail["+i+"].office_name").value+'"/>'+ document.getElementById("zxGoodsApplyDetail["+i+"].office_name").value,
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].stardard" value="'+document.getElementById("zxGoodsApplyDetail["+i+"].standard").value+'"/>'+ document.getElementById("zxGoodsApplyDetail["+i+"].standard").value,
                     '<input type="hidden" name="zxGoodsApplyDetail['+i+'].amount" value="'+document.getElementById("zxGoodsApplyDetail["+i+"].amount").value+'"/>'+ document.getElementById("zxGoodsApplyDetail["+i+"].amount").value,
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].reason" value="'+document.getElementById("zxGoodsApplyDetail["+i+"].reason").value+'"/>'+document.getElementById("zxGoodsApplyDetail["+i+"].reason").value,
                      '<button type="button" class="btn btn-primary" onclick="delrow(this)">删除</button>'
                ]).draw();
                
	}
	$('#addRow').on('click', function() {
			$('#login-form-id').bootstrapValidator({
            fields: {
                amount: {
                    validators: {
                        regexp: {
                        	regexp: /^[+]?\d+(\.\d+)?$/, 
                        	message:'用户名仅支数字'
                        }
                         
                    }
                },
                estimated_price: {
                    validators: {
                       regexp: {
                        	regexp: /^[+]?\d+(\.\d+)?$/, 
                        	message:'用户名仅支数字'
                        }
                    }
                },
                   reason: {
                    validators: {
                        notEmpty: {
                            message: '用途不能为空'
                        }
                    }
                }
            } });
          
            	  $('#login-form-id').data('bootstrapValidator').validate();
            	  if(!$('#login-form-id').data('bootstrapValidator').isValid()){ 
            	  }
            	  else{
            	  	 t.row.add([
                    i+1,
                   '<input type="hidden" name="zxGoodsApplyDetail['+i+'].goods_id"  value="'+document.getElementById("goods_id").value+'"/><input type="hidden" name="zxGoodsApplyDetail['+i+'].detailname" value="+document.getElementById("detailname").value+"/>'+ document.getElementById("detailname").value,
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].stardard" value="'+document.getElementById("stardard").value+'"/>'+ document.getElementById("stardard").value,
                     '<input type="hidden" name="zxGoodsApplyDetail['+i+'].amount" value="'+document.getElementById("amount").value+'"/>'+ +document.getElementById("amount").value,
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].reason" value="'+document.getElementById("reason").value+'"/>'+document.getElementById("reason").value,
                      '<button type="button" class="btn btn-primary" onclick="delrow(this)">删除</button>'
                ]).draw();
                i++;
            	  }
               $('#addModal').modal(options);
            });
	
});

//返回r
function goback(){
	tlocation("../zxGoodsApplyController/loadZxGoodsApply");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxGoodsApply(){
	submitBForm('defaultForm','../zxGoodsApplyController/updateZxGoodsApply','../zxGoodsApplyController/loadZxGoodsApply');
}

function updateZxGoodsApplyDetailItems(){
	validatorDestroy('defaultForm');
	var numbers = $('#zxGoodsApplyDetailFormNumber').val();
	numbers = parseInt(numbers)+1;
	$('#zxGoodsApplyDetailFormNumber').val(numbers);
	//点击添加新一行
	var removeBtn = '<a class="btn btn-danger" href="javascript:delZxGoodsApplyDetailItems(this,'+numbers+')" >删除该条信息</a>';
	var form = '<div id="form_zxGoodsApplyDetail_'+numbers+'">'+
	           '<fieldset>'+
	           '<legend><h5>序号'+numbers+'</h5></legend>'+
	           '<div class="form-group"><div class="col-lg-3">'+removeBtn+'</div></div>'+
			'<div class="form-group" style="display:none;">'+
				'<label class="col-lg-3 control-label">父id</label>'+
				'<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail_'+numbers+'_apply_id" name="zxGoodsApplyDetail['+numbers+'].apply_id"  placeholder="请输入父id">'+
				'</div>'+
			'</div>'+
	           '<div class="form-group" style="display:none;">'+
				'<label class="col-lg-3 control-label">用品id</label>'+
				'<div class="col-lg-6">'+
				     '<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail['+numbers+'].goods_id" name="zxGoodsApplyDetail['+numbers+'].goods_id">'+
				'</div>'+
			   '</div>'+
			    '<div class="form-group">'+
				'<label class="col-lg-3 control-label">用品</label>'+
				'<div class="col-lg-6">'+
				     '<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail['+numbers+'].office_name" name="zxGoodsApplyDetail['+numbers+'].office_name" data-bv-notempty data-bv-notempty-message="请输入用品" onclick="GoodsSelect('+numbers+')">'+
				'</div>'+
			   '</div>'+
	           '<div class="form-group">'+
	             '<label class="col-lg-3 control-label">补充数量</label>'+
	             '<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="20"  name="zxGoodsApplyDetail['+numbers+'].amount"  id="zxGoodsApplyDetail_'+numbers+'_amount"   data-bv-notempty data-bv-notempty-message="请输入数量" min="0" max="99999">'+
				  '</div>'+
				'</div>'+
				  '<div class="form-group">'+
	             '<label class="col-lg-3 control-label">用途</label>'+
	             '<div class="col-lg-6">'+
					'<input class="form-control" type="text" maxlength="20"  name="zxGoodsApplyDetail['+numbers+'].reason"  id="zxGoodsApplyDetail_'+numbers+'_reason"   data-bv-notempty data-bv-notempty-message="请输入用途">'+
				  '</div>'+
				'</div>'+
				    '</fieldset>'+
					'</div>'
	$(".form_zxGoodsApplyDetail").append(form);

	datetimeInit();
	reValidator('defaultForm');
}
function delZxGoodsApplyDetailItems(thiz,numbers){
	validatorDestroy('defaultForm');
	$("#form_zxGoodsApplyDetail_"+numbers).remove();
	var zxGoodsApplyDetail_removed_flag = $('#zxGoodsApplyDetail_removed_flag').val()
	if(null == zxGoodsApplyDetail_removed_flag || '' == zxGoodsApplyDetail_removed_flag){
		$('#zxGoodsApplyDetail_removed_flag').val(','+numbers+',');
	}else{
		$('#zxGoodsApplyDetail_removed_flag').val(zxGoodsApplyDetail_removed_flag+numbers+',')
	}
	reValidator('defaultForm');
}
function delrow(obj){
	t.row( $(obj).parents('tr')).remove().draw();
}