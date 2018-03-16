var zxWorkpieceWinDetail;
var zxWorkpieceFormDetail;
function detailZxWorkpiece(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxWorkpieceFormDetail();
	zxWorkpieceWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
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
		items:zxWorkpieceFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxWorkpieceWinDetail.show();
	
	loadFormData(zxWorkpieceFormDetail,'../zxWorkpieceController/getZxWorkpieceById?id='+ record.items[0].data.id);
}
function initZxWorkpieceFormDetail(){
	zxWorkpieceFormDetail = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'工件ID',
			xtype:'textfield',
			hidden:true,
			name:'id',
			allowBlank:false,
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'项目名称',
			xtype:'textfield',
			name:'project_name',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'组别',
			xtype:'textfield',
			name:'zubie',
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'工件编号',
			xtype:'textfield',
			name:'num',
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'工件名称',
			xtype:'textfield',
			name:'name',
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'单位',
			xtype:'textfield',
			name:'unit',
			maxLength:50,
			anchor:'100%'
		}
		]
	});
}
