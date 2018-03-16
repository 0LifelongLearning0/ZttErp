<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>办公用品主表编辑页面</title>
<link rel="stylesheet" href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
</head>
<body>
	 <div class="panel panel-default padding-10 no-margin">
        <legend style="padding-bottom: 10px">
        <button type="button" class="btn btn-default pull-right" onclick="goback()">
        <span class="glyphicon glyphicon-chevron-left"></span>返回
        </button> 物品申请购买单</legend>
	 <fieldset>

            <div class="container-fluid">
                <div class="row col-md-8 col-md-offset-2">
                    <div class="text-center h3 pbp">物品申请购买单</div>
                    <div class="text-bold pba text-center">
                         <p class="col-md-3">申请人：${applyUser.xt_userinfo_realName }</p>
                         <p class="col-md-3">部门：${applyUser.xt_departinfo_name }</span>
                        <p class="col-md-3">职位：${applyUser.xt_departinfo_name }</span>
                        <p class="col-md-3">申请日期： <%  java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
							    java.util.Date currentTime = new java.util.Date();    
							    String time = simpleDateFormat.format(currentTime).toString();  
							    out.println(time);%></p>
                        <input class="form-control" type="hidden" name="detail" id="detail"  value='${zxPurchaseApply.zxPurchaseApplyDetail }'>
                    </div>
                      <div style="display:none;">
                      <input class="form-control"  name="size" id="size"  value='${size }'>
                       </div>
                    <div class="pbp">
                        <ul>
                            <li>1、300元一下，部门负责人审核；300元以上，部门人审核之后，由总经理进行审核。</li>
                            <li>2、为保证，物品正常使用，应提前进行申请。</li>
                        </ul>
                    </div>
                    <form class="form-horizontal" id="defaultForm" method="post">
                    <input class="form-control" type="hidden" name="apply_id" id="apply_id"  value='${zxGoodsApply.apply_id }'>
                    <table id="example" class="table table-bordered">
                        <thead>
                            <tr class="text-bold" style="text-align:center">
                                <th class="col-md-1 text-center">序号</th>
                                <th class="col-md-2 text-center">物品名称</th>
                                <th class="col-md-2 text-center">品牌及规格型号</th>
                                <th class="col-md-2 text-center">数量</th>
                                <th class="col-md-2 text-center">用途</th>
                               <!--  <th class="col-md-1 text-center">操作</th> -->
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th colspan="5">合计：<span>1000</span></th>
                            </tr>
                        </tfoot>
                    </table>
                      <div class="text-center">
						<button type="button" class="btn btn-success" onclick="updateZxGoodsApply()">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>发放</button>
					</div>
					</form>
                </div>

            </div>

        </fieldset>
          </div>
    <!-- <div class="form_zxPurchaseApplyDetail"> -->
    <div class="form_zxPurchaseApplyDetail" style="display:none;">
<c:forEach var="zxGoodsApplyDetail" items="${zxGoodsApply.zxGoodsApplyDetail }" varStatus="zxGoodsApplyDetailStatus">
				<div id="form_zxGoodsApplyDetail_${zxGoodsApplyDetailStatus.index}">
			<fieldset>
			
					
				<legend><h5>序号${zxGoodsApplyDetailStatus.index+1}</h5></legend>
					<div class="form-group">
						<label class="col-lg-3 control-label">序列号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  data-bv-notempty data-bv-notempty-message="请输入序列号"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].id" name="zxPurchaseApplyDetail[${zxGoodsApplyDetailStatus.index}].id" placeholder="请输入序列号" value="${zxGoodsApplyDetail.id }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用品id</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].goods_id" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].goods_id" placeholder="请输入用品id" value="${zxGoodsApplyDetail.goods_id }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用品</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].office_name" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].office_name" placeholder="请输入用品id" value="${zxGoodsApplyDetail.office_name }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">规格型号</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].standard" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].standard" placeholder="请输入用品id" value="${zxGoodsApplyDetail.standard }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">申请数量</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="20"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].amount" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].amount" placeholder="请输入申请数量" value="${zxGoodsApplyDetail.amount }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">用途</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" maxlength="255"  id="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].reason" name="zxGoodsApplyDetail[${zxGoodsApplyDetailStatus.index}].reason" placeholder="请输入备注" value="${zxGoodsApplyDetail.reason }">
						</div>
					</div>
				
					
				</fieldset>
				</div>
				</c:forEach>
		 </div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-office-out/zx-goods-apply-out.js"></script> 
</html>
