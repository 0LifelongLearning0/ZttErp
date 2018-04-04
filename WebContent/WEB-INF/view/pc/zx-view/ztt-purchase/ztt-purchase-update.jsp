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
					<input class="form-control" type="text" maxlength="32"  name="Product_order_number" placeholder="请输入工令号" value="${zttPurchase.Product_order_number }">
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
				<label class="col-lg-3 control-label">发起人id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="apply_id" placeholder="请输入发起人id" value="${zttPurchase.apply_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">采购人id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="Product_id" placeholder="请输入采购人id" value="${zttPurchase.Product_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="single_price" placeholder="请输入单价" value="${zttPurchase.single_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">总价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="sum_price" placeholder="请输入总价" value="${zttPurchase.sum_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验员id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="qualified_id" placeholder="请输入检验员id" value="${zttPurchase.qualified_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合格件数</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="qualified_number" placeholder="请输入合格件数" value="${zttPurchase.qualified_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验员日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="qualified_date" placeholder="请输入检验员日期" value="${zttPurchase.qualified_date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">检验文件</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="check_attachment" placeholder="请输入检验文件" value="${zttPurchase.check_attachment }">
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
