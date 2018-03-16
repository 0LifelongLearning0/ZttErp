var store;
var grid;
var zx_meeting_house;
Ext.onReady(function(){
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
				id:'s_title',
				name:'title',
				anchor:'30%',
				columnWidth: 0.25,
				labelAlign:'left'
			}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxMeetingUserController/getZxMeetingUserListByCondition',[]);
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
				header:'会议ID',
				flex:1,
				hidden:true,
				dataIndex:'meeting_id'
			},
			{
				header:'会议主题',
				flex:1,
				dataIndex:'title'
			},
			{
				header:'参与人',
				flex:1,
				hidden:true,
				dataIndex:'user_id'
			},
			{
				header:'类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					if(value == 1){
						return '参会人员';
					}else if(value == 0){
						return '邀请人员';
					}else{
						return ''
					}
				}
			},
			{
				header:'邀请日期',
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
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxMeetingUser(grid,'../zxMeetingUserController/exportZxMeetingUser');
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
				detailZxMeeting(2);
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
function delZxMeetingUser(){
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
			ajaxRequest('../zxMeetingUserController/delZxMeetingUser',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxMeetingUser(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxMeetingUserController/copyZxMeetingUser',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxMeetingUser(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[
		{
			text:'会议附件',
			glyph:0xf03b,
			id:'zxMeetingattachItem',
			handler:function(){
				var record = grid.getSelectionModel().selected;
				viewZxMeetingAttach(record.items[0].data.meeting_id);
			}
		},{
			text:'会议明细',
			glyph:0xf03b,
			id:'detailZxMeetingSummaryItem',
			handler:function(){
				detailZxMeeting(2);
			}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxMeetingUser(grid,'../zxMeetingUserController/exportZxMeetingUser');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxMeetingUserItem','delZxMeetingUserItem','copyZxMeetingUserItem','detailZxMeetingUserItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxMeetingUserController/getZxMeetingUserListByCondition?is_self=1',searchForm);
}
function isAccept(e){
	Ext.MessageBox.show({ title:"备注",msg:"请填写备注",height:220,width:300,
        buttons:Ext.MessageBox.OKCANCEL,
        multiline: true, 
        fn: function(id,text){
        	if(id=="ok"){
        		var record = grid.getSelectionModel().selected;
        		if(record.length == 0){
        			msgTishi('请选择信息！');
        			return;
        		}
        		$.post("../zxMeetingUserController/isAccept",{id:record.items[0].data.id,isAccept:e,remark:text},function(result){
        			if(result > 0){
        				msgTishi('操作成功！');
        				store.reload();
        			}else{
        				msgTishi('操作失败！');
        			}
        		});
        	}
    	}
    }); 
}
