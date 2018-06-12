<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>模具部车间员工信息表编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑模具部车间员工信息表</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">用户ID</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="xt_userinfo_id"  placeholder="请输入用户ID" value="${zttMojuUserinfo.xt_userinfo_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">所属设备id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  id="xt_device_id" name="xt_device_id" placeholder="请输入所属设备id" value="${zttMojuUserinfo.xt_device_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">所属设备</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  id="xt_device" name="xt_device" placeholder="请输入所属设备" value="${zttMojuUserinfo.device_name }" onclick="DeviceSelect()">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">用户名</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="64"  data-bv-notempty data-bv-notempty-message="请输入用户名"  name="xt_userinfo_name" placeholder="请输入用户名" value="${zttMojuUserinfo.xt_userinfo_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">移动电话</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="xt_userinfo_mobile" placeholder="请输入移动电话" value="${zttMojuUserinfo.xt_userinfo_mobile }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">其他电话</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="xt_userinfo_ortherTel" placeholder="请输入其他电话" value="${zttMojuUserinfo.xt_userinfo_ortherTel }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否离职</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="4"  name="isonjob" placeholder="请输入是否离职" value="${zttMojuUserinfo.isonjob }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">入职时间</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_userinfo_intime" placeholder="请输入入职时间" value="${zttMojuUserinfo.xt_userinfo_intime }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">离职时间</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_userinfo_outTime" placeholder="请输入离职时间" value="${zttMojuUserinfo.xt_userinfo_outTime }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">qq号码</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="12"  name="xt_userinfo_qq" placeholder="请输入qq号码" value="${zttMojuUserinfo.xt_userinfo_qq }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZttMojuUserinfo()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-moju-userinfo/ztt-moju-userinfo-update.js"></script> 
</html>
