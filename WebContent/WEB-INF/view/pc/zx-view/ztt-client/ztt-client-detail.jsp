<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>客户管理详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>客户管理详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">ID</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入ID" value="${zttClient.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">客户名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="name" placeholder="请输入客户名称" value="${zttClient.name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">类别</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="classify" placeholder="请输入类别" value="${zttClient.classify }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">客户代码</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="num" placeholder="请输入客户代码" value="${zttClient.num }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">地址</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="address" placeholder="请输入地址" value="${zttClient.address }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">联系人</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="50"  name="contact_person" placeholder="请输入联系人" value="${zttClient.contact_person }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">职务</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="title" placeholder="请输入职务" value="${zttClient.title }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">传真</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="40"  name="fax" placeholder="请输入传真" value="${zttClient.fax }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">联系方式</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="40"  name="phone" placeholder="请输入联系方式" value="${zttClient.phone }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">QQ</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="20"  name="qq" placeholder="请输入QQ" value="${zttClient.qq }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">web</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  name="web" placeholder="请输入web" value="${zttClient.web }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">邮箱</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  name="email" placeholder="请输入邮箱" value="${zttClient.email }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">付款方式</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="pay_type" placeholder="请输入付款方式" value="${zttClient.pay_type }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">开户银行</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  name="bank_id" placeholder="请输入开户银行" value="${zttClient.bank_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">银行账号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="bank_account" placeholder="请输入银行账号" value="${zttClient.bank_account }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">客户经营状况</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="operation_status" placeholder="请输入客户经营状况" value="${zttClient.operation_status }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">类型</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="type" placeholder="请输入类型" value="${zttClient.type }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否联系：1-是，0-否</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="is_connect" placeholder="请输入是否联系：1-是，0-否" value="${zttClient.is_connect }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">已验厂次数</label>
				<div class="col-lg-6">
					<input class="form-control" maxlength="10" value="0"  data-bv-numeric data-bv-numeric-message="已验厂次数为数字类型"  name="yc_num" placeholder="请输入已验厂次数" value="${zttClient.yc_num }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">状态：1-正常，0-删除</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="yc_status" placeholder="请输入状态：1-正常，0-删除" value="${zttClient.yc_status }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">验厂结果：1-合格，2-不合格，3-整改</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="yc_grade" placeholder="请输入验厂结果：1-合格，2-不合格，3-整改" value="${zttClient.yc_grade }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">是否有再评审：1-是，0-否</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="is_judge" placeholder="请输入是否有再评审：1-是，0-否" value="${zttClient.is_judge }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">上次评审时间</label>
				<div class="col-lg-6">
					<input class="form-control" maxlength="10" value="0"  data-bv-numeric data-bv-numeric-message="上次评审时间为数字类型"  name="judge_date" placeholder="请输入上次评审时间" value="${zttClient.judge_date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">评审周期：1-年，2-季度，3-月</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="judge_cycle" placeholder="请输入评审周期：1-年，2-季度，3-月" value="${zttClient.judge_cycle }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">再评审等级：0-无，1-I级考核标准，2-Ⅱ级考核标准,3-Ⅲ级考核标准，4-不合格，直接淘汰</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="judge_grade" placeholder="请输入再评审等级：0-无，1-I级考核标准，2-Ⅱ级考核标准,3-Ⅲ级考核标准，4-不合格，直接淘汰" value="${zttClient.judge_grade }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">状态：1-正常，0-删除</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  name="state" placeholder="请输入状态：1-正常，0-删除" value="${zttClient.state }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">创建日期</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="create_date"  placeholder="请选择时间" value="${zttClient.create_date }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/ztt-client/ztt-client-detail.js"></script> 
</html>
