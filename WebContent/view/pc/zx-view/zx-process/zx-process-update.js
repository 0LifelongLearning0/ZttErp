var zxProcessWinEdit;
var zxProcessFormEdit;
function updateZxProcess(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxProcessFormEdit();
	zxProcessWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
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
		items:zxProcessFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxProcessFormEdit,'../zxProcessController/updateZxProcess',grid,zxProcessWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxProcessWinEdit.show();
	
	loadFormData(zxProcessFormEdit,'../zxProcessController/getZxProcessById?id='+ record.items[0].data.id);
}
function initZxProcessFormEdit(){
	zxProcessFormEdit = Ext.create('Ext.FormPanel',{
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
			labelWidth:69,
			labelAlign:'left',
			flex:1,
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
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'工序名称',
			xtype:'textfield',
			name:'name',
			maxLength:255,
			anchor:'100%'
		}
		]
	});
}
