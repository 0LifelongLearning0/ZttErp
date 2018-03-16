var store;
var grid;
var zx_supplier_classify;
var zx_zhiwu;
var zx_pay_type;
var zx_supplier_type;
var zx_is_connext;
var supplier_id;
var sdfURL;
var isAdmin;
var yc_num;
Ext.onReady(function(){
	zx_supplier_classify = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["","---请选择---"],["A"," A"],["B","B"],["C","C"],["D","D"]]
	});
	zx_zhiwu = new Ext.data.Store({
		singleton:true, 
		proxy:new Ext.data.HttpProxy({ 
			url:'../xtDataDictionaryController/getXtDataDictionaryByKey?key=zx_zhiwu',
			reader:new Ext.data.JsonReader({
				root:'items',
				type:'json'
			})
		}),
		fields:['xt_data_dictionary_id', 'xt_data_dictionary_name'],
		autoLoad:true 
	});
	zx_pay_type = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["1","全款"],["2","货到付款"],["3","预付款"]]
	});
	zx_supplier_type = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["","---请选择---"],["1","供应商"],["2","加工商"]]
	});
	zx_is_connext = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["1","是"],["0","否"]]
	});
	$.ajax({  
        type : "post",  
         url : '../zxJudgeResultController/getSdfUrl',  
         async : true,  
         success : function(data){
        	 data = eval('(' + data +')');
        	 sdfURL = data.sdfURL;
        	 isAdmin = data.isAdmin;
         }
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
			fieldLabel:'供应商名称',
			xtype:'textfield',
			labelWidth:70,
			id:'s_name',
			name:'name',
			anchor:'30%',
			columnWidth: 0.25,
			labelAlign:'left'
		},
		{
			fieldLabel:'类别',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:zx_supplier_classify,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'classify',
			valueField:'value',
			displayField:'text',
			name:'classify',
			maxLength:32,
			columnWidth: 0.25,
			labelAlign:'left'
		},
		{
			fieldLabel:'类型',
			xtype:'combo',
			labelWidth:70,
			emptyText:'请选择',
			store:zx_supplier_type,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'type',
			valueField:'value',
			displayField:'text',
			name:'type',
			maxLength:32,
			columnWidth: 0.25,
			labelAlign:'left'
		}
		]
	});
	initSearchForm('north',items,false,'left');
	store = getGridJsonStore('../zxSupplierController/getZxSupplierListByCondition',[]);
	grid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:store,
		title:'查询结果',
		columnLines:true,
		selType:'cellmodel',
		multiSelect:false,
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
				header:'ID',
				flex:1,
				hidden:true,
				dataIndex:'id'
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
				header:'地址',
				flex:1,
				hidden:true,
				dataIndex:'address'
			},
			{
				header:'联系人',
				flex:1,
				hidden:true,
				dataIndex:'contact_person'
			},
			{
				header:'职务',
				flex:1,
				hidden:true,
				dataIndex:'title_name'
			},
			{
				header:'传真',
				flex:1,
				hidden:true,
				dataIndex:'fax'
			},
			{
				header:'联系方式',
				flex:1,
				hidden:true,
				dataIndex:'phone'
			},
			{
				header:'QQ',
				flex:1,
				hidden:true,
				dataIndex:'qq'
			},
			{
				header:'web',
				flex:1,
				hidden:true,
				dataIndex:'web'
			},
			{
				header:'邮箱',
				flex:1,
				hidden:true,
				dataIndex:'email'
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
						return ''
					}
				}
			},
			{
				header:'开户银行',
				flex:1,
				hidden:true,
				dataIndex:'bank_id'
			},
			{
				header:'银行账号',
				flex:1,
				hidden:true,
				dataIndex:'bank_account'
			},
			{
				header:'供应商经营状况',
				flex:1,
				hidden:true,
				dataIndex:'operation_status'
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
						return ''
					}
				}
			},
			{
				header:'是否联系',
				flex:1,
				dataIndex:'is_connect',
				hidden:true,
				renderer:function(value){
					if(value == '1'){
						return '是';
					}else if(value == '0'){
						return '否';
					}else{
						return ''
					}
				}
			},
			{
				header:'验厂状态',
				flex:1,
				dataIndex:'yc_status',
				renderer:function(value){
					if(value == '0'){
						return '<font color="red">未验厂</font>';
					}else if(value == '1'){
						return '申请保存中';
					}else if(value == '2'){
						return '申请审核中';
					}else if(value == '3'){
						return '申请退回';
					}else if(value == '4'){
						return '验厂中';
					}else if(value == '5'){
						return '验厂报告审核中';
					}else if(value == '6'){
						return '验厂报告退回';
					}else if(value == '7'){
						return '验厂完成';
					}else{
						return ''
					}
				}
			},
			{
				header:'验厂结果',
				flex:1,
				dataIndex:'yc_grade',
				renderer:function(value){
					if(value == '1'){
						return '合格';
					}else if(value == '2'){
						return '<font color="red">限期整改</font>';
					}else if(value == '3'){
						return '<font color="red">不合格</font>';
					}else{
						return ''
					}
				}
			},
			{
				header:'评审周期',
				flex:1,
				dataIndex:'judge_cycle',
				renderer:function(value){
					if(value == '1'){
						return '年';
					}else if(value == '2'){
						return '季度';
					}else if(value == '3'){
						return '月';
					}else{
						return ''
					}
				}
			},
			{
				header:'上次评审时间',
				flex:1,
				dataIndex:'judge_date',
				renderer:function(value){
					if(value > 0)
					{
						var year = Math.floor(value/12);
						var month = value%12;
						return month==0?(year - 1) + "-12":year + "-" + (month < 10?"0" + month:month);
					}
				}
			},
			{
				header:'创建日期',
				flex:1,
				dataIndex:'create_date'
			},
			{
				header:'操作',
				flex:1,
				align:'center',
			 	renderer:function(value, metaData, record, rowIndex, colIndex,store){
			 		var yc_status = record.data.yc_status;
			 		var is_judge = record.data.is_judge;
			 		var sid = record.data.id;
			 		
			 		yc_status = yc_status==''?'0':yc_status; 
			 		var text = '';
			 		var type = 0;
			 		if(yc_status == '0'){
			 			type = 1;
			 			text = '验厂申请';
			 		}else if(yc_status == '1'||yc_status == '2'||yc_status == '3'){
			 			type = 2;
			 			text = '验厂申请';
			 		}else if(yc_status == '4'||yc_status == '5'||yc_status == '6'){
			 			type = 3;
			 			text = '验厂报告';
			 		}else if(yc_status == '7'&&is_judge == '1'){
			 			type = 4;
			 			text = '再评审报告';
			 		}
			 		var button = '';
			 		if(type > 0)
			 			button = '<a onclick="writeReport('+ type +','+ record.data.yc_num +','+yc_status +',\''+ sid +'\')" title="'+ text +'" class="x-btn x-unselectable x-btn-default-small x-border-box" style="width:120px;" hidefocus="on" unselectable="on" role="button" aria-hidden="false" aria-disabled="false" id="button-1091" tabindex="-1" data-componentid="button-1091" data-tabindex-value="0" data-tabindex-counter="1"><span id="button-1091-btnWrap" data-ref="btnWrap" role="presentation" unselectable="on" style="table-layout:fixed;" class="x-btn-wrap x-btn-wrap-default-small "><span id="button-1091-btnEl" data-ref="btnEl" role="presentation" unselectable="on" style="" class="x-btn-button x-btn-button-default-small x-btn-text  x-btn-icon x-btn-icon-left x-btn-button-center "><span id="button-1091-btnIconEl" data-ref="btnIconEl" role="presentation" unselectable="on" class="x-btn-icon-el x-btn-icon-el-default-small  " style="background-image:url(../deng/images/grid/using/detail.png);"></span><span id="button-1091-btnInnerEl" data-ref="btnInnerEl" unselectable="on" class="x-btn-inner x-btn-inner-default-small">'+ text +'</span></span></span></a>';

			 		return button;
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
					addZxSupplier();
				}
			 },
			 {
				text:'编辑',
				tooltip:'编辑',
				minWidth:tbarBtnMinWidth,
				cls:'updateBtn',
				icon:editIcon,
				handler:function(){
					updateZxSupplier();
				}
			 },
			 {
				text:'删除',
				tooltip:'删除',
				minWidth:tbarBtnMinWidth,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delZxSupplier();
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
					text:'修改评审周期',
					tooltip:'修改评审周期',
					glyph:0xf03b,
					handler:function(){
						 editCircle();
					}
				 },
				 '-',
		         {
					text:'验厂记录',
					tooltip:'验厂记录',
					glyph:0xf03b,
					handler:function(){
						document.location.href="../zxJudgeResultController/loadZxJudgeResult";
					}
				 },
				 {
					text:'再评审记录',
					tooltip:'再评审记录',
					glyph:0xf03b,
					handler:function(){
						document.location.href="../zxJudgeAgainResultController/loadZxJudgeAgainResult";
					}
				 },
				 '-',
				 {
					text:'复制一行并生成记录',
					tooltip:'复制一行并生成记录',
					glyph:0xf0ea,
					handler:function(){
						copyZxSupplier();
					}
				 },
				 {
					text:'明 细',
					tooltip:'明 细',
					glyph:0xf03b,
					handler:function(){
						detailZxSupplier();
					}
				 },
				 '-',
				 {
						text:'导 入',
						tooltip:'导 入',
						glyph:0xf1c3,
						handler:function(){
							importExcel('zx_judge_pic','zx_judge_attach',2,'xls');
						}
					 },
				 {
					text:'导 出',
					tooltip:'导 出',
					glyph:0xf1c3,
					handler:function(){
						exportZxSupplier(grid,'../zxSupplierController/exportZxSupplier');
					}
				 },
				 {
					text:'打 印',
					tooltip:'打 印',
					glyph:0xf02f,
					handler:function(){
						printerGrid(grid);
					}
				 },
				 '-',
				 {
					text:'全 选',
					tooltip:'全 选',
					glyph:0xf046,
					handler:function(){selectAll(grid);}
				 },
				 {
					text:'反 选',
					tooltip:'反 选',
					glyph:0xf096,
					handler:function(){unSelectAll(grid);}
				 },
				 '-',
				 {
					text:'刷 新',
					tooltip:'刷 新',
					glyph:0xf021,
					handler:function(){
						grid.getStore().reload();
					}
				 },
				 {
					text:'检 索',
					tooltip:'检 索',
					glyph:0xf002,
					handler:function(){
						search();
					}
				 },
				 {
					text:'重 置',
					tooltip:'重 置',
					glyph:0xf014,
					handler:function(){
						searchForm.reset();
					}
				 }
				 ]
			 }
		],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				detailZxSupplier();
			}
		}
	});
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[searchForm,grid]
	});
	/**调用右键**/
	initRight();
	store.on('beforeload',function(thiz, options){Ext.apply(thiz.proxy.extraParams,getParmas(store,searchForm));});
	
	grid.store.on('load',function(){
		$('.x-grid-row').find('td').each(function(){
			if($(this).find('a').length > 0){
				$(this).addClass('x-button-default-small-cell');
			}
		});
	});
});
/**删除操作**/
function delZxSupplier(){
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
			ajaxRequest('../zxSupplierController/delZxSupplier',grid,params,'正在执行删除操作中！请稍后...');
		}
	});
}
/**复制一行并生成记录**/
function copyZxSupplier(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要复制的行！');
		return;
	}
	Ext.Msg.confirm('提示','确定要复制一行并生成记录？',function(btn){
		if(btn == 'yes'){
			var params = {id:record.items[0].data.id};
			ajaxRequest('../zxSupplierController/copyZxSupplier',grid,params,'正在执行复制一行并生成记录！请稍后...');
		}
	});
}
/**导出**/
function exportZxSupplier(grid,url){
	exportExcel(grid,url);
}
/**初始化右键**/
function initRight(){
	var contextmenu = new Ext.menu.Menu({
		id:'theContextMenu',
		items:[{
			text:'申请验厂',
			glyph:0xf016,
			id:'addZxSupplierItem',
			handler:function(){
				var model = grid.getSelectionModel();
				if(model.selected.length == 0){
					msgTishi('请选择后再申请');
					return;
				}
				var data = model.selected.items[0].data;
				supplier_id = data.id;
				yc_num = data.yc_num + 1;
				
				if(data.yc_status == 2){
					msgTishi('验厂中，不能再次申请');
					return;
				}
				if(data.yc_num >= 2){
					msgTishi('不能多次验厂');
					return;
				}
				
				$.post("../zxJudgeApplyController/canApply",{supplier_id:supplier_id},function(result){
					if(result == '7'){
						msgTishi('验厂中，不能再次申请');
					}else if(result == '5'){
						msgTishi('不能多次验厂');
					}else if(result == '0'||result == '6'){
						addZxJudgeApply();
					}else if(result == '1'||result == '4'){
						updateZxJudgeApply();
					}else if(result == '2'||result == '3'){
						checkZxJudgeApply();
					}else if(result == '8'){
						msgTishi('已验厂，合格');
					}else if(result == '9'){
						addZxJudgeApply();
					}else if(result == '10'){
						msgTishi('已验厂，不合格');
					}
				});
			}
		},'-',{
			text:'复制一行并生成记录',
			glyph:0xf0ea,
			id:'copyZxSupplierItem',
			handler:function(){copyZxSupplier();}
		},{
			text:'明 细',
			glyph:0xf03b,
			id:'detailZxSupplierItem',
			handler:function(){detailZxSupplier();}
		},{
			text:'导 出',
			glyph:0xf1c3,
			handler:function(){
				exportZxSupplier(grid,'../zxSupplierController/exportZxSupplier');
			}
		},{
			text:'打 印',
			glyph:0xf02f,
			handler:function(){printerGrid(grid);}
		},'-',{
			text:'全 选',
			glyph:0xf046,
			handler:function(){selectAll(grid);}
		},{
			text:'反 选',
			glyph:0xf096,
			handler:function(){unSelectAll(grid);}
		},'-',{
			text:'刷 新',
			glyph:0xf021,
			handler:function(){refreshGrid(grid);}
		}]
	});
	initrightgridcontextmenu(grid,contextmenu,['updateZxSupplierItem','delZxSupplierItem','copyZxSupplierItem','detailZxSupplierItem']);
}
/**查询操作**/
function search(){
	initSearch(store,'../zxSupplierController/getZxSupplierListByCondition',searchForm);
}

