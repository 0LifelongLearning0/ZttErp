<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>单个日程编辑与明细页面</title>
</head>
<body>
<input type="hidden" id="scheduleId" value="${zxScheduleDay.id }">
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑单个日程</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">ID</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入ID" value="${zxScheduleDay.id }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">用户id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="user_id" placeholder="请输入用户id" value="${zxScheduleDay.user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">日期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="date"  placeholder="请选择时间" value="${zxScheduleDay.date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开始时间</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="begin_time"  placeholder="请选择时间" value="${zxScheduleDay.begin_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">结束时间</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="end_time"  placeholder="请选择时间" value="${zxScheduleDay.end_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">事务类别</label>
				<div class="col-lg-6">
					<input type="hidden" id="transaction_type_" value="${zxScheduleDay.transaction_type }">
					<select class="form-control" maxlength="255" id="transaction_type" name="transaction_type" data-bv-notempty data-bv-notempty-message="请选择事务类别" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">内容</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="transaction_content" placeholder="请输入内容" value="${zxScheduleDay.transaction_content }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="remark" placeholder="请输入备注" value="${zxScheduleDay.remark }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否提醒</label>
				<div class="col-lg-6">
					<input type="hidden" id="transaction_remind_" value="${zxScheduleDay.transaction_remind }">
					<select class="form-control" maxlength="255" id="transaction_remind" name="transaction_remind" data-bv-notempty data-bv-notempty-message="请选择是否提醒" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group" id="remind_day">
				<label class="col-lg-3 control-label">提前多少天</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="255"  name="remind_day" placeholder="请输入提前多少天提醒" value="${zxScheduleDay.remind_day }">
				</div>
			</div>
			<div class="form-group" id="remind_hour">
				<label class="col-lg-3 control-label">多少小时</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="32"  name="remind_hour" placeholder="请输入提前几小时提醒" value="${zxScheduleDay.remind_hour }">
				</div>
			</div>
			<div class="form-group" id="remind_minute">
				<label class="col-lg-3 control-label">多少分钟</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="32"  name="remind_minute" placeholder="请输入提前多少分钟提醒" value="${zxScheduleDay.remind_minute }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="delZxScheduleDay()">删除</button>
					<button type="button" class="btn green" onclick="updateZxScheduleDay()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-schedule-day/zx-schedule-day-update.js"></script> 
</html>
