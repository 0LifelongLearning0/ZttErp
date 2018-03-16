var numbers=-1;
var t;
var counter;
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
                   '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].goods_id"  value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].goods_id").value+'"/>'+
                   '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].id" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].id").value+'"/>'+
                    '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].name" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].name").value+'"/>'+ document.getElementById("zxPurchaseApplyDetail["+i+"].name").value,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].standard" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].standard").value+'"/>'+ document.getElementById("zxPurchaseApplyDetail["+i+"].standard").value,
                     '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].amount" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].amount").value+'"/>'+ +document.getElementById("zxPurchaseApplyDetail["+i+"].amount").value,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].estimated_price" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].estimated_price").value+'"/>'+ +document.getElementById("zxPurchaseApplyDetail["+i+"].estimated_price").value,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].reason" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].reason").value+'"/>'+document.getElementById("zxPurchaseApplyDetail["+i+"].reason").value,
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
                   '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].goods_id"  value="'+document.getElementById("goods_id").value+'"/><input type="hidden" name="zxPurchaseApplyDetail['+i+'].name" value="+document.getElementById("name").value+"/>'+ document.getElementById("name").value,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].stardard" value="'+document.getElementById("stardard").value+'"/>'+ document.getElementById("stardard").value,
                     '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].amount" value="'+document.getElementById("amount").value+'"/>'+ +document.getElementById("amount").value,
                     '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].reason" value="'+document.getElementById("estimated_price").value+'"/>'+document.getElementById("estimated_price").value,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].reason" value="'+document.getElementById("reason").value+'"/>'+document.getElementById("reason").value,
                      '<button type="button" class="btn btn-primary" onclick="delrow(this)">删除</button>'
                ]).draw();
                i++;
            	  }
               $('#addModal').modal(options);
            });
});

//返回r
function goback(){
	tlocation("../zxPurchaseApplyController/loadZxPurchaseApply");
}
//保存
function updateZxPurchaseApply(){
	submitBForm('defaultForm','../ZxPurchaseApplyController/updateZxPurchaseApply','../ZxPurchaseApplyController/loadZxPurchaseApply');
}

function delrow(obj){
	t.row( $(obj).parents('tr')).remove().draw();
}