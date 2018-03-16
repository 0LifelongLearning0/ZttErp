<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>办公用品主表详情页面</title>
</head>
<body>
	<div class="panel-body">
		<div class="page-header">
			<h4>办公用品主表详情</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">序列号</label>
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="apply_id"  placeholder="请输入序列号" value="${zxGoodsApply.apply_id }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">申请人</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="user_id" placeholder="请输入申请人" value="${zxGoodsApply.user_id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">申请人</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="32"  name="user_name" readonly placeholder="请输入申请人" value="${zxGoodsApply.user_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">备注</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="255"  name="reason" readonly placeholder="请输入备注" value="${zxGoodsApply.reason }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">申请时间</label>
				<div class="col-lg-6">
					<input class="form_datetime form-control" name="create_date"  placeholder="请选择时间" value="${zxGoodsApply.create_date }">
				</div>
			</div>
			<div class="form-group" style="display:none">
				<label class="col-lg-3 control-label">状态</label>
				<div class="col-lg-6">
					<input class="form-control" type="text" maxlength="2"  data-bv-notempty data-bv-notempty-message="请输入状态"  name="status" placeholder="请输入状态" value="${zxGoodsApply.status }">
				</div>
			</div>
			<div class="form-group" style="display:none;">
				<div class="col-lg-6">
					<input class="form-control" type="hidden" name="zxGoodsApplyDetail_removed_flag" id="zxGoodsApplyDetail_removed_flag" >
					<input class="form-control" type="hidden" value="${fn:length(zxGoodsApply.zxGoodsApplyDetail) }" name="zxGoodsApplyDetailFormNumber" id="zxGoodsApplyDetailFormNumber" >
				</div>
			</div>
			<!-- 一对多子表开始（用品申领详细表） -->
			<div class="page-header">
				<h4>用品申领详细表</h4>
			</div>
			<div class="form_zxGoodsApplyDetail">
			<c:forEach var="zxGoodsApplyDetail" items="${zxGoodsApply.zxGoodsApplyDetail }" varStatus="zxGoodsApplyDetailStatus">
				<div id="form_zxGoodsApplyDetail_${zxGoodsApplyDetailStatus.index}">
			<fieldset>
			<legend><h5>序号${zxGoodsApplyDetailStatus.index+1}</h5></legend>
					<div class="form-group" style="display:none">
						<label class="col-lg-3 control-label">序列号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"   data-bv-notempty data-bv-notempty-message="请输入序列号"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].id" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].id" placeholder="请输入序列号" value="${zxGoodsApplyDetail.id }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用品</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].goods_id" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].goods_id" placeholder="请输入用品id" value="${zxGoodsApplyDetail.office_name }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">补充数量</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="20"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].amount" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].amount" placeholder="请输入补充数量" value="${zxGoodsApplyDetail.amount }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用途</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="255"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].reason" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].reason" placeholder="请输入用途" value="${zxGoodsApplyDetail.reason }">
						</div>
					</div>
					<div class="form-group" style="display:none">
						<label class="col-lg-3 control-label">补充时间</label>
						<div class="col-lg-6">
							<input class="form_datetime form-control" id="zxGoodsApplyDetail_${zxGoodsApplyDetailStatus.index}_create_time" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].create_time"  placeholder="请选择时间" value="${zxGoodsApplyDetail.create_time }">
						</div>
					</div>
				</fieldset>
				</div>
				</c:forEach>
			</div>
			<!-- 一对多子表结束（用品申领详细表） -->
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
	var zxGoodsApplyObj = '${zxGoodsApplyJSON}';
	try{
		zxGoodsApplyObj = eval("("+zxGoodsApplyObj+")");
	}catch(e){
	}
</script>
<script type="text/javascript" src="../view/pc/zx-view/zx-office-out/zx-goods-apply-detail.js"></script> 
</html>
