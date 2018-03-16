var zxApplyPhoneCardWinEdit;
var zxApplyPhoneCardFormEdit;
function updateZxApplyPhoneCard(id){
	initZxApplyPhoneCardFormEdit();
	zxApplyPhoneCardWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:400,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'发放电话卡',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxApplyPhoneCardFormEdit,
		buttons:[{
			text:'发放',
			itemId:'save',
			handler:function(button){
				submitForm(zxApplyPhoneCardFormEdit,'../zxApplyPhoneCardController/updateZxApplyPhoneCardBySelective',null,zxApplyPhoneCardWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxApplyPhoneCardWinEdit.show();
	loadFormDataCallBack(zxApplyPhoneCardFormEdit,'../zxApplyPhoneCardController/getZxApplyPhoneCardById?id='+ id,callFnDetail);
}
function initZxApplyPhoneCardFormEdit(){
	ZxApplyPhoneCardFormDetailGrant = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'申请人信息',
		items:[
        {
			layout:"column",
			items:[
				{
					fieldLabel:'申请电话卡编号',
					xtype:'textfield',
					hidden:true,
					name:'id',
					allowBlank:false,
					maxLength:32,
					anchor:'100%'
				},
				{
					fieldLabel:'申请人',
					xtype:'textfield',
					hidden:true,
					name:'apply_user_id',
					maxLength:32,
					anchor:'100%'
				},
				{
					fieldLabel:'申&nbsp;&nbsp;请&nbsp;&nbsp;人',
					xtype:'textfield',
					readOnly:true,
					id :'apply_user_name',
					maxLength:32,
					width:350
				},
				{
					fieldLabel:'部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门',
					xtype:'textfield',
					readOnly:true,
					id :'zxcardepart',
					maxLength:32,
					width:350
				},
				{
					fieldLabel:'申请时间',
					xtype:'datetimefield',
					format:'Y-m-d H:i:s',
					readOnly:true,
					name:'apply_time',
					id:'apply_time',
					maxLength:19,
					width:350
				},
				{
					fieldLabel:'申请状态',
					xtype:'combo',
					name:'status',
					id:'status',
					valueField:"xt_data_dictionary_value",
				    displayField:"xt_data_dictionary_name",
					store:zx_apply_phone_card_status,
					readOnly:true,
					maxLength:32,
					width:350
				},
				{
					fieldLabel:'申请描述',
					xtype:'textfield',
					name:'description',
					readOnly:true,
					id:'description',
					maxLength:255,
					width:710
				}
			]
		}
	]
	});
	ZxApplyPhoneCardGrant = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'电话卡号',
		items:[
        {
			layout:"column",
			items:[
				{
					fieldLabel:'集团短号',
					xtype:'textfield',
					hideTrigger:true,
					allowblank:false,
					id:'phone_card',
					name:'phone_card',
					maxLength:32,
					width:320,
					listeners:{                 
						change:function(){  
							var zz= /^[1][3,4,5,7,8][0-9]{9}$/;
			        		var phone_card = Ext.getCmp("phone_card").getValue();
			        		if(zz.test(phone_card)){
			        			 Ext.getCmp("remind").hide();
			        		}else{
			        			Ext.getCmp("remind").show();
			        		}
			            }               
			        }
				},
				{
					xtype : 'displayfield',
					id:'remind',
					hidden:true,
					value :'<font color="red">请输入正确的手机号</font>'
				}
			]
		}
	]
	});
	zxApplyPhoneCardFormEdit = Ext.create('Ext.FormPanel',{
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
			ZxApplyPhoneCardFormDetailGrant,
			ZxApplyPhoneCardGrant  
		]
	});
}
function callFnDetail(form, action){
	var zxApplyPhoneCard = action.result.data;
	var phoneApply = action.result.data.phoneApply;
	if(null != phoneApply){
		Ext.getCmp('apply_user_name').setValue(phoneApply.xt_userinfo_realName);
		Ext.getCmp('zxcardepart').setValue(phoneApply.xt_departinfo_name);
	}
	if(null != zxApplyPhoneCard){
		Ext.getCmp('apply_time').setValue(zxApplyPhoneCard.apply_time);
		Ext.getCmp('status').setValue(zxApplyPhoneCard.status);
		Ext.getCmp('description').setValue(zxApplyPhoneCard.description);
	}
}