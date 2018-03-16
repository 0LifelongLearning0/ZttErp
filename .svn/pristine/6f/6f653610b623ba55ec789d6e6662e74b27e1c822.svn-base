var d1;
var d2;
var d3;
var treePanel;
var clickitem;
var store;
var itemspanel;
var orderby_combo;
Ext.onReady(function() {
	reGetWidthAndHeight();
	orderby_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","默认排序"],["1","编号正序"],["2","编号倒序"],["3","分类正序"],["4","分类倒序"],["5","名称正序"],["6","名称倒序"]]
	});
	var TreeStore = Ext.create('Ext.data.TreeStore', {
		root : {
			text : '办公用品',
			id : '0',
			expanded : true
		},
		proxy : {
			type : 'ajax',
			method : 'post',
			url : '../zxOfficeInventoryController/getZxOfficeInventoryTree',
			reader : {
				type : 'json'
			},
			extraParams : {
				id : '0',
				type : encodeURI('部门'),
				expanded:true
			}
		}
	});
	itemspanel = Ext.create('Ext.FormPanel',{
		xtype:'form',
		maxHeight:150,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'8 5 4 5'
		},
		layout:'column',
		items:[
		{
			fieldLabel:'名称',
			xtype:'textfield',
			labelWidth:100,
			id:'name',
			name:'name',
			anchor:'30%',
			labelAlign:'left'
		}
		]
	});
	// 2创建treePanel
	treePanel = Ext.create('Ext.tree.Panel', {
		store : TreeStore,
		layout : 'fit',
		width : 350,
		autoEncode : true,
		rootVisible : true,
		expanded:true,
		id:"tree",
		useArrows : collapsibleDefined,
		xtype : 'filtered-tree',
	listeners : {
	beforeitemexpand:function(node,optd){
        var id=node.data.id; 
        var type=node.data.type; 
    },
    'itemclick':function(view,record,item,index,e){
    	var id=record.data.id; 
        clickitem=id;
        click();
    }
}

});

	d1 = Ext.create('Ext.Panel', {
		title : '',
		frame : true,
		width : 270,
		id : "leftPanel",
		items : [ {
			anchor : '100%',
			layout : {
				type : 'hbox',
				padding : '10',
				pack : 'start',
				align : 'top'
			},
			defaults : {
				margins : '0 5 0 0'
			},
			items : [treePanel]
		} ],
		tbar:[
					 {
						text:'添加种类',
						tooltip:'添加',
						minWidth:tbarBtnMinWidth,
						cls:'addBtn',
						icon:addIcon,
						handler:function(){
							addZxOfficeClassify();
						}
					 }
					 ]
	});
	store = getGridJsonStore('../zxOfficeInventoryController/getZxOfficeInventoryListByCondition',[]);
	d3 = Ext.create('Ext.grid.Panel', {
		region:'center',
		title:'查询结果',
		xtype:'panel',
		store:store,
	/*	selType:'cellmodel',*/
		/*flex: 3,*/
		id:"rightPanel",
		height: 500,
		columnLines:true,
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
						header:'序列号',
						flex:1,
						hidden:true,
						dataIndex:'id'
					},
					{
						header:'办公用品id',
						flex:1,
						hidden:true,
						dataIndex:'office_id'
					},
					{
						header:'名称',
						flex:1,
						dataIndex:'office_name'
					},
					{
						header:'数量',
						flex:1,
						dataIndex:'amount'
					},
					{
				        header:'单位',
				        width:77,
				        flex:1,
				        dataIndex:'office_unit'
			        },
					{
						header:'备注',
						flex:1,
						hidden:true,
						dataIndex:'reason'
					},
					{
				        header:'规格型号',
				        flex:1,
				        dataIndex:'standard'
			        }
				],
			
					tbar:[
					 {
						text:'补充数量',
						tooltip:'添加',
						minWidth:tbarBtnMinWidth,
						cls:'addamountBtn',
						icon:addIcon,
						handler:function(){
							addZxOfficeInventory();
						}
					 },
					 {
							text:'添加用品',
							tooltip:'添加用品',
							minWidth:tbarBtnMinWidth,
							cls:'addBtn',
							icon:editIcon,
							handler:function(){
								addZxOffice();
							}
						 },
					 {
							text:'编辑信息',
							tooltip:'编辑信息',
							minWidth:tbarBtnMinWidth,
							cls:'updateBtn',
							icon:editIcon,
							handler:function(){
								updateZxOffice();
							}
						 },
						 {
							text:'删除',
							tooltip:'删除',
							minWidth:tbarBtnMinWidth,
							cls:'delBtn',
							icon:delIcon,
							handler:function(){
								delZxOffice();
							}
						 },
						  {
							text:'检索',
							tooltip:'检索',
							minWidth:tbarBtnMinWidth,
							cls:'searchBtn',
							icon:searchIcon,
							handler:function(){
								search();
							}
						 }
				],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(d3, rowIndex, e){
				/*detailZxOffice();*/
			}
		}
	});
	
		d2 = Ext.create('Ext.Panel', {
		title : '',
		frame : true,
		width : 1100,
		height: 900,
		id : "leftPanel1",
		items : [itemspanel,d3]
		
	});
	/*initSearchForm('north',itemspanel,false,'left');*/
	Ext.create('Ext.Viewport', {
		layout : 'hbox',
		xtype : 'viewport',
		items : [ d1, d2 ]
	});
	initRight();
	
})

