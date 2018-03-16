var zxOutApplyWorkpieceWinAdd;
var zxOutApplyWorkpieceFormAdd;
var zxWorkpieceFormAddFieldSet;
var zxOutApplyWorkpieceFormAddFieldSet;
function addZxOutApplyWorkpiece(){
	if($("#out_apply_status").val() != '1'){
		msgTishi('待申请状态才可以操作工件！');
		return;
	}
	initZxOutApplyWorkpieceFormAdd();
	Ext.getCmp('apply_id').setValue($("#out_apply_id").val());
	zxOutApplyWorkpieceWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:1065,
		height:500,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加工件',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOutApplyWorkpieceFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxOutApplyWorkpieceFormAdd,'../zxOutApplyWorkpieceController/addZxOutApplyWorkpiece',grid,zxOutApplyWorkpieceWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOutApplyWorkpieceWinAdd.show();
	
}
function initZxOutApplyWorkpieceFormAdd(){
	zxWorkpieceFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'工件信息',
		items:[
       {
			layout:"column",
			items:[
				{
					fieldLabel:'工件编号',
					xtype:'textfield',
					trigger1Cls:'x-form-ss-trigger',
					onTrigger1Click:function(){selectWorkpiece();},
					name:'workpiece_num',
					allowBlank: false,
					id:'workpiece_num',
					maxLength:255,
					width:320
				},
				{
					fieldLabel:'工件名称',
					xtype:'textfield',
					name:'workpiece_name',
					id:'workpiece_name',
					maxLength:100,
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'单位',
					xtype:'textfield',
					name:'workpiece_unit',
					id:'workpiece_unit',
					maxLength:100,
					readOnly:true,
					width:320
				},
				{
					fieldLabel:'工件标识',
					xtype:'textfield',
					name:'workpiece_id',
					id:'workpiece_id',
					hidden:true
				}
			]
		}
	]
	});
	zxOutApplyWorkpieceFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
       {
			layout:"column",
			items:[
			{
				fieldLabel:'外协类型',
				xtype:"combo",
				queryMode:'local', 
				store:out_type,
				triggerAction:"all",
	            editable:false,
	            emptyText:'请选择',
	            valueField:"xt_data_dictionary_value",
	            displayField:"xt_data_dictionary_name",
				name:'type',
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
				fieldLabel:'加工属性',
				xtype:"combo",
				queryMode:'local', 
				store:out_properties,
				triggerAction:"all",
			    editable:false,
			    emptyText:'请选择',
			    valueField:"xt_data_dictionary_value",
			    displayField:"xt_data_dictionary_name",
				name:'properties',
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
	
	zxOutApplyWorkpieceFormAdd = Ext.create('Ext.FormPanel',{
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
			zxWorkpieceFormAddFieldSet,
			zxOutApplyWorkpieceFormAddFieldSet
		]
	});
}
