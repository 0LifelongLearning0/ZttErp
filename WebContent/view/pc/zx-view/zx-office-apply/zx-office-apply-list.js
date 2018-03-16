var store;
var grid;
var zx_office_apply_delete = Ext.create('Ext.data.SimpleStore',{ 
    fields:['value','text'],  
	data:[["0","待申领"],["1","待审核"],["2","审批不通过"],["3","审批通过"],["4","已发放"]]
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
		layout:'column',
		items:[
		{
			fieldLabel:'用品',
			xtype:'textfield',
			labelWidth:100,
			id:'name',
			name:'name',
			anchor:'30%',
			labelAlign:'left'
		},{
			fieldLabel:'状态',
			xtype:'combo',
			labelWidth:100,
			emptyText:'请选择',
			store:zx_office_apply_delete,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'status',
			valueField:'value',
			displayField:'text',
			id:'status',
			name:'status',
			anchor:'20%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOfficeApplyController/getZxOfficeApplyListByCondition',[]);
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
				header:'备注',
				flex:1,
				dataIndex:'reason'
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
				text:'添加',
				tooltip:'添加',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addZxOfficeApply();
				}
			 },
			 {
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
			 {
				text:'申领',
				tooltip:'申领',
				minWidth:tbarBtnMinWidth,
				icon:cutIcon,
				handler:function(){
					apply();
				}
			 }
		],
		
	//bbar
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				detailZxOfficeApply();
			}
		}
	});
}


/**删除操作**/
function delZxOfficeApply(){
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
			ajaxRequest('../zxOfficeApplyController/delZxOfficeApply',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxOfficeApply(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxOfficeApplyController/copyZxOfficeApply',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxOfficeApply(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxOfficeApplyItem',
			handler:function(){addZxOfficeApply();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxOfficeApplyItem',
			handler:function(){updateZxOfficeApply();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxOfficeApplyItem',
			handler:function(){delZxOfficeApply();}
		},
			{
			text:'申领',
			glyph:0xf014,
			id:'apply',
			handler:function(){apply();}
		},{
			text:'刷 新',
			glyph:0xf021,
			handler:function(){refreshGrid(grid);}
		}]
	});
	initrightgridcontextmenu(grid,contextmenu,['addZxOfficeApplyItem','updateZxOfficeApplyItem','delZxOfficeApplyItem','apply']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOfficeApplyController/getZxOfficeApplyListByCondition',searchForm);
}
/**申领操作**/
function apply(){
	var model = grid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再申领');
		return;
	}
	if(model.selected.length >1){
		msgTishi('只能选择一行申领');
		return;
	}
	var id;
	var status;
	for(var i = 0; i < model.selected.length; i++){
		if(null == id){
			id=model.selected.items[i].data.id;
			status=model.selected.items[i].data.status;
		}else{
			id=id+","+model.selected.items[i].data.id;
			status=status+model.selected.items[i].data.status;
		}
	}
	if(status=="0"){
		Ext.Msg.confirm('提示','确定申领？',function(btn){
		if(btn == 'yes'){
			var params = {id:id};
			ajaxRequest('../zxOfficeApplyController/setZxOfficeApplyById',grid,params,'正在执行申领操作中！请稍后...');
		}
	});
	}
	else{
		msgTishi('已申领');
	}
	
}
