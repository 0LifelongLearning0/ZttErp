<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>人员选择</title>
</head>
<body>
<div class="panel-body">
<div class="modal fade" id="userChooseModal" tabindex="-1" role="dialog" aria-labelledby="userChooseModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="userChooseModalLabel">
					用户列表
				</h4>
			</div>
			<div class="modal-body">
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
/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../zxMeetingController/getXtUserinfoListByCondition',null);},//渲染数据
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
				data:"xt_userinfo_id",
				render:function (data, type, full, meta) {
					return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="' + data + '" /><span></span></label>';
				},
				bSortable:false
			},
			{
				data:"xt_userinfo_id",
				width:"150px"
			},
			{
				data:'xt_userinfo_name'
			},
			{
				data:'xt_userinfo_realName'
			}
		]
	});
	user_choose_grid=$('#datatables').dataTable(options);
	//实现全选反选
	docheckboxall('checkall','checkchild');
	//实现单击行选中
	clickrowselected('datatables');
}
function doUserSelect(){
	if($(".checkchild:checked").length != 1){
		toastrBoot(4,"选择数据非法");
		return;
	}
	var id = $(".checkchild:checked").val();
	var name = $(".checkchild:checked").parent().parent().parent().find('td').eq(2).text();
	msgTishCallFnBoot("确定要选择【<font color=red>"+name+"</font>】？",function(){
		$('#' + user_choose_id).val(id);
		$('#' + user_choose_name).val(name);
		$('#userChooseModal').modal('hide');
	})
}
</script> 
</html>
