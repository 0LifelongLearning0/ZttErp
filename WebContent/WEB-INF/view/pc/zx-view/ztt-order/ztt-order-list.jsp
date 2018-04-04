<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
			<div class="form-group">
					<label>标题</label>
					<input type="text" class="form-control" name="apply_id" placeholder="请输入标题">
				</div>
					<div class="form-group">
					<label>状态</label>
					<select class="form-control" name="state" id="state" placeholder="请选择"></select>
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
			<button class="btn btn-default" onclick="toZttOrderAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="delZttOrder()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button class="btn btn-default" onclick="toZttOrderUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>添加合同号
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
					<th>工令号</th>
					<th>客户</th>
					<th>产品名称</th>
					<th>数量</th>
					<th>申请日期</th>
					<th>业务员</th>
					<th>状态</th>
					<th>详情</th>
					<th>审批</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-order/ztt-order-list.js"></script> 
</html>
