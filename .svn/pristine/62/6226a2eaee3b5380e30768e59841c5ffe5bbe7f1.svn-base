var store;
var grid;
var out_type;
var out_properties;
Ext.onReady(function(){
	//读取外协类型下拉框数据
	out_type = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_working_type',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	//读取加工属性下拉框数据
	out_properties = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_working_properties',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_value', 'xt_data_dictionary_name'],
		autoLoad:true
	});
	/**查询区域可扩展**/
	var items = Ext.create('Ext.FormPanel',{
		xtype:'form',
		maxHeight:150,
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		layout:"column",
		items:[
		{
			fieldLabel:'外协类型',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:out_type,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'type',
			valueField:'xt_data_dictionary_value',
			displayField:'xt_data_dictionary_name',
			id:'type',
			name:'type',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'加工属性',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:out_properties,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'properties',
			valueField:'xt_data_dictionary_value',
			displayField:'xt_data_dictionary_name',
			id:'properties',
			name:'properties',
			anchor:'30%',
			labelAlign:'left'
		},
		{
			fieldLabel:'工件编码',
			xtype:'textfield',
			labelWidth:70,
			name:'workpiece_num',
			anchor:'30%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxOutApplyWorkpieceController/getZxOutApplyWorkpieceListByCondition?apply_id='+$("#out_apply_id").val(),[]);
	grid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:store,
		title:'查询结果',
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		selType:'checkboxmodel',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		loadMask:{
			msg:'正在加载...'
		},
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'工件编号',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.num;
				}
			},
			{
				header:'工件名称',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.name;
				}
			},
			{
				header:'单位',
				flex:1,
				dataIndex:'item',
				renderer:function(value){
					return value.unit;
				}
			},
			{
				header:'外协类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					return initComBoData(out_type,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'加工属性',
				flex:1,
				dataIndex:'properties',
				renderer:function(value){
					return initComBoData(out_properties,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'单台数量',
				flex:1,
				dataIndex:'single_amount'
			},
			{
				header:'总数量',
				flex:1,
				dataIndex:'amount'
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
			}
		],
		tbar:[
			 {
				text:'添加',
				tooltip:'添加',
				minWidth:tbarBtnMinWidth,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addZxOutApplyWorkpiece();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxOutApplyWorkpiece();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxOutApplyWorkpiece();
				}
			 },
			 {
				text:'检索',
				minWidth:tbarBtnMinWidth,
				cls:'searchBtn',
				icon:searchIcon,
				handler:function(){
					search();
				}
			 },
			 {
				text:'重置',
				tooltip:'重置',
				minWidth:tbarBtnMinWidth,
				icon:clearSearchIcon,
				handler:function(){
					searchForm.reset();
				}
			 }
		],
		bbar:getGridBBar(store)
	});
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[searchForm,grid]
	});
	store.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(store,searchForm));});
});
/**删除操作**/
function delZxOutApplyWorkpiece(){
	var model = grid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再删除');
		return;
	}
	var id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == id){
			id=model.selected.items[i].data.id;
		}else{
			id=id+","+model.selected.items[i].data.id;
		}
	}
	Ext.Msg.confirm('提示','确定删除该行数据？',function(btn){
		if(btn == 'yes'){
			var params = {id:id};
			ajaxRequest('../zxOutApplyWorkpieceController/delZxOutApplyWorkpiece',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**查询操作**/
function search(){
	initSearch(store,'../zxOutApplyWorkpieceController/getZxOutApplyWorkpieceListByCondition',searchForm);
}
