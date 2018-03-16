var store;
var grid;
var zx_loan_bill_status;
var lc_process_status_combo;
Ext.onReady(function(){
	lc_process_status_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
        data:[["yes","同意"],["no","驳回"],["2","已关闭"]]
	});
	//状态下拉框数据
	zx_loan_bill_status = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy( { 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_loan_bill_status',
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
		layout:'column',
		items:[
		{
			layout:'table',
			xtype:'form',
			items:[
			{
				fieldLabel:'申请时间',
				xtype:'datefield',
				labelWidth:70,
				format:'Y-m-d',
				editable:false,
				id:'create_time_st',
				name:'create_time_st',
				labelAlign:'left'
			},
			{
				fieldLabel:'至',
				xtype:'datefield',
				labelWidth:15,
				editable:false,
				format:'Y-m-d',
				id:'create_time_et',
				name:'create_time_et',
				labelAlign:'center'
			}
			]
		},
		{
			fieldLabel:'状态',
			xtype:"combo",
			queryMode:'local', 
			store:zx_loan_bill_status,
			triggerAction:"all",
            editable:false,
			readonly:true,
            emptyText:'请选择',
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name",
            id:'status',
			name:'status',
			anchor:'20%',
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxLoanBillController/getZxLoanBillListByCondition',[]);
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
				header:'序列号',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'借款人',
				flex:1,
				hidden:true,
				dataIndex:'user_id'
			},
			{
				header:'状态',
				flex:1,
				dataIndex:'status',
				renderer:function(value){
					return initComBoData(zx_loan_bill_status,value,'xt_data_dictionary_value', 'xt_data_dictionary_name');
				}
			},
			{
				header:'借款人',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'借款理由',
				flex:1,
				dataIndex:'reason'
			},
			{
				header:'借款金额',
				flex:1,
				dataIndex:'balance'
			},
			{
				header:'中文大写',
				flex:1,
				dataIndex:'balance_cn'
			},
			{
				header:'填写时间',
				flex:1,
				hidden:true,
				dataIndex:'create_time'
			},
			{
				header:'预计结算日',
				flex:1,
				dataIndex:'estimate_settle_date'
			},
			{
				header:'审批通过时间',
				flex:1,
				hidden:true,
				dataIndex:'approve_time'
			},
			{
				header:'查看审批记录',
				align:'center',
				xtype:'widgetcolumn',
				widget:{
	                xtype:'button',
	                text:'审批记录',
	                handler:function(rec){	
	  					var id = rec.getWidgetRecord().data.id;
	  					var status = rec.getWidgetRecord().data.status;
	  					initLcApprovalWin(id,status);
				    }
	            }
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
					addZxLoanBill();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxLoanBill();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxLoanBill();
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
			 },
			 grid_toolbar_moretext_gaps,
			 {
				 text:moretext,
				 tooltip:moretexttooltip,
				 icon:listIcon,
				 iconAlign:'left',
				 menu:[
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxLoanBill();
					}
				 },
				 {
					text:'申请',
					tooltip:'申请',
					glyph:0xf078,
					handler:function(){
						applyZxLoan();
					}
				 }
				 ]
			 }
		],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				detailZxLoanBill();
			}
		}
	});
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[searchForm,grid]
	});
	store.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(store,searchForm));});
});
/**删除操作**/
function delZxLoanBill(){
	var model = grid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再删除');
		return;
	}
	var id;
	for(var i = 0; i < model.selected.length; i++){
		var status = model.selected.items[i].data.status;
		if(status != 1){
			msgTishi('只有待申请状态的借款单可删除！');
			return;
		}
		if(null == id){
			id=model.selected.items[i].data.id;
		}else{
			id=id+","+model.selected.items[i].data.id;
		}
	}
	Ext.Msg.confirm('提示','确定删除该行数据？',function(btn){
		if(btn == 'yes'){
			var params = {id:id};
			ajaxRequest('../zxLoanBillController/delZxLoanBill',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**查询操作**/
function search(){
	initSearch(store,'../zxLoanBillController/getZxLoanBillListByCondition',searchForm);
}

//申请
function applyZxLoan() {
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要申请的行！');
		return;
	}else if(record.length > 1) {
		msgTishi('请不要选择多行！');
		return;
	} 
	var status = record.items[0].data.status;
	if(status != 1){
		msgTishi('请选择待申请状态的借款单');
		return;
	}
	var systemUID;
	if(systemUID == ""){
		systemUID = record.items[0].data.xt_userinfo_id;
	}else{
		systemUID = systemUID + "," + record.items[0].data.xt_userinfo_id;
	}
	Ext.Msg.confirm('提示','确定提出申请该行数据？',function(btn){
		if(btn == 'yes'){
			var id = record.items[0].data.id;
			var params = {id:id};
			ajaxRequest('../zxLoanBillController/applyZxLoanApply',grid,params,'正在执行操作中！请稍后...');
		}
	});
}
/**
 * 审批记录
 */
var lcApprovalWin;
function initLcApprovalWin(id,status){
	if(status == 1){
		msgTishi('未申请的数据无审批记录！');
		return;
	}
	initLcApprovalGrid(id);
	reGetWidthAndHeight();
	lcApprovalWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.8,                    
		height:clientHeight*0.8,
		headerPosition:'top',
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'审批记录',
		items:lcApprovalGrid,
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		}
	});
	lcApprovalWin.show();
}

function initLcApprovalGrid(id){
	lcApprovalStore = getGridJsonStore('../lcApprovalController/getLcApprovalListByCondition?model_biz_id='+id,[]);
	lcApprovalGrid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:lcApprovalStore,
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
		title:'审批列表',
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'批审状态',
				flex:1,
				dataIndex:'lc_status_id',
				renderer:function(value){
					return initComBoData(lc_process_status_combo,value,"value","text");
				}
			},
			{
				header:'审批内容',
				flex:1,
				dataIndex:'lc_approval_remark'
			},
			{
				header:'审批时间',
				flex:1,
				dataIndex:'lc_approval_time'
			},
			{
				header:'批审人',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			}
		],
		bbar:getGridBBar(lcApprovalStore)
	});
}
