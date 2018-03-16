var zxScheduleDayWinEdit;
var zxScheduleDayFormEdit;
function updateZxScheduleDay(id){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxScheduleDayFormEdit();
	zxScheduleDayWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:600,
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
		items:zxScheduleDayFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
					submitForm(zxScheduleDayFormEdit,'../zxScheduleDayController/updateZxScheduleDayBySelective?id='+record.items[0].data.id,grid,zxScheduleDayWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxScheduleDayWinEdit.show();
		loadFormDataCallBack(zxScheduleDayFormEdit,'../zxScheduleDayController/getZxScheduleDayById?id='+record.items[0].data.id,callFnUpdate);
}
function initZxScheduleDayFormEdit(){
	var zxScheduleDayFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'日程时间',
		items:[
        {
			layout:"column",
			items:[
			{
				fieldLabel:'用户',
				xtype:'textfield',
				name:'user_id',
				id:'user_id',
				allowBlank:false,
				maxLength:32,
				hidden:true,
				width:710
			},
			{
				fieldLabel:'单日日期',
				xtype:'datefield',
				format:'Y-m-d',
				name:'date',
				id:'date',
				editable:false,
				maxLength:19,
				width:710
			},
			{
				fieldLabel:'开始时间',
				xtype:'timefield',
				format:'H:i:s',
				name:'begin_time',
				editable:false,
				allowBlank:false,
				maxLength:19,
				width:350
			},
			{
				fieldLabel:'结束时间',
				xtype:'timefield',
				format:'H:i:s',
				name:'end_time',
				editable:false,
				allowBlank:false,
				maxLength:19,
				width:350
			}
			]
		}
	]
	});
	var zxScheduleContentFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'日程内容',
		items:[
		{
			fieldLabel:'任务类型',
			xtype:'combo',
			name:'transaction_type',
			triggerAction:"all",
			editable:false,
			allowBlank:false,
			store:zx_transaction_type,
			emptyText:'请选择',
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:710
		},
		{
			fieldLabel:'日程内容',
			xtype:'textfield',
			name:'transaction_content',
			allowBlank:false,
			maxLength:255,
			width:710
		},
		{
			fieldLabel:'备注',
			xtype:'textareafield',
			name:'remark',
			maxLength:255,
			width:710
		}
	]
	});
	var zxScheduleTimeFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'提醒时间',
		items:[
		{
			fieldLabel:'是否提醒',
			xtype:'combo',
			name:'transaction_remind',
			id:'transaction_remind',
			triggerAction:"all",
			editable:false,
			allowBlank:false,
			store:zx_transaction_remind,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:350,
			value:'1',
			listeners:{                 
				select:function(){      
		    		var type = Ext.getCmp("transaction_remind").getValue();
		    		if(type==1){
		    			Ext.getCmp("remind_time").show();
		    		}else{
		    			Ext.getCmp("remind_time").hide();
		    		}
		        }               
		    }
		},
		{
			id:'remind_time',
			layout:'column',
			items:[
			{
				fieldLabel:'提前',
				xtype:'numberfield',
				name:'remind_day',
				editable:false,
				maxLength:19,
				maxValue:10,// 最大值
				minValue:0, // 最小值
				value:0,
				width:210
			},
			{
				fieldLabel:'天',
				xtype:'numberfield',
				name:'remind_hour',
				editable:false,
				maxValue:23,// 最大值
				minValue:0, // 最小值
				maxLength:19,
				value:0,
				width:210
			},
			{
				fieldLabel:'小时',
				xtype:'numberfield',
				name:'remind_minute',
				editable:false,
				maxValue:59,// 最大值
				minValue:0, // 最小值
				maxLength:19,
				value:0,
				width:210,
			},
			{
				xtype : 'displayfield',
				value : '分钟提醒'
			}
			]
		}
		       ]
	});
	zxScheduleDayFormEdit = Ext.create('Ext.FormPanel',{
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
		zxScheduleDayFormEditFieldSet,
		zxScheduleContentFormEditFieldSet,
		zxScheduleTimeFormEditFieldSet
		]
	});
}
function callFnUpdate(form, action){
	var transaction_remind = action.result.data.transaction_remind;
	if(transaction_remind==1){
		Ext.getCmp("remind_time").show();
	}else{
		Ext.getCmp("remind_time").hide();
	}
	
}
