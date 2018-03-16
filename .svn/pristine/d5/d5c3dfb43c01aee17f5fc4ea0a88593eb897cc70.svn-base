var store;
var grid;
var proptiesList;
var stuffList;
var zx_project_id_combo;
Ext.onReady(function(){
	//读取材质下拉框数据
	stuffList = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_workpiece_stuff',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});

	//读取加工属性下拉框数据
	proptiesList = new Ext.data.Store({
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
		singleton:false, 
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
			fieldLabel:'项目',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:zx_project_id_combo,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'project_id',
			valueField:'id',
			displayField:'name',
			name:'project_id',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'工件编号',
			xtype:'textfield',
			labelWidth:70,
			name:'workpiece_id',
			anchor:'30%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxProjectNodeController/getZxProjectNodeListByCondition',[]);
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
	            flex:2,
	            hideable:false,
	            hidden:true,
	            sortable:true,
				dataIndex:'id'
			},
			{
				header:'项目ID',
	            flex:1,
	            hideable:false,
	            hidden:true,
	            sortable:true,
				dataIndex:'project_id'
			},
			{
				header:'工件ID',
				flex:1,
				hidden:true,
				dataIndex:'workpiece_id'
			},
			{
				header:'工件编号',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.num;
				}
			},
			{
				header:'工件名称',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.name;
				}
			},
			{
				header:'加工属性',
				flex:1,
				dataIndex:'propties',
				renderer:function(value){
					return initComBoData(proptiesList,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'材质',
				flex:1,
				dataIndex:'stuff'
			},
			{
				header:'库位',
				flex:1,
				dataIndex:'library'
			},
			{
				header:'单台数量',
				flex:1,
				dataIndex:'single_amount'
			},
			{
				header:'总数量',
				flex:1,
	            hidden:true,
				dataIndex:'all_amount'
			},
			{
				header:'入库时间',
				flex:1,
				dataIndex:'in_warehouse_date'
			},
			{
				header:'入库数量',
				flex:1,
				dataIndex:'in_warehuse_amount'
			},
			{
				header:'出库时间',
				flex:1,
				dataIndex:'out_warehouse_date'
			},
			{
				header:'出库数量',
				flex:1,
				dataIndex:'out_warehuse_amount'
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
			 {
				text:'入库',
				tooltip:'入库',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					inZxProjectNode();
				}
			 },
			 {
				text:'出库',
				tooltip:'出库',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					outZxProjectNode();
				}
			 }
		],
		bbar:getGridBBar(store)
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
	initSearch(store,'../zxProjectNodeController/getZxProjectNodeListByCondition',searchForm);
}
