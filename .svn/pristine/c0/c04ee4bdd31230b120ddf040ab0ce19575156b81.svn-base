var store;
var grid;
var zx_project_id_combo;
var out_progress_status;
var out_type;
var out_properties;
var zx_supplier_id_combo;
Ext.onReady(function(){
	//读取状态下拉框数据
	out_progress_status = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_buy_progress_status',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	//读取外协类型下拉框数据
	out_type = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_working_type',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	//读取加工属性下拉框数据
	out_properties = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_working_properties',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	zx_project_id_combo = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy({ 
			url:'../zxProjectController/getZxProjectList',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['id', 'name'],
		autoLoad:true
	});
	zx_supplier_id_combo = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy({ 
			url:'../zxSupplierController/getZxSupplierList',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['id', 'name'],
		autoLoad:true
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
		layout:"column",
		items:[
		{
			fieldLabel:'状态',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:out_progress_status,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'status',
			valueField:'xt_data_dictionary_value',
			displayField:'xt_data_dictionary_name',
			id:'status',
			name:'status',
			anchor:'30%',
			labelAlign:'top'
		},
		{
			fieldLabel:'加工属性',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:out_properties,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'properties',
			valueField:'xt_data_dictionary_value',
			displayField:'xt_data_dictionary_name',
			name:'properties',
			anchor:'30%',
			labelAlign:'top'
		},
		{
			fieldLabel:'外协类型',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:out_type,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'type',
			valueField:'xt_data_dictionary_value',
			displayField:'xt_data_dictionary_name',
			id:'type',
			name:'type',
			anchor:'30%',
			labelAlign:'top'
		},
		{
			fieldLabel:'图号',
			xtype:'textfield',
			labelWidth:70,
			name:'draw_num',
			anchor:'30%',
			labelAlign:'top'
		},
		{
			fieldLabel:'工件编号',
			xtype:'textfield',
			labelWidth:70,
			id:'workpiece_num',
			name:'workpiece_num',
			anchor:'30%',
			labelAlign:'top'
		},
		{
			fieldLabel:'项目号',
			xtype:'textfield',
			labelWidth:70,
			id:'project_num',
			name:'project_num',
			anchor:'30%',
			labelAlign:'top'
		},
		{
			fieldLabel:'申请单号',
			xtype:'textfield',
			labelWidth:70,
			name:'apply_num',
			anchor:'30%',
			labelAlign:'top'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOutProgressController/getZxOutProgressListByCondition',[]);
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
				header:'ID',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'订单ID',
				flex:1,
				hidden:true,
				dataIndex:'order_id'
			},
			{
				header:'申请单ID',
				flex:1,
				hidden:true,
				dataIndex:'apply_id'
			},
			{
				header:'项目ID',
				flex:1,
				hidden:true,
				dataIndex:'project_id'
			},
			{
				header:'工件编号',
				flex:1,
				dataIndex:'workpiece_num'
			},
			{
				header:'工件名称',
				flex:1,
				dataIndex:'workpiece_name'
			},
			{
				header:'总数量',
				flex:1,
				dataIndex:'apply_amount'
			},
			{
				header:'需求日期',
				flex:1,
				dataIndex:'need_time'
			},
			{
				header:'加工属性',
				flex:1,
				dataIndex:'properties',
				renderer:function(value){
					return initComBoData(out_properties,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
				
			},
			{
				header:'外协类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					return initComBoData(out_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'预计交货时间',
				flex:1,
				dataIndex:'plan_time'
			},
			{
				header:'入库数量',
				flex:1,
				dataIndex:'in_warehouse_amount'
			},
			{
				header:'入库时间',
				flex:1,
				dataIndex:'in_warehouse_date'
			},
			{
				header:'出库数量',
				flex:1,
				dataIndex:'out_warehouse_amount'
			},
			{
				header:'出库时间',
				flex:1,
				dataIndex:'out_warehouse_date'
			},
			{
				header:'申请单号',
				flex:1,
				dataIndex:'apply_num'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					return initComBoData(out_progress_status,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
			}
		],
		tbar:[
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
						text:'导 出',
						tooltip:'导 出',
						glyph:0xf1c3,
						handler:function(){
							exportZxBuyProgress(grid,'../zxOutProgressController/exportZxOutProgress');
						}
					 },
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
				detailZxOutProgress();
			}
		}
	});
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[searchForm,grid]
	});
	store.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(store,searchForm));});
});
/**查询操作**/
function search(){
	initSearch(store,'../zxOutProgressController/getZxOutProgressListByCondition',searchForm);
}
