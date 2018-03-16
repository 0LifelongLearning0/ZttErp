var zxOutProgressWinInEdit;
var zxOutProgressFormInEdit;
var zxMaterialFormEditFieldSet;
var zxOutTimeFormInEditFieldSet;
var zxOutTimeFormInDetail;
function inZxOutProgress(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要入库的工件！');
		return;
	}
	initZxOutProgressFormInEdit();
	reGetWidthAndHeight();
	zxOutProgressWinInEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:"工件入库",
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOutProgressFormInEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOutProgressFormInEdit,'../zxOutProgressController/inZxOutProgress',grid,zxOutProgressWinInEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOutProgressWinInEdit.show();
	loadFormDataCallBack(zxOutProgressFormInEdit,'../zxOutProgressController/getZxOutProgressById?id='+ record.items[0].data.id,callFnInDetail);
}
function initZxOutProgressFormInEdit(){
	zxMaterialFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'工件信息',
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
					fieldLabel:'工件编号',
					xtype:'textfield',
					name:'workpiece_num',
					readOnly:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'工件名称',
					xtype:'textfield',
					name:'workpiece_name',
					readOnly:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'单位',
					xtype:'textfield',
					name:'workpiece_unit',
					readOnly:true
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'外协数量',
					xtype:'textfield',
					name:'out_amount',
					readOnly:true
				}]
			},
			{
				fieldLabel:'出库数量',
				xtype:'textfield',
				name:'out_warehouse_amount',
				hidden:true
			}
			]
		},
		{
			xtype:'numberfield',
			hidden:true,
			value:'0',
			itemId:'zxOutTimeFormNumber'
		},
		{
			xtype:'textfield',
			hidden:true,
			name:'zxOutTime_removed_flag',
			itemId:'zxOutTime_removed_flag'
		}
	]
	});
	zxOutTimeFormInEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'分批信息'
	});
	zxOutProgressFormInEdit = Ext.create('Ext.FormPanel',{
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
			zxOutTimeFormInEditFieldSet
		]
	});
}

function callFnInDetail(form, action){
	var zxOutTime = action.result.data.zxOutTime;
	for(var i = 0; i < zxOutTime.length; i++){
		addZxOutTimeFormInDetail(zxOutTime[i]);
	}
}

function addZxOutTimeFormInDetail(data){
	var numbers = gfiValue(zxMaterialFormEditFieldSet,'zxOutTimeFormNumber');
	sfiValue(zxMaterialFormEditFieldSet,'zxOutTimeFormNumber',numbers+1);
	zxOutTimeFormInDetail = Ext.create('Ext.FormPanel',{
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
			name:'zxOutTime['+numbers+'].id',
			itemId:'zxOutTime['+numbers+'].id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'采购ID',
			xtype:'textfield',
			name:'zxOutTime['+numbers+'].out_id',
			itemId:'zxOutTime['+numbers+'].out_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'计划交货时间',
			xtype:'datefield',
			format:'Y-m-d',
			name:'zxOutTime['+numbers+'].plan_date',
			itemId:'zxOutTime['+numbers+'].plan_date',
			readOnly:true,
			maxLength:10,
			anchor:'100%'
		},
		{
			fieldLabel:'计划到货数量',
			xtype:'textfield',
			name:'zxOutTime['+numbers+'].plan_amount',
			itemId:'zxOutTime['+numbers+'].plan_amount',
			readOnly:true,
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'实际交货时间',
			xtype:'datefield',
			format:'Y-m-d',
			name:'zxOutTime['+numbers+'].real_date',
			itemId:'zxOutTime['+numbers+'].real_date',
			readOnly:true,
			maxLength:10,
			anchor:'100%'
		},
		{
			fieldLabel:'实际到货数量',
			xtype:'textfield',
			name:'zxOutTime['+numbers+'].real_amount',
			itemId:'zxOutTime['+numbers+'].real_amount',
			readOnly:true,
			emptyText:'0',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'入库时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'zxOutTime['+numbers+'].in_warehouse_date',
			itemId:'zxOutTime['+numbers+'].in_warehouse_date',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'入库数量',
			xtype:'textfield',
			emptyText:'0',
			name:'zxOutTime['+numbers+'].in_warehouse_amount',
			itemId:'zxOutTime['+numbers+'].in_warehouse_amount',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'备注',
			xtype:'textfield',
			name:'zxOutTime['+numbers+'].remark',
			itemId:'zxOutTime['+numbers+'].remark',
			maxLength:65536,
			width:1000
		}
		]
	});
	zxOutTimeFormInEditFieldSet.add(zxOutTimeFormInEditFieldSet.items.getCount(),zxOutTimeFormInDetail);
	if(null != data){
		//获取表单中所有字段与值（key/value）
		var zxOutTimeFormInDetailData = zxOutTimeFormInDetail.getForm().getFieldValues();
		//遍历表单中所有字段名称（key）
		for(var zxOutTimeFormInDetailField in zxOutTimeFormInDetailData){
			//获取表单中所有字段名称（key）并且截取对象后面的字段 目的与实体类中字段名称一致
			var zxOutTimeFormInDetailYField = zxOutTimeFormInDetailField.split(".")[1];
			//遍历服务器传递来的对象
			for(var dataKey in data){
				//判断当前字段是否等于服务器传过来的字段
				if(zxOutTimeFormInDetailYField == dataKey){
					//给表单每个字段赋值
					sfiValue(zxOutTimeFormInDetail,zxOutTimeFormInDetailField,data[dataKey]);
				}
			}
		}
	}
	zxOutTimeFormInEditFieldSet.afterLayout();
	resetTitle(zxOutTimeFormInEditFieldSet,true);
}