function submitForm2(subForm,url,grids,win,isHide,isReset){
	try{
		var items;
		if(null != win){
			items = Ext.ComponentQuery.query('button',win); 
		}
		if(subForm.form.isValid()){   
			top.Ext.Msg.confirm('提示','确定要提交当前表单信息内容？',function(btn){
				if(btn == 'yes'){
					///////////禁用window中组件按钮
					for(var it in items){
						items[it].disable();
					}
					subForm.form.submit({                    
				        url:url,
				        timeout:600000,/**设置超时时间10十分钟**/
				        params:{ajaxform:0},
				        waitTitle:'提示',
				        actionMethods:{ 
							read:'POST' 
						},
						method:'post', 
						submitEmptyText: false ,
				        waitMsg:'正在保存数据，请稍后...',                      
				        success:function(form, action){    
				   			top.Ext.example.msg('提示', action.result.msg);//提示之后消失
				      		if(isReset){
				      			subForm.form.reset();  
				      		}                       
			           		if(null != win && "" != win){
			           			if(isHide){
			           				///////////激活window中组件按钮
									for(var it in items){
										items[it].enable();
									}
			           				win.hide();  
			           			}else{
			           				win.close(); 
			           			}
			           		} 
			           		if(null != grids && "" != grids){
			           			grids.getStore().reload();
			           		}
				      	},
				        failure:function(form, action){
				        	if( typeof(action.result.msg) != "undefined"){
				        		top.Ext.example.msg('提示', action.result.msg);//提示之后消失
				        	}
				        	///////////激活window中组件按钮
							for(var it in items){
								items[it].enable();
							}
				      	}                  
				      });  
				}
			});
		}else { 
			msgTishi('请输入必填项');
		}
	}catch(e){
    	console.info(e);
 	}
}

