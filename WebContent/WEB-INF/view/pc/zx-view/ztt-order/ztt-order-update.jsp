<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>添加合同号</title>
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
				<label class="col-lg-3 control-label">合同号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="contract_number" placeholder="请输入合同号" value="${zttOrder.contract_number }">
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
