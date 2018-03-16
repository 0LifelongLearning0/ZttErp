var zxProjectNodeWinAdd;
var zxProjectNodeFormAdd;
var zxProjectNodeFormAddFieldSet;
var zxProjectWokingFormAddFieldSet;
var zxWorkpieceFormAddFieldSet;
function addZxProjectNode(){
	initZxProjectNodeFormAdd();
	reGetWidthAndHeight();
	zxProjectNodeWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加信息',
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
		items:zxProjectNodeFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxProjectNodeFormAdd,'../zxProjectNodeController/addZxProjectNode',grid,zxProjectNodeWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxProjectNodeWinAdd.show();
	
}
function initZxProjectNodeFormAdd(){
	zxWorkpieceFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
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
	
	zxProjectNodeFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
		{
	       layout:"column",
	       items:[
			{
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
			}]
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
			    	   var make_amount = Ext.getCmp('all_amount').getValue();
			    	   if(newValue != '' && make_amount != ''){
			    		   amount = newValue * make_amount;
			    	   }
			    		Ext.getCmp('amounts').setValue(amount);
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
			    	   var single_amount = Ext.getCmp('single_amount').getValue();
			    	   if(newValue != '' && single_amount != ''){
			    		   amount = newValue * single_amount;
			    	   }
			    	   Ext.getCmp('amounts').setValue(amount);
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
	zxProjectWokingFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'工序',
		items:[{	
			xtype:'button',
			text:'添加工序',
			style:'float:left;margin-bottom:10px',
			labelAlign:"right", 
			listeners:{
				click:function(){
					addZxProjectWokingFormAdd();
				}
			}
		}
		]
	});
	zxProjectNodeFormAdd = Ext.create('Ext.FormPanel',{
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
		    zxWorkpieceFormAddFieldSet,
			zxProjectNodeFormAddFieldSet,
			zxProjectWokingFormAddFieldSet
		]
	});
}
function addZxProjectWokingFormAdd(){
	var numbers = gfiValue(zxProjectNodeFormAddFieldSet,'zxProjectWokingFormNumber');
	sfiValue(zxProjectNodeFormAddFieldSet,'zxProjectWokingFormNumber',numbers+1);
	zxProjectWokingFormAdd = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		layout : "column",
		fieldDefaults:{
			labelWidth:100,
			labelAlign:'left',
			flex:1,
			margin:'5 5 5 5'
		},
		items:[
		{
			fieldLabel:'ID',
			xtype:'textfield',
			name:'zxProjectWoking['+numbers+'].id',
			itemId:'zxProjectWoking['+numbers+'].id',
			maxLength:32,
			hidden:true,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'process_id',
			xtype:'textfield',
			name:'zxProjectWoking['+numbers+'].process_id',
			itemId:'zxProjectWoking['+numbers+'].process_id',
			id:'zxProjectWoking['+numbers+'].process_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			xtype:"fieldcontainer" ,
			layout:"column" ,
			items:[
            {
        	   xtype:"textfield" ,
        	   fieldLabel:"工序" ,
			   name:'zxProjectWoking['+numbers+'].process_text',
			   itemId:'zxProjectWoking['+numbers+'].process_text',
			   id:'zxProjectWoking['+numbers+'].process_text',
        	   maxLength:32,
        	   readOnly:true,
			   anchor:'20%'
            }, 
            {
        	   xtype:"button" ,
        	   icon:addIcon,
        	   style:'margin-top:5px;margin-left:-37px;border:1px solid #5fa2dd;',
        	   flex:1,
	   		   handler:function(button){
		   			selectProcess('zxProjectWoking['+numbers+']');
	   		   }
            }]
		},
		{
    	   xtype:"textfield",
    	   fieldLabel:"排序",
		   name:'zxProjectWoking['+numbers+'].time_sort',
		   itemId:'zxProjectWoking['+numbers+'].time_sort',
		   style:'margin-top:25px;',
    	   maxLength:10,
		   value:"1"
		},
		{
			xtype:'button',
			text:'删除',
			cls:'delBtn',
			icon:delIcon,
			style:'background:#368ECE;border-color:#126DAF;float:right;margin-bottom:7px;margin-top:10px',
			labelAlign:'right',
			handler:function (){
				var _panel = this.ownerCt;
				zxProjectWokingFormAddFieldSet.remove(_panel); 
				var zxProjectWoking_removed_flag = gfiValue(zxProjectNodeFormAddFieldSet,'zxProjectWoking_removed_flag');
				if(null == zxProjectWoking_removed_flag || zxProjectWoking_removed_flag == ''){
					sfiValue(zxProjectNodeFormAddFieldSet,'zxProjectWoking_removed_flag',","+numbers+",");
				}else{
					sfiValue(zxProjectNodeFormAddFieldSet,'zxProjectWoking_removed_flag',zxProjectWoking_removed_flag+numbers+',');
				}
				resetTitle(zxProjectWokingFormAddFieldSet,true);
			}
		}
		]
	});
	zxProjectWokingFormAddFieldSet.add(zxProjectWokingFormAddFieldSet.items.getCount(),zxProjectWokingFormAdd);
	zxProjectWokingFormAddFieldSet.afterLayout();
	resetTitle(zxProjectWokingFormAddFieldSet,true);
	
}
