var zxBuyApplyMaterialWinEdit;
var zxBuyApplyMaterialFormEdit;
var zxMaterialFormEditFieldSet;
var zxBuyApplyMaterialFormEditFieldSet;
function updateZxBuyApplyMaterial(){
	if($("#buy_apply_status").val() != '1'){
		msgTishi('待申请状态才可以操作物料！');
		return;
	}
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxBuyApplyMaterialFormEdit();
	zxBuyApplyMaterialWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:1050,
		height:500,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'编辑物料信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxBuyApplyMaterialFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxBuyApplyMaterialFormEdit,'../zxBuyApplyMaterialController/updateZxBuyApplyMaterial',grid,zxBuyApplyMaterialWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxBuyApplyMaterialWinEdit.show();
	
	loadFormDataCallBack(zxBuyApplyMaterialFormEdit,'../zxBuyApplyMaterialController/getZxBuyApplyMaterialById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxBuyApplyMaterialFormEdit(){
	zxMaterialFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'物料信息',
		items:[
       {
			layout:"column",
			items:[
				{
					fieldLabel:'物料编号',
					xtype:'textfield',
					trigger1Cls:'x-form-ss-trigger',
					onTrigger1Click:function(){selectMaterial();},
					name:'material_num',
					allowBlank: false,
					id:'material_num',
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'物料名称',
					xtype:'textfield',
					name:'material_name',
					id:'material_name',
					maxLength:100,
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'型号',
					xtype:'textfield',
					name:'material_standard',
					id:'material_standard',
					maxLength:100,
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'物料标识',
					xtype:'textfield',
					name:'material_id',
					id:'material_id',
					hidden:true
				}
			]
		}
	]
	});
	zxBuyApplyMaterialFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
       {
			layout:"column",
			items:[
			{
				fieldLabel:'材质',
				xtype:'textfield',
				name:'caizhi',
				maxLength:100,
				width:320
			},
			{
				fieldLabel:'品牌',
				xtype:'textfield',
				name:'brand',
				maxLength:150,
				width:320
			},
			{
				fieldLabel:'单台数量',
				xtype:'textfield',
				name:'single_amount',
				allowBlank: false,
				maxLength:20,
				width:320,
				listeners : {
			       change : function(field,newValue,oldValue){
			    		Ext.getCmp('amount').setValue(newValue * $("#make_num").val());
			       }
				}
			},
			{
				fieldLabel:'状态',
				xtype:'textfield',
				name:'status',
				value:'1',
				maxLength:5,
				hidden:true,
				width:320
			},
			{
				fieldLabel:'申请标识',
				xtype:'textfield',
				name:'apply_id',
				id:'apply_id',
				hidden:true
			},
			{
				fieldLabel:'标识ID',
				xtype:'textfield',
				name:'id',
				hidden:true
			}
			]
		},       
		{
			layout:"column",
			items:[
				{
					fieldLabel:'总数量',
					xtype:'textfield',
					allowBlank: false,
					readOnly:true,
					name:'amount',
					id:'amount',
					maxLength:20,
					width:320
				},
				{
					fieldLabel:'备注',
					xtype:'textfield',
					name:'remark',
					maxLength:255,
					width:650
				}
			]
		}
	]
	});
	zxBuyApplyMaterialFormEdit = Ext.create('Ext.FormPanel',{
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
	       	zxMaterialFormEditFieldSet,
	       	zxBuyApplyMaterialFormEditFieldSet
		]
	});
}

function callFnUpdate(form, action){
	var material = action.result.data.material;
	Ext.getCmp('material_name').setValue(material.short_name);
	Ext.getCmp('material_num').setValue(material.num);
	Ext.getCmp('material_standard').setValue(material.standard);
}