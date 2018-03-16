<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>供应商新增页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建供应商信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<fieldset>
				<legend>基本信息</legend>
				<div class="row">
			        <div class="col-md-1">
			        	<label class="control-label"><font color="red">*</font>名称</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="255" style="width: 150px;" id="name" data-bv-notempty data-bv-notempty-message="请输入供应商名称"  name="name" placeholder="请输入供应商名称">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">代码</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="32" style="width: 150px;" id="num" name="num" />
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">类别</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<select class="form-control" maxlength="32" id="classify"  style="width: 150px;" name="classify" placeholder="请选择"></select>
			      		</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">类型</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<select class="form-control" maxlength="32" id="type"  style="width: 150px;" name="type" placeholder="请选择"></select>
			      		</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>联系方式</legend>
				<div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">联系人</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="255" style="width: 150px;" id="contact_person" name="contact_person" >
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">联系方式</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="40" style="width: 150px;" id="phone" name="phone" onkeyup="value=value.replace(/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/,'')">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">职务</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<select class="form-control" maxlength="32" id="title"  style="width: 150px;" name="title" placeholder="请选择"></select>
			      		</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">传真</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input type="text" class="form-control" maxlength="40" id="fax"  style="width: 150px;" name="fax" onkeyup="value=value.replace(/^(\d{3,4}-)?\d{7,8}$/,'')"></input>
			      		</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">QQ</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input type="text" class="form-control" maxlength="20" id="qq"  style="width: 150px;" name="qq" onkeyup="value=value.replace(/[1-9][0-9]{4,}/,'')"></input>
			      		</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">邮箱</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input type="text" class="form-control" maxlength="100" id="email"  style="width: 150px;" name="email" onkeyup="value=value.replace(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/,'')"></input>
			      		</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">公司地址</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input type="text" class="form-control" maxlength="255" id="address"  style="width: 150px;" name="address"></input>
			      		</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">公司网址</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input type="text" class="form-control" maxlength="100" id="web"  style="width: 150px;" name="web"></input>
			      		</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>付款信息</legend>
				<div class="row">
					<div class="col-md-1">
			        	<label class="control-label">付款方式</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<select class="form-control" maxlength="32" id="pay_type"  style="width: 150px;" name="pay_type" placeholder="请选择"></select>
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">开户银行</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="255" style="width: 150px;" id="bank_id" name="bank_id">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">银行账号</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="255" style="width: 150px;" id="bank_account" name="bank_account">
			      		</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>其他信息</legend>
				<div class="row">
					<div class="col-md-1">
			        	<label class="control-label">是否联系</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<select class="form-control" maxlength="32" id="is_connect"  style="width: 150px;" name="is_connect" placeholder="请选择"></select>
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">经营状况</label>
			        </div>
			        <div class="col-md-5">
			        	<div class="form-group">
			        		<textarea class="form-control" cols="100" maxlength="255"  name="operation_status" placeholder="请输入经营状况"></textarea>
			        	</div>
			        </div>
			    </div>
			</fieldset>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZxSupplier()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-supplier/zx-supplier-add.js"></script> 
</html>
