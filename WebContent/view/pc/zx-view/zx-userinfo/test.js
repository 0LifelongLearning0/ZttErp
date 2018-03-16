Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tip.*',
    'Ext.tree.*'
]);
var zxUserinfoFormDetail;
var store2;
Ext.onReady(function() {
	reGetWidthAndHeight();
	var store = Ext.create('Ext.data.TreeStore', {
		root : {
			text : '中天集团',
			id : '0',
			expanded : true
		},
		proxy : {
			type : 'ajax',
			method : 'post',
			url : '../xtOrgController/getXtOrgTree2',
			reader : {
				type : 'json'
			},
			extraParams : {
				id : '0',
				type : encodeURI('部门'),
				expanded:true
			}
		}
	});
	// 2创建treePanel
	var treePanel = Ext.create('Ext.tree.Panel', {
		store : store,
		layout : 'fit',
		width : 350,
		autoEncode : true,
		rootVisible : true,
		expanded:true,
		id:"tree",
		useArrows : collapsibleDefined,
		xtype : 'filtered-tree',
		tbar : [ {
			width : 330,
			xtype : 'triggerfield',
			emptyText : '输入关键字（如“采购”等）',
			triggerCls : 'x-form-clear-trigger',
			onTriggerClick : function() {
				this.reset();
			},
			listeners : {
				change : function() {
					filterBy(treePanel, this.getValue(), 'text');
				},
				buffer : 250
			}
		} ],
		listeners : {
			beforeitemexpand:function(node,optd){
                var id=node.data.id; 
                var type=node.data.type; 
                store.setProxy({   
		       	   //异步从服务器上加载数据extjs会自动帮我们解析  
		           type:'ajax',  
		           url:'../xtOrgController/getXtOrgTree2',  
		           extraParams:{id:id,type:encodeURI(type)}
		        });  
            },
            'itemclick':function(view,record,item,index,e){
            	var text=record.data.text; 
            	var id=record.data.id; 
                var type=record.data.type; 
                var extraParams2 = {};
                var personSearch = Ext.getCmp('personSearch').getValue();
                if(null != personSearch && personSearch != ''){
                	extraParams2.xt_userinfo_realName = encodeURI(personSearch);
                }
                if(type == '部门'){
                	extraParams2.xt_departinfo_id = encodeURI(id);
                	store2.setProxy({   
     		       	   //异步从服务器上加载数据extjs会自动帮我们解析  
     		           type:'ajax',
     		           method : 'post',
     		           url:'../zxUserinfoController/getZxUserinfoListByCondition',  
     		           extraParams:extraParams2,
	     		       reader: {
     		             type: 'json',
     		             rootProperty: 'items'
	     		       }
     		        }); 
                	personGrid.store.load();
                }else if(type == '岗位'){
                	var xt_departinfo_id = record.data.xt_departinfo_id;
                	extraParams2.xt_departinfo_id = encodeURI(xt_departinfo_id);
                	extraParams2.xt_post_id = encodeURI(id);
                	store2.setProxy({   
     		       	   //异步从服务器上加载数据extjs会自动帮我们解析  
     		           type:'ajax',  
     		           method : 'post',
     		           url:'../zxUserinfoController/getZxUserinfoListByCondition',  
     		           extraParams:extraParams2,
	     		       reader: {
	     		             type: 'json',
	     		             rootProperty: 'items'
		     		       }
	     		     }); 
	                personGrid.store.load();
                }else{
                	store2.setProxy({   
      		       	   //异步从服务器上加载数据extjs会自动帮我们解析  
      		           type:'ajax',  
      		           method : 'post',
      		           url:'../zxUserinfoController/getZxUserinfoListByCondition',  
 	     		       reader: {
 	     		             type: 'json',
 	     		             rootProperty: 'items'
 		     		       }
 	     		     }); 
 	                personGrid.store.load();
                }
            }
		}
	});
	var d1 = Ext.create('Ext.Panel', {
		title : '',
		frame : true,
		width : 370,
		id : "leftPanel",
		items : [ {
			anchor : '100%',
			layout : {
				type : 'hbox',
				padding : '10',
				pack : 'start',
				align : 'top'
			},
			defaults : {
				margins : '0 5 0 0'
			},
			items : [treePanel ]
		} ]
	});
	var d2 = Ext.create('Ext.Panel', {
		title : '',
		frame : true,
		width : 320,
		height: clientHeight,
		/*autoScroll:true,*/
	    bodyStyle: 'overflow-x:hidden; overflow-y:auto',
		contentEl: 'persons',
		items : [ {
			anchor : '100%',
			layout : {
				type : 'hbox',
				padding : '5',
				pack : 'start',
				align : 'top'
			},
			defaults : {
				margins : '0 5 0 0'
			}
		} ]
	});
	initZxUserinfoFormDetail();
	var d3 = Ext.create('Ext.Panel', {
		title : '',
		frame : true,
		flex: 3,
		id:"rightPanel",
		columnLines:true,
		items : [ {
			anchor : '100%',
			layout : {
				type : 'hbox',
				padding : '50',
				align : 'top',
				pack : 'left'
			},
			defaults : {
				margins : '0 5 0 0'
			},
			items : zxUserinfoFormDetail
		} ]
	})
	Ext.create('Ext.Viewport', {
		layout : 'hbox',
		xtype : 'viewport',
		items : [ d1, d2, d3 ]
	});
	// Set up a model to use in our Store
	 Ext.define('User', {
	     extend: 'Ext.data.Model',
	     fields: [
	         {name: 'xt_userinfo_id', type: 'string'},
	         {name: 'xt_userinfo_realName',  type: 'string'},
	         {name: 'xt_userinfo_card',  type: 'string'}
	     ]
	 });

	 store2 = Ext.create('Ext.data.Store', {
	     model: 'User', 
	     groupField: 'xt_userinfo_card',
	     proxy: {
	         type: 'ajax',
	         method : 'post',
	         url: '../zxUserinfoController/getZxUserinfoListByCondition',
	         reader: {
	             type: 'json',
	             rootProperty: 'items'
	         }
	     },
	     autoLoad: true
	 });
	 var personGrid = Ext.create('Ext.grid.Panel', {
	    store: store2,
		width : 305,
        reserveScrollbar:true,
        collapsible:false,
        loadMask:true,
        useArrows:true,
        rootVisible:false,
        autoSctroll:true,
        animate:true,
        frame:true,
        bufferedRenderer:false,
	    tbar : [{
			width : 280,
			id : 'personSearch',
			xtype : 'triggerfield',
			emptyText : '请输入姓名查询',
			triggerCls : 'x-form-clear-trigger',
			onTriggerClick : function() {
				this.reset();
			},
			listeners : {
				change : function() {
					 var a = Ext.getCmp('tree').getSelectionModel().getSelection();
					 var extraParams = {xt_userinfo_realName:encodeURI(this.getValue())};
					 if(a.length > 0 ){
						 var type = a[0].data.type;
						 var name = a[0].data.id;
						 if(type == "部门"){
							 extraParams.xt_departinfo_id = encodeURI(name);
						 }else if(type == '岗位'){
							 extraParams.xt_departinfo_id = encodeURI(a[0].data.xt_departinfo_id);
							 extraParams.xt_post_id = encodeURI(id);
						 }
					 };
					store2.setProxy({   
     		       	   //异步从服务器上加载数据extjs会自动帮我们解析  
     		           type:'ajax',  
     		           method : 'post',
     		           url:'../zxUserinfoController/getZxUserinfoListByCondition',  
     		           extraParams:extraParams,
	     		       reader: {
	     		             type: 'json',
	     		             rootProperty: 'items'
		     		       }
	     		     }); 
	                personGrid.store.load();
				},
				buffer : 250
			}
		} ],
	    columns: [
	  	    { header: 'ID', dataIndex: 'xt_userinfo_id', flex: 1,hidden:true },
	        { header: '姓名', dataIndex: 'xt_userinfo_realName', flex: 1 },
	  	    { header: '', dataIndex: 'xt_userinfo_card', flex: 1,hidden:true },
	    ],
		listeners : {
            'itemclick':function(view,record,item,index,e){
            	Ext.getCmp('xt_userinfo_realName').setValue(record.data.xt_userinfo_realName);
            	Ext.getCmp('xt_userinfo_email').setValue(record.data.xt_userinfo_email);
            	Ext.getCmp('xt_departinfo_name').setValue(record.data.xt_departinfo_name);
            	Ext.getCmp('xt_post_name').setValue(record.data.xt_post_name);
            	Ext.getCmp('xt_userinfo_mobile').setValue(record.data.xt_userinfo_mobile);
            	Ext.getCmp('xt_userinfo_ortherTel').setValue(record.data.xt_userinfo_ortherTel);
            }
		},
	    hideHeaders:true,
	    features: [{ftype:'grouping'}],
	    renderTo: 'persons'
	});
	 function initZxUserinfoFormDetail(){
			zxUserinfoFormDetail = Ext.create('Ext.FormPanel',{
				height:clientHeight,
				fieldDefaults:{
					labelWidth:70,
					labelAlign:'left',
					flex:1,
					readOnly:true,
					margin:'2 5 4 5'
				},
				items:[
				{
				    layout:"column",
					readOnly:true,
				    items:[
							{
								fieldLabel:'ID',
								xtype:'textfield',
								name:'xt_userinfo_id',
								maxLength:32,
								hidden:true,
								anchor:'20%'
							},
							{
								columnWidth:.5,
								items:[{
									fieldLabel:'姓&emsp;&emsp;名',
									xtype:'textfield',
									name:'xt_userinfo_realName',
									id:"xt_userinfo_realName",
									maxLength:200,
									readOnly:true,
									anchor:'100%'
								}]
							},
							{
								columnWidth:.5,
								items:[{
									fieldLabel:'电子邮件',
									xtype:'textfield',
									name:'xt_userinfo_email',
									id:'xt_userinfo_email',
									maxLength:200,
									readOnly:true,
									anchor:'100%'
								}]
							}
						]
				},
				{
				    layout:"column",
					readOnly:true,
				    items:[
							{
								columnWidth:.5,
								items:[{
									fieldLabel:'部&emsp;&emsp;门',
									xtype:'textfield',
									name:'xt_departinfo_name',
									id:'xt_departinfo_name',
									maxLength:200,
									readOnly:true,
									anchor:'100%'
								}]
							},
							{
								columnWidth:.5,
								items:[{
									fieldLabel:'岗&emsp;&emsp;位',
									xtype:'textfield',
									name:'xt_post_name',
									id:'xt_post_name',
									maxLength:200,
									readOnly:true,
									anchor:'100%'
								}]
							}
						]
				},
				{
				    layout:"column",
					readOnly:true,
				    items:[
							{
								columnWidth:.5,
								items:[{
									fieldLabel:'手机号码',
									xtype:'textfield',
									name:'xt_userinfo_mobile',
									id:'xt_userinfo_mobile',
									maxLength:200,
									readOnly:true,
									anchor:'100%'
								}]
							},
							{
								columnWidth:.5,
								items:[{
									fieldLabel:'集团短号',
									xtype:'textfield',
									name:'xt_userinfo_ortherTel',
									id:'xt_userinfo_ortherTel',
									maxLength:200,
									readOnly:true,
									anchor:'100%'
								}]
							}
						]
				}
				]
			});
		}
})