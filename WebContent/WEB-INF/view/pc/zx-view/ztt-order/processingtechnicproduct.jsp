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
					<div class="text-bold pba text-center clearfix">
						<p class="col-md-3">产品名称：${zttOrder.product_name }</p>
						<p class="col-md-3">零件名称：${zttOrder.machine_part }</p>
						<p class="col-md-3">工令号：${zttOrder.product_order_number }</p>
						<p class="col-md-3">零件图号：${zttOrder.machine_part_number }</p>
					</div>
					<div class="text-bold pba text-center clearfix">
						<p class="col-md-3">下单日期：${zttOrder.zttordertime }</p>
						<p class="col-md-3">交货日期：${zttOrder.end_data }</p>
						<p class="col-md-3">加工数量：${zttOrder.amount }</p>
						<p class="col-md-3">材料牌号：${zttOrder.material_id }</p>
					</div>
					<div style="display:none;">
                      <input class="form-control"  type="hidden" "size" id="size"  value='${size }'>
                       </div>
					<div>
						<!-- Modal -->


					</div>
					<form class="form-horizontal" id="defaultForm" method="post">
					<input class="form-control" type="hidden" maxlength="32" id="id" name="id" value="${zttOrder.id }">
					<input class="form-control" type="hidden" maxlength="32" id="index" name="index" value="${index }">
						<table id="example" class="table table-bordered">
							<thead>
								<tr class="text-bold">
									<th class="col-md-1 text-center">工序号</th>
									<th class="col-md-2 text-center">工序名称</th>
									<th class="col-md-2 text-center">工艺内容</th>
									<th class="col-md-2 text-center">设备</th>
									<th class="col-md-2 text-center">工艺装备</th>
									<th class="col-md-2 text-center">单价</th>
									<th class="col-md-2 text-center">总价</th>
									<th class="col-md-1 text-center">合格件数</th>
								</tr>
							</thead>
							<tfoot>
							</tfoot>
						</table>
						<div class="text-center">
							<button type="button" class="btn btn-success"
								onclick="addZxGoodsApply()" id="buttonsave">
								<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存
							</button>
						</div>
					</form>
				</div>

			</div>

		</fieldset>

	</div>
 <div class="form_zxPurchaseApplyDetail" style="display:none;">
<c:forEach var="ztt_processproduct" items="${zttOrder.ztt_processproduct }" varStatus="ztt_processproductStatus">
				<div id="form_zxGoodsApplyDetail_${ztt_processproductStatus.index}">
			<fieldset>
				<legend><h5>序号${ztt_processproductStatus.index+1}</h5></legend>
				<div class="form-group">f
						<label class="col-lg-3 control-label">序列号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].id" name="ztt_processproduct[${ztt_processproductStatus.index}].id" value="${ztt_processproduct.id }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">序列号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].processname" name="ztt_processproduct[${ztt_processproductStatus.index}].processname" value="${ztt_processproduct.processname }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用品id</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].processcontent" name="ztt_processproduct[${ztt_processproductStatus.index}].processcontent" placeholder="请输入用品id" value="${ztt_processproduct.processcontent }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用品</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].equipment" name="ztt_processproduct[${ztt_processproductStatus.index}].equipment" placeholder="请输入用品id" value="${ztt_processproduct.equipment }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">规格型号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].tooling" name="ztt_processproduct[${ztt_processproductStatus.index}].tooling" placeholder="请输入用品id" value="${ztt_processproduct.tooling }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">申请数量</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="20"  id="ztt_processproduct[${ztt_processproductStatus.index}].single_price" name="ztt_processproduct[${ztt_processproductStatus.index}].single_price" placeholder="请输入申请数量" value="${ztt_processproduct.single_price }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用途</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="255"  id="ztt_processproduct[${ztt_processproductStatus.index}].sum_price" name="ztt_processproduct[${ztt_processproductStatus.index}].sum_price" placeholder="请输入备注" value="${ztt_processproduct.sum_price }">
						</div>
					</div>
				<div class="form-group">
						<label class="col-lg-3 control-label">用途</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="255"  id="ztt_processproduct[${ztt_processproductStatus.index}].qualified_number" name="ztt_processproduct[${ztt_processproductStatus.index}].qualified_number" placeholder="请输入备注" value="${ztt_processproduct.qualified_number }">
						</div>
					</div>
					
				</fieldset>
				</div>
				</c:forEach>
		 </div>
</body>
	<script type="text/javascript"
		src="../view/pc/zx-view/ztt-order/processingtechnicproduct.js"></script>
</html>
