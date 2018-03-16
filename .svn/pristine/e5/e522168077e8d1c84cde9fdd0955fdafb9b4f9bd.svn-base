var zxConcordatWinEdit;
var zxConcordatFormEdit;
function updateZxConcordat(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxConcordatFormEdit();
	zxConcordatWinEdit = Ext.create('Ext.Window',{
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
		items:zxConcordatFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxConcordatFormEdit,'../zxConcordatController/updateZxConcordat',grid,zxConcordatWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxConcordatWinEdit.show();
	
	loadFormData(zxConcordatFormEdit,'../zxConcordatController/getZxConcordatById?id='+ record.items[0].data.id);
}
function initZxConcordatFormEdit(){
	zxConcordatFormEdit = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'合同编号',
			xtype:'textfield',
			name:'num',
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'合同标题',
			xtype:'textfield',
			name:'name',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'合同描述',
			xtype:'textareafield',
			name:'descriptiom',
			maxLength:65535,
			anchor:'100%'
		}
		]
	});
}
