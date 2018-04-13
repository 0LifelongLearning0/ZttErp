<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
td {
	text-align: center;
}
</style>
</head>
<script type="text/javascript">
    var id = "${taskData.businessKey }"; 
</script>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset id="printAll${zxCarApply.id }">
			<div class="container-fluid  col-md-10 col-md-offset-1">
				<div class="row">
					<form class="form-horizontal" id="defaultForm" method="post">
						<table class="table table-bordered">
							<caption class="text-center h3 no-margin bold">质检部检验单</caption>
							<tbody>
								<tr>
									<td class="col-md-2 text-center">申&ensp;请&ensp;人</td>
									<td class="col-md-2">${applyUser.xt_userinfo_realName }</td>
									<td class="col-md-2 text-center">部&emsp;&emsp;门</td>
									<td class="col-md-2">${applyUser.xt_departinfo_name }</td>
									<td class="col-md-2 text-center">申请日期</td>
									<td class="col-md-2"><label id="zttordertime" />
									<input class="form-control" type="hidden" maxlength="255"  name="taskkind" id="taskkind" value='${taskData.taskVariables.taskkind }'>
									</td>
								</tr>
								<tr>
									<td class="text-center">工令号</td>
									<td><label id="product_order_number" /></td>
								</tr>
								<tr>

									<td class="text-center">上传检验报告</td>
									<td colspan="2"><button class="btn btn-primary"
											data-toggle="button" onclick="uploadattachment()">上传</button>
										<input class="form-control" type="hidden" maxlength="255"
										name="checker_attachment" id="checker_attachment"></td>
									<td class="text-center">检验评审</td>
									<td colspan="2"><input class="form-control" type="text"
										maxlength="255" name="checkcomment"
										id="checkcomment"></td>
								</tr>
							</tbody>
						</table>
						<div class="col-lg-6" style="text-align: center">
							<button type="button" class="btn btn-success"
								onclick='approveZttOrderApply(${taskData.task.id },"yes",this)'>
								<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>合格
							</button>
							<button type="button" class="btn btn-warning"
								onclick='approveZttOrderApply(${taskData.task.id },"no",this)'>
								<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>不合格
							</button>
						</div>
					</form>
				</div>
			</div>
		</fieldset>
	</div>
</body>
<script type="text/javascript"
	src="../view/pc/lc-view/lc-task/approval_ordercheckdept.js"></script>
</html>
