<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>人员选择</title>
</head>
<body>
<div class="modal fade" id="userChooseModal" tabindex="-1" role="dialog" aria-labelledby="userChooseModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="userChooseModalLabel">
					用户列表
				</h4>
			</div>
			<div class="modal-body" style="max-height:500px; overflow-y:auto;">
				<table id="datatables" class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
							<th>序号</th>
							<th>用户名</th>
							<th>真实姓名</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doUserSelect()">保存</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
<!-- 审核记录模态框（Modal）开始 -->
<!-- 部门选择器模态框（Modal）结束 -->
<script type="text/javascript">
var user_choose_grid;
var user_choose_id;
var user_choose_name;
//审批记录
function userModalShow(id,name){
	$('#userChooseModal').modal();
	user_choose_id = id;
	user_choose_name = name;
	var ids = $('#' + user_choose_id).val();
	$('.da').remove();
	$.ajax({  
        type : "post",  
         url : '../zxMeetingController/getXtUserinfoListByCondition?limit=20000',  
         async : true,  
         success : function(data){
        	 data = eval('(' + data +')');
        	 data = data.data;
        	 for(var i = 0;i < data.length;i++){
        		 var cl = 'odd';
        		 if(i%2==0)cl = 'even';
        		 var x = i + 1;
        		 var isCheck = '';
        		 if(ids.indexOf(data[i].xt_userinfo_id + ',') > -1)isCheck = 'checked';
        		 var tr = '<tr role="row" class="'+ cl +' da"><td class=" col_text-center"><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">'+
        		 			'<input type="checkbox" name="checkId" class="checkchild " value="'+ data[i].xt_userinfo_id +'" '+ isCheck +'><span></span></label></td>'+
        		 			'<td>'+ x +'</td><td>'+  data[i].xt_userinfo_name +'</td><td>'+ data[i].xt_userinfo_realName +'</td></tr>';
        		 $('#datatables').append(tr);
        	 }
        	//实现全选反选
       		docheckboxall('checkall','checkchild');
       		//实现单击行选中
       		clickrowselected('datatables');
         }
	});
}
function doUserSelect(){
	if($(".checkchild:checked").length < 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = '',name = '';
	$('input[name="checkId"]:checked').each(function(){ 
    	id += $(this).val() + ',';
    	name += $(this).parent().parent().parent().find('td').eq(3).text() + ',';
    });
	msgTishCallFnBoot("确定要选择【<font color=red>"+name+"</font>】？",function(){
		$('#' + user_choose_id).val(id);
		$('#' + user_choose_name).val(name);
		$('#userChooseModal').modal('hide');
	})
}
</script> 
</html>
