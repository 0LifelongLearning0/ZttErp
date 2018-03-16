var xtQuartzWinAdd;
var xtQuartzFormAdd;
function addXtQuartzSet(){
	initXtQuartzFormAdd();
	reGetWidthAndHeight();
	xtQuartzWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.8,                    
		height:clientHeight, 
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
		items:xtQuartzFormAdd,
		buttons:[{
			text:'参考样例设置',
			handler:function(button){
				ckXtQuartzSet();
			}
		},{
			text:'选择快捷配置',
			handler:function(button){
				selectGrid();
			}
		},{
			text:'保存',
			itemId:'save',
			handler:function(button){
				Ext.Msg.confirm('提示','是否要更改原来"调度任务"中数据？',function(btn){
					if(btn == 'yes'){
						submitForm(xtQuartzFormAdd,'../xtQuartzSetController/addXtQuartzSet?flag=1',grid,xtQuartzWinAdd,false,true);
					}else{
						submitForm(xtQuartzFormAdd,'../xtQuartzSetController/addXtQuartzSet?flag=2',grid,xtQuartzWinAdd,false,true);
					}
				});
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	xtQuartzWinAdd.show();
}
function initXtQuartzFormAdd(){
	xtQuartzFormAdd = Ext.create('Ext.FormPanel',{
		xtype:'form',
		labelWidth:50,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:140,
			labelAlign:'right',
			flex:1,
			margin:'4 5 4 5'
		},
		items:[
		{
			fieldLabel:'任务编号',
			xtype:'textfield',
			name:'jobId',
			allowBlank:false,
			readOnly:true,
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'任务名称',
			xtype:'textfield',
			name:'jobName',
			readOnly:true,
			allowBlank:false,
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'任务分组',
			xtype:'textfield',
			name:'jobGroup',
			readOnly:true,
			allowBlank:false,
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'任务运行时间表达式',
			xtype:'textfield',
			name:'cronExpression',
			allowBlank:false,
			maxLength:50,
			anchor:'100%'
		},
		{
			fieldLabel:'任务描述',
			xtype:'textarea',
			name:'desc',
			allowBlank:false,
			maxLength:50,
			height:120,
			anchor:'100%'
		},
		{
			fieldLabel:'执行的类方法',
			xtype:'textfield',
			name:'targetMethod',
			maxLength:120,
			anchor:'100%'
		},
		{
			fieldLabel:'执行的类',
			xtype:'textfield',
			name:'targetClass',
			maxLength:500,
			anchor:'100%'
		}
		]
	});
}
