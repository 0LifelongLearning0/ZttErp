var store;
var grid;
Ext.onReady(function(){
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
			fieldLabel:'加工单位',
			xtype:'textfield',
			labelWidth:70,
			id:'query_suppier',
			name:'query_suppier',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'采购人',
			xtype:'textfield',
			labelWidth:70,
			id:'query_buy_user',
			name:'query_buy_user',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'订单编号',
			xtype:'textfield',
			labelWidth:70,
			id:'query_order_num',
			name:'order_num',
			anchor:'30%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOrderOutController/getZxOrderOutListByCondition',[]);
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
				header:'订单编号',
				flex:1,
				dataIndex:'order_num'
			},
			{
				header:'订单标题',
				flex:1,
				dataIndex:'order_name'
			},
			{
				header:'订单描述',
				flex:1,
				dataIndex:'description'
			},
			{
				header:'采购人',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					var items = value.split(",");
					return items[0];
				}
			},
			{
				header:'采购时间',
				flex:1,
				dataIndex:'buy_time'
			},
			{
				header:'供应商',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					var items = value.split(",");
					return items[1];
				}
			},
			{
				header:'承诺到货时间',
				flex:1,
				dataIndex:'agree_time'
			},
			{
				header:'导入工件',
				align:'center',
				xtype:'widgetcolumn',
				widget:{
	                xtype:'button',
	                text:'导入工件',
	                handler:function(rec){
	                	var id = rec.getWidgetRecord().data.id;
	                	var order_name = rec.getWidgetRecord().data.order_name;
	                	addZxOrderOutWorkpiece(id,order_name);
				    }
	            }
			}
		],
		tbar:[
			 {
				text:'创建',
				tooltip:'创建订单',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addZxOrderOut();
				}
			 },
			 {
				text:'维护',
				tooltip:'维护订单',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxOrderOut();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxOrderOut();
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
						copyZxOrderOut();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxOrderOut();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxOrderOut(grid,'../zxOrderOutController/exportZxOrderOut');
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
				detailZxOrderOut();
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
function delZxOrderOut(){
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
			ajaxRequest('../zxOrderOutController/delZxOrderOut',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxOrderOut(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxOrderOutController/copyZxOrderOut',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxOrderOut(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxOrderOutItem',
			handler:function(){addZxOrderOut();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxOrderOutItem',
			handler:function(){updateZxOrderOut();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxOrderOutItem',
			handler:function(){delZxOrderOut();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxOrderOutItem',
			handler:function(){copyZxOrderOut();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxOrderOutItem',
			handler:function(){detailZxOrderOut();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxOrderOut(grid,'../zxOrderOutController/exportZxOrderOut');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxOrderOutItem','delZxOrderOutItem','copyZxOrderOutItem','detailZxOrderOutItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOrderOutController/getZxOrderOutListByCondition',searchForm);
}
