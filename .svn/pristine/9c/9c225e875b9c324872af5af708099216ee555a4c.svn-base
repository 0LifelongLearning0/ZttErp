var zxOfficeClassifyWinEdit;
var zxOfficeClassifyFormEdit;
function updateZxOfficeClassify(){
	var record = treePanel.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxOfficeClassifyFormEdit();
	zxOfficeClassifyWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:350,
		height:350,
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
		items:zxOfficeClassifyFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOfficeClassifyFormEdit,'../zxOfficeClassifyController/updateZxOfficeClassify',treePanel,zxOfficeClassifyWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOfficeClassifyWinEdit.show();
	
	loadFormData(zxOfficeClassifyFormEdit,'../zxOfficeClassifyController/getZxOfficeClassifyById?classify_id='+ record.items[0].data.id);
}
function initZxOfficeClassifyFormEdit(){
	zxOfficeClassifyFormEdit = Ext.create('Ext.FormPanel',{
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
	fieldLabel:'上级分类',
	xtype:'treepicker',
	displayField:'text',
	anchor:'100%',
	hiddenName:'classify_parentId',
	name:'classify_parentId',
	minPickerHeight:200,
	maxHeight:200,
	editable:false,
	allowBlank:false,
	rootVisible:true,
	store:Ext.create('Ext.data.TreeStore',{
		fields:['id','text'],
		root:{
			text:'一级分类',
			id:'0',
			expanded:true
		},
		proxy:{
			type:'ajax',
			url:'../zxOfficeClassifyController/getZxOfficeClassifyTree',
			reader:{
				type:'json'
			}
		}
	})
},
	/*	{
			fieldLabel:'序列号',
			xtype:'textfield',
			hidden:true,
			name:'classify_id',
			allowBlank:false,
			maxLength:32,
			anchor:'100%'
		},*/
		/*{
			fieldLabel:'办公用品父ID',
			xtype:'textfield',
			name:'classify_parentId',
			maxLength:32,
			anchor:'100%'
		},*/
		{
			fieldLabel:'分类名称',
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
			hidden:true,
			maxLength:100,
			anchor:'100%'
		},
		/*{
			fieldLabel:'是否存在子叶',
			xtype:'combo',
			emptyText:'请选择',
			store:zx_office_classify_leaf,
			mode:'local',
			hidden:true,
			triggerAction:'all',
			editable:false,
			allowBlank: false,
			hiddenName:'classify_leaf',
			valueField:'value',
			displayField:'text',
			name:'classify_leaf',
			maxLength:1,
			anchor:'100%'
		},*/
		{
			fieldLabel:'排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序',
			xtype:'numberfield',
			value:'0',
			name:'classify_sort',
			maxLength:10,
			anchor:'100%'
		}
		]
	});
}



