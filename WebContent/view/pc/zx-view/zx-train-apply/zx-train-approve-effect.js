var zxTrainApplyWinEffect;
var zxTrainApplyFormDetailEffect;
var zxTrainApplyFormDetailEffectDetail;
function detailZxTrainApplyEffect(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	if(grid.getSelectionModel().selected.items[0].data.status=="0"||grid.getSelectionModel().selected.items[0].data.status=="1"||grid.getSelectionModel().selected.items[0].data.status=="2"||grid.getSelectionModel().selected.items[0].data.status=="3"){
		msgTishi('只有培训结束的才能进行归档！');
		return;
	}
    if(grid.getSelectionModel().selected.items[0].data.status=="4"){
		initZxTrainApplyFormDetailEffect();
		zxTrainApplyWinEffect = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:500,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'培训效果',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxTrainApplyFormDetailEffect,
		buttons:[{
			text:'归档',
			itemId:'save',
			handler:function(button){
				submitForm(zxTrainApplyFormDetailEffect,'../zxTrainApplyController/updateapproveZxTrainEnd',grid,zxTrainApplyWinEffect,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxTrainApplyWinEffect.show();
	
	loadFormData(zxTrainApplyFormDetailEffect,'../zxTrainApplyController/getZxTrainApplyById?id='+ record.items[0].data.id);
	}
	else{
			initZxTrainApplyFormDetailEffectDetail();
		zxTrainApplyWinEffect = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:500,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'培训效果',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxTrainApplyFormDetailEffectDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxTrainApplyWinEffect.show();
	
	loadFormData(zxTrainApplyFormDetailEffectDetail,'../zxTrainApplyController/getZxTrainApplyById?id='+ record.items[0].data.id);
	}
	
}
function initZxTrainApplyFormDetailEffect(){
	zxTrainApplyFormDetailEffect = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		/**新方法使用开始**/
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		layout:"form",
		/**新方法使用结束**/
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
				layout : "column",   
			items : [{ 
				  xtype : "textfield",
				             fieldLabel:'id',
			                 name:'id',
			                 allowBlank: false,
			                 hidden:true,
			                 maxLength:32,
			                  anchor:'100%'
			           },{ 
				  xtype : "textfield",
				             fieldLabel:'申请部门',
			                 name:'train_dept',
			                 maxLength:32,
			                 editable:false,
			                  anchor:'100%'
			           },
		            
					 {
			            xtype : "textfield",
				             fieldLabel:'培训名称',
			                 name:'train_name',
			                 maxLength:32,
			                 editable:false,
			                  anchor:'100%'
		             }
			    	    ] 
				
		   },
		{ // 行3  
			layout : "column",   
			items : [{
			          xtype : "textfield",
				             fieldLabel:'培训方式',
			                 name:'train_cato',
			                 maxLength:32,
			                 editable:false,
			                  anchor:'100%'
		             },
		           { 
						xtype : "textfield",
				             fieldLabel:'培训协议',
			                 name:'train_agreement',
			                 maxLength:32,
			                 editable:false,
			                  anchor:'100%'
			           }
		             
			    	    ]    
		},
		{ // 行4  
			 
			layout : "column",   
			items : [
				  {
			fieldLabel:'培训费用',
			xtype:'textfield',
			name:'train_fee',
			editable:false,
			maxLength:20,
			anchor:'100%'
		},
		 {
			           fieldLabel:'培训人数',
			                 xtype:'textfield',
			                 name:'train_num',
			                 editable:false,
			                 maxLength:10,
			                  anchor:'100%'
		             }
			          
			    	    ]    
		},
		{ // 行5 
			layout : "column",   
			items : [
		             {
			           fieldLabel:'培训效果',
			           xtype:'textareafield',
			           name:'train_effect',
			           maxLength:50000,
			           width:500,
			           height:200
		             }
			    	    ]    
		}
		]
	});
}


function initZxTrainApplyFormDetailEffectDetail(){
	zxTrainApplyFormDetailEffectDetail = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		/**新方法使用开始**/
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		layout:"form",
		/**新方法使用结束**/
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
				layout : "column",   
			items : [{ 
				  xtype : "textfield",
				             fieldLabel:'id',
			                 name:'id',
			                 allowBlank: false,
			                 hidden:true,
			                 maxLength:32,
			                  anchor:'100%'
			           },{ 
				  xtype : "textfield",
				             fieldLabel:'申请部门',
			                 name:'train_dept',
			                 maxLength:32,
			                 editable:false,
			                  anchor:'100%'
			           },
		            
					 {
			            xtype : "textfield",
				             fieldLabel:'培训名称',
			                 name:'train_name',
			                 maxLength:32,
			                 editable:false,
			                  anchor:'100%'
		             }
			    	    ] 
				
		   },
		{ // 行3  
			layout : "column",   
			items : [{
			            fieldLabel:'培训方式',
			          xtype:'combo',
			           mode:'local',
			           store:zx_train_cato,
			           triggerAction:'all',
			           valueField:'value',
			           allowBlank: false,
			           editable:false,
			           displayField:'text',
		             	emptyText:'请选择',
		             	name:'train_cato',
		               	maxLength:32,
			            anchor:'100%'
		             },
		           { 
					fieldLabel:'培训协议',
			xtype:'combo',
			emptyText:'请选择',
			store:zx_train_train_agreement,
			mode:'local',
			triggerAction:'all',
			allowBlank: false,
			editable:false,
			valueField:'value',
			displayField:'text',
			name:'train_agreement',
			maxLength:10,
			anchor:'100%'
			           }
		             
			    	    ]    
		},
		{ // 行4  
			 
			layout : "column",   
			items : [
				  {
			fieldLabel:'培训费用',
			xtype:'textfield',
			name:'train_fee',
			editable:false,
			maxLength:20,
			anchor:'100%'
		},
		 {
			           fieldLabel:'培训人数',
			                 xtype:'textfield',
			                 name:'train_num',
			                 editable:false,
			                 maxLength:10,
			                  anchor:'100%'
		             }
			          
			    	    ]    
		},
		{ // 行5 
			layout : "column",   
			items : [
		             {
			           fieldLabel:'培训效果',
			           xtype:'textareafield',
			           name:'train_effect',
			           editable:false,
			           maxLength:50000,
			           width:500,
			           height:200
		             }
			    	    ]    
		}
		]
	});
}
