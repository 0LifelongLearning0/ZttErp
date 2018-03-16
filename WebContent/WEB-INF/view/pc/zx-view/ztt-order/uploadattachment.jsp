<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表详情页面</title>
</head>
<body>
	<!-- <div class="col-md-8 col-sm-offset-2 text-center">

 <input type="file" id="file_upload"/><br/>
 </div>
 <input type="button" value="上传图片" id="upload" onclick="ajaxFileUpload()"/> <br/> -->
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td class="col-md-1 text-center"><input type="file" id="file_upload"/></td>

			</tr>
			<tr>
				<td class="col-md-1 text-left"><input type="button" value="上传图片" id="upload" onclick="ajaxFileUpload()"/></td>

			</tr>
		</tbody>
	</table>

</body>
<script type="text/javascript"
	src="../view/pc/zx-view/ztt-order/uploadattachment.js"></script>

</html>
