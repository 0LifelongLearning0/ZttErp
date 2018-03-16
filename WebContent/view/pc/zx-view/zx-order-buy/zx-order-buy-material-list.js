var zxMaterialWin;
var zxMaterialGrid;
var zxMaterialStore;
var zxMaterialGrided;
var zxMaterialSotreed;
var zxBuyApplyPanel;
var zxBuyApplyStore;
function addZxOrderBuyMaterial(order_id,order_name){
	initZxMaterialGrid(order_id);
	initZxMaterialGrided(order_id);
	initZxBuyApplyPanel(order_id);
	reGetWidthAndHeight();
	zxMaterialWin = Ext.create('top.Ext.Window',{
		layout:'border', 
		maximizable:true,
		minimizable:true,
		maximized:true,
		plain:true,
		modal:true,
		width:clientWidth,                    
		height:clientHeight, 
		headerPosition:'top',
		title:'导入物料',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:[zxApplyPanel,
			  {
			  	region:'center',
			  	items:[
			  	{
			  		items:zxMaterialGrid
			  	},
			  	{
			  		items:zxMaterialGrided
			  	}
			  	]
			  }
			  ]
	});
	zxMaterialWin.setTitle("采购订单--->导入物料--->"+order_name);
	zxMaterialWin.show();
}


/**待导入物料**/
function initZxMaterialGrid(order_id){
	reGetWidthAndHeight();
	zxMaterialStore = getGridJsonStore('../zxOrderBuyController/getMaterialListByCondition?flag=2&order_id='+order_id,[]);
	zxMaterialGrid = Ext.create('top.Ext.grid.Panel',{
		region:'north',
		store:zxMaterialStore,
		height:document.documentElement.clientHeight*0.6,
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		selType:'checkboxmodel',
		title:'待导入物料',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		loadMask:{
			msg:'正在加载...'
		},
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'申请编码',
				width:120,
				dataIndex:'apply_num'
			},
			{
				header:'物料编码',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'物料名称',
				flex:1,
				dataIndex:'short_name'
			},
			{
				header:'规格型号',
				flex:1,
				dataIndex:'standard'
			},
			{
				header:'材质',
				flex:1,
				dataIndex:'caizhi'
			},
			{
				header:'品牌',
				flex:1,
				dataIndex:'brand'
			},
			{
				header:'单位',
				flex:1,
				dataIndex:'unit'
			},
			{
				header:'总数量',
				width:80,
				dataIndex:'amount'
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
			}
		],
		tbar:[
			 {
				text:'导入物料',
				tooltip:'导入物料',
				scope:this,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addZxOM(order_id);
				}
			 }
		],
		bbar:getGridTopBBar(zxMaterialStore)
	});
}


/**已导入物料**/
function initZxMaterialGrided(order_id){
	reGetWidthAndHeight();
	zxMaterialStoreed = getGridJsonStore('../zxOrderBuyController/getMaterialListByCondition?flag=1&order_id='+order_id,[]);
	zxMaterialGrided = Ext.create('top.Ext.grid.Panel',{
		region:'center',
		store:zxMaterialStoreed,
		height:document.documentElement.clientHeight*0.7,
		style:'margin-left:auto;margin-right:auto;margin-bottom:auto;',
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		border:false,
		selType:'checkboxmodel',
		/**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
		title:'已导入物料',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		loadMask:{
			msg:'正在加载...'
		},
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'申请编码',
				width:120,
				dataIndex:'apply_num'
			},
			{
				header:'物料编码',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'物料名称',
				flex:1,
				dataIndex:'short_name'
			},
			{
				header:'规格型号',
				flex:1,
				dataIndex:'standard'
			},
			{
				header:'材质',
				flex:1,
				dataIndex:'caizhi'
			},
			{
				header:'品牌',
				flex:1,
				dataIndex:'brand'
			},
			{
				header:'单位',
				flex:1,
				dataIndex:'unit'
			},
			{
				header:'总数量',
				width:80,
				dataIndex:'amount'
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
			},
			{
				header:'承诺到货时间',
				flex:1,
				dataIndex:'agree_time'
			}
		],
		tbar:[
			 {
				text:'移除物料',
				tooltip:'移除物料',
				scope:this,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxOM(order_id);
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				scope:this,
				cls:'editBtn',
				icon:editIcon,
				handler:function(){
					editZxOM();
				}
			 }
		],
		bbar:getGridTopBBar(zxMaterialStoreed)
	});
}


function initZxBuyApplyPanel(order_id){
	//1创建store
	zxApplyStore = Ext.create('Ext.data.TreeStore', {  
		root:{
			text : '所有申请单',
			id:'0',
			expanded:true
		},
         proxy:{  
                type:'ajax',  
                url:'../zxBuyApplyController/getZxBuyApplyTree',  
                reader:{  
                    type:'json',  
                    rootProperty:'items'  
                }
         }  
	});  
	//2创建treePanel
	zxApplyPanel = Ext.create('top.Ext.tree.Panel',{   
		region:'west',
        store:zxApplyStore,  
        autoEncode:true,//提交时是否自动编码   
        rootVisible:true,  
        width:300,
        collapsible:true,
        title:'采购申请',
        /**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        listeners:{  
            itemclick:function(node,optd){
            	menuClick(optd,order_id);
            }  
        }
    });  
}

/**导入物料**/
function addZxOM(order_id){
	var model = zxMaterialGrid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择待导入物料');
		return;
	}
	var apply_material_id;
	var material_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == apply_material_id){
			apply_material_id=model.selected.items[i].data.id;
			material_id=model.selected.items[i].data.material_id;
		}else{
			apply_material_id=apply_material_id+","+model.selected.items[i].data.id;
			material_id=material_id+","+model.selected.items[i].data.material_id;
		}
	}
	top.Ext.Msg.confirm('提示','确定导入所选物料？',function(btn){
		if(btn == 'yes'){
			var params = {apply_material_id:apply_material_id,material_id:material_id,order_id:order_id};
			showWaitMsg("正在导入中...");
			Ext.Ajax.request({  
				params:params, 
			    url:'../zxOrderBuyController/addZxOM',  
			    method:'post',  
			    success:function(response,opts){
			    	hideWaitMsg();
			    	var obj=Ext.decode(response.responseText);  
	       			top.Ext.example.msg('提示', obj.msg);//提示之后消失
					zxMaterialGrid.getStore().reload();
					zxMaterialGrided.getStore().reload();
			    },  
			    failure:function(response,opts){  
			    	hideWaitMsg();
			    }  
			});
		}
	});
}

