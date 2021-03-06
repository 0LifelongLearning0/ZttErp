
//返回r
function goback(){
	if($('#from').val()=='1'){
		tlocation("../zxMeetingController/loadZxMeeting");
	}else{
		tlocation("../zxMeetingUserController/loadZxMeetingUser");
	}
	
}
//保存
function addZxMeeting(){
	var back = "../zxMeetingUserController/loadZxMeetingUser";
	if($('#from').val()=='1'){
		back = "../zxMeetingController/loadZxMeeting";
	}
	submitBForm('defaultForm','../zxMeetingController/addZxMeeting',back);
}
//初始化日期选择器
$(document).ready(function(){
	$.ajax({  
        type : "post",  
         url : '../zxMeetingController/getUserAndAttach?meeting_id='+$('#id').val(),  
         async : true,  
         success : function(data){
        	 data = eval('(' + data +')');
        	 $('#user_name_t').val(data.user_name_t);
        	 $('#user_name_o').val(data.user_name_o);
        	 
        	 var zxAttachs = data.zxAttachs;
        	 for(var i = 0;i < zxAttachs.length;i++){
        		var fd = $('.file-demo').html();
    			fd = fd.replace(/{index}/g,i)
    			$('#attach').append(fd);
    			var picid = 'meeting_attach_'+i;
    			var fieldid = 'zx_meeting_pic_'+i;
    			$("#"+picid).attr('src',data.jsonValue); 
              	$("#"+fieldid).val(zxAttachs[i].xt_attachment_id);
              	$('#file_name_' + i).text(zxAttachs[i].filename);
              	$('#file_name_' + i).attr('title',zxAttachs[i].filename);
              	
    			/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
    			initMyBFileRight(fieldid,picid,2);
    			/**初始化附件右键菜单结束**/
        	 }
         }
	});
	
});

function initMyBFileRight(fieldid,picid,isUpAndDelete,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
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
}
