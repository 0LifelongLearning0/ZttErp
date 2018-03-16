Ext.require([
   	'Ext.window.Window',
    'Ext.tab.*',
    'Ext.toolbar.Spacer',
    'Ext.layout.container.Card',
    'Ext.layout.container.Border',
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.state.*'
]);
var store;
var grid;
var zx_material_classify_leaf;
var zx_material_classify_delete;
Ext.onReady(function(){
	zx_material_classify_leaf = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","是"],["1","否"]]
	});
	zx_material_classify_delete = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","正常"],["1","删除"]]
	});
	 store = Ext.create('Ext.data.TreeStore',{
	    	root:{
				name:'一级',
				id:'0',
				expanded:true
			},
			/**此处一定要设置否则全部展开节点无效**/
			autoLoad:false,
	        proxy:{
	            type:'ajax',
	            method:'post',
				url:'../zxMaterialClassifyController/getZxMaterialClassifyList',
				reader:{
					type:'json'
				},
				extraParams:{id:'0',type:encodeURI('菜单'),expanded:true}
	        }
	    });
	 grid = Ext.create('Ext.tree.Panel', {
	    	region:'center',
	    	xtype:'filtered-tree',
	        reserveScrollbar:true,
	        collapsible:false,
	        loadMask:true,
	        useArrows:true,
	        rootVisible:false,
	        store:store,
	        autoSctroll:true,
	        id:'treeGrid',
	        animate:true,
	        columnLines:true,
	        frame:true,
	        bufferedRenderer:false,
	        viewConfig:{
				emptyText:'暂无数据',
				stripeRows:true
			},
			tbar:[
			{
			   width:260,
			   xtype:'triggerfield',
			   emptyText:'请输入关键字（如分类等）',
		      /* triggerCls:'x-form-clear-trigger',*/
		       /*onTriggerClick:function(){
		           this.reset();
		       },*/
		       listeners:{
		           change:function(){
		           	filterBy(grid,this.getValue(),'text');
		           },
		           buffer:250
		       }
			},
			{
				text:'添加',
				tooltip:'添加',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addZxMaterialClassify();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxMaterialClassify();
				}
			 },
	       	 {
	           text:'刷 新',
			   tooltip:'刷 新',
			   xtype:'button',
			   minWidth:tbarBtnMinWidth,
			   cls:'refreshBtn',
			   icon:refreshIcon,
	           handler:function(){
		           	refresh();
	           }
	       	 }],
	        columns:[
	        {
				header:'序列号',
	            flex:2,
	            hideable:false,
	            hidden:true,
	            sortable:true,
				dataIndex:'id'
			},{
	            xtype:'treecolumn',
	            text:'名称',
	            flex:1,
	            sortable:true,
	            dataIndex:'text'
	        },{
	            text:'全名',
	            dataIndex:'tempObject',
	            sortable:true,
	            flex:1,
	            renderer:function(value){
	            	var vals = value.split(",");
	            	return vals[0];
	            }
	        },{
	            text:'分类编号',
	            dataIndex:'tempObject',
	            sortable:true,
	            flex:1,
	            renderer:function(value){
	            	var vals = value.split(",");
	            	return vals[1];
	            }
	        },{
	            text:'状态',
	            dataIndex:'content',
	            sortable:true,
	            width:100,
	            renderer:function(value){
	            	if(value == "1"){
	            		return "<font color='red'>删除</font>";
	            	}else if(value == "0"){
	            		return "正常";
	            	}
	            }
	        }]
	    });
	    Ext.create('Ext.Viewport', {
			layout:'border',
			xtype:'viewport',
			items:[grid]
		});
		showWaitMsg("正在加载数据...");
		refresh();
		//调用右键
		initRight();
});
/**删除操作**/
function delZxMaterialClassify(){
	var model = grid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再删除');
		return;
	}
	var classify_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == classify_id){
			classify_id=model.selected.items[i].data.classify_id;
		}else{
			classify_id=classify_id+","+model.selected.items[i].data.classify_id;
		}
	}
	Ext.Msg.confirm('提示','确定删除该行数据？',function(btn){
		if(btn == 'yes'){
			var params = {classify_id:classify_id};
			ajaxRequest('../zxMaterialClassifyController/delZxMaterialClassify',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxMaterialClassify(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {classify_id:record.items[0].data.id};
			ajaxRequest('../zxMaterialClassifyController/copyZxMaterialClassify',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxMaterialClassifyItem',
			handler:function(){addZxMaterialClassify();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxMaterialClassifyItem',
			handler:function(){updateZxMaterialClassify();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxMaterialClassifyItem',
			handler:function(){delZxMaterialClassify();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxMaterialClassifyItem',
			handler:function(){copyZxMaterialClassify();}
		},{
            text:'刷 新',
            glyph:0xf021,
            handler:function(){
            	refresh();
            }
        }]
	});
	initrightgridcontextmenu(grid,contextmenu,['updateZxMaterialClassifyItem','delZxMaterialClassifyItem','copyZxMaterialClassifyItem']);
}
/**查询操作**/
/*function search(){
	initSearch(store,'../zxMaterialClassifyController/getZxMaterialClassifyListByCondition',searchForm);
}*/

function refresh(){
	showWaitMsg("正在加载数据...");
	/**
	new Ext.util.DelayedTask(function(){  
       
    }).delay(1000);
    **/
	store.on('load',function(){
		grid.expandAll();
	    hideWaitMsg();
    });
}