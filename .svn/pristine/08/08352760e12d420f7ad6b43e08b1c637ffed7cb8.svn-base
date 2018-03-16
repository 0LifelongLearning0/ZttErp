var taskForm;
var approvalFieldSet;
var taskFieldSet;
Ext.onReady(function(){
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
	
	loadFormDataCallBack(taskForm,'../zxGoodsApplyController/getZxUserById?apply_id='+ $("#loanApplyId").val(),callFnUpdate);
	loadFormDataCallBack(taskForm,'../zxGoodsApplyController/getZxGoodsApplyById?apply_id='+ $("#loanApplyId").val(),callFnDetail);
});
function initTaskForm(){
	zxGoodsApplyFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
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
			fieldLabel:'申请人id',
			xtype:'textfield',
			id:'user_id',
			hidden:true,
			name:'user_id',
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'申请人',
			xtype:'textfield',
			id:'user_name',
			name:'user_name',
			maxLength:32,
			anchor:'100%'
		},
		{
					fieldLabel:'部门',
					xtype:'textfield',
					name:'user_depart',
					id:'user_depart',
					maxLength:255,
					anchor:'100%',
					readOnly:true
				}
		]},
		{
			fieldLabel:'标题',
			xtype:'textfield',
			name:'reason',
			maxLength:255,
			anchor:'100%'
		},
		{
			xtype:'numberfield',
			hidden:true,
			value:'0',
			itemId:'zxGoodsApplyDetailFormNumber'
		},
		{
			xtype:'textfield',
			hidden:true,
			name:'zxGoodsApplyDetail_removed_flag',
			itemId:'zxGoodsApplyDetail_removed_flag'
		}
	]
	});
	zxGoodsApplyDetailFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'用品申领详细表',
		items:[]
	});
	
	approvalFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		items:[{
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
		    zxGoodsApplyFormDetailFieldSet,
		    zxGoodsApplyDetailFormDetailFieldSet,
		    approvalFieldSet
		]
	});
}

function callFnUpdate(form, action){
	var borrower = action.result.data;
	if(null != borrower){
		Ext.getCmp('user_name').setValue(borrower.user_name);
		Ext.getCmp('user_depart').setValue(borrower.department);
	}
}
function callFnDetail(form, action){
	var zxGoodsApplyDetail = action.result.data.zxGoodsApplyDetail;
	for(var i = 0; i < zxGoodsApplyDetail.length; i++){
		addDetailZxGoodsApplyDetailFormDetail(zxGoodsApplyDetail[i]);
	}
}

function addDetailZxGoodsApplyDetailFormDetail(data){
	var numbers = gfiValue(zxGoodsApplyFormDetailFieldSet,'zxGoodsApplyDetailFormNumber');
	sfiValue(zxGoodsApplyFormDetailFieldSet,'zxGoodsApplyDetailFormNumber',numbers+1);
	console.log(numbers);
	zxGoodsApplyDetailFormDetail = Ext.create('Ext.FormPanel',{
		xtype:'form',
		autoScroll:true,
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			readOnly:true,
			margin:'2 5 4 5'
		},
		items:[
		{
		layout:"column",
		itemId:'zxGoodsApplyDetail['+numbers+'].items',
		items:[
		{
			fieldLabel:'用品id',
			xtype:'textfield',
			name:'zxGoodsApplyDetail['+numbers+'].goods_id',
			itemId:'zxGoodsApplyDetail['+numbers+'].goods_id',
			hidden:true,
			maxLength:32,
			anchor:'100%'
		},
		   {
			fieldLabel:'用品',
			xtype:'textfield',
			name:'zxGoodsApplyDetail['+numbers+'].office_name',
			itemId:'zxGoodsApplyDetail['+numbers+'].office_name',
			trigger1Cls:'x-form-ss-trigger',
			onTrigger1Click:function(){selectMaterial(numbers);},
			width:250
		   },
		   {
			fieldLabel:'补充数量',
			name:'zxGoodsApplyDetail['+numbers+'].amount',
			itemId:'zxGoodsApplyDetail['+numbers+'].amount',
			value:'1',
			xtype:'numberfield',
			minValue:0,
			maxValue:1000000,
			width:200
		   },
		   {
			fieldLabel:'用途',
			xtype:'textfield',
			name:'zxGoodsApplyDetail['+numbers+'].reason',
			itemId:'zxGoodsApplyDetail['+numbers+'].reason',
			width:520

		}
		]}
		
	
		
		]
	});
	zxGoodsApplyDetailFormDetailFieldSet.add(zxGoodsApplyDetailFormDetailFieldSet.items.getCount(),zxGoodsApplyDetailFormDetail);
	if(null != data){
		//获取表单中所有字段与值（key/value）
		var zxGoodsApplyDetailFormDetailData = zxGoodsApplyDetailFormDetail.getForm().getFieldValues();
		var zxGoodsApplyDetailFormDetailFieldItem;
		for(var zxGoodsApplyDetailFormDetailField in zxGoodsApplyDetailFormDetailData){
			zxGoodsApplyDetailFormDetailFieldItem=zxGoodsApplyDetailFormDetailField.split(".")[0]+".items";
		}
		//遍历表单中所有字段名称（key）
		for(var zxGoodsApplyDetailFormDetailField in zxGoodsApplyDetailFormDetailData){
			//获取表单中所有字段名称（key）并且截取对象后面的字段 目的与实体类中字段名称一致
			var zxGoodsApplyDetailFormDetailYField = zxGoodsApplyDetailFormDetailField.split(".")[1];
			//遍历服务器传递来的对象
			for(var dataKey in data){
				//判断当前字段是否等于服务器传过来的字段
				if(zxGoodsApplyDetailFormDetailYField == dataKey){
					//给表单每个字段赋值
					sfiValuegoods(zxGoodsApplyDetailFormDetail,zxGoodsApplyDetailFormDetailFieldItem,zxGoodsApplyDetailFormDetailField,data[dataKey]);
				}
			}
		}
	}
	zxGoodsApplyDetailFormDetailFieldSet.afterLayout();
	resetTitle(zxGoodsApplyDetailFormDetailFieldSet,true);
	
}

//赋值form元素对象(条件根据form和itemId)
function sfiValuegoods(form,itemIdItem,itemId,val){
	form.getComponent(itemIdItem).getComponent(itemId).setValue(val);
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
			var params = {task_id:Ext.getCmp('task_id').getValue(),task_status:status};
			ajaxRequestCallFn('../zxGoodsApplyController/approvalOfficeApply',null,params,"审批中，请稍等....",callFnSubmit);
		});
	}else { 
		msgTishi('请输入必填项');
	}
}
