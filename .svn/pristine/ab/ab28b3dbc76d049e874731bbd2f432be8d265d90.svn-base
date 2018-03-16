<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>车辆审批表编辑页面</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend><button type="button" onclick="goback()" class="btn btn-default pull-right"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</button>修改车辆审批申请单</legend>
            <div class="container-fluid  col-md-8 col-md-offset-2">
                <div class="row">
                <form class="form-horizontal" id="defaultForm" method="post">
                	<input class="form-control" type="hidden" name="id"  placeholder="请输入Id" value="${zxCarApply.id }">
		            <table class="table table-bordered">
		                <caption class="text-center h3 no-margin bold">车辆使用审批单</caption>
		                <tbody>
		                    <tr>
		                        <td class="col-md-1 text-center">申&ensp;请&ensp;人</td>
		                        <td class="col-md-3">${applyUser.xt_userinfo_realName }</td>
		                        <td class="col-md-1 text-center">部&emsp;&emsp;门</td>
		                        <td class="col-md-2">${applyUser.xt_departinfo_name }</td>
		                        <td class="col-md-1 text-center">申请日期</td>
		                        <td class="col-md-3">${zxCarApply.apply_time }</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">车辆号码</td>
		                        <td class="text-gray">由人力资源部指定</td>
		                        <td class="text-center">司&emsp;&emsp;机</td>
		                        <td class="text-gray" colspan="3">由人力资源部指定</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">用车时间</td>
		                        <td colspan="2">
									<div class="input-group has-feedback">
				                        <div class="form-group has-feedback no-margin">
				                            <div class="col-md-12">
				                                <i></i>
				                                <input class="form_datetime form-control" name="apply_time_begin" data-bv-notempty data-bv-notempty-message="请输入申请用车时间始"  placeholder="请选择时间" value="${zxCarApply.apply_time_begin }">
												<span class="glyphicon glyphicon-calendar form-control-feedback" aria-hidden="true"></span>
				                            </div>
				                        </div>
				                        <span class="input-group-addon">至</span>
										<div class="form-group has-feedback no-margin">
				                            <div class="col-md-12">
				                                <i></i>
				                                <input class="form_datetime form-control" name="apply_time_end"  data-bv-notempty data-bv-notempty-message="请输入申请用车时间末"  placeholder="请选择时间" value="${zxCarApply.apply_time_end }">
											<span class="glyphicon glyphicon-calendar form-control-feedback" aria-hidden="true"></span>
				                            </div>
				                        </div>
									</div>
								</td>
		                        <td class="text-center">出车地点</td>
		                        <td colspan="2"><input class="form-control" type="text" maxlength="255"  data-bv-notempty data-bv-notempty-message="请输入申请用车地点"  name="apply_car_address" placeholder="请输入申请用车地点" value="${zxCarApply.apply_car_address }"></td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">用车事由</td>
		                        <td colspan="2"><input class="form-control" type="text" maxlength="255"  name="user_car_reason" placeholder="请输入用车理由" value="${zxCarApply.user_car_reason }"></td>
		                        <td class="text-center">外出人员</td>
		                        <td colspan="2"><input class="form-control" type="text" maxlength="255"  data-bv-notempty data-bv-notempty-message="请输入外车人员"  name="user_car_person" placeholder="请输入外车人员" value="${zxCarApply.user_car_person }"></td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">出车里程</td>
		                        <td class="text-gray">由门卫登记</td>
		                        <td class="text-center">使用时间</td>
		                        <td class="text-gray">由门卫登记</td>
		                        <td class="text-center">门&emsp;&emsp;卫</td>
		                        <td class="text-gray">由门卫登记</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">回司里程</td>
		                        <td class="text-gray">由门卫登记</td>
		                        <td class="text-center">结束时间</td>
		                        <td class="text-gray">由门卫登记</td>
		                        <td class="text-center">门&emsp;&emsp;卫</td>
		                        <td class="text-gray">由门卫登记</td>
		                    </tr>
		                </tbody>
		            </table>
		            <div class="form-group">
					<label class="col-lg-5 control-label"></label>
					<div class="col-lg-6">
						<button type="button" class="btn btn-success" onclick="updateZxCarApply()">
						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>保存</button>
						<button type="button" class="btn default" onclick="resetAll('defaultForm')">
						<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>重置</button>
					</div>
				</div>
		            </form>
                </div>
            </div>
            <div class="col-md-8 col-md-offset-2">
                <p>1、此表由用车人填写，审批后用车；</p>
                <p>2、门卫根据实际情况填写出车里程、使用时间、回司里程、结束时间，并检查车辆是否有碰撞痕迹；</p>
                <p>3、不得公车私用，一经发现严惩不贷；</p>
                <p>4、请持证驾驶。</p>
            </div>
		</fieldset>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-car-apply/zx-car-apply-update.js"></script> 
</html>
