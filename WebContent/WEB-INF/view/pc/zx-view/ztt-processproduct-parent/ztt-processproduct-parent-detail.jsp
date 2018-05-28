<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>机械加工工艺过程母表详情页面</title>
<style type="text/css" media="print">
.btn-success { display:none;}
</style>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>

			<div class="container-fluid">
				<div class="row col-md-8 col-md-offset-2">
					<div class="text-center h3 pbp">机械加工工艺过程卡片</div>
					<form class="form-horizontal" id="defaultForm" method="post">
					<input class="form-control" type="hidden" maxlength="255"  name="order_id" id="order_id">
					 <input class="form-control"  type="hidden" "size" id="size"  value='${size }'>
					<table id="head" class="table table-bordered">
							<tbody>
							<tr class="text-bold">
									<th class="col-md-1 text-center">产品名称：</th><th class="col-md-2 text-center">${zttOrder.product_name }</th>
									<th class="col-md-1 text-center">零件名称</th><th class="col-md-2 text-center">${zttProcessproductParent.machine_part}</th>
									<th class="col-md-1 text-center">工令号</th><th class="col-md-2 text-center">${zttOrder.product_order_number }</th>
									<th class="col-md-1 text-center">零件图号</th><th class="col-md-2 text-center">${zttProcessproductParent.machine_part_number}</th>
								</tr>
								<tr class="text-bold">
									<th class="col-md-1 text-center">下单日期:</th><th class="col-md-2 text-center">${zttOrder.zttordertime }</th>
									<th class="col-md-1 text-center">交货日期：</th><th class="col-md-2 text-center">${zttOrder.end_data }</th>
									<th class="col-md-1 text-center">加工数量：</th><th class="col-md-2 text-center">${zttOrder.amount }</th>
									<th class="col-md-1 text-center">材料牌号</th><th class="col-md-2 text-center">${zttProcessproductParent.material_id}</th>
								</tr>
							</tbody>
							<tfoot>
							</tfoot>
						</table>
					<div>
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
									<th class="col-md-2 text-center">总价</th>
								</tr>
							</thead>
							<tfoot>
							</tfoot>
						</table>
						<div class="text-center">
							<button type="button" class="btn-success"
								onclick="printpage()">
								<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>打印
							</button>
						</div>
					</form>
				</div>

			</div>

		</fieldset>

	</div>
	  <div class="form_zxPurchaseApplyDetail" style="display:none;">
<c:forEach var="zttProcessproduct" items="${zttProcessproductParent.zttProcessproduct }" varStatus="ztt_processproductStatus">
				<div id="form_zxGoodsApplyDetail_${ZttProcessproductStatus.index}">
			<fieldset>
				<legend><h5>序号${ZttProcessproductStatus.index+1}</h5></legend>
				<div class="form-group">f
						<label class="col-lg-3 control-label">序列号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct_parent[${ztt_processproductStatus.index}].id" name="ztt_processproduct_parent[${ztt_processproductStatus.index}].id" value="${zttProcessproduct.id }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">序列号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].processname" name="ztt_processproduct[${ztt_processproductStatus.index}].processname" value="${zttProcessproduct.processname }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用品id</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].processcontent" name="ztt_processproduct[${ztt_processproductStatus.index}].processcontent" placeholder="请输入用品id" value="${zttProcessproduct.processcontent }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用品</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].equipment" name="ztt_processproduct[${ztt_processproductStatus.index}].equipment" placeholder="请输入用品id" value="${zttProcessproduct.equipment }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">规格型号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="ztt_processproduct[${ztt_processproductStatus.index}].tooling" name="ztt_processproduct[${ztt_processproductStatus.index}].tooling" placeholder="请输入用品id" value="${zttProcessproduct.tooling }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">申请数量</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="20"  id="ztt_processproduct[${ztt_processproductStatus.index}].single_price" name="ztt_processproduct[${ztt_processproductStatus.index}].single_price" placeholder="请输入申请数量" value="${zttProcessproduct.single_price }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">申请数量</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="20"  id="ztt_processproduct[${ztt_processproductStatus.index}].sum_price" name="ztt_processproduct[${ztt_processproductStatus.index}].sum_price" placeholder="请输入申请数量" value="${zttProcessproduct.sum_price }">
						</div>
					</div>
				<!-- </fieldset>
				</div> -->
				</c:forEach>
		 </div>
</body>
<script type="text/javascript">
	var zttProcessproductParentObj = '${zttProcessproductParentJSON}';
	try{
		zttProcessproductParentObj = eval("("+zttProcessproductParentObj+")");
	}catch(e){
	}
</script>
<script type="text/javascript" src="../view/pc/zx-view/ztt-processproduct-parent/ztt-processproduct-parent-detail.js"></script> 
</html>
