<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>会议室详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>会议室信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">会议室名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" value="${zxMeetingHouse.house_name}" maxlength="100" id="house_name" readOnly>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">容纳人数</label>
				<div class="col-lg-3">
					<input class="form-control" type="number" value="${zxMeetingHouse.max_num}" maxlength="11" id="max_num" readOnly>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">状态</label>
				<div class="col-lg-3">
					<input class="form-control" type="text" value="${zxMeetingHouse.status}" maxlength="100" id="status" readOnly>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">说明</label>
				<div class="col-lg-3">
					<textarea class="form-control" cols="100" style="height:300px" maxlength="256" name="remark" readOnly placeholder="请输入说明">${zxMeetingHouse.remark}</textarea>
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
<script type="text/javascript" src="../view/pc/zx-view/zx-meeting-house/zx-meeting-house-detail.js"></script> 
</html>