/**移除物料**/
function delZxOM(order_id){
	var model = zxMaterialGrided.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择要移除的物料');
		return;
	}
	var apply_material_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == apply_material_id){
			apply_material_id=model.selected.items[i].data.id;
		}else{
			apply_material_id=apply_material_id+","+model.selected.items[i].data.id;
		}
	}
	top.Ext.Msg.confirm('提示','确定移除所选物料？',function(btn){
		if(btn == 'yes'){
			var params = {apply_material_id:apply_material_id,order_id:order_id};
			showWaitMsg("正在移除物料中...");
			Ext.Ajax.request({  
				params:params, 
			    url:'../zxOrderBuyController/delZxOM',  
			    method:'post',  
			    success:function(response,opts){
			    	hideWaitMsg();
			    	var obj=Ext.decode(response.responseText);  
	       			top.Ext.example.msg('提示', obj.msg);//提示之后消失
					zxMaterialGrid.getStore().reload();
					zxMaterialGrided.getStore().reload();
			    },  
			    failure:function(response,opts){  
			    	hideWaitMsg();
			    }  
			});
		}
	});
}

/**编辑物料**/
function editZxOM(){
	var model = zxMaterialGrided.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择要编辑的物料');
		return;
	}
	var id = model.selected.items[0].data.order_buy_material_id;
	updateZxOrderBuyMaterial(id);
}

//菜单点击事件
function menuClick(node,order_id){
 	var id = node.data.id;
 	var type = node.data.type;
 	var parm = {apply_id:id};
 	load(zxMaterialGrid,parm);
 	load(zxMaterialGrided,parm);
}
var zxOrderBuyMaterialWinEdit;
var zxOrderBuyMaterialFormEdit;
function updateZxOrderBuyMaterial(id){
	initZxOrderBuyMaterialFormEdit();
	zxOrderBuyMaterialWinEdit = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:500,
		height:300,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'编辑信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOrderBuyMaterialFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOrderBuyMaterialFormEdit,'../zxOrderBuyMaterialController/updateZxOrderBuyMaterial',zxMaterialGrided,zxOrderBuyMaterialWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOrderBuyMaterialWinEdit.show();
	
	loadFormData(zxOrderBuyMaterialFormEdit,'../zxOrderBuyMaterialController/getZxOrderBuyMaterialById?id='+ id);
}
function initZxOrderBuyMaterialFormEdit(){
	zxOrderBuyMaterialFormEdit = Ext.create('top.Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		/**新方法使用开始**/
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		/**新方法使用结束**/
		fieldDefaults:{
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
			fieldLabel:'标识',
			xtype:'textfield',
			hidden:true,
			name:'id',
			allowBlank:false,
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'订单标识',
			xtype:'textfield',
			name:'order_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'申请单物料标识',
			xtype:'textfield',
			name:'apply_material_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'物料标识',
			xtype:'textfield',
			name:'material_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'承诺到货时间',
			xtype:'datefield',
			format:'Y-m-d',
			name:'agree_time',
			maxLength:10,
			anchor:'100%'
		}
		]
	});
}