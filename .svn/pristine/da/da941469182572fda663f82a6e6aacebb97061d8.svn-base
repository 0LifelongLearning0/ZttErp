var zxScheduleDayWinDetail;
var zxScheduleDayFormDetail;
function detailZxScheduleDay(id){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxScheduleDayFormDetail();
	zxScheduleDayWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:600,
		maximizable:true,
		minimizable:true,
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
		items:zxScheduleDayFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxScheduleDayWinDetail.show();
	loadFormDataCallBack(zxScheduleDayFormDetail,'../zxScheduleDayController/getZxScheduleDayById?id='+record.items[0].data.id,callFnUpdate);
}
function initZxScheduleDayFormDetail(){
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
				 readOnly:true,
				maxLength:19,
				width:350
			},
			{
				fieldLabel:'结束时间',
				xtype:'timefield',
				format:'H:i:s',
				name:'end_time',
				readOnly:true,
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
			 readOnly:true,
			store:zx_transaction_type,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:710
		},
		{
			fieldLabel:'日程内容',
			xtype:'textfield',
			name:'transaction_content',
			 readOnly:true,
			maxLength:255,
			width:710
		},
		{
			fieldLabel:'备注',
			xtype:'textareafield',
			 readOnly:true,
			name:'remark',
			maxLength:255,
			width:710
		}
	]
	});
	var zxScheduleRepetitionRemindFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'提醒时间',
		layout:'column',
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
			width:350
		},
		{
			id:'remind_time',
			layout:'column',
			items:[
			{
				fieldLabel:'提&nbsp;&nbsp;&nbsp;&nbsp;前',
				xtype:'numberfield',
				name:'remind_day',
				editable:false,
				maxLength:19,
				maxValue:10,// 最大值
				minValue:0, // 最小值
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
	zxScheduleDayFormDetail = Ext.create('Ext.FormPanel',{
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
			readOnly:true,
			margin:'2 5 4 5'
		},
		items:[
		zxScheduleDayFormEditFieldSet,
		zxScheduleContentFormEditFieldSet,
		zxScheduleRepetitionRemindFormEditFieldSet     
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