<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<%@ include file="/deng/include/inplugboot.jsp"%>
<%@include file="user-choose.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>6S事项改善页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>改善6S事项信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<input type="hidden" id="id" name='id' value="${zxSixSContent.id}"/>
			<input type="hidden" id="six_s_id" name='six_s_id' value="${zxSixSContent.six_s_id}"/>
			<fieldset>
				<legend>基本信息</legend>
				<div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">检查场所</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input type="hidden" id="place_id_" name='place_id_' value="${zxSixSContent.place_id}"/>
			        		<select disabled="disabled" class="form-control" maxlength="32" id="place_id"  style="width: 150px;" name="place_id" placeholder="请选择"></select>			        
						</div>
			        </div>
 					<div class="col-md-1">
			        	<label class="control-label">责任部门</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group input-group">
			        		<input class="form-control" type="text" style="width: 150px;" value="${zxSixSContent.dep_name}" readonly/>
						</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">责任人</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group input-group">
			        		<input class="form-control" type="text" style="width: 150px;" value="${zxSixSContent.user_realname}" readonly/>
						</div>
			        </div>
			        <div class="col-md-1">
			        	<label class="control-label">完成期限</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
							<input class="form_date form-control" readonly="readonly" placeholder="请选择时间"  value="${zxSixSContent.end_date}">
						</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>说明</legend>
				<div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">不符合项说明</label>
			        </div>
			        <div class="col-md-10">
			        	<div class="form-group">
							<textarea class="form-control" cols="100" maxlength="256"  name="problem" readonly placeholder="请输入说明">${zxSixSContent.problem}</textarea>			        	
						</div>
			        </div>
			    </div>
			    <div class="row">
			        <div class="col-md-1">
			        	<label class="control-label">改善措施</label>
			        </div>
			        <div class="col-md-10">
			        	<div class="form-group">
							<textarea class="form-control" cols="100" maxlength="256"  name="measure" readonly placeholder="请输入改善措施">${zxSixSContent.measure}</textarea>			        	
						</div>
			        </div>
			    </div>
			</fieldset>
			<fieldset>
				<legend>参考照片</legend>
				<div class="row">
					<div class="col-md-1">
			        	<label class="control-label">参考照片</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="hidden" name="problem_pic" id="problem_pic" value="${zxSixSContent.problem_pic}">
							<img src = "../deng/images/default/add_d.png" class="img" width="96"  height="96"  id="problem_pic_pic">
			        	</div>
			        </div>
			    </div>
			    <div class="row">
					<div class="col-md-1">
			        	<label class="control-label">改善结果</label>
			        </div>
			        <div class="col-md-2">
			        	<div class="form-group">
			        		<input class="form-control" type="hidden" name="result_pic" id="result_pic">
							<img src="../deng/images/default/add_d.png" class="img" width="96"  height="96" id="result_pic_pic">
			        	</div>
			        </div>
			    </div>
			</fieldset>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-6">
					<button type="button" class="btn green" onclick="correctZxSixSContent()">保存</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-six-s-content/zx-six-s-content-correct.js"></script> 
</html>
