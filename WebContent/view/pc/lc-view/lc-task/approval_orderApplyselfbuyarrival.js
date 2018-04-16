var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	$(".form_datetime").datepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		todayHighlight : true,
		showMeridian : true,
		pickerPosition : "bottom-left",
		language : 'zh-CN',// 中文，需要引用zh-CN.js包
	});
	$(":radio").click(function(){
		  if($(this).val()=="no"){
			  $("#end_data_manual").attr("type" , "text");
		  }else{
			  $("#end_data_manual").attr("type" , "hidden");
		  }
		  });
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
	document.getElementById("attachment").innerText=ajaxobj.attachment;
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
	var url="../zttOrderController/approvalOrderApply";
	var remark="purchase_arrival"
	var params;
	var contract_attachment=document.getElementById("contract_attachment").value;
	
	var supplier_name=$('#supplyer_name').val();
	
	var flag=0;
	if(supplier_name==""){
		layer.alert("请选择供应商");
		flag=1;
	}
	if(contract_attachment==""){
		layer.alert("请上传合同文件");
		flag=1;
	}
	if(flag==0){
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
function selectsupplyer(){
	var upid="suppler";
	layer.open({
		title: '选择供应商',
		type: 2, 
		area: ['800px', '500px'],
		btn: ['关闭'],
		content: "../zttOrderController/selectsuppler?upid="+upid
	 
	}); 
}