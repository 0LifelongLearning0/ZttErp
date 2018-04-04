//返回r
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
		 var index= document.getElementById("ztt_processproduct["+i+"].processname").value;
	       var select;
	       if(index==1){
	   		select="下料";
	   	}else if(index==2){
	   		select="普车加工";
	   	}else if(index==3){
	   		select="数车加工";
	   	}else if(index==4){
	   		select="加工中心";
	   	}else if(index==5){
	   		select="火花机";
	   	}else if(index==6){
	   		select="钳工";
	   	}else if(index==6){
	   		select="线切割";
	   	}else if(index==6){
	   		select="外协加工";
	   	}
           var counter = 0;
                t.row.add([
                    i+1,
                    '<input type="hidden" name="ztt_processproduct['+i+'].id"  value="'+document.getElementById("ztt_processproduct["+i+"].id").value+'"/>'+select,
                     document.getElementById("ztt_processproduct["+i+"].processcontent").value,
                     document.getElementById("ztt_processproduct["+i+"].equipment").value,
                    document.getElementById("ztt_processproduct["+i+"].tooling").value,
                    document.getElementById("ztt_processproduct["+i+"].single_price").value,
                    document.getElementById("ztt_processproduct["+i+"].sum_price").value,
                    '<input type="text" name="ztt_processproduct['+i+'].qualified_number" value="'+document.getElementById("ztt_processproduct["+i+"].qualified_number").value+'"/>'
                ]).draw();
                
	}
	
});

//保存
function addZxGoodsApply(){
	submitBForm('defaultForm','../zttOrderController/processingtechnicUpdate','../zttOrderController/copyZttOrder');
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
			            		var index = parent.layer.getFrameIndex(window.name);
			            		parent.layer.close(index);
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
