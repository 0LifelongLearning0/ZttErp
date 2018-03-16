var zxApplyPhoneCardWinAdd;
var zxApplyPhoneCardFormAdd;
function addZxApplyPhoneCard(){
	initZxApplyPhoneCardFormAdd();
	zxApplyPhoneCardWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:450,
		height:250,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxApplyPhoneCardFormAdd,
		buttons:[{
			text:'申请',
			itemId:'save',
			handler:function(button){
				var apply_user_id = Ext.getCmp('apply_user_id').getValue();
				$.ajax({  
			        type : "post",  
			        url : "../zxApplyPhoneCardController/getZxApplyPhoneCardByUserId?apply_user_id="+apply_user_id,  
			        async : false,  
			        success : function(data){
			        	data = eval("(" + data + ")");  
			            var list = data.items;
			            if(list.length==0){
			            	submitForm(zxApplyPhoneCardFormAdd,'../zxApplyPhoneCardController/addZxApplyPhoneCard',grid,zxApplyPhoneCardWinAdd,false,true);
			            }else{
			            	msgTishi('你已有集团短号或者正在申请中，所以不能再申请');
			        		return;
			            }
			        }
			    });
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxApplyPhoneCardWinAdd.show();
	Ext.getCmp('apply_user_id').setValue(xt_userinfo_id);
	Ext.getCmp('appler_user_name').setValue(sys_pt_user_name);
	Ext.getCmp('zxcardepart').setValue(sys_pt_departinfo_name);
}
function initZxApplyPhoneCardFormAdd(){
	zxApplyPhoneCardFormAdd = Ext.create('Ext.FormPanel',{
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
		layout:'column',
		items:[
		{
			fieldLabel:'申请人',
			xtype:'textfield',
			name:'apply_user_id',
			id:'apply_user_id',
			hidden:true,
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'申&nbsp;&nbsp;请&nbsp;&nbsp;人',
			xtype:'textfield',
			id :'appler_user_name',
			maxLength:32,
			width:200
		},
		{
			fieldLabel:'部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门',
			xtype:'textfield',
			id :'zxcardepart',
			maxLength:32,
			width:200
		},
		{
			fieldLabel:'申请时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			hidden:true,
			name:'apply_time',
			editable:false,
			maxLength:19,
			width:200
		},
		{
			fieldLabel:'申请状态',
			xtype:"combo",
			queryMode:'local', 
			hidden:true,
			store:zx_apply_phone_card_status,
			triggerAction:"all",
			editable:false,
			emptyText:'请选择',
			valueField:"xt_data_dictionary_value",
			displayField:"xt_data_dictionary_name",
			name:'status',
			maxLength:32,
			width:410
		},
		{
			fieldLabel:'申请描述',
			xtype:'textareafield',
			name:'description',
			maxLength:255,
			width:410
		}
		]
	});
}
