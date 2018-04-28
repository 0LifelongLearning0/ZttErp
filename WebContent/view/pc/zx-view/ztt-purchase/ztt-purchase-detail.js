//返回r
function goback(){
	tlocation("../zttPurchaseController/loadZttPurchase");
}

function downloadattachment(id){
	var upid="attachment";
	layer.open({
		title: '下载附件',
		type: 2, 
		area: ['500px', '500px'],
		btn: ['确定', '取消'],
	  content: "../zttOrderController/Downloadattachment?id="+id+"&upid="+upid
	 
	})}; 