var xtUserinfoWin;
var xtUserinfoGrid;
var xtUserinfoStore;
function showUserWin(){
	initXtUserinfoGrid();
	reGetTopWidthAndHeight();
	xtUserinfoWin = Ext.create('top.Ext.Window',{
		layout:'border', 
		width:clientWidth*0.65,                    
		height:clientHeight*0.75, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		frame:true,
		headerPosition:'top',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:[formSearc,xtUserinfoGrid],
		buttons:[ ]
	});
	xtUserinfoWin.setTitle("接收者选择");
	xtUserinfoWin.show();
}


/**用户显示**/
var formSearc;
function initXtUserinfoGrid(){
	reGetWidthAndHeight();
	xtUserinfoStore = getGridJsonStore('../xtDataAuthorityController/getUserinfoListByCondition',[]);
	/**查询区域可扩展**/
	var formItems = Ext.create('top.Ext.FormPanel',{
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
	xtUserinfoGrid = Ext.create('top.Ext.grid.Panel',{
		region:'center',
		store:xtUserinfoStore,
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		selType:'checkboxmodel',
		title:'拥有者列表',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
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
				searchDefindSelectUser();
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
				header:'ID',
				flex:1,
				hidden:true,
				dataIndex:'xt_userinfo_id'
			},
			{
				header:'真实姓名',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'岗位',
				dataIndex:'xt_post_name'
			},
			{
				header:'部门',
				flex:1,
				dataIndex:'xt_departinfo_name'
			}
		],
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				var id = grid.getSelectionModel().selected.items[0].data.xt_userinfo_id;
				var text = grid.getSelectionModel().selected.items[0].data.xt_userinfo_realName;
				top.Ext.Msg.confirm('提示','确定要选择:<br>'+text+'？',function(btn){
					if(btn == 'yes'){
						Ext.getCmp('user_realname').setValue(text);
						Ext.getCmp('user_id').setValue(id);
						xtUserinfoWin.close();
					}
				});
			}
		},
		bbar:getGridTopBBar(xtUserinfoStore)
	});
	xtUserinfoStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(xtUserinfoStore,formSearc));});
}

function searchDefindSelectUser(){
	initSearch(xtUserinfoStore,'../xtDataAuthorityController/getUserinfoListByCondition',formSearc); 
}