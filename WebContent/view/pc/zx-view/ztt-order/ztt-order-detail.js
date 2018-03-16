//返回r
function goback(){
	tlocation("../zttOrderController/loadZttOrder");
}

//保存
function downloadattachment(id){
	layer.open({
		title: '下载附件',
		type: 2, 
		area: ['500px', '500px'],
		btn: ['确定', '取消'],
	  content: "../zttOrderController/Downloadattachment?id="+id
	 
	})}; 