var taskForm;
var approvalFieldSet;
var taskFieldSet;
var zx_car_apply_type;
Ext.onReady(function(){
	//类型下拉框数据
	zx_car_apply_type = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_car_apply_type',
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
	loadFormDataCallBack(taskForm,'../zxCarApplyController/getZxCarApplyById?id='+ $("#carApplyId").val(),callFnUpdate);
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
			}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'申请人',
					xtype:'textfield',
					id:'apply_user_name',
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'部门',
					xtype:'textfield',
					name:'zxcardepart',
					id:'zxcardepart',
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'申请类型',
					xtype:"combo",
					queryMode:'local', 
					store:zx_car_apply_type,
					triggerAction:"all",
		            editable:false,
		            emptyText:'请选择',
		            valueField:"xt_data_dictionary_value",
		            displayField:"xt_data_dictionary_name",
					name:'apply_type',
					readOnly:true,
					width:320
				}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'用车时间始',
					xtype:'datetimefield',
					format:'Y-m-d H:i:s',
					name:'apply_time_begin',
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'用车时间末',
					xtype:'datetimefield',
					format:'Y-m-d H:i:s',
					name:'apply_time_end',
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'用车事由',
					xtype:'textfield',
					name:'user_car_reason',
					readOnly:true,
					width:320
				}
			]
		},{
			layout:"column",
			items:[
				{
					fieldLabel:'目的地',
					xtype:'textfield',
					name:'apply_car_address',
					allowBlank:false,
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'外出人员',
					xtype:'textfield',
					name:'user_car_person',
					allowBlank:false,
					maxLength:255,
					width:650,
					anchor:'100%'
				}
			]
		},{
			fieldLabel:'携带物品',
			xtype:'textareafield',
			name:'comment',
			maxLength:255,
			width:980
		}
	]
	});
	
	approvalFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'审批信息',
		items:[
		{
			layout:"column",
			items:[
				{
					fieldLabel:'车牌号',
					xtype:'textfield',
					name:'car_id',
					hidden:true,
					id:'car_id',
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'车牌号',
					xtype:'textfield',
					trigger1Cls:'x-form-ss-trigger',
					onTrigger1Click:function(){initCarInfo('car_id','car_num','people_num')},
					id:'car_num',
					allowBlank:false,
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'可乘坐人数',
					xtype:'textfield',
					id:'people_num',
					allowBlank:false,
					readOnly:true,
					maxLength:255,
					width:320
				}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'司机',
					xtype:'textfield',
					name:'driver_id',
					hidden:true,
					id:'driver_id',
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'司机',
					xtype:'textfield',
					trigger1Cls:'x-form-userselect-trigger',
					onTrigger1Click:function(){initassignee('driver_id','driver_name')},
					id:'driver_name',
					allowBlank:false,
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'司机驾龄',
					xtype:'textfield',
					name:'driver_age',
					id:'driver_age',
					allowBlank:false,
					maxLength:255,
					width:320
				}
			]
		},
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
	reGetWidthAndHeight();
	taskForm = Ext.create('Ext.FormPanel',{
		xtype:'form',
		width:1050,
		height:clientHeight,
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
	var applyCar = action.result.data.applyCar;
	var applyUser = action.result.data.applyUser;
	if(null != applyUser){
		Ext.getCmp('apply_user_name').setValue(applyUser.xt_userinfo_realName);
		Ext.getCmp('zxcardepart').setValue(applyUser.xt_departinfo_name);
	}
	var driverUser = action.result.data.applyDriver;
	if(null != driverUser){
		Ext.getCmp('driver_name').setValue(driverUser.xt_userinfo_realName);
	}
	Ext.getCmp('car_num').setValue(applyCar.car_no);
	Ext.getCmp('people_num').setValue(applyCar.people_num);
}

function callFnSubmit(form, action){
	var approvalFormWin = parent.Ext.getCmp('approvalFormWin');  
	approvalFormWin.close();
	var grid = parent.Ext.getCmp('grid');  
	grids.getStore().reload();
}

function approvalSubmit(status){
	var s = false;
	if(status == 'yes'){
		if(taskForm.form.isValid()){   
			s = true;
		}else{ 
			msgTishi('请输入必填项');
		}
	}
	if(s){
		top.Ext.Msg.confirm('提示','确定要提交当前表单信息内容？',function(btn){
			var params = {task_status:status};
			params.task_id = Ext.getCmp('task_id').getValue();
			params.remark = Ext.getCmp('remark').getValue();
			params.car_id = Ext.getCmp('car_id').getValue();
			params.driver_id = Ext.getCmp('driver_id').getValue();
			params.driver_age = Ext.getCmp('driver_age').getValue();
			ajaxRequestCallFn('../zxCarApplyController/approvalSafe',null,params,"审批中，请稍等....",callFnSubmit);
		});
	}
}