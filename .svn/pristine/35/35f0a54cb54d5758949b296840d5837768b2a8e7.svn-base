var taskForm;
var approvalFieldSet;
var taskFieldSet;
var commAble = 1;
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
	loadFormData(taskForm,'../zxJudgeResultController/getZxJudgeResultTaskById?id='+ $("#resultId").val());
}
function initzxJudgeApplyFormCheck(){
	var backUserField = new Array();
	$.ajax({ 
       type: "post", 
       url: "../zxJudgeResultController/getUserList?type=1&result_id=" + $("#resultId").val(), 
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
    var score_rule = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["0","无程序无执行"],["1","有程序没执行"],["2","有执行没程序"],["3","有程序有执行，但效果不明显"],["4","生产设备精度不达标"]]
	});
	taskFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'任务信息',
		id:'taskFieldSet',
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
				width:320,
				readOnly:true
			},
			{
				fieldLabel:'任务类型',
				xtype:'textfield',
				name:'task_type',
				id:'task_type',
				width:320,
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
					width:320,
					readOnly:true
				},
				{
					fieldLabel:'开始日期',
					xtype:'textfield',
					name:'judge_date_start',
					maxLength:19,
					editable:false,
					width:320,
					anchor:'100%'
				},
				{
					fieldLabel:'结束日期',
					xtype:'textfield',
					name:'judge_date_end',
					maxLength:19,
					editable:false,
					width:320,
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
						width:320,
						anchor:'100%'
					},
					{
						fieldLabel:'评定结果',
						xtype:'textfield',
						id:'grade',
						readOnly:true,
						width:320,
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
		},
		{
			layout:"column",
			items:[
			       {
			            xtype : "radiogroup",
			            fieldLabel : "是否重新打分",
			            id : "commAble",
			            name : "dd_s",
			            items : [ 
				            {
				                boxLabel : "是",
				                name : "commAble",
				                id: "commAbleY",
				                inputValue : 1,
				                checked : true
				            }, {
				                boxLabel : "否",
				                name : "commAble",
				                inputValue : 0
				            } 
				        ],
				        listeners : {
		                    "change" : function(el, checked) {
		                    	if(commAble == 0){
		                    		commAble = 1;
		                        	Ext.getCmp('newscore').show();
		                    	}else{
		                    		commAble = 0;
		                    		Ext.getCmp('remark').setValue('');
		                        	Ext.getCmp('newscore').hide();
		                    	}
		                    }
		                }
			        }
			]
		},
		{
			layout:"column",
			id:'newscore',
			items:[
					{
						fieldLabel:'状态',
						xtype:'combo',
						emptyText:'请选择',
						store:score_rule,
						mode:'local',
						triggerAction:'all',
						editable:false,
						hiddenName:'score_rule',
						valueField:'value',
						displayField:'text',
						name:'score_rule',
						id:'score_rule',
						maxLength:50,
						width:320,
						allowBlank:false,
						anchor:'100%',
						listeners : {
		                    "change" : function() {
		                    	var val = Ext.getCmp("score_rule").getValue();
		                    	var score = Ext.getCmp("score").getValue();
		                        var t_score = 0;
		                        if(val == 1){
		                        	t_score = score * 0.3;
		                        } else if(val == 2){
		                        	t_score = score * 0.5;
		                        } else if(val == 3){
		                        	t_score = score * 0.7;
		                        }
		                        Ext.getCmp("final_score").setValue(t_score);
	                        	Ext.getCmp("final_grade").setValue(getGrade(t_score) );
	                        	Ext.getCmp('remark').setValue(Ext.getCmp("score_rule").getRawValue());
		                    }
		                }
					},
					{
						fieldLabel:'最终总分',
						xtype:'textfield',
						id:'final_score',
						readOnly:true,
						width:320,
						allowBlank:false,
						anchor:'100%'
					},
					{
						fieldLabel:'最终评定结果',
						xtype:'textfield',
						id:'final_grade',
						readOnly:true,
						width:320,
						allowBlank:false,
						anchor:'100%'
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
	var final_score = Ext.getCmp('final_score').getValue();
	if(commAble == 1&&final_score == ''){
		msgTishi("重新打分请选择否！");
		return;
	}
	var final_grade = "3";
	if(final_score >= 80.0){
		final_score = "1";
	}else if(score < 60.0){
		final_score = "3";
	}else {
		final_score = "2";
	}
	
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
	
	var params = {task_id:Ext.getCmp('task_id').getValue(),status:status,remark:Ext.getCmp('remark').getValue(),commAble:commAble,result_id:$("#resultId").val(),final_score:Ext.getCmp('final_score').getValue(),final_grade:final_grade,'user_ids':user_ids};
	$.post("../zxJudgeResultController/checkResult",params,function(data){
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
function getGrade(score){
	var grade = '';
	if(score >= 80.0){
		 grade = "合格供应商";
	 }else if(score < 60.0){
		 grade = "不合格供应商";
	 }else {
		 grade = "必须限期整改";
	 }
	return grade;
}
