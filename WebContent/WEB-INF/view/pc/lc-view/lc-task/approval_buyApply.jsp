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
<title>流程任务-会签</title>  
<script type="text/javascript" src="../view/pc/lc-view/lc-task/approval_buyApply.js"></script> 
</head>  
<body>  
	<input type="hidden" value="${taskData.task.id }" id= "taskId">
	<input type="hidden" value="${taskData.task.name }" id= "taskName">
	<input type="hidden" value="${taskData.businessKey }" id= "buyApplyId">
	<input type="hidden" value="${taskData.taskVariables.taskType }" id= "taskType">
</body>  
</html> 