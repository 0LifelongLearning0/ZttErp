var zxWorkpieceWin;
var zxWorkpieceGrid;
var zxWorkpieceStore;
var zxWorkpieceGrided;
var zxWorkpieceSotreed;
var zxOutApplyPanel;
var zxOutApplyStore;
var out_type;
var out_properties;
function addZxOrderOutWorkpiece(order_id,order_name){
	initZxWorkpieceGrid(order_id);
	initZxWorkpieceGrided(order_id);
	initZxOutApplyPanel(order_id);
	reGetWidthAndHeight();
	zxWorkpieceWin = Ext.create('top.Ext.Window',{
		layout:'border', 
		maximizable:true,
		minimizable:true,
		maximized:true,
		plain:true,
		modal:true,
		width:clientWidth,                    
		height:clientHeight, 
		headerPosition:'top',
		title:'导入工件',
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
			  		items:zxWorkpieceGrid
			  	},
			  	{
			  		items:zxWorkpieceGrided
			  	}
			  	]
			  }
			  ]
	});
	zxWorkpieceWin.setTitle("采购订单--->导入工件--->"+order_name);
	zxWorkpieceWin.show();
}


/**待导入工件**/
function initZxWorkpieceGrid(order_id){
	reGetWidthAndHeight();
	zxWorkpieceStore = getGridJsonStore('../zxOrderOutController/getWorkpieceListByCondition?flag=2&order_id='+order_id,[]);
	zxWorkpieceGrid = Ext.create('top.Ext.grid.Panel',{
		region:'north',
		store:zxWorkpieceStore,
		height:document.documentElement.clientHeight*0.6,
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		selType:'checkboxmodel',
		title:'待导入工件',
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
				header:'工件编码',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'工件名称',
				flex:1,
				dataIndex:'name'
			},
			{
				header:'单位',
				flex:1,
				dataIndex:'unit'
			},
			{
				header:'外协类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					return initComBoData(out_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'加工属性',
				flex:1,
				dataIndex:'properties',
				renderer:function(value){
					return initComBoData(out_properties,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
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
				text:'导入工件',
				tooltip:'导入工件',
				scope:this,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addZxOM(order_id);
				}
			 }
		],
		bbar:getGridTopBBar(zxWorkpieceStore)
	});
}


