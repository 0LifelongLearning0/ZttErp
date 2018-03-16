var zxSixSContentWinList;
var zxSixSContentFormList;
var contentStore;
var contentGrid;
var six_sID;
function initZxSixSContentList(six_s_id){
	six_sID = six_s_id;
	initContentList();
	initZxSixSContentFormList();
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
function initZxSixSContentFormList(){
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

function initContentList(){
	contentStore = getGridJsonStore('../zxSixSContentController/getZxSixSContentListByCondition?six_s_id=' + six_sID,[]);
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
				dataIndex:'problem_pic_name'
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
				dataIndex:'result_pic_name'
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
					}else{
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
				text:'添加',
				tooltip:'添加',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					$.post('../zxSixSController/getZxSixSById',{id:six_sID}, function(data){
						var json = eval('('+ data +')');
						if(json.success&&json.data.status=='1'){
							addZxSixSContent(six_sID);
						}else{
							msgTishi('操作失败！');
							return;
						}
					});
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					var record = contentGrid.getSelectionModel().selected;
					if(record.length == 0){
						msgTishi('请选择要修改的一项！');
						return;
					}
					if(record.items[0].data.status != 1){
						msgTishi('请选择正确的改善项！');
						return;
					}
					var content_id = record.items[0].data.id;
					$.post('../zxSixSController/getZxSixSById',{id:six_sID}, function(data){
						var json = eval('('+ data +')');
						if(json.success&&json.data.status=='1'){
							updateZxSixSContent(content_id);
						}else{
							msgTishi('操作失败！');
							return;
						}
					});
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxSixSContent();
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
						text:'改善',
						tooltip:'改善',
						glyph:0xf03b,
						handler:function(){
							var record = contentGrid.getSelectionModel().selected;
							if(record.length == 0){
								msgTishi('请选择要改的一项！');
								return;
							}
							if(record.items[0].data.status == 3){
								msgTishi('请选择正确的改善项！');
								return;
							}
							var six_s_id = record.items[0].data.id;
							correctZxSixSContent(six_s_id);
						}
					 },
					 {
						text:'确认',
						tooltip:'确认',
						glyph:0xf03b,
						handler:function(){
							var model = contentGrid.getSelectionModel();
							if(model.selected.length == 0){
								msgTishi('请选择');
								return;
							}
							var ids;
							for(var i = 0; i < model.selected.length; i++){
								if(model.selected.items[i].data.status == 1||model.selected.items[i].data.status == 3){
									msgTishi('请选择正确的改善项！');
									return;
								}
								if(null == ids){
									ids=model.selected.items[i].data.id;
								}else{
									ids=ids+","+model.selected.items[i].data.id;
								}
							}
							var params = {ids:ids,status:3,six_s_id:model.selected.items[0].data.six_s_id};
							ajaxRequest('../zxSixSContentController/checkZxSixSContent',contentGrid,params,'正在执行确认操作中！请稍后...');
						}
					 }
			          ]
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
/**删除操作**/
function delZxSixSContent(){
	var model = contentGrid.getSelectionModel();
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
			ajaxRequest('../zxSixSContentController/delZxSixSContent',contentGrid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**查询操作**/
function searchContent(){
	initSearch(contentStore,'../zxSixSContentController/getZxSixSContentListByCondition?six_s_id=' + six_sID,searchForm);
}
