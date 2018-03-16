var scores;
//返回
function goback(){
	tlocation("../zxSupplierController/loadZxSupplier");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}
function submit(status){
	msgTishCallFnBoot("确定要提交该表单信息？",function(){
		$('.btn-group').find('button').eq(0).disabled = true;
		$('.btn-group').find('button').eq(1).disabled = true;
		var param = {status:status,scores:scores.join("-"),supplier_id:$('#supplier_id').val(),apply_id:$('#apply_id').val()};
		$.ajax({
	        url:'../zxJudgeReportController/saveReport',
	        type:'POST',//PUT DELETE POST
	        data:param,
	        dataType: "json",
	        success:function(data){
	    		if(data=='1'){
	    			toastrBoot(4,"操作成功");
	    			goback();
		    	}else if(data=='0'){
		    		toastrBoot(4,"操作失败");
		    	}else if(data=='2'){
		    		toastrBoot(4,"操作失败:审核中，不能修改！");
		    	}else if(data=='3'){
		    		toastrBoot(4,"操作失败:审核通过，不能修改！");
		    	}else if(data=='4'){
		    		toastrBoot(4,"操作失败:部门已经有其他人填写！");
		    	}else if(data=='5'){
		    		toastrBoot(4,"操作失败:已提交！");
		    	}
	    		$('.btn-group').find('button').eq(0).disabled = false;
	        	$('.btn-group').find('button').eq(1).disabled = false;
	        }, 
	        error:function(){
	        	$('.btn-group').find('button').eq(0).disabled = false;
	        	$('.btn-group').find('button').eq(1).disabled = false;
	        }
	    });
	});
}
//保存
function addZxJudgeReport(status){
	scores = new Array();
	var flag = true,isnull = false;
	$(".score").each(function(){
		var dic_id = $(this).attr('data-id');
		var score = myTrim($(this).val());
		var max = $(this).attr('max');
		if(score == ''){
			isnull = true;
			score = 0;
		}
		if(isNaN(score)||score < 0||score - max > 0){
			flag = false;
		}
		var text = '{"id":"'+ dic_id +'","score":"'+ score +'"}';
		scores.push(text);
	});
	if(!flag){
		toastrBoot(4,'输入不合法');
		return;
	}
	if(isnull){
		msgTishCallFnBoot("您没有填写所有得分，确定要继续么？",function(){
			submit(status);
		});
	}else{
		submit(status);
	}
}
//初始化日期选择器
$(document).ready(function(){
	if($('#step').val() == '2'||$('#step').val() == '3'){
		$('#accordion-group-one').show();
		$('.bta').hide();
		$('.bts').hide();
	}
	$(".content-table").each(function(){
		var index = $(this).attr('id').replace('datatable-','');
	    var dic_id = $(this).attr('data-id');
	    $.post("../zxJudgeReportController/getZxJudgeReportTableColumnList",{dic_id:dic_id,apply_id:$('#apply_id').val()},function(result){
	    	var data = eval("(" + result + ")");
	    	var items = data.items;
	    	var text = '';
	    	for(var i = 0;i < items.length;i++){
	    		var s_id = items[i].id;
	    		var content = items[i].content;
	    		var total_score = items[i].total_score;
	    		var judge_user_name = "";
	    		if(items[i].hasOwnProperty("judge_user_name")){
	    			judge_user_name = items[i].judge_user_name;
	    		}
	    		var score = 0;
	    		if(items[i].hasOwnProperty("score")){
	    			score = items[i].score;
	    		}
	    		var is_read = false;
	    		if(items[i].hasOwnProperty("status")){
	    			if(items[i].status == '2'||items[i].status == '3'){
	    				is_read = true;
	    			}
	    		}
	    		var cl = "odd";
	    		if(i%2 == 1){
	    			cl = "even";
	    		}
	    		if(is_read){
	    			text += '<tr role="row" class="'+ cl +'"><td>'+ content +'</td><td>'+ total_score +'</td><td><input readOnly value="'+ score +'" class="score" name="score" data-id="'+ s_id +'" max="'+ total_score +'" onkeyup="this.value=this.value.replace(/\D/g,\'\')" onafterpaste="this.value=this.value.replace(/\D/g,\'\')"></td><td>'+ judge_user_name +'</td></tr>';
	    		}else{
	    			text += '<tr role="row" class="'+ cl +'"><td>'+ content +'</td><td>'+ total_score +'</td><td><input value="'+ score +'" class="score" name="score" data-id="'+ s_id +'" max="'+ total_score +'" onkeyup="this.value=this.value.replace(/\D/g,\'\')" onafterpaste="this.value=this.value.replace(/\D/g,\'\')"></td><td>'+ judge_user_name +'</td></tr>';

	    		}
	    	}
	    	$('#row-table-' + index).html(text);
	    });
	});
});
