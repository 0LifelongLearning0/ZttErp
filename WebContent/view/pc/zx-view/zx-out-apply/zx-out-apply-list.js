var store;
var grid;
var out_status;
var lc_process_status_combo;
Ext.onReady(function(){
	lc_process_status_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
        data:[["yes","同意"],["no","驳回"],["2","已关闭"]]
	});
	//读取状态下拉框数据
	out_status = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_buy_status',
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
			fieldLabel:'状态',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:out_status,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'status',
			valueField:'xt_data_dictionary_value',
			displayField:'xt_data_dictionary_name',
			id:'status',
			name:'status',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'图号',
			xtype:'textfield',
			labelWidth:70,
			name:'draw_num',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'项目案号',
			xtype:'textfield',
			labelWidth:70,
			name:'project_num',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'申请编号',
			xtype:'textfield',
			labelWidth:70,
			name:'apply_num',
			anchor:'30%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOutApplyController/getZxOutApplyListByCondition',[]);
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
				header:'申请编号',
				flex:1,
				dataIndex:'apply_num'
			},
			{
				header:'项目ID',
				flex:1,
				dataIndex:'project_id',
				hidden:true
			},
			{
				header:'项目案号',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					var items = value.split(",");
					return items[2];
				}
			},
			{
				header:'图号',
				flex:1,
				dataIndex:'draw_num'
			},
			{
				header:'制作台数',
				flex:1,
				dataIndex:'make_num'
			},
			{
				header:'申请时间',
				flex:1,
				dataIndex:'apply_time'
			},
			{
				header:'需求日期',
				flex:1,
				dataIndex:'need_time'
			},
			{
				header:'清单下发时间',
				flex:1,
				dataIndex:'send_draw_time'
			},
			{
				header:'申请人',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					var items = value.split(",");
					return items[0];
				}
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					return initComBoData(out_status,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'操作',
				columns:[
				{
					header:'工件清单',
					align:'center',
					xtype:'widgetcolumn',
					widget:{
		                xtype:'button',
		                text:'工件清单',
		                handler:function(rec){
		                	var id = rec.getWidgetRecord().data.id;
		                	showZxOutApplyWorkpiece(id);
					    }
		            }
				},
				{
					header:'查看审批记录',
					align:'center',
					xtype:'widgetcolumn',
					widget:{
		                xtype:'button',
		                text:'审批记录',
		                handler:function(rec){	
		  					var id = rec.getWidgetRecord().data.id;
		  					var status = rec.getWidgetRecord().data.status;
		  					initLcApprovalWin(id,status);
					    }
		            }
				},
				]
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
					addZxOutApply();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxOutApply();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxOutApply();
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
						copyZxOutApply();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxOutApply();
					}
				 },
				 '-',
				 {
					text:'申请',
					tooltip:'申请',
					glyph:0xf078,
					handler:function(){
						goZxOutApply();
					}
				 },
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxOutApply(grid,'../zxOutApplyController/exportZxOutApply');
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
				detailZxOutApply();
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
/**申请**/
function goZxOutApply() {
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要申请的行！');
		return;
	}else if(record.length > 1) {
		msgTishi('请不要选择多行！');
		return;
	} 
	var state = record.items[0].data.status;
	if(state != 1){
		msgTishi('请选择待申请状态的项');
		return;
	}
	var systemUID;
	if(systemUID == ""){
		systemUID = record.items[0].data.apply_user_id;
	}else{
		systemUID = systemUID + "," + record.items[0].data.apply_user_id;
	}
	Ext.Msg.confirm('提示','确定提出申请该行数据？',function(btn){
		if(btn == 'yes'){
			var id = record.items[0].data.id;
			var params = {id:id};
			ajaxRequest('../zxOutApplyController/applyZxOutApply',grid,params,'正在执行操作中！请稍后...');
		}
	});
}

/**删除操作**/
function delZxOutApply(){
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
			ajaxRequest('../zxOutApplyController/delZxOutApply',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxOutApply(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxOutApplyController/copyZxOutApply',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxOutApply(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxOutApplyItem',
			handler:function(){addZxOutApply();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxOutApplyItem',
			handler:function(){updateZxOutApply();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxOutApplyItem',
			handler:function(){delZxOutApply();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxOutApplyItem',
			handler:function(){copyZxOutApply();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxOutApplyItem',
			handler:function(){detailZxOutApply();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxOutApply(grid,'../zxOutApplyController/exportZxOutApply');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxOutApplyItem','delZxOutApplyItem','copyZxOutApplyItem','detailZxOutApplyItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOutApplyController/getZxOutApplyListByCondition',searchForm);
}

var zxOutApplyWorkpieceWin;
function showZxOutApplyWorkpiece(apply_id){
	reGetWidthAndHeight();
	zxOutApplyWorkpieceWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'工件清单列表',
		html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="../zxOutApplyWorkpieceController/loadZxOutApplyWorkpiece?apply_id='+apply_id+'"></iframe>',
		listeners:{
			minimize:function(win,opts){
				win.collapse();
			},
			close:function(){
				store.load();
			}
		}
	});
	zxOutApplyWorkpieceWin.show();
}

var lcApprovalWin;
function initLcApprovalWin(id,status){
	if(status == 1){
		msgTishi('未申请的数据无审批记录！');
		return;
	}
	initLcApprovalGrid(id);
	reGetWidthAndHeight();
	lcApprovalWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.8,                    
		height:clientHeight*0.8,
		headerPosition:'top',
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'审批记录',
		items:lcApprovalGrid,
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		}
	});
	lcApprovalWin.show();
}

function initLcApprovalGrid(id){
	lcApprovalStore = getGridJsonStore('../lcApprovalController/getLcApprovalListByCondition?model_biz_id='+id,[]);
	lcApprovalGrid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:lcApprovalStore,
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
		title:'审批列表',
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'批审状态',
				flex:1,
				dataIndex:'lc_status_id',
				renderer:function(value){
					return initComBoData(lc_process_status_combo,value,"value","text");
				}
			},
			{
				header:'审批内容',
				flex:1,
				dataIndex:'lc_approval_remark'
			},
			{
				header:'审批时间',
				flex:1,
				dataIndex:'lc_approval_time'
			},
			{
				header:'批审人',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			}
		],
		bbar:getGridBBar(lcApprovalStore)
	});
}
