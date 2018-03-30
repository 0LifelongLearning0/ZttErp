var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	var ajaxobj=eval("("+getbyapplyid(id)+")").data;
	document.getElementById("client").innerText=ajaxobj.client;  
	document.getElementById("zttordertime").innerText=ajaxobj.zttordertime;
	document.getElementById("order_number").innerText=ajaxobj.order_number;
	document.getElementById("product_order_number").innerText=ajaxobj.product_order_number;
	document.getElementById("contract_number").innerText=ajaxobj.contract_number; 
	document.getElementById("linkman").innerText=ajaxobj.linkman;
	document.getElementById("product_name").innerText=ajaxobj.product_name;
	document.getElementById("stardard").innerText=ajaxobj.stardard;
	document.getElementById("unit").innerText=ajaxobj.unit;
	document.getElementById("amount").innerText=ajaxobj.amount;
	document.getElementById("sum_price").innerText=ajaxobj.sum_price;
	document.getElementById("single_price").innerText=ajaxobj.single_price;
	document.getElementById("end_data").innerText=ajaxobj.end_data;
         /*  var counter = 0;
                t.row.add([
                    i+1,
                    document.getElementById("zxGoodsApplyDetail["+i+"].office_name").value,
                     document.getElementById("zxGoodsApplyDetail["+i+"].standard").value,
                     document.getElementById("zxGoodsApplyDetail["+i+"].amount").value,
                    document.getElementById("zxGoodsApplyDetail["+i+"].reason").value
                ]).draw();*/
                
	
});


//返回r
function goback(){
	tlocation("../zxGoodsApplyController/loadZxGoodsApply");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});

/*根据id得到*/
function getbyapplyid(id){
	var obj="";
	var params = {id:id};
	var url="../zttOrderController/getZttOrderById";
	$.ajax({ 
		   url: url, 
		   async:false, 
           type:'POST',
           data: params,
           success: function (result) { 
                obj= result;
            }
            });
            
       return obj;
}
//保存
function approveZttOrderApply(taskid,status,obj){
	var datatables = parent.$('#datatables').DataTable();
	var erp_number=document.getElementById("erp_number").value;
	var flag=0;
	if(erp_number==""){
		layer.alert('erp号不能为空');
		flag=1;
	}
	if(flag==0){
		var url="../zxGoodsApplyController/approvalOrderApply";
		var remark=erp_number;
		var params = {task_id:taskid,task_status:status,remark:remark};
		var approvalFormWin = parent.Ext.getCmp('approvalFormWin');  
		ajaxBReq('../zttOrderController/approvalOrderApply',params);
		$.ajax({ 
			   url: url, 
			   async:false, 
	           type:'POST',
	           data: params,
	           success: function (result) { 
	        	   var index = parent.layer.getFrameIndex(window.name);
	        	   parent.layer.close(index);
	        	   datatables.ajax.reload();
	            }
	        });
	}
	
}
