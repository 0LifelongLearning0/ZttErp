var items;
var zxReportGridListColumnGrid;
var zxReportGridListColumnStore;
var zxReportTab;
var zxReportWinAdd;
var zxReportFormAdd;
var scores;
var TMap;
var WMap;
var zx_apply_id;
var zx_result_id;
var filestore;
var filetype='jpg,txt';
var isread = false;
function addJudgeGenerator(step){
	items = new Array();
	scores = new Array();
	TMap= {};
	WMap={};
	zxReportGridListColumnGrid = new Array();
	zxReportGridListColumnStore = new Array();
	initTab(step);
	initZxReportFormAdd();
	reGetWidthAndHeight();
	var buttons;
	if(step == 1){
		buttons = [
		   		{  
		            text:'保存',  
		            itemId:'save',  
		            handler:function(button){
		            	checkScore(button,1);     		
		            }  
		        },
		        {  
		            text:'提交',  
		            itemId:'tocheck',  
		            handler:function(button){
		            	checkScore(button,2);		
		            }  
		        },
		        {  
		            text:'关闭',  
		            itemId:'close',  
		            handler:function(button){  
		                button.up('window').close();  
		            }  
		        }]
		
	}else{
		isread = true;
		buttons = [
		        {  
		            text:'关闭',  
		            itemId:'close',  
		            handler:function(button){  
		                button.up('window').close();  
		            }  
		        }]
	}
	zxReportWinAdd =  Ext.create('Ext.Window',{                  
		layout:'fit',                    
		width:clientWidth * 0.9,                    
		height:clientHeight * 0.9,
		maximizable:true,
		minimizable:true,
		resizable : false,
		animateTarget:document.body,    
		plain:true,   
		modal:true,                 
		title:'验厂报告',                    
		items:zxReportFormAdd, 
		headerPosition:'top',
		listeners:{
		    minimize:function(win,opts){
		        if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
		    },
		    maximize:function(win,opts){
		    	zxReportWinAdd.maximize();
		    }
		},  
		buttons:buttons             
	});
	zxReportWinAdd.show(); 
}

