<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>机械加工工艺过程母表编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑机械加工工艺过程母表</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序列号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序列号" value="${zttProcessproductParent.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">订单号id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="order_id" placeholder="请输入订单号id" value="${zttProcessproductParent.order_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">下单时间</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="date" placeholder="请输入下单时间" value="${zttProcessproductParent.date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">操作者</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="product_person_id" placeholder="请输入操作者" value="${zttProcessproductParent.product_person_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">零件名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="machine_part" placeholder="请输入零件名称" value="${zttProcessproductParent.machine_part }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">零件图号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="machine_part_number" placeholder="请输入零件图号" value="${zttProcessproductParent.machine_part_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">材料牌号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="material_id" placeholder="请输入材料牌号" value="${zttProcessproductParent.material_id }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="zttProcessproduct_removed_flag" id="zttProcessproduct_removed_flag" >
					<input class="form-control" type="hidden" value="${fn:length(zttProcessproductParent.zttProcessproduct) }" name="zttProcessproductFormNumber" id="zttProcessproductFormNumber" >
				</div>
			</div>
			<!-- 一对多子表开始（机械加工工艺过程表） -->
			<div class="page-header">
				<h4>机械加工工艺过程表</h4>
			</div>
			<div class="form-group">
				<div class="col-lg-4">
					<a class="btn btn-mini btn-primary glyphicon glyphicon-plus" href="javascript:addZttProcessproductItems()" role="button">新一行</a>
				</div>
			</div>
			<div class="form_zttProcessproduct">
			<c:forEach var="zttProcessproduct" items="${zttProcessproductParent.zttProcessproduct }" varStatus="zttProcessproductStatus">
				<div id="form_zttProcessproduct_${zttProcessproductStatus.index}">
			<fieldset>
			<legend><h5>序号${zttProcessproductStatus.index+1}</h5></legend>
			<div class="form-group"><div class="col-lg-3"><a class="btn btn-danger" href="javascript:delZttProcessproductItems(this,${zttProcessproductStatus.index})" >删除该条信息</a></div></div>
					<div class="form-group">
						<label class="col-lg-3 control-label">订单号id</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].order_id" name="zttProcessproduct[${zttProcessproductStatus.index}].order_id" placeholder="请输入订单号id" value="${zttProcessproduct.order_id }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">父id</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].parentId" name="zttProcessproduct[${zttProcessproductStatus.index}].parentId" placeholder="请输入父id" value="${zttProcessproduct.parentId }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">工序名称</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="4"  id="zttProcessproduct[${zttProcessproductStatus.index}].Processname" name="zttProcessproduct[${zttProcessproductStatus.index}].Processname" placeholder="请输入工序名称" value="${zttProcessproduct.Processname }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">工序内容</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="255"  id="zttProcessproduct[${zttProcessproductStatus.index}].Processcontent" name="zttProcessproduct[${zttProcessproductStatus.index}].Processcontent" placeholder="请输入工序内容" value="${zttProcessproduct.Processcontent }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">设备</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].equipment" name="zttProcessproduct[${zttProcessproductStatus.index}].equipment" placeholder="请输入设备" value="${zttProcessproduct.equipment }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">工艺装备</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].tooling" name="zttProcessproduct[${zttProcessproductStatus.index}].tooling" placeholder="请输入工艺装备" value="${zttProcessproduct.tooling }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">单价</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="20"  id="zttProcessproduct[${zttProcessproductStatus.index}].single_price" name="zttProcessproduct[${zttProcessproductStatus.index}].single_price" placeholder="请输入单价" value="${zttProcessproduct.single_price }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">总价</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="20"  id="zttProcessproduct[${zttProcessproductStatus.index}].sum_price" name="zttProcessproduct[${zttProcessproductStatus.index}].sum_price" placeholder="请输入总价" value="${zttProcessproduct.sum_price }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">操作者</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].product_person_id" name="zttProcessproduct[${zttProcessproductStatus.index}].product_person_id" placeholder="请输入操作者" value="${zttProcessproduct.product_person_id }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">操作者日期</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].product_date" name="zttProcessproduct[${zttProcessproductStatus.index}].product_date" placeholder="请输入操作者日期" value="${zttProcessproduct.product_date }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">合格件数</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].qualified_number" name="zttProcessproduct[${zttProcessproductStatus.index}].qualified_number" placeholder="请输入合格件数" value="${zttProcessproduct.qualified_number }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">检验员日期</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zttProcessproduct[${zttProcessproductStatus.index}].qualified_date" name="zttProcessproduct[${zttProcessproductStatus.index}].qualified_date" placeholder="请输入检验员日期" value="${zttProcessproduct.qualified_date }">
						</div>
					</div>
				</fieldset>
				</div>
				</c:forEach>
			</div>
			<!-- 一对多子表结束（机械加工工艺过程表） -->
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZttProcessproductParent()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	var zttProcessproductParentObj = '${zttProcessproductParentJSON}';
	try{
		zttProcessproductParentObj = eval("("+zttProcessproductParentObj+")");
	}catch(e){
	}
</script>
<script type="text/javascript" src="../view/pc/zx-view/ztt-processproduct-parent/ztt-processproduct-parent-update.js"></script> 
</html>
