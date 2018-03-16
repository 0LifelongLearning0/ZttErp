<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>发放电话卡</title>
</head>
<body>
	<input type="hidden" id="id1" value="${zxApplyPhoneCard.apply_matter }">
	<div class="panel-body">
		<div class="page-header">
			<h4>发放电话卡</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">申请状态</label>
				<div class="col-lg-6">
				<input type="hidden" id="status_" value="${zxApplyPhoneCard.status }">
					<select class="form-control" maxlength="32" disabled="disabled" data-bv-notempty data-bv-notempty-message="请选择状态" name="status" id="status" placeholder="请选择"></select>
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">id</label>
				<div class="col-lg-6">
				<input class="form-control" maxlength="32" data-bv-notempty data-bv-notempty-message="请输入id" name="id" value="${zxApplyPhoneCard.id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
				<input class="form-control" readOnly="readonly" name="apply_user_id" value="${zxApplyPhoneCard.apply_user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">姓名</label>
				<div class="col-lg-6">
				<input class="form-control" readOnly="readonly" name="xt_user_name" value="${zxApplyPhoneCard.xt_user_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">部门</label>
				<div class="col-lg-6">
				<input class="form-control" readOnly="readonly" name="zxcardepart" value="${zxcardepart }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">申请时间</label>
				<div class="col-lg-6">
				<input class="form-control" readOnly="readonly" name="apply_time" value="${zxApplyPhoneCard.apply_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">申请原因</label>
				<div class="col-lg-6">
				<input class="form-control" readOnly="readonly" data-bv-notempty data-bv-notempty-message="请输入申请原因" placeholder="请输入申请原因" name="description" value="${zxApplyPhoneCard.description }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">申请事项</label>
					<label class="radio-inline">
				        <input type="radio" disabled="disabled" name="apply_matter" id="optionsRadios1" value="1"> 初次申请
				    </label>
				    <label class="radio-inline">
				        <input type="radio" disabled="disabled" name="apply_matter" id="optionsRadios2" value="2"> 出差
				    </label>
				    <label class="radio-inline">
				        <input type="radio" disabled="disabled" name="apply_matter" id="optionsRadios3" value="3"> 申请调整
				    </label>
				    <label class="radio-inline">
				        <input type="radio" disabled="disabled" name="apply_matter" id="optionsRadios4" value="4"> 加入集团网
				    </label>
				    <label class="radio-inline">
				        <input type="radio" disabled="disabled" name="apply_matter" id="optionsRadios5" value="5"> 其他   <input style="display:none" name="apply_matter" id="other">
				    </label>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">电话套餐</label>
				<div class="col-lg-6">
				<select class="form-control" value="0" data-bv-notempty data-bv-notempty-message="请选择电话套餐" placeholder="请选择 " id="phone_card_set">
				</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">集团号</label>
				<div class="col-lg-6">
				<input class="form-control" data-bv-notempty data-bv-notempty-message="请输入集团号" placeholder="请输入集团号 " id="phone_card" name="phone_card">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZxApplyPhoneCardBySelective()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-grant-phone-card/zx-apply-phone-card-grant.js"></script> 
</html>
