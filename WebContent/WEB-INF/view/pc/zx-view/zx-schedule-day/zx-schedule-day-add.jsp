<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>单个日程新增页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建单个日程</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="date" data-bv-notempty data-bv-notempty-message="请选择日期" placeholder="请选择时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开始时间</label>
				<div class="col-lg-6">
					<input class="form_time form-control" name="begin_time" data-bv-notempty data-bv-notempty-message="请选择开始时间" placeholder="请选择时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">结束时间</label>
				<div class="col-lg-6">
					<input class="form_time form-control" name="end_time" data-bv-notempty data-bv-notempty-message="请选择结束时间" placeholder="请选择时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">事务类别</label>
				<div class="col-lg-6">
					<select class="form-control" maxlength="255" id="transaction_type" name="transaction_type" data-bv-notempty data-bv-notempty-message="请选择事务类别" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">内容</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="transaction_content" data-bv-notempty data-bv-notempty-message="请输入内容" placeholder="请输入内容">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="remark" placeholder="请输入备注">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否提醒</label>
				<div class="col-lg-6">
					<select class="form-control" maxlength="255"  id="transaction_remind" name="transaction_remind" value="0" data-bv-notempty data-bv-notempty-message="请选择" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group" style="display:none" id="remind_day">
				<label class="col-lg-3 control-label">提前多少天</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="255" max="7" name="remind_day" placeholder="提前多少天">
				</div>
			</div>
			<div class="form-group" style="display:none" id="remind_hour">
				<label class="col-lg-3 control-label">多少小时</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="32" max="24" name="remind_hour" placeholder="多少小时">
				</div>
			</div>
			<div class="form-group" style="display:none" id="remind_minute">
				<label class="col-lg-3 control-label">多少分钟提醒</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="32" max="60" name="remind_minute" placeholder="多少分钟提醒">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZxScheduleDay()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-schedule-day/zx-schedule-day-add.js"></script> 
</html>
