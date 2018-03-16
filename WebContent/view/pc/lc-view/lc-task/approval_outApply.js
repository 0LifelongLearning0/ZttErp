var taskForm;
var approvalFieldSet;
var taskFieldSet;
Ext.onReady(function(){
	initTaskForm();
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:taskForm
	});
	Ext.getCmp('task_id').setValue($("#taskId").val());
	Ext.getCmp('task_name').setValue($("#taskName").val());
	Ext.getCmp('task_type').setValue($("#taskType").val());
	loadFormDataCallBack(taskForm,'../zxOutApplyController/getZxOutApplyById?id='+ $("#outApplyId").val(),callFnUpdate);
});
function initTaskForm(){
	taskFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'任务信息',
		items:[
       {
			layout:"column",
			items:[
			{
				fieldLabel:'任务ID',
				xtype:'textfield',
				name:'task_id',
				id:'task_id',
				hidden:true
			},
			{
				fieldLabel:'任务名称',
				xtype:'textfield',
				name:'task_name',
				id:'task_name',
				maxLength:100,
				readOnly:true,
				width:320
			},
			{
				fieldLabel:'任务类型',
				xtype:'textfield',
				name:'task_type',
				id:'task_type',
				readOnly:true,
				width:320
			},
			{
				fieldLabel:'申请人',
				xtype:'textfield',
				id:'apply_user_name',
				readOnly:true,
				width:320
			}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'项目案号',
					xtype:'textfield',
					name:'project_num',
					id:'project_num',
					readOnly:true,
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
				},
				{
					xtype:'button',
					text:'工件清单',
					style:'float:left;margin:0px 0px 0px 110px;width:215px;',
					labelAlign:"center", 
					listeners:{
						click:function(){
							showZxOutApplyWorkpiece($("#outApplyId").val());
						}
					}
				}
			]
		},
		{
			layout:"column",
			items:[
			{
				fieldLabel:'申请编号',
				xtype:'textfield',
				name:'apply_num',
				readOnly:true,
				maxLength:100,
				width:320
			},
			{
				fieldLabel:'图&emsp;&emsp;号',
				xtype:'textfield',
				name:'draw_num',
				readOnly:true,
				maxLength:100,
				width:320
			},
			{
				fieldLabel:'制作台数',
				xtype:'textfield',
				name:'make_num',
				readOnly:true,
				maxLength:20,
				width:320
			}
			]
		},       
		{
			layout:"column",
			items:[
			{
				fieldLabel:'申购时间',
				xtype:'datetimefield',
				name:'apply_time',
				format:'Y-m-d H:i:s',
				readOnly:true,
				maxLength:19,
				width:320
			},
			{
				fieldLabel:'需求日期',
				xtype:'datefield',
				name:'need_time',
				format:'Y-m-d',
				readOnly:true,
				maxLength:19,
				width:320
			},
			{
				fieldLabel:'清单下发时间',
				xtype:'datetimefield',
				format:'Y-m-d H:i:s',
				name:'send_draw_time',
				readOnly:true,
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
				readOnly:true,
				maxLength:65535,
				width:980
			}
			]
		}
	]
	});
	
	approvalFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'审批信息',
		items:[{
			fieldLabel:'批注',
			xtype:'textareafield',
			name:'approval_remark',
			id:'approval_remark',
			maxLength:65536,
			width:980
		},{
			fieldLabel:'审批结果',
			xtype:'textfield',
			name:'task_status',
			id:'task_status',
			hidden:true
		},{
			layout:"column",
			items:[
				{
					xtype:'button',
					text:'驳回',
					style:'float:right;margin:10px 30px 10px 0px',
					labelAlign:"right", 
					listeners:{
						click:function(){
							approvalSubmit("no");
						}
					}
				},{
					xtype:'button',
					text:'同意',
					style:'float:right;margin:10px',
					labelAlign:"right", 
					listeners:{
						click:function(){
							approvalSubmit("yes");
						}
					}
				}
			]
		}]
	});
	taskForm = Ext.create('Ext.FormPanel',{
		xtype:'form',
		width:1050,
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
		    taskFieldSet,
		    approvalFieldSet
		]
	});
}

function callFnUpdate(form, action){
	var zxProject = action.result.data.project;
	var applyUser = action.result.data.applyUser;
	if(null != applyUser){
		Ext.getCmp('apply_user_name').setValue(applyUser.xt_userinfo_realName);
	}
	Ext.getCmp('project_name').setValue(zxProject.name);
	Ext.getCmp('project_num').setValue(zxProject.num);
}

function callFnSubmit(form, action){
	var approvalFormWin = parent.Ext.getCmp('approvalFormWin');  
	approvalFormWin.close();
	var grid = parent.Ext.getCmp('grid');  
	grids.getStore().reload();
}

function approvalSubmit(status){
	if(taskForm.form.isValid()){   
		top.Ext.Msg.confirm('提示','确定要提交当前表单信息内容？',function(btn){
			var params = {task_id:Ext.getCmp('task_id').getValue(),task_status:status,remark:Ext.getCmp('approval_remark').getValue()};
			ajaxRequestCallFn('../zxOutApplyController/approval',null,params,"审批中，请稍等....",callFnSubmit);
		});
	}else { 
		msgTishi('请输入必填项');
	}
}

var zxOutApplyWorkpieceWin;
function showZxOutApplyWorkpiece(apply_id){
	reGetWidthAndHeight();
	zxOutApplyWorkpieceWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*1.1,                    
		height:clientHeight*1.1, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'工件清单列表',
		html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="../zxOutApplyWorkpieceController/loadZxOutApplyWorkpiece?apply_id='+apply_id+'"></iframe>',
		listeners:{
			minimize:function(win,opts){
				win.collapse();
			},
			close:function(){
				store.load();
			}
		}
	});
	zxOutApplyWorkpieceWin.show();
}