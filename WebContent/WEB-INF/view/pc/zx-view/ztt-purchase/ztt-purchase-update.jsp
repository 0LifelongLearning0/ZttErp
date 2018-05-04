<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购台账编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑采购台账</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序列号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序列号" value="${zttPurchase.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">工令号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="Product_order_number" id="Product_order_number" placeholder="请输入工令号" value="${zttPurchase.product_order_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">交期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" type="text" maxlength="32"  name="hope_end_data" placeholder="请输入交期" value="${zttPurchase.hope_end_data }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">erp号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="erp_number" placeholder="请输入erp号" value="${zttPurchase.erp_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">数量</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="amount" placeholder="请输入erp号" value="${zttPurchase.amount }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="purchase_name" value="${zttPurchase.purchase_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">规格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="purchase_stardard" value="${zttPurchase.purchase_stardard }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">成本单价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="cost_single_price" value="${zttPurchase.cost_single_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">供应商开票日期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" type="text" maxlength="32"  id="supplier_bill_date" name="supplier_bill_date"  value="${zttPurchase.supplier_bill_date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">供应商开票金额</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="supplier_bill_price"  id="supplier_bill_price" value="${zttPurchase.supplier_bill_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">实际到货日期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" type="text" maxlength="32"  id="end_data" name="end_data"  value="${zttPurchase.end_data }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">到货数量</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="send_amount"  id="send_amount" value="${zttPurchase.send_amount }">
				</div>
			</div>
		<div class="form-group">
		<label class="col-lg-3 control-label">供应商</label>
										<div class="col-lg-6">
									<input type="text" class="form-control"
						name="supply_name" id="supplyer_name" placeholder="请选择供应商" value="${zttPurchase.supply_name }">
									<button type="button" class="btn btn-success"
						onclick="selectsupplyer()" id="buttonsave">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>选择
					</button></div>
			</div>
			<div class="form-group" style="display:none;">
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="zttPurchaseSon_removed_flag" id="zttPurchaseSon_removed_flag" >
					<input class="form-control" type="hidden" value="${fn:length(zttPurchase.zttPurchaseSon) }" name="zttPurchaseSonFormNumber" id="zttPurchaseSonFormNumber" >
				</div>
			</div>
			<!-- 一对多子表开始（采购子台账） -->
			<div class="page-header">
				<h4>采购子台账</h4>
			</div>
			<input type="hidden" id="zttPurchaseSon" value="${zttPurchase.zttPurchaseSon}">
			<div class="form-group">
				<div class="col-lg-4">
					<a class="btn btn-mini btn-primary glyphicon glyphicon-plus" href="javascript:addZttPurchaseSonItems()" role="button">新一行</a>
				</div>
			</div>
			<div class="form_zttPurchaseSon">
			<c:forEach var="zttPurchaseSon" items="${zttPurchase.zttPurchaseSon }" varStatus="zttPurchaseSonStatus">
				<div id="form_zttPurchaseSon_${zttPurchaseSonStatus.index}">
			<fieldset>
			<legend><h5>序号${zttPurchaseSonStatus.index+1}</h5></legend>
			<div class="form-group">
			<div class="col-lg-3">
			<a class="btn btn-danger" href="javascript:delZttPurchaseSonItemsupdate(this,${zttPurchaseSonStatus.index})" >删除该条信息</a>
			</div>
			</div>
				<table><tr>
			<td><label class="control-label">名称</label></td>
			<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon[${zttPurchaseSonStatus.index}].name" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].name" placeholder="请输入名称" value="${zttPurchaseSon.name }"></td>
			<td><label class="control-label">规格</label></td>
			<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon[${zttPurchaseSonStatus.index}].purchase_stardard" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].purchase_stardard" placeholder="请输入名称" value="${zttPurchaseSon.purchase_stardard }"></td>		
			<td><label class="control-label">材质</label></td>
			<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon[${zttPurchaseSonStatus.index}].material" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].material" placeholder="请输入名称" value="${zttPurchaseSon.material }"></td>		
			<td><label class="control-label">单位</label></td>
			<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon[${zttPurchaseSonStatus.index}].unit" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].unit" placeholder="请输入名称" value="${zttPurchaseSon.unit }"></td>		
			<td><label class="control-label">数量</label></td>
			<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon[${zttPurchaseSonStatus.index}].amount" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].amount" placeholder="请输入名称" value="${zttPurchaseSon.amount }"></td>		
			<td><label class="control-label">上传附件</label></td>
		<td><button class="btn btn-primary" data-toggle="button" onclick="uploadattachment(${zttPurchaseSonStatus.index})">请上传附件</button>
		<input class="form-control" type="hidden" maxlength="255"  id="zttPurchaseSon_${zttPurchaseSonStatus.index}_attachment" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].attachment" value="${zttPurchaseSon.attachment}"></td>
		<td><label class="control-label">报价</label></td>
		<td>
		<input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon[${zttPurchaseSonStatus.index}].single_price" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].single_price" placeholder="请输入名称" value="${zttPurchaseSon.single_price }">
		</td>
			<td><label class="control-label">erp号</label></td>
			<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon[${zttPurchaseSonStatus.index}].erp_numbert" name="zttPurchaseSon[${zttPurchaseSonStatus.index}].erp_number" placeholder="请输入名称" value="${zttPurchaseSon.erp_number }"></td>		
			</tr>	</table>
				
				
				</fieldset>
				</div>
				</c:forEach>
			</div>
			<!-- 一对多子表结束（采购子台账） -->
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZttPurchase()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	var zttPurchaseObj = '${zttPurchaseJSON}';
	try{
		zttPurchaseObj = eval("("+zttPurchaseObj+")");
	}catch(e){
	}
</script>
<script type="text/javascript" src="../view/pc/zx-view/ztt-purchase/ztt-purchase-update.js"></script> 
</html>
