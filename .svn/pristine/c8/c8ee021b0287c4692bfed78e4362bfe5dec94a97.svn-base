<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>解除合同详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>解除合同详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序号" value="${zxRelieveContract.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">姓名</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" readonly="readonly" maxlength="32" id="user_name" name="user_name" placeholder="姓名" value="${zxRelieveContract.xt_userinfo_realName }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合同编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" readonly="readonly" name="contract_num" placeholder="请输入合同编号" value="${zxRelieveContract.contract_num }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">登记日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="create_time" readonly="readonly" placeholder="请选择时间" value="${zxRelieveContract.create_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">签署时间</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="sign_time" readonly="readonly" placeholder="请选择时间" value="${zxRelieveContract.sign_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开始日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="begin_time" readonly="readonly" placeholder="请选择时间" value="${zxRelieveContract.begin_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">结束日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="end_time" readonly="readonly" placeholder="请选择时间" value="${zxRelieveContract.end_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">解除日期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="relieve_time" readonly="readonly" placeholder="请选择时间" value="${zxRelieveContract.relieve_time }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_user_id" placeholder="请输入员工id" value="${zxRelieveContract.xt_user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255" readonly="readonly" name="remark" placeholder="备注" value="${zxRelieveContract.remark}">
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
<script type="text/javascript" src="../view/pc/zx-view/zx-relieve-contract/zx-relieve-contract-detail.js"></script> 
</html>
