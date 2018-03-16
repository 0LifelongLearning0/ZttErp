var zxBuyApplyMaterialWinDetail;
var zxBuyApplyMaterialFormDetail;
var zxBuyApplyFormDetailFieldSet;
var zxProjectFormDetailFieldSet;
function detailZxBuyApplyMaterial(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxBuyApplyMaterialFormDetail();
	zxBuyApplyMaterialWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:1050,
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
		items:zxBuyApplyMaterialFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxBuyApplyMaterialWinDetail.show();
	
	loadFormDataCallBack(zxBuyApplyMaterialFormDetail,'../zxBuyApplyMaterialController/getZxBuyApplyMaterialById?id='+ record.items[0].data.id,callFnDetail);
}
function initZxBuyApplyMaterialFormDetail(){
	zxMaterialFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
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
	zxBuyApplyMaterialFormDetailFieldSet = Ext.create('Ext.form.FieldSet',{
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
				width:320
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
					name:'amount',
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
	zxBuyApplyMaterialFormDetail = Ext.create('Ext.FormPanel',{
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
	       	zxMaterialFormDetailFieldSet,
	       	zxBuyApplyMaterialFormDetailFieldSet
		]
	});
}

function callFnDetail(form, action){
	var material = action.result.data.material;
	Ext.getCmp('material_name').setValue(material.short_name);
	Ext.getCmp('material_num').setValue(material.num);
	Ext.getCmp('material_standard').setValue(material.standard);
}