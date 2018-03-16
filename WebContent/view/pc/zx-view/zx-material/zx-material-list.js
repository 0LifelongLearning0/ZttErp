var store;
var grid;
var zx_material_delete;
var zxMaterialTeamList;
var zxMaterialPropertyList;
var orderby_combo;
var filetype='xls';
Ext.onReady(function(){
	zx_material_delete = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","正常"],["1","删除"]]
	});

	orderby_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","默认排序"],["1","编号正序"],["2","编号倒序"],["3","分类正序"],["4","分类倒序"],["5","名称正序"],["6","名称倒序"]]
	});
	//读取班组下拉框数据
	zxMaterialTeamList = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_material_team',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true 
	});
	//读取物料属性下拉框数据
	zxMaterialPropertyList = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_material_property',
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
		layout:'column',
		items:[
		{
			fieldLabel:'物料名称',
			xtype:'textfield',
			labelWidth:100,
			id:'name',
			name:'name',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'物料编号',
			xtype:'textfield',
			labelWidth:100,
			id:'num',
			name:'num',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'状态',
			xtype:'combo',
			labelWidth:100,
			emptyText:'请选择',
			store:zx_material_delete,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'status',
			valueField:'value',
			displayField:'text',
			id:'status',
			name:'status',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'排序方式',
			xtype:'combo',
			labelWidth:100,
			emptyText:'请选择',
			store:orderby_combo,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'orderby',
			valueField:'value',
			displayField:'text',
			id:'orderby',
			name:'orderby',
			anchor:'30%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxMaterialController/getZxMaterialListByCondition',[]);
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
				header:'物料ID',
	            flex:2,
	            hideable:false,
	            hidden:true,
	            sortable:true,
				dataIndex:'material_id'
			},
			{
				header:'物料名称',
				flex:1,
				dataIndex:'short_name'
			},
			{
				header:'全名',
				width:400,
				dataIndex:'name'
			},
			{
				header:'物料编号',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'规格型号',
				flex:1,
				dataIndex:'standard'
			},
			{
				header:'单位',
				width:80,
				dataIndex:'unit'
			},
			{
				header:'重量(千克)',
				width:80,
				dataIndex:'weight'
			},
			{
				header:'物料属性',
				width:80,
				dataIndex:'property',
				renderer:function(value){
					return initComBoData(zxMaterialPropertyList,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'班组',
				width:80,
				dataIndex:'team',
				renderer:function(value){
					return initComBoData(zxMaterialTeamList,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'状态',
				dataIndex:'status',
				renderer:function(value){
					if(value == "0"){
						return "正常";
					}else if(value=="1"){
						return "<font color='red'>删除</font>";
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
					addZxMaterial();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxMaterial();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxMaterial();
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
						copyZxMaterial();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxMaterial();
					}
				 },
				 '-',
				 {
					text:'导入',
					glyph:0xf1c4,
					handler:function(){
						optupload2('zx_judge_pic','zx_judge_attach',2,filetype);
					}
				 },
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxMaterial(grid,'../zxMaterialController/exportZxMaterial');
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
				detailZxMaterial();
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
function delZxMaterial(){
	var model = grid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再删除');
		return;
	}
	var material_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == material_id){
			material_id=model.selected.items[i].data.material_id;
		}else{
			material_id=material_id+","+model.selected.items[i].data.material_id;
		}
	}
	Ext.Msg.confirm('提示','确定删除该行数据？',function(btn){
		if(btn == 'yes'){
			var params = {material_id:material_id};
			ajaxRequest('../zxMaterialController/delZxMaterial',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxMaterial(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {material_id:record.items[0].data.material_id};
			ajaxRequest('../zxMaterialController/copyZxMaterial',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxMaterial(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'添 加',
			glyph:0xf016,
			id:'addZxMaterialItem',
			handler:function(){addZxMaterial();}
		},{
			text:'编 辑',
			glyph:0xf044,
			id:'updateZxMaterialItem',
			handler:function(){updateZxMaterial();}
		},{
			text:'删 除',
			glyph:0xf014,
			id:'delZxMaterialItem',
			handler:function(){delZxMaterial();}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxMaterialItem',
			handler:function(){copyZxMaterial();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxMaterialItem',
			handler:function(){detailZxMaterial();}
		},'-',
		{
			text:'导入',
			glyph:0xf1c4,
			handler:function(){
				optupload2('zx_judge_pic','zx_judge_attach',2,filetype);
			}
		},
		{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxMaterial(grid,'../zxMaterialController/exportZxMaterial');
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
	initrightgridcontextmenu(grid,contextmenu,['updateZxMaterialItem','delZxMaterialItem','copyZxMaterialItem','detailZxMaterialItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxMaterialController/getZxMaterialListByCondition',searchForm);
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
		                url:basePath+'/zxMaterialController/import',
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
