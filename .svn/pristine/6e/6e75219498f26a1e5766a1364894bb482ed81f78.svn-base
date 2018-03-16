var store;
var grid;
var outsource_status;
Ext.onReady(function(){
	//读取状态下拉框数据
	outsource_status = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_outsource_status',
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
			labelAlign:'top',
			flex:1,
			margin:'2 5 4 5'
		},
		layout:'column',
		items:[
		{
			fieldLabel:'工件',
			xtype:'textfield',
			labelWidth:70,
			id:'workpiece_id',
			name:'workpiece_id',
			anchor:'20%',
			labelAlign:'left'
		},
		{
			fieldLabel:'合同编号',
			xtype:'textfield',
			labelWidth:70,
			id:'concordat_num',
			name:'concordat_num',
			anchor:'20%',
			labelAlign:'left'
		},
		{
			fieldLabel:'采购订单号',
			xtype:'textfield',
			labelWidth:70,
			id:'buy_num',
			name:'buy_num',
			anchor:'20%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOutsourceController/getZxOutsourceListByCondition',[]);
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
				header:'总数量',
				flex:1,
				dataIndex:'amount'
			},
			{
				header:'需求日期',
				flex:1,
				dataIndex:'need_date'
			},
			{
				header:'计划交货时间',
				flex:1,
				dataIndex:'plan_date'
			},
			{
				header:'合同编号',
				flex:1,
				dataIndex:'concordat_num'
			},
			{
				header:'采购订单号',
				flex:1,
				dataIndex:'buy_num'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					return initComBoData(outsource_status,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
			},
			{
				header:'创建时间',
				flex:1,
				dataIndex:'create_date'
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
					addZxOutsource();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxOutsource();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxOutsource();
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
						copyZxOutsource();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxOutsource();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxOutsource(grid,'../zxOutsourceController/exportZxOutsource');
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
				detailZxOutsource();
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
function delZxOutsource(){
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
			ajaxRequest('../zxOutsourceController/delZxOutsource',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxOutsource(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxOutsourceController/copyZxOutsource',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxOutsource(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxOutsourceItem',
			handler:function(){addZxOutsource();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxOutsourceItem',
			handler:function(){updateZxOutsource();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxOutsourceItem',
			handler:function(){delZxOutsource();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxOutsourceItem',
			handler:function(){copyZxOutsource();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxOutsourceItem',
			handler:function(){detailZxOutsource();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxOutsource(grid,'../zxOutsourceController/exportZxOutsource');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxOutsourceItem','delZxOutsourceItem','copyZxOutsourceItem','detailZxOutsourceItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOutsourceController/getZxOutsourceListByCondition',searchForm);
}
