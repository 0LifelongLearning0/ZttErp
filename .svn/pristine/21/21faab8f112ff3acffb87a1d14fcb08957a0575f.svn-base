var index = 0;
//返回r
function goback(){
	tlocation("../zxMeetingController/loadZxMeeting");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxMeeting(){
	if($('#user_ids_t').val() == ''){
		toastrBoot(4,"请选择参会人员");
		return;
	}
	submitBForm('defaultForm','../zxMeetingController/addZxMeeting','../zxMeetingController/loadZxMeeting');
}
//初始化日期选择器
$(document).ready(function(){
	myDatetimeInit();
	var json = eval('(' + $('#house_list').val() + ')');
	var house_list = json.items;
	var text = '<option value="">请选择</option>';
	for(var i = 0;i < house_list.length;i++){
		text += '<option value="'+ house_list[i].id +'">'+ house_list[i].house_name +'</option>';
	}
    $("#house_id").append(text);
});
function myDatetimeInit(){
	$(".form_datetime").datetimepicker({
		 format:"yyyy-mm-dd hh:ii",
		 autoclose:true,
		 todayBtn:true,
		 todayHighlight:true,
		 showMeridian:true,
		 pickerPosition:"bottom-left",
		 language:'zh-CN',//中文，需要引用zh-CN.js包
		 startView:2,//月视图
		 minView:0//日期时间选择器所能够提供的最精确的时间选择视图
	}); 
}
function addFile(){
	var fd = $('.file-demo').html();
	fd = fd.replace(/{index}/g,index)
	$('#meeting_attach_add').before(fd);
	var picid = 'meeting_attach_'+index;
	var fieldid = 'zx_meeting_pic_'+index;
	/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
	initMyBFileRight(fieldid,picid,4);
	/**初始化附件右键菜单结束**/
	index = index + 1;
}

function initMyBFileRight(fieldid,picid,isUpAndDelete,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	var menu = new BootstrapMenu('#'+picid,{
		  actions:[
		    {
		      name:'上传',
		      iconClass:'fa-upload',
		      onClick:function(){
		    	  initMyBUpload(fieldid,picid,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk);
		      }
		    }, 
		    {
		      name:'下载',
		      iconClass:'fa-download',
		      onClick:function(){
		    	  var xt_attachment_id = $('#' + fieldid).val();
				  downOrExportB(basePath+'/xtCommonController/downFile?xt_attachment_id='+xt_attachment_id);
		      }
		    }, 
		    {
		      name:'删除',
		      iconClass:'fa-trash',
		      onClick:function(){
			      $('#'+picid).remove();
		      }
		    },
		    {
		      name:'复制文件地址',
		      iconClass:'fa-clipboard',
			  onClick:function(){
				  var url_path = $("#"+picid).attr('src'); 
				  msgTishCallFnBoot("文件地址："+url_path,function(){});
			  }
		    },
		    {
		      name:'查看',
		      iconClass:'fa-file-image-o',
			  onClick:function(){
				  var url_path = $("#"+picid).attr('src'); 
				  getBimghw(url_path);
			  }
		    }
		    ]
	});
}
function initMyBUpload(fieldid,picid,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	var allowedFileExtensions_ = ['jpg','gif','png','xls','xlsx','bmp','zip','docx','pptx','pdf','csv','txt','apk'];
	var maxFileSize_ = 0;
	if(null !=validateSize){
		maxFileSize_ = validateSize;
	}
	if(null != validateparameter){
		allowedFileExtensions_ = validateparameter;
	}
	$('#jehcUploadModal').modal({backdrop: 'static', keyboard: false});
	$("#jehcFile").fileinput({
		showUpload:true, //是否显示上传按钮
		showCaption:false,
		showPreview:true,
		uploadUrl:basePath+'/zxMeetingController/upload?type=1',
		enctype:'multipart/form-data',
		language:'zh',
        allowedFileExtensions:allowedFileExtensions_,//接收的文件后缀
        minFileCount:1,
        uploadAsync:false,/**默认异步上传**/
        showCaption:true,/**是否显示标题**/
        maxFileSize:maxFileSize_,/**单位为kb，如果为0表示不限制文件大小**/
        maxFileCount:1,/**表示允许同时上传的最大文件个数**/
        enctype:'multipart/form-data',
        validateInitialCount:true,
        msgFilesTooMany:"选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        uploadExtraData:function (previewId, index) {    
            var data = {
            	validateparameter:(validateparameter != '' && null != validateparameter && typeof(validateparameter) != "undefined")?validateparameter:'',
            	validateSize:(validateSize != '' && null != validateSize && typeof(validateSize) != "undefined")?validateSize:'',
            	xt_path_absolutek:(xt_path_absolutek != '' && null != xt_path_absolutek && typeof(xt_path_absolutek) != "undefined")?xt_path_absolutek:'',
            	xt_path_relativek:(xt_path_relativek != '' && null != xt_path_relativek && typeof(xt_path_relativek) != "undefined")?xt_path_relativek:'',
            	xt_path_urlk:(xt_path_urlk != '' && null != xt_path_urlk && typeof(xt_path_urlk) != "undefined")?xt_path_urlk:''
            };
            return data;
       }
     }).on('filebatchuploadsuccess', function(event, data, previewId, index) {
 		 var obj = eval("(" + data.response + ")");
     	 if(obj.data.jsonID != 0){
     		//赋值
          	$("#"+picid).attr('src',obj.data.jsonValue); 
          	$("#"+fieldid).val(obj.data.jsonID);
          	var num = picid.replace(/meeting_attach_/g,"");
          	$('#file_name_' + num).text(obj.data.filename);
          	$('#file_name_' + num).attr('title',obj.data.filename);
      		//关闭上传窗口
          	$('#jehcUploadModal').modal('hide');
          	//并清空上传控件内容
          	$('#jehcFile').val('');
          	 window.parent.toastrBoot(3,obj.data.msg);
         }else{
        	 window.parent.toastrBoot(4,obj.data.msg);
         }
     });
}