var zxOfficeWinEdit;
var zxOfficeFormEdit;
function updateZxOffice(){
	var record = d3.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxOfficeFormEdit();
	zxOfficeWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:350,
		height:300,
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
		items:zxOfficeFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOfficeFormEdit,'../zxOfficeController/updateZxOffice',d3,zxOfficeWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOfficeWinEdit.show();
	
	loadFormData(zxOfficeFormEdit,'../zxOfficeController/getZxOfficeById?office_id='+ record.items[0].data.office_id);
}
function initZxOfficeFormEdit(){
	zxOfficeFormEdit = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'办公用品ID',
			xtype:'textfield',
			hidden:true,
			name:'office_id',
			allowBlank:false,
			maxLength:32,
			anchor:'100%'
		},
		
		         {
			       fieldLabel:'分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类',
			       xtype:'treepicker',
					displayField:'text',
					anchor:'100%',
					hiddenName:'classify_id',
					name:'classify_id',
					minPickerHeight:200,
					maxHeight:200,
					editable:false,
					allowBlank:false,
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
		{
			fieldLabel:'名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称',
			xtype:'textfield',
			name:'name',
			maxLength:255,
			allowBlank:false,
			anchor:'100%'
		},
		{
			fieldLabel:'编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号',
			xtype:'textfield',
			name:'num',
			hidden:true,
			maxLength:100,
			anchor:'100%'
		},
		{
			fieldLabel:'单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位',
			xtype:'textfield',
			name:'unit',
			maxLength:10,
			allowBlank:false,
			anchor:'100%'
		},
		
		/*{
			fieldLabel:'创建时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'create_date',
			maxLength:19,
			anchor:'60%'
		},*/
		{
			fieldLabel:'规格型号',
			xtype:'textfield',
			name:'standard',
			maxLength:255,
			anchor:'100%'
		}
		
		]
	});
}
