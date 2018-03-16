var store;
var grid;
var apply_status;
Ext.onReady(function(){
	apply_status = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["1","保存中"],["2","审核中"],["3","申请通过"],["3","申请退回"]]
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
				fieldLabel:'供应商名称',
				xtype:'textfield',
				labelWidth:70,
				id:'supplier_name',
				name:'supplier_name',
				columnWidth: 0.25,
				labelAlign:'left'
			},
			{
				fieldLabel:'状态',
				xtype:'combo',
				labelWidth:70,
				emptyText:'请选择',
				store:apply_status,
				mode:'local',
				triggerAction:'all',
				editable:false,
				hiddenName:'status',
				valueField:'value',
				displayField:'text',
				name:'status',
				maxLength:32,
				columnWidth: 0.25,
				labelAlign:'left'
			}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxJudgeApplyController/getZxJudgeApplyListByCondition',[]);
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
				header:'供应商名称',
				flex:1,
				dataIndex:'supplier_name'
			},
			{
				header:'申请单内容',
				flex:1,
				hidden:true,
				dataIndex:'content'
			},
			{
				header:'验厂申请人',
				flex:1,
				hidden:true,
				dataIndex:'apply_user_id'
			},
			{
				header:'验厂审核人',
				flex:1,
				hidden:true,
				dataIndex:'check_user_id'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					if(value == 1){
						return '保存中';
					}else if(value == 2){
						return '<font color="blue">审核中</font>';
					}else if(value == 3){
						return '<font color="green">申请通过</font>';
					}else if(value == 4){
						return '<font color="red">申请退回</font>';
					}else{
						return ''
					}
				}
			},
			{
				header:'状态：1-正常，0-删除',
				flex:1,
				hidden:true,
				dataIndex:'state'
			},
			{
				header:'开始日期',
				flex:1,
				dataIndex:'judge_date_start'
			},
			{
				header:'结束日期',
				flex:1,
				dataIndex:'judge_date_end'
			},
			{
				header:'审核日期',
				flex:1,
				dataIndex:'check_date'
			},
			{
				header:'创建日期',
				flex:1,
				dataIndex:'create_date'
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
					text:'复制一行并生成记录',
					tooltip:'复制一行并生成记录',
					glyph:0xf0ea,
					handler:function(){
						copyZxJudgeApply();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxJudgeApply();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxJudgeApply(grid,'../zxJudgeApplyController/exportZxJudgeApply');
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
				detailZxJudgeApply();
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
function delZxJudgeApply(){
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
			ajaxRequest('../zxJudgeApplyController/delZxJudgeApply',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxJudgeApply(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxJudgeApplyController/copyZxJudgeApply',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxJudgeApply(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxJudgeApplyItem',
			handler:function(){copyZxJudgeApply();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxJudgeApplyItem',
			handler:function(){detailZxJudgeApply();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxJudgeApply(grid,'../zxJudgeApplyController/exportZxJudgeApply');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxJudgeApplyItem','delZxJudgeApplyItem','copyZxJudgeApplyItem','detailZxJudgeApplyItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxJudgeApplyController/getZxJudgeApplyListByCondition',searchForm);
}
