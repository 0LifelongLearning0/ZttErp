<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购申领表详情页面</title>
</head>
<body>
  <div class="panel panel-default padding-10 no-margin">
        <fieldset>

            <div class="container-fluid">
                <div class="row col-md-8 col-md-offset-2">
                    <div class="text-center h3 pbp">采购申请购买单</div>
                    <div class="text-bold pba text-center">
                        <span style="width:100px;white-space:pre-wrap;">申请人：${applyUser.xt_userinfo_realName }</span>
                        <span style="width:100px;white-space:pre-wrap;">部门：${applyUser.xt_departinfo_name }</span>
                        <span style="width:100px">职位：${applyUser.xt_departinfo_name }</span>
                        <span style="width:200px">申请日期：${applyUser.xt_post_name }</span>
                        <input class="form-control" type="hidden" name="detail" id="detail"  value='${zxPurchaseApply.zxPurchaseApplyDetail }'>
                    </div>
                     <div style="display:none;">
                      <input class="form-control"  name="apply_id" id="apply_id"  value='${taskData.businessKey }'>
                       <input class="form-control"  name="task_id" id="task_id"  value='${taskData.task.id }'>
                      <input class="form-control"  name="size" id="size"  value='${size }'>
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
                    <table id="example" class="table table-bordered">
                        <thead>
                            <tr class="text-bold" style="text-align:center">
                                <th class="col-md-1 text-center">序号</th>
                                <th class="col-md-2 text-center">物品名称</th>
                                <th class="col-md-2 text-center">品牌及规格型号</th>
                                <th class="col-md-2 text-center">数量</th>
                                <th class="col-md-2 text-center">估计价格</th>
                                <th class="col-md-2 text-center">用途</th>
                               <!--  <th class="col-md-1 text-center">操作</th> -->
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th colspan="6">合计：<span>1000</span></th>
                            </tr>
                        </tfoot>
                    </table>
                     <div class="col-lg-6">
						<button type="button" class="btn btn-success" onclick='approveZxGoodsApply(${taskData.task.id },"true",this)'>
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存</button>
						<button type="button" class="btn btn-warning" onclick='approveZxGoodsApply(${taskData.task.id },"false")'>
						<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>驳回</button>
					</div>
					</form>
                </div>

            </div>

        </fieldset>

    </div>
   
</body>
<script type="text/javascript" src="../view/pc/lc-view/lc-task/approval_purchaseApply.js"></script> 
<script type="text/javascript" src="../view/pc/zx-view/zx-purchase-apply/zx-purchase-apply-list.js"></script> 
</html>
