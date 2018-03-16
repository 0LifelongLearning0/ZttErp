<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>公积金台账编辑页面</title>
<link rel="stylesheet" href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑公积金台账</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">序号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入序号" value="${zxReservedFunds.id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">部门id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_departinfo_id" placeholder="请输入部门id" value="${zxReservedFunds.xt_departinfo_id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">员工id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="xt_user_id" placeholder="请输入员工id" value="${zxReservedFunds.xt_user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">员工</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" readonly="readonly" name="xt_userinfo_realName" placeholder="请输入员工id" value="${zxReservedFunds.xt_userinfo_realName }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">部门</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32" onclick="departSelect()" name="xt_departinfo_name" placeholder="请选择部门" value="${zxReservedFunds.xt_departinfo_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">年</label>
				<div class="col-lg-6">
					<input type="hidden" id="annum_" value="${zxReservedFunds.annum }">
					<select class="form-control" type="text" maxlength="10" id="annum" name="annum" placeholder="请选择年份">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">月</label>
				<div class="col-lg-6">
					<input type="hidden" id="month_" value="${zxReservedFunds.month }">
					<select class="form-control" type="text" maxlength="10" id="month" name="month" placeholder="请选择月份">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">新基数</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" data-bv-notempty data-bv-notempty-message="请输入新基数" name="cardinal_num" onkeyup="var p2 = parseFloat(value).toFixed(2);value = p2>=0?(/\.0?$/.test(value)?value:p2.replace(/0$/,'').replace(/\.0$/,'')):''" maxlength="10" placeholder="请输入新基数" value="${zxReservedFunds.cardinal_num }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位缴存</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" data-bv-notempty data-bv-notempty-message="请输入单位缴存" onchange="toSum()" onkeyup="var p2 = parseFloat(value).toFixed(2);value = p2>=0?(/\.0?$/.test(value)?value:p2.replace(/0$/,'').replace(/\.0$/,'')):''" maxlength="10" id="company_payment" name="company_payment" placeholder="请输入单位缴存" value="${zxReservedFunds.company_payment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">个人缴存</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" data-bv-notempty data-bv-notempty-message="请输入个人缴存" onchange="toSum()" id="person_payment" name="person_payment" onkeyup="var p2 = parseFloat(value).toFixed(2);value = p2>=0?(/\.0?$/.test(value)?value:p2.replace(/0$/,'').replace(/\.0$/,'')):''" maxlength="10" placeholder="请输入个人缴存" value="${zxReservedFunds.person_payment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">合计</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="10" id="sum_payment" name="sum_payment" placeholder="请输入合计" value="${zxReservedFunds.sum_payment }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">个人账号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="40"  name="person_account" data-bv-notempty data-bv-notempty-message="请输入个人账号" placeholder="请输入个人账号" value="${zxReservedFunds.person_account }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="remark" placeholder="请输入备注" value="${zxReservedFunds.remark }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="updateZxReservedFunds()">保存</button>
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
<script type="text/javascript" src="../view/pc/zx-view/zx-reserved-funds/zx-reserved-funds-update.js"></script> 
</html>
