var store;
var grid;
var zx_repeat_type;
var zx_transaction_type;
var zx_transaction_remind;
var zx_week;
var zx_day;
Ext.onReady(function(){
	//周
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
	/**查询区域可扩展**/
	var items = Ext.create('Ext.FormPanel',{
		xtype:'form',
		maxHeight:150,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		layout:'column',
		items:[
		{
			fieldLabel:'重复类型',
			xtype:"combo",
			queryMode:'local', 
			store:zx_repeat_type,
			triggerAction:"all",
            editable:false,
            emptyText:'请选择',
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name",
			name:'repetition_type',
			anchor:'20%',
			labelAlign:'left'
		},
		{
			fieldLabel:'事务类型',
			xtype:"combo",
			queryMode:'local', 
			store:zx_transaction_type,
			triggerAction:"all",
            editable:false,
            emptyText:'请选择',
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name",
            id:'transaction_type',
			name:'transaction_type',
			anchor:'20%',
			labelAlign:'left'
		},
		{
			fieldLabel:'是否提醒',
			xtype:"combo",
			queryMode:'local', 
			store:zx_transaction_remind,
			triggerAction:"all",
            editable:false,
            emptyText:'请选择',
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name",
			name:'transaction_remind',
			anchor:'20%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxPeriodTransactionController/getZxPeriodTransactionListByCondition',[]);
	grid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
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
				header:'id',
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
				header:'开始日期',
				flex:1,
				dataIndex:'begin_date'
			},
			{
				header:'结束日期',
				flex:1,
				dataIndex:'end_date'
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
				header:'重复类型',
				flex:1,
				dataIndex:'repetition_type',
				renderer:function(value){
					return initComBoData(zx_repeat_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'事务类型',
				flex:1,
				dataIndex:'transaction_type',
				renderer:function(value){
					return initComBoData(zx_transaction_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'内容',
				flex:1,
				dataIndex:'transaction_content'
			},
			{
				header:'是否提醒',
				flex:1,
				hidden:true,
				dataIndex:'transaction_remind',
				renderer:function(value){
					return initComBoData(zx_transaction_remind,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'周',
				flex:1,
				hidden:true,
				dataIndex:'repetition_week',
				renderer:function(value){
					return initComBoData(zx_week,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'日',
				flex:1,
				hidden:true,
				dataIndex:'repetition_day',
				renderer:function(value){
					return initComBoData(zx_day,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'提前多少天',
				flex:1,
				hidden:true,
				dataIndex:'remind_day'
			},
			{
				header:'提前多少小时',
				flex:1,
				hidden:true,
				dataIndex:'remind_hour'
			},
			{
				header:'提前多少分钟',
				flex:1,
				hidden:true,
				dataIndex:'remind_minute'
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
					addZxPeriodTransaction();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxPeriodTransaction();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxPeriodTransaction();
				}
			 },
			 {
				text:'检索',
				minWidth:tbarBtnMinWidth,
				cls:'searchBtn',
				icon:searchIcon,
				handler:function(){
					search();
				}
			 },
			 {
				text:'重置',
				tooltip:'重置',
				minWidth:tbarBtnMinWidth,
				icon:clearSearchIcon,
				handler:function(){
					searchForm.reset();
				}
			 },
			 grid_toolbar_moretext_gaps,
			 {
				 text:moretext,
				 tooltip:moretexttooltip,
				 icon:listIcon,
				 iconAlign:'left',
				 menu:[
				 {
					text:'复制一行并生成记录',
					tooltip:'复制一行并生成记录',
					glyph:0xf0ea,
					handler:function(){
						copyZxPeriodTransaction();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxPeriodTransaction();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxPeriodTransaction(grid,'../zxPeriodTransactionController/exportZxPeriodTransaction');
					}
				 },
				 {
					text:'打 印',
					tooltip:'打 印',
					glyph:0xf02f,
					handler:function(){
						printerGrid(grid);
					}
				 },
				 '-',
				 {
					text:'全 选',
					tooltip:'全 选',
					glyph:0xf046,
					handler:function(){selectAll(grid);}
				 },
				 {
					text:'反 选',
					tooltip:'反 选',
					glyph:0xf096,
					handler:function(){unSelectAll(grid);}
				 },
				 '-',
				 {
					text:'刷 新',
					tooltip:'刷 新',
					glyph:0xf021,
					handler:function(){
						grid.getStore().reload();
					}
				 },
				 {
					text:'检 索',
					tooltip:'检 索',
					glyph:0xf002,
					handler:function(){
						search();
					}
				 },
				 {
					text:'重 置',
					tooltip:'重 置',
					glyph:0xf014,
					handler:function(){
						searchForm.reset();
					}
				 }
				 ]
			 }
		],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				detailZxPeriodTransaction();
			}
		}
	});
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[searchForm,grid]
	});
	/**调用右键**/
	initRight();
	store.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(store,searchForm));});
});
/**删除操作**/
function delZxPeriodTransaction(){
	var model = grid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再删除');
		return;
	}
	var id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == id){
			id=model.selected.items[i].data.id;
		}else{
			id=id+","+model.selected.items[i].data.id;
		}
	}
	Ext.Msg.confirm('提示','确定删除该行数据？',function(btn){
		if(btn == 'yes'){
			var params = {id:id};
			ajaxRequest('../zxPeriodTransactionController/delZxPeriodTransaction',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxPeriodTransaction(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxPeriodTransactionController/copyZxPeriodTransaction',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxPeriodTransaction(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxPeriodTransactionItem',
			handler:function(){addZxPeriodTransaction();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxPeriodTransactionItem',
			handler:function(){updateZxPeriodTransaction();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxPeriodTransactionItem',
			handler:function(){delZxPeriodTransaction();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxPeriodTransactionItem',
			handler:function(){copyZxPeriodTransaction();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxPeriodTransactionItem',
			handler:function(){detailZxPeriodTransaction();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxPeriodTransaction(grid,'../zxPeriodTransactionController/exportZxPeriodTransaction');
			}
		},{
			text:'打 印',
			glyph:0xf02f,
			handler:function(){printerGrid(grid);}
		},'-',{
			text:'全 选',
			glyph:0xf046,
			handler:function(){selectAll(grid);}
		},{
			text:'反 选',
			glyph:0xf096,
			handler:function(){unSelectAll(grid);}
		},'-',{
			text:'刷 新',
			glyph:0xf021,
			handler:function(){refreshGrid(grid);}
		}]
	});
	initrightgridcontextmenu(grid,contextmenu,['updateZxPeriodTransactionItem','delZxPeriodTransactionItem','copyZxPeriodTransactionItem','detailZxPeriodTransactionItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxPeriodTransactionController/getZxPeriodTransactionListByCondition',searchForm);
}
