var numbers=-1;
var t;
var counter;
$(document).ready(function(){
           t = $("#example").DataTable({
                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });
            var counter = 0;
            $('#addRow').on('click', function() {
                t.row.add([
                    counter+1,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+counter+'].goods_id"  value="'+document.getElementById("goods_id").value+'"/><input type="hidden" name="zxPurchaseApplyDetail['+counter+'].detailname" value="+document.getElementById("detailname").value+"/>'+ document.getElementById("detailname").value,
                     '<input type="hidden" name="zxPurchaseApplyDetail['+counter+'].stardard" value="'+document.getElementById("stardard").value+'"/>'+ document.getElementById("stardard").value,
                     '<input type="hidden" name="zxPurchaseApplyDetail['+counter+'].amount" value="'+document.getElementById("amount").value+'"/>'+ +document.getElementById("amount").value,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+counter+'].estimated_price" value="'+document.getElementById("amount").value+'"/>'+ +document.getElementById("estimated_price").value,
                    '<input type="hidden" name="zxPurchaseApplyDetail['+counter+'].reason" value="'+document.getElementById("reason").value+'"/>'+document.getElementById("reason").value,
                      '<button type="button" class="btn btn-primary" onclick="delrow(this)">删除</button>'
                ]).draw();
                counter++;
            });
            $('#addModal').modal(options);
});
//返回r
function goback(){
	tlocation("../zxPurchaseApplyController/loadZxPurchaseApply");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxPurchaseApply(){
	submitBForm('defaultForm','../zxPurchaseApplyController/addZxPurchaseApply','../zxPurchaseApplyController/loadZxPurchaseApply');
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
	var content=/*'<form id="login-form-id" class="form-inline">'+
			  '<p>'+
				'<label class="col-lg-3 control-label">用品</label>'+
			'	  <input class="form-control" type="text" maxlength="32"  id="detailname" name="detailname" onclick="GoodsSelect()">'+
			'  </p> '+
			'  <p>'+
             '   <button type="button" class="btn btn-primary" data-dismiss="modal" id="addRow">添加</button>'+
			'  </p>'+
			 ' </form>';*/
	'loadZxPurchaseApplyAdd';
	layer.open({
		area: ['800px', '800px'],
     type: 2, 
   content: content
    });
	 document.getElementById("detailname").value="";
      document.getElementById("amount").value="";
      document.getElementById("stardard").value="";
      document.getElementById("estimated_price").value="";
     document.getElementById("reason").value="";
	/*$('#addModal').modal();*/
	
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
