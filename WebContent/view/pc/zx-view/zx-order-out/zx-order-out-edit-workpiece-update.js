var zxOutProgressWinEdit;
var zxOutProgressFormEdit;
var zxOutTimeFormEdit;
var zxOutProgressFormEditFieldSet;
var zxOutProgressFormBuyEditFieldSet;
var zxOutTimeFormEditFieldSet;

function updateZxOutProgressWorkpiece(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要跟单的工件！');
		return;
	}
	initZxOutProgressFormEdit();
	reGetWidthAndHeight();
	zxOutProgressWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'工件跟单',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOutProgressFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOutProgressFormEdit,'../zxOutProgressController/updateZxOutProgress',grid,zxOutProgressWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOutProgressWinEdit.show();
	loadFormDataCallBack(zxOutProgressFormEdit,'../zxOutProgressController/getZxOutProgressById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxOutProgressFormEdit(){
	zxOutProgressFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
       {
			layout:"column",
			items:[
			{
				fieldLabel:'ID',
				xtype:'textfield',
				name:'id',
				id:'id',
				hidden:true,
				maxLength:32,
				anchor:'20%'
			},
			{
				columnWidth:.25,
				fieldLabel:'项目号',
				xtype:'textfield',
				name:'project_num',
				id:'project_num',
				readOnly: true,
				maxLength:255
			},
			{
				columnWidth:.25,
				fieldLabel:'项目名称',
				xtype:'textfield',
				name:'project_name',
				id:'project_name',
				readOnly: true,
				maxLength:255
			},
			{
				columnWidth:.25,
				fieldLabel:'申请编号',
				xtype:'textfield',
				name:'apply_num',
				id:'apply_num',
				readOnly: true,
				maxLength:255
			},
			{
				columnWidth:.25,
				fieldLabel:'订单编号',
				xtype:'textfield',
				name:'order_num',
				id:'order_num',
				readOnly: true,
				maxLength:255
			}
			]
		},
       {
			layout:"column",
			items:[
			{
				columnWidth:.25,
				fieldLabel:'订单标题',
				xtype:'textfield',
				name:'order_name',
				id:'order_name',
				readOnly: true,
				maxLength:100
			},
			{
				columnWidth:.75,
				fieldLabel:'订单描述',
				xtype:'textfield',
				name:'description',
				id:'description',
				readOnly: true,
				maxLength:255,
				anchor:'100%'
			}
			]
		},
		{
			layout:"column",
			items:[
			{
				fieldLabel:'工件ID',
				xtype:'textfield',
				name:'workpiece_id',
				id:'workpiece_id',
				hidden:true,
				maxLength:32
			},
			{
				columnWidth:.25,
				fieldLabel:'工件编号',
				xtype:'textfield',
				name:'workpiece_num',
				readOnly: true,
				id:'workpiece_num',
				maxLength:255
			},
			{
				columnWidth:.25,
				fieldLabel:'工件名称',
				xtype:'textfield',
				name:'workpiece_name',
				id:'workpiece_name',
				readOnly:true,
				maxLength:100
			},
			{
				columnWidth:.25,
				fieldLabel:'单位',
				xtype:'textfield',
				name:'workpiece_unit',
				id:'workpiece_unit',
				maxLength:100,
				readOnly:true
			},
			{
				columnWidth:.25,
				fieldLabel:'外协数量',
				xtype:'textfield',
				name:'out_amount',
				id:'out_amount',
				maxLength:26,
				readOnly:true
			},
			{
				fieldLabel:'已到数量',
				xtype:'textfield',
				name:'real_amount',
				hidden:true
			},
			{
				fieldLabel:'入库数量',
				xtype:'textfield',
				name:'in_warehouse_amount',
				hidden:true
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
	       layout:"column",
	       items:[
			{
				columnWidth:.25,
				fieldLabel:'需求日期',
				xtype:'datefield',
				format:'Y-m-d',
				readOnly:true,
				name:'need_time',
				id:'need_time',
				maxLength:19
			},
			{
				columnWidth:.25,
				fieldLabel:'清单下发时间',
				xtype:'datetimefield',
				format:'Y-m-d H:i:s',
				name:'send_draw_time',
				id:'send_draw_time',
				readOnly:true,
				maxLength:20
			},
			{
				columnWidth:.25,
				fieldLabel:'供应商',
				xtype:'textfield',
				name:'supplier_name',
				id:'supplier_name',
				readOnly: true,
				maxLength:255
			},
			{
				columnWidth:.25,
				fieldLabel:'承诺到货日期',
				xtype:'datefield',
				format:'Y-m-d',
				readOnly: true,
				name:'agree_time',
				id:'agree_time',
				maxLength:20
			},
			]
		},
		{
			layout:"column",
			items:[
			{
				columnWidth:.25,
				fieldLabel:'采购日期',
				xtype:'datefield',
				format:'Y-m-d',
				readOnly: true,
				name:'buy_time',
				id:'buy_time',
				maxLength:20
			},
			{
				fieldLabel:'供应商ID',
				xtype:'textfield',
				name:'supplier_id',
				id:'supplier_id',
				hidden:true,
				maxLength:32
			},
			{
				columnWidth:.75,
				fieldLabel:'备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注',
				xtype:'textfield',
				name:'workpiece_remark',
				maxLength:65535
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
	
	zxOutProgressFormBuyEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'采购信息',
		items:[
		{
	       layout:"column",
	       items:[
			{
				columnWidth:.25,
				fieldLabel:'预计到货日期',
				xtype:'datefield',
				format:'Y-m-d',
				allowBlank: false,
				name:'plan_time',
				maxLength:20
			},
			{
				columnWidth:.75,
				fieldLabel:'备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注',
				xtype:'textfield',
				name:'remark',
				maxLength:65535
			}]
		}
		]
	});
	zxOutTimeFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'分批到货',
		items:[{	
			xtype:'button',
			text:'添加',
			style:'float:left;margin-bottom:10px',
			labelAlign:"right", 
			listeners:{
				click:function(){
					addZxOutTimeFormEdit();
				}
			}
		}
		]
	});
	zxOutProgressFormEdit = Ext.create('Ext.FormPanel',{
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
			margin:'2 0 4 5'
		},
		items:[
			zxOutProgressFormEditFieldSet,
			zxOutProgressFormBuyEditFieldSet,
			zxOutTimeFormEditFieldSet
		]
	});
}

