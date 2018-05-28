var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	var ajaxobj=eval("("+getbyapplyid(id)+")").data;
	document.getElementById("zttordertime").innerText=ajaxobj.apply_time;
	document.getElementById("Product_order_number").innerText=ajaxobj.product_order_number;
	document.getElementById("purchase_stardard").innerText=ajaxobj.purchase_stardard;
	document.getElementById("purchase_name").innerText=ajaxobj.purchase_name;
	document.getElementById("erpnumber").value=ajaxobj.erp_number;
	document.getElementById("material").innerText=ajaxobj.material;
	document.getElementById("unit").innerText=ajaxobj.unit;
	document.getElementById("amount").innerText=ajaxobj.amount;
	document.getElementById("project").innerText=ajaxobj.project;
	document.getElementById("material_add").innerText=ajaxobj.product_order_number+" "+ajaxobj.project+" "+ajaxobj.purchase_stardard;
                
	
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
	var isnewerp="1";
	var params = {id:id,isnewerp:isnewerp};
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
	var value="erpnumber";
	var erpnumber=document.getElementById("erpnumber").value;
	var params = {task_id:taskid,task_status:status,remark:value,path:erpnumber};
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
function checkdetail(id){
	parent.layer.open({
		title: '采购单详情',
		type: 2, 
		area: ['1500px', '700px'],
		btn: ['关闭'],
	  content: "../zttPurchaseController/toZttPurchaseUpdate?id="+id
	})}; 