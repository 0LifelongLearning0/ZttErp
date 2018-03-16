var zxProjectNodeWinEdit;
var zxProjectNodeFormEdit;
var zxProjectNodeFormEditFieldSet;
var zxProjectWokingFormEditFieldSet;
var zxWorkpieceFormEditFieldSet;
function updateZxProjectNode(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxProjectNodeFormEdit();
	reGetWidthAndHeight();
	zxProjectNodeWinEdit = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'编辑信息',
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
		items:zxProjectNodeFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxProjectNodeFormEdit,'../zxProjectNodeController/updateZxProjectNode',grid,zxProjectNodeWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxProjectNodeWinEdit.show();
	
	loadFormDataCallBack(zxProjectNodeFormEdit,'../zxProjectNodeController/getZxProjectNodeById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxProjectNodeFormEdit(){
	zxWorkpieceFormEditFieldSet = Ext.create('top.Ext.form.FieldSet',{
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
	
	zxProjectNodeFormEditFieldSet = Ext.create('top.Ext.form.FieldSet',{
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
			    	   top. Ext.getCmp('amounts').setValue(amount);
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
	zxProjectWokingFormEditFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'工序',
		items:[{	
			xtype:'button',
			text:'添加工序',
			style:'float:left;margin-bottom:10px',
			labelAlign:"right", 
			listeners:{
				click:function(){
					addUpdateZxProjectWokingFormEdit();
				}
			}
		}
		]
	});
	zxProjectNodeFormEdit = Ext.create('top.Ext.FormPanel',{
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
		    zxWorkpieceFormEditFieldSet,
			zxProjectNodeFormEditFieldSet,
			zxProjectWokingFormEditFieldSet
		]
	});
}
function callFnUpdate(form, action){
	var zxProjectWoking = action.result.data.zxProjectWoking;
	for(var i = 0; i < zxProjectWoking.length; i++){
		addZxProjectWokingFormEdit(zxProjectWoking[i]);
	}
	var zxWorkpiece = action.result.data.workpiece;
	top.Ext.getCmp('project_name').setValue(zxWorkpiece.project_name);
	top.Ext.getCmp('workpiece_name').setValue(zxWorkpiece.name);
	top.Ext.getCmp('workpiece_num').setValue(zxWorkpiece.num);
}
function addZxProjectWokingFormEdit(data){
	var numbers = gfiValue(zxProjectNodeFormEditFieldSet,'zxProjectWokingFormNumber');
	sfiValue(zxProjectNodeFormEditFieldSet,'zxProjectWokingFormNumber',numbers+1);
	zxProjectWokingFormEdit = Ext.create('top.Ext.FormPanel',{
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
			layout:"hbox" ,
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
    	   maxLength:10
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
				zxProjectWokingFormEditFieldSet.remove(_panel); 
				var zxProjectWoking_removed_flag = gfiValue(zxProjectNodeFormEditFieldSet,'zxProjectWoking_removed_flag');
				if(null == zxProjectWoking_removed_flag || zxProjectWoking_removed_flag == ''){
					sfiValue(zxProjectNodeFormEditFieldSet,'zxProjectWoking_removed_flag',","+numbers+",");
				}else{
					sfiValue(zxProjectNodeFormEditFieldSet,'zxProjectWoking_removed_flag',zxProjectWoking_removed_flag+numbers+',');
				}
				resetTitle(zxProjectWokingFormEditFieldSet,true);
			}
		}
		]
	});
	zxProjectWokingFormEditFieldSet.add(zxProjectWokingFormEditFieldSet.items.getCount(),zxProjectWokingFormEdit);
	if(null != data){
		//获取表单中所有字段与值（key/value）
		var zxProjectWokingFormEditData = zxProjectWokingFormEdit.getForm().getFieldValues();
		//遍历表单中所有字段名称（key）
		for(var zxProjectWokingFormEditField in zxProjectWokingFormEditData){
			//获取表单中所有字段名称（key）并且截取对象后面的字段 目的与实体类中字段名称一致
			var zxProjectWokingFormEditYField = zxProjectWokingFormEditField.split(".")[1];
			//遍历服务器传递来的对象
			for(var dataKey in data){
				//判断当前字段是否等于服务器传过来的字段
				if(zxProjectWokingFormEditYField == dataKey){
					//给表单每个字段赋值
					if(dataKey != "process_text"){
						sfiValue(zxProjectWokingFormEdit,zxProjectWokingFormEditField,data[dataKey]);
					}else{
						top.Ext.getCmp(zxProjectWokingFormEditField).setValue(data[dataKey]);
					}
				}
			}
		}
	}
	zxProjectWokingFormEditFieldSet.afterLayout();
	resetTitle(zxProjectWokingFormEditFieldSet,true);
}
