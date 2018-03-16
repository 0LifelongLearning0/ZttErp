<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<%@include file="user-choose.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>会议详情页面</title>
<style type="text/css">
.iconUl li {
    width: 160px;
    list-style: none;
    float: left;
    padding: 5px;
}
.iconUl li span {
    width: 100%;
    text-align: center;
    display: block;
    height: 30px;
}
</style>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>会议详细信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<input type="hidden" id="id" value="${zxMeeting.id}">
			<fieldset>
				<legend>基本信息</legend>
				<div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">会议标题</label>
			        </div>
			        <div class="col-md-11">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="100" id="title" name="title" value="${zxMeeting.title}" readOnly>
			        	</div>
			        </div>
			     </div>
			     <div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">开始时间</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control"type="text" id="time_start" name="time_start" value="${zxMeeting.time_start}" readOnly>
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">结束时间</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" id="time_end" name="time_end" value="${zxMeeting.time_end}" readOnly>
			      		</div>
			        </div>
			       <div class="col-md-1">
			        	<label class="control-label">会议室</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="100" value="${zxMeeting.house_name}" readOnly>
			      		</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>参会人员选择</legend>
				<div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">参会人员</label>
			        </div>
			        <div class="col-md-11">
			        	<div class="form-group">
			        		<input class="form-control" type="text" id="user_name_t" readOnly>
			        	</div>
			        </div>
			    </div>
			    <div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">邀请人员</label>
			        </div>
			        <div class="col-md-11">
			        	<div class="form-group">
			        		<input class="form-control" type="text" id="user_name_o" readOnly>
			        	</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>会议附件</legend>
				<div class="row">
					<div class="col-md-1">
			        </div>
			        <div class="col-md-10">
			       		<ul class="iconUl up_file"  id="attach">
			       		</ul>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>会议内容</legend>
				<div class="row">
			        <div class="col-md-1">
			        </div>
			        <div class="col-md-10">
			        	<div class="form-group">
			        		<textarea class="form-control" maxlength="60000" style="heigth:300px" name="content" readOnly>${zxMeeting.content}</textarea>
			        	</div>
			        </div>
			    </div>
			</fieldset>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
	<div class="file-demo" style="display:none">
		<li id="meeting_attach_{index}" src="">
			<input class="form-control" type="hidden" name="zx_meeting_pic" id="zx_meeting_pic_{index}">
			<span class="glyphicon glyphicon-file"></span>
			<span title="{file}" id="file_name_{index}">{file}</span>
		</li>
	</div>	
	<input type="hidden" id="from" value="${from}">
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-meeting/zx-meeting-detail.js"></script> 
</html>
