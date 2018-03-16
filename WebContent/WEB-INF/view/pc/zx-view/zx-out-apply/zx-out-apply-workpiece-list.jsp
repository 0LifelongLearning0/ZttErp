<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
<head>  
<meta charset="UTF-8">  
<title>外协工件列表</title>  
	<script type="text/javascript" src="../view/pc/zx-view/zx-out-apply/zx-out-apply-workpiece-list.js"></script>
	<script type="text/javascript" src="../view/pc/zx-view/zx-out-apply/zx-out-apply-workpiece-add.js"></script>  
	<script type="text/javascript" src="../view/pc/zx-view/zx-out-apply/zx-out-apply-workpiece-update.js"></script>  
	<script type="text/javascript" src="../view/pc/zx-view/zx-out-apply/zx-out-apply-list-workpiece.js"></script>
</head>  
<body>  
<input type="hidden" id="out_apply_id" value="${zxOutApplyWorkpiece.apply_id }">
<input type="hidden" id="make_num" value="${zxOutApply.make_num }">
<input type="hidden" id="out_apply_status" value="${zxOutApply.status }">
<input type="hidden" id="out_project_id" value="${zxOutApply.project_id }">
</body>  
</html> 