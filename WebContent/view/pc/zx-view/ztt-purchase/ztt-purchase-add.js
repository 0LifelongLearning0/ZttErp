$(function() {
	$(".form_datetime").datepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		todayHighlight : true,
		showMeridian : true,
		pickerPosition : "bottom-left",
		language : 'zh-CN',// 中文，需要引用zh-CN.js包
	});

});

//返回r
function goback(){
	tlocation("../zttPurchaseController/loadZttPurchase");
}
//保存
function addZttPurchase(){
	submitBForm('defaultForm','../zttPurchaseController/addZttPurchase','../zttPurchaseController/loadZttPurchase');
}

function addZttPurchaseSonItems(){
	var numbers = $('#zttPurchaseSonFormNumber').val();
	numbers = parseInt(numbers)+1;
	$('#zttPurchaseSonFormNumber').val(numbers);
	//点击添加新一行
	var removeBtn = '<a class="btn btn-danger" href="javascript:delZttPurchaseSonItems(this,'+numbers+')" >删除该条信息</a>';
	var form ='<div id="form_zttPurchaseSon_'+numbers+'">'+
	'<fieldset>'+
	'<legend><h5>序号'+numbers+'</h5></legend>'+
	'<div class="form-group"><div class="col-lg-3">'+removeBtn+'</div></div>'+
	'<input class="form-control" type="hidden" maxlength="32"  id="zttPurchaseSon_'+numbers+'_parent_id" name="zttPurchaseSon['+numbers+'].parent_id"  placeholder="请输入父id">'+
		'<table>'+
		'<tr>'+
		'<td><label class="control-label">工令号</label></td>'+
		'<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon_'+numbers+'_Product_order_number" name="zttPurchaseSon['+numbers+'].Product_order_number"  placeholder="请输入名称"></div></td>'+
		
		'<td><label class="control-label">名称</label></td>'+
		'<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon_'+numbers+'_name" name="zttPurchaseSon['+numbers+'].name"  placeholder="请输入名称"></div></td>'+
		'<td><label class="control-label">规格</label></td>'+
		'<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon_'+numbers+'_purchase_stardard" name="zttPurchaseSon['+numbers+'].purchase_stardard"  placeholder="请输入规格"></td>'+
		'<td><label class="control-label">材质</label></td>'+
		'<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon_'+numbers+'_material" name="zttPurchaseSon['+numbers+'].material"  placeholder="请输入名称"></td>'+
		'<td><label class="control-label">单位</label></td>'+
		'<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon_'+numbers+'_unit" name="zttPurchaseSon['+numbers+'].unit"  placeholder="请输入名称"></td>'+
		'<td><label class="control-label">数量</label></td>'+
		'<td><input class="form-control" type="text" maxlength="255"  id="zttPurchaseSon_'+numbers+'_amount" name="zttPurchaseSon['+numbers+'].amount"  placeholder="请输入名称"></td>'+
		'<td><label class="control-label" >交期</label></td>'+
		'<td><input class="form_datetime form-control" type="text" maxlength="255"  id="zttPurchaseSon_'+numbers+'_hope_end_data" name="zttPurchaseSon['+numbers+'].hope_end_data"  placeholder="请输入交期"></td>'+
		'<td><label class="control-label">上传附件</label></td>'+
		'<td><button class="btn btn-primary" data-toggle="button" onclick="uploadattachment('+numbers+')">请上传附件</button>'+
		'<input class="form-control" type="hidden" maxlength="255"  id="zttPurchaseSon_'+numbers+'_attachment" name="zttPurchaseSon['+numbers+'].attachment"  placeholder="请输入名称"></td>'+
		'</tr>'+
	   '</table>'+
		'</fieldset>'+
		'</div>'
		
	$(".form_zttPurchaseSon").append(form);
	$(".form_datetime").datepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		todayHighlight : true,
		showMeridian : true,
		pickerPosition : "bottom-left",
		language : 'zh-CN',// 中文，需要引用zh-CN.js包
	});
	reValidator('defaultForm');

}
function delZttPurchaseSonItems(thiz,numbers){
	validatorDestroy('defaultForm');
	$("#form_zttPurchaseSon_"+numbers).remove();
	var zttPurchaseSon_removed_flag = $('#zttPurchaseSon_removed_flag').val()
	if(null == zttPurchaseSon_removed_flag || '' == zttPurchaseSon_removed_flag){
		$('#zttPurchaseSon_removed_flag').val(','+numbers+',');
	}else{
		$('#zttPurchaseSon_removed_flag').val(zttPurchaseSon_removed_flag+numbers+',')
	}
	reValidator('defaultForm');
}
function uploadattachment(numbers) {
	var upid="zttPurchaseSon_"+numbers+"_attachment";
	layer.open({
		title : '上传附件',
		type : 2,
		area : [ '800px', '500px' ],
		btn : [ '确定', '取消' ],
		content : "../zttOrderController/uploadattachment?upid="+upid

	});
}
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
	//验证
	//验证有效开启发送异步请求
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
			        			if(null != callUrl){
			                		//默认返回页面
			                    	tlocation(callUrl);
			                	}
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
