var zxBuyProgressWinEdit;
var zxBuyProgressFormOutEdit;
var zxMaterialFormEditFieldSet;
var zxBuyTimeFormEditFieldSet;
function outZxBuyProgress(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要出库的物料！');
		return;
	}
	initZxBuyProgressFormEdit();
	reGetWidthAndHeight();
	zxBuyProgressWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:"物料出库",
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxBuyProgressFormOutEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxBuyProgressFormOutEdit,'../zxBuyProgressController/outZxBuyProgress',grid,zxBuyProgressWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxBuyProgressWinEdit.show();
	loadFormDataCallBack(zxBuyProgressFormOutEdit,'../zxBuyProgressController/getZxBuyProgressById?id='+ record.items[0].data.id,callFnOutDetail);
}
function initZxBuyProgressFormEdit(){
	zxMaterialFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'物料信息',
		items:[
		{
			layout:"column",
			items:[
			{
				fieldLabel:'ID',
				xtype:'textfield',
				name:'id',
				id:'id',
				hidden:true
			},
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'项目号',
					xtype:'textfield',
					name:'project_num',
					readOnly: true
				}]
			},
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'项目名称',
					xtype:'textfield',
					name:'project_name',
					readOnly: true
				}]
			},
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'申请编号',
					xtype:'textfield',
					name:'apply_num',
					readOnly: true
				}]
			},
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'订单编号',
					xtype:'textfield',
					name:'order_num',
					readOnly: true
				}]
			}
			]
		},
        {
			layout:"column",
			items:[
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'物料编号',
					xtype:'textfield',
					name:'material_num',
					readOnly:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'物料名称',
					xtype:'textfield',
					name:'material_name',
					readOnly:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'规格型号',
					xtype:'textfield',
					name:'material_standard',
					readOnly:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'采购数量',
					xtype:'textfield',
					name:'buy_amount',
					readOnly:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'已到数量',
					xtype:'textfield',
					name:'real_amount',
					hidden:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'入库数量',
					xtype:'textfield',
					name:'in_warehouse_amount',
					hidden:true
				}]
			}
			]
		},
		{
			xtype:'numberfield',
			hidden:true,
			value:'0',
			itemId:'zxBuyTimeFormNumber'
		},
		{
			xtype:'textfield',
			hidden:true,
			name:'zxBuyTime_removed_flag',
			itemId:'zxBuyTime_removed_flag'
		}
	]
	});

	zxBuyTimeFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'分批信息'
	});
	zxBuyProgressFormOutEdit = Ext.create('Ext.FormPanel',{
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
			margin:'2 5 4 0'
		},
		items:[
		    zxMaterialFormEditFieldSet,
		    zxBuyTimeFormEditFieldSet
		]
	});
}

function callFnOutDetail(form, action){
	var zxBuyTime = action.result.data.zxBuyTime;
	for(var i = 0; i < zxBuyTime.length; i++){
		addZxBuyTimeFormOutDetail(zxBuyTime[i]);
	}
}

function addZxBuyTimeFormOutDetail(data){
	var numbers = gfiValue(zxMaterialFormEditFieldSet,'zxBuyTimeFormNumber');
	sfiValue(zxMaterialFormEditFieldSet,'zxBuyTimeFormNumber',numbers+1);
	zxBuyTimeFormDetail = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		layout:"column",
		fieldDefaults:{
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
			fieldLabel:'ID',
			xtype:'textfield',
			name:'zxBuyTime['+numbers+'].id',
			itemId:'zxBuyTime['+numbers+'].id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'采购ID',
			xtype:'textfield',
			name:'zxBuyTime['+numbers+'].buy_id',
			itemId:'zxBuyTime['+numbers+'].buy_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'实际交货时间',
			xtype:'datefield',
			format:'Y-m-d',
			name:'zxBuyTime['+numbers+'].real_date',
			itemId:'zxBuyTime['+numbers+'].real_date',
			readOnly:true,
			maxLength:10,
			anchor:'100%'
		},
		{
			fieldLabel:'实际到货数量',
			xtype:'textfield',
			name:'zxBuyTime['+numbers+'].real_amount',
			itemId:'zxBuyTime['+numbers+'].real_amount',
			readOnly:true,
			emptyText:'0',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'入库时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'zxBuyTime['+numbers+'].in_warehouse_date',
			itemId:'zxBuyTime['+numbers+'].in_warehouse_date',
			readOnly:true,
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'入库数量',
			xtype:'textfield',
			emptyText:'0',
			name:'zxBuyTime['+numbers+'].in_warehouse_amount',
			itemId:'zxBuyTime['+numbers+'].in_warehouse_amount',
			readOnly:true,
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'出库时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'zxBuyTime['+numbers+'].out_warehouse_date',
			itemId:'zxBuyTime['+numbers+'].out_warehouse_date',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'出库数量',
			xtype:'textfield',
			emptyText:'0',
			name:'zxBuyTime['+numbers+'].out_warehouse_amount',
			itemId:'zxBuyTime['+numbers+'].out_warehouse_amount',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'备注',
			xtype:'textfield',
			name:'zxBuyTime['+numbers+'].remark',
			itemId:'zxBuyTime['+numbers+'].remark',
			maxLength:65536,
			width:1000
		}
		]
	});
	zxBuyTimeFormEditFieldSet.add(zxBuyTimeFormEditFieldSet.items.getCount(),zxBuyTimeFormDetail);
	if(null != data){
		//获取表单中所有字段与值（key/value）
		var zxBuyTimeFormDetailData = zxBuyTimeFormDetail.getForm().getFieldValues();
		//遍历表单中所有字段名称（key）
		for(var zxBuyTimeFormDetailField in zxBuyTimeFormDetailData){
			//获取表单中所有字段名称（key）并且截取对象后面的字段 目的与实体类中字段名称一致
			var zxBuyTimeFormDetailYField = zxBuyTimeFormDetailField.split(".")[1];
			//遍历服务器传递来的对象
			for(var dataKey in data){
				//判断当前字段是否等于服务器传过来的字段
				if(zxBuyTimeFormDetailYField == dataKey){
					//给表单每个字段赋值
					sfiValue(zxBuyTimeFormDetail,zxBuyTimeFormDetailField,data[dataKey]);
				}
			}
		}
	}
	zxBuyTimeFormEditFieldSet.afterLayout();
	resetTitle(zxBuyTimeFormEditFieldSet,true);
}