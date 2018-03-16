var zxJudgeApplyWinDetail;
var zxJudgeApplyFormDetail;
function detailZxJudgeApply(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxJudgeApplyFormDetail();
	zxJudgeApplyWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:1000,
		height:500,
		maximizable:true,
		minimizable:true,
		resizable : false,
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
		items:zxJudgeApplyFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxJudgeApplyWinDetail.show();
	
	loadFormData(zxJudgeApplyFormDetail,'../zxJudgeApplyController/getZxJudgeApplyById?id='+ record.items[0].data.id);
}
function initZxJudgeApplyFormDetail(){
	zxJudgeApplyFormDetail = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'ID',
			xtype:'textfield',
			hidden:true,
			name:'id',
			allowBlank:false,
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'供应商',
			xtype:'textfield',
			name:'supplier_name',
			allowBlank:false,
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'验厂申请人',
			xtype:'textfield',
			name:'apply_user_name',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'验厂审核人',
			xtype:'textfield',
			name:'check_user_name',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'状态',
			xtype:'textfield',
			name:'status',
			id:'status',
			maxLength:2,
			anchor:'100%',
			renderer:function(value){
				if(value == 1){
					return '保存中';
				}else if(value == 2){
					return '审核中';
				}else if(value == 3){
					return '申请通过';
				}else{
					return '申请退回';
				}
			}
		},
		{
			fieldLabel:'开始日期',
			xtype:'datefield',
			format:'Y-m-d',
			name:'judge_date_start',
			maxLength:19,
			anchor:'60%'
		},
		{
			fieldLabel:'结束日期',
			xtype:'datefield',
			format:'Y-m-d',
			name:'judge_date_end',
			maxLength:19,
			anchor:'60%'
		},
		{
			fieldLabel:'审核日期',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'check_date',
			maxLength:19,
			anchor:'60%'
		},
		{
			fieldLabel:'创建日期',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'create_date',
			maxLength:19,
			anchor:'60%'
		},
		{
			fieldLabel:'申请单内容',
			xtype:'textareafield',
			name:'content',
			maxLength:65535,
			anchor:'100%'
		}
		]
	});
}
