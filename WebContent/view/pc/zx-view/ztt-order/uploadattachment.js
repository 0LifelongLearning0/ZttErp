/*function ajaxFileUpload(){
	         var formData = new FormData();
	        formData.append('file',$("#file_upload")[0].files[0]);    //将文件转成二进制形式
	        $.ajax({
	            type:"post",
	            url:"../zttOrderController/uploadfile",
	            async:false,
	            contentType: false,    //这个一定要写
	            processData: false, //这个也一定要写，不然会报错
	            data:formData,
	            dataType:'text',    //返回类型，有json，text，HTML。这里并没有jsonp格式，所以别妄想能用jsonp做跨域了。
	            success:function(data){
	            	parent.$('#attachmentupload').val(data);
	            	layer.alert('上传成功');
	            },
	            error:function(XMLHttpRequest, textStatus, errorThrown, data){
	                alert(errorThrown);
	            }            
	        }); 
	    
}
*/
$('#easyContainer').easyUpload({
	  index:0,
	  allowFileTypes: '*.*',//允许上传文件类型，格式';*.doc;*.pdf'
	  allowFileSize: 100000000,//允许上传文件大小(KB)
	  selectText: '选择文件',//选择文件按钮文案
	  multi: true,//是否允许多文件上传
	  multiNum: 10,//多文件上传时允许的文件数
	  showNote: true,//是否展示文件上传说明
	  note: '提示：最多上传10个文件',//文件上传说明
	  showPreview: true,//是否显示文件预览
	  url: '../zttOrderController/uploadfile',//上传文件地址
	  fileName: 'file',//文件filename配置参数
	  formParam: {
	    token: $.cookie('token_cookie')//不需要验证token时可以去掉
	  },//文件filename以外的配置参数，格式：{key1:value1,key2:value2}
	  timeout: 3000000,//请求超时时间
	  successFunc: function(res) {
		/*  var data=eval('(' + res.success[0] + ')').path;
		  var attachment=parent.$('#attachment').val();
		  if(attachment==""){
			  attachment=data;
		  }else{
			  attachment=attachment+","+data;
		  }
		  parent.$('#attachment').val(attachment);*/
		  var id= document.getElementById("upload").value;
		  var str=res.success.join(",");
		  parent.$('#'+id).val(str);
	    console.log('成功回调', res);
	  },//上传成功回调函数
	  errorFunc: function(res) {
	    console.log('失败回调', res);
	  },//上传失败回调函数
	  deleteFunc: function(res) {
	    console.log('删除回调', res);
	  }//删除文件回调函数
	});