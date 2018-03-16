var zxMeetingUserWinDetail;
var zxMeetingUserFormDetail;
function detailZxMeetingUser(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxMeetingUserFormDetail();
	zxMeetingUserWinDetail = Ext.create('Ext.Window',{
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
		items:zxMeetingUserFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxMeetingUserWinDetail.show();
	
	loadFormData(zxMeetingUserFormDetail,'../zxMeetingUserController/getZxMeetingUserById?id='+ record.items[0].data.id);
}
function initZxMeetingUserFormDetail(){
	zxMeetingUserFormDetail = Ext.create('Ext.FormPanel',{
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
		items:[
		{
			fieldLabel:'ID',
			xtype:'textfield',
			hidden:true,
			name:'id',
			allowBlank:false,
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'会议ID',
			xtype:'textfield',
			name:'meeting_id',
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'参与人',
			xtype:'textfield',
			name:'user_id',
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'邀请人',
			xtype:'textfield',
			name:'invite_user_id',
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'类型:1-必到；2-邀请；',
			xtype:'textfield',
			name:'type',
			maxLength:2,
			anchor:'100%'
		},
		{
			fieldLabel:'创建日期',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'create_date',
			maxLength:19,
			anchor:'100%'
		}
		]
	});
}
