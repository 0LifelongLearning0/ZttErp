
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
var zx_car_status = new Ext.data.Store({
	singleton:true, 
	proxy:new Ext.data.HttpProxy( { 
		url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_car_status',
		reader:new Ext.data.JsonReader({
			root:'items',
			type:'json'
		})
	}),
	fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
	autoLoad:true 
});

function initassignee(user_id,user_name,carflag){
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
				Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
					//汽车使用申请
					if(btn == 'yes' &&　carflag == '1'){
						Ext.getCmp(user_id).setValue(xt_userinfo_id);
						Ext.getCmp(user_name).setValue(xt_userinfo_realName);
						Ext.getCmp('zxcardepart').setValue(xt_departinfo_name);
						userWin.close();
					}else {
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

function searchUser(){
	initSearch(userStore,'../xtUserinfoController/getXtUserinfoListByCondition',formSearc); 
}

//日期格式化
function dateFtt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 

//获取车辆
function initCarInfo(car_id,car_name) {
	userStore = getGridJsonStore('../zxCarController/getZxCarListByCondition',[{'state':'4'}]);
	/**查询区域可扩展**/
	var formItems = Ext.create('Ext.FormPanel',{
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
				fieldLabel:'车牌',
				xtype:'textfield',
				labelWidth:70,
				id:'car_no',
				name:'car_no',
				anchor:'30%',
				labelAlign:'left'
			},
			{
				fieldLabel:'状态',
				xtype:"combo",
				queryMode:'local', 
				store:zx_car_status,
				triggerAction:"all",
	            editable:false,
				readonly:true,
	            emptyText:'请选择',
	            valueField:"xt_data_dictionary_value",
	            displayField:"xt_data_dictionary_name",
	            id:'state',
				name:'state',
				anchor:'30%',
				labelAlign:'left'
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
				header:'Id',
				flex:1,
				dataIndex:'id',
				hidden:true
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'state',
				renderer:function(value){
					return initComBoData(zx_car_status,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'车牌',
				flex:1,
				dataIndex:'car_no'
			},
			{
				header:'型号',
				flex:1,
				dataIndex:'model'
			},
			{
				header:'品牌',
				flex:1,
				dataIndex:'brand'
			},
			{
				header:'可乘坐人数',
				flex:1,
				dataIndex:'people_num'
			}
		],
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				var zx_car_id = userGrid.getSelectionModel().selected.items[0].data.id;
				var zx_car_no = userGrid.getSelectionModel().selected.items[0].data.car_no;
				var zx_people_num = userGrid.getSelectionModel().selected.items[0].data.people_num;
				var zx_car_brand = userGrid.getSelectionModel().selected.items[0].data.brand; 
				var zx_car_model = userGrid.getSelectionModel().selected.items[0].data.model;
				var str = "[<font color=red><br>车牌号:"+zx_car_no+"<br></font>]";
				Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
					//汽车使用申请
					Ext.getCmp(car_id).setValue(zx_car_id);
					Ext.getCmp(car_name).setValue(zx_car_no);
					Ext.getCmp('people_num').setValue(zx_people_num);
					userWin.close();
				});
			}
		},
		bbar:getGridTopBBar(userStore)
	});
	userStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(userStore,formSearc));});
	reGetWidthAndHeight();
	userWin = Ext.create('Ext.Window',{
		layout:'border',
		title:'可用车辆列表',
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