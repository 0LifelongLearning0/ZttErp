<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>解除合同编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑解除合同</h4>
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
					<input class="form-control" type="text" readonly="readonly" maxlength="32" id="user_name" name="user_name" placeholder="姓名" value="${zxRelieveContract.user_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合同编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" readonly="readonly" maxlength="10"  name="contract_num" placeholder="请输入合同编号" value="${zxRelieveContract.contract_num }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">登记日期</label>
				<div class="col-lg-6">
					<input class="form-control" readonly="readonly" name="create_time"  placeholder="请选择时间" value="${zxRelieveContract.create_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">签署时间</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="sign_time"  placeholder="请选择时间" value="${zxRelieveContract.sign_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开始日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="begin_time"  placeholder="请选择时间" value="${zxRelieveContract.begin_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">结束日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="end_time"  placeholder="请选择时间" value="${zxRelieveContract.end_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">解除日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="relieve_time"  placeholder="请选择时间" value="${zxRelieveContract.relieve_time }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" id="xt_user_id" name="xt_user_id" placeholder="请输入员工id" value="${zxRelieveContract.xt_user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255" name="remark" placeholder="备注" value="${zxRelieveContract.remark}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZxRelieveContract()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-relieve-contract/zx-relieve-contract-update.js"></script> 
</html>
