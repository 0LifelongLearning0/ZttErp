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

			<div class="container-fluid">
				<div class="row col-md-8 col-md-offset-2">
					<div class="text-center h3 pbp">机械加工工艺过程卡片</div>
					<form class="form-horizontal" id="defaultForm" method="post">
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
							data-toggle="modal"
							onclick="showmodal()">
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
									<th class="col-md-2 text-center">负责人</th>
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
<!-- add模态框（Modal）开始 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
	aria-labelledby="departSelectModalLabel" aria-hidden="true"
	style="width: 600px; height: 900px; text-align: center; margin-left: auto; margin-right: auto;margin-buttom:auto;margin-top:auto">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="departSelectModalLabel">新增工艺内容</h4>


			</div>
			<div class="modal-body">

				<form id='login-form-id' class="form-inline">
					<div class="form-group">
					
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td class="text-center">工序名称</td>
									<td class="text-gray"><select id="Processname">
									        <option value="0">请选择</option>
											<option value="1">下料</option>
											<option value="2">普车加工</option>
											<option value="3">数车加工</option>
											<option value="4">加工中心</option>
											<option value="5">火花机</option>
											<option value="6">钳工</option>
											<option value="7">线切割</option>
											<option value="8">外协加工</option>
									</select></td>
									<td class="text-center">工艺内容</td>
									<td class="text-center">
									<input class="form-control" type="text" maxlength="32" id="Processcontent" name="Processcontent">
									</td>
								</tr>
								<tr>
									<td class="text-center">设备</td>
									<td class="text-gray">
									<input class="form-control" type="text" maxlength="32" id="equipment" name="equipment"></td>
									<td class="text-center">工艺装备</td>
									<td class="text-center">
									<input class="form-control" type="text" maxlength="32" id="tooling" name="tooling">
									</td>
								</tr>
								<tr>
									<td class="text-center">单价</td>
									<td class="text-gray"><input class="form-control" type="text" maxlength="32" id="time" name="single_price"></td>
									<td class="text-center"></td>
									<td class="text-center">
									</td>
								</tr>
							</tbody>
						</table>
						 <div class="form-group">
						<div class="col-lg-6">
						<button type="button" name="addRow" class="btn btn-primary"
							id="addRow" data-dismiss="modal"><span class="glyphicon glyphicon-saved" aria-hidden="true"></span>添加</button>
					</div>
					</div>
					</div>
				

				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="../view/pc/zx-view/ztt-order/processingtechnic.js"></script>
	<script type="text/javascript"
		src="../view/pc/zx-view/zx-goods-apply/zx-goods-apply-list-tree.js"></script>
</html>
