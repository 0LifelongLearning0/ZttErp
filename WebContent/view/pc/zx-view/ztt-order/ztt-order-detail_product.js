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
	
	var url="../zxGoodsApplyController/approvalOrderApply";
	status="selfwaitcheck";
	remark="1";
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
        	   setTimeout("productreload()",1000);
        	   
            }
        });
	
}
function productreload(){
	var datatables = parent.$('#datatables').DataTable();
	datatables.ajax.reload();
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

//上传
//保存
function progressupload(id){
	var state=document.getElementById("state").value;
	layer.open({
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
		
		function downloadattachmentcheck(id){
			var upid="checker_attachment";
			layer.open({
				title: '下载附件',
				type: 2, 
				area: ['500px', '500px'],
				btn: ['关闭'],
			  content: "../zttOrderController/Downloadattachment?id="+id+"&upid="+upid
			 
			})};
			
			//返回r
			function goback(){
				tlocation("../zttOrderController/loadZttOrder");
			}