/**已导入工件**/
function initZxWorkpieceGrided(order_id){
	reGetWidthAndHeight();
	zxWorkpieceStoreed = getGridJsonStore('../zxOrderOutController/getWorkpieceListByCondition?flag=1&order_id='+order_id,[]);
	zxWorkpieceGrided = Ext.create('top.Ext.grid.Panel',{
		region:'center',
		store:zxWorkpieceStoreed,
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
		title:'已导入工件',
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
				header:'工件编码',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'工件名称',
				flex:1,
				dataIndex:'name'
			},
			{
				header:'单位',
				flex:1,
				dataIndex:'unit'
			},
			{
				header:'外协类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					return initComBoData(out_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'加工属性',
				flex:1,
				dataIndex:'properties',
				renderer:function(value){
					return initComBoData(out_properties,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
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
				text:'移除工件',
				tooltip:'移除工件',
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
		bbar:getGridTopBBar(zxWorkpieceStoreed)
	});
}


function initZxOutApplyPanel(order_id){
	//1创建store
	zxApplyStore = Ext.create('Ext.data.TreeStore', {  
		root:{
			text : '所有申请单',
			id:'0',
			expanded:true
		},
         proxy:{  
                type:'ajax',  
                url:'../zxOutApplyController/getZxOutApplyTree',  
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
        title:'外协申请',
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

/**导入工件**/
function addZxOM(order_id){
	var model = zxWorkpieceGrid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择待导入工件');
		return;
	}
	var apply_workpiece_id;
	var workpiece_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == apply_workpiece_id){
			apply_workpiece_id=model.selected.items[i].data.id;
			workpiece_id=model.selected.items[i].data.workpiece_id;
		}else{
			apply_workpiece_id=apply_workpiece_id+","+model.selected.items[i].data.id;
			workpiece_id=workpiece_id+","+model.selected.items[i].data.workpiece_id;
		}
	}
	top.Ext.Msg.confirm('提示','确定导入所选工件？',function(btn){
		if(btn == 'yes'){
			var params = {apply_workpiece_id:apply_workpiece_id,workpiece_id:workpiece_id,order_id:order_id};
			showWaitMsg("正在导入中...");
			Ext.Ajax.request({  
				params:params, 
			    url:'../zxOrderOutController/addZxOM',  
			    method:'post',  
			    success:function(response,opts){
			    	hideWaitMsg();
			    	var obj=Ext.decode(response.responseText);  
	       			top.Ext.example.msg('提示', obj.msg);//提示之后消失
					zxWorkpieceGrid.getStore().reload();
					zxWorkpieceGrided.getStore().reload();
			    },  
			    failure:function(response,opts){  
			    	hideWaitMsg();
			    }  
			});
		}
	});
}

/**移除工件**/
function delZxOM(order_id){
	var model = zxWorkpieceGrided.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择要移除的工件');
		return;
	}
	var apply_workpiece_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == apply_workpiece_id){
			apply_workpiece_id=model.selected.items[i].data.id;
		}else{
			apply_workpiece_id=apply_workpiece_id+","+model.selected.items[i].data.id;
		}
	}
	top.Ext.Msg.confirm('提示','确定移除所选工件？',function(btn){
		if(btn == 'yes'){
			var params = {apply_workpiece_id:apply_workpiece_id,order_id:order_id};
			showWaitMsg("正在移除工件中...");
			Ext.Ajax.request({  
				params:params, 
			    url:'../zxOrderOutController/delZxOM',  
			    method:'post',  
			    success:function(response,opts){
			    	hideWaitMsg();
			    	var obj=Ext.decode(response.responseText);  
	       			top.Ext.example.msg('提示', obj.msg);//提示之后消失
					zxWorkpieceGrid.getStore().reload();
					zxWorkpieceGrided.getStore().reload();
			    },  
			    failure:function(response,opts){  
			    	hideWaitMsg();
			    }  
			});
		}
	});
}

/**编辑工件**/
function editZxOM(){
	var model = zxWorkpieceGrided.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择要编辑的工件');
		return;
	}
	var id = model.selected.items[0].data.order_out_workpiece_id;
	updateZxOrderOutWorkpiece(id);
}

//菜单点击事件
function menuClick(node,order_id){
 	var id = node.data.id;
 	var type = node.data.type;
 	var parm = {apply_id:id};
 	load(zxWorkpieceGrid,parm);
 	load(zxWorkpieceGrided,parm);
}
var zxOrderOutWorkpieceWinEdit;
var zxOrderOutWorkpieceFormEdit;
function updateZxOrderOutWorkpiece(id){
	initZxOrderOutWorkpieceFormEdit();
	zxOrderOutWorkpieceWinEdit = Ext.create('top.Ext.Window',{
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
		items:zxOrderOutWorkpieceFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOrderOutWorkpieceFormEdit,'../zxOrderOutWorkpieceController/updateZxOrderOutWorkpiece',zxWorkpieceGrided,zxOrderOutWorkpieceWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOrderOutWorkpieceWinEdit.show();
	
	loadFormData(zxOrderOutWorkpieceFormEdit,'../zxOrderOutWorkpieceController/getZxOrderOutWorkpieceById?id='+ id);
}
function initZxOrderOutWorkpieceFormEdit(){
	zxOrderOutWorkpieceFormEdit = Ext.create('top.Ext.FormPanel',{
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
			hidden:true,
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'申请单工件标识',
			xtype:'textfield',
			name:'apply_workpiece_id',
			hidden:true,
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'工件标识',
			xtype:'textfield',
			name:'workpiece_id',
			hidden:true,
			maxLength:32,
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