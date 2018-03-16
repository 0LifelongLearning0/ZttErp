<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>部门信息表(departInfo)详情页面</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<legend><button type="button" onclick="goback()" class="btn btn-default pull-right"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</button>部门信息详情</legend>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-1 control-label bold">上级部门</label>
				<div class="col-lg-3 padding-10">
					<input class="form-control" type="hidden" id="xt_departinfo_parentId" value="${xtDepartinfo.xt_departinfo_parentId }">
					<span id="xt_departinfo_parentName"></span>
				</div>
				<label class="col-lg-1 control-label bold">部门名称</label>
				<div class="col-lg-3 padding-10">${xtDepartinfo.xt_departinfo_name }</div>
			</div>
			<div class="form-group">
				<label class="col-lg-1 control-label bold">联系电话</label>
				<div class="col-lg-3 padding-10">${xtDepartinfo.xt_departinfo_connectTelNo }</div>
				<label class="col-lg-1 control-label bold">移动电话</label>
				<div class="col-lg-3 padding-10">${xtDepartinfo.xt_departinfo_mobileTelNo }</div>
				<label class="col-lg-1 control-label bold">传&emsp;&emsp;真</label>
				<div class="col-lg-3 padding-10">${xtDepartinfo.xt_departinfo_faxes }</div>
			</div>
			<div class="form-group">
				<label class="col-lg-1 control-label bold">描&emsp;&emsp;述</label>
				<div class="col-lg-11 padding-10">${xtDepartinfo.xt_departinfo_desc }</div>
			</div>
			<div class="form-group">
				<label class="col-lg-1 control-label bold">立成时间</label>
				<div class="col-lg-3 padding-10">${xtDepartinfo.xt_departinfo_time }</div>
				<label class="col-lg-1 control-label bold">部门性质</label>
				<div class="col-lg-3 padding-10">${xtDepartinfo.xt_departinfo_type }</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/xt-view/xt-departinfo/xt-departinfo-detail.js"></script> 
</html>
