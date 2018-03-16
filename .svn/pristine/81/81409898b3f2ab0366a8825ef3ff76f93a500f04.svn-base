<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>公积金台账详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>公积金台账详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序号" value="${zxReservedFunds.id }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">部门id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_departinfo_id" placeholder="请输入部门id" value="${zxReservedFunds.xt_departinfo_id }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_user_id" placeholder="请输入员工id" value="${zxReservedFunds.xt_user_id }">
				</div>
			</div>
			<div class="form-group" >
				<label class="col-lg-3 control-label">姓名</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" readonly="readonly" name="xt_userinfo_realName" placeholder="请输入员工id" value="${zxReservedFunds.xt_userinfo_realName }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">部</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" readonly="readonly" name="xt_departinfo_name" placeholder="请输入部门id" value="${zxReservedFunds.xt_departinfo_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">年</label>
				<div class="col-lg-6">
					<input type="hidden" id="annum_" value="${zxReservedFunds.annum }">
					<select class="form-control" type="text" maxlength="10" disabled="disabled" id="annum" name="annum" placeholder="请输入年">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">月</label>
				<div class="col-lg-6">
					<input type="hidden" id="month_" value="${zxReservedFunds.month }">
					<select class="form-control" type="text" maxlength="10" disabled="disabled" id="month" name="month" placeholder="请输入月">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">新基数</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" readonly="readonly" name="cardinal_num" placeholder="请输入新基数" value="${zxReservedFunds.cardinal_num }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位缴存</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" readonly="readonly" name="company_payment" placeholder="请输入单位缴存" value="${zxReservedFunds.company_payment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">个人缴存</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" readonly="readonly" name="person_payment" placeholder="请输入个人缴存" value="${zxReservedFunds.person_payment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合计</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" readonly="readonly" name="sum_payment" placeholder="请输入合计" value="${zxReservedFunds.sum_payment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">个人账号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="40" readonly="readonly" name="person_account" placeholder="请输入个人账号" value="${zxReservedFunds.person_account }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">记录时间</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="create_time" readonly="readonly" placeholder="请选择时间" value="${zxReservedFunds.create_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255" readonly="readonly" name="remark" placeholder="请输入备注" value="${zxReservedFunds.remark }">
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
<script type="text/javascript" src="../view/pc/zx-view/zx-reserved-funds/zx-reserved-funds-detail.js"></script> 
</html>
