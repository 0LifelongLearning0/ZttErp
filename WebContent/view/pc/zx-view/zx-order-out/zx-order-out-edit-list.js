var store;
var grid;
Ext.onReady(function(){
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
				header:'加工单位',
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
				header:'工件清单',
				align:'center',
				xtype:'widgetcolumn',
				widget:{
	                xtype:'button',
	                text:'工件清单',
	                handler:function(rec){
	                	var id = rec.getWidgetRecord().data.id;
	                	showWorkpiece(id);
				    }
	            }
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
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxOrderOut();
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
	initSearch(store,'../zxOrderOutController/getZxOrderOutListByCondition',searchForm);
}

var materialWin;
function showWorkpiece(order_id){
	reGetWidthAndHeight();
	materialWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth,                    
		height:clientHeight, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'工件清单列表',
		html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="../zxOutProgressController/loadZxOutProgressWorkpiece?order_id='+order_id+'"></iframe>',
		listeners:{
			minimize:function(win,opts){
				win.collapse();
			},
			close:function(){
				store.load();
			}
		}
	});
	materialWin.show();
}