function initTab(step){
	zx_apply_id = '';
	$.ajax({  
        type : "post",  
         url : '../zxJudgeResultController/getOverview?supplier_id=' + supplier_id,  
         async : false,  
         success : function(data){
        	 data = eval("(" + data + ")");
        	 zx_apply_id = data.apply_id;
        	 zx_result_id = data.result_id;
        	 if(step == 2||step == 3){
	        	 var grade = '';
	        	 if(data.score >= 80.0){
	        		 grade = "合格供应商";
	 			 }else if(data.score < 60.0){
	 				 grade = "不合格供应商";
	 			 }else {
	 				 grade = "必须限期整改";
	 			 }
	        	 
	        	 var zxField1 = Ext.create('Ext.form.FieldSet',{
	        			anchor:'100%',
	        			title:'基本信息',
	        			items:[
	        	        {
	        				layout:"column",
	        				items:[
								{
									columnWidth:.2,
									items:[{
										fieldLabel:'开始日期',
											xtype:'textfield',
											name:'judge_date_start',
											editable:false,
											maxLength:32,
											anchor:'100%',
											value:data.judge_date_start
									}]
								},
		        				{
									columnWidth:.2,
									items:[{
										fieldLabel:'结束日期',
			  							xtype:'textfield',
			  							name:'judge_date_end',
			  							editable:false,
			  							maxLength:32,
			  							anchor:'100%',
			  							value:data.judge_date_end
									}]
								},
								{
									columnWidth:.2,
									items:[{
										fieldLabel:'总分',
			  							xtype:'textfield',
			  							name:'score',
			  							editable:false,
			  							maxLength:32,
			  							anchor:'100%',
			  							value:data.score
									}]
								},
								{
									columnWidth:.2,
									items:[{
										fieldLabel:'评定结果',
			  							xtype:'textfield',
			  							name:'supplier_id',
			  							maxLength:100,
			  							editable:false,
			  							anchor:'100%',
			  							value:grade
									}]
								},
								{
									columnWidth:.2,
									items:[{
										fieldLabel:'状态',
			  							xtype:'textfield',
			  							name:'status',
			  							maxLength:100,
			  							editable:false,
			  							anchor:'100%',
			  							value:data.status
									}]
								}
	        				]
	        			}
	        		]
	        		});
	        	    var viewitems = new Array();
	        	    viewitems.push(zxField1);
	          	    var tit = {
	               		title:'总览',
	            			defaultType:'textfield',
	            			fieldDefaults:{
	            		        labelWidth:80,
	            		        labelAlign:"right",
	            		        margin:'2 5 4 5'
	            		    },
	            		    items:viewitems
	                   };
	                items.push(tit);
        	 }
         }
	});
	
	filestore = getGridJsonStore('../zxJudgeResultController/refreshAttach?result_id=' + zx_result_id +'&start=0&limit=200' ,[]);
	
	$.ajax({  
        type : "post",  
         url : "../zxJudgeReportController/getTitle?type=1&step=" + step,  
         async : false,  
         success : function(data){
           data = eval("(" + data + ")");  
           var list = data.items;
           for(var i = 0;i < list.length;i++){
        	  initZxReportGridListColumn(list[i].xt_data_dictionary_id,i);
        	  var ti = {
		      				title:list[i].xt_data_dictionary_name,
		    				layout:'fit',    
		    			    items:zxReportGridListColumnGrid[i]
		    			};
        	  if(step == 1){
        		  items[i] = ti;
        	  }else{
        		  items[i + 1] = ti;
        	  }
           }
           
          var filegrid = Ext.create('Ext.grid.Panel',{
       		region:'center',
       		xtype:'panel',
       		store:filestore,
       		title:'已上传附件',
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
       				header:'ID',
       				flex:1,
       				dataIndex:'id',
       				hidden:true
       			},
       			{
       				header:'文件名',
       				flex:1,
       				dataIndex:'name'
       			},
       			{
       				header:'保存名',
       				flex:1,
       				dataIndex:'file_name',
       				hidden:true
       			},
       			{
       				header:'上传人',
       				flex:1,
       				dataIndex:'user_name'
       			}
       		],
       		tbar:[
       			 {
       				text:'上传',
       				tooltip:'上传',
       				minWidth:tbarBtnMinWidth,
       				cls:'addBtn',
       				icon:addIcon,
       				handler:function(){
       					optupload2('zx_judge_pic','zx_judge_attach',2,filetype);
       				}
       			 },
       			 {
    				text:'下载',
    				tooltip:'下载',
    				minWidth:tbarBtnMinWidth,
    				cls:'addBtn',
    				icon:addIcon,
    				handler:function(){
    					var model = filegrid.getSelectionModel();
    					if(model.selected.length == 0){
    						msgTishi('请选择后再下载');
    						return;
    					}
    					var id;
    					for(var i = 0; i < model.selected.length; i++){
    						if(null == id){
    							id=model.selected.items[i].data.id;
    							break;
    						}
    					}
    					Ext.MessageBox.confirm(   
   				             "请确认"  
   				            ,"确定下载吗？"  
   				            ,function( button,text ){  
   				                if( button == 'yes'){  
   				                	$.ajax({
   			    					    url: "../zxJudgeResultController/downFile",
   			    					    type: "POST",
   			    					    data: {
   			    					        "id": id
   			    					    },
   			    					    traditional: true,
   			    					    success: function(data) {
   			    					    	downOrExport(basePath+'/xtCommonController/downFile?xt_attachment_id='+data);
   			    					    }
   			    					});
   				                }
   				            });
    				}
    			 },
       			 {
    				text:'删除',
    				tooltip:'删除',
    				minWidth:tbarBtnMinWidth,
    				cls:'delBtn',
    				icon:delIcon,
    				handler:function(){
    					var model = filegrid.getSelectionModel();
    					if(model.selected.length == 0){
    						msgTishi('请选择后再删除');
    						return;
    					}
    					Ext.MessageBox.confirm(   
				             "请确认"  
				            ,"确定删除吗？"  
				            ,function( button,text ){  
				                if( button == 'yes'){  
				                	var id;
			    					for(var i = 0; i < model.selected.length; i++){
			    						if(null == id){
			    							id=model.selected.items[i].data.id;
			    							break;
			    						}
			    					}
			    					$.ajax({
			    					    url: "../zxJudgeResultController/delAttach",
			    					    type: "POST",
			    					    data: {
			    					        "result_id": zx_result_id,
			    					        "id": id
			    					    },
			    					    traditional: true,
			    					    success: function(data) {
			    					    	if(data=='1'){
			    					    		msgTishi("操作失败:审核中，不能删除！");
			    					    	}else if(data=='0'){
			    					    		msgTishi("操作失败");
			    					    	}else if(data=='2'){
			    					    		msgTishi("操作成功");
			    					    		filestore.reload();
			    					    	}else if(data=='3'){
			    					    		msgTishi("操作失败");
			    					    	}else if(data=='4'){
			    					    		msgTishi("操作失败:不能删除别人的文件！");
			    					    	}
			    					    }
			    					});
				                }  
				            }   
				        );     
    				}
    			 }
       		]
       		});
           
           var tit = {
          		title:'附件',
       			defaultType:'textfield',
       			fieldDefaults:{
       		        labelWidth:80,
       		        labelAlign:"right",
       		        margin:'2 5 4 5'
       		    },
       		    items:[
					filegrid
       		    ]
              };
           items.push(tit);
         }  
    }); 
}

function initZxReportTab(){
	zxReportTab = Ext.create('Ext.TabPanel',{
		activeTab:0,
		autoScroll:true,
		region:'center',
		xtype:'tabpanel',
		tabPosition:'bottom',
		layout:'fit',
		items:items
	});
}

function initZxReportFormAdd(){
	initZxReportTab();

	zxReportFormAdd = Ext.create('Ext.FormPanel',{
		autoScroll:true,
		fieldDefaults:{
	        labelWidth:80,
	        labelAlign:"right",
	        margin:'4 5 4 5'
	    },
	    layout:'fit',    
		items:[zxReportTab]		
	});
}

