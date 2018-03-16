var zxJudgeResultWinAdd;
var zxJudgeResultFormAdd;
function applyZxJudge(){
	initZxJudgeResultFormAdd();
	zxJudgeResultWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:400,
		maximizable:true,
		minimizable:true,
		resizable : false,
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
		items:zxJudgeResultFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxJudgeResultFormAdd,'../zxJudgeStandardController/addZxJudgeStandard',grid,zxJudgeResultWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxJudgeResultWinAdd.show();
	initFileRight('xt_userinfo_pic','xt_userinfo_pic_pic',2,1);
}
function initZxJudgeResultFormAdd(){
	zxJudgeResultFormAdd = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'文件名',
			xtype:'textfield',
			name:'total_score',
			maxLength:22,
			anchor:'60%'
		},
		{
			title:'采购申请单',
			xtype:'fieldset',
			items:{
				xtype:'box', 
				id:'xt_userinfo_pic_pic', 
				margin:'2 5 4 70', 
				autoEl:{
					tag:'img',
					src:bsdefimg
				}
			}
		}
		]
	});
}
