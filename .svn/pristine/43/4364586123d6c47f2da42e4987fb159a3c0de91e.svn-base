var xt_constant_id_combo = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy({ 
		url:'../xtConstantController/getXtConstantList?xt_constantType=3',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_constant_id', 'xt_constantName'],
	autoLoad:true 
});
//创建节点模板 暂时未使用
function insertEdgeTemplate(panel, graph, name, icon, style, width, height, value, parentNode){
		var cells = [new mxCell((value != null) ? value : '', new mxGeometry(0, 0, width, height), style)];
		cells[0].geometry.setTerminalPoint(new mxPoint(0, height), true);
		cells[0].geometry.setTerminalPoint(new mxPoint(width, 0), false);
		cells[0].edge = true;
		var funct = function(graph, evt, target){
			cells = graph.getImportableCells(cells);
			if(cells.length > 0){
				var validDropTarget = (target != null) ? graph.isValidDropTarget(target, cells, evt) : false;
				var select = null;
				if(target != null && !validDropTarget){
					target = null;
				}
				var pt = graph.getPointForEvent(evt);
				var scale = graph.view.scale;
				pt.x -= graph.snap(width / 2);
				pt.y -= graph.snap(height / 2);
				select = graph.importCells(cells, pt.x, pt.y, target);
				GraphEditor.edgeTemplate = select[0];
				graph.scrollCellToVisible(select[0]);
				graph.setSelectionCells(select);
			}
		};
		var node = panel.addTemplate(name, icon, parentNode, cells);
		var installDrag = function(expandedNode){
			if (node.ui.elNode != null){
				var dragPreview = document.createElement('div');
				dragPreview.style.border = 'dashed black 1px';
				dragPreview.style.width = width+'px';
				dragPreview.style.height = height+'px';
				mxUtils.makeDraggable(node.ui.elNode, graph, funct, dragPreview, -width / 2, -height / 2,graph.autoscroll, true);
			}
		};
		if(!node.parentNode.isExpanded()){
			panel.on('expandnode', installDrag);
		}else{
			installDrag(node.parentNode);
		}
		return node;
};
// 添加元素右上角的删除图标  
function addOverlays(graph, cell, addDeleteIcon){  
    var overlay = new mxCellOverlay(new mxImage('images/add.png', 24, 24), 'Add child');  
    overlay.cursor = 'hand';  
    overlay.align = mxConstants.ALIGN_CENTER;  
    overlay.addListener(mxEvent.CLICK, mxUtils.bind(this, function(sender, evt){  
        addChild(graph, cell);  
    }));  
    graph.addCellOverlay(cell, overlay);  
    if (addDeleteIcon){  
        overlay = new mxCellOverlay(new mxImage('images/close.png', 30, 30), 'Delete');  
        overlay.cursor = 'hand';  
        overlay.offset = new mxPoint(-4, 8);  
        overlay.align = mxConstants.ALIGN_RIGHT;  
        overlay.verticalAlign = mxConstants.ALIGN_TOP;  
        overlay.addListener(mxEvent.CLICK, mxUtils.bind(this, function(sender, evt){  
            deleteSubtree(graph, cell);  
        }));  
        graph.addCellOverlay(cell, overlay);  
    }  
}; 
// 添加子元素  
function addChild(graph, cell){  
    var model = graph.getModel();  
    var parent = graph.getDefaultParent();  
    var vertex;  
    model.beginUpdate();  
    try {  
        vertex = graph.insertVertex(parent, null, 'Double click to set name');  
        var geometry = model.getGeometry(vertex);  
        var size = graph.getPreferredSizeForCell(vertex);  
        geometry.width = size.width;  
        geometry.height = size.height;  
        var edge = graph.insertEdge(parent, null, '', cell, vertex);  
        edge.geometry.x = 1;  
        edge.geometry.y = 0;  
        edge.geometry.offset = new mxPoint(0, -20);  
    }finally{  
        model.endUpdate();  
    }  
    return vertex;  
};

//导入流程
var processGrid;
var processStore;
function imp(graph,history){
	reGetWidthAndHeight();
	initProcessGrid(graph,history);
	impWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.8,                    
		height:clientHeight, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'流程列表',
		items:processGrid,
		listeners:{
			minimize:function(win,opts){
				win.collapse();
			}
		}
	});
	impWin.show();
}

//导入流程
function initProcessGrid(graph,history){
	processStore = getGridJsonStore('../lcProcessController/getLcProcessListByCondition?lc_process_flag=0',[]);
	processGrid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:processStore,
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
				header:'流程标题',
				flex:1,
				dataIndex:'lc_process_title'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'lc_process_status',
				renderer:function(value){
					if(value == 0){
						return "待发布"
					}else if(value == 1){
						return "发布中";
					}else if(value == 1){
						return "已关闭";
					}else{
						return "缺省";
					}
				}
			},
			{
				header:'创建时间',
				flex:1,
				dataIndex:'lc_process_ctime'
			},
			{
				header:'最后修改时间',
				flex:1,
				dataIndex:'lc_process_mtime'
			},
			{
				header:'创建人',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'操作',
				align:'center',
				xtype:'widgetcolumn',
				widget:{
	                xtype:'button',
	                text:'导入流程',
	                handler:function(rec){	
	                	Ext.Msg.confirm('提示','确定导入该流程数据？',function(btn){
							if(btn == 'yes'){
								var record = rec.getWidgetRecord();
						        var lc_process_title = record.data.lc_process_title;
						        var lc_process_mxgraph_style = record.data.lc_process_mxgraph_style;
						        var lc_process_mxgraphxml = record.data.lc_process_mxgraphxml;
						        var processId = record.data.lc_process_uid;
						        var candidateStarterUsers = record.data.candidateStarterUsers;
						        var candidateStarterGroups = record.data.candidateStarterGroups;
						        var lc_process_remark = record.data.lc_process_remark;
						        var lc_process_id = record.data.lc_process_id;
						        var xt_constant_id = record.data.xt_constant_id;
						        //////////////////////////////////开始导入XML文件///////////////////////////
								graph.getModel().beginUpdate();
								try{
									/*
									 * 直接读取流程图的xml, 并展示流程图
									*/
								    if(lc_process_mxgraphxml != null && lc_process_mxgraphxml.length > 0){
										var doc = mxUtils.parseXml(lc_process_mxgraphxml); 
										var dec = new mxCodec(doc); 
										dec.decode(doc.documentElement, graph.getModel());
									}
									validatePOOL(graph);
								}finally{
									graph.getModel().endUpdate();
									linetostyle(lc_process_mxgraph_style,graph);
									graph.refresh();
									Ext.getCmp('processId').setValue(processId);
							        Ext.getCmp('processName').setValue(lc_process_title);
							        Ext.getCmp('mxgraphxml').setValue(lc_process_mxgraphxml);
							        Ext.getCmp('lc_process_mxgraph_style').setValue(lc_process_mxgraph_style);
							        Ext.getCmp('lc_process_id').setValue(lc_process_id);
							        Ext.getCmp('candidateStarterUsers').setValue(candidateStarterUsers);
							        Ext.getCmp('remark').setValue(lc_process_remark);
							        Ext.getCmp('xt_constant_id').setValue(xt_constant_id);
									impWin.close();
								}
								//////////////////////////////////结束导入XML文件///////////////////////////
							}
						});
				    }
	            }
			}
		]
	});
}

