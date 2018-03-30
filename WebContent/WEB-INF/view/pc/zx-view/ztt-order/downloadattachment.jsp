<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>业务人员下单表详情页面</title>
</head>
<body>
<%-- <label id="downloadnumber" />

<a href="JavaScript:downloadFile('${zttOrder.attachment }')">'${zttOrder.attachment }'</a><br> --%>

	<div class="panel-body">
		<div class="btn-group pull-right" style="margin-right: 20px;">
		</div>
		<input type="hidden" id="download" value='${upid}'/>
		<table id="datatables" class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>文件名</th>
					<th>下载</th>
				</tr>
			</thead>
		</table>
	</div>

</body>
<script type="text/javascript"
	src="../view/pc/zx-view/ztt-order/downloadattachment.js"></script>
	<script>
	var attachment="${zttOrder.attachment }";
	if(attachment==""){
		document.getElementById("downloadnumber").innerText="无附件下载";
	}

</script>

</html>
