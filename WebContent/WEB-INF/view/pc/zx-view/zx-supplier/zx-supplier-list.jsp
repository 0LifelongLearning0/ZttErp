<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>供应商列表</title>
</head>
<body>  
	<input type="hidden" id="permission" value="${permission}"/>
	<input type="hidden" id="isAdmin" value="${isAdmin}"/>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
				<div class="form-group">
					<label>供应商名称</label>
					<input type="text" class="form-control" name="name" placeholder="请输入供应商">
				</div>
				<div class="form-group">
					<label>类别</label>
					<select class="form-control" name="classify" id="classify" placeholder="请选择"></select>
				</div>
				<div class="form-group">
					<label>类型</label>
					<select class="form-control" name="type" id="type" placeholder="请选择"></select>
				</div>
				<div class="form-group" style="margin-left: 35px;">
					<button class="btn btn-primary" type="button" onclick="search('datatables')">
						<i class="glyphicon glyphicon-search"></i>&nbsp;检索
					</button>
					<button class="btn btn-default" type="button" onclick="resetAll();">重置</button>
				</div>
			</form>
		</fieldset>
	</div>
	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
			<button class="btn btn-default" onclick="toZxSupplierAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button class="btn btn-default" onclick="toZxSupplierUpdate()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button class="btn btn-default" onclick="toZxSupplierDetail()">
				<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>明细
			</button>
			<button class="btn btn-default" onclick="delZxSupplier()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>供应商名称</th>
					<th>类别</th>
					<th>供应商代码</th>
					<th>付款方式</th>
					<th>类型</th>
					<th>验厂状态</th>
					<th>验厂结果</th>
					<th>评审周期</th>
					<th>上次再评审时间</th>
					<th>上次再评审结果</th>
					<th>是否有再评审</th>
					<th>验厂次数</th>
					<th>创建日期</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
</body> 
<script type="text/javascript" src="../view/pc/zx-view/zx-supplier/zx-supplier-list.js"></script>  
</html> 