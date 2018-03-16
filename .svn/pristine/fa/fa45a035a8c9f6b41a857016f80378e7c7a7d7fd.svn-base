var zxJudgeApplyWinCheck;
var zxJudgeApplyFormCheck;
function checkZxJudgeApply(){
	initzxJudgeApplyFormCheck();
	var buttons = [{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	zxJudgeApplyWinCheck = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:600,
		maximizable:true,
		minimizable:true,
		resizable : false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'申请详情',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxJudgeApplyFormCheck,
		buttons:buttons
	});
	zxJudgeApplyWinCheck.show();
	
	loadFormData(zxJudgeApplyFormCheck,'../zxJudgeApplyController/getZxJudgeApply?supplier_id='+ supplier_id + '&num=' + yc_num);
}
function initzxJudgeApplyFormCheck(){
	zxJudgeApplyFormCheck = Ext.create('Ext.FormPanel',{
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
			readOnly:true,
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
			fieldLabel:'申请单内容',
			xtype:'htmleditor',  
            name:'content',  
            height:320,  
            width:'100%',
            editable:false,
            maxLength:65535,
            fontFamilies :['宋体','黑体','楷体'],  
            defaultLinkValue :'http://www.uspcat.com'  
		},
		{
			fieldLabel:'开始日期',
			xtype:'textfield',
			name:'judge_date_start',
			maxLength:19,
			editable:false,
			anchor:'100%'
		},
		{
			fieldLabel:'结束日期',
			xtype:'textfield',
			name:'judge_date_end',
			maxLength:19,
			editable:false,
			anchor:'100%'
		}
		]
	});
}
