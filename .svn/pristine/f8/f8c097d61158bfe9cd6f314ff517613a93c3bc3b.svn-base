var zxOfficeInventoryWinAdd;
var zxOfficeInventoryFormAdd;
function addZxOfficeInventory(){
	var record = d3.getSelectionModel().selected;
	initZxOfficeInventoryFormAdd();
	zxOfficeInventoryWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:350,
		height:300,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'补充数量',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOfficeInventoryFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOfficeInventoryFormAdd,'../zxOfficeInventoryController/addZxOfficeInventory',d3,zxOfficeInventoryWinAdd,false,true);
				/*submitForm();*/
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOfficeInventoryWinAdd.show();
	loadFormData(zxOfficeInventoryFormAdd,'../zxOfficeInventoryController/getZxOfficeInventoryAddById?id='+ record.items[0].data.office_id);
}
function initZxOfficeInventoryFormAdd(){
	zxOfficeInventoryFormAdd = Ext.create('Ext.FormPanel',{
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
			fieldLabel:'office_id',
			xtype:'textfield',
			hidden:true,
			name:'office_id',
			id:'office_id',
			maxLength:32,
			anchor:'100%'
		},
		  {
            fieldLabel:'编号',
            xtype:'textfield',
            name:'office_num',
            hidden:true,
            id:'office_num',
            maxLength:255,
            width:320
          },
		{
			fieldLabel:'名称',
			xtype:'textfield',
			trigger1Cls:'x-form-ss-trigger',
            onTrigger1Click:function(){selectMaterial();},
			name:'office_name',
			allowBlank: false,
			id:'office_name',
			maxLength:100,
			width:320
		},
		{
			fieldLabel:'规格型号',
			xtype:'textfield',
			name:'standard',
			hidden:true,
			id:'standard',
			allowBlank: false,
			maxLength:100,
			readOnly:true,
			width:320
		},
		{
			fieldLabel:'库存数量',
			xtype:'textfield',
			allowBlank: false,
			name:'amount',
			id:'amount',
			readOnly:true,
			maxLength:20,
			width:320
		},
		{
			fieldLabel:'补充数量',
			xtype:'numberfield',
			value:'1',
			name:'add_amount',
			maxLength:20,
			maxValue:1000000,
			allowBlank: false,
			minValue:0,
			width:320
		},
		{
			fieldLabel:'备注',
			xtype:'textfield',
			hidden:true,
			name:'reason',
			maxLength:255,
			anchor:'100%'
		}
		]
	});
}