function writeReport(type,syc_num,yc_status,sid){
	supplier_id = sid;
	yc_num = syc_num + 1;
	if(type == 1||type == 2){
		$.post("../zxJudgeApplyController/canApply",{supplier_id:supplier_id},function(result){
			if(result == '7'||result == '8'||result == '9'){
				msgTishi('验厂中，不能再次申请');
			}else if(result == '5'){
				msgTishi('不能多次验厂');
			}else if(result == '0'||result == '6'){
				addZxJudgeApply();
			}else if(result == '1'||result == '4'){
				updateZxJudgeApply();
			}else if(result == '2'||result == '3'){
				checkZxJudgeApply();
			}else if(result == '10'){
				msgTishi('已验厂，合格');
			}else if(result == '11'){
				addZxJudgeApply();
			}else if(result == '12'){
				msgTishi('已验厂，不合格');
			}
		});
	}else if(type == 3){
		$.post("../zxJudgeReportController/getYCStep",{supplier_id:supplier_id,num:yc_num},function(result){
    		if(result == '0'){
    			msgTishi('没有权限');
    		}else if(result == '1'||result == '2'||result == '4'){
    			addJudgeGenerator(1);
    		}else if(result == '3'||result == '7'){
    			addJudgeGenerator(3);
    		}else if(result == '5'){
    			msgTishi('申请中，不能填写');
    		}else if(result == '6'){
    			msgTishi('还没有申请验厂');
    		}
    	});
	}else if(type == 4){
		$.post("../zxJudgeReportController/getAgainStep",{supplier_id:supplier_id},function(result){
    		if(result == '0'){
    			msgTishi('没有权限');
    		}else if(result == '1'||result == '2'||result == '4'){
    			addJudgeAgainGenerator(1);
    		}else if(result == '3'||result == '7'){
    			addJudgeAgainGenerator(3);
    		}else if(result == '5'){
    			msgTishi('没有验厂');
    		}else if(result == '6'){
    			msgTishi('当前没有再评审');
    		}
    	});
	}
}

