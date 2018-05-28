<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>模具部工序详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>模具部工序详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none;">
				<label class="col-lg-3 control-label">id</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="id"  placeholder="请输入id" value="${zttMouldsGongxu.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">工序名称</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="gongxu_name" placeholder="请输入工序名称" value="${zttMouldsGongxu.gongxu_name }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="zttMouldsDeivice_removed_flag" id="zttMouldsDeivice_removed_flag" >
					<input class="form-control" type="hidden" value="${fn:length(zttMouldsGongxu.zttMouldsDeivice) }" name="zttMouldsDeiviceFormNumber" id="zttMouldsDeiviceFormNumber" >
				</div>
			</div>
			<!-- 一对多子表开始（工序设备） -->
			<div class="page-header">
				<h4>工序设备</h4>
			</div>
			<div class="form_zttMouldsDeivice">
			<c:forEach var="zttMouldsDeivice" items="${zttMouldsGongxu.zttMouldsDeivice }" varStatus="zttMouldsDeiviceStatus">
				<div id="form_zttMouldsDeivice_${zttMouldsDeiviceStatus.index}">
			<fieldset>
			<legend><h5>序号${zttMouldsDeiviceStatus.index+1}</h5></legend>
					<div class="form-group">
						<label class="col-lg-3 control-label">设备名称</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="255"  id="zttMouldsDeivice[${zttMouldsDeiviceStatus.index}].device_name" name="zttMouldsDeivice[${zttMouldsDeiviceStatus.index}].device_name" placeholder="请输入设备名称" value="${zttMouldsDeivice.device_name }">
						</div>
					</div>
				</fieldset>
				</div>
				</c:forEach>
			</div>
			<!-- 一对多子表结束（工序设备） -->
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	var zttMouldsGongxuObj = '${zttMouldsGongxuJSON}';
	try{
		zttMouldsGongxuObj = eval("("+zttMouldsGongxuObj+")");
	}catch(e){
	}
</script>
<script type="text/javascript" src="../view/pc/zx-view/ztt-moulds-gongxu/ztt-moulds-gongxu-detail.js"></script> 
</html>
