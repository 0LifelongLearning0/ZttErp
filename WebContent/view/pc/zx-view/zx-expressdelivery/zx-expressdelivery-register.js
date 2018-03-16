var store;
var grid;
var lc_process_status_combo;
var zx_expressdelivery_status;
var zx_expressdelivery_type;
Ext.onReady(function(){
	lc_process_status_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
        data:[["yes","同意"],["no","驳回"],["2","已关闭"]]
	});
	//状态下拉框数据
	zx_expressdelivery_status = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_expressdelivery_status',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	//快递类型下拉框数据
	zx_expressdelivery_type = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_expressdelivery_type',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
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
		layout:'column',
		items:[
		{
			fieldLabel:'公司名称',
			xtype:'textfield',
			labelWidth:70,
			name:'company',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'状态',
            id:'status',
			name:'status',
			hidden:true,
			value:2
		},
		{
			fieldLabel:'快递单号',
			xtype:'textfield',
			labelWidth:70,
			name:'num',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'快递类型',
			xtype:"combo",
			queryMode:'local', 
			store:zx_expressdelivery_type,
			triggerAction:"all",
            editable:false,
			readonly:true,
            emptyText:'请选择',
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name",
			name:'type',
			anchor:'20%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxExpressdeliveryController/getZxExpressdeliveryListByCondition?',[]);
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
				header:'标识ID',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'申请人标识',
				flex:1,
				hidden:true,
				dataIndex:'apply_user_id'
			},
			{
				header:'申请时间',
				flex:1,
				dataIndex:'apply_time'
			},
			{
				header:'公司名称',
				flex:1,
				dataIndex:'company'
			},
			{
				header:'地址',
				flex:1,
				dataIndex:'address'
			},
			{
				header:'收件人',
				flex:1,
				dataIndex:'addressee'
			},
			{
				header:'收件人电话',
				flex:1,
				dataIndex:'addressee_concat'
			},
			{
				header:'所寄物品',
				flex:1,
				dataIndex:'goods'
			},
			{
				header:'快递类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					return initComBoData(zx_expressdelivery_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'快递单号',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'快递金额',
				flex:1,
				dataIndex:'money'
			},
			{
				header:'快递日期',
				flex:1,
				dataIndex:'send_time'
			}
		],
		tbar:[
			 {
				text:'登记',
				tooltip:'登记',
				minWidth:tbarBtnMinWidth,
				cls:'editBtn',
				icon:editIcon,
				handler:function(){
					updateZxExpressdelivery();
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
			 }
		],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				detailZxExpressdelivery();
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
	initSearch(store,'../zxExpressdeliveryController/getZxExpressdeliveryListByCondition',searchForm);
}
