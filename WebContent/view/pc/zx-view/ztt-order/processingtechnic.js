var numbers=-1;
var t;
var counter;
$(document).ready(function(){
		  	
		
             t = $("#example").DataTable({
                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });
             var counter = 0;
            $('#addRow').on('click', function() {
            	var index=document.getElementById("Processname").selectedIndex;
            	var flag=0;
            	var select;
            	if(index==1){
            		
            		select="下料";
            	}else if(index==2){
            		select="普车加工";
            	}else if(index==3){
            		select="数车加工";
            	}else if(index==4){
            		select="加工中心";
            	}else if(index==5){
            		select="火花机";
            	}else if(index==6){
            		select="钳工";
            	}else if(index==6){
            		select="线切割";
            	}else if(index==6){
            		select="外协加工";
            	}
            	
            	
            	if(index==0){
            		flag=1;
            		layer.alert("请选择工序名称");
            	}
            	if(flag==0){
            		t.row.add([
                               counter+1,
                               '<input type="hidden" name="ztt_processproduct['+counter+'].Processname"  value="'+document.getElementById("Processname").value+'"/>'+ select,
                               '<input type="hidden" name="ztt_processproduct['+counter+'].Processcontent" value="'+document.getElementById("Processcontent").value+'"/>'+ document.getElementById("Processcontent").value,
                                '<input type="hidden" name="ztt_processproduct['+counter+'].equipment" value="'+document.getElementById("equipment").value+'"/>'+document.getElementById("equipment").value,
                               '<input type="hidden" name="ztt_processproduct['+counter+'].tooling" value="'+document.getElementById("tooling").value+'"/>' +document.getElementById("tooling").value,
                               '<input type="hidden" name="ztt_processproduct['+counter+'].single_price" value="'+document.getElementById("time").value+'"/>'+document.getElementById("time").value,
                                 '<button type="button" class="btn btn-primary" onclick="delrow(this)">删除</button>'
                           ]).draw();
                           counter++;	
            	}
            	  });
               $('#addModal').modal(options);
            });
            
	

//保存
function addZxGoodsApply(){
	submitBForm('defaultForm','../zttOrderController/processingtechnicAdd','../zttOrderController/copyZttOrder');
}



//发起提交表单
function submitBForm(formid,url,callUrl){
	if(null == formid || '' == formid){
		window.parent.toastrBoot(4,"未能获取到formid!");
		return;
	}
	var bootform =  $('#'+formid);
	if(typeof(bootform) == "undefined" ||null == bootform || '' == bootform){
		window.parent.toastrBoot(4,"未能获取到form对象!");
		return;
	}
		msgTishCallFnBoot("确定要提交该表单信息？",function(){
			$.ajax({
	            url:url,
//	            async:false,//同步，会阻塞操作
	            type:'POST',//PUT DELETE POST
	            data:bootform.serialize(),
	            success:function(result){
	            	try {
	            		result = eval("(" + result + ")");  
	            		if(typeof(result.success) != "undefined"){
	            			if(result.success){
			            		window.parent.toastrBoot(3,result.msg);
			            		var index = parent.layer.getFrameIndex(window.name);
			            		parent.layer.close(index);
			        		}else{
			        			//失败还在原位置页面
			        			window.parent.toastrBoot(4,result.msg);
			        		}
	            		}
					} catch (e) {
						
					}
	            }, 
	            error:function(){
	            	
	            }
	        })
		})
}
function delZxGoodsApplyDetailItems(thiz,numbers){
	validatorDestroy('defaultForm');
	$("#form_zxGoodsApplyDetail_"+numbers).remove();
	var zxGoodsApplyDetail_removed_flag = $('#zxGoodsApplyDetail_removed_flag').val()
	if(null == zxGoodsApplyDetail_removed_flag || '' == zxGoodsApplyDetail_removed_flag){
		$('#zxGoodsApplyDetail_removed_flag').val(','+numbers+',');
	}else{
		$('#zxGoodsApplyDetail_removed_flag').val(zxGoodsApplyDetail_removed_flag+numbers+',')
	}
	reValidator('defaultForm');
}
//新一行
function showmodal(){
	document.getElementById("Processname")[0].selected=true;
	document.getElementById("Processcontent").value="";
     document.getElementById("equipment").value="";
     document.getElementById("tooling").value="";
     document.getElementById("time").value="";
	
	$('#addModal').modal();
}
//弹出框保存
function doGoodsupload(){
	numbers = parseInt(numbers)+1;
var trHTML =  '<tr id="row'+numbers+'">' +
                             '<td>用品</td><td>' +
                             /*'<label>' +*/
                               '<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail_'+numbers+'_.office_name" name="zxGoodsApplyDetail['+numbers+'].office_name" data-bv-notempty data-bv-notempty-message="请输入用品">'+
                             '</td><td>数量</td><td>' +
                             '<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail_'+numbers+'_.amount" name="zxGoodsApplyDetail['+numbers+'].amount" data-bv-notempty data-bv-notempty-message="请输入用品">'+
                             '</td><td>用途</td><td>' +
                             '<input class="form-control" type="text" maxlength="20"  name="zxGoodsApplyDetail['+numbers+'].reason"  id="zxGoodsApplyDetail_'+numbers+'_.reason"   data-bv-notempty data-bv-notempty-message="请输入用途">'+
                              '</td><td><button type="button" class="btn btn-primary" onclick="delrow('+numbers+')">删除</button></td>' +
                              
                             '</tr>';
      $("#tab").append(trHTML); 
       document.getElementById("zxGoodsApplyDetail_"+numbers+"_.office_name").value=document.getElementById("detailname").value;
      document.getElementById("zxGoodsApplyDetail_"+numbers+"_.amount").value=document.getElementById("amount").value;
      document.getElementById("zxGoodsApplyDetail_"+numbers+"_.reason").value=document.getElementById("reason").value;
     
	$('#adddetail').modal('hide');
}

function delrow(obj){
	t.row( $(obj).parents('tr')).remove().draw();
}