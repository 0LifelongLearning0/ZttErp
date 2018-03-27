<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表详情页面</title>
</head>

<body>
	<%-- <div class="panel-body">
	<legend style="padding-bottom: 10px">
        <button type="button" class="btn btn-default pull-right" onclick="goback()">
        <span class="glyphicon glyphicon-chevron-left"></span>返回
        </button></legend>
		<div class="page-header">
			<h4>业务人员下单表详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序列号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序列号" value="${zttOrder.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">订单号/申请号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="order_number" placeholder="请输入订单号/申请号" value="${zttOrder.order_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合同号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="contract_number" placeholder="请输入合同号" value="${zttOrder.contract_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">客户</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="client" placeholder="请输入客户" value="${zttOrder.client }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">联系人</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="linkman" placeholder="请输入联系人" value="${zttOrder.linkman }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">产品名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="product_name" placeholder="请输入产品名称" value="${zttOrder.product_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">规格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="stardard" placeholder="请输入规格" value="${zttOrder.stardard }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">附件</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="attachment" placeholder="请输入附件" value="${zttOrder.attachment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="unit" placeholder="请输入单位" value="${zttOrder.unit }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">数量</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="amount" placeholder="请输入数量" value="${zttOrder.amount }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">销售单价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="single_price" placeholder="请输入销售单价" value="${zttOrder.single_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">销售总价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="sum_price" placeholder="请输入销售总价" value="${zttOrder.sum_price }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">交货日期</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="End_data" placeholder="请输入交货日期" value="${zttOrder.End_data }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
			
		</form>
	</div> --%>
	
	
	<div class="panel panel-default padding-10 no-margin">
		<legend>
		<div class="btn-group pull-right" style="margin-right: 20px;">
			<button type="button" onclick="goback()" class="btn btn-default">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回
			</button>
		</div>
		业务人员下单表
		</legend>
		<fieldset id="printAll${zxCarApply.id }">
            <div class="container-fluid  col-md-8 col-md-offset-2">
                <div class="row">
		            <table class="table table-bordered">
		                <caption class="text-center h3 no-margin bold">业务人员下单表</caption>
		                <tbody>
		                    <tr>
		                        <td class="col-md-1 text-center">申&ensp;请&ensp;人</td>
		                        <td class="col-md-3">${applyUser.xt_userinfo_realName }</td>
		                        <td class="col-md-1 text-center">部&emsp;&emsp;门</td>
		                        <td class="col-md-2">${applyUser.xt_departinfo_name }</td>
		                        <td class="col-md-1 text-center">申请日期</td>
		                        <td class="col-md-3">
		                      ${zttOrder.zttordertime } </td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">订单号/申请号</td>
		                        <td>${zttOrder.order_number }</td>
		                        <td class="text-center">合同号</td>
		                        <td  colspan="3">${zttOrder.contract_number }</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">客户</td>
		                        <td colspan="2">
									${zttOrder.client }
								</td>
		                        <td class="text-center">联系人</td>
		                        <td colspan="2">
									${zttOrder.linkman }
								</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">产品名称</td>
		                        <td colspan="2">${zttOrder.product_name }</td>
		                        <td class="text-center">规格</td>
		                        <td colspan="2">${zttOrder.stardard }</td>
		                    </tr>
		                    <tr>
		                        <td>单位</td>
		                        <td>${zttOrder.unit }</td>
		                        <td>数量</td>
		                        <td>${zttOrder.amount }</td>
		                        <td>单价</td>
		                        <td>${zttOrder.single_price }</td>
		                        
		                    </tr>
		                    <tr>
		                     <td class="col-md-1 text-center">总价</td>
		                        <td class="col-md-3">${zttOrder.sum_price }</td>
		                        <td class="col-md-1 text-center">交货日期</td>
		                        <td class="col-md-2">${zttOrder.end_data }</td>
		                        <td class="col-md-1 text-center">附件</td>
		                        <td class="col-md-3"><label id="attachment" style="display: none;">${zttOrder.attachment }</label><button class="btn btn-primary" data-toggle="button" onclick="downloadattachment('${zttOrder.id}')">查看附件</button>
					
		                    </tr>
		                       <tr>
		                        <td>工令号</td>
		                        <td>${zttOrder.product_order_number }</td>
		                        <td>erp号</td>
		                        <td>${zttOrder.erp_number }</td>
		                        
		                    </tr>
		                </tbody>
		            </table>
                </div>
            </div>
		</fieldset>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-order/ztt-order-detail.js"></script> 
</html>
