<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>员工档案编辑页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑员工档案</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">姓名</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="user_name" readOnly="readOnly" placeholder="请输入姓名" value="${zxStaffRecord.user_name }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序号" value="${zxStaffRecord.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">档案编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="file_num" readOnly="readOnly" placeholder="请输入档案编号" value="${zxStaffRecord.file_num }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">员工编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="user_num" readOnly="readOnly" placeholder="请输入员工编号" value="${zxStaffRecord.user_num }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_user_id" placeholder="请输入员工id" value="${zxStaffRecord.xt_user_id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">部门id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_departinfo_id" placeholder="请输入部门id" value="${zxStaffRecord.xt_departinfo_id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">职务id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_post_id" placeholder="请输入职务id" value="${zxStaffRecord.xt_post_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">部门</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_departinfo_name" data-bv-notempty data-bv-notempty-message="请选择组织机构" placeholder="请选择组织机构" value="${zxStaffRecord.xt_departinfo_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">职务</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_post_name" data-bv-notempty data-bv-notempty-message="请选择组织机构" placeholder="请选择组织机构" value="${zxStaffRecord.xt_post_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">入职时间</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="entry_time"  placeholder="请选择时间" value="${zxStaffRecord.entry_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">试用期薪水</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="6"  name="probation_salary" placeholder="请输入试用期薪水" value="${zxStaffRecord.probation_salary }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">转正日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="confirmation_time"  placeholder="请选择时间" value="${zxStaffRecord.confirmation_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">转正薪水</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="6"  name="confirmation_salary" placeholder="请输入转正薪水" value="${zxStaffRecord.confirmation_salary }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否办理社保卡</label>
				<div class="col-lg-6">
					<input type="hidden" id="social_security_cards_" value="${zxStaffRecord.social_security_cards }">
					<select class="form-control" maxlength="32" value="0"  data-bv-notempty data-bv-notempty-message="请选择是否办理社保卡" name="social_security_cards" id="social_security_cards" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">联系方式</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="11"  name="userinfo_phone" placeholder="请输入联系方式" value="${zxStaffRecord.userinfo_phone }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">公司短号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="4"  name="userinfo_ortherTel" placeholder="请输入公司短号" value="${zxStaffRecord.userinfo_ortherTel }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">身份证号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="18"  name="userinfo_card" placeholder="请输入身份证号" value="${zxStaffRecord.userinfo_card }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">家庭住址</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="family_address" placeholder="请输入家庭住址" value="${zxStaffRecord.family_address }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">现居住地址</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="now_address" placeholder="请输入现居住地址" value="${zxStaffRecord.now_address }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否办理居住证</label>
				<div class="col-lg-6">
					<input type="hidden" id="residence_permit_" value="${zxStaffRecord.residence_permit }">
					<select class="form-control" maxlength="32" id="residence_permit" name="residence_permit" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">学历</label>
				<div class="col-lg-6">
					<input type="hidden" id="userinfo_highestDegree_" value="${zxStaffRecord.userinfo_highestDegree }">
					<select class="form-control" type="text" maxlength="32" id="userinfo_highestDegree" name="userinfo_highestDegree" placeholder="请选择学历">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">毕业学校</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="50"  name="userinfo_schoolName" placeholder="请输入毕业学校" value="${zxStaffRecord.userinfo_schoolName }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">专业</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="30"  name="specialty" placeholder="请输入专业" value="${zxStaffRecord.specialty }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">承诺书</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="etter_of_commitment" placeholder="请输入承诺书" value="${zxStaffRecord.etter_of_commitment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">离职日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="dimission_time"  placeholder="请选择时间" value="${zxStaffRecord.dimission_time }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="remark" placeholder="请输入备注" value="${zxStaffRecord.remark }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZxStaffRecord()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-staff-record/zx-staff-record-update.js"></script> 
</html>
