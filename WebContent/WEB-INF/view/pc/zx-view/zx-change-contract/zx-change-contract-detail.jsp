<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>变更合同详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>变更合同详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序号" value="${zxChangeContract.id }">
				</div>
			</div>
			<div class="form-group" >
				<label class="col-lg-3 control-label">姓名</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" readonly="readonly" name="xt_userinfo_realName" placeholder="请选择员工" value="${zxChangeContract.xt_userinfo_realName }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">登记日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="create_time" readonly="readonly" placeholder="请选择时间" value="${zxChangeContract.create_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">签订日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="sign_time" readonly="readonly" placeholder="请选择时间" value="${zxChangeContract.sign_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">原合同开始日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="old_begin_time" readonly="readonly" placeholder="请选择时间" value="${zxChangeContract.old_begin_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">原合同结束日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="old_end_time" readonly="readonly" placeholder="请选择时间" value="${zxChangeContract.old_end_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">新合同开始日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="new_begin_time" readonly="readonly" placeholder="请选择时间" value="${zxChangeContract.new_begin_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">新合同结束日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="new_end_time" readonly="readonly" placeholder="请选择时间" value="${zxChangeContract.new_end_time }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_user_id" placeholder="请输入员工id" value="${zxChangeContract.xt_user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255" readonly="readonly" name="remark" placeholder="备注" value="${zxChangeContract.remark}">
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
<script type="text/javascript" src="../view/pc/zx-view/zx-change-contract/zx-change-contract-detail.js"></script> 
</html>
