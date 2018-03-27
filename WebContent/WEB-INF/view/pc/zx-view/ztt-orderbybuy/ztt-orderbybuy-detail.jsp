<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>外协单表详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>外协单表详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序列号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序列号" value="${zttOrderbybuy.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">订单号id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入订单号id"  name="order_id" placeholder="请输入订单号id" value="${zttOrderbybuy.order_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">采购人员id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入采购人员id"  name="buymanager_id" placeholder="请输入采购人员id" value="${zttOrderbybuy.buymanager_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">确认交货日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="buy_end_data" placeholder="请输入确认交货日期" value="${zttOrderbybuy.buy_end_data }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">提交日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="update_date" placeholder="请输入提交日期" value="${zttOrderbybuy.update_date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验人员id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入检验人员id"  name="product_dispatch_id" placeholder="请输入检验人员id" value="${zttOrderbybuy.product_dispatch_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验报告</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  data-bv-notempty data-bv-notempty-message="请输入检验报告"  name="product_dispatch_attachment" placeholder="请输入检验报告" value="${zttOrderbybuy.product_dispatch_attachment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否合格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="product_is_qualified" placeholder="请输入是否合格" value="${zttOrderbybuy.product_is_qualified }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验人员提交日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="product_update_date" placeholder="请输入检验人员提交日期" value="${zttOrderbybuy.product_update_date }">
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
<script type="text/javascript" src="../view/pc/zx-view/ztt-orderbybuy/ztt-orderbybuy-detail.js"></script> 
</html>
