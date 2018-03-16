<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>周期性事务</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
			<div class="form-group">
					<label>重复类型</label>
					<select class="form-control" name="repetition_type" id="repetition_type" placeholder="请选择"></select>
				</div>
				<div class="form-group">
					<label>事务类型</label>
					<select class="form-control" name="transaction_type" id="transaction_type" placeholder="请选择"></select>
				</div>
				<div class="form-group">
					<label>是否提醒</label>
					<select class="form-control" name="transaction_remind" id="transaction_remind" placeholder="请选择"></select>
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
			<button class="btn btn-default" onclick="toZxPeriodTransactionAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="toZxPeriodTransactionUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button class="btn btn-default" onclick="delZxPeriodTransaction()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>开始日期</th>
					<th>结束日期</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>重复类型</th>
					<th>事务类型</th>
					<th>内容</th>
					<th>事务提醒</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-period-transaction/zx-period-transaction-list.js"></script> 
</html>
