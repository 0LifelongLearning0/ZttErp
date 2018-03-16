var zxJudgeApplyWinCheck;
var zxJudgeApplyFormCheck;
var taskForm;
var approvalFieldSet;
var taskFieldSet;
var zxField3;
Ext.onReady(function(){
	Ext.getCmp('task_id').setValue($("#taskId").val());
	Ext.getCmp('task_name').setValue($("#taskName").val());
	Ext.getCmp('task_type').setValue($("#taskType").val());
});
function checkZxJudgeApply(){
	initzxJudgeApplyFormCheck();
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:taskForm
	});
	
	loadFormData(taskForm,'../zxJudgeAgainResultController/getZxJudgeAgainResultTaskById?id='+ $("#resultId").val());
}
function initzxJudgeApplyFormCheck(){
	var backUserField = new Array();
	$.ajax({ 
       type: "post", 
       url: "../zxJudgeResultController/getUserList?type=2&result_id=" + $("#resultId").val(), 
       cache:false, 
       async:false, 
       success: function(result){ 
    	   var rs = eval('('+ result +')');
    	   var data = rs.list;
	   	   for(var i = 0;i < data.length;i++){
	   		   var label = { 'boxLabel': data[i].user_name, 'name': 'back_user_ids', 'inputValue': data[i].user_id };
	   		   backUserField.push(label);
	   	   }
       }
	});
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
					fieldLabel:'供应商',
					xtype:'textfield',
					id:'supplier_name',
					readOnly:true
				},
				{
					fieldLabel:'评审日期',
					xtype:'textfield',
					name:'judge_date',
					maxLength:19,
					editable:false,
					anchor:'100%'
				}
			]
		},
		{
			layout:"column",
			items:[
					{
						fieldLabel:'总分',
						xtype:'textfield',
						id:'score',
						readOnly:true,
						anchor:'100%'
					},
					{
						fieldLabel:'评定结果',
						xtype:'textfield',
						id:'grade',
						readOnly:true,
						anchor:'100%'
					}
			]
		},
		{
			layout:"column",
			items:[
					{
						fieldLabel:'驳回人员',
						id: 'back_username',
						name: 'back_username',
			            xtype:'checkboxgroup',
	                    layout:'auto',
	                    defaults:{
	                        cls:'inline_checkbox'
	                    },
			            items:backUserField
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
	var user_ids = '';
	if(status == '4'){
		var back_users = Ext.getCmp('back_username').getChecked();
		Ext.Array.each(back_users, function(item){
			user_ids += item.inputValue + ',';
		});
		if(user_ids == ''){
			msgTishi("请选择驳回人员！");
	        return false;
		}
	}
	var params = {task_id:Ext.getCmp('task_id').getValue(),status:status,remark:Ext.getCmp('remark').getValue(),result_id:$("#resultId").val(),'user_ids':user_ids};
	$.post("../zxJudgeAgainResultController/checkAgainResult",params,function(data){
		if(data=='5'){
    		msgTishi("操作成功");
    	}else if(data=='0'){
    		msgTishi("操作失败");
    	}else if(data=='3'){
    		msgTishi("操作失败:审核通过，不能再次审核！");
    	}else if(data=='4'){
    		msgTishi("操作失败:审核退回，不能再次审核！");
    	}else if(data=='1'){
    		msgTishi("操作失败:填写中，不能再次审核！");
    	}
		var approvalFormWin = parent.Ext.getCmp('approvalFormWin');  
		approvalFormWin.close();
	});
}
$(document).ready(function(){ 
	checkZxJudgeApply();
}); 
