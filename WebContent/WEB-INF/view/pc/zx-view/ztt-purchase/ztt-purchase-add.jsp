<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购台账新增页面</title>
<style>
.font-color-meta-light{ color:red}
.hse2{ color:#F00}
.hse3{ color:#FF0000}
</style>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建采购台账</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">工令号 <span class="font-color-meta-light">（必填项）</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="Product_order_number" id="Product_order_number" placeholder="请输入工令号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">名称 <span class="font-color-meta-light">（必填项）</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="purchase_name" id="purchase_name" placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">规格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="purchase_stardard" id="purchase_stardard" placeholder="请输入规格">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">材质</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="material" id="material" placeholder="请输入材质">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="unit" id="unit" placeholder="请输入单位">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">数量 <span class="font-color-meta-light">（必填项）</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="amount" id="amount" placeholder="请输入数量">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">交期 <span class="font-color-meta-light">（必填项）</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" type="text" maxlength="32"  id="hope_end_data" name="hope_end_data" placeholder="请输入交期">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZttPurchase()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-purchase/ztt-purchase-add.js"></script> 
</html>
