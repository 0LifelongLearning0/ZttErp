var zxOrderOutWinEdit;
var zxOrderOutFormEdit;
var zxOrderOutFormEditFieldSet;
var zxOrderOutUserFormEditFieldSet;
var zxOrderOutSuppierFormEditFieldSet;
function updateZxOrderOut(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxOrderOutFormEdit();
	zxOrderOutWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:825,
		height:510,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'维护订单',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOrderOutFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOrderOutFormEdit,'../zxOrderOutController/updateZxOrderOut',grid,zxOrderOutWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOrderOutWinEdit.show();
	loadFormDataCallBack(zxOrderOutFormEdit,'../zxOrderOutController/getZxOrderOutById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxOrderOutFormEdit(){
	zxOrderOutFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'订单信息',
		items:[
       {
			layout:"column",
			items:[
				{
					fieldLabel:'订单编号',
					xtype:'textfield',
					name:'order_num',
					id:'order_num',
					allowBlank: false,
					maxLength:255,
					width:380
				},
				{
					fieldLabel:'订单标题',
					xtype:'textfield',
					name:'order_name',
					id:'order_name',
					allowBlank: false,
					maxLength:100,
					width:380
				}
			]
		},
		{
			layout:"column",
			items:[
				{
					fieldLabel:'订单描述',
					xtype:'textareafield',
					name:'description',
					id:'description',
					maxLength:255,
					width:765
				}
			]
		}
	]
	});
	zxOrderOutUserFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'采购信息',
		items:[
       {
			layout:"column",
			items:[
				{
					fieldLabel:'采购人',
					xtype:'textfield',
					trigger1Cls:'x-form-userselect-trigger',
					onTrigger1Click:function(){initassignee("buy_user_id","buy_user_name")},
					name:'buy_user_name',
					id:'buy_user_name',
					allowBlank: false,
					maxLength:255,
					width:380
				},
				{
					fieldLabel:'采购日期',
					xtype:'datefield',
					format:'Y-m-d',
					allowBlank: false,
					name:'buy_time',
					id:'buy_time',
					maxLength:20,
					width:380
				},
				{
					fieldLabel:'采购人ID',
					xtype:'textfield',
					name:'buy_user_id',
					id:'buy_user_id',
					hidden:true,
					maxLength:32
				}
			]
		}
       ]
	});
	zxOrderOutSuppierFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'加工单位信息',
		items:[
       {
			layout:"column",
			items:[
				{
					fieldLabel:'加工单位',
					xtype:'textfield',
					trigger1Cls:'x-form-userselect-trigger',
					onTrigger1Click:function(){initSupplier("suppier_id","supplier_name")},
					name:'supplier_name',
					id:'supplier_name',
					allowBlank: false,
					maxLength:255,
					width:380
				},
				{
					fieldLabel:'承诺到货日期',
					xtype:'datefield',
					format:'Y-m-d',
					allowBlank: false,
					name:'agree_time',
					id:'agree_time',
					maxLength:20,
					width:380
				},
				{
					fieldLabel:'加工单位ID',
					xtype:'textfield',
					name:'suppier_id',
					id:'suppier_id',
					hidden:true,
					maxLength:32
				},
				{
					fieldLabel:'标识ID',
					xtype:'textfield',
					name:'id',
					id:'id',
					hidden:true,
					maxLength:32
				}
			]
		}
       ]
	});
	
	zxOrderOutFormEdit = Ext.create('Ext.FormPanel',{
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
			margin:'2 0 4 5'
		},
		items:[
			zxOrderOutFormEditFieldSet,
			zxOrderOutUserFormEditFieldSet,
			zxOrderOutSuppierFormEditFieldSet
		]
	});
}

function callFnUpdate(form, action){
	var buyUser = action.result.data.buyUser;
	var supplier = action.result.data.supplier;
	Ext.getCmp('buy_user_name').setValue(buyUser.xt_userinfo_realName);
	Ext.getCmp('supplier_name').setValue(supplier.name);
}