<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购申领表新增页面</title>
<link rel="stylesheet" href="${syspath}/deng/source/plugins/other/bztree/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${syspath}/deng/source/plugins/other/bztree/js/jquery.ztree.exedit.js"></script>
</head>
<body>
    <div class="panel panel-default padding-10 no-margin">
        <legend style="padding-bottom: 10px">
        <button type="button" class="btn btn-default pull-right" onclick="goback()">
        <span class="glyphicon glyphicon-chevron-left"></span>返回</button> 采购申请购买单</legend>
        <fieldset>

            <div class="container-fluid">
                <div class="row col-md-8 col-md-offset-2">
                    <div class="text-center h3 pbp">采购申请购买单</div>
                    <div class="text-bold pba text-center">
                        <p class="col-md-3">申请人：${applyUser.xt_userinfo_realName }</p>
                        <p class="col-md-3">部门：${applyUser.xt_departinfo_name }</p>
                        <p class="col-md-3">职位：${applyUser.xt_post_name }</p>
                        <p class="col-md-3">申请日期：${applyUser.xt_post_name }</p>
                    </div>
                    <div class="pbp">
                        <ul>
                            <li>1、300元一下，部门负责人审核；300元以上，部门人审核之后，由总经理进行审核。</li>
                            <li>2、为保证，物品正常使用，应提前进行申请。</li>
                        </ul>
                    </div>
                    <div>
                        <button class="btn btn-default pull-right" type="button"  onclick="addZxPurchaseApplyDetailItems()"> 
                      <!--   <button class="btn btn-default pull-right" type="button" data-toggle="modal"  onclick="addZxPurchaseApplyDetailItems()"> -->
                        <span class="glyphicon glyphicon-plus"></span> 添加</button>
                    </div>
                    <form class="form-horizontal" id="defaultForm" method="post">
                    <table id="example" class="table table-bordered">
                        <thead>
                            <tr class="text-bold">
                                <th class="col-md-1 text-center">序号</th>
                                <th class="col-md-2 text-center">物品名称</th>
                                <th class="col-md-2 text-center">品牌及规格型号</th>
                                <th class="col-md-2 text-center">数量</th>
                                <th class="col-md-2 text-center">估计价格</th>
                                <th class="col-md-2 text-center">用途</th>
                                <th class="col-md-2 text-center">操作</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th colspan="7">合计：<span>1000</span></th>
                            </tr>
                        </tfoot>
                    </table>
                    
                    
                    <div class="text-center">
						<button type="button" class="btn btn-success" onclick="addZxPurchaseApply()">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存</button>
						<button type="button" class="btn default" onclick="resetAll('defaultForm')">
						<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>重置</button>
					</div>
					</form>
                </div>

            </div>

        </fieldset>

    </div>
</body>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="departSelectModalLabel" aria-hidden="true" style="width:600px;height:900px;text-align:center;margin-left:auto;margin-right:auto">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="departSelectModalLabel">
					新增用品
				</h4>
		
		   <!-- 部门选择器模态框（Modal）开始 -->
           <div class="modal fade" id="departSelectModal" tabindex="-1" role="dialog" aria-labelledby="departSelectModalLabel" aria-hidden="true">
	        <div class="modal-dialog">
		      <div class="modal-content">
			      <div class="modal-header">
				    <h4 class="modal-title" id="departSelectModalLabel">
					   部门选择器
				    </h4>
			     </div>
			     <div class="modal-body">
				  <ul id="tree" class="ztree"></ul>
			     </div>
			  <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="doGoodsSelect()">保存</button>
              </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
		
			</div>
			<div class="modal-body">
			  <form id="login-form-id" class="form-inline">
			  <p>
				<label class="col-lg-3 control-label">用品</label>
				  <input class="form-control" type="text" maxlength="32"  id="detailname" name="detailname" onclick="GoodsSelect()">
			  </p> 
			  <p>
				<label class="col-lg-3 control-label">规格型号</label>
				  <input class="form-control" type="text" maxlength="32"  id="stardard" name="stardard">
			  </p> 
			  <p>
				<label class="col-lg-3 control-label">数量</label>
				     <input class="form-control" type="text" maxlength="32"  id="amount" name="amount">
			  </p> 
			  <p>
				<label class="col-lg-3 control-label">估计价格</label>
				     <input class="form-control" type="text" maxlength="32"  id="estimated_price" name="reason">
			  </p> 
			  <p>
				<label class="col-lg-3 control-label">用途</label>
				     <input class="form-control" type="text" maxlength="32"  id="reason" name="reason">
			  </p> 
			  <div class="form-group" style="display:none;">
				<div class="col-lg-6">
				    <input class="form-control" type="hidden" name="goods_id" id="goods_id" >
					<input class="form-control" type="hidden" name="zxGoodsApplyDetail_removed_flag" id="zxGoodsApplyDetail_removed_flag" >
					<input class="form-control" type="hidden" value="0" name="zxGoodsApplyDetailFormNumber" id="zxGoodsApplyDetailFormNumber" >
				</div>
			</div>
			  <p>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="addRow">添加</button>
			  </p>
			  </form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<script type="text/javascript" src="../view/pc/zx-view/zx-purchase-apply/zx-purchase-apply-add.js"></script> 
<script type="text/javascript" src="../view/pc/zx-view/zx-purchase-apply/zx-purchase-apply-list-tree.js"></script> 
</html>
