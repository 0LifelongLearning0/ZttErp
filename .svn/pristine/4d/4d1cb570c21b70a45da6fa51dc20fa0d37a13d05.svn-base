var zxApplyPhoneCardWinDetail;
var zxApplyPhoneCardFormDetail;
function detailZxApplyPhoneCard(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxApplyPhoneCardFormDetail();
	zxApplyPhoneCardWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:400,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'明细信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxApplyPhoneCardFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxApplyPhoneCardWinDetail.show();
	loadFormDataCallBack(zxApplyPhoneCardFormDetail,'../zxApplyPhoneCardController/getZxApplyPhoneCardById?id='+ record.items[0].data.id,callFnDetail);
}
function initZxApplyPhoneCardFormDetail(){
	zxApplyPhoneCardFormDetail = Ext.create('Ext.FormPanel',{
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
			readOnly:true,
			margin:'2 5 4 5'
		},
		layout:'column',
		items:[
		{
			fieldLabel:'申请电话卡编号',
			xtype:'textfield',
			hidden:true,
			name:'id',
			allowBlank:false,
			maxLength:32,
			width:350
		},
		{
			fieldLabel:'申请人',
			xtype:'textfield',
			id:'apply_user_id',
			hidden:true,
			maxLength:32,
			width:350
		},
		{
			fieldLabel:'申&nbsp;&nbsp;请&nbsp;&nbsp;人',
			xtype:'textfield',
			id:'apply_user_name',
			name:'apply_user_name',
			maxLength:32,
			width:350
		},
		{
			fieldLabel:'部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门',
			xtype:'textfield',
			id:'zxcardepart',
			maxLength:32,
			width:350
		},
		{
			fieldLabel:'申请时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'apply_time',
			maxLength:19,
			width:350
		},
		{
			fieldLabel:'申请状态',
			xtype:'combo',
			name:'status',
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
			maxLength:255,
			width:710
		}
		]
	});
}
function callFnDetail(form, action){
	var phoneApply = action.result.data.phoneApply;
	if(null != phoneApply){
		Ext.getCmp('apply_user_name').setValue(phoneApply.xt_userinfo_realName);
		Ext.getCmp('zxcardepart').setValue(phoneApply.xt_departinfo_name);
	}
}
