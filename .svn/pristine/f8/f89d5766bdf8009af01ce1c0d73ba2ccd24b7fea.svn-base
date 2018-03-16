var grid;
var index = 0;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxMeetingController/getZxMeetingListByCondition',opt);},//渲染数据
			//在第一位置追加序列号
			fnRowCallback:function(nRow, aData, iDisplayIndex){
				jQuery('td:eq(1)', nRow).html(iDisplayIndex +1);  
				return nRow;
		},
		order:[],//取消默认排序查询,否则复选框一列会出现小箭头
		//列表表头字段
		colums:[
			{
				sClass:"col_text-center",
				width:"50px",
				data:"id",
				render:function (data, type, full, meta) {
					return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="' + data + '" /><span></span></label>';
				},
				bSortable:false
			},
			{
				data:"id",
				width:"150px"
			},
			{
				data:'title'
			},
			{
				data:'user_realname'
			},
			{
				data:'house_id',
				render:function(data, type, row, meta) {
					var json = eval('(' + $('#house_list').val() + ')');
					var house_list = json.items;
					var col_text = '∨';
					for(var i = 0;i < house_list.length;i++){
						if(data == house_list[i].id){
							col_text = house_list[i].house_name;
							break;
						}
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			},
			{
				data:'time_start'
			},
			{
				data:'time_end'
			},
			{
				data:'state',
				render:function(data, type, row, meta) {
					var col_text = '∨';
					var now_time = $('#now_time').val();
					if(now_time < row.time_start){
						col_text = "会议前";
					}else if(now_time > row.time_end){
						col_text = "会议结束";
					}else{
						col_text = "会议中";
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			},
			{
				data:'is_record',
				render:function (data, type, full, meta) {
					var col_text = '否';
					if(data == '0'){
						col_text = '否';
					}else if(data == '1'){
						col_text = '是';
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			}
		]
	});
	grid=$('#datatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkall','checkchild');
	//实现单击行选中
	clickrowselected('datatables');
});
//新增
function toZxMeetingAdd(){
	tlocation('../zxMeetingController/toZxMeetingAdd');
}
//详情
function toZxMeetingDetail(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	tlocation("../zxMeetingController/toZxMeetingDetail?from=1&id="+id);
}
//会议记录
function toZxMeetingRecord(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	$('.del_class').remove();
	$.post('../zxMeetingController/getUserAndAttach',{meeting_id:$(".checkchild:checked").val()}, function(data) {
		 data = eval('(' + data +')');
		 var zxAttachs = data.zxAttachs;
	   	 for(var i = 0;i < zxAttachs.length;i++){
	   		 if(zxAttachs[i].type=='2'){
	   			var fd = $('.file-demo').html();
					fd = fd.replace(/{index}/g,index);
					fd = fd.replace(/{del_class}/g,'del_class');
					$('#meeting_attach_add').before(fd);
					var picid = 'meeting_attach_'+index;
					var fieldid = 'zx_meeting_pic_'+index;
					$("#"+picid).attr('src',data.jsonValue); 
		          	$("#"+fieldid).val(zxAttachs[i].xt_attachment_id);
		          	$('#file_name_' + index).text(zxAttachs[i].filename);
		          	$('#file_name_' + index).attr('title',zxAttachs[i].filename);
		          	
					/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
					initMyBFileRight(fieldid,picid,4);
					/**初始化附件右键菜单结束**/
					index = index + 1;
	   		 }
	   	 }
	});
	$('#attachRecordModal').modal();
	
}
//会议附件
function toZxMeetingAttach(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	$('.del_class').remove();
	$.post('../zxMeetingController/getUserAndAttach',{meeting_id:$(".checkchild:checked").val()}, function(data) {
		 data = eval('(' + data +')');
		 var zxAttachs = data.zxAttachs;
	   	 for(var i = 0;i < zxAttachs.length;i++){
	   		if(zxAttachs[i].type=='1'){
	   			var fd = $('.file-demo').html();
					fd = fd.replace(/{index}/g,index);
					fd = fd.replace(/{del_class}/g,'del_class');
					$('.attach-1').append(fd);
					var picid = 'meeting_attach_'+index;
					var fieldid = 'zx_meeting_pic_'+index;
					$("#"+picid).attr('src',data.jsonValue); 
		          	$("#"+fieldid).val(zxAttachs[i].xt_attachment_id);
		          	$('#file_name_' + index).text(zxAttachs[i].filename);
		          	$('#file_name_' + index).attr('title',zxAttachs[i].filename);
		          	
					/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
					initMyBFileRight(fieldid,picid,2);
					/**初始化附件右键菜单结束**/
					index = index + 1;
	   		 }else if(zxAttachs[i].type=='2'){
	   			var fd = $('.file-demo').html();
					fd = fd.replace(/{index}/g,index);
					fd = fd.replace(/{del_class}/g,'del_class');
					$('.attach-2').append(fd);
					var picid = 'meeting_attach_'+index;
					var fieldid = 'zx_meeting_pic_'+index;
					$("#"+picid).attr('src',data.jsonValue); 
		          	$("#"+fieldid).val(zxAttachs[i].xt_attachment_id);
		          	$('#file_name_' + index).text(zxAttachs[i].filename);
		          	$('#file_name_' + index).attr('title',zxAttachs[i].filename);
		          	
					/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
					initMyBFileRight(fieldid,picid,2);
					/**初始化附件右键菜单结束**/
					index = index + 1;
	   		 }
	   	 }
	});
	$('#attachModal').modal();
	
}

function addAttachRecord(){
	var fd = $('.file-demo').html();
	fd = fd.replace(/{index}/g,index)
	fd = fd.replace(/{del_class}/g,'del_class');
	$('#meeting_attach_add').before(fd);
	var picid = 'meeting_attach_'+index;
	var fieldid = 'zx_meeting_pic_'+index;
	/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
	initMyBFileRight(fieldid,picid,4);
	/**初始化附件右键菜单结束**/
	index = index + 1;
}

function initMyBFileRight(fieldid,picid,isUpAndDelete,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	if(isUpAndDelete == 2){
		var menu = new BootstrapMenu('#'+picid,{
			  actions:[
			    {
			      name:'下载',
			      iconClass:'fa-download',
			      onClick:function(){
			    	  var xt_attachment_id = $('#' + fieldid).val();
					  downOrExportB(basePath+'/xtCommonController/downFile?xt_attachment_id='+xt_attachment_id);
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
	}else{
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
			    	  msgTishCallFnBoot("确定要删除所选择的数据？",function(){
			    		  var meeting_id = $(".checkchild:checked").val();
				    	  var xt_attachment_id = $('#' + fieldid).val();
						  if(meeting_id != ''){
							  $.post('../zxMeetingController/delAttach',{meeting_id:meeting_id,xt_attachment_id:xt_attachment_id}, function(data) {
								  $('#'+picid).remove();
							  });
						  }
			    	  });
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
}
function initMyBUpload(fieldid,picid,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	var meeting_id = $(".checkchild:checked").val();
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
		uploadUrl:basePath+'/zxMeetingController/upload?type=2&meeting_id=' + meeting_id,
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