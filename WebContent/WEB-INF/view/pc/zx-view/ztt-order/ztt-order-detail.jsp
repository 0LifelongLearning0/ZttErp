<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表详情页面</title>
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
		<fieldset id="printAll${zxCarApply.id }">
            <div class="container-fluid  col-md-8 col-md-offset-2">
                <div class="row">
                 <input class="form-control" type="hidden" maxlength="255"  name="erp_number" id="erp_number" value='${zttOrder.erp_number }'>
                 <input class="form-control" type="hidden" maxlength="255"  name="id" id="id" value='${zttOrder.id }'>
                 	<input class="form-control" type="hidden" maxlength="255"  name="order_id" id="order_id">
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
		                        <td  colspan="3">${zttOrder.sale_contract_number }</td>
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
		                        <td class="col-md-3">
		                        <input class="form-control" type="hidden" maxlength="255"  name="attachment" id="attachment" value='${zttOrder.attachment }'>
		                        <button class="btn btn-primary" data-toggle="button" onclick="downloadattachment('${zttOrder.id}')">查看附件</button>
					
		                    </tr>
		                     <tr>
		                     <td class="col-md-1 text-center" id="erp1">erp号</td>
		                        <td class="col-md-3" id="erp2">${zttOrder.erp_number }</td>
		                        <td class="col-md-1 text-center" id="erp1">加工工艺过程</td>
		                        <td class="col-md-3" id="erp2"><button class="btn btn-primary" data-toggle="button" onclick="progressupload()">查看</button></td>
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
