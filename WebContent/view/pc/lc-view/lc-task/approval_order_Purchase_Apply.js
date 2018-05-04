var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	var ajaxobj=eval("("+getbyapplyid(id)+")").data;
	document.getElementById("zttordertime").innerText=ajaxobj.apply_time;
	document.getElementById("Product_order_number").innerText=ajaxobj.product_order_number;
	document.getElementById("purchase_stardard").innerText=ajaxobj.purchase_stardard;
	document.getElementById("purchase_name").innerText=ajaxobj.purchase_name;
	document.getElementById("amount").innerText=ajaxobj.amount;
	document.getElementById("hope_end_data").innerText=ajaxobj.hope_end_data;
	
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
	var url="../zttPurchaseController/getZttPurchaseById";
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
	var url="../zttPurchaseController/approvalOrderpurchaseApply";
	var datatables = parent.$('#datatables').DataTable();
	var value="manager";
	var params = {task_id:taskid,task_status:status,remark:value};
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
	
function checkdetail(id){
	parent.layer.open({
		title: '采购单详情',
		type: 2, 
		area: ['1500px', '700px'],
		btn: ['关闭'],
	  content: "../zttPurchaseController/toZttPurchaseDetail?id="+id
	})}; 
