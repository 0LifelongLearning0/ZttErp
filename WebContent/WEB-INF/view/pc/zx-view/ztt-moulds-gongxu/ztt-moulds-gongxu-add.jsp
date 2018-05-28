<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>模具部工序新增页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建模具部工序</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">工序名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="gongxu_name" placeholder="请输入工序名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="number" placeholder="请输入编号">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="zttMouldsDeivice_removed_flag" id="zttMouldsDeivice_removed_flag" >
					<input class="form-control" type="hidden" value="-1" name="zttMouldsDeiviceFormNumber" id="zttMouldsDeiviceFormNumber" >
				</div>
			</div>
			<!-- 一对多子表开始（工序设备） -->
			<div class="page-header">
				<h4>工序设备</h4>
			</div>
			<div class="form-group">
				<div class="col-lg-4">
					<a class="btn btn-mini btn-primary glyphicon glyphicon-plus" href="javascript:addZttMouldsDeiviceItems()" role="button">新一行</a>
				</div>
			</div>
			<div class="form_zttMouldsDeivice">
			</div>
			<!-- 一对多子表结束（工序设备） -->
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZttMouldsGongxu()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-moulds-gongxu/ztt-moulds-gongxu-add.js"></script> 
</html>
