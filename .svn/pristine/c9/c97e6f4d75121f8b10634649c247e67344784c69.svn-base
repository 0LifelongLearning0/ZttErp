var store;
var grid;
var lc_process_status_combo;
var zx_apply_phone_card_status;
Ext.onReady(function(){
	lc_process_status_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
        data:[["yes","同意"],["no","驳回"],["2","已关闭"]]
	});
	//状态下拉框数据
	zx_apply_phone_card_status = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_apply_phone_card_status',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	store = getGridJsonStore('../zxApplyPhoneCardController/getZxApplyPhoneCardListByConditionHR',[]);
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
				header:'申请电话卡编号',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'申请人',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'申请人',
				flex:1,
				hidden:true,
				dataIndex:'apply_user_id'
			},
			{
				header:'申请时间',
				flex:1,
				dataIndex:'apply_time'
			},
			{
				header:'申请描述',
				flex:1,
				dataIndex:'description'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					return initComBoData(zx_apply_phone_card_status,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'操作',
				columns:[
				{
					header:'发放电话卡',
					align:'center',
					xtype:'widgetcolumn',
					id:'faFang',
					widget:{
		                xtype:'button',
		                text:'发放',
		                handler:function(rec){
	                		var id = rec.getWidgetRecord().data.id;
		                	var status = rec.getWidgetRecord().data.status;
		                	grantZxApplyPhoneCard(id,status);
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
				}
				]
			}
		],
		tbar:[
			 {
				text:'申请',
				tooltip:'申请',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				hidden:true,
				handler:function(){
					addZxApplyPhoneCard();
				}
			 },
			 {
				text:'刷新',
				tooltip:'刷新',
				minWidth:tbarBtnMinWidth,
				icon:refreshIcon,
				handler:function(){
					refreshGrid(grid);
				}
			 },
			 {
				text:'检索',
				minWidth:tbarBtnMinWidth,
				hidden:true,
				cls:'searchBtn',
				icon:searchIcon,
				handler:function(){
					search();
				}
			 },
			 {
				text:'重置',
				tooltip:'重置',
				hidden:true,
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
					hidden:true,
					handler:function(){
						copyZxApplyPhoneCard();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					hidden:true,
					handler:function(){
						detailZxApplyPhoneCard();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					hidden:true,
					glyph:0xf1c3,
					handler:function(){
						/*exportZxApplyPhoneCard(grid,'../zxApplyPhoneCardController/exportZxApplyPhoneCard');*/
					}
				 },
				 {
					text:'打 印',
					tooltip:'打 印',
					hidden:true,
					glyph:0xf02f,
					handler:function(){
						printerGrid(grid);
					}
				 },
				 '-',
				 {
					text:'全 选',
					tooltip:'全 选',
					hidden:true,
					glyph:0xf046,
					handler:function(){selectAll(grid);}
				 },
				 {
					text:'反 选',
					tooltip:'反 选',
					hidden:true,
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
					hidden:true,
					handler:function(){
						search();
					}
				 },
				 {
					text:'重 置',
					tooltip:'重 置',
					glyph:0xf014,
					hidden:true,
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
				detailZxApplyPhoneCard();
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
});
/**导出**/
function exportZxApplyPhoneCard(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxApplyPhoneCardItem',
			handler:function(){addZxApplyPhoneCard();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxApplyPhoneCardItem',
			handler:function(){detailZxApplyPhoneCard();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				//exportZxApplyPhoneCard(grid,'../zxApplyPhoneCardController/exportZxApplyPhoneCard');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxApplyPhoneCardItem','delZxApplyPhoneCardItem','copyZxApplyPhoneCardItem','detailZxApplyPhoneCardItem']);
}
/**
 * 发放卡号
 * @param id
 */
function grantZxApplyPhoneCard(id,status){
	if(status == 4){
		msgTishi('请勿重复发放电话卡！！');
		return;
	}else if(status !=2){
		msgTishi('还在审核中，无法发放。');
		return;
	}
	updateZxApplyPhoneCard(id);
}
/**
 * 审批记录
 */
var lcApprovalWin;
function initLcApprovalWin(id,status){
	if(status == 1){
		msgTishi('审批中，暂无记录');
		return;
	}
	initLcApprovalGrid(id);
	reGetWidthAndHeight();
	lcApprovalWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,                    
		height:480,
		headerPosition:'top',
		maximizable:false,
		minimizable:false,
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