<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表详情页面</title>
</head>
<body>
		<input type="hidden" id="permission" value="${permission}"/>
	<input type="hidden" id="isAdmin" value="${isAdmin}"/>
	<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
			<div class="form-group">
					<label>名称</label> <input type="text" class="form-control"
						name="name" id="name" placeholder="请输入供应商">
				</div>
			<div class="form-group" style="margin-left: 35px;">
				<button class="btn btn-primary" type="button" onclick="search('datatables')">
					<i class="glyphicon glyphicon-search"></i>&nbsp;检索
				</button>
				<button class="btn btn-default" type="button" onclick="resetAll();">重置</button>
			</div>
			</form>
		</fieldset>
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
					<th>设备名称</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript"
	src="../view/pc/zx-view/ztt-moulds-gongxu/ztt-moulds-gongxu-device-list.js"></script>

</html>
