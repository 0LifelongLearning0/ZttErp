var store;
var grid;
var zx_train_apply = Ext.create('Ext.data.SimpleStore',{ 
    fields:['value','text'],  
	data:[["0","待申请"],["1","待审核"],["2","审批不通过"],["3","审批通过"],["4","培训中"],["5","已归档"]]
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
		layout:'column',
		items:[
		{
			fieldLabel:'申请部门',
			xtype:'textfield',
			labelWidth:100,
			id:'train_dept',
			name:'train_dept',
			anchor:'20%',
			labelAlign:'left'},
			{
			fieldLabel:'状态',
			xtype:'combo',
			labelWidth:100,
			emptyText:'请选择',
			store:zx_train_apply,
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
	store = getGridJsonStore('../zxTrainApplyController/getZxTrainApplyListByCondition',[]);
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
						return "培训中";
					}else if(value=="5"){
						return "已归档";
					}
					
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
					addZxTrainApply();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxTrainUpdate();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxTrainApply();
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
				text:'申请',
				tooltip:'申请',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxTrainApply();
				}},
				 {
				text:'培训计划',
				tooltip:'培训计划',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					detailZxTrainApplyApprove();
				}
			 },
			  {
				text:'归档',
				tooltip:'归档',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					detailZxTrainApplyEffect();
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
		msgTishi('请选择再在删除');
		return;
	}
	if(grid.getSelectionModel().selected.items[0].data.status!="0"){
		msgTishi('正在审核,无法删除！');
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
/**复制一行并生成记录**/
function copyZxTrainApply(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxTrainApplyController/copyZxTrainApply',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxTrainApply(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxTrainApplyItem',
			handler:function(){updateZxTrainApply();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxTrainApplyItem',
			handler:function(){delZxTrainApply();}
		},{
			text:'申 请',
			glyph:0xf014,
			id:'ZxTrainApplyItem',
			handler:function(){updateZxTrainApply();}
		}, {
				text:'培训计划',
				tooltip:'培训计划',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				id:'detailZxTrainApplyApprove',
				icon:editIcon,
				handler:function(){
					detailZxTrainApplyApprove();
				}
			 },, {
				text:'归档',
				tooltip:'归档',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				id:'detailZxTrainApplyEffect',
				icon:editIcon,
				handler:function(){
					detailZxTrainApplyEffect();
				}
			 }]
	});
	initrightgridcontextmenu(grid,contextmenu,['updateZxTrainApplyItem','delZxTrainApplyItem','ZxTrainApplyItem','detailZxTrainApplyApprove','detailZxTrainApplyEffect']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxTrainApplyController/getZxTrainApplyListByCondition',searchForm);
}
