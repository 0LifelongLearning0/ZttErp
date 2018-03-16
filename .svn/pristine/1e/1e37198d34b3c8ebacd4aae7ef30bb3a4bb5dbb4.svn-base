var zxRecruitApplyWinCheck;
var zxRecruitApplyFormCheck;
var taskForm;
var approvalFieldSet;
var taskFieldSet;
Ext.onReady(function(){
	Ext.getCmp('task_id').setValue($("#taskId").val());
	Ext.getCmp('task_name').setValue($("#taskName").val());
	Ext.getCmp('task_type').setValue($("#taskType").val());
});
function checkZxRecruitApply(){
	initzxRecruitApplyFormCheck();
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:taskForm
	});
	
	loadFormData(taskForm,'../zxRecruitController/getZxRecruitById?id='+ $("#applyId").val());
}
function initzxRecruitApplyFormCheck(){
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
				readOnly:true
			},
			{
				fieldLabel:'任务类型',
				xtype:'textfield',
				name:'task_type',
				id:'task_type',
				readOnly:true
			}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'职位',
					xtype:'textfield',
					id:'job',
					readOnly:true,
					anchor:'100%'
				},
				{
					fieldLabel:'需求部门',
					xtype:'textfield',
					name:'dep_name',
					readOnly:true,
					anchor:'100%'
				},
				{
					fieldLabel:'招聘原因',
					xtype:'textfield',
					name:'employ_reason_name',
					maxLength:32,
					readOnly:true,
					anchor:'100%'
				}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'申请日期',
					xtype:'textfield',
					name:'employ_dep_date',
					readOnly:true,
					anchor:'100%'
				},
				{
					fieldLabel:'最低工资',
					xtype:'textfield',
					id:'min_pay',
					readOnly:true,
					anchor:'100%'
				},
				{
					fieldLabel:'最高工资',
					xtype:'textfield',
					name:'max_pay',
					readOnly:true,
					anchor:'100%'
				}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'职位描述',
					xtype:'textareafield',
					id:'description',
					readOnly:true,
					width:'100%'
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
							submitForm2('4');
						}
					}
				},{
					xtype:'button',
					text:'同意',
					style:'float:right;margin:10px',
					labelAlign:"right", 
					listeners:{
						click:function(){
							submitForm2('3');
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

function submitForm2(status){
	var params = {task_id:Ext.getCmp('task_id').getValue(),task_status:status,remark:Ext.getCmp('remark').getValue(),apply_id:$("#applyId").val()};
	$.post("../zxRecruitController/manegerCheckZxRecruitApply",params,function(result){
		if(result == '1'){
			msgTishi('操作成功');
		}else{
			msgTishi('操作失败');
		}
		var approvalFormWin = parent.Ext.getCmp('approvalFormWin');  
		approvalFormWin.close();
	});
}
$(document).ready(function(){ 
	checkZxRecruitApply();
}); 
