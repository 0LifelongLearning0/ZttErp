var zxPeriodTransactionWinDetail;
var zxPeriodTransactionFormDetail;
function detailZxPeriodTransaction(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxPeriodTransactionFormDetail();
	zxPeriodTransactionWinDetail = Ext.create('Ext.Window',{
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
		items:zxPeriodTransactionFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxPeriodTransactionWinDetail.show();
	loadFormDataCallBack(zxPeriodTransactionFormDetail,'../zxPeriodTransactionController/getZxPeriodTransactionById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxPeriodTransactionFormDetail(){
	
	zxPeriodTransactionFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'事务时间',
		items:[
        {
			layout:"column",
			items:[
				{
					fieldLabel:'用户id',
					xtype:'textfield',
					name:'user_id',
					id:'user_id',
					allowBlank:false,
					maxLength:32,
					hidden:true,
					width:710
				},
				{
					fieldLabel:'开始日期',
					xtype:'datefield',
					format:'Y-m-d',
					name:'begin_date',
					readOnly:true,
					maxLength:10,
					width:350
				},
				{
					fieldLabel:'结束日期',
					xtype:'datefield',
					format:'Y-m-d',
					name:'end_date',
					readOnly:true,
					maxLength:10,
					width:350
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
	zxPeriodTransactionInfoFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'事务内容',
		layout:"column",
		items:[
		{
			fieldLabel:'事务类型',
			xtype:'combo',
			name:'transaction_type',
			maxLength:32,
			readOnly:true,
			width:350,
			store:zx_transaction_type,
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name"
		},
		{
			fieldLabel:'内容',
			xtype:'textfield',
			name:'transaction_content',
			readOnly:true,
			maxLength:255,
			width:710
		},
		{
			fieldLabel:'备注',
			xtype:'textareafield',
			name:'remark',
			allowBlank:false,
			maxLength:255,
			width:710
		},
		{
			fieldLabel:'重复类型',
			xtype:'combo',
			id:'repetition_type',
			name:'repetition_type',
			readOnly:true,
			maxLength:32,
			width:710,
			store:zx_repeat_type,
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name"
		},
		{
			fieldLabel:'',
			xtype:'combo',
			name:'repetition_week',
			id:'repetition_week',
			triggerAction:"all",
			hidden:true,
		    editable:false,
			store:zx_week,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:220
		},
		{
			fieldLabel:'',
			xtype:'combo',
			name:'repetition_day',
			id:'repetition_day',
			triggerAction:"all",
			hidden:true,
		    editable:false,
			store:zx_day,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:220
		},
		{
			fieldLabel:'是否提醒',
			xtype:'combo',
			name:'transaction_remind',
			id:'transaction_remind',
			readOnly:true,
			maxLength:32,
			width:350,
			store:zx_transaction_remind,
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name"
		},
		{
			id:'remind_time',
			layout:'column',
			items:[
			{
				fieldLabel:'提&nbsp;&nbsp;&nbsp;&nbsp;前',
				xtype:'numberfield',
				name:'remind_day',
				id:'remind_day',
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
				id:'remind_hour',
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
				id:'remind_minute',
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
	
	zxPeriodTransactionFormDetail = Ext.create('Ext.FormPanel',{
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
		zxPeriodTransactionFormDetailFieldSet,
		zxPeriodTransactionInfoFormDetailFieldSet
		]
	});
}
function callFnUpdate(form, action){
	var transaction_remind = action.result.data.transaction_remind;
	var type = action.result.data.repetition_type;
	if(transaction_remind==1){
		Ext.getCmp("remind_time").show();
	}else{
		Ext.getCmp("remind_time").hide();
	}
	if(type==2){
		Ext.getCmp("repetition_week").show();
		Ext.getCmp("repetition_day").hide();
		Ext.getCmp("repetition_week").setFieldLabel("重复时间");
	}else if(type==3){
		Ext.getCmp("repetition_day").show();
		Ext.getCmp("repetition_week").hide();
		Ext.getCmp("repetition_day").setFieldLabel("重复时间");
	}else{
		Ext.getCmp("repetition_week").hide();
		Ext.getCmp("repetition_day").hide();
	}
}
