var zxTrainApplyWinEdit;
var zxTrainApplyFormDetail;
var zxTrainApplyFormDetailD;
function detailZxTrainApplyApprove(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	if(grid.getSelectionModel().selected.items[0].data.status=="0"||grid.getSelectionModel().selected.items[0].data.status=="1"||grid.getSelectionModel().selected.items[0].data.status=="2"){
		msgTishi('只有通过审核的才能编写培训计划！');
		return;
	}
	if(grid.getSelectionModel().selected.items[0].data.status=="3"){
		initZxTrainApplyFormDetailApprove();
	zxTrainApplyWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:500,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'明细信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxTrainApplyFormDetail,
		buttons:[{
			text:'开始培训',
			itemId:'save',
			handler:function(button){
				submitForm(zxTrainApplyFormDetail,'../zxTrainApplyController/updateapproveZxTrainApprove',grid,zxTrainApplyWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxTrainApplyWinEdit.show();
	
	loadFormData(zxTrainApplyFormDetail,'../zxTrainApplyController/getZxTrainApplyById?id='+ record.items[0].data.id);
	}else{
		initZxTrainApplyFormDetailApproveDetail();
	zxTrainApplyWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:500,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'明细信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxTrainApplyFormDetailD,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxTrainApplyWinEdit.show();
	
	loadFormData(zxTrainApplyFormDetailD,'../zxTrainApplyController/getZxTrainApplyById?id='+ record.items[0].data.id);
	}
	
}
function initZxTrainApplyFormDetailApprove(){
	zxTrainApplyFormDetail = Ext.create('Ext.FormPanel',{
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
			           fieldLabel:'培训计划',
			           xtype:'textareafield',
			           name:'train_plan',
			           maxLength:50000,
			           width:500,
			           height:200
		             }
			    	    ]    
		}
		]
	});
}
function initZxTrainApplyFormDetailApproveDetail(){
	zxTrainApplyFormDetailD = Ext.create('Ext.FormPanel',{
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
			           fieldLabel:'培训计划',
			           xtype:'textareafield',
			           name:'train_plan',
			           maxLength:50000,
			           width:500,
			           height:200
		             }
			    	    ]    
		}
		]
	});
}
