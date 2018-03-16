var zxOrderBuyMaterialWinEdit;
var zxOrderBuyMaterialFormEdit;
function updateZxOrderBuyMaterial(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxOrderBuyMaterialFormEdit();
	zxOrderBuyMaterialWinEdit = Ext.create('Ext.Window',{
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
		items:zxOrderBuyMaterialFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOrderBuyMaterialFormEdit,'../zxOrderBuyMaterialController/updateZxOrderBuyMaterial',grid,zxOrderBuyMaterialWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOrderBuyMaterialWinEdit.show();
	
	loadFormData(zxOrderBuyMaterialFormEdit,'../zxOrderBuyMaterialController/getZxOrderBuyMaterialById?id='+ record.items[0].data.id);
}
function initZxOrderBuyMaterialFormEdit(){
	zxOrderBuyMaterialFormEdit = Ext.create('Ext.FormPanel',{
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
			anchor:'100%'
		},
		{
			fieldLabel:'申请单物料标识',
			xtype:'textfield',
			name:'apply_material_id',
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'物料标识',
			xtype:'textfield',
			name:'material_id',
			maxLength:32,
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
