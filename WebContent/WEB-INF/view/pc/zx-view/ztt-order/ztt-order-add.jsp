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
			<legend><button type="button" onclick="goback()" class="btn btn-default pull-right"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</button></legend>
            <div class="container-fluid  col-md-8 col-md-offset-2">
                <div class="row">
                <form class="form-horizontal" id="defaultForm" method="post">
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
		                        <%  java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
							    java.util.Date currentTime = new java.util.Date();    
							    String time = simpleDateFormat.format(currentTime).toString();  
							    out.println(time);%>  </td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">订单号/申请号</td>
		                        <td class="text-gray"><input class="form-control" type="text" maxlength="255"  name="order_number" placeholder="请输入订单号/申请号"></td>
		                        <td class="text-center">合同号</td>
		                        <td class="text-gray" colspan="3"><input class="form-control" type="text" maxlength="255"  name="contract_number" placeholder="请输入合同号"></td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">客户</td>
		                        <td colspan="2">
									<input class="form-control" type="text" maxlength="255"  name="client" placeholder="请输入客户">
								</td>
		                        <td class="text-center">联系人</td>
		                        <td colspan="2">
									<input class="form-control" type="text" maxlength="255"  name="linkman" placeholder="请输入联系人">
								</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">产品名称</td>
		                        <td colspan="2"><input class="form-control" type="text" maxlength="255"  name="product_name" placeholder="请输入产品名称"></td>
		                        <td class="text-center">规格</td>
		                        <td colspan="2"><input class="form-control" type="text" maxlength="255"  name="stardard" placeholder="请输入规格"></td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">单位</td>
		                        <td class="text-gray"><input class="form-control" type="text" maxlength="255"  name="unit" id="unit" placeholder="请输入单位"></td>
		                        <td class="text-center">数量</td>
		                        <td class="text-gray"><input class="form-control" type="text" maxlength="255"  name="amount" id="amount" placeholder="请输入数量"></td>
		                        <td class="text-center">单价</td>
		                        <td class="text-gray"><input class="form-control" type="text" maxlength="255"  name="single_price" id="single_price" placeholder="请输入单价"></td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">交货日期</td>
		                        <td colspan="2"><input type="text"  class="form_datetime form-control"  maxlength="32"  name="End_data" id="end_data" placeholder="请输入交货日期"></td>
		                        <td class="text-center">附件</td>
		                        <td colspan="2"><button class="btn btn-primary" data-toggle="button" onclick="uploadattachment()">请上传附件</button>
					<input class="form-control" type="hidden" maxlength="255"  name="attachment" id="attachmentupload"></td>
		                    </tr>
		                </tbody>
		            </table>
		            <div class="form-group">
					<label class="col-lg-5 control-label"></label>
					<div class="col-lg-6">
						<button type="button" class="btn btn-success" onclick="addZttOrder()">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存</button>
						<button type="button" class="btn default" onclick="resetAll('defaultForm')">
						<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>重置</button>
					</div>
				</div>
		            </form>
                </div>
            </div>
		</fieldset>
	</div>
			<!-- <div class="form-group">
				<label class="col-lg-3 control-label">订单号/申请号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="order_number" placeholder="请输入订单号/申请号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合同号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="contract_number" placeholder="请输入合同号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">客户</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="client" placeholder="请输入客户">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">联系人</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="linkman" placeholder="请输入联系人">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">产品名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="product_name" placeholder="请输入产品名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">规格</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="stardard" placeholder="请输入规格">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">附件</label>
				<div class="col-lg-6">
					<button class="btn btn-primary" data-toggle="button" onclick="uploadattachment()">请上传附件</button>
					<input class="form-control" type="text" maxlength="255"  name="attachment" id="attachment" value="aa">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="unit" placeholder="请输入单位">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">数量</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="amount" placeholder="请输入数量" id="amount">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">销售单价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="single_price" placeholder="请输入销售单价">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">销售总价</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="sum_price" placeholder="请输入销售总价">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">交货日期</label>
				<div class="col-lg-6">
					<input type="text"  class="form_datetime form-control"  maxlength="32"  name="End_data" id="end_data" placeholder="请输入交货日期">
				</div>
			</div> -->
			<!-- <div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZttOrder()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div> -->
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-order/ztt-order-add.js"></script> 
</html>
