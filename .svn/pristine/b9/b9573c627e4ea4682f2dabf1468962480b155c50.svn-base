var zxSixSWinEdit;
var zxSixSFormEdit;
function updateZxSixS(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	if(record.items[0].data.status != '1'){
		msgTishi('不能修改！');
		return;
	}
	initZxSixSFormEdit();
	zxSixSWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:300,
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
		items:zxSixSFormEdit,
		buttons:[{
			text:'事项明细',
			itemId:'detail',
			handler:function(button){
				initZxSixSContentList(record.items[0].data.id);
			}
		},{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxSixSFormEdit,'../zxSixSController/updateZxSixS?status=1',grid,zxSixSWinEdit,false,true);
			}
		},{
			text:'发布',
			itemId:'submit',
			handler:function(button){
				submitForm(zxSixSFormEdit,'../zxSixSController/updateZxSixS?status=2',grid,zxSixSWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxSixSWinEdit.show();
	
	loadFormData(zxSixSFormEdit,'../zxSixSController/getZxSixSById?id='+ record.items[0].data.id);
}
function initZxSixSFormEdit(){
	zxSixSFormEdit = Ext.create('Ext.FormPanel',{
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
			anchor:'100%'
		},
		{
			fieldLabel:'标题',
			xtype:'textareafield',
			name:'title',
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'检查日期',
			xtype:'datefield',
			format:'Y-m-d',
			name:'check_date',
			maxLength:19,
			allowBlank:false,
			editable:false,
			anchor:'50%'
		},
		{
			fieldLabel:'发布人',
			xtype:'textfield',
			name:'user_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'状态：1-正常，0-删除',
			xtype:'textfield',
			name:'state',
			maxLength:2,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'创建日期',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'create_date',
			maxLength:19,
			hidden:true,
			anchor:'100%'
		}
		]
	});
}
