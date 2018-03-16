$(document).ready(function() {
		var year = $("#year").val();
		var month = $("#month").val();
		if(year!=""){
			$(".goYear").html(year);
	        $(".goMonth").html(month);
	        showDate(year, month);
		}else{
			//页面加载初始化年月
	        var mydate = new Date();
	        $(".goYear").html(mydate.getFullYear());
	        $(".goMonth").html(mydate.getMonth() + 1);
	        showDate(mydate.getFullYear(), mydate.getMonth() + 1);
		}
        //日历上一月
        $(".reduce").click(function() {
            var mm = parseInt($(".goMonth").html());
            var yy = parseInt($(".goYear").html());
            if (mm == 1) { //返回12月
            	tlocation("../zxScheduleDayController/toLoadZxScheduleDay?year="+(yy-1)+"&month="+(12));
            } else { //上一月
            	tlocation("../zxScheduleDayController/toLoadZxScheduleDay?year="+yy+"&month="+(mm-1));
            }
        })
        //日历下一月
        $(".plus").click(function() {
            var mm = parseInt($(".goMonth").html());
            var yy = parseInt($(".goYear").html());
            if (mm == 12) { //返回12月
            	tlocation("../zxScheduleDayController/toLoadZxScheduleDay?year="+(yy+1)+"&month="+1);
            } else { //上一月
            	tlocation("../zxScheduleDayController/toLoadZxScheduleDay?year="+yy+"&month="+(mm+1));
            }
        })
        //返回本月
        $(".f-btn-fhby").click(function() {
            $(".goYear").html(mydate.getFullYear());
            $(".goMonth").html(mydate.getMonth() + 1);
            showDate(mydate.getFullYear(), mydate.getMonth() + 1);
        })

        //读取年月写入日历  重点算法!!!!!!!!!!!
        function showDate(yyyy, mm) {
            var dd = new Date(parseInt(yyyy), parseInt(mm), 0); //Wed Mar 31 00:00:00 UTC+0800 2010  
            var daysCount = dd.getDate(); //本月天数  
            var mystr = ""; //写入代码
            var icon = ""; //图标代码
            var today = new Date().getDate(); //今天几号  21
            var monthstart = new Date(parseInt(yyyy) + "/" + parseInt(mm) + "/1").getDay() //本月1日周几  
            var lastMonth; //上一月天数
            var nextMounth //下一月天数
            if (parseInt(mm) == 1) {
                lastMonth = new Date(parseInt(yyyy) - 1, parseInt(12), 0).getDate();
            } else {
                lastMonth = new Date(parseInt(yyyy), parseInt(mm) - 1, 0).getDate();
            }
            if (parseInt(mm) == 12) {
                nextMounth = new Date(parseInt(yyyy) + 1, parseInt(1), 0).getDate();
            } else {
                nextMounth = new Date(parseInt(yyyy), parseInt(mm) + 1, 0).getDate();
            }
            //计算上月空格数
            for (j = monthstart; j > 0; j--) {
                mystr += "<li class='col text-gray lastMonth'><em>" + (lastMonth - j + 1) + "</em><i></i></li>";
            }
            var list = $("#zxScheduleDaylist").val()
            var da = eval('('+ list+ ')');
            var zxScheduleDaylist = da.items;
            
            //本月单元格
            for (i = 0; i < daysCount; i++) {
            	var month = mm.toString();
            	var day = (i+1).toString();
            	if(month.length<2){
            		month = "0"+month;
            	}
            	if(day.length<2){
            		day ="0"+day;
            	}
            	mystr += "<li class='col' date='"+yyyy+"-"+ month +"-"+(i+1)+"'><div class='programme'>"
            	var str = yyyy+"-"+month+"-"+day;
            	for (var j = 0; j < zxScheduleDaylist.length; j++) {
            	    var item = zxScheduleDaylist[j];
            	    if(item.date==str){
            	    	var s_id = item.id;
            	    	var pti = item.period_transaction_id;
            	    	var content = item.transaction_content.substring(0,3);
                	    if(pti!=""&&pti!=null){
                	    		 //这里为一个单元格，添加内容在此
                	    		 mystr +="<a href=\"javascript:toZxScheduleDayUpdate('"+ s_id +"')\"><span class='continue'>"+item.end_time+"前完成  内容："+content+"</span></a>";
                	    }else{
                	    	//这里为一个单元格，添加内容在此
                            mystr +="<a href=\"javascript:toZxScheduleDayUpdate('"+ s_id +"')\"><span>"+item.end_time+"前完成  内容："+content+"</span></a>";
                               
                	    }
            	    }
            	}
            	mystr += "</div><em>"+ (i+1) + "</em><i></i>"
                +
                "</li>";
            }
            //计算下月空格数
            for (k = 0; k < 42 - (daysCount + monthstart); k++) { //表格保持等高6行42个单元格
                mystr += "<li class='col text-gray'><em>" + (k + 1) + "</em><i></i></li>";
            }



            //写入日历
            $(".day ul").html(mystr);
            //给今日加class
            if(year==""){
            	if (mydate.getFullYear() == yyyy) {
                    if ((mydate.getMonth() + 1) == mm) {
                        var today = mydate.getDate();
                        var lastNum = $(".lastMonth").length;
                        $(".day li").eq(today + lastNum - 1).addClass("today");
                    }
                }
            }
            //绑定选择方法
            $(".f-rili-table .f-number").off("click");
            $(".f-rili-table .f-number").on("click", function() {
                $(".f-rili-table .f-number").removeClass("f-on");
                $(this).addClass("f-on");
            });

            //绑定查看方法
            $(".f-yuan").off("mouseover");
            $(".f-yuan").on("mouseover", function() {
                $(this).parent().find(".f-table-msg").show();
            });
            $(".f-table-msg").off("mouseover");
            $(".f-table-msg").on("mouseover", function() {
                $(this).show();
            });
            $(".f-yuan").off("mouseleave");
            $(".f-yuan").on("mouseleave", function() {
                $(this).parent().find(".f-table-msg").hide();
            });
            $(".f-table-msg").off("mouseleave");
            $(".f-table-msg").on("mouseleave", function() {
                $(this).hide();
            });
        }
    })
    //新增
function toZxScheduleDayAdd(){
	tlocation('../zxScheduleDayController/toZxScheduleDayAdd');
}
function toZxScheduleDayUpdate(id){
	tlocation('../zxScheduleDayController/toZxScheduleDayUpdate?id='+id);
}
