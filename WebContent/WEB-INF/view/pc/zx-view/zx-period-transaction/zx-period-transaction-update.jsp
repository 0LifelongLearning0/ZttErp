<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>周期性事务编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑周期性事务</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">id</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入id" value="${zxPeriodTransaction.id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">用户id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="user_id" placeholder="请输入用户id" value="${zxPeriodTransaction.user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开始日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="begin_date"  placeholder="请选择时间" value="${zxPeriodTransaction.begin_date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">结束日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="end_date"  placeholder="请选择时间" value="${zxPeriodTransaction.end_date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开始时间</label>
				<div class="col-lg-6">
					<input class="form_time form-control" name="begin_time"  placeholder="请选择时间" value="${zxPeriodTransaction.begin_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">结束时间</label>
				<div class="col-lg-6">
					<input class="form_time form-control" name="end_time"  placeholder="请选择时间" value="${zxPeriodTransaction.end_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">事务类型</label>
				<div class="col-lg-6">
					<input type="hidden" id="transaction_type_" value="${zxPeriodTransaction.transaction_type }">
					<select class="form-control" maxlength="32"  id="transaction_type" name="transaction_type" data-bv-notempty data-bv-notempty-message="请选择事务类型" placeholder="请输入事务类型">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">内容</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255" name="transaction_content" placeholder="请输入内容" data-bv-notempty data-bv-notempty-message="请输入内容" value="${zxPeriodTransaction.transaction_content }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="remark" placeholder="请输入备注" value="${zxPeriodTransaction.remark }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">重复类型</label>
				<div class="col-lg-6">
					<input type="hidden" id="repetition_type_" value="${zxPeriodTransaction.repetition_type }">
					<select class="form-control" maxlength="32" id="repetition_type" name="repetition_type" data-bv-notempty data-bv-notempty-message="请选择重复类型" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group" id="week" style="display:none">
				<label class="col-lg-3 control-label">请选择周几</label>
				<div class="col-lg-6">
					<input type="hidden" id="repetition_week_" value="${zxPeriodTransaction.repetition_week }">
					<select class="form-control" maxlength="32" id="repetition_week" name="repetition_week" data-bv-notempty data-bv-notempty-message="请选择周几" placeholder="请选择" >
					</select>
				</div>
			</div>
			<div class="form-group" id="day" style="display:none">
				<label class="col-lg-3 control-label">请选择几号</label>
				<div class="col-lg-6">
					<input type="hidden" id="repetition_day_" value="${zxPeriodTransaction.repetition_day }">
					<select class="form-control" maxlength="32" id="repetition_day" name="repetition_day" data-bv-notempty data-bv-notempty-message="请选择多少号" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否提醒</label>
				<div class="col-lg-6">
					<input type="hidden" id="transaction_remind_" value="${zxPeriodTransaction.transaction_remind }">
					<select class="form-control" maxlength="32" id="transaction_remind" name="transaction_remind" data-bv-notempty data-bv-notempty-message="请选择是否提醒" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group" style="display:none" id="remind_day">
				<label class="col-lg-3 control-label">提前多少天</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="32" max="7" name="remind_day" placeholder="请输入多少天" value="${zxPeriodTransaction.remind_day }">
				</div>
			</div>
			<div class="form-group" style="display:none" id="remind_hour">
				<label class="col-lg-3 control-label">多少小时</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="32" max="24" name="remind_hour" placeholder="请输入多少小时" value="${zxPeriodTransaction.remind_hour }">
				</div>
			</div>
			<div class="form-group" style="display:none" id="remind_minute">
				<label class="col-lg-3 control-label">多少分钟提醒</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="32" max="60" name="remind_minute" placeholder="请输入多少分钟" value="${zxPeriodTransaction.remind_minute }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZxPeriodTransaction()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-period-transaction/zx-period-transaction-update.js"></script> 
</html>
