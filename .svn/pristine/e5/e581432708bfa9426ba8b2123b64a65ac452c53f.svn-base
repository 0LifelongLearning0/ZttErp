var zxTrainApplyWinEdit;
var zxTrainApplyFormEdit;

function updateZxTrainUpdate(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	if(grid.getSelectionModel().selected.items[0].data.status!="0"){
		msgTishi('正在审核,无法修改！');
		return;
	}
	initZxTrainApplyFormEdit();
	zxTrainApplyWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:500,
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
		items:zxTrainApplyFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxTrainApplyFormEdit,'../zxTrainApplyController/updateZxTrainApply',grid,zxTrainApplyWinEdit,false,true);
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
	
	loadFormData(zxTrainApplyFormEdit,'../zxTrainApplyController/getZxTrainApplyById?id='+ record.items[0].data.id);
}
function initZxTrainApplyFormEdit(){
	zxTrainApplyFormEdit = Ext.create('Ext.FormPanel',{
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
			items : [
				{ 
				  xtype : "textfield",
				             fieldLabel:'id',
			                 name:'id',
			                 allowBlank: false,
			                 hidden:true,
			                 maxLength:32,
			                  anchor:'100%'
			           },{ 
				  xtype : "textfield",
				             fieldLabel:'申请部门111',
			                 name:'train_dept',
			                 allowBlank: false,
			                 maxLength:32,
			                  anchor:'100%'
			           },
		            
					 {
			            xtype : "textfield",
				             fieldLabel:'培训名称',
			                 name:'train_name',
			                 allowBlank: false,
			                 maxLength:32,
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
			xtype:'numberfield',
			value:'0',
			maxValue:1000000,
			allowBlank: false,
			minValue:0,
			name:'train_fee',
			maxLength:20,
			anchor:'100%'
		},
		 {
			           fieldLabel:'参加培训人数',
			                 xtype:'numberfield',
			                 value:'0',
			                 allowDecimals:false,
			                 allowBlank: false,
			                 name:'train_num',
			                 maxValue:1000000,
			                 minValue:0,
			                 maxLength:10,
			                  anchor:'100%'
		             }
			          
			    	    ]    
		},
		{ // 行5 
			layout : "column",   
			items : [
		             {
			              fieldLabel:'培训地点',
			xtype:'textfield',
			name:'train_address',
			maxLength:255,
			width:500
		             }
			    	    ]    
		},
		{ // 行5 
			layout : "column",   
			items : [
		             {
			       
			fieldLabel:'培训目的',
			            xtype:'textareafield',
			           name:'train_purpose',
			           maxLength:500,
			           width:500
		             }
			    	    ]    
		},
		{ // 行5 
			layout : "column",   
			items : [
		             {
			           fieldLabel:'备&emsp;&emsp;注',
			           xtype:'textareafield',
			           name:'remark',
			           maxLength:5000,
			           width:500
		             }
			    	    ]    
		}
		]
	});
}
