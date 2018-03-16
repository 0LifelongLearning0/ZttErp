//初始化处理人
var supplierGrid;
var supplierStore;
var supplierWin;
var supplierFormSearch;
var zx_supplier_classify;
var zx_pay_type;
var zx_supplier_type;

zx_supplier_classify = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
    fields:['value','text'],  
	data:[["A"," A"],["B","B"],["C","C"],["D","D"]]
});
zx_pay_type = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
    fields:['value','text'],  
	data:[["1","全款"],["2","货到付款"],["3","预付款"]]
});
zx_supplier_type = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
    fields:['value','text'],  
	data:[["1","供应商"],["2","加工商"]]
});
function initSupplier(supplier_id,supplier_name){
	supplierStore = getGridJsonStore('../zxSupplierController/getZxSupplierListByCondition',[{}]);
	/**查询区域可扩展**/
	var formItems = Ext.create('top.Ext.FormPanel',{
		maxHeight:220,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
			layout:'table',
			xtype:'form',
			anchor:'100%',
			items:[
			{
				fieldLabel:'供应商名称',
				xtype:'textfield',
				name:'name',
				width:320
			},
			{
				fieldLabel:'类别',
				xtype:'combo',
				labelWidth:100,
				emptyText:'请选择',
				store:zx_supplier_classify,
				mode:'local',
				triggerAction:'all',
				editable:false,
				hiddenName:'classify',
				valueField:'value',
				displayField:'text',
				name:'classify',
				anchor:'30%',
				labelAlign:'left'
			},
			{
				fieldLabel:'付款方式',
				xtype:'combo',
				labelWidth:100,
				emptyText:'请选择',
				store:zx_pay_type,
				mode:'local',
				triggerAction:'all',
				editable:false,
				hiddenName:'pay_type',
				valueField:'value',
				displayField:'text',
				name:'pay_type',
				anchor:'30%',
				labelAlign:'left'
			},
			{
				fieldLabel:'供应商类型',
				xtype:'combo',
				labelWidth:100,
				emptyText:'请选择',
				store:zx_supplier_type,
				mode:'local',
				triggerAction:'all',
				editable:false,
				hiddenName:'type',
				valueField:'value',
				displayField:'text',
				name:'type',
				anchor:'30%',
				labelAlign:'left'
			}
			]
		}
		]
	});
	supplierFormSearch = initSearchFormByUserdefined('north',formItems,true,'left');
	supplierGrid = Ext.create('top.Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:supplierStore,
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		border:true,
		selType:'checkboxmodel',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		title:'查询结果',
		loadMask:{
			msg:'正在加载...'
		},
		tbar:[
			 {
				text:'检 索',
				tooltip:'检索',
				minWidth:tbarBtnMinWidth,
				cls:'searchBtn',
				icon:searchIcon,
				handler:function(){
					searchSupplier();
				}
			 },
			 {
				text:'重 置',
				tooltip:'重置',
				minWidth:tbarBtnMinWidth,
				icon:clearSearchIcon,
				handler:function(){
					supplierFormSearch.reset();
				}
			 }
		],
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'供应商名称',
				flex:1,
				dataIndex:'name'
			},
			{
				header:'类别',
				flex:1,
				dataIndex:'classify'
			},
			{
				header:'供应商代码',
				flex:1,
				dataIndex:'num'
			},
			{
				header:'付款方式',
				flex:1,
				dataIndex:'pay_type',
				renderer:function(value){
					if(value == 1){
						return '全款';
					}else if(value == 2){
						return '货到付款';
					}else if(value == 3){
						return '预付款';
					}else{
						return '缺省'
					}
				}
			},
			{
				header:'类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					if(value == 1){
						return '供应商';
					}else if(value == 2){
						return '加工商';
					}else{
						return '缺省'
					}
				}
			},
			{
				header:'是否验厂',
				flex:1,
				dataIndex:'is_yanchang',
				renderer:function(value){
					if(value == '1'){
						return '是';
					}else if(value == '0'){
						return '否';
					}else{
						return '缺省'
					}
				}
			}
		],
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				var name = supplierGrid.getSelectionModel().selected.items[0].data.name;
				var id = supplierGrid.getSelectionModel().selected.items[0].data.id; 
				var str = "[<font color=red><br>供应商名称:"+name+"</font>]";
				top.Ext.Msg.confirm('提示','确定要选择:<br>'+str+'？',function(btn){
					if(btn == 'yes'){
						Ext.getCmp(supplier_id).setValue(id);
						Ext.getCmp(supplier_name).setValue(name);
						supplierWin.close();
					}
				});
			}
		},
		bbar:getGridTopBBar(supplierStore)
	});
	supplierStore.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(supplierStore,supplierFormSearch));});
	reGetWidthAndHeight();
	supplierWin = Ext.create('top.Ext.Window',{
		layout:'border',
		title:'供应商列表',
		width:clientWidth,                    
		height:clientHeight, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		items:[supplierFormSearch,supplierGrid],
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	supplierWin.show();
	if(flag == 2 && type == 1){
		
	}else{
		//隐藏按钮
		top.Ext.getCmp('supplierGridBtn').setVisible(false);
	}
}

function searchSupplier(){
	initSearch(supplierStore,'../zxSupplierController/getZxSupplierListByCondition',supplierFormSearch); 
}