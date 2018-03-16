<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>员工档案</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
				<div class="form-group">
					<label>姓名</label>
					<input type="text" class="form-control" name="xt_userinfo_realName" placeholder="请输入姓名">
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
			<button class="btn btn-default" onclick="ZxChangeContractUserChoose()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加选择人员
			</button>
			<button class="btn btn-default" onclick="search('datatables')">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>
			<button class="btn btn-default" onclick="goback()">
				<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>返回
			</button>
		</div>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" class="checkall" /><span></span></label></th>
					<th>序号</th>
					<th>姓名</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-change-contract/zx-change-contract-user-choose.js"></script> 
</html>
