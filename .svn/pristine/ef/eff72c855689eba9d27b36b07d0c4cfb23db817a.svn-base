var zxLoanBillWinDetail;
var zxLoanBillFormDetail;
var zxLoanBillFormDetailFieldSet;
var zxLoanBillBaseInfoFormDetailFieldSet;
function detailZxLoanBill(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxLoanBillFormDetail();
	zxLoanBillWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:780,
		height:400,
		maximizable:false,
		minimizable:false,
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
		items:zxLoanBillFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxLoanBillWinDetail.show();
	
	loadFormDataCallBack(zxLoanBillFormDetail,'../zxLoanBillController/getZxLoanBillById?id='+ record.items[0].data.id,callFnDetail);
}
function initZxLoanBillFormDetail(){
	zxLoanBillFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'借款人信息',
		items:[
        {
			layout:"column",
			items:[
				{
					fieldLabel:'借款人',
					xtype:'textfield',
					name:'user_id',
					hidden:true,
					id:'user_id',
					maxLength:32,
					width:320
				},
				{
					fieldLabel:'借款人',
					xtype:'textfield',
					id:'user_name',
					allowBlank:false,
					readOnly:true,
					maxLength:32,
					width:350
				},
				{
					fieldLabel:'部门',
					xtype:'textfield',
					name:'zxcardepart',
					id:'zxcardepart',
					maxLength:255,
					width:350,
					readOnly:true
				}
			]
		}
	]
	});
	
	zxLoanBillBaseInfoFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基础信息',
		items:[
		{
			fieldLabel:'借款理由',
			xtype:'textfield',
			name:'reason',
			id:'reason',
			maxLength:255,
			width:710,
			readOnly:true
		},
        {
			layout:"column",
			items:[
				{
					fieldLabel:'申请时间',
					xtype:'datetimefield',
					format:'Y-m-d H:i:s',
					name:'create_time',
					id:'create_time',
					allowBlank:false,
					hidden:true,
					maxLength:19,
					width:485,
					anchor:'100%'
				},
				{
					fieldLabel:'预计结算日',
					xtype:'datefield',
					format:'Y-m-d',
					name:'estimate_settle_date',
					allowBlank:false,
					maxLength:19,
					width:350,
					readOnly:true
				},
				{
					fieldLabel:'审批通过',
					xtype:'datetimefield',
					format:'Y-m-d H:i:s',
					name:'approve_time',
					allowBlank:false,
					maxLength:19,
					width:350,
					readOnly:true
				}
			]
		},{
			layout:"column",
			items:[
				{
					fieldLabel:'中文大写',
					xtype:'textfield',
					name:'balance_cn',
					allowBlank:false,
					readOnly:true,
					maxLength:100,
					width:500,
					anchor:'100%'
				},
				{
					fieldLabel:'借款金额',
					xtype:'textfield',
					name:'balance',
					readOnly:true,
					allowBlank:false,
					maxLength:20,
					width:200
				}
			]
		}
	]
	});

	zxLoanBillFormDetail = Ext.create('Ext.FormPanel',{
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
			zxLoanBillFormDetailFieldSet,
			zxLoanBillBaseInfoFormDetailFieldSet
		]
	});
}
function callFnDetail(form, action){
	var borrower = action.result.data.borrower;
	if(null != borrower){
		Ext.getCmp('user_name').setValue(borrower.xt_userinfo_realName);
		Ext.getCmp('zxcardepart').setValue(borrower.xt_departinfo_name);
	}
}