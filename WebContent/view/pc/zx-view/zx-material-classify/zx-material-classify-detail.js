var zxMaterialClassifyWinDetail;
var zxMaterialClassifyFormDetail;
function detailZxMaterialClassify(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxMaterialClassifyFormDetail();
	zxMaterialClassifyWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,
		height:400,
		maximizable:true,
		minimizable:true,
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
		items:zxMaterialClassifyFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxMaterialClassifyWinDetail.show();
	
	loadFormData(zxMaterialClassifyFormDetail,'../zxMaterialClassifyController/getZxMaterialClassifyById?classify_id='+ record.items[0].data.classify_id);
}
function initZxMaterialClassifyFormDetail(){
	zxMaterialClassifyFormDetail = Ext.create('Ext.FormPanel',{
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
			readOnly:true,
			margin:'2 5 4 5'
		},
		items:[
		{
			fieldLabel:'序列号',
			xtype:'textfield',
			hidden:true,
			name:'classify_id',
			allowBlank:false,
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'物料父ID',
			xtype:'textfield',
			name:'classify_parentId',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'分类名称',
			xtype:'textfield',
			name:'classify_short_name',
			allowBlank:false,
			maxLength:200,
			anchor:'100%'
		},
		{
			fieldLabel:'全名',
			xtype:'textfield',
			name:'classify_name',
			allowBlank:false,
			maxLength:200,
			anchor:'100%'
		},
		{
			fieldLabel:'分类编号',
			xtype:'textfield',
			name:'classify_num',
			allowBlank:false,
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'是否存在子叶',
			xtype:'textfield',
			name:'classify_leaf',
			maxLength:1,
			anchor:'100%'
		},
		{
			fieldLabel:'状态',
			xtype:'combo',
			emptyText:'请选择',
			store:zx_material_classify_delete,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'classify_isdelete',
			valueField:'value',
			displayField:'text',
			name:'classify_isdelete',
			maxLength:1,
			anchor:'100%'
		},
		{
			fieldLabel:'创建时间',
			xtype:'textfield',
			name:'classify_time',
			maxLength:20,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'排序',
			xtype:'numberfield',
			value:'0',
			name:'classify_sort',
			maxLength:10,
			anchor:'100%'
		}
		]
	});
}
