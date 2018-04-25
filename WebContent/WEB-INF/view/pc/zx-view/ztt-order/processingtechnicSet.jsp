<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%@ include file="/deng/include/includeboot.jsp"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript"
	src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
</head>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">

				


				<div class="form-group" style="margin-left: 35px;">
					<button class="btn btn-primary" type="button"
						onclick="search('datatables')">
						<i class="glyphicon glyphicon-search"></i>&nbsp;检索
					</button>
					<button class="btn btn-default" type="button" onclick="resetAll();">重置</button>
				</div>
				<input class="form-control" type="hidden" maxlength="255"
					name="apply_id" id="apply_id" value='${applyUser.xt_userinfo_id }'>
			</form>
		</fieldset>
	</div>
	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
			<button class="btn btn-default" onclick="toZttOrderAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="toZttOrderUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button class="btn btn-default" onclick="delZttOrder()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
			<button class="btn btn-default" onclick="export1()">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>导出
			</button>
		</div>
		<input class="form-control"
									type="hidden" maxlength="255" name="apply_id" id="apply_id" value='${applyUser.xt_userinfo_id }'>
		<table id="datatables"
			class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label
						class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input
							type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>申请日期</th>
					<th>工令号</th>
					<th>客户</th>
					<th>产品名称</th>
					<th>规格</th>
					<th>数量</th>
					<th>业务员</th>
					<th>erp号</th>
					<th>订单号/申请号</th>
					<th>合同编号</th>
					<th>类型</th>
					<th>供应商</th>
					<th>成本总价</th>
					<th>供应商开票日期</th>
					<th>供应商开票金额</th>
					<th>单位</th>
					<th>销售单价</th>
					<th>销售总价</th>
					<th>交货日期</th>
					<th>实际交货日期</th>
					<th>发货数量</th>
					<th>销售开票日期</th>
					<th>销售开票金额</th>
					<th>成本分摊</th>
					<th>状态</th>
					<th>详情</th>
					<th>审批</th>
					<th>质检</th>
					<th>发货</th>
				</tr>
			</thead>
		</table>
	</div>
	</body>
	<script type="text/javascript"
		src="../view/pc/zx-view/ztt-order/processingtechnic.js"></script>
	<script type="text/javascript"
		src="../view/pc/zx-view/zx-goods-apply/zx-goods-apply-list-tree.js"></script>
</html>
