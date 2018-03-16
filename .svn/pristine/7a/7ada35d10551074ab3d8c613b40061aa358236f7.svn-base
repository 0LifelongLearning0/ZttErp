function initZxSixSContentListView(six_s_id){
	initContentListView(six_s_id);
	initZxSixSContentFormListView();
	zxSixSContentWinList = Ext.create('Ext.Window',{
		layout:'fit',
		width:1200,
		height:600,
		maximizable:false,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'事项明细列表',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxSixSContentFormList,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxSixSContentWinList.show();
	
}
function initZxSixSContentFormListView(){
	zxSixSContentFormList = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		/**新方法使用开始**/
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		/**新方法使用结束**/
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		    contentGrid
		]
	});
}

function initContentListView(six_s_id){
	contentStore = getGridJsonStore('../zxSixSContentController/getZxSixSContentListByCondition?six_s_id=' + six_s_id,[]);
	contentGrid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:contentStore,
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
				header:'six_sID',
				flex:1,
				hidden:true,
				dataIndex:'six_s_id'
			},
			{
				header:'检查场所',
				flex:1,
				hidden:true,
				dataIndex:'place_id'
			},
			{
				header:'检查场所',
				flex:1,
				dataIndex:'place_name'
			},
			{
				header:'责任部门',
				flex:1,
				hidden:true,
				dataIndex:'dep_id'
			},
			{
				header:'责任部门',
				flex:1,
				dataIndex:'dep_name'
			},
			{
				header:'责任人',
				flex:1,
				hidden:true,
				dataIndex:'user_id'
			},
			{
				header:'责任人',
				flex:1,
				dataIndex:'user_realname'
			},
			{
				header:'不符合项说明',
				flex:1,
				dataIndex:'problem'
			},
			{
				header:'参考照片',
				flex:1,
				hidden:true,
				dataIndex:'problem_pic'
			},
			{
				header:'参考照片',
				flex:1,
				dataIndex:'pic_name'
			},
			{
				header:'完成期限',
				flex:1,
				dataIndex:'end_date',
				renderer:function(value){
					if(value != ''&&value.length > 9){
						return value.substring(0,10);
					}
				}
			},
			{
				header:'改善措施',
				flex:1,
				dataIndex:'measure'
			},
			{
				header:'改善结果',
				flex:1,
				dataIndex:'result'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					if(value == 1){
						return '改善中';
					}else if(value == 2){
						return '确认中';
					}else if(value == 3){
						return '已确认';
					}}else{
						return '';
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
				text:'重置',
				tooltip:'重置',
				minWidth:tbarBtnMinWidth,
				icon:clearSearchIcon,
				handler:function(){
					searchForm.reset();
				}
			 }
		],
		bbar:getGridBBar(contentStore),
		listeners:{
			'rowdblclick':function(contentGrid, rowIndex, e){
				var record = contentGrid.getSelectionModel().selected;
				detailZxSixSContent(record.items[0].data.id);
			}
		}
	});
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[searchForm,contentGrid]
	});
	/**调用右键**/
	contentStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(contentStore,searchForm));});
}
