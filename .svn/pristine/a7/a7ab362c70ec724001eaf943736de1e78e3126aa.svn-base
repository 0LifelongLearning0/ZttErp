var zxOutApplyWinAdd;
var zxOutApplyFormAdd;
var zxOutApplyFormAddFieldSet;
var zxProjectFormAddFieldSet;
function addZxOutApply(){
	initZxOutApplyFormAdd();
	zxOutApplyWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:1050,
		height:600,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'新增申请单',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOutApplyFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOutApplyFormAdd,'../zxOutApplyController/addZxOutApply',grid,zxOutApplyWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOutApplyWinAdd.show();
	
}
function initZxOutApplyFormAdd(){
	zxProjectFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'申请项目',
		items:[
       {
			layout:"column",
			items:[
				{
					fieldLabel:'项目ID',
					xtype:'textfield',
					name:'project_id',
					hidden:true,
					id:'project_id',
					maxLength:32,
					width:320
				},
				{
					fieldLabel:'项目案号',
					xtype:'textfield',
					trigger1Cls:'x-form-ss-trigger',
					onTrigger1Click:function(){initProject('project_id','project_num','project_name');},
					name:'project_num',
					id:'project_num',
					allowBlank: false,
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'项目名称',
					xtype:'textfield',
					name:'project_name',
					id:'project_name',
					maxLength:100,
					readOnly:true,
					width:320
				}
			]
		}
	]
	});
	zxOutApplyFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
       {
			layout:"column",
			items:[
			{
				fieldLabel:'申请编号',
				xtype:'textfield',
				name:'apply_num',
				allowBlank: false,
				maxLength:100,
				width:320
			},
			{
				fieldLabel:'图&emsp;&emsp;号',
				xtype:'textfield',
				name:'draw_num',
				maxLength:100,
				width:320
			},
			{
				fieldLabel:'制作台数',
				xtype:'textfield',
				name:'make_num',
				allowBlank: false,
				maxLength:20,
				width:320
			}
			]
		},       
		{
			layout:"column",
			items:[
			{
				fieldLabel:'申请时间',
				xtype:'datetimefield',
				format:'Y-m-d H:i',
				name:'apply_time',
				allowBlank: false,
				maxLength:19,
				width:320
			},
			{
				fieldLabel:'需求日期',
				xtype:'datefield',
				format:'Y-m-d',
				name:'need_time',
				allowBlank: false,
				maxLength:19,
				width:320
			},
			{
				fieldLabel:'清单下发时间',
				xtype:'datetimefield',
				format:'Y-m-d H:i',
				name:'send_draw_time',
				allowBlank: false,
				maxLength:19,
				width:320
			}
			]
		},
		{
			layout:"column",
			items:[
			{
				fieldLabel:'备&emsp;&emsp;注',
				xtype:'textareafield',
				name:'remark',
				maxLength:65535,
				width:980
			}
			]
		}
	]
	});
	zxOutApplyFormAdd = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		/**新方法使用开始**/
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		/**新方法使用结束**/
		fieldDefaults:{
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
			zxProjectFormAddFieldSet,
			zxOutApplyFormAddFieldSet
		]
	});
}
