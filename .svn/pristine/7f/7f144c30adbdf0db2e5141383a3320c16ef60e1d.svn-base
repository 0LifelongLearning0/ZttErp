<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>再评审报告编辑页面</title>
<style type="text/css">
.accordion-group {
    margin-bottom: 2px;
    border: 1px solid #e5e5e5;
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
    display: block;
    padding: 8px 15px;
}
</style>
</head>
<body>
	<input type="hidden" id="step" value="${step}">
	<input type="hidden" id="months" value="${months}">
	<input type="hidden" id="supplier_id" value="${supplier_id}">
	<div class="panel-body">
		<div class="page-header">
			<h4>编辑再评审报告信息</h4>
		</div>
		<form class="form-horizontal" id="defaultForm" method="post">
			<div class="container-fluid">
				<div class="accordion" id="accordion2">
					<div class="accordion-group" id="accordion-group-one" style="display:none">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
								总览
							</a>
						</div>
						<div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
							<div class="accordion-inner" id="accordion-inner-${vs.index + 1}">
								<div class="row">
							        <div class="col-md-1">
							        	<label class="control-label">评定日期</label>
							        </div>
							        <div class="col-md-2">
							        	<div class="form-group">
							        		<input class="form-control" readOnly type="text" maxlength="255" style="width: 150px;" value="${judge_date}"  name="judge_date">
							        	</div>
							        </div>
							    </div>
							    <div class="row">
							        <div class="col-md-1">
							        	<label class="control-label">总分</label>
							        </div>
							        <div class="col-md-2">
							        	<div class="form-group">
							        		<input class="form-control" readOnly type="text" maxlength="255" style="width: 150px;" value="${score}"  name=score>
							        	</div>
							        </div>
							    </div>
							    <div class="row">
							        <div class="col-md-1">
							        	<label class="control-label">评定结果</label>
							        </div>
							        <div class="col-md-2">
							        	<div class="form-group">
							        		<input class="form-control" readOnly type="text" maxlength="255" style="width: 150px;" value="${grade}"  name="grade">
							        	</div>
							        </div>
							    </div>
							    <div class="row">
							        <div class="col-md-1">
							        	<label class="control-label">状态</label>
							        </div>
							        <div class="col-md-2">
							        	<div class="form-group">
							        		<input class="form-control" readOnly type="text" maxlength="255" style="width: 150px;" value="${status}"  name="status">
							        	</div>
							        </div>
							    </div>
							</div>
						</div>
					</div>
					<c:forEach items="${standards}" var="standard" varStatus="vs"> 
						<div class="accordion-group">
							<div class="accordion-heading" id="accordion-heading-${vs.index + 1}" data-id="${standard.xt_data_dictionary_id}">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse-${vs.index + 1}">
									${standard.xt_data_dictionary_name}
								</a>
							</div>
							<div id="collapse-${vs.index + 1}" class="accordion-body collapse" style="height: 0px; ">
								<div class="accordion-inner" id="accordion-inner-${vs.index + 1}">
									<table id="datatable-${vs.index + 1}" data-id="${standard.xt_data_dictionary_id}"  class="table table-bordered table-striped table-hover content-table">
										<thead>
											<tr>
												<th>考核内容</th>
												<th>最高分</th>
												<th>实际得分</th>
												<th>考核人</th>
											</tr>
										</thead>
										<tbody id="row-table-${vs.index + 1}">
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label"></label>
				<div class="col-lg-9 btn-group">
					<button type="button" class="btn green bta" onclick="addZxJudgeReport(1)">保存</button>
					<button type="button" class="btn blue bts" onclick="addZxJudgeReport(2)">提交</button>
					<button type="button" class="btn default" onclick="goback()">返回</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-judge-result/zx-judge-again-report-add.js"></script> 
</html>
