<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>车辆出门登记</title>
</head>
<body>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend><button type="button" onclick="goback()" class="btn btn-default pull-right"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</button>车辆出门登记</legend>
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
		                        <td>${applyCar.car_no }</td>
		                        <td class="text-center">司&emsp;&emsp;机</td>
		                        <td colspan="3">${applyDriver.xt_userinfo_realName }</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">用车时间</td>
		                        <td colspan="2">${zxCarApply.apply_time_begin } 至 ${zxCarApply.apply_time_end }</td>
		                        <td class="text-center">出车地点</td>
		                        <td colspan="2">${zxCarApply.apply_car_address }</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">用车事由</td>
		                        <td colspan="2">${zxCarApply.user_car_reason }</td>
		                        <td class="text-center">外出人员</td>
		                        <td colspan="2">${zxCarApply.user_car_person }</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">出车里程</td>
		                        <td>
									<div class="input-group spinner" data-trigger="spinner">
									    <input type="text" class="form-control text-center" value="0" name="out_mileage" placeholder="请输入出车里程" data-min="0" data-step="1" data-rule="currency">
									    <span class="input-group-addon">
									        <a href="javascript:;" class="spin-up" data-spin="up"><i class="fa fa-caret-up"></i></a>
									        <a href="javascript:;" class="spin-down" data-spin="down"><i class="fa fa-caret-down"></i></a>
									    </span>
									</div>
		                        </td>
		                        <td class="text-center">出门时间</td>
		                        <td>
		                        	<div class="form-group has-feedback no-margin">
			                            <div class="col-md-12">
			                                <input class="form_datetime form-control" name="usecar_outtime" data-bv-notempty data-bv-notempty-message="请选择出门时间"  placeholder="请选择时间">
		                        			<span class="glyphicon glyphicon-calendar form-control-feedback" aria-hidden="false"></span>
			                            </div>
			                        </div>
		                        </td>
		                        <td class="text-center">门&emsp;&emsp;卫</td>
		                        <td>${xtUserinfo.xt_userinfo_realName}</td>
		                    </tr>
		                    <tr>
		                        <td class="text-center">回司里程</td>
		                        <td class="text-gray">由门卫登记</td>
		                        <td class="text-center">回司时间</td>
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
<script type="text/javascript" src="../view/pc/zx-view/zx-car-apply/zx-car-apply-check-out.js"></script> 
</html>
