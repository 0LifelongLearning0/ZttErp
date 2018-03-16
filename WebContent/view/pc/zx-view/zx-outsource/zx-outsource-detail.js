var zxOutsourceWinDetail;
var zxOutsourceFormDetail;
var zxOutsourceFormDetailFieldSet;
var zxOutsourceTimeFormDetailFieldSet;
var zxOutsourceWorkpieceFormDetailFieldSet;
var zxOutsourceConcordatFormDetailFieldSet;
function detailZxOutsource(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的一项！');
		return;
	}
	initZxOutsourceFormDetail();
	reGetWidthAndHeight();
	zxOutsourceWinDetail = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*1.1,                    
		height:clientHeight, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'明细信息',
		headerPosition:'top',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOutsourceFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOutsourceWinDetail.show();
	
	loadFormDataCallBack(zxOutsourceFormDetail,'../zxOutsourceController/getZxOutsourceById?id='+ record.items[0].data.id,callFnDetail);
}
function initZxOutsourceFormDetail(){
	zxOutsourceWorkpieceFormDetailFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'工件信息',
		items:[
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
							allowBlank: false,
							id:'workpiece_num',
							maxLength:255,
							anchor:'30%'
						}
						]
					},
					{
						columnWidth:.25,
						items:[{
							fieldLabel:'所属项目',
							xtype:'textfield',
							name:'project_name',
							id:'project_name',
							maxLength:100,
							readOnly:true,
							anchor:'20%'
						}]
					},
					{
						columnWidth:.25,
						items:[{
							fieldLabel:'工件名称',
							xtype:'textfield',
							name:'workpiece_name',
							id:'workpiece_name',
							maxLength:100,
							readOnly:true,
							anchor:'20%'
						}]
					},
					{
						columnWidth:.25,
						items:[{
							fieldLabel:'单位',
							xtype:'textfield',
							name:'workpiece_unit',
							id:'workpiece_unit',
							maxLength:100,
							readOnly:true,
							anchor:'20%'
						}]
					}
					]
				}
			]
	});
	
	zxOutsourceFormDetailFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
		{
			layout:"column",
			items:[
			{
				fieldLabel:'ID',
				xtype:'textfield',
				hidden:true,
				name:'id',
				allowBlank:false,
				maxLength:32,
				hidden:true,
				anchor:'100%'
			},
			{
				fieldLabel:'工件',
				xtype:'textfield',
				name:'workpiece_id',
				id:'workpiece_id',
				maxLength:100,
				hidden:true,
				anchor:'20%'
			},
			{
				fieldLabel:'采购订单',
				xtype:'textfield',
				name:'buy_id',
				id:'buy_id',
				maxLength:100,
				hidden:true,
				anchor:'20%'
			},
			{
				fieldLabel:'采购合同',
				xtype:'textfield',
				name:'concordat_id',
				id:'concordat_id',
				maxLength:100,
				hidden:true,
				anchor:'20%'
			},
			{
				fieldLabel:'加工单位',
				xtype:'textfield',
				name:'machine_id',
				id:'machine_id',
				maxLength:100,
				hidden:true,
				anchor:'20%'
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'总数量',
					xtype:'textfield',
					format:'Y-m-d',
					name:'amount',
					maxLength:26,
					anchor:'20%'
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'需求日期',
					xtype:'datefield',
					format:'Y-m-d',
					name:'need_date',
					maxLength:20,
					anchor:'20%'
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'计划交货时间',
					xtype:'datefield',
					format:'Y-m-d',
					name:'plan_date',
					maxLength:20,
					anchor:'20%'
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'加工单位',
					xtype:'textfield',
					name:'machine_name',
					id:'machine_name',
					maxLength:255,
					anchor:'30%'
				}]
			}
			]
		},
		{
		       layout:"column",
		       items:[
				{
					columnWidth:.3,
					items:[{
						fieldLabel:'状态',
						xtype:"combo",
						queryMode:'local', 
						store:outsource_status,
						triggerAction:"all",
			            editable:false,
			            emptyText:'请选择',
			            valueField:"xt_data_dictionary_value",
			            displayField:"xt_data_dictionary_name",
						name:'status',
						anchor:'20%'
					}]
				}
				]
			},
		{
			fieldLabel:'备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注',
			xtype:'textarea',
			name:'remark',
			maxLength:65535,
			height:20,
			anchor:'100%'
		},
		{
			xtype:'numberfield',
			hidden:true,
			value:'0',
			itemId:'zxOutsourceTimeFormNumber'
		},
		{
			xtype:'textfield',
			hidden:true,
			name:'zxOutsourceTime_removed_flag',
			itemId:'zxOutsourceTime_removed_flag'
		} 
		]
	});

	zxOutsourceConcordatFormDetailFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'合同与订单',
		items:[
		{
			layout:"column",
			items:[
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'合同号',
					xtype:'textfield',
					name:'concordat_num',
					id:'concordat_num',
					maxLength:255,
					anchor:'30%'
				}
				]
			},
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'采购订单号',
					xtype:'textfield',
					name:'buy_num',
					id:'buy_num',
					maxLength:255,
					anchor:'30%' 
				}]
			}
			]
		}
		]
	});
	zxOutsourceTimeFormDetailFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'外协分批到货'
	});
	zxOutsourceFormDetail = Ext.create('top.Ext.FormPanel',{
		labelWidth:50,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		/**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        /**新方法使用结束**/ 
		fieldDefaults:{
			labelWidth:90,
			readOnly:true,
			labelAlign:'left',
			margin:'4 5 4 5'
		},
		items:[
		        zxOutsourceWorkpieceFormDetailFieldSet,
				zxOutsourceFormDetailFieldSet,
				zxOutsourceConcordatFormDetailFieldSet,
				zxOutsourceTimeFormDetailFieldSet
		       ]
	});
}
function callFnDetail(form, action){
	var zxOutsourceTime = action.result.data.zxOutsourceTime;
	for(var i = 0; i < zxOutsourceTime.length; i++){
		addUpdateZxOutsourceTimeFormDetail(zxOutsourceTime[i]);
	}
	var zxWorkpiece = action.result.data.workpiece;
	var zxMachine = action.result.data.machine;
	top.Ext.getCmp('project_name').setValue(zxWorkpiece.project_name);
	top.Ext.getCmp('workpiece_name').setValue(zxWorkpiece.name);
	top.Ext.getCmp('workpiece_num').setValue(zxWorkpiece.num);
	top.Ext.getCmp('workpiece_unit').setValue(zxWorkpiece.unit);
	top.Ext.getCmp('machine_name').setValue(zxMachine.name);
}
function addUpdateZxOutsourceTimeFormDetail(data){
	var numbers = gfiValue(zxOutsourceFormDetailFieldSet,'zxOutsourceTimeFormNumber');
	sfiValue(zxOutsourceFormDetailFieldSet,'zxOutsourceTimeFormNumber',numbers+1);
	zxOutsourceTimeFormDetail = Ext.create('top.Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		layout : "column",
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
			name:'zxOutsourceTime['+numbers+'].id',
			itemId:'zxOutsourceTime['+numbers+'].id',
			maxLength:32,
			hidden:true,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'外协ID',
			xtype:'textfield',
			columnWidth: .25,
			name:'zxOutsourceTime['+numbers+'].outsource_id',
			itemId:'zxOutsourceTime['+numbers+'].outsource_id',
			maxLength:32,
			hidden:true,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'计划交货时间',
			xtype:'datefield',
			columnWidth: .25,
			format:'Y-m-d',
			name:'zxOutsourceTime['+numbers+'].plan_date',
			itemId:'zxOutsourceTime['+numbers+'].plan_date',
			maxLength:10,
			anchor:'80%'
		},
		{
			fieldLabel:'实际到货时间',
			xtype:'datefield',
			columnWidth: .25,
			format:'Y-m-d',
			name:'zxOutsourceTime['+numbers+'].real_date',
			itemId:'zxOutsourceTime['+numbers+'].real_date',
			maxLength:10,
			anchor:'80%'
		},
		{
			fieldLabel:'排序',
			xtype:'numberfield',
			columnWidth: .25,
			value:'0',
			itemId:'zxOutsourceTime['+numbers+'].time_sort',
			name:'zxOutsourceTime['+numbers+'].time_sort',
			maxLength:10,
			anchor:'100%'
		}
		]
	});
	zxOutsourceTimeFormDetailFieldSet.add(zxOutsourceTimeFormDetailFieldSet.items.getCount(),zxOutsourceTimeFormDetail);
	if(null != data){
		//获取表单中所有字段与值（key/value）
		var zxOutsourceTimeFormDetailData = zxOutsourceTimeFormDetail.getForm().getFieldValues();
		//遍历表单中所有字段名称（key）
		for(var zxOutsourceTimeFormDetailField in zxOutsourceTimeFormDetailData){
			//获取表单中所有字段名称（key）并且截取对象后面的字段 目的与实体类中字段名称一致
			var zxOutsourceTimeFormDetailYField = zxOutsourceTimeFormDetailField.split(".")[1];
			//遍历服务器传递来的对象
			for(var dataKey in data){
				//判断当前字段是否等于服务器传过来的字段
				if(zxOutsourceTimeFormDetailYField == dataKey){
					//给表单每个字段赋值
					sfiValue(zxOutsourceTimeFormDetail,zxOutsourceTimeFormDetailField,data[dataKey]);
				}
			}
		}
	}
	zxOutsourceTimeFormDetailFieldSet.afterLayout();
	resetTitle(zxOutsourceTimeFormDetailFieldSet,true);
}
