<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>添加合同号</title>
</head>
<body>

	<div class="panel panel-default padding-10 no-margin">
		<legend>
			<div class="btn-group pull-right" style="margin-right: 20px;">
				<button type="button" onclick="goback()" class="btn btn-default">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回
				</button>
			</div>
			业务人员下单表
		</legend>
		<fieldset id="printAll${zttOrder.id }">
			<div class="container-fluid  col-md-8 col-md-offset-2">
				<div class="row">
					<form class="form-horizontal" id="defaultForm" method="post">
						<input class="form-control" type="hidden" maxlength="255" name="id"
							id="id" value='${zttOrder.id }'>
						<table class="table table-bordered">
							<caption class="text-center h3 no-margin bold">业务人员下单表</caption>
							<tbody>
								<tr>
								<input class="form-control"
									type="hidden" maxlength="255"  id="apply_id" name='apply_id' value='${zttOrder.apply_id }'>
									<input class="form-control"
									type="hidden" maxlength="255"  id="login_id"  value='${applyUser.xt_userinfo_id }'>
								
								<input class="form-control" type="hidden" name="zttordertime"  value="${zttOrder.zttordertime }"/>
								<input class="form-control" type="hidden" name="state" id='state' value="${zttOrder.state }"/>
							<input class="form-control" type="hidden" name="product_order_number"  value="${zttOrder.product_order_number }"/>
								<input class="form-control" type="hidden" name="unit"  value="${zttOrder.unit }"/>
									<td class="col-md-1 text-center">申&ensp;请&ensp;人</td>
									<td class="col-md-3"></td>
									<td class="col-md-1 text-center">部&emsp;&emsp;门</td>
									<td class="col-md-2">${applyUser.xt_departinfo_name }</td>
									<td class="col-md-1 text-center">申请日期</td>
									<td class="col-md-3">${zttOrder.zttordertime }</td>
								</tr>
								<tr>
									<td class="text-center">订单号/申请号</td>
									<td>
									<input class="form-control"
									type="text" maxlength="255" name="order_number" id="order_number" value='${zttOrder.order_number }'>
									</td>
									<td class="col-md-1 text-center">合同号</td>
									<td class="col-md-2"><input class="form-control" type="text"
										maxlength="255" name="sale_contract_number" id="sale_contract_number"
										value="${zttOrder.sale_contract_number}"></td>
										<td lass="col-md-1 text-center">工令号</td>
									<td colspan="3">${zttOrder.product_order_number}</td>
								</tr>
								<tr>
									<td class="text-center">客户</td>
									<td>
									<input type="text" class="form-control"
						name="client" id="client" value="${zttOrder.client}">
					<button type="button" class="btn btn-success"
						onclick="selectclient()" id="buttonsave">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>选择
					</button>
									</td>
									<td class="col-md-1 text-center">联系人</td>
									<td class="col-md-2">
									<input class="form-control"
									type="text" maxlength="255" name="linkman" id="linkman" value='${zttOrder.linkman }'>
									</td>
									<td class="text-center">供应商</td>
									<td colspan="3">
									<input type="text" class="form-control"
						name="supplier_name" id="supplyer_name" placeholder="请选择供应商" value='${zttOrder.supplier_name }'> 
									<button type="button" class="btn btn-success"
						onclick="selectsupplyer()" id="buttonsave">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>选择
					</button></td>
								</tr>
								<tr>
									<td class="text-center">产品名称
									</td>
									<td colspan="2">
									<input class="form-control"
									type="text" maxlength="255" name="product_name" id="product_name" value='${zttOrder.product_name }'></td>
									<td class="text-center">规格</td>
									<td colspan="2">
									<input class="form-control"
									type="text" maxlength="255" name="stardard" id="stardard" value='${zttOrder.stardard }'>
									</td>
								</tr>
								<tr>
									<td>单位</td>
									<td>${zttOrder.unit }</td>
									<td>数量</td>
									<td><input class="form-control"
										type="text" maxlength="255" id="amount" name="amount"
										value="${zttOrder.amount }" readonly=false>
									</td>
									<td>单价</td>
									<td><input class="form-control" type="text"
										maxlength="255" name="single_price" id="single_price"
										value="${zttOrder.single_price }"></td>

								</tr>
								<tr>
									<td class="col-md-1 text-center">总价</td>
									<td class="col-md-3">${zttOrder.sum_price } <input
										class="form-control" type="hidden" maxlength="255"
										id="sum_price" name="sum_price" value="${zttOrder.sum_price }">
									</td>
									<td class="col-md-1 text-center">交货日期</td>
									<td class="col-md-2">
									<input class="form_datetime form-control"
									type="text" maxlength="255" name="End_data" id="end_data" value='${zttOrder.end_data }'>
									</td>
									<td class="col-md-1 text-center" style="display:none" id="attachmenttd1">附件</td>
									<td class="col-md-3"  style="display:none" id="attachmenttd2"><button class="btn btn-primary"
											data-toggle="button" onclick="uploadattachment()" >请上传附件</button>
										
										<input class="form-control" type="hidden" maxlength="255"
										name="attachmentbefore" id="attachmentbefore" value='${zttOrder.attachment }'>
										<input class="form-control" type="hidden" maxlength="255"
										 id="attachment" name="attachment">
										 <input class="form-control" type="hidden" maxlength="255"
										 id="attachmentupdate">
										 <input class="form-control" type="hidden" maxlength="255"
										 id="attachmentafter">
										<button class="btn btn-primary"
											data-toggle="button" onclick="updtachment()" >修改附件</button>
											<input class="form-control" type="hidden" maxlength="255"
										 id="update" value='${zttOrder.attachment }'>
										</td>
								</tr>
								<tr>
									<td class="col-md-1 text-center">erp号</td>
									<td class="col-md-3">
									<input class="form-control"
										type="text" maxlength="255" name="erp_number"
										id="erp_number" value='${zttOrder.erp_number }'>
									</td>
									<td class="col-md-1 text-center">成本单价</td>
									<td class="col-md-3"><input class="form-control"
										type="text" maxlength="255" name="cost_single_price"
										id="cost_single_price" value='${zttOrder.cost_single_price }'>
									</td>
									
									<td class="col-md-1 text-center">成本总价</td>
									<td class="col-md-3">${zttOrder.cost_sum_price } <input
										class="form-control" type="hidden" maxlength="255"
										name="cost_sum_price" id="cost_sum_price"
										value='${zttOrder.cost_sum_price }'>
									</td>
								</tr>
								<td class="col-md-1 text-center">供应商开票日期</td>
								<td class="col-md-3"><input class="form_datetime form-control"
									type="text" maxlength="255" name="supplier_bill_date" id="supplier_bill_date" value='${zttOrder.supplier_bill_date }'></td>


								<td class="col-md-1 text-center">供应商开票金额</td>
								<td class="col-md-3"><input class="form-control"
									type="text" maxlength="255" name="supplier_bill_price"
									id="supplier_bill_price"
									value='${zttOrder.supplier_bill_price }'></td>
								<td class="col-md-1 text-center">发货数量</td>
								<td class="col-md-3"><input class="form-control"
									type="text" maxlength="255" name="send_amount" id="send_amount" value='${zttOrder.send_amount }'></td>
								</tr>
								<tr id="sales">
								<td class="col-md-1 text-center">销售开票日期</td>
								<td class="col-md-3"><input type="text"
									class="form_datetime form-control" maxlength="32"
									name="bill_date_open" id="bill_date_open" value='${zttOrder.bill_date_open }'></td>
								<td class="col-md-1 text-center" id="erp1">销售开票金额</td>
								<td class="col-md-3"><input class="form-control"
									type="text" maxlength="255" name="bill_price" id="bill_price"
									value='${zttOrder.bill_price }'></td>
								<td class="col-md-1 text-center" id="erp1">成本分摊</td>
								<td class="col-md-3" id="erp2"><input class="form-control"
									type="text" maxlength="255" name="cost_share" id="cost_share"
									value='${zttOrder.cost_share }'></td>
								</tr>
								<tr id="sales">
								<td class="col-md-1 text-center">实际交货日期</td>
								<td class="col-md-3"><input type="text"
									class="form_datetime form-control" maxlength="32"
									name="send_time" id="send_time" value='${zttOrder.send_time }'></td>
								<td class="col-md-1 text-center" id="cato_typetd" style="display:none">类型</td>
								<td class="col-md-3" id="cato_typetd1" style="display:none"><input type="hidden"
									class="form-control" maxlength="32"
									name="cato_type" id="cato_type" value='${zttOrder.cato_type }'>
									<input type="hidden"
									class="form-control" maxlength="32"
									 id="cato_type_before" value='${zttOrder.cato_type }'>
									 <input type="hidden"
									class="form-control" maxlength="32"
								 name="change_state" id="change_state" value='${zttOrder.change_state }'>
									<select id="selector">
                                              <option value ="madebyself">自制</option>
                                              <option value ="outside">外协</option>
                                                <option value ="">未选择</option>

                                    </select>
									
									</td>
										</tr>
										
											<tr>
											
												<td class="col-md-1 text-center" id="cato_typetd" >备注</td>
									<td class="col-md-3" id="cato_typetd1" colspan="4">
									<textarea style="width:600px;height:100px;" id="comment" name="comment">${zttOrder.comment }</textarea>
									
									</td>
									
								</tr>
							</tbody>
						</table>
						<div class="text-center">
							<button type="button" class="btn btn-success"
								onclick="updateZttOrder()">
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
