var zxMeetingWinEdit;
var zxMeetingFormEdit;
function updateZxMeeting(){
	index = 1;
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	reGetWidthAndHeight();
	initZxMeetingFormEdit(record.items[0].data.id);

	zxMeetingWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth * 0.9,                    
		height:clientHeight * 0.9,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'编辑信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxMeetingFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxMeetingFormEdit,'../zxMeetingController/updateZxMeeting',grid,zxMeetingWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxMeetingWinEdit.show();
	
	loadFormData(zxMeetingFormEdit,'../zxMeetingController/getZxMeetingById?id='+ record.items[0].data.id);
	
	$.post('../zxMeetingController/getUserAndAttach',{meeting_id:record.items[0].data.id}, function(data) {
		var json = eval('('+ data +')');
		
		Ext.getCmp('user_name_t').setValue(json.user_name_t);
		Ext.getCmp('user_name_o').setValue(json.user_name_o);
		Ext.getCmp('user_ids_t').setValue(json.user_ids_t);
		Ext.getCmp('user_ids_o').setValue(json.user_ids_o);
		
		var zxAttachs = json.zxAttachs;
		if(zxAttachs != null&&zxAttachs != ''){
			var _item = Ext.getCmp('myattachitems');
			for(var i = 0;i < zxAttachs.length;i++){
				if(zxAttachs[i].type == '1'){
					var id_pic = 'zx_meeting_pic' + index;
					var id_pic_pic = 'zx_meeting_pic_pic' + index;
					index++;
					var t_pic = {
							xtype:'box', 
							id:id_pic_pic, 
							margin:'2 5 4 70', 
							html:'<font style="font-size:16px;font-weight:bold;">' + zxAttachs[i].filename +'</font>',
							autoEl:{
								tag:'img|div',
								src:bsdefimg
							}
						};
					var t_pic_pic = {
							fieldLabel:'附件编号',
							xtype:'textfield',
							hidden:true,
							id:id_pic,
							name:'zx_meeting_pic',
							maxLength:32,
							anchor:'100%'
						};
					_item.add(t_pic);
					_item.add(t_pic_pic);
					initFileRight5(id_pic,id_pic_pic,2,1,record.items[0].data.id,1);
					
	                Ext.getCmp(id_pic).setValue(zxAttachs[i].xt_attachment_id);
				}
			}
			
			_item.remove(Ext.getCmp('xt_meeting_pic_pic_add')); 
			var addbtn = {
				xtype:'box', 
				id:'xt_meeting_pic_pic_add', 
				margin:'2 5 4 70', 
				autoEl:{
					tag:'img',
					onclick:"editattach('"+ record.items[0].data.id +"','1')",
					src:addattachhimg
				}
			};
			_item.add(addbtn);
			_item.doLayout(true);
		}
	});
}
	
function editattach(meeting_id,type){
	var id_pic = 'zx_meeting_pic' + index;
	var id_pic_pic = 'zx_meeting_pic_pic' + index;
	index++;
	var t_pic = {
			xtype:'box', 
			id:id_pic_pic, 
			margin:'2 5 4 70', 
			autoEl:{
				tag:'img',
				src:bsdefimg
			}
		};
	var t_pic_pic = {
			fieldLabel:'附件编号',
			xtype:'textfield',
			hidden:true,
			id:id_pic,
			name:'zx_meeting_pic',
			maxLength:32,
			anchor:'100%'
		};
	
	var _item = Ext.getCmp('myattachitems');
	_item.add(t_pic);
	_item.add(t_pic_pic);
	initFileRight3(id_pic,id_pic_pic,2,1,meeting_id,type);
	Ext.getCmp('myattachitems').remove(Ext.getCmp('xt_meeting_pic_pic_add')); 
	var addbtn = {
		xtype:'box', 
		id:'xt_meeting_pic_pic_add', 
		margin:'2 5 4 70', 
		autoEl:{
			tag:'img',
			onclick:"editattach('"+ meeting_id +"','"+ type +"')",
			src:addattachhimg
		}
	};
	_item.add(addbtn);
	_item.doLayout(true);
}

