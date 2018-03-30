$(document).ready(function(){
	
	if(document.getElementById("erp_number").value==""){
		document.getElementById("erp1").style.display="none";
		document.getElementById("erp2").style.display="none";
	}
	
});

//返回r
function goback(){
	tlocation("../zttOrderController/loadZttOrder");
}

//保存
function downloadattachment(id){
	var upid="attachment";
	layer.open({
		title: '下载附件',
		type: 2, 
		area: ['500px', '500px'],
		btn: ['确定', '取消'],
	  content: "../zttOrderController/Downloadattachment?id="+id+"&upid="+upid
	 
	})}; 