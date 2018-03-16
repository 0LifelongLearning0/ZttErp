<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>单个日程</title>
</head>
<body>
	<input type="hidden" id="zxScheduleDaylist" value='${zxScheduleDaylist}'>
	<input type="hidden" id="year" value='${year}'>
	<input type="hidden" id="month" value='${month}'>
	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend style="padding-bottom: 10px;margin-left:50%;">我的日程</legend>
            <div class="schedule">
            <div class="calendar clearfix">
                <div class="pull-left"><button class="btn btn-default" onclick="toZxScheduleDayAdd()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加日程
			</button></div>
                <div class="pull-right">
                    <div class="reduce pull-left">&lt;</div><div class="goDates pull-left"><span class="goYear">2017</span>年<span class="goMonth">1</span>月</div><div class="plus pull-left">&gt;</div>
                </div>
            </div>
            <div class="week clearfix partition">
                <ul>
                    <li class="col">日</li>
                    <li class="col">一</li>
                    <li class="col">二</li>
                    <li class="col">三</li>
                    <li class="col">四</li>
                    <li class="col">五</li>
                    <li class="col">六</li>
                </ul>
            </div>
            <div class="day clearfix partition">
                <ul></ul>
            </div>
        </div>
		</fieldset>
	</div>
</body>
<script type="text/javascript" src="../view/pc/zx-view/zx-schedule-day/zx-my-schedule.js"></script> 
</html>
