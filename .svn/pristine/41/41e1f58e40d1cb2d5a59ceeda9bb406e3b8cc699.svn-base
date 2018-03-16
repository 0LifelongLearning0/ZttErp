var xtUserinfoWin;
var xtUserinfoGrid;
var xtUserinfoStore;
function showUserWin(utype){
	initXtUserinfoGrid(utype);
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
		buttons:[
		]
	});
	xtUserinfoWin.setTitle("参会人员选择");
	xtUserinfoWin.show();
	
	xtUserinfoStore.on("load",function(store){
	    var ids = '';
		if(utype == 1){
			ids = Ext.getCmp('user_ids_t').getValue();
		}else if(utype == 0){
			ids = Ext.getCmp('user_ids_o').getValue();
		}
		var arr = [];
	    if(ids != null && ids != ''){
			for(var i=0;i<xtUserinfoStore.getCount();i++){  
			    var record = xtUserinfoStore.getAt(i);  
			    if(ids.indexOf(record.data.xt_userinfo_id) > -1){  
			        arr.push(record);
			    }  
			}  
		}
		xtUserinfoGrid.getSelectionModel().select(arr,true,true);
	});
}

/**用户显示**/
var formSearc;
function initXtUserinfoGrid(utype){
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
			text:'添加已选人员',
			tooltip:'添加已选人员',
			minWidth:tbarBtnMinWidth,
			cls:'addBtn',
			icon:addIcon,
			handler:function(){
				var record = xtUserinfoGrid.getSelectionModel().selected;
				if(record.length == 0){
					msgTishi('请选择要添加的人员！');
					return;
				}
				
				var names = '';
				var ids = '';
				if(utype == 1){
					for(var i = 0;i < record.items.length;i++){
						names += record.items[i].data.xt_userinfo_realName + ',';
						ids += record.items[i].data.xt_userinfo_id + ',';
					}
					
					if(ids != '') ids = ids.substring(0,ids.length - 1);
					if(names != '') names = names.substring(0,names.length - 1);
					Ext.getCmp('user_ids_t').setValue(ids);
					Ext.getCmp('user_name_t').setValue(names);
				}else if(utype == 0){
					for(var i = 0;i < record.items.length;i++){
						names += record.items[i].data.xt_userinfo_realName + ',';
						ids += record.items[i].data.xt_userinfo_id + ',';
					}
					
					if(ids != '') ids = ids.substring(0,ids.length - 1);
					if(names != '') names = names.substring(0,names.length - 1);
					Ext.getCmp('user_ids_o').setValue(ids);
					Ext.getCmp('user_name_o').setValue(names);
				}
				xtUserinfoWin.close();
			}
		 },
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
				header:'岗位',
				dataIndex:'xt_post_name'
			},
			{
				header:'部门',
				flex:1,
				dataIndex:'xt_departinfo_name'
			}
		],
	});
	xtUserinfoStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(xtUserinfoStore,formSearc));});
}

function searchDefindSelectUser(){
	initSearch(xtUserinfoStore,'../xtDataAuthorityController/getUserinfoListByCondition',formSearc); 
}