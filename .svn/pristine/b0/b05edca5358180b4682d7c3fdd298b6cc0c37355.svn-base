<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>基础库存编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑库存</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">库存编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="b_stock_id"  placeholder="请输入库存编号" value="${bStock.b_stock_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户</label>
				<div class="col-lg-6">
					<div class="input-group" style="width:280px;" >
		        		<input class="form-control" type="hidden"  data-bv-notempty data-bv-notempty-message="请选择商户、卖家" placeholder="请选择商户、卖家" name="b_seller_product_id" id="b_seller_product_id" value="${bStock.b_seller_product_id }"/> 
		                <input class="form-control" type="text"readonly="readonly" data-bv-notempty data-bv-notempty-message="请选择商户、卖家" placeholder="请选择商户、卖家" id="b_seller_name" value="${bStock.b_seller_name }"/> 
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;品</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" style="width:280px;"  maxlength="32" readonly="readonly" id="b_product_name" value="${bStock.b_product_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牌</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" style="width:280px;"  maxlength="32" readonly="readonly" id="b_brand_name" value="${bStock.b_brand_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" style="width:280px;"  maxlength="32" readonly="readonly" id="b_category_name" value="${bStock.b_category_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</label>
				<div class="col-lg-6">
					<input class="form-control" maxlength="10" value="0" style="width:120px;" data-bv-numeric data-bv-numeric-message="库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存为数字类型"  name="b_stock_countable_sell" placeholder="请输入库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存" value="${bStock.b_stock_countable_sell }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">可&nbsp;&nbsp;卖&nbsp;数</label>
				<div class="col-lg-6">
					<input class="form-control" maxlength="10" value="0" style="width:120px;" data-bv-numeric data-bv-numeric-message="可&nbsp;&nbsp;卖&nbsp;数为数字类型"  name="b_stock_locks_number" placeholder="请输入可&nbsp;&nbsp;卖&nbsp;数" value="${bStock.b_stock_locks_number }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateBStock()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>

<!-- 商户商品品牌品类模态框（Modal）开始 -->
<div class="modal fade" id="bSellerProductSelectModal" tabindex="-1" role="dialog" aria-labelledby="bSellerProductModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="bSellerProductModalLabel">
					商户、商品、品牌、品类选择器
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel panel-default">
					<fieldset>
						<legend>查询区域</legend>
						<form method="POST" id="searchBSellerProductForm" class="form-inline">
							<div class="form-group">
								<label>商户名称</label>
								<input type="text" class="form-control" name="b_seller_name" placeholder="请输入商户名称">
							</div>
							<div class="form-group">
								<label>电话</label>
								<input type="text" class="form-control" name="b_seller_tel" placeholder="请输入电话">
							</div>
						</form>
						<div class="form-group" style="margin-left: 35px;margin-top: 25px;">
							<button class="btn btn-primary" onclick="search('bSellersDatatables')">
								<i class="glyphicon glyphicon-search"></i>&nbsp;检索
							</button>
							<button class="btn btn-default" onclick="resetAll('searchBSellerProductForm');">重置</button>
						</div>
					</fieldset>
				</div>
				<div class="panel-body">
					<table id="bSellerProductDatatables" class="table table-bordered table-striped table-hover">
						<thead>
							<tr>
								<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkallBSellerProduct" /><span></span></label></th>
								<th>序号</th>
								<th>商户</th>
								<th>商品</th>
								<th>分类</th>
								<th>品牌</th>
								<th>状态</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doBSellerProductSelect();">保存</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<!-- 商户商品品牌品类（Modal）结束 -->

<script type="text/javascript" src="../view/pc/b-view/b-stock/b-stock-update.js"></script> 
</html>
