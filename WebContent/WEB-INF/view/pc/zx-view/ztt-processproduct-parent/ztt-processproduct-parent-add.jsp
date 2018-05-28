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
			<div class="container-fluid">
				<div class="row col-md-8 col-md-offset-2">
					<div class="text-center h3 pbp">机械加工工艺过程卡片</div>
					<form class="form-horizontal" id="defaultForm" method="post">
					<input class="form-control" type="hidden" maxlength="255"  name="order_id" id="order_id">
					<input class="form-control" type="hidden" maxlength="255"  name="product_order_number" id="product_order_number">
					<table id="head" class="table table-bordered">
							<tbody>
							<tr class="text-bold">
									<th class="col-md-1 text-center">产品名称：</th><th class="col-md-2 text-center">${zttOrder.product_name }</th>
									<th class="col-md-1 text-center">零件名称</th><th class="col-md-2 text-center"><input class="form-control" type="text" maxlength="32" id="machine_part" name="machine_part"></th>
									<th class="col-md-1 text-center">工令号</th><th class="col-md-2 text-center">${zttOrder.product_order_number }</th>
									<th class="col-md-1 text-center">零件图号</th><th class="col-md-2 text-center"><input class="form-control" type="text" maxlength="32" id="machine_part_number" name="machine_part_number"></th>
								</tr>
								<tr class="text-bold">
									<th class="col-md-1 text-center">下单日期:</th><th class="col-md-2 text-center">${zttOrder.zttordertime }</th>
									<th class="col-md-1 text-center">交货日期：</th><th class="col-md-2 text-center">${zttOrder.end_data }</th>
									<th class="col-md-1 text-center">加工数量：</th><th class="col-md-2 text-center">${zttOrder.amount }</th>
									<th class="col-md-1 text-center">材料牌号</th><th class="col-md-2 text-center"><input class="form-control" type="text" maxlength="32" id="material_id" name="material_id"></th>
								</tr>
							</tbody>
							<tfoot>
							</tfoot>
						</table>
					<div>
						<button class="btn btn-default pull-right" type="button"
							onclick="showaddpage()">
							<span class="glyphicon glyphicon-plus"></span> 添加
						</button>
						<!-- Modal -->


					</div>
					
					
					<form class="form-horizontal" id="defaultForm" method="post">
					<input class="form-control" type="hidden" maxlength="32" id="id" name="id" value="${zttOrder.id }">
					<input class="form-control" type="hidden" maxlength="32" id="index" name="index" value="${index }">
					<input class="form-control" type="hidden" maxlength="32" id="amount" name="amount" value="${zttOrder.amount }">
						<table id="example" class="table table-bordered">
							<thead>
							
								<tr class="text-bold">
									<th class="col-md-1 text-center">工序号</th>
									<th class="col-md-2 text-center">工序名称</th>
									<th class="col-md-2 text-center">工艺内容</th>
									<th class="col-md-2 text-center">设备</th>
									<th class="col-md-2 text-center">工艺装备</th>
									<th class="col-md-2 text-center">单价</th>
									<th class="col-md-2 text-center">操作</th>
								</tr>
							</thead>
							<tfoot>
							</tfoot>
						</table>
						<div class="text-center">
							<button type="button" class="btn btn-success"
								onclick="addZxGoodsApply()">
								<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存
							</button>
							<button type="button" class="btn default"
								onclick="resetAll('defaultForm')">
								<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>重置
							</button>
						</div>
					</form>
				</div>

			</div>

		</fieldset>

	</div>
</body>

	<script type="text/javascript" src="../view/pc/zx-view/ztt-processproduct-parent/ztt-processproduct-parent-add.js"></script> 
</html>
