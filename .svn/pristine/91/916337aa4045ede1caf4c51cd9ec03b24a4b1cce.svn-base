var zxSupplierWinEdit;
var zxSupplierFormEdit;
function updateZxSupplier(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initFieldItems();
	reGetWidthAndHeight();
	initZxSupplierFormEdit();
	zxSupplierWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth * 0.9,                    
		height:clientHeight * 0.9,
		maximizable:true,
		minimizable:true,
		resizable : false,
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
		items:zxSupplierFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm2(zxSupplierFormEdit,'../zxSupplierController/updateZxSupplier',grid,zxSupplierWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxSupplierWinEdit.show();
	
	loadFormData(zxSupplierFormEdit,'../zxSupplierController/getZxSupplierById?id='+ record.items[0].data.id);
}
function initZxSupplierFormEdit(){
	zxSupplierFormEdit = Ext.create('Ext.FormPanel',{
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
		       zxField1,
		       zxField2,
		       zxField3,
		       zxField4,
		       { 
					fieldLabel:'yc_status',
					xtype:'textfield',
					name:'yc_status',
					hidden:true,
					maxLength:2,
					anchor:'30%'
				},
				{ 
					fieldLabel:'yc_grade',
					xtype:'textfield',
					name:'yc_grade',
					hidden:true,
					maxLength:2,
					anchor:'30%'
				},
				{ 
					fieldLabel:'is_judge',
					xtype:'textfield',
					name:'is_judge',
					hidden:true,
					maxLength:2,
					anchor:'30%'
				},
				{ 
					fieldLabel:'judge_cycle',
					xtype:'textfield',
					name:'judge_cycle',
					hidden:true,
					maxLength:2,
					anchor:'30%'
				},
				{ 
					fieldLabel:'state',
					xtype:'textfield',
					name:'state',
					hidden:true,
					maxLength:2,
					anchor:'30%'
				}
		]
	});
}
