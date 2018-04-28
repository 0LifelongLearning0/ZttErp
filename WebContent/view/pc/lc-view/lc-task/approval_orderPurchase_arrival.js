var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	$(":radio").click(function(){
		  if($(this).val()=="no"){
			  $("#end_data_manual").attr("type" , "text");
		  }else{
			  $("#end_data_manual").attr("type" , "hidden");
		  }
		  });
	var ajaxobj=eval("("+getbyapplyid(id)+")").data;
	document.getElementById("product_order_number").innerText=ajaxobj.product_order_number;  
	document.getElementById("purchase_name").innerText=ajaxobj.purchase_name;
	document.getElementById("purchase_stardard").innerText=ajaxobj.purchase_stardard;
	document.getElementById("material").innerText=ajaxobj.material;
	document.getElementById("unit").innerText=ajaxobj.unit; 
	document.getElementById("purchase_name").innerText=ajaxobj.purchase_name;
	document.getElementById("unit").innerText=ajaxobj.unit;
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
	
	var datatables = parent.$('#datatables').DataTable();
	var url="../zttPurchaseController/approvalOrderpurchaseApply";
	var remark;
	var params;
	var contract_attachment=document.getElementById("contract_attachment").value;
	var supplier_name=$('#supplyer_name').val();
	var flag=0;
	if(supplier_name==""){
		layer.alert("请选择供应商");
		flag=1;
	}
	if(flag==0){
		remark="begin_purchase";
		params = {task_id:taskid,task_status:status,remark:remark,contract_attachment:contract_attachment,supplier_name:supplier_name};
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
//上传
//保存
function uploadattachment(){
	var upid="contract_attachment";
	layer.open({
		title: '上传附件',
		type: 2, 
		area: ['800px', '500px'],
		btn: ['确定', '取消'],
		content: "../zttOrderController/uploadattachment?upid="+upid,
	 
	}); 
}

$(function() {
	$(".form_datetime").datepicker({
		 format:"yyyy-mm-dd",
		 autoclose:true,
		 todayBtn:true,
		 todayHighlight:true,
		 showMeridian:true,
		 pickerPosition:"bottom-left",
		 language:'zh-CN',//中文，需要引用zh-CN.js包
	});
	
});
