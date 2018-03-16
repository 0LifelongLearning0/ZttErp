var store;
var grid;
var zx_meeting_house;
var now_time;
Ext.onReady(function(){
	$.post('../zxMeetingController/getNowTime',function(data){
		now_time = data;
	});
	
	zx_meeting_house = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy({ 
			url:'../zxMeetingHouseController/getZxMeetingHouseListAll',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['id', 'house_name'],
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
		layout:'column',
		items:[
		{
			fieldLabel:'会议主题',
			xtype:'textfield',
			labelWidth:70,
			id:'title',
			name:'title',
			anchor:'30%',
			columnWidth: 0.25,
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxMeetingController/getZxMeetingListByCondition',[]);
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
				header:'会议主题',
				flex:1,
				dataIndex:'title'
			},
			{
				header:'会议内容',
				flex:1,
				hidden:true,
				dataIndex:'content'
			},
			{
				header:'发起人',
				flex:1,
				dataIndex:'user_realname'
			},
			{
				header:'会议室',
				flex:1,
				dataIndex:'house_id',
				renderer:function(value){
					return initComBoData(zx_meeting_house,value,'id', 'house_name');
				}
			},
			{
				header:'开始时间',
				flex:1,
				dataIndex:'time_start'
			},
			{
				header:'结束时间',
				flex:1,
				dataIndex:'time_end'
			},
			{
				header:'状态',
				flex:1,
				renderer:function(value, metaData, record, rowIndex, colIndex,store){
					if(now_time < record.data.time_start){
						return "会议前";
					}else if(now_time > record.data.time_end){
						return "会议结束";
					}else{
						return "会议中";
					}
				}
			},
			{
				header:'是否已上传会议记录',
				flex:1,
				dataIndex:'is_record',
				renderer:function(value){
					if(value == '0'){
						return '否';
					}else if(value == '1'){
						return '是';
					}else{
						return '否'
					}
				}
			},
			{
				header:'状态',
				flex:1,
				hidden:true,
				dataIndex:'state'
			},
			{
				header:'创建日期',
				flex:1,
				hidden:true,
				dataIndex:'create_date'
			},
			{
				header:'会议记录',
				align:'center',
				xtype:'widgetcolumn',
				width:150,
				widget:{
	                xtype:'button',
	                text:'会议记录',
	                icon:detailIcon,
	                handler:function(rec){
	                	$.post('../zxMeetingController/canAddRecord',{id:rec.getWidgetRecord().data.id}, function(data) {
	                		if( data == '0'){
	                			msgTishi('不能添加会议记录');
		                		return;
	                		}else{
	                			changeZxMeetingRecordAttach(rec.getWidgetRecord().data.id);
	                		}
	                	});
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
					addZxMeeting();
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
				 menu:[{
					text:'会议记录',
					tooltip:'会议记录',
					glyph:0xf03b,
					handler:function(){
						zxMeetingSummaryList();
					}
				 },    
				 '-',
				 {
					text:'复制一行并生成记录',
					tooltip:'复制一行并生成记录',
					glyph:0xf0ea,
					handler:function(){
						copyZxMeeting();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxMeeting(1);
					}
				 },
				 '-',
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxMeeting(grid,'../zxMeetingController/exportZxMeeting');
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
				detailZxMeeting(1);
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
function delZxMeeting(){
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
			ajaxRequest('../zxMeetingController/delZxMeeting',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxMeeting(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxMeetingController/copyZxMeeting',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxMeeting(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'会议附件',
			tooltip:'会议附件',
			glyph:0xf03b,
			handler:function(){
				var record = grid.getSelectionModel().selected;
				viewZxMeetingAttach(record.items[0].data.id);
			}
		 },{
			text:'添 加',
			glyph:0xf016,
			id:'addZxMeetingItem',
			handler:function(){addZxMeeting();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxMeetingItem',
			handler:function(){copyZxMeeting();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxMeetingItem',
			handler:function(){detailZxMeeting(1);}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxMeeting(grid,'../zxMeetingController/exportZxMeeting');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxMeetingItem','delZxMeetingItem','copyZxMeetingItem','detailZxMeetingItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxMeetingController/getZxMeetingListByCondition',searchForm);
	$.post('../zxMeetingController/getNowTime',function(data){
		now_time = data;
	});
}
