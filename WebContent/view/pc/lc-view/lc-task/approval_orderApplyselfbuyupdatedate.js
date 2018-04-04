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
	var remark="updatedate"
	var params;
	var end_date=document.getElementById("buy_end_data").value;
	if(end_date==""){
		layer.alert("请输入日期");
	}else{
		params = {task_id:taskid,task_status:status,remark:remark,end_date:end_date};
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
	layer.open({
		title: '上传附件',
		type: 2, 
		area: ['800px', '500px'],
		btn: ['确定', '取消'],
	  content: "../zttOrderController/uploadattachment",
	 
	}); 
	/*var inputObj=document.createElement('input')
    inputObj.setAttribute('id','_ef');
    inputObj.setAttribute('type','file');
    inputObj.setAttribute("style",'visibility:hidden');
    document.body.appendChild(inputObj);
    inputObj.click();
    inputObj.value */
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
