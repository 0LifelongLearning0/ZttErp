<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>代码版本控制新增页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建代码版本控制</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">项目名</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="name" placeholder="请输入项目名">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">版本号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="codeversion" placeholder="请输入版本号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">修改时间</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="updatetime" placeholder="请输入修改时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">svn路径</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="svn" placeholder="请输入svn路径">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">搜索名</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="searchname" placeholder="请输入搜索名">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">负责人</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="person" placeholder="请输入负责人">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZttCodeversion()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-codeversion/ztt-codeversion-add.js"></script> 
</html>
