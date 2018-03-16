var months;
var result_id;
var supplier_id;
var items;
var zxReportGridListColumnGrid;
var zxReportGridListColumnStore;
var zxReportTab;
var zxReportWinAdd;
var zxReportFormAdd;
var scores;
var TMap;
var WMap;
function addJudgeAgainGenerator(){
	zxReportGridListColumnGrid = new Array();
	zxReportGridListColumnStore = new Array();
	items = new Array();
	scores = new Array();
	TMap= {};
	WMap={};
	initAgainTab();
	initZxAgainReportFormAdd();
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
		title:'再评审报告',                    
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
		buttons: buttons               
	});
	
	zxReportWinAdd.show(); 
	zxReportWinAdd.setTitle("再评审报告");
}

function initAgainTab(){
	$.ajax({  
        type : "post",  
         url : '../zxJudgeAgainResultController/getAgainOverviewByResultId?result_id=' + result_id ,  
         async : false,  
         success : function(data){
        	 data = eval("(" + data + ")");
        	 months = data.months;
        	 supplier_id = data.supplier_id;
        	 var grade = '';
        	 if(data.score >= 90.0){
        		 grade = "I级考核标准";
 			 }else if(data.score < 90.0&&data.score >=80.0){
 				 grade = "Ⅱ级考核标准";
 			 }else if(data.score < 80.0&&data.score >=70.0){
 				 grade = "Ⅲ级考核标准";
 			 }else {
 				 grade = "不合格，直接淘汰";
 			 }
        	 
        	 var zxField1 = Ext.create('Ext.form.FieldSet',{
        			anchor:'100%',
        			title:'基本信息',
        			items:[
        	        {
        				layout:"column",
        				items:[
	        				{
								columnWidth:.25,
								items:[{
									fieldLabel:'评定日期',
		  							xtype:'textfield',
		  							name:'judge_year',
		  							editable:false,
		  							maxLength:32,
		  							anchor:'100%',
		  							value:data.judge_date
								}]
							},
							{
								columnWidth:.25,
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
								columnWidth:.25,
								items:[{
									fieldLabel:'评定结果',
		  							xtype:'textfield',
		  							name:'supplier_id',
		  							maxLength:32,
		  							editable:false,
		  							anchor:'100%',
		  							value:grade
								}]
							},
							{
								columnWidth:.25,
								items:[{
									fieldLabel:'状态',
		  							xtype:'textfield',
		  							name:'status',
		  							maxLength:32,
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
	$.ajax({  
        type : "post",  
         url : "../zxJudgeReportController/getAgainTitle?type=2&step=" + 3,  
         async : false,  
         success : function(data){
           data = eval("(" + data + ")");  
           var list = data.items;
           for(var i = 0;i < list.length;i++){
        	  initZxAgainReportGridListColumn(list[i].xt_data_dictionary_id,i);
        	  var ti = {
		      				title:list[i].xt_data_dictionary_name,
		    				layout:'fit',    
		    			    items:zxReportGridListColumnGrid[i]
		    			};
        	  items[i + 1] = ti;
           }
         }  
    }); 
}

function initZxAgainReportTab(){
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

function initZxAgainReportFormAdd(){
	initZxAgainReportTab();
	
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

function initZxAgainReportGridListColumn(id,i){
	zxReportGridListColumnStore[i] = getGridJsonStore('../zxJudgeReportController/getZxJudgeAgainReportTableColumnList?dic_id=' + id + '&supplier_id=' + supplier_id + '&months=' + months,[]);
	zxReportGridListColumnGrid[i] = Ext.create('Ext.grid.Panel',{
   	 	columnLines:true,
        multiSelect:true,
        collapsible:false,
        border:true,
        region:'center', 
        layout:'fit',  
        title:'<font color=red>A类供应商必须达到I级考核标准，B类供应商需达到Ⅱ级考核标准，C类供应商需达到Ⅲ级考核标准。</font>',
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
            	summaryType: 'sum',
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
        			var data = '{"id":"' + record.get("id") +'"\,"score":"' + record.get("score") +'"}';
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
