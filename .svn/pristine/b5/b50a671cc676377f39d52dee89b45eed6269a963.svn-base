var zxJudgeApplyWinAdd;
var zxJudgeApplyFormAdd;
function addZxJudgeApply(){
	initZxJudgeApplyFormAdd();
	zxJudgeApplyWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:600,
		maximizable:true,
		minimizable:true,
		resizable : false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加验厂申请单',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxJudgeApplyFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm2(zxJudgeApplyFormAdd,'../zxJudgeApplyController/addZxJudgeApply?supplier_id=' + supplier_id + '&status=1&num=' + yc_num,grid,zxJudgeApplyWinAdd,false,true);
			}
		},{
			text:'提交',
			itemId:'tocheck',
			handler:function(button){
				submitForm2(zxJudgeApplyFormAdd,'../zxJudgeApplyController/addZxJudgeApply?supplier_id=' + supplier_id + '&status=2&num=' + yc_num,grid,zxJudgeApplyWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxJudgeApplyWinAdd.show();
	
}
function initZxJudgeApplyFormAdd(){
	var flag = false;
	var permission = $('#permission').val();
	if(permission.indexOf(",zxJudgeApplyController/addZxJudgeApply,") == -1&&(!$('#isAdmin').val()||$('#isAdmin').val() == 'false')){
		flag = true;
	}
	console.log(flag);
	zxJudgeApplyFormAdd = Ext.create('Ext.FormPanel',{
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
			readOnly:flag,
			margin:'2 5 4 5'
		},
		items:[
		{
			
			fieldLabel:'申请单内容',
			xtype:'htmleditor',  
            name:'content',  
            height:320,  
            width:'100%',
            maxLength:65535,
            allowBlank:false,
            fontFamilies :['宋体','黑体','楷体'],  
            defaultLinkValue :'http://www.uspcat.com'  
		},
		{
			fieldLabel:'开始日期',
			xtype:'datefield',
			format:'Y-m-d',
			name:'judge_date_start',
			id:'judge_date_start',
			maxLength:19,
			allowBlank:false,
			anchor:'60%',
			listeners: {
				"select": function () {
					var date = new Date();
				    var month = date.getMonth() + 1;
				    var strDate = date.getDate();
				    if (month >= 1 && month <= 9) {
				        month = "0" + month;
				    }
				    if (strDate >= 0 && strDate <= 9) {
				        strDate = "0" + strDate;
				    }
				    var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
				    
					var te = dateFormat(Ext.getCmp('judge_date_end').getValue());
					var ts = dateFormat(Ext.getCmp('judge_date_start').getValue());
					if((te != ''&&ts != ''&&ts > te)||ts < currentdate){
						Ext.getCmp('judge_date_start').setValue('');
						msgTishi('日期选择错误');
						return;
					}
				}
			}
		},
		{
			fieldLabel:'结束日期',
			xtype:'datefield',
			format:'Y-m-d',
			name:'judge_date_end',
			id:'judge_date_end',
			maxLength:19,
			allowBlank:false,
			anchor:'60%',
			listeners: {
				"select": function () {
					var date = new Date();
				    var month = date.getMonth() + 1;
				    var strDate = date.getDate();
				    if (month >= 1 && month <= 9) {
				        month = "0" + month;
				    }
				    if (strDate >= 0 && strDate <= 9) {
				        strDate = "0" + strDate;
				    }
				    var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
				    
					var te = dateFormat(Ext.getCmp('judge_date_end').getValue());
					var ts = dateFormat(Ext.getCmp('judge_date_start').getValue());
					if((te != ''&&ts != ''&&ts > te)||te < currentdate){
						Ext.getCmp('judge_date_end').setValue('');
						msgTishi('日期选择错误');
						return;
					}
				}
			}
		}
		]
	});
}
function dateFormat(value){ 
    if(null != value){ 
        return Ext.Date.format(new Date(value),'Y-m-d'); 
    }else{ 
        return ""; 
    } 
} 