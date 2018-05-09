<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购台账</title>
<style>
#datatables
{
white-space: nowrap;
}
.table tr.row_selected td {
background-color: yellow;
}
</style>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
			<div class="form-group">
					<label>名称</label>
					<input type="text" class="form-control" name="purchase_name" id="purchase_name" placeholder="请输入标题">
				</div>
				<div class="form-group">
					<label>项目</label>
					<input type="text" class="form-control" name="project" id="project" placeholder="请输入项目">
				</div>
				<span style="background-color: #FFFFFF">    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				</span>
				<div class="form-group">
					<label>申请时间</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control" placeholder="起始时间" name="apply_time_st" />
						<span class="input-group-addon">至</span>
						<input type="text" class="form_datetime form-control" placeholder="结束时间" name="apply_time_et" />
					</div>
					</div>
				<div class="form-group">
					<label>工令号</label>
					<input type="text" class="form-control" name="product_order_number" id="product_order_number" placeholder="请输入工令号">
				</div>
				
				<div class="form-group">
					<label>erp号</label>
					<input type="text" class="form-control" name="erp_number" id="erp_number" placeholder="请输入erp号">
				</div>
				</br>
				<div class="form-group">
					<label>供应商</label>
					<input type="text" class="form-control" name="supply_name" id="supplyer_name" placeholder="请选择供应商">
					<button type="button" class="btn btn-success"
								onclick="selectsupplyer()" id="buttonsave">
								<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>选择
							</button>
				</div>
				<span style="background-color: #FFFFFF">    &nbsp;&nbsp;&nbsp;</span>
				<div class="form-group">
					<label>供应商开票日期</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control" placeholder="起始时间" name="apply_time_st_supplier_bill_date" />
						<span class="input-group-addon">至</span>
						<input type="text" class="form_datetime form-control" placeholder="结束时间" name="apply_time_et_supplier_bill_date" />
					</div>
				</div>
				
				<div class="form-group">
					<label>交货日期</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control" placeholder="起始时间" name="apply_time_st_End_data" />
						<span class="input-group-addon">至</span>
						<input type="text" class="form_datetime form-control" placeholder="结束时间" name="apply_time_et_End_data" />
					</div>
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
			<button class="btn btn-default" onclick="toZttPurchaseAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="toZttPurchaseUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button class="btn btn-default" onclick="delZttPurchase()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
			<button class="btn btn-default" onclick="export1()">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>导出
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>下单日期</th>
					<th>erp号</th>
					<th>工令号</th>
					<th>申请人</th>
					<th>项目</th>
					<th>名称</th>
					<th>规格</th>
					<th>单位</th>
					<th>数量</th>
					<th>供应商</th>
					<th>成本单价</th>
					<th>成本总价</th>
					<th>供应商开票日期</th>
					<th>供应商开票金额</th>
					<th>交期</th>
					<th>到货日期</th>
					<th>到货数量</th>
					<th>状态</th>
					<th>详情</th>
					<th>审批</th>
					<th>质检</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-purchase/ztt-purchase-list.js"></script> 
</html>
