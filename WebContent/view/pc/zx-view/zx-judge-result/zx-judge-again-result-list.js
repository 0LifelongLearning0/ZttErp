var store;
var grid;
var zx_result_status;
var zx_judge_grade;
Ext.onReady(function(){
	zx_result_status = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["","---所有---"],["1","申请中"],["2","审核中"],["3","审核通过"],["4","审核退回"]]
	});
	zx_judge_grade = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["","---所有---"],["1","I级考核标准"],["2","Ⅱ级考核标准"],["3","Ⅲ级考核标准"],["4","不合格，直接淘汰"]]
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
			fieldLabel:'供应商',
			xtype:'textfield',
			labelWidth:70,
			id:'s_name',
			name:'supplier_name',
			anchor:'30%',
			columnWidth: 0.25,
			labelAlign:'left'
		},
		{
			fieldLabel:'评定结果',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:zx_judge_grade,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'grade',
			valueField:'value',
			displayField:'text',
			name:'grade',
			maxLength:32,
			columnWidth: 0.25,
			labelAlign:'left'
		},
		{
			fieldLabel:'状态',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:zx_result_status,
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
	store = getGridJsonStore('../zxJudgeAgainResultController/getZxJudgeAgainResultListByCondition',[]);
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
				header:'供应商',
				flex:1,
				dataIndex:'supplier_name'
			},
			{
				header:'总分',
				flex:1,
				dataIndex:'score'
			},
			{
				header:'评定结果',
				flex:1,
				dataIndex:'grade',
				renderer:function(value){
					if(value == 1){
						return 'I级考核标准';
					}else if(value == 2){
						return 'Ⅱ级考核标准';
					}else if(value == 3){
						return 'Ⅲ级考核标准';
					}else if(value == 4){
						return '不合格，直接淘汰';
					}else{
						return ''
					}
				}
			},
			{
				header:'评审时间',
				flex:1,
				dataIndex:'judge_date',
				renderer:function(value){
					if(value > 0){
						var year = Math.floor(value/12);
						var month = value%12;
						return month==0?(year - 1) + "-12":year + "-" + (month < 10?"0" + month:month);
					}
				}
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					if(value == 1){
						return '申请中';
					}else if(value == 2){
						return '审核中';
					}else if(value == 3){
						return '审核通过';
					}else if(value == 4){
						return '审核退回';
					}else{
						return ''
					}
				}
			},
			{
				header:'创建日期',
				flex:1,
				hidden:true,
				dataIndex:'create_date'
			}
		],
		tbar:[
			{
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delJudgeAgain();
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
				text:'返 回',
				tooltip:'返 回',
				scope:this,
				minWidth:tbarBtnMinWidth,
				cls:'backBtn',
				icon:backIcon,
				handler:function(){
					document.location.href="../zxSupplierController/loadZxSupplier";
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
						var model = grid.getSelectionModel();
						if(model.selected.length == 0){
							msgTishi('请选择后再申请');
							return;
						}
						var data = model.selected.items[0].data;
						result_id = data.id;
						addJudgeAgainGenerator();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxJudgeAgainResult(grid,'../zxJudgeAgainResultController/exportZxJudgeAgainResult');
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
				detailZxJudgeAgainResult();
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
/**复制一行并生成记录**/
function copyZxJudgeAgainResult(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxJudgeAgainResultController/copyZxJudgeAgainResult',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxJudgeAgainResult(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxJudgeAgainResultItem',
			handler:function(){
				var model = grid.getSelectionModel();
				if(model.selected.length == 0){
					msgTishi('请选择后再申请');
					return;
				}
				var data = model.selected.items[0].data;
				result_id = data.id;
				addJudgeAgainGenerator();
			}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxJudgeAgainResult(grid,'../zxJudgeAgainResultController/exportZxJudgeAgainResult');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxJudgeAgainResultItem','delZxJudgeAgainResultItem','copyZxJudgeAgainResultItem','detailZxJudgeAgainResultItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxJudgeAgainResultController/getZxJudgeAgainResultListByCondition',searchForm);
}
/**删除操作**/
function delJudgeAgain(){
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
			ajaxRequest('../zxJudgeAgainResultController/delZxJudgeAgainResult',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