function callFnUpdate(form, action){
	var zxOutTime = action.result.data.zxOutTime;
	for(var i = 0; i < zxOutTime.length; i++){
		addZxOutTimeFormEdit(zxOutTime[i]);
	}
}

function addZxOutTimeFormEdit(data){
	var numbers = gfiValue(zxOutProgressFormEditFieldSet,'zxOutTimeFormNumber');
	sfiValue(zxOutProgressFormEditFieldSet,'zxOutTimeFormNumber',numbers+1);
	zxOutTimeFormEdit = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		layout:"hbox",
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
			maxLength:10,
			anchor:'100%'
		},
		{
			fieldLabel:'计划到货数量',
			xtype:'textfield',
			name:'zxOutTime['+numbers+'].plan_amount',
			itemId:'zxOutTime['+numbers+'].plan_amount',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'实际交货时间',
			xtype:'datefield',
			format:'Y-m-d',
			name:'zxOutTime['+numbers+'].real_date',
			itemId:'zxOutTime['+numbers+'].real_date',
			maxLength:10,
			anchor:'100%'
		},
		{
			fieldLabel:'实际到货数量',
			xtype:'textfield',
			name:'zxOutTime['+numbers+'].real_amount',
			itemId:'zxOutTime['+numbers+'].real_amount',
			emptyText:'0',
			maxLength:20,
			anchor:'100%'
		},
		{
			fieldLabel:'排序',
			xtype:'numberfield',
			value:'0',
			name:'zxOutTime['+numbers+'].time_sort',
			itemId:'zxOutTime['+numbers+'].time_sort',
			maxLength:10,
			anchor:'100%'
		},
		{
			xtype:'button',
			text:'删除',
			cls:'delBtn',
			icon:delIcon,
			style:'background:#368ECE;border-color:#126DAF;float:right;margin-bottom:10px',
			labelAlign:'right',
			handler:function (){
				var _panel = this.ownerCt;
				zxOutTimeFormEditFieldSet.remove(_panel); 
				var zxOutTime_removed_flag = gfiValue(zxOutProgressFormEditFieldSet,'zxOutTime_removed_flag');
				if(null == zxOutTime_removed_flag || zxOutTime_removed_flag == ''){
					sfiValue(zxOutProgressFormEditFieldSet,'zxOutTime_removed_flag',","+numbers+",");
				}else{
					sfiValue(zxOutProgressFormEditFieldSet,'zxOutTime_removed_flag',zxOutTime_removed_flag+numbers+',');
				}
				resetTitle(zxOutTimeFormEditFieldSet,true);
			}
		}
		]
	});
	zxOutTimeFormEditFieldSet.add(zxOutTimeFormEditFieldSet.items.getCount(),zxOutTimeFormEdit);
	if(null != data){
		//获取表单中所有字段与值（key/value）
		var zxOutTimeFormEditData = zxOutTimeFormEdit.getForm().getFieldValues();
		//遍历表单中所有字段名称（key）
		for(var zxOutTimeFormEditField in zxOutTimeFormEditData){
			//获取表单中所有字段名称（key）并且截取对象后面的字段 目的与实体类中字段名称一致
			var zxOutTimeFormEditYField = zxOutTimeFormEditField.split(".")[1];
			//遍历服务器传递来的对象
			for(var dataKey in data){
				//判断当前字段是否等于服务器传过来的字段
				if(zxOutTimeFormEditYField == dataKey){
					//给表单每个字段赋值
					sfiValue(zxOutTimeFormEdit,zxOutTimeFormEditField,data[dataKey]);
				}
			}
		}
	}
	zxOutTimeFormEditFieldSet.afterLayout();
	resetTitle(zxOutTimeFormEditFieldSet,true);
}