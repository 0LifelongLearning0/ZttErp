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
            	$('#login-form-id').bootstrapValidator({
            fields: {
                amount: {
                    validators: {
                        regexp: {
                        	regexp: /^[+]?\d+(\.\d+)?$/, 
                        	message:'用户名仅支数字'
                        }
                         
                    }
                },
                estimated_price: {
                    validators: {
                       regexp: {
                        	regexp: /^[+]?\d+(\.\d+)?$/, 
                        	message:'用户名仅支数字'
                        }
                    }
                },
                   reason: {
                    validators: {
                        notEmpty: {
                            message: '用途不能为空'
                        }
                    }
                }
            } });
          
            	  $('#login-form-id').data('bootstrapValidator').validate();
            	  if(!$('#login-form-id').data('bootstrapValidator').isValid()){ 
            	  }
            	  else{
            	  	 t.row.add([
                    counter+1,
                   '<input type="hidden" name="zxGoodsApplyDetail['+counter+'].goods_id"  value="'+document.getElementById("goods_id").value+'"/><input type="hidden" name="zxGoodsApplyDetail['+counter+'].detailname" value="+document.getElementById("detailname").value+"/>'+ document.getElementById("detailname").value,
                    '<input type="hidden" name="zxGoodsApplyDetail['+counter+'].stardard" value="'+document.getElementById("stardard").value+'"/>'+ document.getElementById("stardard").value,
                     '<input type="hidden" name="zxGoodsApplyDetail['+counter+'].amount" value="'+document.getElementById("amount").value+'"/>'+ +document.getElementById("amount").value,
                    '<input type="hidden" name="zxGoodsApplyDetail['+counter+'].estimated_price" value="'+document.getElementById("estimated_price").value+'"/>'+ +document.getElementById("estimated_price").value,
                    '<input type="hidden" name="zxGoodsApplyDetail['+counter+'].reason" value="'+document.getElementById("reason").value+'"/>'+document.getElementById("reason").value,
                      '<button type="button" class="btn btn-primary" onclick="delrow(this)">删除</button>'
                ]).draw();
                counter++;
            	  }
               $('#addModal').modal(options);
            });
            
        });
	
//返回r
function goback(){
	tlocation("../zxGoodsApplyController/loadZxGoodsApply");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});

//保存
function addZxGoodsApply(){
	submitBForm('defaultForm','../zxGoodsApplyController/addZxGoodsApply','../zxGoodsApplyController/loadZxGoodsApply');
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
	//验证
	var boostrapValidator =bootform.data('bootstrapValidator');
	boostrapValidator.validate();
	//验证有效开启发送异步请求
	if(boostrapValidator.isValid()){
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
	}else{
		window.parent.toastrBoot(4,"存在不合法的字段!");
	}
}
//初始化日期选择器


/*function addZxGoodsApplyDetailItems111(){
	
	validatorDestroy('defaultForm');
	var numbers = $('#zxGoodsApplyDetailFormNumber').val();
	numbers = parseInt(numbers)+1;
	$('#zxGoodsApplyDetailFormNumber').val(numbers);
	//点击添加新一行
	var removeBtn = '<a class="btn btn-danger" href="javascript:delZxGoodsApplyDetailItems(this,'+numbers+')" >删除该条信息</a>';
	var form = '<div id="form_zxGoodsApplyDetail_'+numbers+'">'+
	           '<fieldset>'+
	           '<legend><h5>序号'+numbers+'</h5></legend>'+
	           '<div class="form-group"><div class="col-lg-3">'+removeBtn+'</div></div>'+
			    '<div class="form-group">'+
				'<label class="col-lg-3 control-label">用品</label>'+
				'<div class="col-lg-6">'+
				     '<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail['+numbers+'].office_name" name="zxGoodsApplyDetail['+numbers+'].office_name" data-bv-notempty data-bv-notempty-message="请输入用品" onclick="GoodsSelect('+numbers+')">'+
				     '<input class="form-control" type="text" maxlength="20"  name="zxGoodsApplyDetail['+numbers+'].amount"  id="zxGoodsApplyDetail_'+numbers+'_amount"   data-bv-notempty data-bv-notempty-message="请输入数量" min="0" max="99999">'+
				'</div>'+
			   '</div>'+
				    '</fieldset>'+
					'</div>'
	$("#AddForm").append(form);
	var trHTML =  '<tr>' +
                             '<td>用品</td><td>' +
                               '<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail['+numbers+'].office_name" name="zxGoodsApplyDetail['+numbers+'].office_name" data-bv-notempty data-bv-notempty-message="请输入用品" onclick="GoodsSelect('+numbers+')">'+
                             '</td><td>数量</td><td>' +
                             '<input class="form-control" type="text" maxlength="32"  id="zxGoodsApplyDetail['+numbers+'].amount" name="zxGoodsApplyDetail['+numbers+'].amount" data-bv-notempty data-bv-notempty-message="请输入用品">'+
                             '</td><td>用途</td><td>' +
                             '<input class="form-control" type="text" maxlength="20"  name="zxGoodsApplyDetail['+numbers+'].reason"  id="zxGoodsApplyDetail['+numbers+'].reason"   data-bv-notempty data-bv-notempty-message="请输入用途">'+
                              '</td><td><button type="button" class="btn btn-primary">删除</button></td>' +
                              
                             '</tr>';
      $("#tab").append(trHTML);   
       document.getElementById("detailname").value="";
      document.getElementById("amount").value="";
     document.getElementById("reason").value="";
	datetimeInit();
	reValidator('defaultForm');
	
	
	
}*/
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
function addZxGoodsApplyDetailItems(){
	document.getElementById("detailname").value="";
	document.getElementById("stardard").value="";
     document.getElementById("amount").value="";
     document.getElementById("estimated_price").value="";
     document.getElementById("reason").value="";
	$('#adddetail').modal();
}
function GoodsSelect1(){
	$('#departSelectModal1').modal();
	var setting = {
	   view:{
	       selectedMulti:false
	   },
	   check:{
	       enable:false
	   },
	   async:{
	       enable:true,//设置 zTree是否开启异步加载模式  加载全部信息
	       url:"../zxGoodsApplyController/getGoodsTree",//Ajax获取数据的 URL地址  
	       otherParam:{ 
	    	 　　'expanded':function(){return 'false'},
	    	     id:'0',
	    	     type:encodeURI('分类')
	       } //异步参数
	   },
	   data:{
		   //必须使用data  
	       simpleData:{
	           enable:true,
	           idKey:"id",//id编号命名 默认  
	           pIdKey:"pId",//父id编号命名 默认   
	           rootPId:0 //用于修正根节点父节点数据，即 pIdKey 指定的属性值  
	       }
	   },
	   edit:{
	       enable:false
	   },  
	   callback:{  
	       onClick:onClick//单击事件
	   }  
	};
	$.fn.zTree.init($("#tree"), setting);
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