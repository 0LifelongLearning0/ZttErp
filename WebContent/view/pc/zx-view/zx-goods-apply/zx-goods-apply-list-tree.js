var numbers;
function GoodsSelect(){
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

//单击事件
function onClick(event, treeId, treeNode, msg){  
}  
function doGoodsSelect(){
	var zTree = $.fn.zTree.getZTreeObj("tree"),
	nodes = zTree.getSelectedNodes();
	if (nodes.length != 1) {
		toastrBoot(4,"请选择一条隶属用品信息");
		return;
	}
	if(nodes[0].content=="office"){
		msgTishCallFnBoot("确定要选择【<font color=red>"+nodes[0].name+"</font>】？",function(){
		document.getElementById('detailname').value=nodes[0].name;
		document.getElementById('stardard').value=nodes[0].tempObject;
		document.getElementById('goods_id').value=nodes[0].id;
		/*document.getElementById('zxGoodsApplyDetail['+numbers+'].goods_id').value=nodes[0].id;*/
		$('#departSelectModal').modal('hide');
	})
	}else{
		msgTishBoot("请选择用品!",function(){});
	}
	
}



