<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>会议室列表</title>
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
#attachRecordModal{
	z-index:888 !important;
}
.modal-backdrop{
	z-index:700 !important;
}
</style>
</head>
<body>  
	<div class="panel panel-default padding-10 no-margin">
	</div>
	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
			<button class="btn btn-default" onclick="toZxMeetingDetail()">
				<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>详情
			</button>
			<button class="btn btn-default" onclick="toZxMeetingAttach()">
				<span class="glyphicon glyphicon-file" aria-hidden="true"></span>查看附件
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
					<th>会议主题</th>
					<th>类型</th>
					<th>邀请日期</th>
				</tr>
			</thead>
		</table>
	</div>
	<input type="hidden" id="from" value="${from}">
</body> 
<div class="modal fade" id="attachModal" tabindex="-1" role="dialog" aria-labelledby="attachLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="attachLabel">
					查看附件
				</h4>
			</div>
			<div class="modal-body">
				<legend>会议附件</legend>
				<fieldset>
					<div class="row">
						<div class="col-md-1">
				        </div>
				        <div class="col-md-10">
				        	<ul class="iconUl up_file attach-1">
				        	</ul>
				        </div>
				    </div>
				</fieldset>
				<legend>会议记录</legend>
				<fieldset>
					<div class="row">
						<div class="col-md-1">
				        </div>
				        <div class="col-md-10">
				        	<ul class="iconUl up_file attach-2">
				        	</ul>
				        </div>
				    </div>
				</fieldset>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<div class="file-demo " style="display:none">
	<li id="meeting_attach_{index}" src="" class="{del_class}">
		<input class="form-control" type="hidden" name="zx_meeting_pic" id="zx_meeting_pic_{index}">
		<span class="glyphicon glyphicon-file"></span>
		<span title="{file}" id="file_name_{index}">{file}</span>
	</li>
</div>	
<script type="text/javascript" src="../view/pc/zx-view/zx-meeting/zx-meeting-list-view.js"></script>  
</html> 