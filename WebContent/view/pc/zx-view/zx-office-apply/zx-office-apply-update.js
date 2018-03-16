var zxOfficeApplyWinEdit;
var zxOfficeApplyFormEdit;
var zxProjectFormupdateFieldSet;
var zxProjectFormupdateFieldSet2;
function updateZxOfficeApply(){
	var record = grid.getSelectionModel().selected;
	
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	if(record.items[0].data.status != 0){
		msgTishi('只有待申请状态可以修改！');
		return;
	}
	initZxOfficeApplyFormEdit();
	zxOfficeApplyWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:500,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'编辑信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOfficeApplyFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOfficeApplyFormEdit,'../zxOfficeApplyController/updateZxOfficeApply',grid,zxOfficeApplyWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOfficeApplyWinEdit.show();
	
	loadFormData(zxOfficeApplyFormEdit,'../zxOfficeApplyController/getZxOfficeApplyById?id='+ record.items[0].data.id);
}
function initZxOfficeApplyFormEdit(){
	zxProjectFormupdateFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'编辑用品',
		items:[
       {
			layout:"column",
		items:[
		       {
						fieldLabel:'名称',
						xtype:'textfield',
						trigger1Cls:'x-form-ss-trigger',
						onTrigger1Click:function(){selectMaterial();},
						name:'office_name',
						allowBlank:true,
						id:'office_name',
						maxLength:100,
						width:320
					},
					{
						fieldLabel:'id',
						xtype:'textfield',
						name:'id',
						id:'id',
						hidden:true,
						maxLength:100,
						width:320
					},
					{
						fieldLabel:'编号',
						xtype:'textfield',
						name:'office_num',
						allowBlank:true,
						hidden:true,
						id:'office_num',
						maxLength:100,
						width:320
					},
					{
						fieldLabel:'用户id',
						xtype:'textfield',
						name:'user_id',
						allowBlank:true,
						id:'user_id',
						hidden:true,
						maxLength:100,
						width:320
					},
					{
						fieldLabel:'规格型号',
						xtype:'textfield',
						name:'standard',
						allowBlank:true,
						hidden:true,
						id:'standard',
						maxLength:100,
						width:320
					},
					{
						fieldLabel:'office_id',
						xtype:'textfield',
						name:'office_id',
						id:'office_id',
						allowBlank:true,
						hidden:true,
						maxLength:100,
						width:320
					},
					{
						fieldLabel:'用品id',
						xtype:'textfield',
						hidden:true,
						allowBlank:true,
						name:'office_id',
						maxLength:32,
						anchor:'100%'
					},
					 {
						fieldLabel:'申请数量',
						xtype:'numberfield',
						value:'1',
						name:'amount',
						maxLength:10,
						width:320
					   },
					 {
				           fieldLabel:'备&emsp;&emsp;注',
				           allowBlank:false,
				           xtype:'textareafield',
				           name:'reason',
				           maxLength:5000,
				           width:500
			               }
			]
		}
	]
	});
	zxOfficeApplyFormEdit = Ext.create('Ext.FormPanel',{
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
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
                  zxProjectFormupdateFieldSet
		]
	});
}
