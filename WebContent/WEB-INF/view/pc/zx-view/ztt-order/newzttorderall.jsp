<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表</title>
<style>
#datatables
{
white-space: nowrap;
}
</style>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
			<div class="form-group">
					<label>产品名称</label>
					<input type="text" class="form-control" name="product_name" id="product_name" placeholder="请输入标题">
				</div>
				<div class="form-group">
					<label>申请时间</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control" placeholder="起始时间" name="apply_time_st" />
						<span class="input-group-addon">至</span>
						<input type="text" class="form_datetime form-control" placeholder="结束时间" name="apply_time_et" />
					</div>
					
					<div class="form-group">
					<label>类型</label>
					<select class="form-control" name="cato_type" id="cato_type" placeholder="请选择"></select>
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
			<button class="btn btn-default" onclick="export1()">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>导出excel
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>申请日期</th>
					<th>工令号</th>
					<th>客户</th>
					<th>产品名称</th>
					<th>数量</th>
					<th>业务员</th>
					<th>erp号</th>
					<th>订单号/申请号</th>
					<th>合同编号</th>
					<th>类型</th>
					<th>供应商</th>
					<th>成本单价</th>
					<th>成本总价</th>
					<th>供应商开票日期</th>
					<th>供应商开票金额</th>
					<th>单位</th>
					<th>销售单价</th>
					<th>销售总价</th>
					<th>交货日期</th>
					<th>实际交货日期</th>
					<th>发货数量</th>
					<th>开票日期</th>
					<th>开票金额</th>
					<th>成本分摊</th>
					<th>状态</th>
				</tr>
			</thead>
		</table>
	</div>
	
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-order/newzttorderall.js"></script> 
</html>
