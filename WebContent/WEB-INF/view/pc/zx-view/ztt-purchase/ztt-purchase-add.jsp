<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购台账新增页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建采购台账</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">工令号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="Product_order_number" placeholder="请输入工令号">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">交期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" type="text" maxlength="32"  name="hope_end_data" placeholder="请输入交期">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">名称</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" type="text" maxlength="32"  name="purchase_name" placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="zttPurchaseSon_removed_flag" id="zttPurchaseSon_removed_flag" >
					<input class="form-control" type="hidden" value="-1" name="zttPurchaseSonFormNumber" id="zttPurchaseSonFormNumber" >
				</div>
			</div>
			<!-- 一对多子表开始（采购子台账） -->
			<div class="page-header">
				<h4>采购子台账</h4>
			</div>
			<div class="form-group">
				<div class="col-lg-4">
					<a class="btn btn-mini btn-primary glyphicon glyphicon-plus" href="javascript:addZttPurchaseSonItems()" role="button">新一行</a>
				</div>
			</div>
			<div class="form_zttPurchaseSon">
			</div>
			<!-- 一对多子表结束（采购子台账） -->
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
