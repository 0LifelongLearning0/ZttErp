var store;
var grid;
var zx_train_apply = Ext.create('Ext.data.SimpleStore',{ 
    fields:['value','text'],  
	data:[["0","待申请"],["1","待审核"],["2","审批不通过"],["3","审批通过"],["4","同意培训"]]
});
Ext.onReady(function(){
		zx_train_train_agreement = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","签署"],["1","不签署"]]
	});
	zx_train_cato = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","面授"],["1","函授"]]
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
		items:[
		{
			fieldLabel:'申请部门',
			xtype:'textfield',
			labelWidth:100,
			id:'train_dept',
			name:'train_dept',
			anchor:'20%',
			labelAlign:'left'}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxTrainApplyController/getZxTrainApproveListByCondition',[]);
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
				header:'序列号',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'申请部门',
				flex:1,
				dataIndex:'train_dept'
			},
			{
				header:'申请人',
				flex:1,
				hidden:true,
				dataIndex:'train_userid'
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
				header:'培训人数',
				flex:1,
				dataIndex:'train_num'
			},
			{
				header:'培训名称',
				flex:1,
				dataIndex:'train_name'
			},
			{
				header:'培训目的',
				flex:1,
				hidden:true,
				dataIndex:'train_purpose'
			},
			{
				header:'培训方式',
				flex:1,
				hidden:true,
				dataIndex:'train_cato'
			},
			{
				header:'培训地点',
				flex:1,
				hidden:true,
				dataIndex:'train_address'
			},
			{
				header:'是否签署培训协议',
				flex:1,
				hidden:true,
				dataIndex:'train_agreement'
			},
			{
				header:'培训费用',
				flex:1,
				dataIndex:'train_fee'
			},
			{
				header:'备注',
				flex:1,
				hidden:true,
				dataIndex:'remark'
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
						return "同意培训";
					}
					
				}
			}
		],
		tbar:[
			 {
				text:'通知',
				tooltip:'通知',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					detailZxTrainApply();
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
			 }
			
			
		],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				detailZxTrainApply();
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
function delZxTrainApply(){
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
			ajaxRequest('../zxTrainApplyController/delZxTrainApply',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}

/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'通 知',
			glyph:0xf016,
			id:'addZxTrainApplyItem',
			handler:function(){addZxTrainApply();}
		}]
	});
	initrightgridcontextmenu(grid,contextmenu,['updateZxTrainApplyItem','delZxTrainApplyItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxTrainApplyController/getZxTrainApproveListByCondition',searchForm);
}
