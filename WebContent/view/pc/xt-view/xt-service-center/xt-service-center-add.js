var xtServiceCenterWinAdd;
var xtServiceCenterFormAdd;
var xtServiceCenterFormAddFieldSet;
var xtServiceCenterParameterFormAddFieldSet;
function addXtServiceCenter(){
	initXtServiceCenterFormAdd();
	xtServiceCenterWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:800,
		height:400,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加信息',
		headerPosition:'left',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:xtServiceCenterFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(xtServiceCenterFormAdd,'../xtServiceCenterController/addXtServiceCenter',grid,xtServiceCenterWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	xtServiceCenterWinAdd.show();
	
}
function initXtServiceCenterFormAdd(){
	xtServiceCenterFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		autoScroll:true,
		title:'基本信息',
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		items:[
		{
			fieldLabel:'服务名称',
			xtype:'textfield',
			name:'xt_service_center_name',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'服务地址',
			xtype:'textfield',
			name:'xt_service_center_location',
			maxLength:1024,
			anchor:'100%'
		},
		{
			fieldLabel:'服务描述',
			xtype:'textareafield',
			name:'xt_service_center_remark',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'创建时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'ctime',
			maxLength:19,
			anchor:'40%'
		},
		{
			fieldLabel:'修改时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'mtime',
			maxLength:19,
			anchor:'40%'
		},
		{
			fieldLabel:'创&nbsp;&nbsp;建&nbsp;人',
			xtype:'textfield',
			name:'xt_userinfo_id',
			maxLength:32,
			anchor:'40%'
		},
		{
			fieldLabel:'服务类型',
			xtype:'combo',
			emptyText:'请选择',
			store:xt_service_center_type_combo ,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'xt_service_center_type',
			valueField:'value',
			displayField:'text',
			name:'xt_service_center_type',
			maxLength:32,
			anchor:'40%'
		},
		{
			fieldLabel:'状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态',
			xtype:'combo',
			emptyText:'请选择',
			store:xt_service_center_status_combo,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'xt_service_center_status',
			valueField:'value',
			displayField:'text',
			name:'xt_service_center_status',
			maxLength:4,
			anchor:'40%'
		},
		{
			xtype:'numberfield',
			hidden:true,
			value:'0',
			itemId:'xtServiceCenterParameterFormNumber'
		},
		{
			xtype:'textfield',
			hidden:true,
			name:'xt_Service_Center_Parameter_removed_flag',
			itemId:'xt_Service_Center_Parameter_removed_flag'
		}
		]
	});
	xtServiceCenterParameterFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'服务中心参数',
		items:[{	
			xtype:'button',
			text:'添加服务中心参数',
			style:'float:left;margin-bottom:10px',
			labelAlign:"right", 
			listeners:{
				click:function(){
					addXtServiceCenterParameterFormAdd();
				}
			}
		}
		]
	});
	xtServiceCenterFormAdd = Ext.create('Ext.FormPanel',{
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
			xtServiceCenterFormAddFieldSet,
			xtServiceCenterParameterFormAddFieldSet
		]
	});
}
function addXtServiceCenterParameterFormAdd(){
	var numbers = gfiValue(xtServiceCenterFormAddFieldSet,'xtServiceCenterParameterFormNumber');
	sfiValue(xtServiceCenterFormAddFieldSet,'xtServiceCenterParameterFormNumber',numbers+1);
	
	xtServiceCenterParameterFormAdd = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
		{
			fieldLabel:'服务参数编号',
			xtype:'textfield',
			name:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_id',
			itemId:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'服务中心编号',
			xtype:'textfield',
			name:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_id',
			itemId:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_id',
			maxLength:32,
			hidden:true,
			anchor:'100%'
		},
		{
			fieldLabel:'参数名称',
			xtype:'textfield',
			name:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_name',
			itemId:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_name',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'参数描述',
			xtype:'textareafield',
			name:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_remark',
			itemId:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_remark',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'参数类型',
			xtype:'combo',
			emptyText:'请选择',
			store:xt_service_center_parameter_type_combo,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_type',
			valueField:'value',
			displayField:'text',
			name:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_type',
			itemId:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_type',
			maxLength:4,
			anchor:'40%'
		},
		{
			fieldLabel:'状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态',
			xtype:'combo',
			emptyText:'请选择',
			store:xt_service_center_parameter_status_combo,
			mode:'local',
			triggerAction:'all',
			editable:false,
			hiddenName:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_status',
			valueField:'value',
			displayField:'text',
			name:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_status',
			itemId:'xt_Service_Center_Parameter['+numbers+'].xt_service_center_parameter_status',
			maxLength:4,
			anchor:'40%'
		},
		{
			fieldLabel:'创&nbsp;&nbsp;建&nbsp;人',
			xtype:'textfield',
			name:'xt_Service_Center_Parameter['+numbers+'].xt_userinfo_id',
			itemId:'xt_Service_Center_Parameter['+numbers+'].xt_userinfo_id',
			maxLength:32,
			anchor:'40%'
		},
		{
			fieldLabel:'创建时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'xt_Service_Center_Parameter['+numbers+'].ctime',
			itemId:'xt_Service_Center_Parameter['+numbers+'].ctime',
			maxLength:19,
			anchor:'40%'
		},
		{
			fieldLabel:'修改时间',
			xtype:'datetimefield',
			format:'Y-m-d H:i:s',
			name:'xt_Service_Center_Parameter['+numbers+'].mtime',
			itemId:'xt_Service_Center_Parameter['+numbers+'].mtime',
			maxLength:19,
			anchor:'40%'
		},
		{
			fieldLabel:'参数类型附件',
			xtype:'textfield',
			hidden:true,
			id:'xt_Service_Center_Parameter['+numbers+'].attach_filetype',
			name:'xt_Service_Center_Parameter['+numbers+'].attach_filetype',
			itemId:'xt_Service_Center_Parameter['+numbers+'].attach_filetype',
			maxLength:32,
			anchor:'100%'
		},
		{
			title:'参数类型附件',
			anchor:'80%',
			xtype:'fieldset',
			items:{
				xtype:'box', 
				width:80,
				height:60,    
				id:'xt_Service_Center_Parameter['+numbers+'].attach_filetype_pic', 
				margin:'2 5 4 70', 
				autoEl:{
					tag:'img',
					src:bsdefimg
				}
			}
		},
		{
			fieldLabel:'参数配置附件',
			xtype:'textfield',
			hidden:true,
			id:'xt_Service_Center_Parameter['+numbers+'].attach_fileconfig',
			itemId:'xt_Service_Center_Parameter['+numbers+'].attach_fileconfig',
			name:'xt_Service_Center_Parameter['+numbers+'].attach_fileconfig',
			maxLength:32,
			anchor:'100%'
		},
		{
			title:'参数配置附件',
			anchor:'80%',
			xtype:'fieldset',
			items:{
				xtype:'box', 
				width:80,
				height:60, 
				id:'xt_Service_Center_Parameter['+numbers+'].attach_fileconfig_pic', 
				margin:'2 5 4 70', 
				autoEl:{
					tag:'img',
					src:bsdefimg
				}
			}
		},
		{
			xtype:'button',
			text:'删除',
			cls:'delBtn',
			icon:delIcon,
			style:'background:#368ECE;border-color:#126DAF;float:right;margin-bottom:10px',
			labelAlign:'right',
			handler:function (){
				var _panel = this.ownerCt;
				xtServiceCenterParameterFormAddFieldSet.remove(_panel); 
				var xt_Service_Center_Parameter_removed_flag = gfiValue(xtServiceCenterFormAddFieldSet,'xt_Service_Center_Parameter_removed_flag');
				if(null == xt_Service_Center_Parameter_removed_flag || xt_Service_Center_Parameter_removed_flag == ''){
					sfiValue(xtServiceCenterFormAddFieldSet,'xt_Service_Center_Parameter_removed_flag',","+numbers+",");
				}else{
					sfiValue(xtServiceCenterFormAddFieldSet,'xt_Service_Center_Parameter_removed_flag',xt_Service_Center_Parameter_removed_flag+numbers+',');
				}
				resetTitle(xtServiceCenterParameterFormAddFieldSet,true);
			}
		}
		]
	});
	xtServiceCenterParameterFormAddFieldSet.add(xtServiceCenterParameterFormAddFieldSet.items.getCount(),xtServiceCenterParameterFormAdd);
	xtServiceCenterParameterFormAddFieldSet.afterLayout();
	resetTitle(xtServiceCenterParameterFormAddFieldSet,true);
	/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
	initFileRight('xt_Service_Center_Parameter['+numbers+'].attach_filetype','xt_Service_Center_Parameter['+numbers+'].attach_filetype_pic',1,1);
	initFileRight('xt_Service_Center_Parameter['+numbers+'].attach_fileconfig','xt_Service_Center_Parameter['+numbers+'].attach_fileconfig_pic',1,1);
	/**初始化附件右键菜单结束**/

}