function importExcel(fieldid,picid,flag,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	console.log('asdsad');
	optuploadForm = Ext.create('Ext.FormPanel',{
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			margin:'5 5 5 5',
			flex:1
		},
		/**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        /**新方法使用结束**/ 
		items:[
			{
				fieldLabel:'校验参数（pdf,png,jpg,bmp等等以逗号分隔）',
				xtype:'textfield',
				hidden:true,
				id:'validateparameter',
				name:'validateparameter',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'大小（格式如"1024-10240" 表示最小1024KB最大10240KB）',
				xtype:'textfield',
				hidden:true,
				id:'validateSize',
				name:'validateSize',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'平台路径配置中心键（自定义上传对绝路径使用）',
				xtype:'textfield',
				hidden:true,
				id:'xt_path_absolutek',
				name:'xt_path_absolutek',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'平台路径配置中心键（自定义上传相对路径使用）',
				xtype:'textfield',
				hidden:true,
				id:'xt_path_relativek',
				name:'xt_path_relativek',
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'平台路径配置中心键（自定义上传路径 自定义URL地址）',
				xtype:'textfield',
				hidden:true,
				id:'xt_path_urlk',
				name:'xt_path_urlk',
				maxLength:32,
				anchor:'100%'
			},
			{
			    xtype:'filefield',
			    /**
			    hideLabel:true,
			    buttonOnly:true,
			    **/
			    emptyText:'请选择要上传的文件',
			    name:'picFile',
			    buttonText:'选择文件...',
			    anchor:'100%',
			    allowBlank:false,
			    buttonConfig:{
			        icon:uploadimg
			    }
			}
		]
	});
	if(null != validateparameter && '' != validateparameter && typeof(validateparameter) != "undefined"){
		sValue('validateparameter',validateparameter);
	}
	if(null != validateSize && '' != validateSize && typeof(validateSize) != "undefined"){
		sValue('validateSize',validateSize);
	}
	if(null != xt_path_absolutek && '' != xt_path_absolutek && typeof(xt_path_absolutek) != "undefined"){
		sValue('xt_path_absolutek',xt_path_absolutek);
	}
	if(null != xt_path_relativek && '' != xt_path_relativek && typeof(xt_path_relativek) != "undefined"){
		sValue('xt_path_relativek',xt_path_relativek);
	}
	if(null != xt_path_urlk && '' != xt_path_urlk && typeof(xt_path_urlk) != "undefined"){
		sValue('xt_path_urlk',xt_path_urlk);
	}
	
	//否则正常
	optuploadWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:400,
		autoHeight:true,
		closable:false, 
		title:'批量导入物料',
		animateTarget:document.body,
		plain:true,
		modal:true,
		buttonAlign:'right',
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'5 5 5 5'
		},
		listeners:{
			minimize:function(win,opts){
				win.collapse();
			}
		},
		items:optuploadForm,
		buttons:[{
			text:'开始导入',
			itemId:'save',
			handler:function(button){
				if(optuploadForm.form.isValid()) {
					var items = Ext.ComponentQuery.query('button',optuploadWin); 
					///////////激活window中组件按钮
					for(var it in items){
						items[it].disable();
					}
		            optuploadForm.submit({
		                url:basePath+'/zxSupplierController/import',
		                waitMsg:'正在导入中，请稍后...',
		                success:function(form, action){
		                	msgTishi(action.result.data.msg);
		                    if(action.result.data.jsonID != 0){
			                    optuploadWin.close();
		                    }else{
		                    	///////////激活window中组件按钮
								for(var it in items){
									items[it].enable();
								}
		                    }
		                },  
					    failure:function(response,opts){  
					    	///////////激活window中组件按钮
							for(var it in items){
								items[it].enable();
							}
					    }
		            });
		        }else{
		        	msgTishi('请选择附件');
		        }
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				 optuploadWin.close();
			}
		}]
	});
	optuploadWin.show();
}