/**查询操作**/
function click(){
	initClick(store,'../zxOfficeInventoryController/getZxOfficeInventoryListclick',clickitem);
}

//调用点击方法
function initClick(store,url,clickitem){
	store.load({
		url:url, 
		method:'post',
		params:{
			start:0,
			limit:getGridBBar(store).pageSize,
			searchJson:Ext.encode(clickitem)
		}
	});
}
 
function initRight(){
	var contextmenutreePanel = new Ext.menu.Menu({
		id:'theContextMenutreePanel',
		items:[{
			text:'添加子分类',
			glyph:0xf016,
			id:'addZxOfficeItemd1',
			handler:function(){addZxOfficeClassify();}
		},
		{
			text:'编辑分类',
			glyph:0xf016,
			id:'updateZxOfficeItemd1',
			handler:function(){updateZxOfficeClassify();}
		},
		{
			text:'删除分类',
			glyph:0xf016,
			id:'delZxOfficeItemd1',
			handler:function(){delZxOfficeClassify();}
		}
		]
	});
	var contextmenud3 = new Ext.menu.Menu({
		id:'theContextMenud3',
		items:[{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxOfficeItemd3',
			handler:function(){updateZxOffice();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxOfficeItemd3',
			handler:function(){delZxOffice();}
		},
		{
			text:'补充数量',
			glyph:0xf014,
			id:'addZxOfficeItemdamount',
			handler:function(){addZxOfficeInventory();}
		}]
	});
	initrightgridcontextmenu(treePanel,contextmenutreePanel,['addZxOfficeItemd1','updateZxOfficeItemd1','delZxOfficeItemd1']);
	initrightgridcontextmenu(d3,contextmenud3,['updateZxOfficeItemd3','delZxOfficeItemd3','addZxOfficeItemdamount']);
}
/**删除操作**/
function delZxOffice(){
	var model =d3.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再删除');
		return;
	}
	var office_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == office_id){
			office_id=model.selected.items[i].data.office_id;
		}else{
			office_id=office_id+","+model.selected.items[i].data.office_id;
		}
	}
	Ext.Msg.confirm('提示','确定删除该行数据？',function(btn){
		if(btn == 'yes'){
			var params = {office_id:office_id};
			ajaxRequest('../zxOfficeController/delZxOffice',d3,params,'正在执行删除操作中！请稍后...');
		}
	});
}

/**删除操作**/
function delZxOfficeClassify(){
	var model = treePanel.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再删除');
		return;
	}
	var classify_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == classify_id){
			classify_id=model.selected.items[i].data.id;
		}else{
			classify_id=classify_id+","+model.selected.items[i].data.id;
		}
	}
	Ext.Msg.confirm('提示','确定删除该行数据？',function(btn){
		if(btn == 'yes'){
			var params = {classify_id:classify_id};
			ajaxRequest('../zxOfficeClassifyController/delZxOfficeClassify',treePanel,params,'正在执行删除操作中！请稍后...');
		}
	});
}
function refresh(){
	store.on('load',function(){
		d1.expandAll();
	    hideWaitMsg();
    });
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOfficeInventoryController/getZxOfficeInventoryListByCondition',itemspanel);
}