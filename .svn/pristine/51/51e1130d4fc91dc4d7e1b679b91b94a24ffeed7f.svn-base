var zxOfficeApplyWinDetail;
var zxOfficeApplyFormDetail;
var zxOfficeApplyFieldSet;
var zxOfficeApplyFieldSet2;
function detailZxOfficeApply(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxOfficeApplyFormDetail();
	zxOfficeApplyWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:900,
		height:500,
		maximizable:false,
		minimizable:false,
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
		items:zxOfficeApplyFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOfficeApplyWinDetail.show();
	
	loadFormData(zxOfficeApplyFormDetail,'../zxOfficeApplyController/getZxOfficeApplyById?id='+ record.items[0].data.id);
}
function initZxOfficeApplyFormDetail(){
	zxOfficeApplyFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'申领用品',
		items:[
       {
			layout:"column",
		items:[
					{
						fieldLabel:'名称',
						xtype:'textfield',
						name:'office_name',
						id:'office_name',
						maxLength:100,
						readOnly:true,
						width:320
					},
					{
						fieldLabel:'编号',
						xtype:'textfield',
						name:'office_num',
						id:'office_num',
						maxLength:100,
						readOnly:true,
						width:320
					},
					{
						fieldLabel:'规格型号',
						xtype:'textfield',
						name:'standard',
						id:'standard',
						maxLength:100,
						readOnly:true,
						width:320
					}
			]
		}
	]
	});
	zxOfficeApplyFieldSet2= Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
       {
			layout:"column",
		items:[
           {
			fieldLabel:'申请数量',
			xtype:'numberfield',
			value:'0',
			readOnly:true,
			name:'amount',
			maxLength:10,
			width:320
		   },
		   {
				fieldLabel:'状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态',
				xtype:'combo',
				emptyText:'请选择',
				store:zx_office_apply_delete,
				mode:'local',
				triggerAction:'all',
				readOnly:true,
				editable:false,
				allowBlank:false,
				hiddenName:'status',
				valueField:'value',
				displayField:'text',
				name:'status',
				maxLength:2,
				anchor:'100%'
			}
			]
		},
		{
		       layout:"column",
		       items:[
		              {
			           fieldLabel:'备&emsp;&emsp;注',
			           xtype:'textareafield',
			           name:'reason',
			           readOnly:true,
			           maxLength:200,
			           width:680
		               }
		              ]
	         }
	]
	});
	
	zxOfficeApplyFormDetail = Ext.create('Ext.FormPanel',{
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
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		       zxOfficeApplyFieldSet,
		       zxOfficeApplyFieldSet2
		]
	});
}
