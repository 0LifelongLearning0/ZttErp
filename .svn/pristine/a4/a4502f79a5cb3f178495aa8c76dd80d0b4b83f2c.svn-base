<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的日程</title>
<link rel="stylesheet" type="text/css" href="${syspath}/view/pc/zx-view/zx-schedule-day/style.css">
<script type="text/javascript" src="${syspath}/view/pc/zx-view/zx-schedule-day/main.js"></script>
<script type="text/javascript" src="../view/pc/zx-view/zx-schedule-day/zx-schedule-day-add.js"></script> 
<script type="text/javascript" src="../view/pc/zx-view/zx-schedule-day/zx-schedule-day-update.js"></script> 
<script type="text/javascript" src="../view/pc/zx-view/zx-schedule-day/zx-schedule-day-detail.js"></script>
</head>
<body>
<div id="content">
<!-- 显示日期详情 -->
  <div id="detail">
     <div id="animal_year"></div>
  </div>
  <form name="calender_content" style="margin-top: -15px;">
  	    <table style="width: 100%;">
            <tbody>
             <tr>
               <td class="sm">
                 <table class="table_head">
                   <tbody>
                   <tr>
                     <td> 
                     <!-- 选择年份菜单 -->
                       <div class="year_select">
                           <span onClick="BtN('year_d')"><img src="${syspath}/deng/source/plugins/other/jquery/perpetualcalendar/img/left.png"></span>
                             <select onChange="chaCld()" name="SY">
                               <script>
                                  for(i=1900;i<2050;i++) 
                                 document.write('<option>'+i+"年")
                               </script>
                             </select> 
                           <span onClick="BtN('year_a')"><img src="${syspath}/deng/source/plugins/other/jquery/perpetualcalendar/img/right.png"></span> 
                       </div>
                       <!-- 回到当天菜单 -->
                       <div  class="home_select">
                            <span onClick="BtN('')"><img src="${syspath}/deng/source/plugins/other/jquery/perpetualcalendar/img/2.png" style="width:26px;height:26px"></span>
                       </div>
                       <!-- 选择月份菜单 -->
                       <div style="display:inline-block;">
                           <span onClick="BtN('month_d')"><img src="${syspath}/deng/source/plugins/other/jquery/perpetualcalendar/img/left.png"></span>
                            <select onChange="chaCld()" name="SM">
                             <script>
                             for(i=1;i<13;i++) document.write('<option>'+i+"月")
                             </script>
                             </select> 
                           <span onClick="BtN('month_a')"><img src="${syspath}/deng/source/plugins/other/jquery/perpetualcalendar/img/right.png"></span>
                       </div>
                     <td>
                     <td>
                     	<div style="background:#5fa2dd; text-align:right; margin-right:200px; " >
						 	<input style="font-size:16px; border-radius: 7px; height:50px; width:90px; color: white; background:#FF0000" type="button" onClick="addZxScheduleDay()" value="新增日程">
					 	</div>
                     </td>
                   </tr>
                   </tbody>
                 </table>
               </td>
             </tr> 
          </tbody>
        </table>
      <table class="week">
           <tbody>
                <tr>
                   <td class="ch">
                      <!-- 日历头部 -->
                      <table>
                         <tbody>
                            <tr class="day">
                               <td>日</td>
                               <td>一</td>
                               <td>二</td>
                               <td>三</td>
                               <td>四</td>
                               <td>五</td>
                               <td>六</td>
                            </tr>
                         </tbody>
                       </table>
                   </td>
                </tr>
                <!-- 头部END -->
                <tr>
                	<td>
      			<!-- js动态的向表格写入日期 -->
	                 <script>
	                 var Num; //Num计算出日期位置
	                 for(i=0;i<6;i++) {
	                   document.write('<table id="cal-content"  border="0" cellspacing="0"><tr>');
	                   for(j=0;j<7;j++) {
	                     Num = i*7+j;
	                     document.write('<td id="SD' + Num +'" onclick="addDay(' + Num +')" ');
	             		//周六 周日 假期样式设定
	                  	if(j == 0|| j == 6){
	                       document.write(' class="aorange"');
	                     }else{
	                       document.write(' class="one"');
	                     }
	                     document.write('title=""> </td>');
	                   }
	                   document.write('</tr></table>');
	                   /* document.write('</tr></table></td></tr><tr><td><table style="width:399;"><tr style="text-align:center"> ');
                       //农历
                       for(j=0;j<7;j++) {
                          Num = i*7+j;
                          document.write('<td id="LD' + Num +'" onclick="addDay(' + Num +')" class="bs" title=""></td>')
                       }
                          document.write('</tr></table></td></tr>'); */
	              	}
	                 function dayContent(id,date,begin_time,transaction_content){
                		var date = date;
                	    var days = date.split("-");
                	    var str = '<span id="'+id+';" class="dayContent;" title="'+transaction_content+'">'+begin_time.substring(0,5)+' '+transaction_content+'</span></br>';
                		if($("td[date$='"+days[2]+"']").length > 1){
                			for(var i=0;i<$("td[date$='"+days[2]+"']").length;i++){
                				if($("td[date$='"+days[2]+"']").eq(i).html().trim()!=''){
                         	    	$("td[date$='"+days[2]+"']").eq(i).append(str);
                         	     }
                			}
                		}else{
                     	    $("td[date$='"+days[2]+"']").append(str);
                		}
                	}
	              	</script>
       		 	 <!-- 生成日期 END-->
	             	</td>
	             </tr>
              </tbody>
            </table>
      </form>
   </div>
   <c:forEach items="${zxScheduleDaylist}" var="zxScheduleDay">
   <script type="text/javascript">$(function(){dayContent('${zxScheduleDay.id}','${zxScheduleDay.date }','${zxScheduleDay.begin_time }','${zxScheduleDay.transaction_content }'); });</script>
	</c:forEach>
</body>
<script type="text/javascript">
document.onLoad = initial();
function showButton(){
	var div = document.getElementById("a1").style.display;
	if(div=='none'){
        document.getElementById("a1").style.display='block';
       }else{
        document.getElementById("a1").style.display='none';
      }
}

function ddd(id){
	//单机  双击事件
	var time = null;

	$('').click(function (id) {
		alert(111);
	    // 取消上次延时未执行的方法
	    clearTimeout(time);
	    //执行延时
	    time = setTimeout(function(){
	        //do function在此处写单击事件要执行的代码
	    	updateZxScheduleDay(id);
	    },300);
	});

	$('').dblclick(function (id) {
	    // 取消上次延时未执行的方法
	    clearTimeout(time);
	    //双击事件的执行代码
	    detailZxScheduleDay(id);
	});
}
	
$(function(){
	  $("#month").click(function(){
	    $.ajax({
	      url:"../zxScheduleDayController/loadZxScheduleDayByDateType",
	      dataType:"text",
	      data:{type:"1"},
	      success:function(data){
	        alert(data);
	      }
	    });
	  });
	  $("#week").click(function(){
	    $.ajax({
	      url:"../zxScheduleDayController/loadZxScheduleDayByDateType",
	      dataType:"text",
	      data:{type:"2"},
	      success:function(data){
	        alert(data);
	      }
	    });
	  });
	  $("#day").click(function(){
	    $.ajax({
	      url:"../zxScheduleDayController/loadZxScheduleDayByDateType",
	      dataType:"text",
	      data:{type:"3"},
	      success:function(data){
	        alert(data);
	      }
	    });
	  });
	});
</script>
</html>