var zxProjectNodeWinDetail;
var zxProjectNodeFormDetail;
var zxProjectNodeFormDetailFieldSet;
var zxProjectWokingFormDetailFieldSet;
var zxWorkpieceFormDetailFieldSet;
function detailZxProjectNode(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	initZxProjectNodeFormDetail();
	reGetWidthAndHeight();
	zxProjectNodeWinDetail = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.9,                    
		height:clientHeight*0.9, 
		maximizable:false,
		minimizable:false,
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
		items:zxProjectNodeFormDetail
	});
	zxProjectNodeWinDetail.show();
	
	loadFormDataCallBack(zxProjectNodeFormDetail,'../zxProjectNodeController/getZxProjectNodeById?id='+ record.items[0].data.id,callFnDetail);
}
function initZxProjectNodeFormDetail(){
	zxWorkpieceFormDetailFieldSet = Ext.create('top.Ext.form.FieldSet',{
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
				name:'workpiece_num',
				readOnly: true,
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
	
	zxProjectNodeFormDetailFieldSet = Ext.create('top.Ext.form.FieldSet',{
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
				readOnly: true,
				maxLength:32,
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
				readOnly: true
			},
			{
				columnWidth:.33,
				fieldLabel:'材质',
				xtype:"textfield",
				readOnly: true,
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
				readOnly: true,
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
				readOnly: true,
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
				readOnly: true,
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
	zxProjectWokingFormDetailFieldSet = Ext.create('top.Ext.form.FieldSet',{
		anchor:'100%',
		title:'工序'
	});
	zxProjectNodeFormDetail = Ext.create('top.Ext.FormPanel',{
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
		    zxWorkpieceFormDetailFieldSet,
			zxProjectNodeFormDetailFieldSet,
			zxProjectWokingFormDetailFieldSet
		]
	});
}
function callFnDetail(form, action){
	var zxProjectWoking = action.result.data.zxProjectWoking;
	for(var i = 0; i < zxProjectWoking.length; i++){
		addZxProjectWokingFormDetail(zxProjectWoking[i]);
	}
	var zxWorkpiece = action.result.data.workpiece;
	top.Ext.getCmp('project_name').setValue(zxWorkpiece.project_name);
	top.Ext.getCmp('workpiece_name').setValue(zxWorkpiece.name);
	top.Ext.getCmp('workpiece_num').setValue(zxWorkpiece.num);
}
function addZxProjectWokingFormDetail(data){
	var numbers = gfiValue(zxProjectNodeFormDetailFieldSet,'zxProjectWokingFormNumber');
	sfiValue(zxProjectNodeFormDetailFieldSet,'zxProjectWokingFormNumber',numbers+1);
	zxProjectWokingFormDetail = Ext.create('top.Ext.FormPanel',{
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
			xtype:"textfield" ,
     	    fieldLabel:"工序" ,
			name:'zxProjectWoking['+numbers+'].process_text',
			itemId:'zxProjectWoking['+numbers+'].process_text',
			id:'zxProjectWoking['+numbers+'].process_text',
     	    maxLength:32,
     	    readOnly:true
		},
		{
    	   xtype:"textfield",
    	   fieldLabel:"排序",
		   name:'zxProjectWoking['+numbers+'].time_sort',
		   itemId:'zxProjectWoking['+numbers+'].time_sort',
		   readOnly: true,
    	   maxLength:10
		}
		]
	});
	zxProjectWokingFormDetailFieldSet.add(zxProjectWokingFormDetailFieldSet.items.getCount(),zxProjectWokingFormDetail);
	if(null != data){
		//获取表单中所有字段与值（key/value）
		var zxProjectWokingFormDetailData = zxProjectWokingFormDetail.getForm().getFieldValues();
		//遍历表单中所有字段名称（key）
		for(var zxProjectWokingFormDetailField in zxProjectWokingFormDetailData){
			//获取表单中所有字段名称（key）并且截取对象后面的字段 目的与实体类中字段名称一致
			var zxProjectWokingFormDetailYField = zxProjectWokingFormDetailField.split(".")[1];
			//遍历服务器传递来的对象
			for(var dataKey in data){
				//判断当前字段是否等于服务器传过来的字段
				if(zxProjectWokingFormDetailYField == dataKey){
					//给表单每个字段赋值
					if(dataKey != "process_text"){
						sfiValue(zxProjectWokingFormDetail,zxProjectWokingFormDetailField,data[dataKey]);
					}else{
						top.Ext.getCmp(zxProjectWokingFormDetailField).setValue(data[dataKey]);
					}
				}
			}
		}
	}
	zxProjectWokingFormDetailFieldSet.afterLayout();
	resetTitle(zxProjectWokingFormDetailFieldSet,true);
}
