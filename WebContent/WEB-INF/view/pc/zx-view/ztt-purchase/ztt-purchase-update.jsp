<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购台账编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑采购台账</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序列号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序列号" value="${zttPurchase.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">工令号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="product_order_number" placeholder="请输入工令号" value="${zttPurchase.product_order_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">erp号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="erp_number"  value="${zttPurchase.erp_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">数量</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="amount" placeholder="请输入数量" value="${zttPurchase.amount }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">成本单价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="cost_single_price" placeholder="请输入单价" value="${zttPurchase.cost_single_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">供应商开票日期</label>
				<div class="col-lg-6">
				<input class="form_datetime form-control"
									type="text" maxlength="255" name="supplier_bill_date" id="supplier_bill_date" value='${zttPurchase.supplier_bill_date }'>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">供应商开票金额</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name=supplier_bill_price  value="${zttPurchase.supplier_bill_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">实际到货日期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" type="text" maxlength="20"  name="end_data"  value="${zttPurchase.end_data }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZttPurchase()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-purchase/ztt-purchase-update.js"></script> 
</html>
