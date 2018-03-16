<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>组织机构</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
				<div class="form-group">
					<label>部门名称</label>
					<input type="text" class="form-control" name="xt_departinfo_name" placeholder="请输入部门名称">
				</div>
				<div class="form-group" style="margin-left: 35px;">
					<button class="btn btn-primary" type="button" onclick="search('datatables')">
						<i class="glyphicon glyphicon-search"></i>&nbsp;检索
					</button>
					<button class="btn btn-default" type="button" onclick="resetAll();">重置</button>
				</div>
			</form>
		</fieldset>
	</div>
	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
			<button class="btn btn-default" onclick="toXtDepartinfoAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增一级部门
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
		</table>
	</div>
</body>
<!-- <script type="text/javascript" src="../view/pc/xt-view/xt-org/xt-org-list.js"></script>  -->
<script type="text/javascript">
$(function(){
	$('#datatables').treegridData({
        id: 'id',
        parentColumn: 'pid',
        type: "GET", //请求数据的ajax类型
        url: '../xtOrgController/getStaticDepartinfoAndPostTreeGrid',   //请求数据的ajax的url
        ajaxParams: {}, //请求数据的ajax的data属性
        expandColumn: null,//在哪一列上面显示展开按钮
        striped: true,   //是否各行渐变色
        bordered: true,  //是否显示边框
        expandAll: true,  //是否全部展开,
        columns: [
            {
                title: '机构名称',
                field: 'text'
            },
            {
                title: '性质',
                field: 'tempObject'
            },
            {
                title: '备注',
                field: 'remark'
            },
            {
                title: '操作',
                field: 'tempObject',
                width:"col-md-4",
                renderTo: function (data, type, row) {
	            	 var opt="";
	            	 if(data == '部门'){
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom btn-success\" onclick=\"editDepart('"+ row.id +"')\"><i class='glyphicon glyphicon-edit' title='编辑部门'></i> 编辑部门</button>&emsp;";
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom btn-danger\" onclick=\"delDepart('"+ row.id +"')\"><i class='glyphicon glyphicon-remove' title='删除部门'></i> 删除部门</button>&emsp;";
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom btn-primary\" onclick=\"addDepart('"+ row.id +"')\"><i class='glyphicon glyphicon-plus' title='添加下一级部门'></i> 添加下一级部门</button>&emsp;";
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom btn-primary\" onclick=\"addFirstPost('"+ row.id +"')\"><i class='glyphicon glyphicon-plus' title='添加一级岗位'></i> 添加一级岗位</button>&emsp;";
	            	 }else if(data == '岗位'){
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom btn-success\" onclick=\"editPost('"+ row.id +"')\"><i class='glyphicon glyphicon-edit' title='编辑岗位'></i> 编辑岗位</button>&emsp;";
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom btn-danger\" onclick=\"delPost('"+ row.id +"')\"><i class='glyphicon glyphicon-remove' title='删除岗位'></i> 删除岗位</button>&emsp;";
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom\" disabled=\"disabled\"><i class='glyphicon glyphicon-plus' title='此按钮不能操作'></i> 此按钮不能操作</button>&emsp;";
	            		 opt += "<button class=\"btn btn-sm btn-outline filter-submit margin-bottom btn-primary\" onclick=\"addPost('"+ row.id +"')\"><i class='glyphicon glyphicon-plus' title='添加下级岗位'></i> 添加下级岗位</button>&emsp;";
	            	 }
             	     return opt;
             	}
            }
        ],
        expanderExpandedClass: 'glyphicon glyphicon-chevron-down',//展开的按钮的图标
        expanderCollapsedClass: 'glyphicon glyphicon-chevron-right'//缩起的按钮的图标
    });
});

function editDepart(departId){
	layer.open({
		title: '编辑部门',
		type: 2, 
		area: ['800px', '600px'],
		content: "../xtDepartinfoController/toXtDepartinfoUpdate?xt_departinfo_id="+departId
	}); 
}
function delDepart(departId){
	alert("删除部门");
}
function addDepart(departId){
	alert("添加下级部门");
}
function addFirstPost(departId){
	alert("添加一级岗位");
}
function editPost(postId){
	alert("编辑岗位");
}
function delPost(postId){
	alert("删除岗位");
}
function addPost(postId){
	alert("添加下级岗位");
}
</script>
</html>
