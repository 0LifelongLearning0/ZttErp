<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
<meta charset="UTF-8">
<title>办公用品管理</title>
<style type="text/css">
/* #left{width:25%; height:750px;float:left;border:5px;}
#right{width:72%; height:750px;float:right;border:5px;overflow-y:scroll;} */
#btn-group{height:75px;top:40px}
</style>
</head>
<body>
<div id="left" class="col-md-2">
     <div class="btn-group"  id="btn-group">
			<button class="btn btn-default" onclick="toZxOfficeClassifyAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="toZxOfficeClassifyUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button class="btn btn-default" onclick="delZxOfficeClassify()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
	</div>
	<div class="modal-body" id="modal-body">
				<ul id="treeDemo" class="ztree"></ul>
	</div>
</div>
	<div id="right" class="col-md-10">
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
				<div class="form-group">
					<label>名称</label>
					<input type="text" class="form-control" name="office_name" placeholder="请输入名称">
				</div>
				<div class="form-group" style="display:none">
					<label>classify_id</label>
					<input type="text" class="form-control" name="classify_id" id="classify_id" placeholder="请输入名称">
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
			<button class="btn btn-default" onclick="toZxOfficeAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="toZxOfficeUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button class="btn btn-default" onclick="delZxOffice()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>办公用品名称</th>
					<th>数量</th>
					<th>规格型号</th>
					<th>单位</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
</body>


	
	
<!-- <div class="departSelectModal" id="id="panel-body1" tabindex="-1" role="dialog" aria-labelledby="departSelectModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="departSelectModalLabel">
					部门选择器
				</h4>
			</div>
			<div class="modal-body">
				<ul id="tree" class="ztree"></ul>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doGoodsSelect()">保存</button>
            </div>
		</div>/.modal-content
	</div>/.modal
</div> -->
<script type="text/javascript" src="../view/pc/zx-view/zx-office/zx-office-list.js"></script> 
</html>
