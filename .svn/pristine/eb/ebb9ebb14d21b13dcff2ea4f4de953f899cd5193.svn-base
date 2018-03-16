<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>岗位详情</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<legend><button type="button" onclick="goback()" class="btn btn-default pull-right"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</button>岗位详情</legend>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-1 control-label bold">隶属部门</label>
				<div class="col-lg-3 padding-10">${xtPost.xt_departinfo_name }</div>
				<label class="col-lg-1 control-label bold">上级岗位</label>
				<div class="col-lg-3 padding-10">
					<input class="form-control" type="hidden" maxlength="32"  name="xt_post_parentId" id="xt_post_parentId" placeholder="请输入上级岗位" value="${xtPost.xt_post_parentId }">
					<span id="xt_post_parentName"></span>
				</div>
				<label class="col-lg-1 control-label bold">岗位名称</label>
				<div class="col-lg-3 padding-10">${xtPost.xt_post_name }</div>
			</div>
			<div class="form-group">
				<label class="col-lg-1 control-label bold">岗位描述</label>
				<div class="col-lg-11 padding-10">${xtPost.xt_post_desc }</div>
			</div>
			<div class="form-group">
				<label class="col-lg-1 control-label bold">岗位最大人数</label>
				<div class="col-lg-3 padding-10">${xtPost.xt_post_maxNum }</div>
				<label class="col-lg-1 control-label bold">岗位级别</label>
				<div class="col-lg-3 padding-10">${xtPost.xt_post_grade }</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/xt-view/xt-post/xt-post-detail.js"></script> 
</html>
