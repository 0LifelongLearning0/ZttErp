<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购台账详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>采购台账详情</h4>
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
					<input class="form-control" type="text" maxlength="32"  name="Product_order_number" placeholder="请输入工令号" value="${zttPurchase.product_order_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="purchase_name" placeholder="请输入名称" value="${zttPurchase.purchase_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">规格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="purchase_stardard" placeholder="请输入规格" value="${zttPurchase.purchase_stardard }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">材质</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="material" placeholder="请输入材质" value="${zttPurchase.material }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="unit" placeholder="请输入单位" value="${zttPurchase.unit }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">数量</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="amount" placeholder="请输入数量" value="${zttPurchase.amount }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">交期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="hope_end_data" placeholder="请输入交期" value="${zttPurchase.hope_end_data }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">供应商</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="supply_name" placeholder="供应商" value="${zttPurchase.supply_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">采购单价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="single_price" placeholder="采购单价" value="${zttPurchase.single_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">总价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="sum_price" placeholder="请输入总价" value="${zttPurchase.sum_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">附件</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" maxlength="255"  name="attachment" id="attachment" value='${zttPurchase.attachment }'>
		                        <button class="btn btn-primary" data-toggle="button" onclick="downloadattachment('${zttPurchase.id}')">查看附件</button>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="comment" id="comment" value='${zttPurchase.comment }'>
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
<script type="text/javascript" src="../view/pc/zx-view/ztt-purchase/ztt-purchase-detail.js"></script> 
</html>