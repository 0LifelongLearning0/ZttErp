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
           var counter = 0;
                t.row.add([
                    i+1,
                     '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].id" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].id").value+'"/>'+'<input type="hidden" name="zxPurchaseApplyDetail['+i+'].name" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].name").value+'"/>'+ 
                     '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].goods_id" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].goods_id").value+'"/>'+document.getElementById("zxPurchaseApplyDetail["+i+"].name").value,
                     '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].standard" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].standard").value+'"/>'+ document.getElementById("zxPurchaseApplyDetail["+i+"].standard").value,
                      '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].amount" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].amount").value+'"/>'+ document.getElementById("zxPurchaseApplyDetail["+i+"].amount").value,
                       '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].estimated_price" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].estimated_price").value+'"/>'+ document.getElementById("zxPurchaseApplyDetail["+i+"].estimated_price").value,
                        '<input  name="zxPurchaseApplyDetail['+i+'].amount_store" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].amount_store").value+'"/>',
                         '<input type="hidden" name="zxPurchaseApplyDetail['+i+'].reason" value="'+document.getElementById("zxPurchaseApplyDetail["+i+"].reason").value+'"/>'+ document.getElementById("zxPurchaseApplyDetail["+i+"].reason").value
                ]).draw();
                
	}
});
//返回r
function goback(){
	tlocation("../zxPurchaseApplyController/loadZxPurchaseCheckApply");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxPurchaseApply(){
	
	submitBForm('defaultForm','../zxPurchaseApplyController/updateZxPurchaseApplyCheck','../zxPurchaseApplyController/loadZxPurchaseCheckApply');
}

//发起提交表单
function submitBForm(formid,url,callUrl){
	if(null == formid || '' == formid){
		window.parent.toastrBoot(4,"未能获取到formid!");
		return;
	}
	var bootform =  $('#'+formid);
	if(typeof(bootform) == "undefined" ||null == bootform || '' == bootform){
		window.parent.toastrBoot(4,"未能获取到form对象!");
		return;
	}
	//验证
/*	var boostrapValidator =bootform.data('bootstrapValidator');
	boostrapValidator.validate();*/
	//验证有效开启发送异步请求
/*	if(boostrapValidator.isValid()){*/
		msgTishCallFnBoot("确定要提交该表单信息？",function(){
			$.ajax({
	            url:url,
//	            async:false,//同步，会阻塞操作
	            type:'POST',//PUT DELETE POST
	            data:bootform.serialize(),
	            success:function(result){
	            	try {
	            		result = eval("(" + result + ")");  
	            		if(typeof(result.success) != "undefined"){
	            			if(result.success){
			            		window.parent.toastrBoot(3,result.msg);
			        			if(null != callUrl){
			                		//默认返回页面
			                    	tlocation(callUrl);
			                	}
			        		}else{
			        			//失败还在原位置页面
			        			window.parent.toastrBoot(4,result.msg);
			        		}
	            		}
					} catch (e) {
						
					}
	            }, 
	            error:function(){
	            	
	            }
	        })
		})
	/*}else{
		window.parent.toastrBoot(4,"存在不合法的字段!");
	}*/
}

function addZxPurchaseApplyDetailItems(){
	 document.getElementById("detailname").value="";
      document.getElementById("amount").value="";
      document.getElementById("stardard").value="";
      document.getElementById("estimated_price").value="";
     document.getElementById("reason").value="";
	$('#addModal').modal();
	
}
function delZxPurchaseApplyDetailItems(thiz,numbers){
	validatorDestroy('defaultForm');
	$("#form_zxPurchaseApplyDetail_"+numbers).remove();
	var zxPurchaseApplyDetail_removed_flag = $('#zxPurchaseApplyDetail_removed_flag').val()
	if(null == zxPurchaseApplyDetail_removed_flag || '' == zxPurchaseApplyDetail_removed_flag){
		$('#zxPurchaseApplyDetail_removed_flag').val(','+numbers+',');
	}else{
		$('#zxPurchaseApplyDetail_removed_flag').val(zxPurchaseApplyDetail_removed_flag+numbers+',')
	}
	reValidator('defaultForm');
}

function delrow(obj){
	t.row( $(obj).parents('tr')).remove().draw();
}
