<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑业务人员下单表</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序列号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序列号" value="${zttOrder.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">订单号/申请号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="order_number" placeholder="请输入订单号/申请号" value="${zttOrder.order_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合同号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="contract_number" placeholder="请输入合同号" value="${zttOrder.contract_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">客户</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="client" placeholder="请输入客户" value="${zttOrder.client }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">联系人</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="linkman" placeholder="请输入联系人" value="${zttOrder.linkman }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">产品名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="product_name" placeholder="请输入产品名称" value="${zttOrder.product_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">规格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="stardard" placeholder="请输入规格" value="${zttOrder.stardard }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">附件</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="attachment" placeholder="请输入附件" value="${zttOrder.attachment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="unit" placeholder="请输入单位" value="${zttOrder.unit }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">数量</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="amount" placeholder="请输入数量" value="${zttOrder.amount }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">销售单价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="single_price" placeholder="请输入销售单价" value="${zttOrder.single_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">销售总价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="sum_price" placeholder="请输入销售总价" value="${zttOrder.sum_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">交货日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="End_data" placeholder="请输入交货日期" value="${zttOrder.End_data }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZttOrder()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-order/ztt-order-update.js"></script> 
</html>
