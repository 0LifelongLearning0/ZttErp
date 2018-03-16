//返回r
function goback(){
	tlocation("../zxSixSContentController/loadZxSixSContent?six_s_id=" + $('#six_s_id').val());
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxSixSContent(){
	if($('#dep_id').val() == ''){
		toastrBoot(4,"请选择责任部门");
		return;
	}
	if($('#user_id').val() == ''){
		toastrBoot(4,"请选择责任人");
		return;
	}
	if($('#end_date').val() == ''){
		toastrBoot(4,"请选择完成期限");
		return;
	}
	submitBForm('defaultForm','../zxSixSContentController/addZxSixSContent','../zxSixSContentController/loadZxSixSContent?six_s_id=' + $('#six_s_id').val());
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
	InitMyDataCombo("six_s_check_place","place_id");
});
function InitMyDataCombo(ckey,id){
	var str = "<option value=''>请选择</option>";
	$.ajax({
	   type:"GET",
	   url:"../xtCommonController/getXtDataDictionaryList",
	   data:"ckey="+ckey,
	   success: function(data){
         $.each(data, function(i, item){
         	 str += "<option value=" + item.xt_data_dictionary_id + ">" + item.xt_data_dictionary_name + "</option>";
         })
         $("#"+id).append(str);
	   }
	});
}
/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
initBFileRight('problem_pic','problem_pic_pic',1);
/**初始化附件右键菜单结束**/

/////////////////////部门选择器开始///////////////////
function departSelect(){
	$('#departSelectModal').modal();
	var setting = {
	   view:{
	       selectedMulti:false
	   },
	   check:{
	       enable:false
	   },
	   async:{
	       enable:true,//设置 zTree是否开启异步加载模式  加载全部信息
	       url:"../xtDepartinfoController/getXtDepartinfoBZTree",//Ajax获取数据的 URL地址  
	       otherParam:{ 
	    	 　　'expanded':function(){return 'true'} 
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

//单击事件
function onClick(event, treeId, treeNode, msg){  
}  

function doDepartSelect(){
	var zTree = $.fn.zTree.getZTreeObj("tree"),
	nodes = zTree.getSelectedNodes();
	if (nodes.length != 1) {
		toastrBoot(4,"请选择一条隶属部门信息");
		return;
	}
	msgTishCallFnBoot("确定要选择【<font color=red>"+nodes[0].name+"</font>】？",function(){
		$('#xt_departinfo_name').val(nodes[0].name);
		$('#dep_id').val(nodes[0].id);
		$('#xt_post_name').val("");
		$('#xt_post_id').val("");
		$('#departSelectModal').modal('hide');
	})
}
/////////////////////部门选择器结束///////////////////
