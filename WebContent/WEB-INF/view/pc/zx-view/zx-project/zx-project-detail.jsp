<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>项目管理详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>项目详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">项目ID</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入项目ID" value="${zxProject.id }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">项目名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="name" placeholder="请输入项目名称" value="${zxProject.name }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">项&ensp;目&ensp;号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  name="num" placeholder="请输入项目号" value="${zxProject.num }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">发货时间</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="ship_date"  placeholder="请选择时间" value="${zxProject.ship_date }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-project/zx-project-detail.js"></script> 
</html>
