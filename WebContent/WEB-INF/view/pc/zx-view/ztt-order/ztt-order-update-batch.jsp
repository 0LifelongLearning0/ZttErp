<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<div class="container-fluid  col-md-8 col-md-offset-2">
				<div class="row">
				<input id="id" type="hidden" value="${id }"/>
					<form class="form-horizontal" id="defaultForm" method="post">
						<input class="form-control" type="hidden" maxlength="255" name="id"
							id="id" value='${id }'>
						<table class="table table-bordered">
							<caption class="text-center h3 no-margin bold">批量修改表</caption>
							<tbody>
								<%-- <tr>
								<td class="col-md-1 text-center">供应商开票日期</td>
								<td class="col-md-3"><input class="form_datetime form-control"
									type="text" maxlength="255" name="supplier_bill_date" id="supplier_bill_date" value='${zttOrder.supplier_bill_date }'></td>


								<td class="col-md-1 text-center">供应商开票金额</td>
								<td class="col-md-3"><input class="form-control"
									type="text" maxlength="255" name="supplier_bill_price"
									id="supplier_bill_price"
									value='${zttOrder.supplier_bill_price }'></td>
								</tr>
								<tr id="sales">
								<td class="col-md-1 text-center">销售开票日期</td>
								<td class="col-md-3"><input type="text"
									class="form_datetime form-control" maxlength="32"
									name="bill_date_open" id="bill_date_open" value='${zttOrder.bill_date_open }'></td>
								<td class="col-md-1 text-center" id="erp1">销售开票金额</td>
								<td class="col-md-3"><input class="form-control"
									type="text" maxlength="255" name="bill_price" id="bill_price"
									value='${zttOrder.bill_price }'></td> --%>
									<tr>
									<td class="col-md-1 text-center" id="erp1">成本分摊</td>
								<td class="col-md-3" id="erp2"><input class="form-control"
									type="text" maxlength="255" name="cost_share" id="cost_share"
									value='${zttOrder.cost_share }'></td>
								</tr>
							</tbody>
						</table>
						<div class="text-center">
							<button type="button" class="btn btn-success"
								onclick="updateZttOrderbatch()">
								<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存
							</button>
						</div>
					</form>

				</div>
			</div>
		</fieldset>
	</div>
</body>
<script type="text/javascript"
	src="../view/pc/zx-view/ztt-order/ztt-order-update.js"></script>
</html>
