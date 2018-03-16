var zxSixSWinAdd;
var zxSixSFormAdd;
function addZxSixS(){
	initZxSixSFormAdd();
	reGetWidthAndHeight();
	zxSixSWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,                    
		height:300,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxSixSFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm2(zxSixSFormAdd,'../zxSixSController/addZxSixS',grid,zxSixSWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxSixSWinAdd.show();
	
}
function initZxSixSFormAdd(){
	zxSixSFormAdd = Ext.create('Ext.FormPanel',{
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
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		       {
				fieldLabel:'标题',
				xtype:'textareafield',
				name:'title',
				maxLength:100,
				anchor:'100%'
			},
			{
				fieldLabel:'检查日期',
				xtype:'datefield',
				format:'Y-m-d',
				name:'check_date',
				maxLength:19,
				allowBlank:false,
				editable:false,
				anchor:'50%'
			}
		]
	});
}
function submitForm2(subForm,url,grids,win,isHide,isReset){
	try{
		var items;
		if(null != win){
			items = Ext.ComponentQuery.query('button',win); 
		}
		if(subForm.form.isValid()){   
			top.Ext.Msg.confirm('提示','确定要提交当前表单信息内容？',function(btn){
				if(btn == 'yes'){
					///////////禁用window中组件按钮
					for(var it in items){
						items[it].disable();
					}
					subForm.form.submit({                    
				        url:url,
				        timeout:600000,/**设置超时时间10十分钟**/
				        params:{ajaxform:0},
				        waitTitle:'提示',
				        actionMethods:{ 
							read:'POST' 
						},
						method:'post', 
				        waitMsg:'正在保存数据，请稍后...',                      
				        success:function(form, action){    
				   			top.Ext.example.msg('提示', action.result.msg);//提示之后消失
				      		if(isReset){
				      			subForm.form.reset();  
				      		}                       
			           		if(null != win && "" != win){
			           			if(isHide){
			           				///////////激活window中组件按钮
									for(var it in items){
										items[it].enable();
									}
			           				win.hide();  
			           			}else{
			           				win.close(); 
			           			}
			           		} 
			           		if(null != grids && "" != grids){
			           			grids.getStore().reload();
			           		}
			           		initZxSixSContentList(action.result.id);
				      	},
				        failure:function(form, action){
				        	if( typeof(action.result.msg) != "undefined"){
				        		top.Ext.example.msg('提示', action.result.msg);//提示之后消失
				        	}
				        	///////////激活window中组件按钮
							for(var it in items){
								items[it].enable();
							}
				      	}                  
				      });  
				}
			});
		}else { 
			msgTishi('请输入必填项');
		}
	}catch(e){
    	console.info(e);
 	}
}