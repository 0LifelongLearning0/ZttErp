var taskForm;
var approvalFieldSet;
var taskFieldSet;
Ext.onReady(function(){
		zx_train_train_agreement = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","签署"],["1","不签署"]]
	});
	zx_train_cato = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","面授"],["1","函授"]]
	});
	initTaskForm();
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		xtype:'viewport',
		autoScroll:true,
		items:taskForm
	});
	Ext.getCmp('task_id').setValue($("#taskId").val());
	Ext.getCmp('task_name').setValue($("#taskName").val());
	Ext.getCmp('task_type').setValue($("#taskType").val());
	loadFormDataCallBack(taskForm,'../zxTrainApplyController/getZxTrainApplyById?id='+ $("#loanApplyId").val(),callFnUpdate);
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
				width:485
			},
			{
				fieldLabel:'任务类型',
				xtype:'textfield',
				name:'task_type',
				id:'task_type',
				readOnly:true,
				width:485
			}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'申请人',
					xtype:'textfield',
					name:'user_name',
					id:'user_name',
					readOnly:true,
					width:485
				},
				{
					fieldLabel:'部门',
					xtype:'textfield',
					name:'department_name',
					id:'department_name',
					readOnly:true,
					width:485
				}
			]
		},
		{
			layout:"column",
			items:[ {
			            xtype : "textfield",
				             fieldLabel:'培训名称',
			                 name:'train_name',
			                 maxLength:32,
			                 editable:false,
			                  anchor:'100%'
		             },{
			            fieldLabel:'培训方式',
			          xtype:'textfield',
			           editable:false,
		             	name:'status',
		               	maxLength:32,
			            anchor:'100%'
		             },{
			            fieldLabel:'培训协议',
			          xtype:'textfield',
			           editable:false,
		             	name:'train_agreement',
		               	maxLength:32,
			            anchor:'100%'
		             }]
		             },{
			layout:"column",
			items:[ {
			fieldLabel:'培训费用',
			xtype:'textfield',
			name:'train_fee',
			editable:false,
			maxLength:20,
			anchor:'100%'
		}, {
			           fieldLabel:'参加培训人数',
			                 xtype:'textfield',
			                 name:'train_num',
			                 editable:false,
			                 maxLength:10,
			                  anchor:'100%'
		             },{
			          fieldLabel:'培训地点',
			xtype:'textfield',
			name:'train_address',
			editable:false,
			maxLength:255,
			anchor:'100%'
		             }]
		             },{
			layout:"column",
			items:[  {
			           fieldLabel:'培训目的',
			           xtype:'textareafield',
			           name:'train_purpose',
			           editable:false,
			           maxLength:65536,
			width:980
		             }]
		             },{
			layout:"column",
			items:[  {
			           fieldLabel:'备&emsp;&emsp;注',
			           xtype:'textareafield',
			           name:'remark',
			           editable:false,
			           maxLength:65536,
			width:980
		             }]
		             }
		
	]
	});
	
	approvalFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'审批信息',
		items:[{
			layout:"column",
			items:[
		   {
		       layout:"column",
		       items:[
		               {
			fieldLabel:'批注',
			xtype:'textareafield',
			name:'remark',
			id:'remark',
			maxLength:65536,
			width:980
		},{
			fieldLabel:'审批结果',
			xtype:'textfield',
			name:'task_status',
			id:'task_status',
			hidden:true
		}
		              ]
	         }
				
				
			]
		},
		{
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
	var borrower = action.result.data.borrower;
	if(null != borrower){
		Ext.getCmp('user_name').setValue(borrower.xt_userinfo_realName);
		Ext.getCmp('zxcardepart').setValue(borrower.xt_departinfo_name);
	}
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
			var params = {task_id:Ext.getCmp('task_id').getValue(),task_status:status,remark:Ext.getCmp('remark').getValue()};
			ajaxRequestCallFn('../zxTrainApplyController/approvalTrainApply',null,params,"审批中，请稍等....",callFnSubmit);
		});
	}else { 
		msgTishi('请输入必填项');
	}
}
