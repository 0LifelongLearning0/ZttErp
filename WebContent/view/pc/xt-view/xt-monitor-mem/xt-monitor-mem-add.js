var xtMonitorMemWinAdd;
var xtMonitorMemFormAdd;
function addXtMonitorMem(){
	initXtMonitorMemFormAdd();
	xtMonitorMemWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:400,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:xtMonitorMemFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(xtMonitorMemFormAdd,'../xtMonitorMemController/addXtMonitorMem',grid,xtMonitorMemWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	xtMonitorMemWinAdd.show();
}
function initXtMonitorMemFormAdd(){
	xtMonitorMemFormAdd = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
			fieldLabel:'总内存',
			xtype:'textfield',
			name:'xt_monitor_memTotal',
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'当前内存使用量',
			xtype:'textfield',
			name:'xt_monitor_memCurrUse',
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'当前内存剩余量',
			xtype:'textfield',
			name:'xt_monitor_memCurrSy',
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'',
			xtype:'textfield',
			name:'xt_monitor_memJhTotal',
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'当前交换区使用量',
			xtype:'textfield',
			name:'xt_monitor_memJhCurrUse',
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'当前交换区剩余量',
			xtype:'textfield',
			name:'xt_monitor_memJhSy',
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'取读时间',
			xtype:'textfield',
			name:'xt_monitor_memTime',
			maxLength:20,
			anchor:'100%'
		}
		]
	});
}
