var zxOutApplyWinEdit;
var zxOutApplyFormEdit;
var zxOutApplyFormEditFieldSet;
var zxProjectFormEditFieldSet;
function updateZxOutApply(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	if(record.items[0].data.status != '1'){
		msgTishi('待申请状态才可以修改！');
		return;
	}
	initZxOutApplyFormEdit();
	zxOutApplyWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:1050,
		height:600,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'修改申请单',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOutApplyFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOutApplyFormEdit,'../zxOutApplyController/updateZxOutApply',grid,zxOutApplyWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOutApplyWinEdit.show();
	loadFormDataCallBack(zxOutApplyFormEdit,'../zxOutApplyController/getZxOutApplyById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxOutApplyFormEdit(){
	zxProjectFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'申购项目',
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
	zxOutApplyFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
       {
			layout:"column",
			items:[
			{
				fieldLabel:'标识ID',
				xtype:'textfield',
				hidden:true,
				name:'id',
				allowBlank:false,
				maxLength:32
			},
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
				fieldLabel:'申购人ID',
				xtype:'textfield',
				name:'apply_user_id',
				id:'apply_user_id',
				hidden:true,
				maxLength:32,
				anchor:'20%'
			},
			{
				fieldLabel:'申购时间',
				xtype:'datetimefield',
				format:'Y-m-d H:i:s',
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
				maxLength:20,
				width:320
			},
			{
				fieldLabel:'清单下发时间',
				xtype:'datetimefield',
				format:'Y-m-d H:i:s',
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
			},
			{
				fieldLabel:'制作人ID',
				xtype:'textfield',
				name:'make_user_id',
				hidden:true,
				maxLength:32,
				anchor:'20%'
			},
			{
				fieldLabel:'状态',
				xtype:'textfield',
				name:'status',
				hidden:true,
				maxLength:32,
				anchor:'20%'
			}
			]
		}
	]
	});
	
	zxOutApplyFormEdit = Ext.create('Ext.FormPanel',{
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
			zxProjectFormEditFieldSet,
			zxOutApplyFormEditFieldSet
		]
	});
}

function callFnUpdate(form, action){
	var zxProject = action.result.data.project;
	Ext.getCmp('project_name').setValue(zxProject.name);
	Ext.getCmp('project_num').setValue(zxProject.num);
}