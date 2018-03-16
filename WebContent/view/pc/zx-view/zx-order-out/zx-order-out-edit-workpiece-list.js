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
		layout:'column',
		items:[
		{
			fieldLabel:'工件编号',
			xtype:'textfield',
			labelWidth:70,
			id:'query_workpiece_num',
			name:'workpiece_num',
			anchor:'25%',
			labelAlign:'left'
		},
		{
			fieldLabel:'工件名称',
			xtype:'textfield',
			labelWidth:70,
			id:'query_workpiece_name',
			name:'workpiece_name',
			anchor:'25%',
			labelAlign:'left'
		},
		{
			fieldLabel:'项目编号',
			xtype:'textfield',
			labelWidth:70,
			id:'query_project_num',
			name:'project_num',
			anchor:'25%',
			labelAlign:'left'
		},
		{
			fieldLabel:'申请编号',
			xtype:'textfield',
			labelWidth:70,
			id:'query_apply_num',
			name:'apply_num',
			anchor:'25%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOutProgressController/getZxOutProgressListByCondition?order_id='+$('#order_id').val(),[]);
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
				header:'申请标识',
				flex:1,
				hidden:true,
				dataIndex:'apply_id'
			},
			{
				header:'项目号',
				width:120,
				dataIndex:'project_num'
			},
			{
				header:'项目名称',
				flex:1,
				dataIndex:'project_name'
			},
			{
				header:'申请编号',
				width:120,
				dataIndex:'apply_num'
			},
			{
				header:'工件编码',
				width:120,
				dataIndex:'workpiece_num'
			},
			{
				header:'工件名称',
				flex:1,
				dataIndex:'workpiece_name'
			},
			{
				header:'单位',
				flex:1,
				dataIndex:'workpiece_unit'
			},
			{
				header:'外协数量',
				width:80,
				dataIndex:'out_amount'
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
			}
		],
		tbar:[
			 {
				text:'跟单',
				tooltip:'跟单',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxOutProgressWorkpiece();
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
				detailZxOutProgressWorkpiece();
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
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'跟单',
			glyph:0xf044,
			id:'updateZxOutApplyWorkpieceItem',
			handler:function(){updateZxOutProgressWorkpiece();}
		},{
			text:'刷 新',
			glyph:0xf021,
			handler:function(){refreshGrid(grid);}
		}]
	});
	initrightgridcontextmenu(grid,contextmenu,['updateZxOutApplyWorkpieceItem','delZxOutApplyWorkpieceItem','copyZxOutApplyWorkpieceItem','detailZxOutApplyWorkpieceItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOutProgressController/getZxOutProgressListByCondition?order_id='+$('#order_id').val(),searchForm);
}
