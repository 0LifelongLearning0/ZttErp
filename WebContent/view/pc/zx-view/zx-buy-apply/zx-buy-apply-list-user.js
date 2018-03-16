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

function initassignee(user_id,user_name){
	userStore = getGridJsonStore('../xtUserinfoController/getXtUserinfoListByCondition',[{}]);
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
	userGrid = Ext.create('top.Ext.grid.Panel',{
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
				var str = "[<font color=red><br>用户姓名:"+xt_userinfo_realName+"<br>所属部门:"+xt_departinfo_name+"<br>所属岗位:"+xt_post_name+"<br></font>]";
				top.Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
					if(btn == 'yes'){
						Ext.getCmp(user_id).setValue(xt_userinfo_id);
						Ext.getCmp(user_name).setValue(xt_userinfo_realName);
						userWin.close();
					}
				});
			}
		},
		bbar:getGridTopBBar(userStore)
	});
	userStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(userStore,formSearc));});
	reGetWidthAndHeight();
	userWin = Ext.create('top.Ext.Window',{
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
		top.Ext.getCmp('userGridBtn').setVisible(false);
	}
}

function searchUser(){
	initSearch(userStore,'../xtUserinfoController/getXtUserinfoListByCondition',formSearc); 
}
