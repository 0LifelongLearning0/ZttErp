<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>外协单表新增页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建外协单表</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">订单号id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入订单号id"  name="order_id" placeholder="请输入订单号id">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">采购人员id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入采购人员id"  name="buymanager_id" placeholder="请输入采购人员id">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">确认交货日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="buy_end_data" placeholder="请输入确认交货日期">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">提交日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="update_date" placeholder="请输入提交日期">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验人员id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入检验人员id"  name="product_dispatch_id" placeholder="请输入检验人员id">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验报告</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  data-bv-notempty data-bv-notempty-message="请输入检验报告"  name="product_dispatch_attachment" placeholder="请输入检验报告">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否合格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="product_is_qualified" placeholder="请输入是否合格">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验人员提交日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="product_update_date" placeholder="请输入检验人员提交日期">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZttOrderbybuy()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-orderbybuy/ztt-orderbybuy-add.js"></script> 
</html>
