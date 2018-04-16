//返回r
function goback(){
	tlocation("../zttClientController/loadZttClient");
}
//保存
function addZttClient(){
	submitBForm('defaultForm','../zttClientController/addZttClient','../zttClientController/loadZttClient');
}
//初始化日期选择器
$(document).ready(function(){
	/*datetimeInit();
    $("#classify").append("<option value=''>请选择</option><option value='A'>A</option><option value='B'>B</option><option value='C'>C</option><option value='D'>D</option>");
    $("#type").append("<option value=''>请选择</option><option value='1'>供应商</option><option value='2'>加工商</option>");
    InitMyDataCombo("zx_zhiwu","title");
    $("#pay_type").append("<option value=''>请选择</option><option value='1'>全款</option><option value='2'>货到付款</option><option value='3'>预付款</option>");
    $("#is_connect").append("<option value=''>请选择</option><option value='1'>是</option><option value='0'>否</option>");*/
});

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
}