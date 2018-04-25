var numbers=-1;
var t;
var counter;
$(document).ready(function(){
             t =$("#example").DataTable({
                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });
             counter = 0;
             $('#delrow').on('click', function() {
            	 t.row( $(obj).parent('td').parents('tr')).remove().draw();
             });
            });
            
	function showaddpage(){
	/*	layer.open({
			title : '下载附件',
			type : 2,
			area : [ '600px', '450px' ],
			btn : [ '确定','关闭' ],
			content : "../zttProcessproductParentController/toZttProcessproductdetailAdd",
			yes: function (layero, index){
				 var body = layer.getChildFrame('body', index);
				 addRow(index);
			}

		});*/
		
		
		layer.open({
            title: false,
            type: 2,
            closeBtn: false,
            area: ['420px', '450px'],
            skin: 'layui-layer-rim', //加上边框
            btn : [ '确定','关闭' ],
            content : "../zttProcessproductParentController/toZttProcessproductdetailAdd",
            yes: function (layero, index) {
                
            	addRow(layero);
            	

            }
         
        });
	}
	function addRow(layero){
		var flag=0;
        var body = layer.getChildFrame('body', layero); 
        var Processname=body.contents().find('#Processname').val();
        var index=Processname;
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
    	var single_price=body.contents().find('#time').val();
    	if (!/^(?:[1-9]\d*|0)(?:\.\d+)?$/.test(single_price)) {
    		layer.alert('输入单价不合法');
    		flag = 1;
    		return;
    	}
    	
    	if(index==0){
    		flag=1;
    		layer.alert("请选择工序名称");
    	}
        var Processcontent=body.contents().find('#Processcontent').val();
        var equipment=body.contents().find('#equipment').val();
        var tooling=body.contents().find('#tooling').val();
        if(flag==0){
        	 t.row.add([
                        counter+1,
                        '<input type="hidden" name="zttProcessproduct['+counter+'].Processname"  value="'+Processname+'"/>'+ select,
                        '<input type="hidden" name="zttProcessproduct['+counter+'].Processcontent" value="'+Processcontent+'"/>'+ Processcontent,
                         '<input type="hidden" name="zttProcessproduct['+counter+'].equipment" value="'+equipment+'"/>'+equipment,
                        '<input type="hidden" name="zttProcessproduct['+counter+'].tooling" value="'+tooling+'"/>' +tooling,
                        '<input type="hidden" name="zttProcessproduct['+counter+'].single_price" value="'+single_price+'"/>'+single_price,
                          '<button type="button" class="btn btn-primary" onclick="delrow(this)">删除</button>'
                    ]).draw();
             counter++;	
            layer.close(layero);
        }
       
	}

//保存
function addZxGoodsApply(){
	submitBForm1('defaultForm','../zttProcessproductParentController/addZttProcessproductParent','../zttProcessproductParentController/loadZttProcessproductParent');
}

function submitBForm1(formid,url,callUrl){
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
			        				 var index = parent.layer.getFrameIndex(window.name);  
			        	                parent.layer.close(index);  
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