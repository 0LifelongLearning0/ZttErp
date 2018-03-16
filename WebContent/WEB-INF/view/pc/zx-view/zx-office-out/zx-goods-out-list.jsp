<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>办公用品主表</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
			<div class="form-group">
					<label>标题</label>
					<input type="text" class="form-control" name="car_num" placeholder="请输入标题">
				</div>
				<div class="form-group">
					<label>申请时间</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control" placeholder="起始时间" name="apply_time_st" />
						<span class="input-group-addon">至</span>
						<input type="text" class="form_datetime form-control" placeholder="结束时间" name="apply_time_et" />
					</div>
				</div>
				<div class="form-group">
					<label>状态</label>
					<select class="form-control" name=""status"" id="status" placeholder="请选择"></select>
				</div>
			<div class="form-group" style="margin-left: 35px;">
				<button class="btn btn-primary" type="button" onclick="search('datatables')">
					<i class="glyphicon glyphicon-search"></i>&nbsp;检索
				</button>
				<button class="btn btn-default" type="button" onclick="resetAll();">重置</button>
			</div>
			</form>
		</fieldset>
	</div>
	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
			<button class="btn btn-default" onclick="toZxGoodsApplyOut()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>发放
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>
					<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
					<input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>申请时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-office-out/zx-goods-apply-list.js"></script> 
</html>
