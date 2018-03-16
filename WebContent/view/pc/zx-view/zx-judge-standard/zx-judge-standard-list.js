var store;
var grid;
var zx_judge_dic;
var zx_zhiwu;
var zx_dep;
var zx_standard_state;
Ext.onReady(function(){
	zx_judge_dic = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy({ 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_judge',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_id', 'xt_data_dictionary_name'],
		autoLoad:true 
	});
	zx_dep = xt_service_center_type_combo = Ext.create('Ext.data.TreeStore',{
		fields:['id','text'],
		root:{
			text:'一级分类',
			id:'0',
			expanded:false
		},
		proxy:{
			type:'ajax',
			url:'../xtDataAuthorityController/getXtDepartTree',
			reader:{
				type:'json'
			}
		},
		autoLoad:true 
	});
	
	zx_standard_state = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["1","正常"],["2","删除"]]
	});
	
	var depChoose;
	$.ajax({  
        type : "post",  
         url : '../zxJudgeStandardController/getDep',  
         async : false,  
         success : function(data){
        	 data = eval('(' + data +')');
        	 var items = data.items;
        	 var datas = new Array();
        	 for(var i = 0;i < items.length;i++){
        		 var data = [items[i].dep_id,items[i].xt_departinfo_name];
        		 datas.push(data);
        	 }
        	 depChoose = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
    	         fields:['value','text'],  
    			 data:datas
    		 });
         }
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
			fieldLabel:'考核项目',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:zx_judge_dic,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'dic_id',
			valueField:'xt_data_dictionary_id',
			displayField:'xt_data_dictionary_name',
			name:'dic_id',
			maxLength:32,
			columnWidth: 0.25,
			labelAlign:'left'
		},
		{
			fieldLabel:'评分部门',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:depChoose,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'dep_id',
			valueField:'value',
			displayField:'text',
			name:'dep_id',
			maxLength:32,
			columnWidth: 0.25,
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxJudgeStandardController/getZxJudgeStandardListByCondition?type=1',[]);
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
				header:'考核项目',
				flex:1,
				dataIndex:'dic_name'
			},
			{
				header:'考核内容',
				flex:1,
				dataIndex:'content'
			},
			{
				header:'最高分',
				flex:1,
				dataIndex:'total_score'
			},
			{
				header:'评分部门',
				flex:1,
				dataIndex:'dep_name'
			},
			{
				header:'状态',
				flex:1,
				hidden:true,
				dataIndex:'state'
			},
			{
				header:'顺序',
				flex:1,
				dataIndex:'sort'
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
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
					addZxJudgeStandard();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxJudgeStandard();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxJudgeStandard();
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
						copyZxJudgeStandard();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxJudgeStandard();
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxJudgeStandard(grid,'../zxJudgeStandardController/exportZxJudgeStandard');
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
				detailZxJudgeStandard();
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
function delZxJudgeStandard(){
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
			ajaxRequest('../zxJudgeStandardController/delZxJudgeStandard',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxJudgeStandard(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxJudgeStandardController/copyZxJudgeStandard',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxJudgeStandard(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxJudgeStandardItem',
			handler:function(){addZxJudgeStandard();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxJudgeStandardItem',
			handler:function(){updateZxJudgeStandard();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxJudgeStandardItem',
			handler:function(){delZxJudgeStandard();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxJudgeStandardItem',
			handler:function(){copyZxJudgeStandard();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxJudgeStandardItem',
			handler:function(){detailZxJudgeStandard();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxJudgeStandard(grid,'../zxJudgeStandardController/exportZxJudgeStandard');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxJudgeStandardItem','delZxJudgeStandardItem','copyZxJudgeStandardItem','detailZxJudgeStandardItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxJudgeStandardController/getZxJudgeStandardListByCondition?type=1',searchForm);
}
