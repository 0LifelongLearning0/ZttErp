var grid;
var index = 0;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
		searchformId:'searchForm'
	};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxMeetingUserController/getZxMeetingUserListByCondition',opt);},//渲染数据
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
				data:'type',
				render:function(data, type, row, meta) {
					var col_text = '∨';
					if(data == '1'){
						col_text = "必到";
					}else if(data == '2'){
						col_text = "邀请";
					}
					jQuery('td:eq('+meta.col+')', meta.row).html(col_text); //通过异步渲染数据
					return col_text;
				}
			},
			{
				data:'create_date'
			}
		]
	});
	grid=$('#datatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkall','checkchild');
	//实现单击行选中
	clickrowselected('datatables');
});
//详情
function toZxMeetingDetail(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	var meeting_id = '';
	$.ajax({  
        type : 'post',  
         url : '../zxMeetingUserController/getZxMeetingUserById?id=' + $(".checkchild:checked").val(),  
         async : false,  
         success : function(result){
        	 result = eval('(' + result +')');
        	 meeting_id = result.data.meeting_id;
         }
	});
	tlocation("../zxMeetingController/toZxMeetingDetail?from=2&id="+meeting_id);
}
//会议附件
function toZxMeetingAttach(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	$('.del_class').remove();
	var meeting_id = '';
	$.ajax({  
        type : 'post',  
         url : '../zxMeetingUserController/getZxMeetingUserById?id=' + $(".checkchild:checked").val(),  
         async : false,  
         success : function(result){
        	 result = eval('(' + result +')');
        	 meeting_id = result.data.meeting_id;
         }
	});
	$.ajax({  
        type : 'post',  
         url : '../zxMeetingController/getUserAndAttach?meeting_id=' + meeting_id,  
         async : false,  
         success : function(data){
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
         }
	});
	$('#attachModal').modal();
}

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
