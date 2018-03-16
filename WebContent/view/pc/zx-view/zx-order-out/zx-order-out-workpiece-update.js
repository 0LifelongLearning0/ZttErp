var zxOrderOutWorkpieceWinEdit;
var zxOrderOutWorkpieceFormEdit;
function updateZxOrderOutWorkpiece(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxOrderOutWorkpieceFormEdit();
	zxOrderOutWorkpieceWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:400,
		maximizable:true,
		minimizable:true,
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
		items:zxOrderOutWorkpieceFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOrderOutWorkpieceFormEdit,'../zxOrderOutWorkpieceController/updateZxOrderOutWorkpiece',grid,zxOrderOutWorkpieceWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOrderOutWorkpieceWinEdit.show();
	
	loadFormData(zxOrderOutWorkpieceFormEdit,'../zxOrderOutWorkpieceController/getZxOrderOutWorkpieceById?id='+ record.items[0].data.id);
}
function initZxOrderOutWorkpieceFormEdit(){
	zxOrderOutWorkpieceFormEdit = Ext.create('Ext.FormPanel',{
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
		{
			fieldLabel:'标识',
			xtype:'textfield',
			hidden:true,
			name:'id',
			allowBlank:false,
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'订单标识',
			xtype:'textfield',
			name:'order_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'申请单工件标识',
			xtype:'textfield',
			name:'apply_workpiece_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'工件标识',
			xtype:'textfield',
			name:'workpiece_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'承诺到货时间',
			xtype:'datefield',
			format:'Y-m-d',
			name:'agree_time',
			maxLength:10,
			anchor:'100%'
		}
		]
	});
}
