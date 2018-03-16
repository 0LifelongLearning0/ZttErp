<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>验厂申请单 详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>验厂申请单信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">申请单内容</label>
				<div class="col-lg-6">
					<textarea class="form-control" cols="100" style="height:400px" readonly="readonly" maxlength="60000"  name="content" placeholder="请输入申请单内容">${zxJudgeApply.content}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开始日期</label>
				<div class="col-lg-3">
					<input class="form-control" readonly="readonly" id="judge_date_start" name="judge_date_start" value="${zxJudgeApply.judge_date_start}" placeholder="请选择时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">结束日期</label>
				<div class="col-lg-3">
					<input class="form-control" readonly="readonly" id="judge_date_end" name="judge_date_end" value="${zxJudgeApply.judge_date_end}" placeholder="请选择时间">
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
<script type="text/javascript" src="../view/pc/zx-view/zx-judge-apply/zx-judge-apply-detail.js"></script> 
</html>
