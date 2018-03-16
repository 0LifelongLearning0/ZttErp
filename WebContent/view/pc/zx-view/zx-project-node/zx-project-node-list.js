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
				header:'计划入库时间',
				flex:1,
				dataIndex:'plan_date'
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
			},
			{
				header:'工序',
				flex:1,
				dataIndex:'zxProjectWoking',
				renderer:function(value){
					var result = "";
					for(var i = 1;i <= value.length;i++){
						result += i+":"+value[i-1].item.name;
						if(i<value.length){
							result += ",";
						}
					}
					return result;
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
					addZxProjectNode();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxProjectNode();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxProjectNode();
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
						copyZxProjectNode();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxProjectNode();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxProjectNode(grid,'../zxProjectNodeController/exportZxProjectNode');
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
				detailZxProjectNode();
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
function delZxProjectNode(){
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
			ajaxRequest('../zxProjectNodeController/delZxProjectNode',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxProjectNode(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxProjectNodeController/copyZxProjectNode',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxProjectNode(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxProjectNodeItem',
			handler:function(){addZxProjectNode();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxProjectNodeItem',
			handler:function(){updateZxProjectNode();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxProjectNodeItem',
			handler:function(){delZxProjectNode();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxProjectNodeItem',
			handler:function(){copyZxProjectNode();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxProjectNodeItem',
			handler:function(){detailZxProjectNode();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxProjectNode(grid,'../zxProjectNodeController/exportZxProjectNode');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxProjectNodeItem','delZxProjectNodeItem','copyZxProjectNodeItem','detailZxProjectNodeItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxProjectNodeController/getZxProjectNodeListByCondition',searchForm);
}
