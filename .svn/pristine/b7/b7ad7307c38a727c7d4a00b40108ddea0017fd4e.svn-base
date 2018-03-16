
	//周
	var zx_week = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_week',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true,
	});
	//日
	var zx_day = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_day',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true,
	});
//事务是否提醒下拉框数据
var zx_transaction_remind = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy( { 
		url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_transaction_remind',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
	autoLoad:true,
});
//重复类型下拉框数据
var zx_repeat_type = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy( { 
		url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_repeat_type',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
	autoLoad:true,
});
//事务类型下拉框数据
var zx_transaction_type = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy( { 
		url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_transaction_type',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
	autoLoad:true,
});

var zxScheduleDayFormAdd;
function addZxScheduleDay(){
	initZxScheduleDayFormAdd();
	var zxScheduleDayWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:600,
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
		items:zxScheduleDayFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				var whether_repetition = Ext.getCmp('whether_repetition').getValue();
				if(whether_repetition==2){
					submitForm(zxScheduleDayFormAdd,'../zxScheduleDayController/addZxScheduleDay',null,zxScheduleDayWinAdd,false,true);
				}else{
					submitForm(zxScheduleDayFormAdd,'../zxPeriodTransactionController/addZxPeriodTransaction',null,zxScheduleDayWinAdd,false,true);
				}
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxScheduleDayWinAdd.show();
	Ext.getCmp('user_id').setValue(xt_userinfo_id);
}
function initZxScheduleDayFormAdd(){
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
				id:'begin_time',
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
				id:'end_time',
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
			fieldLabel:'事务类型',
			xtype:'combo',
			name:'transaction_type',
			id:'transaction_type',
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
			fieldLabel:'事务内容',
			xtype:'textfield',
			name:'transaction_content',
			id:'transaction_content',
			allowBlank:false,
			maxLength:255,
			width:710
		},
		{
			fieldLabel:'备注',
			xtype:'textareafield',
			name:'remark',
			id:'remark',
			maxLength:255,
			width:710
		}
	]
	});
	var zxScheduleRepetitionRemindFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'日程类型',
		layout:'column',
		items:[
		{
			fieldLabel:'是否重复',
			xtype:'combo',
			name:'whether_repetition',
			id:'whether_repetition',
			triggerAction:"all",
			editable:false,
			allowBlank:false,
			store:zx_transaction_remind,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:350,
			value:'2',
			listeners:{                 
				select:function(){      
	        		var whether_repetition = Ext.getCmp("whether_repetition").getValue();
	        		var repetition_type = Ext.getCmp("repetition_type").getValue();
	        		var transaction_remind = Ext.getCmp("transaction_remind").getValue();
	        		if(whether_repetition==2){
	        			Ext.getCmp("date").show();
	        			Ext.getCmp("begin_date").hide();
	        			Ext.getCmp("end_date").hide();
	        			//隐藏重复类型和时间
	        			Ext.getCmp("repetition_type").hide();
	        			Ext.getCmp("repetition_week").hide();
	        			Ext.getCmp("repetition_day").hide();
	        			if(transaction_remind==2){
	        				//隐藏设置提醒时间
		        			Ext.getCmp("remind_time").hide();
	        			}else{
	        				//显示设置提醒时间
		        			Ext.getCmp("remind_time").show();
	        			}
	        		}else{
	        			Ext.getCmp("date").hide();
	        			Ext.getCmp("begin_date").show();
	        			Ext.getCmp("end_date").show();
	        			
	        			Ext.getCmp("repetition_type").show();
	        			//隐藏设置提醒时间
	        			if(transaction_remind==2){
		        			Ext.getCmp("remind_time").hide();
	        			}else{
		        			Ext.getCmp("remind_time").show();
	        			}
	        			if(repetition_type==2){
		        			Ext.getCmp("repetition_week").show();
		        			Ext.getCmp("repetition_time").show();
		        			Ext.getCmp("repetition_day").hide();
		        			Ext.getCmp("repetition_week").setFieldLabel("重复时间");
		        		}else if(repetition_type==3){
		        			Ext.getCmp("repetition_day").show();
		        			Ext.getCmp("repetition_time").show();
		        			Ext.getCmp("repetition_week").hide();
		        			Ext.getCmp("repetition_day").setFieldLabel("重复时间");
		        		}else{
		        			Ext.getCmp("repetition_week").hide();
		        			Ext.getCmp("repetition_day").hide();
		        		}
	        		}
	            }               
	        }
		},
		{
			fieldLabel:'开始日期',
			xtype:'datefield',
			format:'Y-m-d',
			name:'begin_date',
			id:'begin_date',
			hidden:true,
			editable:false,
			maxLength:19,
			width:350
		},
		{
			fieldLabel:'结束日期',
			xtype:'datefield',
			format:'Y-m-d',
			name:'end_date',
			id:'end_date',
			hidden:true,
			editable:false,
			maxLength:19,
			width:350
		},
		{
			fieldLabel:'重复类型',
			xtype:'combo',
			name:'repetition_type',
			id:'repetition_type',
			hidden:true,
			triggerAction:"all",
			editable:false,
			allowBlank:false,
			store:zx_repeat_type,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:350,
			emptyText:'请选择',
			listeners:{                 
				select:function(){        
	        		var type = Ext.getCmp("repetition_type").getValue();
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
	        }
		},
		{
			fieldLabel:'',
			xtype:'combo',
			name:'repetition_week',
			id:'repetition_week',
			triggerAction:"all",
			hidden:true,
		    editable:false,
		    value:'1',
			store:zx_week,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:350
		},
		{
			fieldLabel:'',
			xtype:'combo',
			name:'repetition_day',
			id:'repetition_day',
			triggerAction:"all",
			hidden:true,
		    editable:false,
		    value:'1',
			store:zx_day,
			valueField:"xt_data_dictionary_value",
		    displayField:"xt_data_dictionary_name",
			maxLength:32,
			width:350
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
				fieldLabel:'提&nbsp;&nbsp;&nbsp;&nbsp;前',
				xtype:'numberfield',
				name:'remind_day',
				id:'remind_day',
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
				id:'remind_hour',
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
				id:'remind_minute',
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
	zxScheduleDayFormAdd = Ext.create('Ext.FormPanel',{
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
		zxScheduleRepetitionRemindFormEditFieldSet,
		zxScheduleTimeFormEditFieldSet
		]
	});
}
