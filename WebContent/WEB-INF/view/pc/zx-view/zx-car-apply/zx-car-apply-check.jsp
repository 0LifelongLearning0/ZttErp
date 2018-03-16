<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>车辆审批表</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
				<div class="form-group">
					<label>车牌</label>
					<input type="text" class="form-control" name="car_num" placeholder="请输入车辆">
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
					<label>申请人</label>
					<input type="text" class="form-control" name="apply_user_name" placeholder="请输入申请人姓名">
				</div>
				<div class="form-group">
					<label>申请类型</label>
					<select class="form-control" name="apply_type" id="apply_type" placeholder="请选择"></select>
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
			<button class="btn btn-default" onclick="toCarOut()">
				<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>出门
			</button>
			<button class="btn btn-default" onclick="toCarBack()">
				<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>回司
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
					<th>状态</th>
					<th>审批车辆</th>
					<th>申请类型</th>
					<th>申请用车地点</th>
					<th>申请时间</th>
					<th>出门时间</th>
					<th>出门里程</th>
					<th>回司时间</th>
					<th>回司里程</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<!-- 部门选择器模态框（Modal）结束 -->
<script type="text/javascript" src="../view/pc/zx-view/zx-car-apply/zx-car-apply-check.js"></script> 
</html>
