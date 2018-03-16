<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<%@ include file="/deng/include/inplugboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>员工信息表详情页面</title>
</head>
<body>
	<div class="panel-body panel-default padding-10 no-margin">
		<legend><button type="button" onclick="goback()" class="btn btn-default pull-right"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</button>员工信息表详情</legend>
		<form class="form-horizontal" id="defaultForm" method="post">
			<fieldset>
				<legend>组织机构</legend>
				<div class="row col-md-12">
			         <div class="col-md-1">
			        	<label class="control-label bold">隶属部门</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_departinfo_name }</div>
			        <div class="col-md-1">
			        	<label class="control-label bold">隶属岗位</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_post_name }</div>
			    </div>
			</fieldset>
			<fieldset>
			<legend>基本信息</legend>
				<div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label bold">用户名称</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_userinfo_name}</div>
			        <div class="col-md-1">
			        	<label class="control-label bold">真实姓名</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_userinfo_realName }</div>
			        <div class="col-md-1">
			        	<label class="control-label bold">性&emsp;&emsp;别</label>
			        </div>
			        <div class="col-md-3 padding-10"><input type="hidden" value="${xtUserinfo.xt_userinfo_sex }" id="gender"><span id="gender_text"></span></div>
			    </div>
				<div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label bold">联系电话</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_userinfo_phone }</div>
			        <div class="col-md-1">
			        	<label class="control-label bold">移动电话</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_userinfo_mobile }</div>
			        <div class="col-md-1">
			        	<label class="control-label bold">其他电话</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_userinfo_ortherTel }</div>
			    </div>
			    <div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label bold">QQ号码</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_userinfo_qq }</div>
			        <div class="col-md-1">
			        	<label class="control-label bold">电子邮件</label>
			        </div>
			        <div class="col-md-3 padding-10">${xtUserinfo.xt_userinfo_email }</div>
			        <div class="col-md-1">
			        	<label class="control-label bold">状&emsp;&emsp;态</label>
			        </div>
			        <div class="col-md-3 padding-10"><input type="hidden" value="${xtUserinfo.xt_userinfo_state }" id="xt_userinfo_state"><span id="xt_userinfo_state_text"></span></div>
				</div>
				<div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label bold">备&emsp;&emsp;注</label>
			        </div>
			        <div class="col-md-11 padding-10">${xtUserinfo.xt_userinfo_ortherTel }</div>
			    </div>
			</fieldset>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/xt-view/xt-userinfo/xt-userinfo-detail.js"></script> 
</html>
