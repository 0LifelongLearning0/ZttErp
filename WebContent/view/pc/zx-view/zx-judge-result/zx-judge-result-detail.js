var result_id;
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
var filestore;
function viewJudgeGenerator(){
	items = new Array();
	scores = new Array();
	TMap= {};
	WMap={};
	zxReportGridListColumnGrid = new Array();
	zxReportGridListColumnStore = new Array();
	initViewTab();
	initZxReportViewFormAdd();
	reGetWidthAndHeight();
	var buttons = [
		        {  
		            text:'关闭',  
		            itemId:'close',  
		            handler:function(button){  
		                button.up('window').close();  
		            }  
		        }];
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
	zxReportWinAdd.setTitle("验厂报告");
}

function initViewTab(){
	zx_apply_id = '';
	$.ajax({  
        type : "post",  
         url : '../zxJudgeResultController/getOverviewByResultId?result_id=' + result_id,  
         async : false,  
         success : function(data){
        	 data = eval("(" + data + ")");
        	 zx_apply_id = data.apply_id;
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
	});
	
	filestore = getGridJsonStore('../zxJudgeResultController/refreshAttach?result_id=' + result_id +'&start=0&limit=200' ,[]);
	
	$.ajax({  
        type : "post",  
         url : "../zxJudgeReportController/getTitle?type=1&step=" + 3,  
         async : false,  
         success : function(data){
           data = eval("(" + data + ")");  
           var list = data.items;
           for(var i = 0;i < list.length;i++){
        	  initZxReportViewGridListColumn(list[i].xt_data_dictionary_id,i);
        	  var ti = {
		      				title:list[i].xt_data_dictionary_name,
		    				layout:'fit',    
		    			    items:zxReportGridListColumnGrid[i]
		    			};
        	  items[i + 1] = ti;
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
       		tbar:[{
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
			 }]
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

function initZxReportViewTab(){
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

function initZxReportViewFormAdd(){
	initZxReportViewTab();

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

function initZxReportViewGridListColumn(id,i){
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
	               	 if(record.get('status') == '2'||record.get('status') == '3'){
	               		 return false;//不可编辑
	                    }
	               	 return true;
	               }
            }
	});
}
