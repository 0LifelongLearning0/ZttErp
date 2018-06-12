<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表</title>
<style>
#datatables {
	white-space: nowrap;
}
.table tr.row_selected td {
background-color: yellow;
}
</style>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<button style="background-color: #7ED321;width:20px;height:20px;"></button>生产中
			<button style="background-color: #ea9999;width:20px;height:20px;"></button>自制改外协
			<button style="background-color: #b5eaf2;width:20px;height:20px;"></button>外协改自制
			<form method="POST" id="searchForm" class="form-inline">

				<div class="form-group">
					<label>产品名称</label> <input type="text" class="form-control"
						name="product_name" id="product_name" placeholder="请输入标题">
				</div>
				<div class="form-group">
					<label>申请时间</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control"
							placeholder="起始时间" name="apply_time_st" /> <span
							class="input-group-addon">至</span> <input type="text"
							class="form_datetime form-control" placeholder="结束时间"
							name="apply_time_et" />
					</div>
				</div>
				<span style="background-color: #FFFFFF"> &nbsp;&nbsp;&nbsp;</span>
				<div class="form-group">
					<label>类型</label> <select class="form-control" name="cato_type"
						id="cato_type" placeholder="请选择"></select>
				</div>
				<span style="background-color: #FFFFFF"> &nbsp;&nbsp;&nbsp;</span>
				<div class="form-group">
					<label>工令号</label> <input type="text" class="form-control"
						name="product_order_number" id="product_order_number"
						placeholder="请输入工令号">
				</div>
				<span style="background-color: #FFFFFF"> &nbsp;&nbsp;&nbsp;</span>
				<div class="form-group">
					<label>erp号</label> <input type="text" class="form-control"
						name="erp_number" id="erp_number" placeholder="请输入erp号">
				</div>
				<div class="form-group">
					<label>数量</label> <input type="text" class="form-control"
						name="amount" id="amount" placeholder="请输入数量">
				</div>
				</br>
				<div class="form-group">
					<label>供应商</label> <input type="text" class="form-control"
						name="supplier_name" id="supplyer_name" placeholder="请选择供应商">
					<button type="button" class="btn btn-success"
						onclick="selectsupplyer()" id="buttonsave">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>选择
					</button>
				</div>
				<span style="background-color: #FFFFFF"> &nbsp;&nbsp;&nbsp;</span>
				<div class="form-group">
					<label>客户</label> <input type="text" class="form-control"
						name="client" id="client" placeholder="请选择客户">
					<button type="button" class="btn btn-success"
						onclick="selectclient()" id="buttonsave">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>选择
					</button>
				</div>
				<div class="form-group">
					<label>合同号</label> <input type="text" class="form-control"
						name="contract_number" id="contract_number" placeholder="请输入合同号">
				</div>
				<div class="form-group">
					<label>订单号</label> <input type="text" class="form-control"
						name="order_number" id="order_number" placeholder="请输入订单号">
				</div>
				<div class="form-group">
					<label>供应商开票日期</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control"
							placeholder="起始时间" name="apply_time_st_supplier_bill_date" /> <span
							class="input-group-addon">至</span> <input type="text"
							class="form_datetime form-control" placeholder="结束时间"
							name="apply_time_et_supplier_bill_date" />
					</div>
					
				</div>

				<div class="form-group">
					<label>交货日期</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control"
							placeholder="起始时间" name="apply_time_st_End_data" /> <span
							class="input-group-addon">至</span> <input type="text"
							class="form_datetime form-control" placeholder="结束时间"
							name="apply_time_et_End_data" />
					</div>
				</div>
				  <div class="form-group">
					<label>实际交货日期</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control"
							placeholder="起始时间" name="apply_time_st_send_time" /> <span
							class="input-group-addon">至</span> <input type="text"
							class="form_datetime form-control" placeholder="结束时间"
							name="apply_time_et_send_time" />
					</div>
					为空
					<input type="checkbox" name="send_time" id="send_time"/>
				</div>
                   <div class="form-group">
					<label>销售开票日期</label>
					<div class="input-group">
						<input type="text" class="form_datetime form-control"
							placeholder="起始时间" name="apply_time_st_bill_date_open" /> <span
							class="input-group-addon">至</span> <input type="text"
							class="form_datetime form-control" placeholder="结束时间"
							name="apply_time_et_bill_date_open" />
					</div>
					为空
					<input type="checkbox" name="bill_date_open" id="bill_date_open"/>
				</div>
                <div class="form-group">
					<label>成本分摊</label> <input type="text" class="form-control"
						name="cost_share" id="cost_share" placeholder="成本分摊">
				</div>
				 <div class="form-group">
					<label>联系人</label> <input type="text" class="form-control"
						name="linkman" id="linkman" placeholder="联系人">
				</div>
				<div class="form-group">
					<label>工令号批量筛选</label> 
					<div class="input-group"><input type="text" class="form-control"
							placeholder="起始" name="product_order_number_st" /> <span
							class="input-group-addon">至</span> <input type="text"
							class="form-control" placeholder="结束"
							name="product_order_number_et" />
							</div>
				</div>
				<div class="form-group">
					<label>状态</label> 
					<div class="input-group">
					<input type="hidden" class="form-control"
							id='cato_type' name="cato_type" /> 
					<select id='cato_type_selct'>
			<option value ="noselect">未选择</option>		
  <option value ="madebyself">生产中</option>
  <option value ="outside">质检中</option>
                    </select>
							</div>
				</div>
				<div class="form-group" style="margin-left: 35px;">
					<button class="btn btn-primary" type="button"
						onclick="search('datatables')">
						<i class="glyphicon glyphicon-search"></i>&nbsp;检索
					</button>
					<button class="btn btn-default" type="button" onclick="resetAll();">重置</button>
				</div>
				<input class="form-control" type="hidden" maxlength="255"
					name="apply_id" id="apply_id" value='${applyUser.xt_userinfo_id }'>
			</form>
		</fieldset>
	</div>
	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
		<button class="btn btn-default" onclick="batchapply()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>批量修改
			</button>
			<button class="btn btn-default" onclick="toZttOrderAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="toZttOrderUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button class="btn btn-default" onclick="delZttOrder()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button class="btn btn-default" onclick="cancelZttOrder()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>取消
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
			<button class="btn btn-default" onclick="export1()">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>导出
			</button>
			<button class="btn btn-default" onclick="export1All()">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>全部导出
			</button>
		</div>
		<input class="form-control"
									type="hidden" maxlength="255" name="apply_id" id="apply_id" value='${applyUser.xt_userinfo_id }'>
		<table id="datatables"
			class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label
						class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input
							type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>申请日期</th>
					<th>工令号</th>
					<th>客户</th>
					<th>联系人</th>
					<th>产品名称</th>
					<th>规格</th>
					<th>数量</th>
					<th>业务员</th>
					<th>erp号</th>
					<th>订单号/申请号</th>
					<th>合同编号</th>
					<th>类型</th>
					<th>供应商</th>
					<th id="cost_single_price">成本单价</th>
					<th>成本总价</th>
					<th>供应商开票日期</th>
					<th>供应商开票金额</th>
					<th>单位</th>
					<th>销售单价</th>
					<th>销售总价</th>
					<th>交货日期</th>
					<th>实际交货日期</th>
					<th>发货数量</th>
					<th>销售开票日期</th>
					<th>销售开票金额</th>
					<th>成本分摊</th>
					<th>状态</th>
					<th>详情</th>
					<th>审批</th>
					<th>质检</th>
					<th>发货</th>
				</tr>
			</thead>
		</table>
	</div>

</body>
<script type="text/javascript"
	src="../view/pc/zx-view/ztt-order/ztt-order-list.js"></script>
</html>
