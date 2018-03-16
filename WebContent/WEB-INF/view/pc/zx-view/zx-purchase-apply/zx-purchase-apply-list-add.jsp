<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>采购申领表</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend>查询区域</legend>
			<form method="POST" id="searchForm" class="form-inline">
			<p>
				<label class="col-lg-5 control-label">用品</label>
				  <input class="form-control" type="text" maxlength="32"  id="detailname" name="detailname" onclick="GoodsSelect()">
			  </p> 
			  <p>
				<label class="col-lg-5 control-label">规格型号</label>
				  <input class="form-control" type="text" maxlength="32"  id="stardard" name="stardard">
			  </p> 
			  <p>
				<label class="col-lg-5 control-label">数量</label>
				     <input class="form-control" type="text" maxlength="32"  id="amount" name="amount">
			  </p> 
			  <p>
				<label class="col-lg-5 control-label">估计价格</label>
				     <input class="form-control" type="text" maxlength="32"  id="estimated_price" name="reason">
			  </p> 
			  <p>
				<label class="col-lg-5 control-label">用途</label>
				     <input class="form-control" type="text" maxlength="32"  id="reason" name="reason">
			  </p> 
			  <div class="form-group" style="display:none;">
				<div class="col-lg-6">
				    <input class="form-control" type="hidden" name="goods_id" id="goods_id" >
					<input class="form-control" type="hidden" name="zxGoodsApplyDetail_removed_flag" id="zxGoodsApplyDetail_removed_flag" >
					<input class="form-control" type="hidden" value="0" name="zxGoodsApplyDetailFormNumber" id="zxGoodsApplyDetailFormNumber" >
				</div>
			</div>
			</form>
		</fieldset>
	</div>
	
</body>
<!-- <script type="text/javascript" src="../view/pc/zx-view/zx-purchase-apply/zx-purchase-apply-list.js"></script>  -->
<script type="text/javascript">
function GoodsSelect()
{
	layer.open({
		title: '用品选择',
		area: ['400px', '500px'],
     type: 2, 
   content: "loadZxPurchaseApplyTree"
    });
	
	}


</script>
</html>
