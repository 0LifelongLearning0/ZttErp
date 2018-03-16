var zxProjectNodeWinOut;
var zxProjectNodeFormOut;
var zxProjectNodeFormOutFieldSet;
var zxProjectWokingFormOutFieldSet;
var zxProjectWarehouseFormOutFieldSet;
function outZxProjectNode(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要出库的零件！');
		return;
	}
	initZxProjectNodeFormOut();
	reGetWidthAndHeight();
	zxProjectNodeWinOut = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'零件出库',
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
		items:zxProjectNodeFormOut,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxProjectNodeFormOut,'../zxProjectNodeController/outZxProjectNode',grid,zxProjectNodeWinOut,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxProjectNodeWinOut.show();
	
	loadFormDataCallBack(zxProjectNodeFormOut,'../zxProjectNodeController/getZxProjectNodeById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxProjectNodeFormOut(){
	zxWorkpieceFormOutFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'工件信息',
		items:[
       {
			layout:"column",
			items:[
			{
				columnWidth:.33,
				fieldLabel:'工件编号',
				xtype:'textfield',
				trigger1Cls:'x-form-ss-trigger',
				onTrigger1Click:function(){selectWorkpiece();},
				name:'workpiece_num',
				allowBlank: false,
				id:'workpiece_num',
				maxLength:255,
				anchor:'30%'
			},
			{
				columnWidth:.33,
				fieldLabel:'所属项目',
				xtype:'textfield',
				name:'project_name',
				id:'project_name',
				maxLength:100,
				readOnly:true,
				anchor:'80%'
			},
			{
				columnWidth:.33,
				fieldLabel:'工件名称',
				xtype:'textfield',
				name:'workpiece_name',
				id:'workpiece_name',
				maxLength:100,
				readOnly:true,
				anchor:'80%'
			}]
		}]
	});
	
	zxProjectNodeFormOutFieldSet = Ext.create('top.Ext.form.FieldSet',{
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
			},{
				fieldLabel:'工件',
				xtype:'textfield',
				name:'workpiece_id',
				id:'workpiece_id',
				maxLength:100,
				hidden:true,
				anchor:'20%'
			},
			{
				fieldLabel:'项目',
				xtype:'textfield',
				name:'project_id',
				id:'project_id',
				maxLength:32,
				hidden:true,
				anchor:'20%'
			},
			{
				columnWidth:.33,
				fieldLabel:'加工属性',
				xtype:"combo",
				queryMode:'local', 
				store:proptiesList,
				triggerAction:"all",
	            editable:false,
	            emptyText:'请选择',
	            valueField:"xt_data_dictionary_value",
	            displayField:"xt_data_dictionary_name",
				name:'propties',
				anchor:'60%'
			},
			{
				columnWidth:.33,
				fieldLabel:'材质',
				xtype:"textfield",
				name:'stuff',
				maxLength:255
			},
			{
				columnWidth:.33,
				fieldLabel:'计划入库时间',
				xtype:'datefield',
				format:'Y-m-d',
				name:'plan_date',
				maxLength:10,
				anchor:'20%',
				margin:'5 0 5 0'
			}
			]
		},
		{
	       layout:"column",
	       items:[
			{
				columnWidth:.33,
				fieldLabel:'单台数量',
				xtype:'textfield',
				name:'single_amount',
				id:'single_amount',
				maxLength:20,
				anchor:'20%',
				margin:'5 0 5 0',
			    listeners:{
			       change : function(field,newValue,oldValue){
			    	   var amount = 0;
			    	   var make_amount = top.Ext.getCmp('all_amount').getValue();
			    	   if(newValue != '' && make_amount != ''){
			    		   amount = newValue * make_amount;
			    	   }
			    	   top.Ext.getCmp('amounts').setValue(amount);
			       }
				}
			},
			{
				columnWidth:.33,
				fieldLabel:'制作台数',
				xtype:'textfield',
				name:'all_amount',
				id:'all_amount',
				maxLength:20,
				anchor:'20%',
				margin:'5 0 5 0',
			    listeners:{
			       change : function(field,newValue,oldValue){
			    	   var amount = 0;
			    	   var single_amount = top.Ext.getCmp('single_amount').getValue();
			    	   if(newValue != '' && single_amount != ''){
			    		   amount = newValue * single_amount;
			    	   }
			    	   top.Ext.getCmp('amounts').setValue(amount);
			       }
				}
			},
			{
				columnWidth:.33,
				fieldLabel:'总数量',
				xtype:'textfield',
				name:'amount',
				id:'amounts',
				maxLength:20,
				readOnly:true,
				margin:'5 0 5 0'
			}]
		},
		{
			xtype:'numberfield',
			hidden:true,
			value:'0',
			itemId:'zxProjectWokingFormNumber'
		},
		{
			xtype:'textfield',
			hidden:true,
			name:'zxProjectWoking_removed_flag',
			itemId:'zxProjectWoking_removed_flag'
		}
		]
	});
	zxProjectWarehouseFormOutFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'出入库信息',
		items:[
		{
	       layout:"column",
	       items:[
			{
				columnWidth:.33,
				fieldLabel:'出库时间',
				xtype:'datetimefield',
				format:'Y-m-d H:i:s',
				name:'out_warehouse_date',
				maxLength:20,
				anchor:'20%',
				margin:'5 0 5 0'
			},
			{
				columnWidth:.33,
				fieldLabel:'出库数量',
				xtype:'textfield',
				name:'out_warehuse_amount',
				maxLength:32,
				anchor:'20%',
				margin:'5 0 5 0'
			}
			]
		}
		]
	});
	zxProjectNodeFormOut = Ext.create('top.Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		/**新方法使用结束**/
		fieldDefaults:{
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'5 0 5 0'
		},
		items:[
		    zxWorkpieceFormOutFieldSet,
			zxProjectNodeFormOutFieldSet,
			zxProjectWarehouseFormOutFieldSet
		]
	});
}
function callFnUpdate(form, action){
	var zxWorkpiece = action.result.data.workpiece;
	top.Ext.getCmp('project_name').setValue(zxWorkpiece.project_name);
	top.Ext.getCmp('workpiece_name').setValue(zxWorkpiece.name);
	top.Ext.getCmp('workpiece_num').setValue(zxWorkpiece.num);
}
