//返回r
function goback(){
	tlocation("../zttPurchaseController/loadZttPurchase");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZttPurchase(){
	var flag = 0;
	var Product_order_number = $('#Product_order_number').val();
	var single_price = $('#single_price').val();
	if ($('#Product_order_number').val() == "") {
		layer.alert('工令号不能为空');
		flag = 1;
	}
	if ($('#purchase_name').val() == "") {
		layer.alert('名称不能为空');
		flag = 1;
	}
	if ($('#amount').val() == "") {
		layer.alert('数量不能为空');
		flag = 1;
	}
	if ($('#hope_end_data').val() == "") {
		layer.alert('交期不能为空');
		flag = 1;
	}
	if (flag == 0) {
	submitBForm('defaultForm','../zttPurchaseController/addZttPurchase','../zttPurchaseController/loadZttPurchase');
	}
	
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
	var boostrapValidator =bootform.data('bootstrapValidator');
	boostrapValidator.validate();
	//验证有效开启发送异步请求
	if(boostrapValidator.isValid()){
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
	}else{
		window.parent.toastrBoot(4,"存在不合法的字段!");
	}
}

$(function() {
	$(".form_datetime").datepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		todayHighlight : true,
		showMeridian : true,
		pickerPosition : "bottom-left",
		language : 'zh-CN',// 中文，需要引用zh-CN.js包
	});
});