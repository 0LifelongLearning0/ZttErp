var zxMachineWinDetail;
var zxMachineFormDetail;
function detailZxMachine(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxMachineFormDetail();
	zxMachineWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:400,
		height:200,
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
		items:zxMachineFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxMachineWinDetail.show();
	
	loadFormData(zxMachineFormDetail,'../zxMachineController/getZxMachineById?id='+ record.items[0].data.id);
}
function initZxMachineFormDetail(){
	zxMachineFormDetail = Ext.create('Ext.FormPanel',{
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
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			readOnly:true,
			margin:'2 5 4 5'
		},
		items:[
		{
			fieldLabel:'加工商ID',
			xtype:'textfield',
			hidden:true,
			name:'id',
			allowBlank:false,
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'名称',
			xtype:'textfield',
			name:'name',
			maxLength:255,
			anchor:'100%'
		}
		]
	});
}