function initZxMeetingFormEdit(meeting_id){
	var zxField1 = Ext.create('Ext.form.FieldSet',{
		title:'基本信息',
		items:[
		{
			layout:"column",
			items:[
				{
					columnWidth:1,
					items:[
							{
								fieldLabel:'会议主题',
								xtype:'textfield',
								name:'title',
								maxLength:100,
								allowBlank:false,
								width : '99%' 
							}
						]
				},
				{
					columnWidth:.33,
					items:[
							{
								fieldLabel:'开始时间',
								xtype:'datetimefield',
								format:'Y-m-d H:i',
								name:'time_start',
								maxLength:19,
								allowBlank:false,
								width : 300 
							}
						]
				},
				{
					columnWidth:.33,
					items:[
							{
								fieldLabel:'结束时间',
								xtype:'datetimefield',
								format:'Y-m-d H:i',
								name:'time_end',
								maxLength:19,
								allowBlank:false,
								width : 300 
							}
						]
				},
				{
					columnWidth:.33,
					items:[
							{
								fieldLabel:'会议地址',
								xtype:'combo',
								emptyText:'请选择',
								store:zx_meeting_house,
								mode:'local',
								triggerAction:'all',
								editable:false,
								hiddenName:'house_id',
								valueField:'id',
								displayField:'house_name',
								name:'house_id',
								maxLength:100,
								allowBlank:false,
								width : 300 
							}
						]
				}
			]
		}]
	});
	var zxField2 = Ext.create('Ext.form.FieldSet',{
		title:'参会人员选择',
		items:[
		{
			layout:"column",
			items:[
				{
					columnWidth:1,
					items:[
							{
								fieldLabel:'参会人员',
								xtype:'textfield',
								id:'user_name_t',
								name:'user_name_t',
								maxLength:10000,
								allowBlank:false,
								editable:false,
								trigger1Cls:'x-form-userselect-trigger',
								onTrigger1Click:function(){showUserWin(1);},
								width : '99%' 
							},
							{
								fieldLabel:'参会人员',
								xtype:'textfield',
								id:'user_ids_t',
								name:'user_ids_t',
								maxLength:10000,
								allowBlank:false,
								editable:false,
								hidden:true,
								width : '99%' 
							}
						]
				},
				{
					columnWidth:1,
					items:[
							{
								fieldLabel:'邀请人员',
								xtype:'textfield',
								id:'user_name_o',
								name:'user_name_o',
								maxLength:10000,
								editable:false,
								trigger1Cls:'x-form-userselect-trigger',
								onTrigger1Click:function(){showUserWin(0);},
								width : '99%' 
							},
							{
								fieldLabel:'邀请人员',
								xtype:'textfield',
								id:'user_ids_o',
								name:'user_ids_o',
								maxLength:10000,
								editable:false,
								hidden:true,
								width : '99%' 
							}
						]
				}
			]
		}]
	});	
	var zxField3 = Ext.create('Ext.form.FieldSet',{
		title:'会议内容',
		items:[
		{
			layout:"column",
			items:[
				{
					columnWidth:1,
					items:[
						{
							xtype:'htmleditor',  
				            name:'content',  
				            height:320,  
				            width:'99%',
				            maxLength:65535,
				            allowBlank:false,
				            fontFamilies :['宋体','黑体','楷体'],  
				            defaultLinkValue :'http://www.uspcat.com'  
						}
					]
				}
			]
		}]
	});	
	
	zxMeetingFormEdit = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		//**新方法使用开始**//
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		//**新方法使用结束**//
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
			{
				fieldLabel:'ID',
				xtype:'textfield',
				hidden:true,
				name:'id',
				allowBlank:false,
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'创建时间',
				xtype:'textfield',
				name:'create_date',
				maxLength:20,
				hidden:true,
				anchor:'40%'
			},
			{
				fieldLabel:'user_id',
				xtype:'textfield',
				hidden:true,
				name:'user_id',
				allowBlank:false,
				maxLength:32,
				anchor:'100%'
			},
			{
				fieldLabel:'state',
				xtype:'textfield',
				name:'state',
				maxLength:20,
				hidden:true,
				anchor:'40%'
			},
			zxField1,
			zxField2,
			{
				fieldLabel:'附件编号',
				xtype:'textfield',
				hidden:true,
				id:'xt_meeting_pic_add',
				name:'xt_meeting_pic_add',
				maxLength:32,
				anchor:'100%'
			},
			{
				title:'附件',
				xtype:'fieldset',
				id:'myattachitems',
				items:[{
					xtype:'box', 
					id:'xt_meeting_pic_pic_add', 
					margin:'2 5 4 70', 
					autoEl:{
						tag:'img',
						onclick:"editattach('"+ meeting_id +"','1')",
						src:addattachhimg
					}
				}]
			},
			zxField3
		]
	});
}

