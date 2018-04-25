<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%@ include file="/deng/include/includeboot.jsp"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript"
	src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
	
</head>

<body>
<div class="panel panel-default padding-10 no-margin">
		<fieldset>

			<div class="container-fluid">
				<div class="row col-md-8 col-md-offset-2">
					<div class="text-center h3 pbp">机械加工工艺过程卡片</div>
					<table class="table table-bordered">
							<tbody>
								<tr>
									<td class="text-center">工序名称</td>
									<td class="text-gray"><select id="Processname">
									        <option value="0">请选择</option>
											<option value="1">下料</option>
											<option value="2">普车加工</option>
											<option value="3">数车加工</option>
											<option value="4">加工中心</option>
											<option value="5">火花机</option>
											<option value="6">钳工</option>
											<option value="7">线切割</option>
											<option value="8">外协加工</option>
									</select></td>
									<td class="text-center">工艺内容</td>
									<td class="text-center">
									<input class="form-control" type="text" maxlength="32" id="Processcontent" name="Processcontent">
									</td>
								</tr>
								<tr>
									<td class="text-center">设备</td>
									<td class="text-gray">
									<input class="form-control" type="text" maxlength="32" id="equipment" name="equipment"></td>
									<td class="text-center">工艺装备</td>
									<td class="text-center">
									<input class="form-control" type="text" maxlength="32" id="tooling" name="tooling">
									</td>
								</tr>
								<tr>
									<td class="text-center">单价</td>
									<td class="text-gray"><input class="form-control" type="text" maxlength="32" id="time" name="single_price"></td>
									<td class="text-center"></td>
									<td class="text-center">
									</td>
								</tr>
							</tbody>
						</table>
				</div>

			</div>

		</fieldset>

	</div>
</body>

	<script type="text/javascript" src="../view/pc/zx-view/ztt-processproduct-parent/ztt-processproduct-detail-add.js"></script> 
</html>
