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
	document.getElementById("attachment").value=ajaxobj.attachment;
	document.getElementById("techmanager_attachment").value=ajaxobj.techmanager_attachment;
	document.getElementById("checker_attachment").value=ajaxobj.checker_attachment;
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
	remark="checkself";
	var path=document.getElementById("checker_attachment").value;
	var params = {task_id:taskid,task_status:status,remark:remark,path:path};
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
//上传

function uploadattachment(){
	var upid="checker_attachment";
	layer.open({
		title: '上传附件',
		type: 2, 
		area: ['800px', '500px'],
		btn: ['确定', '取消'],
	  content: "../zttOrderController/uploadattachment?upid="+upid,
	 
	}); 
}

//上传
//保存
function progressupload(id){
	var index = parent.layer.getFrameIndex(window.name); 
	var state="7";
	parent.layer.open({
		title: '机械加工工艺过程卡片',
		type: 2, 
		area: ['1500px', '700px'],
		btn: ['关闭'],
	  content: "../zttOrderController/toZttprocessingtechnicDetail?id="+id+"&state="+state
	}); 
}
//保存
function downloadattachment(id){
	var upid="attachment";
	layer.open({
		title: '下载附件',
		type: 2, 
		area: ['500px', '500px'],
		btn: ['关闭'],
	  content: "../zttOrderController/Downloadattachment?id="+id+"&upid="+upid
	 
	})}; 
	//保存
	function downloadattachmenttech(id){
		var upid="techmanager_attachment";
		layer.open({
			title: '下载附件',
			type: 2, 
			area: ['500px', '500px'],
			btn: ['关闭'],
		  content: "../zttOrderController/Downloadattachment?id="+id+"&upid="+upid
		 
		})}; 