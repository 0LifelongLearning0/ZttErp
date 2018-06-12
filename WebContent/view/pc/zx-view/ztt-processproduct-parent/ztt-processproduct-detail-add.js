var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	InitBDataCombogongxu("Processname");
            });
            
	function showaddpage(){
		parent.layer.open({
			title : '下载附件',
			type : 2,
			area : [ '600px', '450px' ],
			btn : [ '关闭' ],
			content : "../zttProcessproductParentController/toZttProcessproductdetailAdd"

		})
	}
	function addRow(){
	}

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
	/*t.row( $(obj).parents('tr')).remove().draw();*/
	t.row( $(obj).parent('td').parents('tr')).remove().draw();
}