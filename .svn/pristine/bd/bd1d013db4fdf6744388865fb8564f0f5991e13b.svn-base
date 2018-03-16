var store;
var grid;
var filetype='xls';
Ext.onReady(function(){
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
			fieldLabel:'物料编号',
			xtype:'textfield',
			labelWidth:70,
			id:'query_material_num',
			name:'material_num',
			anchor:'30%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxBuyApplyMaterialController/getZxBuyApplyMaterialListByCondition?apply_id='+$('#buy_apply_id').val(),[]);
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
				header:'标识ID',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'申请标识',
				flex:1,
				hidden:true,
				dataIndex:'apply_id'
			},
			{
				header:'编码',
				width:120,
				dataIndex:'item',
				renderer:function(value){
					return value.num;
				}
			},
			{
				header:'名称',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.short_name;
				}
			},
			{
				header:'规格型号',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.standard;
				}
			},
			{
				header:'材质',
				flex:1,
				dataIndex:'caizhi'
			},
			{
				header:'品牌',
				flex:1,
				dataIndex:'brand'
			},
			{
				header:'单位',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.unit;
				}
			},
			{
				header:'单台数量',
				width:80,
				dataIndex:'single_amount'
			},
			{
				header:'总数量',
				width:80,
				dataIndex:'amount'
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
					addZxBuyApplyMaterial();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxBuyApplyMaterial();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxBuyApplyMaterial();
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
					text:'导 入',
					tooltip:'导 入',
					glyph:0xf1c3,
					handler:function(){
						optupload2('zx_judge_pic','zx_judge_attach',2,filetype);
					}
				 },
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxBuyApplyMaterial(grid,'../zxBuyApplyMaterialController/exportZxBuyApplyMaterial');
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
				detailZxBuyApplyMaterial();
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
function delZxBuyApplyMaterial(){
	if($("#buy_apply_status").val() != '1'){
		msgTishi('待申请状态才可以操作物料！');
		return;
	}
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
			ajaxRequest('../zxBuyApplyMaterialController/delZxBuyApplyMaterial',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**导出**/
function exportZxBuyApplyMaterial(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxBuyApplyMaterialItem',
			handler:function(){addZxBuyApplyMaterial();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxBuyApplyMaterialItem',
			handler:function(){updateZxBuyApplyMaterial();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxBuyApplyMaterialItem',
			handler:function(){delZxBuyApplyMaterial();}
		},'-',{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxBuyApplyMaterial(grid,'../zxBuyApplyMaterialController/exportZxBuyApplyMaterial');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxBuyApplyMaterialItem','delZxBuyApplyMaterialItem','copyZxBuyApplyMaterialItem','detailZxBuyApplyMaterialItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxBuyApplyMaterialController/getZxBuyApplyMaterialListByCondition',searchForm);
}

function optupload2(fieldid,picid,flag,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	optuploadForm = Ext.create('Ext.FormPanel',{
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			margin:'5 5 5 5',
			flex:1
		},
		/**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        /**新方法使用结束**/ 
		items:[
			{
				fieldLabel:'校验参数（pdf,png,jpg,bmp等等以逗号分隔）',
				xtype:'textfield',
				hidden:true,
				id:'validateparameter',
				name:'validateparameter',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'大小（格式如"1024-10240" 表示最小1024KB最大10240KB）',
				xtype:'textfield',
				hidden:true,
				id:'validateSize',
				name:'validateSize',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'平台路径配置中心键（自定义上传对绝路径使用）',
				xtype:'textfield',
				hidden:true,
				id:'xt_path_absolutek',
				name:'xt_path_absolutek',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'平台路径配置中心键（自定义上传相对路径使用）',
				xtype:'textfield',
				hidden:true,
				id:'xt_path_relativek',
				name:'xt_path_relativek',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'平台路径配置中心键（自定义上传路径 自定义URL地址）',
				xtype:'textfield',
				hidden:true,
				id:'xt_path_urlk',
				name:'xt_path_urlk',
				maxLength:32,
				anchor:'100%'
			},
			{
			    xtype:'filefield',
			    /**
			    hideLabel:true,
			    buttonOnly:true,
			    **/
			    emptyText:'请选择要上传的文件',
			    name:'picFile',
			    buttonText:'选择文件...',
			    anchor:'100%',
			    allowBlank:false,
			    buttonConfig:{
			        icon:uploadimg
			    }
			}
		]
	});
	if(null != validateparameter && '' != validateparameter && typeof(validateparameter) != "undefined"){
		sValue('validateparameter',validateparameter);
	}
	if(null != validateSize && '' != validateSize && typeof(validateSize) != "undefined"){
		sValue('validateSize',validateSize);
	}
	if(null != xt_path_absolutek && '' != xt_path_absolutek && typeof(xt_path_absolutek) != "undefined"){
		sValue('xt_path_absolutek',xt_path_absolutek);
	}
	if(null != xt_path_relativek && '' != xt_path_relativek && typeof(xt_path_relativek) != "undefined"){
		sValue('xt_path_relativek',xt_path_relativek);
	}
	if(null != xt_path_urlk && '' != xt_path_urlk && typeof(xt_path_urlk) != "undefined"){
		sValue('xt_path_urlk',xt_path_urlk);
	}
	
	//否则正常
	optuploadWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:400,
		autoHeight:true,
		closable:false, 
		title:'批量导入物料',
		animateTarget:document.body,
		plain:true,
		modal:true,
		buttonAlign:'right',
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'5 5 5 5'
		},
		listeners:{
			minimize:function(win,opts){
				win.collapse();
			}
		},
		items:optuploadForm,
		buttons:[{
			text:'开始导入',
			itemId:'save',
			handler:function(button){
				if(optuploadForm.form.isValid()) {
					var items = Ext.ComponentQuery.query('button',optuploadWin); 
					///////////激活window中组件按钮
					for(var it in items){
						items[it].disable();
					}
		            optuploadForm.submit({
		                url:basePath+'/zxBuyApplyMaterialController/import?apply_id='+$('#buy_apply_id').val(),
		                waitMsg:'正在导入中，请稍后...',
		                success:function(form, action){
		                    msgTishi(action.result.data.msg);
		                    if(action.result.data.jsonID != 0){
			                    optuploadWin.close();
			                    filestore.reload();
		                    }else{
		                    	///////////激活window中组件按钮
								for(var it in items){
									items[it].enable();
								}
		                    }
		                },  
					    failure:function(response,opts){  
					    	///////////激活window中组件按钮
							for(var it in items){
								items[it].enable();
							}
					    }
		            });
		        }else{
		        	msgTishi('请选择附件');
		        }
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				 optuploadWin.close();
			}
		}]
	});
	optuploadWin.show();
}
