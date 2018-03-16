<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<%@ include file="/deng/include/inplugboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>员工信息表编辑页面</title>
</head>
<body>
	<div class="panel-body panel-default padding-10 no-margin">
		<legend><button type="button" onclick="goback()" class="btn btn-default pull-right"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</button>编辑员工信息表</legend>
		<form class="form-horizontal" id="defaultForm" method="post">
			<fieldset>
				<legend>组织机构</legend>
				<div class="row col-md-12">
			         <div class="col-md-1">
			        	<label class="control-label">隶属部门</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group input-group">
			        		<input type="hidden" maxlength="32"  name="xt_departinfo_id" id="xt_departinfo_id" value="${xtUserinfo.xt_departinfo_id }">
			        		<input type="hidden" maxlength="32"  name="xt_userinfo_id" value="${xtUserinfo.xt_userinfo_id }">
							<input class="form-control" type="text" maxlength="32" readonly="readonly" id ="xt_departinfo_name"  name="xt_departinfo_name"  value="${xtUserinfo.xt_departinfo_name }" placeholder="请选择隶属部门" >
							<span class="input-group-btn">
								<button class="btn btn-default" type="button" onclick="departSelect()">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">隶属岗位</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group input-group">
			        		<input type="hidden" maxlength="32"  name="xt_post_id" id="xt_post_id" value="${xtUserinfo.xt_post_id }">
							<input class="form-control" type="text"  maxlength="32" readonly="readonly" id="xt_post_name" name="xt_post_name"  value="${xtUserinfo.xt_post_name }" placeholder="请选择岗位">
							<span class="input-group-btn" style="margin-left: 0px;">
								<button class="btn btn-default" type="button" onclick="postSelect()">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
			<legend>基本信息</legend>
				<div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label">用户名称</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input class="form-control" type="hidden" maxlength="64" id="xt_userinfo_name_"  value="${xtUserinfo.xt_userinfo_name}">
			        		<input class="form-control" type="text" maxlength="64" onblur="validateUser(this);" id="xt_userinfo_name"  value="${xtUserinfo.xt_userinfo_name }" data-bv-notempty data-bv-notempty-message="请输入用户名"  name="xt_userinfo_name" placeholder="请输入用户名">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">真实姓名</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="30" data-bv-notempty data-bv-notempty-message="请输入真实姓名"   name="xt_userinfo_realName" value="${xtUserinfo.xt_userinfo_realName }" placeholder="请输入真实姓名">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">性&emsp;&emsp;别</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input type="hidden" id="xt_userinfo_sex_" value="${xtUserinfo.xt_userinfo_sex }">
			        		<select class="form-control" maxlength="32" id="xt_userinfo_sex" name="xt_userinfo_sex" placeholder="请选择" ></select>
			        	</div>
			        </div>
			    </div>
				<div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label">联系电话</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="30"  name="xt_userinfo_phone" value="${xtUserinfo.xt_userinfo_phone }" placeholder="请输入联系电话">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">移动电话</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="20"  name="xt_userinfo_mobile" value="${xtUserinfo.xt_userinfo_mobile }" placeholder="请输入移动电话">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">其他电话</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="20" name="xt_userinfo_ortherTel" value="${xtUserinfo.xt_userinfo_ortherTel }" placeholder="请输入其他电话">
			        	</div>
			        </div>
			    </div>
			    <div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label">QQ号码</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="12" name="xt_userinfo_qq" value="${xtUserinfo.xt_userinfo_qq }" placeholder="请输入qq号码">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">电子邮件</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input class="form-control" type="text" maxlength="50" name="xt_userinfo_email" value="${xtUserinfo.xt_userinfo_email }" placeholder="请输入电子邮件">
			        	</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">状&emsp;&emsp;态</label>
			        </div>
			        <div class="col-md-3">
			        	<div class="form-group">
			        		<input type="hidden" id="xt_userinfo_state_" value="${xtUserinfo.xt_userinfo_state }">
			        		<select class="form-control" maxlength="32" id="xt_userinfo_state" name="xt_userinfo_state" placeholder="请选择状态"></select>
			        	</div>
				    </div>
				</div>
				<div class="row col-md-12">
			        <div class="col-md-1">
			        	<label class="control-label">备&emsp;&emsp;注</label>
			        </div>
			        <div class="col-md-11">
			        	<div class="form-group">
			        		<textarea class="form-control" cols="100" maxlength="200"  name="xt_userinfo_remark" placeholder="请输入备注">${xtUserinfo.xt_userinfo_ortherTel }</textarea>
			        	</div>
			        </div>
			    </div>
			</fieldset>
			<div class="form-group">
				<label class="col-lg-5 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn btn-success" onclick="updateXtUserinfo()">
					<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存</button>
					<button type="button" class="btn default" onclick="resetAll('defaultForm')">
					<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>重置</button>
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
<!-- 岗位选择器模态框（Modal）结束 -->
<script type="text/javascript" src="../view/pc/xt-view/xt-userinfo/xt-userinfo-update.js"></script> 
</html>