//初始化通过表单导入流程（即来源是否通过流程数据跳入到设计器中）
function initImpfromform(graph,lc_process_hideid){
	if(null != lc_process_hideid && '' != lc_process_hideid && typeof(lc_process_hideid) != "undefined"){
		eastPanel.getForm().load({
			url:'../lcProcessController/getLcProcessById?lc_process_id='+lc_process_hideid,	
			waitTitle:'提示',
			method:'post', 
	        waitMsg:'正在载入数据，请稍后...',  			
		    success:function(form, action){
		    	var record = action.result;
		        var lc_process_title = record.data.lc_process_title;
		        var lc_process_mxgraph_style = record.data.lc_process_mxgraph_style;
		        var lc_process_mxgraphxml = record.data.lc_process_mxgraphxml;
		        var processId = record.data.lc_process_uid;
		        var candidateStarterUsers = record.data.candidateStarterUsers;
		        var candidateStarterGroups = record.data.candidateStarterGroups;
		        var lc_process_remark = record.data.lc_process_remark;
		        var lc_process_id = record.data.lc_process_id;
		        //////////////////////////////////开始导入XML文件///////////////////////////
				graph.getModel().beginUpdate();
				try{
					/*
					 * 直接读取流程图的xml, 并展示流程图
					*/
				    if(lc_process_mxgraphxml != null && lc_process_mxgraphxml.length > 0){
						var doc = mxUtils.parseXml(lc_process_mxgraphxml); 
						var dec = new mxCodec(doc); 
						dec.decode(doc.documentElement, graph.getModel());
					}
				}finally{
					graph.getModel().endUpdate();
					linetostyle(lc_process_mxgraph_style,graph);
					graph.refresh();
					Ext.getCmp('processId').setValue(processId);
			        Ext.getCmp('processName').setValue(lc_process_title);
			        Ext.getCmp('mxgraphxml').setValue(lc_process_mxgraphxml);
			        Ext.getCmp('lc_process_mxgraph_style').setValue(lc_process_mxgraph_style);
			        Ext.getCmp('lc_process_id').setValue(lc_process_id);
			        Ext.getCmp('candidateStarterUsers').setValue(candidateStarterUsers);
			        Ext.getCmp('remark').setValue(lc_process_remark);
				}
				//////////////////////////////////结束导入XML文件///////////////////////////
		    },                      
	   	    failure:function(form, action){}                  
		});
	}
}
//初始化处理人
var userGrid;
var userStore;
var userWin;
var formSearc;
//读取性别下拉框数据
var xtUserinfoSexList = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy( { 
		url:'../xtUserinfoController/getXtUserinfoSexList',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_data_dictionary_id', 'xt_data_dictionary_name'],
	autoLoad:true 
});
//读取名族下拉框数据
var xtUserinfoNationList = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy( { 
		url:'../xtUserinfoController/getXtUserinfoNationList',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_data_dictionary_id', 'xt_data_dictionary_name'],
	autoLoad:true 
});
//读取是否已婚下拉框数据
var xtUserinfoIsmarriedList = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy( { 
		url:'../xtUserinfoController/getXtUserinfoIsmarriedList',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_data_dictionary_id', 'xt_data_dictionary_name'],
	autoLoad:true 
});

