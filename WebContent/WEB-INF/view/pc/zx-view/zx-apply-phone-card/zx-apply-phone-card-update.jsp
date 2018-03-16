<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>电话卡申请编辑页面</title>
</head>
<body>
<input type="hidden" id="id1" value="${zxApplyPhoneCard.apply_matter }">
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑电话卡申请</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">id</label>
				<div class="col-lg-6">
				<input class="form-control" maxlength="32" data-bv-notempty data-bv-notempty-message="请输入id" name="id" value="${zxApplyPhoneCard.id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">申请人</label>
				<div class="col-lg-6">
				<input class="form-control" maxlength="32" data-bv-notempty data-bv-notempty-message="请输入申请人" name="apply_user_id" value="${zxApplyPhoneCard.apply_user_id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">申请时间</label>
				<div class="col-lg-6">
				<input class="form_datetime form-control" data-bv-notempty data-bv-notempty-message="请输入申请时间" name="apply_time" value="${zxApplyPhoneCard.apply_time }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">申请状态</label>
				<div class="col-lg-6">
				<input class="form-control" data-bv-notempty data-bv-notempty-message="请输入申请时间" name="status" value="${zxApplyPhoneCard.status }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">申请原因</label>
				<div class="col-lg-6">
				<input class="form-control" data-bv-notempty data-bv-notempty-message="请输入申请原因" placeholder="请输入申请原因" name="description" value="${zxApplyPhoneCard.description }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">申请事项</label>
					<label class="radio-inline">
				        <input type="radio" name="apply_matter" id="optionsRadios1" value="1"> 初次申请
				    </label>
				    <label class="radio-inline">
				        <input type="radio" name="apply_matter" id="optionsRadios2" value="2"> 出差
				    </label>
				    <label class="radio-inline">
				        <input type="radio" name="apply_matter" id="optionsRadios3" value="3"> 申请调整
				    </label>
				    <label class="radio-inline">
				        <input type="radio" name="apply_matter" id="optionsRadios4" value="4"> 加入集团网
				    </label>
				    <label class="radio-inline">
				        <input type="radio" name="apply_matter" id="optionsRadios5" value="5"> 其他   <input style="display:none" name="apply_matter" id="other">
				    </label>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZxApplyPhoneCard()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-apply-phone-card/zx-apply-phone-card-update.js"></script> 
</html>
