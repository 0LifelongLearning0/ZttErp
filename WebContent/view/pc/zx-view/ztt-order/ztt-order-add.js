//返回r
function goback(){
	tlocation("../zttOrderController/loadZttOrder");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZttOrder(){
	var flag=0;
	var amount=$('#amount').val();
	var single_price=$('#single_price').val();
	if(!/^(?:[1-9]\d*|0)(?:\.\d+)?$/.test(amount)){
		layer.alert('输入数量不合法')
		flag=1;
	}
	if(!/^(?:[1-9]\d*|0)(?:\.\d+)?$/.test(single_price)){
		layer.alert('输入的单价不合法')
		flag=1;
	}
	if(flag==0){
		submitBForm('defaultForm','../zttOrderController/addZttOrder','../zttOrderController/loadZttOrder');
	}
	
}
//保存
function uploadattachment(){
	layer.open({
		title: '上传附件',
		type: 2, 
		area: ['500px', '500px'],
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
	$(".form_datetime").datetimepicker({
		 format:"yyyy-mm-dd",
		 autoclose:true,
		 todayBtn:true,
		 todayHighlight:true,
		 showMeridian:true,
		 pickerPosition:"bottom-left",
		 language:'zh-CN',//中文，需要引用zh-CN.js包
		 startView:2,//月视图
	});
	
});

