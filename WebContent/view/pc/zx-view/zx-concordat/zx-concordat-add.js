var zxConcordatWinAdd;
var zxConcordatFormAdd;
function addZxConcordat(){
	initZxConcordatFormAdd();
	zxConcordatWinAdd = Ext.create('Ext.Window',{
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
		items:zxConcordatFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxConcordatFormAdd,'../zxConcordatController/addZxConcordat',grid,zxConcordatWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxConcordatWinAdd.show();
	
}
function initZxConcordatFormAdd(){
	zxConcordatFormAdd = Ext.create('Ext.FormPanel',{
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