//用户选择器--------flag标识是1单个用户选择2支持多选----------type类型1在UserTask中使用2在“流程基本信息使用”3在泳道中使用
function initassignee(flag,type){
	userStore = getGridJsonStore('../xtUserinfoController/getXtUserinfoListByCondition',[{}]);
	/**查询区域可扩展**/
	var formItems = Ext.create('Ext.FormPanel',{
		maxHeight:220,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:40,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		/**新方法使用开始**/
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		/**新方法使用结束**/
		items:[
		{
			layout:'table',
			xtype:'form',
			anchor:'100%',
			items:[
			{
				fieldLabel:'部门',
				xtype:'textfield',
				name:'xt_departinfo_name',
				width:220
			},
			{
				fieldLabel:'岗位',
				xtype:'textfield',
				name:'xt_post_name',
				width:220
			},
			{
				fieldLabel:'账户',
				xtype:'textfield',
				name:'xt_userinfo_name',
				width:220
			},
			{
				fieldLabel:'姓名',
				xtype:'textfield',
				name:'xt_userinfo_realName',
				width:220
			}
			]
		}
		]
	});
	formSearc = initSearchFormByUserdefined('north',formItems,true,'left');
	userGrid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:userStore,
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		border:true,
		selType:'checkboxmodel',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		title:'查询结果',
		loadMask:{
			msg:'正在加载...'
		},
		tbar:[
			 {
				text:'保存选择',
				tooltip:'保存选择',
				scope:this,
				cls:'saveBtn',
				icon:saveIcon,
				id:'userGridBtn',
				handler:function(){
					//Usertask中处理人选择
					if(flag == 2 && type == 1){
						var model = userGrid.getSelectionModel();
						if(model.selected.length == 0){
							msgTishi('请选择后在保存');
							return;
						}
						var xt_userinfo_id;
						var xt_userinfo_realName;
						for(var i = 0; i < model.selected.length; i++){
							//编号维护
							if(null == xt_userinfo_id){
								xt_userinfo_id=model.selected.items[i].data.xt_userinfo_id;
							}else{
								xt_userinfo_id=xt_userinfo_id+","+model.selected.items[i].data.xt_userinfo_id;
							}
							//名称维护
							if(null == xt_userinfo_realName){
								xt_userinfo_realName=model.selected.items[i].data.xt_userinfo_realName;
							}else{
								xt_userinfo_realName=xt_userinfo_realName+","+model.selected.items[i].data.xt_userinfo_realName;
							}
						}
						Ext.Msg.confirm('提示','确定要选择:<br>'+xt_userinfo_realName+'？',function(btn){
							if(btn == 'yes'){
								Ext.getCmp('candidateUsers').setValue(xt_userinfo_id);
								Ext.getCmp('candidateUsers_Text').setValue(xt_userinfo_realName);
								userWin.close();
							}
						});
					}
				}
			 },
			 {
				text:'检 索',
				tooltip:'检索',
				minWidth:tbarBtnMinWidth,
				cls:'searchBtn',
				icon:searchIcon,
				handler:function(){
					searchUser();
				}
			 },
			 {
				text:'重 置',
				tooltip:'重置',
				minWidth:tbarBtnMinWidth,
				icon:clearSearchIcon,
				handler:function(){
					formSearc.reset();
				}
			 }
		],
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'用户名',
				dataIndex:'xt_userinfo_name'
			},
			{
				header:'真实姓名',
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'性别',
				width:50,
				dataIndex:'xt_userinfo_sex',
				renderer:function(value){
					return initData(xtUserinfoSexList,value);
				}
			},
			{
				header:'是否已婚',
				width:80,
				dataIndex:'xt_userinfo_ismarried',
				renderer:function(value){
					return initData(xtUserinfoIsmarriedList,value);
				}
			},
			{
				header:'籍贯',
				dataIndex:'xt_userinfo_origo',
				renderer:function(value){
					if(value == ''){
						return '∨'
					}else{
						return value;
					}
				}
			},
			{
				header:'入职时间',
				dataIndex:'xt_userinfo_intime',
				renderer:function(value){
					if(value == ''){
						return '∨'
					}else{
						return value;
					}
				}
			},
			{
				header:'到期时间',
				dataIndex:'xt_userinfo_contractTime',
				renderer:function(value){
					if(value == ''){
						return '∨'
					}else{
						return value;
					}
				}
			},
			{
				header:'岗位',
				dataIndex:'xt_post_name'
			},
			{
				header:'部门',
				flex:1,
				dataIndex:'xt_departinfo_name'
			},
			{
				header:'状态',
				dataIndex:'xt_userinfo_isDelete',
				renderer:function(value){
					if(value == 0){
						return '在职'
					}else{
						return '离职'
					}
				}
			}
		],
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				var xt_userinfo_realName = userGrid.getSelectionModel().selected.items[0].data.xt_userinfo_realName;
				var xt_userinfo_id = userGrid.getSelectionModel().selected.items[0].data.xt_userinfo_id; 
				var xt_departinfo_name = userGrid.getSelectionModel().selected.items[0].data.xt_departinfo_name;
				var xt_post_name = userGrid.getSelectionModel().selected.items[0].data.xt_post_name;
				//Usertask中处理人选择
				if(flag == 1 && type == 1){
					var str = "[<font color=red><br>用户姓名:"+xt_userinfo_realName+"<br>所属部门:"+xt_departinfo_name+"<br>所属岗位:"+xt_post_name+"<br></font>]";
					Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
						if(btn == 'yes'){
							Ext.getCmp('assignee').setValue(xt_userinfo_id);
							Ext.getCmp('assignee_text').setValue(xt_userinfo_realName);
							userWin.close();
						}
					});
				}
				//“流程基本信息使用”中处理人选择
				if(flag == 1 && type == 2){
					var str = "[<font color=red><br>用户姓名:"+xt_userinfo_realName+"<br>所属部门:"+xt_departinfo_name+"<br>所属岗位:"+xt_post_name+"<br></font>]";
					Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
						if(btn == 'yes'){
							Ext.getCmp('candidateStarterUsers').setValue(xt_userinfo_id);
							Ext.getCmp('candidateStarterUsers_Text').setValue(xt_userinfo_realName);
							userWin.close();
						}
					});
				}
				//泳道中使用 处理人选择
				if(flag == 1 && type == 3){
					var str = "[<font color=red><br>用户姓名:"+xt_userinfo_realName+"<br>所属部门:"+xt_departinfo_name+"<br>所属岗位:"+xt_post_name+"<br></font>]";
					Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
						if(btn == 'yes'){
							Ext.getCmp('candidateStarterUsers_').setValue(xt_userinfo_id);
							Ext.getCmp('candidateStarterUsers_Text_').setValue(xt_userinfo_realName);
							userWin.close();
						}
					});
				}
			}
		},
		bbar:getGridTopBBar(userStore)
	});
	userStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(userStore,formSearc));});
	reGetWidthAndHeight();
	userWin = Ext.create('Ext.Window',{
		layout:'border',
		title:'用户列表',
		width:clientWidth,                    
		height:clientHeight, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		items:[formSearc,userGrid],
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	userWin.show();
	if(flag == 2 && type == 1){
		
	}else{
		//隐藏按钮
		Ext.getCmp('userGridBtn').setVisible(false);
	}
}

//初始化候选人
function initcandidateUsers(){
	
}

//初始化候选组（采用部门，岗位等） flag标识是1单个组选择2支持多选----------type类型1在UserTask中使用2在“流程基本信息使用”3在泳道中使用
//标准格式"    ['部门编号','0'],['岗位编号','1']   "
var DepartinfoAndPostWin;
var DepartinfoAndPostTreeGrid;
var DepartinfoAndPostStore;
function initcandidateGroups(flag,type){
	DepartinfoAndPostStore = Ext.create('Ext.data.TreeStore',{
    	root:{
			name:'一级',
			id:'0',
			expanded:true
		},
		/**此处一定要设置否则全部展开节点无效**/
		autoLoad:true,
        proxy:{
            type:'ajax',
            method:'post',
			url:'../xtOrgController/getStaticDepartinfoAndPostTreeGrid',
			reader:{
				type:'json'
			},
			extraParams:{id:'0',type:encodeURI('部门')}
        },
        lazyFill:true
    });
    DepartinfoAndPostTreeGrid = Ext.create('Ext.tree.Panel', {
        reserveScrollbar:true,
        collapsible:false,
        loadMask:true,
        useArrows:false,
        rootVisible:false,
        store:DepartinfoAndPostStore,
        animate:false,
        columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		border:true,
		selType:'checkboxmodel',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
        frame:true,
        listeners:{ 
            itemclick:function(node,optd){
            	var leaf = optd.data.leaf;
            	if(leaf == true){
            		
            	}
            }
        },
		fbar:[
			 '->',
			 {
			   width:260,
			   xtype:'triggerfield',
			   emptyText:'请输入关键字（如研发部、技术总监等）',
		       triggerCls:'x-form-clear-trigger',
		       onTriggerClick:function(){
		           this.reset();
		       },
		       listeners:{
		           change:function(){
		           		filterBy(DepartinfoAndPostTreeGrid,this.getValue(),'text');
		           },
		           buffer:250
		       }
			 },
			 {
				text:'保存选择',
				tooltip:'保存选择',
				scope:this,
				cls:'saveBtn',
				icon:saveIcon,
				handler:function(){
					var model = DepartinfoAndPostTreeGrid.getSelectionModel();
					if(model.selected.length == 0){
						msgTishi('请选择后在保存');
						return;
					}
					var id;
					var text;
					for(var i = 0; i < model.selected.length; i++){
						//编号维护
						if(null == id){
							if(model.selected.items[i].data.tempObject == '部门'){
								id="["+model.selected.items[i].data.id+",0]";
							}
							if(model.selected.items[i].data.tempObject == '岗位'){
								id="["+model.selected.items[i].data.id+",1]";
							}
						}else{
							if(model.selected.items[i].data.tempObject == '部门'){
								id=id+","+"["+model.selected.items[i].data.id+",0]";
							}
							if(model.selected.items[i].data.tempObject == '岗位'){
								id=id+","+"["+model.selected.items[i].data.id+",1]";
							}
						}
						//名称维护
						if(null == text){
							text=model.selected.items[i].data.text;
						}else{
							text=text+","+model.selected.items[i].data.text;
						}
					}
					Ext.Msg.confirm('提示','确定保存所选的数据？<br>'+text,function(btn){
						if(btn == 'yes'){
							//任务中使用
							if(type == 1){
								Ext.getCmp('candidateGroups').setValue(id);
								Ext.getCmp('candidateGroups_Text').setValue(text);
								DepartinfoAndPostWin.close();
							}
							//主流程中使用
							if(type == 2){
								Ext.getCmp('candidateStarterGroups').setValue(id);
								Ext.getCmp('candidateStarterGroups_Text').setValue(text);
								DepartinfoAndPostWin.close();
							}
							//泳道池中使用
							if(type == 3){
								Ext.getCmp('candidateStarterGroups_').setValue(id);
								Ext.getCmp('candidateStarterGroups_Text_').setValue(text);
								DepartinfoAndPostWin.close();
							}
						}
					});
				}
			 }
		],
        columns:[{
            text:'ID',
            flex:2,
            hideable:false,
            hidden:true,
            sortable:true,
            dataIndex:'id'
        },{
            xtype:'treecolumn',
            text:'名称',
            flex:1,
            sortable:true,
            dataIndex:'text'
        },{
            text:'性质',
            dataIndex:'tempObject',
            sortable:true,
            renderer:function(value){
				if(value == '部门'){
					return '部门'
				}else{
					return '<font color=red>岗位</font>'
				}
			}
        },{
            text:'备注',
            flex:1,
            dataIndex:'content',
            renderer:function(value){
            	return value;
            }
        }]
    });
	DepartinfoAndPostWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.6,                    
		height:clientHeight*0.8, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'部门、岗位选择器',
		items:DepartinfoAndPostTreeGrid
	});
	DepartinfoAndPostWin.show();
}