function initZxReportGridListColumn(id,i){
	zxReportGridListColumnStore[i] = getGridJsonStore('../zxJudgeReportController/getZxJudgeReportTableColumnList?dic_id=' + id + '&apply_id=' + zx_apply_id,[]);
	zxReportGridListColumnGrid[i] = Ext.create('Ext.grid.Panel',{
   	 	columnLines:true,
        multiSelect:true,
        collapsible:false,
        border:true,
        region:'center', 
        layout:'fit',  
        title:'<font color=red>★注：若生产设备精度不能够达标，则判定为不合格供应商</font>',
        /**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        /**新方法使用结束**/   
        plugins:{
			ptype:'cellediting',
        	clicksToEdit:1
		},
	    features: [{
	        ftype: 'summary'
	    }],
        xtype:'grid',  
        store:zxReportGridListColumnStore[i],
        loadMask:{
            msg:'正在加载...'
        },
        columns:[
			{
			    header:'ID',
			    flex:1,
			    dataIndex:'id',
			    hidden:true
			},
           	{
                header:'考核内容',
                flex:1,
                dataIndex:'content'
           	},
           	{
                header:'状态',
                flex:1,
                hidden:true,
                dataIndex:'status'
           	},
           	{
                header:'最高分',
                flex:1,
                dataIndex:'total_score',
            	summaryType: 'sum',//求工资总额
                summaryRenderer: function(value){  
                    return '<strong>总分：'+Ext.util.Format.number(value,'0,000')+'</strong>';  
                }	
           	},
           	{
                header:'实际得分',
                flex:1,
                field:{
	                allowBlank:false,
                	xtype:'numberfield',
                	minValue:0
	            },
                dataIndex:'score',
                summaryType: 'sum',//求平均考核得分
                summaryRenderer: function(value){  
                    return '<strong>实得：'+Ext.util.Format.number(value,'0')+'</strong>';  
                }
           	},
           	{
			    header:'填写人',
			    flex:1,
			    dataIndex:'judge_user_name',
			    renderer:function(value){
			    	if(value == undefined) value = '';
                    return value;  
			    }
			}],
        tbar:[],
        listeners: {
                'edit': function(editor, e) {
                	 var record = e.record;
                     var key = record.get("id");
                      
                     var i = 0;
                     for(var key1 in WMap){
             	    	if(key1 == key){
             	    		i = 1;
             	    		WMap[key1] = record.get("score");
             	    		break;
             	    	}
             	    }                   
                     if(i == 0){
                     	WMap[key] = record.get("score");
                     	TMap[key] = record.get("total_score");
                     }
                    if(record.get("score") > record.get("total_score")){
        				msgTishi("得分超过总分");
        		        return false;
        			}
        			var data = '{"id":"' + record.get("id") +'","score":"' + record.get("score") +'"}';
        			scores.push(data);
                },
                beforeedit:function(editor, e, eOpts){
	               	 var record = e.record;
	               	 if(record.get('status') == '2'||record.get('status') == '3'||isread){
	               		 return false;//不可编辑
	               	 }
	               	 return true;
	               }
            }
	});
}

function checkScore(button,status){
	for(var key1 in WMap){
	    for(var key2 in TMap){    
	    	if(key1 == key2&&TMap[key2] < WMap[key1]){
	    		msgTishi("得分超过总分");
		        return false;
	    	}
	    }
	}
	if(scores.length == 1){
		scores.push('{}');
	}
	$.ajax({
	    url: "../zxJudgeReportController/saveReport",
	    type: "POST",
	    data: {
	        "scores": scores,
	        "status": status,
	        "supplier_id":supplier_id,
	        "apply_id":zx_apply_id
	    },
	    traditional: true,
	    success: function(data) {
	    	if(data=='1'){
	    		msgTishi("操作成功");
	    		store.reload();
	    		button.up('window').close();
	    	}else if(data=='0'){
	    		msgTishi("操作失败");
	    	}else if(data=='2'){
	    		msgTishi("操作失败:审核中，不能修改！");
	    	}else if(data=='3'){
	    		msgTishi("操作失败:审核通过，不能修改！");
	    	}else if(data=='4'){
	    		msgTishi("操作失败:部门已经有其他人填写！");
	    	}else if(data=='5'){
	    		msgTishi("操作失败:已提交！");
	    	}
	    }
	});      
}

function optupload2(fieldid,picid,flag,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
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
		title:'附件上传',
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
			text:'开始上传',
			itemId:'save',
			handler:function(button){
				if(optuploadForm.form.isValid()) {
					var items = Ext.ComponentQuery.query('button',optuploadWin); 
					///////////激活window中组件按钮
					for(var it in items){
						items[it].disable();
					}
		            optuploadForm.submit({
		                url:basePath+'/zxJudgeResultController/upload?result_id=' + zx_result_id,
		                waitMsg:'正在上传中，请稍后...',
		                success:function(form, action){
		                    msgTishi(action.result.data.msg);
		                    if(action.result.data.jsonID != 0){
			                    optuploadWin.close();
			                    filestore.reload();
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
