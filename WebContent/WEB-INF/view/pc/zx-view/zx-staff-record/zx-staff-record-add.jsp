<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>员工档案新增页面</title>
<link rel="stylesheet" href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建员工档案</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">   
				<label class="col-lg-3 control-label">姓名</label>   
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" onclick="toChooseUser()" value="${user_name }" id="user_name" name="user_name" placeholder="请选择员工">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">档案编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="file_num" data-bv-notempty data-bv-notempty-message="请输入档案编号" placeholder="请输入档案编号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">员工编号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="user_num" data-bv-notempty data-bv-notempty-message="请输入员工编号" placeholder="请输入员工编号">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" value="${xt_user_id }" id="xt_user_id" name="xt_user_id" placeholder="请输入员工id">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">部门id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" id="xt_departinfo_id" name="xt_departinfo_id" placeholder="请输入部门id">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">部门</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" readOnly="readonly" maxlength="32" id="xt_departinfo_name" data-bv-notempty data-bv-notempty-message="请选择部门" name="xt_departinfo_name" placeholder="请选择">
				</div>
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" onclick="departSelect()">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">职务id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" id="xt_post_id" name="xt_post_id" placeholder="请输入职务id">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">职务</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" id="xt_post_name" data-bv-notempty data-bv-notempty-message="请选择岗位" name="xt_post_name" placeholder="请选择">
				</div>
				<span class="input-group-btn" style="margin-left: 0px;">
					<button class="btn btn-default" type="button" onclick="postSelect()">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">入职时间</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="entry_time" data-bv-notempty data-bv-notempty-message="请选择入职时间" placeholder="请选择时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">试用期薪水</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="6" data-bv-notempty data-bv-notempty-message="请输入试用期薪水" name="probation_salary" placeholder="请输入试用期薪水">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">转正日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="confirmation_time"  placeholder="请选择时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">转正薪水</label>
				<div class="col-lg-6">
					<input class="form-control" type="number" maxlength="6"  name="confirmation_salary" placeholder="请输入转正薪水">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否办理社保卡</label>
				<div class="col-lg-6">
					<select class="form-control" maxlength="32" id="social_security_cards" name="social_security_cards" data-bv-notempty data-bv-notempty-message="请选择是否办理社保卡" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">联系方式</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="11" id="userinfo_phone" name="userinfo_phone" placeholder="请输入联系方式">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">公司短号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="4"  name="userinfo_ortherTel" placeholder="请输入公司短号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">身份证号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="18"  name="userinfo_card" placeholder="请输入身份证号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">家庭住址</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="family_address" placeholder="请输入家庭住址">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">现居住地址</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="now_address" placeholder="请输入现居住地址">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否办理居住证</label>
				<div class="col-lg-6">
					<select class="form-control" maxlength="32" id="residence_permit" name="residence_permit" data-bv-notempty data-bv-notempty-message="请选择是否办理居住证" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">学历</label>
				<div class="col-lg-6">
					<select class="form-control" maxlength="32" id="userinfo_highestDegree" name="userinfo_highestDegree" data-bv-notempty data-bv-notempty-message="请选择学历" placeholder="请选择">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">毕业学校</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="50"  name="userinfo_schoolName" placeholder="请输入毕业学校">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">专业</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="30"  name="specialty" placeholder="请输入专业">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">承诺书</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="etter_of_commitment" placeholder="请输入承诺书">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">离职日期</label>
				<div class="col-lg-6">
					<input class="form_date form-control" name="dimission_time"  placeholder="请选择时间">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="remark" placeholder="请输入备注">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZxStaffRecord()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<!-- 部门选择器模态框（Modal）开始 -->
<div class="modal fade col-md-8 col-md-offset-2" id="departSelectModal" tabindex="-1" role="dialog" aria-labelledby="departSelectModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="departSelectModalLabel">
					部门选择器
				</h4>
			</div>
			<div class="modal-body">
				<ul id="tree" class="ztree"></ul>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doDepartSelect()">保存</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<!-- 部门选择器模态框（Modal）结束 -->

<!-- 岗位选择器模态框（Modal）开始 -->
<div class="modal fade col-md-8 col-md-offset-2" id="postSelectModal" tabindex="-1" role="dialog" aria-labelledby="postSelectModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="postSelectModalLabel">
					岗位选择器
				</h4>
			</div>
			<div class="modal-body">
				<ul id="posttree" class="ztree"></ul>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doPostSelect()">保存</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<script type="text/javascript" src="../view/pc/zx-view/zx-staff-record/zx-staff-record-add.js"></script> 
</html>
