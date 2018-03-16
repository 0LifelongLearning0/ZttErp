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
<title>外协订单跟单物料列表</title>  
	<script type="text/javascript" src="../view/pc/zx-view/zx-order-out/zx-order-out-edit-workpiece-list.js"></script> 
	<script type="text/javascript" src="../view/pc/zx-view/zx-order-out/zx-order-out-edit-workpiece-update.js"></script>  
	<script type="text/javascript" src="../view/pc/zx-view/zx-order-out/zx-order-out-edit-workpiece-detail.js"></script>  
</head>  
<body>  
<input type="hidden" id="order_id" value="${zxOutProgress.order_id }">
</body>  
</html> 