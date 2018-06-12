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
	function progressupload() {
		var id=document.getElementById("id").value;
		layer.open({
			title : '机械加工工艺过程卡片',
			type : 2,
			area : [ '80%', '80%' ],
			btn : [ '关闭' ],
			content : "../zttProcessproductParentController/loadZttProcessproductParent?id=" + id+"&order_id=" + id,
			 success: function (layero, index) {
					layer.getChildFrame('body',index).contents().find("#order_id").val(id);
					layer.getChildFrame('body',index).contents().find("#flag").val("list")
	           	

	           }
		});
	}
	function getlay() {  //利用这个方法向子页面传递layer的index
        return document.getElementById("id").value;
    }