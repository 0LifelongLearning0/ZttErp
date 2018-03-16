var grid;//显示列表
var store;//选定时期的数据
var zx_repeat_type;
var zx_transaction_type;
var zx_transaction_remind;
var zx_month;
var zx_week;
var zx_day;
Ext.onReady(function(){
	zx_week = new Ext.data.Store({
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
		listeners:{
	      'load': function(store, records, options) {
	       }
		}
	});
	//日
	zx_day = new Ext.data.Store({
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
		listeners:{
	      'load': function(store, records, options) {
	       }
		}
	});
	//事务是否提醒下拉框数据
	zx_transaction_remind = new Ext.data.Store({
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
		listeners:{
	      'load': function(store, records, options) {
	       }
		}
	});
	//重复类型下拉框数据
	zx_repeat_type = new Ext.data.Store({
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
		listeners:{
	      'load': function(store, records, options) {
	       }
		}
	});
	//事务类型下拉框数据
	zx_transaction_type = new Ext.data.Store({
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
		listeners:{
	      'load': function(store, records, options) {
	       }
		}
	});
	
	store = getGridJsonStore('../zxScheduleDayController/getZxScheduleDayListByCondition',[]);
	grid = Ext.create('Ext.grid.Panel',{
		flex : 2,
		store:store,
		title:'查询结果',
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		selType:'checkboxmodel',
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
				header:'ID',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'用户id',
				flex:1,
				hidden:true,
				dataIndex:'user_id'
			},
			{
				header:'日期',
				flex:1,
				dataIndex:'date'
			},
			{
				header:'日程类别',
				flex:1,
				dataIndex:'transaction_type',
				renderer:function(value){
					return initComBoData(zx_transaction_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'开始时间',
				flex:1,
				dataIndex:'begin_time'
			},
			{
				header:'结束时间',
				flex:1,
				dataIndex:'end_time'
			},
			{
				header:'内容',
				flex:1,
				dataIndex:'transaction_content'
			},
			{
				header:'提前多少天提醒',
				flex:1,
				hidden:true,
				dataIndex:'remind_day'
			},
			{
				header:'提前多少小时提醒',
				flex:1,
				hidden:true,
				dataIndex:'remind_hour'
			},
			{
				header:'提前多少分钟提醒',
				flex:1,
				hidden:true,
				dataIndex:'remind_minute'
			},
			{
				header:'备注',
				flex:1,
				hidden:true,
				dataIndex:'remark'
			},
			{
				header:'是否提醒',
				flex:1,
				hidden:true,
				dataIndex:'transaction_remind',
				renderer:function(value){
					return initComBoData(zx_transaction_remind,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			}
		],
		tbar:[
			 {
				text:'添加',
				tooltip:'添加',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addZxScheduleDay();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxScheduleDay();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxScheduleDay();
				}
			 }
		],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				detailZxScheduleDay();
			}
		}
	});
	//日历
	var calendar =  new Ext.form.field.Date({
	  id  : 'calendar',
	  name: 'calendar',
	  fieldLabel: '日历',
	  format: 'Y-m-d',
	  maxLength: 20,
	  editable:false,//不可编辑
	  onload :true,
	  listeners: {
		  handleTabClick: function () {
			  
		  }
      }
    });
	
	var d1 = Ext.create('Ext.Panel', {
		region: 'west',
		title : '日历',
		frame : true,
		width : 700,
		items : [ {
			anchor : '100%',
			layout : {
				type : 'hbox',
				padding : '10',
				pack : 'start',
				align : 'top'
			},
			defaults : {
				margins : '0 5 0 0'
			},
			items: calendar
		} ]
	});
	
	var d2 = Ext.create('Ext.Panel', {
		title : '我的日程',
		frame : true,
		flex  : 2,
		items : [ {
			anchor : '100%',
			layout : {
				type : 'hbox',
				padding : '5',
				pack : 'start',
				align : 'top'
			},
			defaults : {
				margins : '0 5 0 0'
			},
			items: grid
		} ]
	});
	Ext.create('Ext.Viewport', {
		layout: 'hbox',
		xtype : 'viewport',
		items : [ d1, d2]
	});
})