var circleWinEdit;
var circleFormEdit;
function editCircle(){
	var model = grid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择后再修改');
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
	
	initCircleFormEdit();
	circleWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:280,                    
		height:150,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'评审周期',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:circleFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				Ext.Msg.confirm('提示','确定要修改所选供应商评审周期么？',function(btn){
					if(btn == 'yes'){
						var params = {ids:id,judge_cycle:Ext.getCmp('judge_cycle').getValue()};
						ajaxRequest('../zxSupplierController/editCycle',grid,params,'正在执行修改操作中！请稍后...');
						circleWinEdit.close();
					}
				});
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	circleWinEdit.show();
	
}
function initCircleFormEdit(){
	var judge_circle_list = xt_service_center_type_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
		data:[["","---请选择---"],["1"," 年"],["2","季度"],["3","月"]]
	});
	circleFormEdit = Ext.create('Ext.FormPanel',{
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
		    {
				fieldLabel:'评审周期',
				xtype:'combo',
				emptyText:'请选择',
				store:judge_circle_list,
				mode:'local',
				triggerAction:'all',
				editable:false,
				allowBlank:false,
				hiddenName:'judge_cycle',
				valueField:'value',
				displayField:'text',
				name:'judge_cycle',
				id:'judge_cycle',
				maxLength:32,
				anchor:'100%'
			}
		]
	});
}