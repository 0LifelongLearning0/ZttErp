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
            	var single_price=document.getElementById("time").value;
            	if (!/^(?:[1-9]\d*|0)(?:\.\d+)?$/.test(single_price)) {
            		layer.alert('输入单价不合法');
            		flag = 1;
            		return;
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
	var index=document.getElementById("index").value;
	var body = parent.layer.getChildFrame('body', index);
	var machine_part=document.getElementById("machine_part").value;
	var machine_part_number=document.getElementById("machine_part_number").value;
	var material_id=document.getElementById("material_id").value;
	body.contents().find("#machine_part").val(machine_part);
	body.contents().find("#machine_part_number").val(machine_part_number);
	body.contents().find("#material_id").val(material_id);
	parent.$('#machine_part').val(document.getElementById("machine_part").value);
	parent.$('#machine_part_number').val(document.getElementById("machine_part_number").value);
	parent.$('#material_id').val(document.getElementById("material_id").value);
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

function delrow(obj){
	t.row( $(obj).parents('tr')).remove().draw();
}