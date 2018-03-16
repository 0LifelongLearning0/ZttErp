var zxProcessWinAdd;
var zxProcessFormAdd;
function addZxProcess(){
	initZxProcessFormAdd();
	zxProcessWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:400,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxProcessFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxProcessFormAdd,'../zxProcessController/addZxProcess',grid,zxProcessWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxProcessWinAdd.show();
	
}
function initZxProcessFormAdd(){
	zxProcessFormAdd = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'工序名称',
			xtype:'textfield',
			name:'name',
			maxLength:255,
			anchor:'100%'
		}
		]
	});
}
