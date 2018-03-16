var zxBuyApplyMaterialWinAdd;
var zxBuyApplyMaterialFormAdd;
var zxMaterialFormAddFieldSet;
var zxBuyApplyMaterialFormAddFieldSet;
function addZxBuyApplyMaterial(){
	if($("#buy_apply_status").val() != '1'){
		msgTishi('待申请状态才可以操作物料！');
		return;
	}
	initZxBuyApplyMaterialFormAdd();
	Ext.getCmp('apply_id').setValue($("#buy_apply_id").val());
	zxBuyApplyMaterialWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:1065,
		height:500,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加物料',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxBuyApplyMaterialFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxBuyApplyMaterialFormAdd,'../zxBuyApplyMaterialController/addZxBuyApplyMaterial',grid,zxBuyApplyMaterialWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxBuyApplyMaterialWinAdd.show();
}
function initZxBuyApplyMaterialFormAdd(){
	zxMaterialFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
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
	zxBuyApplyMaterialFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
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
			    		Ext.getCmp('add_amount').setValue(newValue * $("#make_num").val());
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
					readOnly: true,
					name:'amount',
					id:'add_amount',
					maxLength:20,
					width:320
				},
				{
					fieldLabel:'备注',
					xtype:'textareafield',
					name:'remark',
					maxLength:255,
					width:650
				}
			]
		}
	]
	});
	
	zxBuyApplyMaterialFormAdd = Ext.create('Ext.FormPanel',{
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
			zxMaterialFormAddFieldSet,
			zxBuyApplyMaterialFormAddFieldSet
		]
	});
}