//连线样式设置虚线
function connectEdge(editor){
	if (editor.defaultEdge != null){
		editor.defaultEdge.style = 'straightEdge';
	}
}


/**
*点击节点渲染处理人，处理组等
*type 1任务中 2泳道 3主页面
**/
function initACC(assignee,candidateUsers,candidateGroups,type){
	if(type == 1){
		//任务中处理人，候选人，处理组等节点操作
		if(null != assignee){
			Ext.Ajax.request({ 
				url:'../xtUserinfoController/getXtUserinfoList', 
				method:'post', 
				params:{ 
					xt_userinfo_id:assignee
				}, 
				success:function(response, options){ 
					var o = Ext.util.JSON.decode(response.responseText); 
					for(var i = 0; i < o.items.length; i++){
						var item = o.items[i];
						Ext.getCmp('assignee_text').setValue(item.xt_userinfo_realName);
						break;
					}
				}, 
				failure:function(){ 
				} 
			}); 
		}
		if(null != candidateUsers){
			Ext.Ajax.request({ 
				url:'../xtUserinfoController/getXtUserinfoList', 
				method:'post', 
				params:{ 
					xt_userinfo_id:candidateUsers
				}, 
				success:function(response, options){ 
					var o = Ext.util.JSON.decode(response.responseText); 
					var candidateUsers_text;
					for(var i = 0; i < o.items.length; i++){
						var item = o.items[i];
						if(null != candidateUsers_text){
							candidateUsers_text = candidateUsers_text+","+item.xt_userinfo_realName;
						}else{
							candidateUsers_text = item.xt_userinfo_realName;
						}
					}
					Ext.getCmp('candidateUsers_Text').setValue(candidateUsers_text);
				}, 
				failure:function(){ 
				} 
			}); 
		}
		if(null != candidateGroups){
			Ext.getCmp('candidateGroups_Text').setValue('');
			var orgArray = candidateGroups.split('],[');
			var xt_departinfo_id;
			var xt_post_id;
			for(var i = 0; i < orgArray.length; i++){
				var org = orgArray[i];
				org = org.replace("[",'');
				org = org.replace("]",'');
				var org_ = org.split(",");
				//部门
				if(org_[1] == 0){
					if(null != xt_departinfo_id && '' != xt_departinfo_id){
						xt_departinfo_id = xt_departinfo_id+","+org_[0];
					}else{
						xt_departinfo_id = org_[0];
					}
				}
				//岗位
				if(org_[1] == 1){
					if(null != xt_post_id && '' != xt_post_id){
						xt_post_id = xt_post_id + "," + org_[0];
					}else{
						xt_post_id = org_[0];
					}
				}
			}
			if(null != xt_departinfo_id){
				//处理部门
				Ext.Ajax.request({ 
					url:'../xtDepartinfoController/queryXtDepartinfoList', 
					method:'post', 
					params:{ 
						xt_departinfo_id:xt_departinfo_id
					}, 
					success:function(response, options){ 
						var o = Ext.util.JSON.decode(response.responseText); 
						var candidateGroups_Text;
						for(var i = 0; i < o.items.length; i++){
							var item = o.items[i];
							if(null != candidateGroups_Text){
								candidateGroups_Text = candidateGroups_Text+","+item.xt_departinfo_name;
							}else{
								candidateGroups_Text = item.xt_departinfo_name;
							}
						}
						var candidateGroups_Text_Temp = Ext.getCmp('candidateGroups_Text').getValue();
						if(null != candidateGroups_Text_Temp && '' != candidateGroups_Text_Temp){
							if(null != candidateGroups_Text){
								Ext.getCmp('candidateGroups_Text').setValue(candidateGroups_Text_Temp+","+candidateGroups_Text);
							}
						}else{
							Ext.getCmp('candidateGroups_Text').setValue(candidateGroups_Text);
						}
						
					}, 
					failure:function(){ 
					} 
				});
			}
			if(null != xt_post_id){
				//处理岗位
				Ext.Ajax.request({ 
					url:'../xtPostController/getXtPostList', 
					method:'post', 
					params:{ 
						xt_post_id:xt_post_id
					}, 
					success:function(response, options){ 
						var o = Ext.util.JSON.decode(response.responseText); 
						var candidateGroups_Text;
						for(var i = 0; i < o.items.length; i++){
							var item = o.items[i];
							if(null != candidateGroups_Text){
								candidateGroups_Text = candidateGroups_Text+","+item.xt_post_name;
							}else{
								candidateGroups_Text = item.xt_post_name;
							}
						}
						var candidateGroups_Text_Temp = Ext.getCmp('candidateGroups_Text').getValue();
						if(null != candidateGroups_Text_Temp && '' != candidateGroups_Text_Temp){
							if(null != candidateGroups_Text){
								Ext.getCmp('candidateGroups_Text').setValue(candidateGroups_Text_Temp+","+candidateGroups_Text);
							}
						}else{
							Ext.getCmp('candidateGroups_Text').setValue(candidateGroups_Text);
						}
					}, 
					failure:function(){ 
					} 
				}); 
			}
		}
	}
	if(type == 2){
		//主流程中发起人，发起人组等节点操作
		if(null != assignee){
		
		}
		if(null != candidateGroups){
		
		}
	}
	if(type == 3){
		//泳道池中流程发起人，发起人组等节点操作
		if(null != assignee){
			Ext.Ajax.request({ 
				url:'../xtUserinfoController/getXtUserinfoList', 
				method:'post', 
				params:{ 
					xt_userinfo_id:assignee
				}, 
				success:function(response, options){ 
					var o = Ext.util.JSON.decode(response.responseText); 
					for(var i = 0; i < o.items.length; i++){
						var item = o.items[i];
						Ext.getCmp('candidateStarterUsers_Text_').setValue(item.xt_userinfo_realName);
						break;
					}
				}, 
				failure:function(){ 
				} 
			}); 
		}
		if(null != candidateGroups){
			Ext.getCmp('candidateStarterGroups_Text_').setValue('');
			var orgArray = candidateGroups.split('],[');
			var xt_departinfo_id;
			var xt_post_id;
			for(var i = 0; i < orgArray.length; i++){
				var org = orgArray[i];
				org = org.replace("[",'');
				org = org.replace("]",'');
				var org_ = org.split(",");
				//部门
				if(org_[1] == 0){
					if(null != xt_departinfo_id && '' != xt_departinfo_id){
						xt_departinfo_id = xt_departinfo_id+","+org_[0];
					}else{
						xt_departinfo_id = org_[0];
					}
				}
				//岗位
				if(org_[1] == 1){
					if(null != xt_post_id && '' != xt_post_id){
						xt_post_id = xt_post_id + "," + org_[0];
					}else{
						xt_post_id = org_[0];
					}
				}
			}
			if(null != xt_departinfo_id){
				//处理部门
				Ext.Ajax.request({ 
					url:'../xtDepartinfoController/queryXtDepartinfoList', 
					method:'post', 
					params:{ 
						xt_departinfo_id:xt_departinfo_id
					}, 
					success:function(response, options){ 
						var o = Ext.util.JSON.decode(response.responseText); 
						var candidateGroups_Text;
						for(var i = 0; i < o.items.length; i++){
							var item = o.items[i];
							if(null != candidateGroups_Text){
								candidateGroups_Text = candidateGroups_Text+","+item.xt_departinfo_name;
							}else{
								candidateGroups_Text = item.xt_departinfo_name;
							}
						}
						var candidateGroups_Text_Temp = Ext.getCmp('candidateStarterGroups_Text_').getValue();
						if(null != candidateGroups_Text_Temp && '' != candidateGroups_Text_Temp){
							if(null != candidateGroups_Text){
								Ext.getCmp('candidateStarterGroups_Text_').setValue(candidateGroups_Text_Temp+","+candidateGroups_Text);
							}
						}else{
							Ext.getCmp('candidateStarterGroups_Text_').setValue(candidateGroups_Text);
						}
						
					}, 
					failure:function(){ 
					} 
				});
			}
			if(null != xt_post_id){
				//处理岗位
				Ext.Ajax.request({ 
					url:'../xtPostController/getXtPostList', 
					method:'post', 
					params:{ 
						xt_post_id:xt_post_id
					}, 
					success:function(response, options){ 
						var o = Ext.util.JSON.decode(response.responseText); 
						var candidateGroups_Text;
						for(var i = 0; i < o.items.length; i++){
							var item = o.items[i];
							if(null != candidateGroups_Text){
								candidateGroups_Text = candidateGroups_Text+","+item.xt_post_name;
							}else{
								candidateGroups_Text = item.xt_post_name;
							}
						}
						var candidateGroups_Text_Temp = Ext.getCmp('candidateStarterGroups_Text_').getValue();
						if(null != candidateGroups_Text_Temp && '' != candidateGroups_Text_Temp){
							if(null != candidateGroups_Text){
								Ext.getCmp('candidateStarterGroups_Text_').setValue(candidateGroups_Text_Temp+","+candidateGroups_Text);
							}
						}else{
							Ext.getCmp('candidateStarterGroups_Text_').setValue(candidateGroups_Text);
						}
					}, 
					failure:function(){ 
					} 
				}); 
			}
		}
	}
}