function initFileRight3(fieldid,picid,flag,isUpAndDelete,meeting_id,attach_type,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	var contextmenuFile = new Ext.menu.Menu({
		items:[{
			text:'上 传',
			glyph:0xf093,
			handler:function(){
				optupload3(fieldid,picid,2,validateparameter,meeting_id,attach_type,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk);
			}
		},{
			text:'下 载',
			glyph:0xf019,
			handler:function(){
				var xt_attachment_id = Ext.getCmp(fieldid).getValue();
				downOrExport(basePath+'/xtCommonController/downFile?xt_attachment_id='+xt_attachment_id);
			}
		},
		'-',
		{
			text:'删 除',
			glyph:0xf014,
			handler:function(){
		        Ext.getCmp('myattachitems').remove(Ext.getCmp(picid)); 
		        Ext.getCmp('myattachitems').remove(Ext.getCmp(fieldid)); 
		        Ext.getCmp('myattachitems').doLayout(true);
			}
		},
		'-',
		{
			text:'复制文件地址',
			glyph:0xf0c5,
			handler:function(){
				var url_path = Ext.getCmp(picid).getEl().dom.src;
				Ext.Msg.alert("复制文件地址",url_path);
			}
		},
		'-',
		{
			text:'查 看',
			glyph:0xf1c5,
			handler:function(){
				var url_path = Ext.getCmp(picid).getEl().dom.src;
				getimghw(url_path);
			}
		}]
	});
	Ext.getCmp(picid).getEl().on('contextmenu',function(e){ 
		e.preventDefault(); 
		contextmenuFile.showAt(e.getXY());
	});
}

function initFileRight5(fieldid,picid,flag,isUpAndDelete,meeting_id,attach_type,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	var contextmenuFile = new Ext.menu.Menu({
		items:[{
			text:'下 载',
			glyph:0xf019,
			handler:function(){
				var xt_attachment_id = Ext.getCmp(fieldid).getValue();
				downOrExport(basePath+'/xtCommonController/downFile?xt_attachment_id='+xt_attachment_id);
			}
		},
		'-',
		{
			text:'删 除',
			glyph:0xf014,
			handler:function(){
				if(meeting_id != '')$.post('../zxMeetingController/delAttach',{meeting_id:meeting_id,xt_attachment_id:Ext.getCmp(fieldid).getValue()}, function(data) {});
		        Ext.getCmp('myattachitems').remove(Ext.getCmp(picid)); 
		        Ext.getCmp('myattachitems').remove(Ext.getCmp(fieldid)); 
		        Ext.getCmp('myattachitems').doLayout(true);
			}
		},
		'-',
		{
			text:'复制文件地址',
			glyph:0xf0c5,
			handler:function(){
				var url_path = Ext.getCmp(picid).getEl().dom.src;
				Ext.Msg.alert("复制文件地址",url_path);
			}
		},
		'-',
		{
			text:'查 看',
			glyph:0xf1c5,
			handler:function(){
				var url_path = Ext.getCmp(picid).getEl().dom.src;
				getimghw(url_path);
			}
		}]
	});
	Ext.getCmp(picid).getEl().on('contextmenu',function(e){ 
		e.preventDefault(); 
		contextmenuFile.showAt(e.getXY());
	});
}
function optupload3(fieldid,picid,flag,validateparameter,meeting_id,attach_type,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
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
		//**新方法使用开始**//
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        //**新方法使用结束**// 
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
			   /* hideLabel:true,
			    buttonOnly:true,*/
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
		                url:basePath+'/zxMeetingController/upload?meeting_id=' + meeting_id + '&type=' + attach_type,
		                waitMsg:'正在上传中，请稍后...',
		                success:function(form, action){
		                	 msgTishi(action.result.data.msg);
			                    if(action.result.data.jsonID != 0){
			                    	var _item = Ext.getCmp('myattachitems');
			                    	_item.remove(Ext.getCmp(picid)); 
			                    	var t_pic = {
			    							xtype:'box', 
			    							id:picid, 
			    							margin:'2 5 4 70', 
			    							html:'<font style="font-size:16px;font-weight:bold;">asdasdasd</font>',
			    							autoEl:{
			    								tag:'img|div',
			    								src:bsdefimg
			    							}
			    						};
			    					_item.add(t_pic);
			    					initFileRight5(fieldid,picid,2,1,meeting_id,attach_type);

			    					var record = grid.getSelectionModel().selected;
			    					_item.remove(Ext.getCmp('xt_meeting_pic_pic_add')); 
			    					var addbtn = {
			    						xtype:'box', 
			    						id:'xt_meeting_pic_pic_add', 
			    						margin:'2 5 4 70', 
			    						autoEl:{
			    							tag:'img',
			    							onclick:"editattach('"+ record.items[0].data.id +"','" + attach_type + "')",
			    							src:addattachhimg
			    						}
			    					};
			    					_item.add(addbtn);
				                    Ext.getCmp(fieldid).setValue(action.result.data.jsonID);
				                    optuploadWin.close();
				                    _item.doLayout(true);
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
