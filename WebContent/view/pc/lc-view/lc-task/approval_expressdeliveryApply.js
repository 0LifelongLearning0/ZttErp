var taskForm;
var approvalFieldSet;
var taskFieldSet;
var zx_expressdelivery_type;
Ext.onReady(function(){
	//快递类型下拉框数据
	zx_expressdelivery_type = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_expressdelivery_type',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	initTaskForm();
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:taskForm
	});
	Ext.getCmp('task_id').setValue($("#taskId").val());
	Ext.getCmp('task_name').setValue($("#taskName").val());
	Ext.getCmp('task_type').setValue($("#taskType").val());
	loadFormDataCallBack(taskForm,'../zxExpressdeliveryController/getZxExpressdeliveryById?id='+ $("#expressdeliveryApplyId").val(),callFnUpdate);
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
				fieldLabel:'公司名称',
				xtype:'textfield',
				name:'company',
				maxLength:255,
				readOnly:true,
				width:980
			}
			]
		},
		{
			layout:"column",
			items:[
			{
				fieldLabel:'地址',
				xtype:'textfield',
				name:'address',
				maxLength:255,
				readOnly:true,
				width:980
			}
			]
		},
		{
			layout:"column",
			items:[
			{
				fieldLabel:'收件人',
				xtype:'textfield',
				name:'addressee',
				maxLength:255,
				readOnly:true,
				width:485
			},
			{
				fieldLabel:'收件人电话',
				xtype:'textfield',
				name:'addressee_concat',
				maxLength:255,
				readOnly:true,
				width:485
			}
			]
		},
		{
			layout:"column",
			items:[
			{
				fieldLabel:'所寄物品',
				xtype:'textfield',
				name:'goods',
				maxLength:255,
				readOnly:true,
				width:980
			}
			]
		},
		{
			layout:"column",
			items:[
			{
				fieldLabel:'快递类型',
				xtype:"combo",
				queryMode:'local', 
				store:zx_expressdelivery_type,
				triggerAction:"all",
	            valueField:"xt_data_dictionary_value",
	            displayField:"xt_data_dictionary_name",
				name:'type',
				readOnly:true,
				maxLength:32,
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
	var applyUser = action.result.data.applyUser;
	if(null != applyUser){
		Ext.getCmp('apply_user_name').setValue(applyUser.xt_userinfo_realName);
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
			var params = {task_id:Ext.getCmp('task_id').getValue(),task_status:status,remark:Ext.getCmp('approval_remark').getValue()};
			ajaxRequestCallFn('../zxExpressdeliveryController/approval',null,params,"审批中，请稍等....",callFnSubmit);
		});
	}else { 
		msgTishi('请输入必填项');
	}
}
