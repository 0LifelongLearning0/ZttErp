<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>客户详情页面</title>
</head>
<body>
		<input type="hidden" id="permission" value="${permission}"/>
	<input type="hidden" id="isAdmin" value="${isAdmin}"/>
	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
			<button class="btn btn-default" onclick="toZxSupplierAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>选择
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>客户名称</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript"
	src="../view/pc/zx-view/ztt-order/selectclient.js"></script>

</html>
