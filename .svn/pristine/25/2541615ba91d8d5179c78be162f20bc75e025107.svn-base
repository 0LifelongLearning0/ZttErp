var store;
var grid;
var zx_office_apply_delete = Ext.create('Ext.data.SimpleStore',{ 
    fields:['value','text'],  
	data:[["0","待申请"],["1","待审核"],["2","审批不通过"],["3","审批通过"],["4","已发放"]]
});
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
		items:[
		{}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOfficeOutController/getZxOfficeOutListByCondition',[]);
	//panel
	createpanelZxOfficeApply();
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[searchForm,grid]
	});
	/**调用右键**/
	initRight();
	store.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(store,searchForm));});
});

function createpanelZxOfficeApply(){
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
		//columns
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'序列号',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'申请人',
				flex:1,
				hidden:true,
				dataIndex:'user_id'
			},
			{
				header:'申请时间',
				flex:1,
				hidden:true,
				dataIndex:'create_time'
			},
			{
				header:'审批通过时间',
				flex:1,
				hidden:true,
				dataIndex:'approve_time'
			},
			{
				header:'用品id',
				flex:1,
				hidden:true,
				dataIndex:'office_id'
			},
			{
				header:'用品',
				flex:1,
				dataIndex:'office_name'
			},
			{
				header:'分类id',
				hidden:true,
				flex:1,
				dataIndex:'classify_id'
			},
			
			{
				header:'申请数量',
				flex:1,
				dataIndex:'amount'
			},
			{
				header:'单位',
				/*hidden:true,*/
				flex:1,
				dataIndex:'office_unit'
			},
			{
				header:'规格型号',
				/*hidden:true,*/
				flex:1,
				dataIndex:'standard'
			},
			{
				header:'库存数量',
				/*hidden:true,*/
				flex:1,
				dataIndex:'inventoryamount'
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'reason'
			},
				{
				header:'申请人',
				flex:1,
				dataIndex:'user_name'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					if(value == "0"){
						return "待申请";
					}else if(value=="1"){
						return "待审核";
					}else if(value=="2"){
						return "审批不通过";
					}else if(value=="3"){
						return "审批通过";
					}else if(value=="4"){
						return "已发放";
					}
					
				}
			}
		],
		//tbar
		tbar:[
			 {
				 text:'发放',
					tooltip:'发放',
					minWidth:tbarBtnMinWidth,
					cls:'updateBtn',
					icon:editIcon,
					handler:function(){
						updateZxOfficeApply();
					}
			 },
			/* {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxOfficeApply();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxOfficeApply();
				}
			 },*/
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
		
	//bbar
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
			/*	detailZxOfficeApply();*/
			}
		}
	});
}




/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'发放',
			glyph:0xf016,
			id:'updateZxOfficeApply',
			handler:function(){updateZxOfficeApply();}
		}]
	});
	initrightgridcontextmenu(grid,contextmenu,['updateZxOfficeApply']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOfficeOutController/getZxOfficeOutListByCondition',searchForm);
}
