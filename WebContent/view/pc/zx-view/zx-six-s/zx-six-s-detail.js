var zxSixSWinDetail;
var zxSixSFormDetail;
function detailZxSixS(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxSixSFormDetail();
	zxSixSWinDetail = Ext.create('Ext.Window',{
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
		items:zxSixSFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxSixSWinDetail.show();
	
	loadFormData(zxSixSFormDetail,'../zxSixSController/getZxSixSById?id='+ record.items[0].data.id);
}
function initZxSixSFormDetail(){
	zxSixSFormDetail = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'编号',
			xtype:'textfield',
			name:'num',
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'标题',
			xtype:'textfield',
			name:'title',
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'备注',
			xtype:'textfield',
			name:'remark',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'发布人',
			xtype:'textfield',
			name:'user_id',
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'状态：1-正常，0-删除',
			xtype:'textfield',
			name:'state',
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
