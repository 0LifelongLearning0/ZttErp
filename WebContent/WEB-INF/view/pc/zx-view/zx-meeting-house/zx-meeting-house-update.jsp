<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>会议室新增页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑会议室信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<input type="hidden" name="id" value="${zxMeetingHouse.id}">
			<input type="hidden" name="state" value="${zxMeetingHouse.state}">
			<div class="form-group">
				<label class="col-lg-3 control-label">会议室名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" value="${zxMeetingHouse.house_name}" maxlength="100" id="house_name" data-bv-notempty data-bv-notempty-message="请输入会议室名称"  name="house_name" placeholder="请输入会议室名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">容纳人数</label>
				<div class="col-lg-3">
					<input class="form-control" min="0" type="number" data-bv-notempty data-bv-notempty-message="请输入容纳人数"  value="${zxMeetingHouse.max_num}" maxlength="11" id="max_num" name="max_num">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">状态</label>
				<div class="col-lg-3">
					<input type="hidden" id="status_" value="${zxMeetingHouse.status}">
					<select class="form-control" maxlength="32" id="status" name="status" placeholder="请选择"></select>				
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">说明</label>
				<div class="col-lg-3">
					<textarea class="form-control" cols="100" style="height:300px" maxlength="256" name="remark" placeholder="请输入说明">${zxMeetingHouse.remark}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZxMeetingHouse()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-meeting-house/zx-meeting-house-update.js"></script> 
</html>