function searchUser(){
	initSearch(userStore,'../xtUserinfoController/getXtUserinfoListByCondition',formSearc); 
}



var xtUserinfoWin;
var xtUserinfoGrid;
var xtUserinfoStore;
var xtUserinfoGrided;
var xtUserinfoSotreed;
var xtDpPanel;
var xtDpStore;
function addXtUserinfo(){
	initXtUserinfoGrid();
	initXtUserinfoGrided();
	initXtDpPanel();
	reGetWidthAndHeight();
	xtUserinfoWin = Ext.create('Ext.Window',{
		layout:'border', 
		maximizable:true,
		minimizable:true,
		maximized:true,
		plain:true,
		modal:true,
		autoScroll:true,
		width:clientWidth,                    
		height:clientHeight, 
		headerPosition:'top',
		title:'待选人',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:[xtDpPanel,
			  {
			  	region:'center',
			  	items:[
			  	{
			  		items:xtUserinfoGrid
			  	},
			  	{
			  		items:xtUserinfoGrided
			  	}
			  	]
			  }
			  ],
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				var model = xtUserinfoGrided.store;
				if(model.getCount() > 0){
					var xt_userinfo_id;
					var xt_userinfo_realName;
					for(var j= 0 ;j< model.getCount();j++){  
				        var record = model.getAt(j); 
				      //编号维护
						if(null == xt_userinfo_id){
							xt_userinfo_id=record.data.xt_userinfo_id;
						}else{
							xt_userinfo_id=xt_userinfo_id+","+record.data.xt_userinfo_id;
						}
						//名称维护
						if(null == xt_userinfo_realName){
							xt_userinfo_realName=record.data.xt_userinfo_realName;
						}else{
							xt_userinfo_realName=xt_userinfo_realName+","+record.data.xt_userinfo_realName;
						}
				    } 
					Ext.Msg.confirm('提示','确定要选择:<br>'+xt_userinfo_realName+'？',function(btn){
						if(btn == 'yes'){
							Ext.getCmp('candidateUsers').setValue(xt_userinfo_id);
							Ext.getCmp('candidateUsers_Text').setValue(xt_userinfo_realName);
							xtUserinfoWin.close();
						}
					});
				}else{
					Ext.getCmp('candidateUsers').setValue("");
					Ext.getCmp('candidateUsers_Text').setValue("");
					xtUserinfoWin.close();
				}
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	xtUserinfoWin.show();
	var model = xtUserinfoGrided.store;
	if(model.getCount() > 0){
		var aa = new Array(model.getCount());
        for(var j= 0 ;j< model.getCount();j++){  
        	var row = model.getAt(j); 
        	aa[j]=row;
	    } 
        for(var j= 0 ;j< aa.length;j++){
        	xtUserinfoGrided.store.remove(aa[j]);
        }
        xtUserinfoGrided.getView().refresh(); 
	}
	var users = Ext.getCmp('candidateUsers').getValue();
	var params = {};
	params.xt_userinfo_id = users;
	if(null != users && users != ''){
		Ext.Ajax.request({  
			params:params, 
		    url:'../xtUserinfoController/getXtUserinfoList',  
		    method:'post',  
		    success:function(response,opts){
		    	var obj=Ext.decode(response.responseText);  
		    	for(var i = 0; i < obj.items.length; i++){
		        	xtUserinfoGrided.store.insert(xtUserinfoGrided.store.getCount(), obj.items[i]);  //插入新行作为grid最后一行
		    	}
		        xtUserinfoGrided.getView().refresh(); 
		    },  
		    failure:function(response,opts){  
		    }  
		});
	}
}


/**待导入用户**/
function initXtUserinfoGrid(){
	reGetWidthAndHeight();
	xtUserinfoStore = getGridJsonStore('../xtUserinfoController/getXtUserinfoListAllByCondition?xt_userinfo_isDelete=0',[]);
	xtUserinfoGrid = Ext.create('Ext.grid.Panel',{
		region:'north',
		store:xtUserinfoStore,
		height:document.documentElement.clientHeight*0.5,
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		selType:'checkboxmodel',
		title:'待选用户',
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
				header:'用户名',
				flex:1,
				dataIndex:'xt_userinfo_name'
			},
			{
				header:'真实姓名',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'性别',
				dataIndex:'xt_userinfo_sex',
				renderer:function(value){
					if(value == 0){
						return '男'
					}else{
						return '女'
					}
				}
			},
			{
				header:'籍贯',
				dataIndex:'xt_userinfo_origo',
				renderer:function(value){
					if(value == ''){
						return '∨'
					}else{
						return value;
					}
				}
			},
			{
				header:'岗位',
				dataIndex:'xt_post_name',
				renderer:function(value){
					if(value == ''){
						return '—'
					}else{
						return value;
					}
				}
			},
			{
				header:'部门',
				flex:1,
				dataIndex:'xt_departinfo_name',
				renderer:function(value){
					if(value == ''){
						return '—'
					}else{
						return value;
					}
				}
			},
			{
				header:'状态',
				dataIndex:'xt_userinfo_isDelete',
				renderer:function(value){
					if(value == 0){
						return '在职'
					}else{
						return '离职'
					}
				}
			}
		],
		tbar:[
			 {
				text:'选择用户',
				tooltip:'选择用户',
				scope:this,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addXtUser();
				}
			 }
		],
		bbar:getGridTopBBar(xtUserinfoStore)
	});
}


