//初始化项目列表
var projectGrid;
var projectStore;
var projectWin;
var projectFormSearch;
function initProject(project_id,project_num,project_name){
	projectStore = getGridJsonStore('../zxProjectController/getZxProjectListByCondition',[{}]);
	/**查询区域可扩展**/
	var formItems = Ext.create('top.Ext.FormPanel',{
		maxHeight:220,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
			layout:'table',
			xtype:'form',
			anchor:'100%',
			items:[
			{
				fieldLabel:'项目名称',
				xtype:'textfield',
				name:'name',
				width:220
			},
			{
				fieldLabel:'项目号',
				xtype:'textfield',
				name:'num',
				width:220
			}
			]
		}
		]
	});
	projectFormSearch = initSearchFormByUserdefined('north',formItems,true,'left');
	projectGrid = Ext.create('top.Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:projectStore,
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
				text:'检 索',
				tooltip:'检索',
				minWidth:tbarBtnMinWidth,
				cls:'searchBtn',
				icon:searchIcon,
				handler:function(){
					searchProject();
				}
			 },
			 {
				text:'重 置',
				tooltip:'重置',
				minWidth:tbarBtnMinWidth,
				icon:clearSearchIcon,
				handler:function(){
					projectFormSearch.reset();
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
				header:'项目名称',
				flex:1,
				dataIndex:'name'
			},
			{
				header:'项目号',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'项目发货时间',
				flex:1,
				dataIndex:'ship_date'
			}
		],
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				var id = projectGrid.getSelectionModel().selected.items[0].data.id; 
				var name = projectGrid.getSelectionModel().selected.items[0].data.name;
				var num = projectGrid.getSelectionModel().selected.items[0].data.num;
				var str = "[<font color=red><br>项目名称:"+name+"<br>项目案号:"+num+"<br></font>]";
				top.Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
					if(btn == 'yes'){
						Ext.getCmp(project_id).setValue(id);
						Ext.getCmp(project_name).setValue(name);
						Ext.getCmp(project_num).setValue(num);
						projectWin.close();
					}
				});
			}
		},
		bbar:getGridTopBBar(projectStore)
	});
	projectStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(projectStore,projectFormSearch));});
	reGetWidthAndHeight();
	projectWin = Ext.create('top.Ext.Window',{
		layout:'border',
		title:'项目列表',
		width:clientWidth,                    
		height:clientHeight, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		items:[projectFormSearch,projectGrid],
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	projectWin.show();
	if(flag == 2 && type == 1){
		
	}else{
		//隐藏按钮
		top.Ext.getCmp('projectGridBtn').setVisible(false);
	}
}

function searchProject(){
	initSearch(projectStore,'../zxProjectController/getZxProjectListByCondition',projectFormSearch); 
}