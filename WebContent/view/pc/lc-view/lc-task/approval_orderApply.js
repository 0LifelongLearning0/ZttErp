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
	document.getElementById("product_name").innerText=ajaxobj.product_name;
	document.getElementById("stardard").innerText=ajaxobj.stardard;
	document.getElementById("unit").innerText=ajaxobj.unit;
	document.getElementById("amount").innerText=ajaxobj.amount;
	document.getElementById("sum_price").innerText=ajaxobj.sum_price;
	document.getElementById("single_price").innerText=ajaxobj.single_price;
	document.getElementById("end_data").innerText=ajaxobj.end_data;
	document.getElementById("attachment").value=ajaxobj.attachment;
	
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
	var url="../zttOrderController/approvalOrderApply";
	var datatables = parent.$('#datatables').DataTable();
	var flag=0;
	var approvalFormWin = parent.Ext.getCmp('approvalFormWin'); 
	var selectindex=document.getElementById("select").selectedIndex;
	if(status=="yes"){
		if(selectindex==0){
			layer.alert('请选择产品类型');
			flag=1;
		}
	}
	
	var selectvalue=document.getElementById("select").options[selectindex].value;
	var params = {task_id:taskid,task_status:status,remark:selectvalue};
	if(flag==0){
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
//下载
function downloadattachment(id){
	var upid="attachment";
	layer.open({
		title: '下载附件',
		type: 2, 
		area: ['500px', '500px'],
		btn: ['关闭'],
	  content: "../zttOrderController/Downloadattachment?id="+id+"&upid="+upid
	 
	})}; 