/**已选择用户**/
function initXtUserinfoGrided(){
	reGetWidthAndHeight();
	xtUserinfoGrided = Ext.create('Ext.grid.Panel',{
		region:'center',
		height:document.documentElement.clientHeight*0.7,
		style:'margin-left:auto;margin-right:auto;margin-bottom:auto;',
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		border:false,
		selType:'checkboxmodel',
		/**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
		title:'已导入用户',
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
				header:'用户名',
				flex:1,
				dataIndex:'xt_userinfo_name'
			},
			{
				header:'真实姓名',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'性别',
				dataIndex:'xt_userinfo_sex',
				renderer:function(value){
					if(value == 0){
						return '男'
					}else{
						return '女'
					}
				}
			},
			{
				header:'籍贯',
				dataIndex:'xt_userinfo_origo',
				renderer:function(value){
					if(value == ''){
						return '∨'
					}else{
						return value;
					}
				}
			},
			{
				header:'岗位',
				dataIndex:'xt_post_name',
				renderer:function(value){
					if(value == ''){
						return '—'
					}else{
						return value;
					}
				}
			},
			{
				header:'部门',
				flex:1,
				dataIndex:'xt_departinfo_name',
				renderer:function(value){
					if(value == ''){
						return '—'
					}else{
						return value;
					}
				}
			},
			{
				header:'状态',
				dataIndex:'xt_userinfo_isDelete',
				renderer:function(value){
					if(value == 0){
						return '在职'
					}else{
						return '离职'
					}
				}
			}
		],
		tbar:[
			 {
				text:'移除用户',
				tooltip:'移除用户',
				scope:this,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delXtUser();
				}
			 }
		]
	});
}


function initXtDpPanel(){
	//1创建store
	xtDpStore = Ext.create('Ext.data.TreeStore', {  
	     root:{  
              expanded:true  
         },
         proxy:{  
                type:'ajax',  
                url:'../xtCommonController/getXtOrgTree',  
                reader:{  
                    type:'json',  
                    rootProperty:'items'  
                },
				extraParams:{id:'0',type:encodeURI('部门')}  
         }  
	});  
	//2创建treePanel
	xtDpPanel = Ext.create('Ext.tree.Panel',{   
		region:'west',
        store:xtDpStore,  
        autoEncode:true,//提交时是否自动编码   
        rootVisible:false,  
        width:200,
        collapsible:true,
        title:'组织机构',
        /**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        listeners:{  
            beforeitemexpand:function(node,optd){  
            	//展开节点之前触发  
                var id=node.data.id;  
                var type=node.data.type; 
                xtDpStore.setProxy({   
                	//异步从服务器上加载数据  extjs会自动帮我们解析  
                    type:'ajax',  
                    url:'../xtCommonController/getXtOrgTree',  
                    extraParams:{id:id,type:encodeURI(type)}
                 });  
            },
            itemclick:function(node,optd){
            	var leaf = optd.data.leaf;
            	menuClick(optd);
            }  
        }
    });  
}

/**导入用户**/
function addXtUser(){
	var model = xtUserinfoGrid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择待选用户');
		return;
	}
	Ext.Msg.confirm('提示','确定选择所选用户？',function(btn){
		if(btn == 'yes'){
	        //刷新
	        for(var i = 0; i < model.selected.length; i++){
	        	xtUserinfoGrided.store.insert(xtUserinfoGrided.store.getCount(), model.selected.items[i].data);  //插入新行作为grid最后一行
	    	}
	        xtUserinfoGrided.getView().refresh(); 
		}
	});
}


/**移除用户**/
function delXtUser(){
	var model = xtUserinfoGrided.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择要移除的用户');
		return;
	}
	Ext.Msg.confirm('提示','确定移除所选用户？',function(btn){
		if(btn == 'yes'){
			Ext.each(model.getSelection(),function(record){
			//先通过ajax从后台删除数据，删除成功后再从页面删除数据
				xtUserinfoGrided.store.remove(record);
			});
			xtUserinfoGrided.getView().refresh(); 
		}
	});
}



//菜单点击事件
function menuClick(node){
 	var id = node.data.id;
 	var type = node.data.type;
 	var parm = {};
 	if(type == '部门'){
 		parm.xt_departinfo_id = id;
 	}else if(type == '岗位'){
 		parm.xt_post_id = id;
 	}
 	load(xtUserinfoGrid,parm);
}

var xtDPWin;
var xtDPGrided;
var xtDpPanel2;
var xtDpStore2;
function addXtDP(candidateGroups,candidateGroups_Text){
	initXtDpGrided();
	initXtDpPanel2();
	reGetWidthAndHeight();
	xtDPWin = Ext.create('Ext.Window',{
		layout:'border', 
		maximizable:true,
		minimizable:true,
		maximized:true,
		plain:true,
		modal:true,
		width:clientWidth,                    
		height:clientHeight*1.4, 
		headerPosition:'top',
		title:'待选组',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:[xtDpPanel2,
			  {
			  	region:'center',
			  	items:[xtDPGrided]
			  }
			  ],
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				var model = xtDPGrided.store;
				if(model.getCount() > 0){
					var xt_dp_id;
					var xt_dp_name;
					for(var j= 0 ;j< model.getCount();j++){  
				        var record = model.getAt(j); 
						if(null == xt_dp_id){
							if(record.data.type == '部门'){
								xt_dp_id="["+record.data.id+",0]";
							}
							if(record.data.type == '岗位'){
								xt_dp_id="["+record.data.id+",1]";
							}
						}else{
							if(record.data.type == '部门'){
								xt_dp_id=xt_dp_id+","+"["+record.data.id+",0]";
							}
							if(record.data.type == '岗位'){
								xt_dp_id=xt_dp_id+","+"["+record.data.id+",1]";
							}
						}
						//名称维护
						if(null == xt_dp_name){
							xt_dp_name=record.data.text;
						}else{
							xt_dp_name=xt_dp_name+","+record.data.text;
						}
				    } 
					Ext.Msg.confirm('提示','确定要选择:<br>'+xt_dp_name+'？',function(btn){
						if(btn == 'yes'){
							Ext.getCmp(candidateGroups).setValue(xt_dp_id);
							Ext.getCmp(candidateGroups_Text).setValue(xt_dp_name);
							xtDPWin.close();
						}
					});
				}else{
					Ext.getCmp(candidateGroups).setValue("");
					Ext.getCmp(candidateGroups_Text).setValue("");
					xtDPWin.close();
				}
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	xtDPWin.show();
	var model = xtDPGrided.store;
	if(model.getCount() > 0){
		var aa = new Array(model.getCount());
        for(var j= 0 ;j< model.getCount();j++){  
        	var row = model.getAt(j); 
        	aa[j]=row;
	    } 
        for(var j= 0 ;j< aa.length;j++){
        	xtDPGrided.store.remove(aa[j]);
        }
		xtDPGrided.getView().refresh(); 
	}
	var xt_depart_id;
	var xt_post_id;
	var dps = Ext.getCmp(candidateGroups).getValue();
	var aa = dps.split("],");
	for(var i = 0;i<aa.length;i++){
		var b ='';
		if(i == aa.length-1){
			b=aa[i].substring(1,aa[i].length-1);
		}else{
			b=aa[i].substring(1,aa[i].length);
		}
		var cc = b.split(",");
		if(cc[1] == '0'){
			if(null == xt_depart_id){
				xt_depart_id=cc[0];
			}else{
				xt_depart_id=xt_depart_id+","+cc[0];
			}
		}else{
			if(null == xt_post_id){
				xt_post_id=cc[0];
			}else{
				xt_post_id=xt_post_id+","+cc[0];
			}
		}
	}
	var params = {};
	params.xt_departinfo_id = xt_depart_id;
	params.xt_post_id = xt_post_id;
	if(null != dps && dps != ''){
		Ext.Ajax.request({  
			params:params, 
		    url:'../xtCommonController/queryXtDPList',  
		    method:'post',  
		    success:function(response,opts){
		    	var obj=Ext.decode(response.responseText);  
		    	for(var i = 0; i < obj.items.length; i++){
		        	xtDPGrided.store.insert(xtDPGrided.store.getCount(), obj.items[i]);  //插入新行作为grid最后一行
		    	}
		    	xtDPGrided.getView().refresh(); 
		    },  
		    failure:function(response,opts){  
		    }  
		});
	}
}

/**已选择用户**/
function initXtDpGrided(){
	reGetWidthAndHeight();
	xtDPGrided = Ext.create('Ext.grid.Panel',{
		region:'center',
		height:document.documentElement.clientHeight*0.7,
		style:'margin-left:auto;margin-right:auto;margin-bottom:auto;',
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		border:false,
		selType:'checkboxmodel',
		/**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
		title:'已导入组',
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
				header:'名称',
				flex:1,
				dataIndex:'text'
			},
			{
				header:'性质',
				dataIndex:'type',
				renderer:function(value){
					if(value == 0){
						return '部门'
					}else{
						return '岗位'
					}
				}
			}
		],
		tbar:[
			 {
				text:'移除组',
				tooltip:'移除组',
				scope:this,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delXtDP();
				}
			 }
		]
	});
}


function initXtDpPanel2(){
	//1创建store
	xtDpStore2 = Ext.create('Ext.data.TreeStore', {  
	     root:{  
              expanded:true  
         },
         proxy:{  
                type:'ajax',  
                url:'../xtCommonController/getXtOrgTree',  
                reader:{  
                    type:'json',  
                    rootProperty:'items'  
                },
				extraParams:{id:'0',type:encodeURI('部门')}  
         }  
	});  
	//2创建treePanel
	xtDpPanel2 = Ext.create('Ext.tree.Panel',{   
		region:'west',
        store:xtDpStore2,  
        autoEncode:true,//提交时是否自动编码   
        rootVisible:false,  
        width:200,
        collapsible:true,
        title:'候选组',
        /**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
		tbar:[
			 {
				text:'导入候选组',
				tooltip:'导入候选组',
				scope:this,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addXtDPinfo();
				}
			 }
		],
        listeners:{  
            beforeitemexpand:function(node,optd){  
            	//展开节点之前触发  
                var id=node.data.id;  
                var type=node.data.type; 
                xtDpStore2.setProxy({   
                	//异步从服务器上加载数据  extjs会自动帮我们解析  
                    type:'ajax',  
                    url:'../xtCommonController/getXtOrgTree',  
                    extraParams:{id:id,type:encodeURI(type)}
                 });  
            }
        }
    });  
}

/**导入组**/
function addXtDPinfo(){
	var checkedNodes = xtDpPanel2.getSelection();
	if(checkedNodes.length == 0){
		msgTishi('请选择待选组');
		return;
	}
	Ext.Msg.confirm('提示','确定选择所选组？',function(btn){
		if(btn == 'yes'){
	        //刷新
			for(var i=0;i<checkedNodes.length;i++){
				xtDPGrided.store.insert(xtDPGrided.store.getCount(), checkedNodes[i].data);  //插入新行作为grid最后一行
			} 
	        xtDpGrided.getView().refresh(); 
		}
	});
}

/**移除组**/
function delXtDP(){
	var model = xtDPGrided.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择要移除的组');
		return;
	}
	Ext.Msg.confirm('提示','确定移除所选组？',function(btn){
		if(btn == 'yes'){
			Ext.each(model.getSelection(),function(record){
			//先通过ajax从后台删除数据，删除成功后再从页面删除数据
				xtDPGrided.store.remove(record);
			});
			xtDPGrided.getView().refresh(); 
		}
	});
}
