var zxSupplierWinDetail;
var zxSupplierFormDetail;
function detailZxSupplier(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initFieldItems();
	reGetWidthAndHeight();
	initZxSupplierFormDetail();
	zxSupplierWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth * 0.9,                    
		height:clientHeight * 0.9 ,
		maximizable:true,
		minimizable:true,
		resizable : false,
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
		items:zxSupplierFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxSupplierWinDetail.show();
	
	loadFormData(zxSupplierFormDetail,'../zxSupplierController/getZxSupplierById?id='+ record.items[0].data.id);
}
function initZxSupplierFormDetail(){
	zxSupplierFormDetail = Ext.create('Ext.FormPanel',{
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
		       zxField1,
		       zxField2,
		       zxField3,
		       zxField4
		]
	});
}
