<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<%@include file="user-choose.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>会议新增页面</title>
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
			<h4>创建会议信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<fieldset>
				<legend>基本信息</legend>
				<div class="row">
			        <div class="col-md-1">
			        	<label class="control-label"><font color="red">*</font>会议标题</label>
			        </div>
			        <div class="col-md-11">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="100" id="title" data-bv-notempty data-bv-notempty-message="请输入会议标题"  name="title" placeholder="请输入会议标题">
			        	</div>
			        </div>
			     </div>
			     <div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">开始时间</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form_datetime form-control" readonly="readonly" id="time_start" name="time_start" placeholder="请选择时间">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">结束时间</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form_datetime form-control" readonly="readonly" id="time_end" name="time_end" placeholder="请选择时间">
			      		</div>
			        </div>
			       <div class="col-md-1">
			        	<label class="control-label">会议室</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<select class="form-control" maxlength="32"  id="house_id" name="house_id" placeholder="请选择"></select>
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
			        <div class="col-md-10">
			        	<div class="form-group input-group">
			        		<input type="hidden" id="user_ids_t" name="user_ids_t">
			        		<input class="form-control" type="text" id="user_name_t" name="user_name_t" readOnly>
			        		<span class="input-group-btn">
								<button class="btn btn-default" type="button" onclick="userModalShow('user_ids_t','user_name_t')">
									选择
								</button>
							</span>
			        	</div>
			        </div>
			    </div>
			    <div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">邀请人员</label>
			        </div>
			        <div class="col-md-10">
			        	<div class="form-group input-group">
			        		<input type="hidden" id="user_ids_o" name="user_ids_o">
			        		<input class="form-control" type="text" id="user_name_o" name="user_name_o" readOnly>
			        		<span class="input-group-btn">
								<button class="btn btn-default" type="button" onclick="userModalShow('user_ids_o','user_name_o')">
									选择
								</button>
							</span>
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
			        	<ul class="iconUl up_file">
			        		<li id="meeting_attach_add" onclick="addFile()">
			        			<span class="glyphicon glyphicon-plus-sign"></span>
			        			<span title="添加附件">添加附件</span>
			        		</li>
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
			        		<textarea class="form-control" maxlength="60000" style="heigth:300px" name="content" placeholder="请输入会议内容"></textarea>
			        	</div>
			        </div>
			    </div>
			</fieldset>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZxMeeting()">保存</button>
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
	<input type="hidden" id="house_list" value='${house_list}'>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-meeting/zx-meeting-add.js"></script> 
</html>
