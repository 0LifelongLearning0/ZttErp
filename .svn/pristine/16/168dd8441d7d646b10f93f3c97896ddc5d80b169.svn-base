<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>办公用品管理新增页面</title>
<link rel="stylesheet" href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>创建办公用品管理</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group">
				<label class="col-lg-3 control-label">分类</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  id="classify_name" name="classify_name" placeholder="请选择分类" onclick="GoodsSelect()">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">分类id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"   id="classify_id" name="classify_id" placeholder="请输入办公用品名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">办公用品名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  id=name" name="name" placeholder="请输入办公用品名称">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">办公用品id</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  id="office_id" name="office_id" placeholder="请输入办公用品名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">规格型号</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  id="standard" name="standard" placeholder="请输入办公用品名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">单位</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="100"  id="unit" name="unit" placeholder="请输入办公用品名称">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="addZxOffice()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<div class="modal fade" id="departSelectModal" tabindex="-1" role="dialog" aria-labelledby="departSelectModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="departSelectModalLabel">
					用品选择器
				</h4>
			</div>
			<div class="modal-body">
				<ul id="tree" class="ztree"></ul>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doGoodsSelect()">保存</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<script type="text/javascript" src="../view/pc/zx-view/zx-office/zx-office-add.js"></script> 
</html>
