var zxSixSContentWinAdd;
var zxSixSContentFormAdd;
var zxField1,zxField2;
function addZxSixSContent(six_s_id){
	reGetWidthAndHeight();
	initZxSixSContentFormAdd();
	zxSixSContentWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:1100,                    
		height:500,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加责任人及场所',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxSixSContentFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxSixSContentFormAdd,'../zxSixSContentController/addZxSixSContent?six_s_id=' + six_s_id,contentGrid,zxSixSContentWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxSixSContentWinAdd.show();
	initFileRight2('problem_pic','problem_pic_pic',2,1);
}
function initZxSixSContentFormAdd(){
	initFieldItems();
	zxSixSContentFormAdd = Ext.create('Ext.FormPanel',{
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
		       zxField1,zxField2,
		       {
					fieldLabel:'参考照片',
					xtype:'textfield',
					hidden:true,
					id:'problem_pic',
					name:'problem_pic',
					maxLength:32,
					anchor:'100%'
				},
				{
					title:'参考照片',
					xtype:'fieldset',
					items:{
						xtype:'box', 
						id:'problem_pic_pic', 
						margin:'2 5 4 70', 
						autoEl:{
							tag:'img',
							//onclick:"optupload('xt_userinfo_pic','xt_userinfo_pic_pic',1)",
							src:bsdefimg
						}
					}
				}
		]
	});
}

function initFieldItems(){
	zxField1 = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基本信息',
		items:[
        {
			layout:"column",
			items:[
			{
				columnWidth:.25,
				items:[
				{ 
					fieldLabel:'检查场所',
					xtype:'combo',
					emptyText:'请选择',
					store:six_s_check_place,
					mode:'local',
					triggerAction:'all',
					editable:false,
					hiddenName:'place_id',
					valueField:'xt_data_dictionary_id',
					displayField:'xt_data_dictionary_name',
					name:'place_id',
					maxLength:32,
					allowBlank:false,
					anchor:'100%'
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'责任部门',
					xtype:'treepicker',
					displayField:'text',
					anchor:'60%',
					hiddenName:'dep_id',
					name:'dep_id',
					minPickerHeight:200,
					maxHeight:200,
					editable:false,
					allowBlank:false,
					store:zx_dep,
					allowBlank:false,
					anchor:'100%'
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'责任人',
					xtype:'textfield',
					id:'user_id',
					name:'user_id',
					maxLength:32,
					hidden:true,
					allowBlank:false,
					anchor:'100%'
				},
				{
					fieldLabel:'责任人',
					xtype:'textfield',
					id:'user_realname',
					name:'user_realname',
					maxLength:32,
					trigger1Cls:'x-form-userselect-trigger',
					onTrigger1Click:function(){showUserWin();},
					allowBlank:false,
					editable:false,
					anchor:'100%'
				}]
			},
			{
				columnWidth:.25,
				items:[{
					fieldLabel:'完成期限',
					xtype:'datetimefield',
					format:'Y-m-d',
					name:'end_date',
					maxLength:19,
					allowBlank:false,
					editable:false,
					anchor:'30%'
				}]
			}
			]
		}
	]
	});
	
	zxField2 = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'说明',
		items:[
			{ 
				fieldLabel:'不符合项说明',
				xtype:'textareafield',
				name:'problem',
				maxLength:256,
				anchor:'100%'
			},
			{
				fieldLabel:'改善措施',
				xtype:'textareafield',
				name:'measure',
				maxLength:256,
				anchor:'100%'
			}   
        ]
	});
}

function initFileRight2(fieldid,picid,flag,isUpAndDelete,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
	var contextmenuFile = new Ext.menu.Menu({
		items:[{
			text:'上 传',
			glyph:0xf093,
			handler:function(){
				optupload2(fieldid,picid,2,validateparameter,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk);
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
				Ext.getCmp(picid).getEl().dom.src = bsdefimg;
		        Ext.getCmp(fieldid).setValue('');
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

function optupload2(fieldid,picid,flag,validateparameter,meeting_id,validateSize,xt_path_absolutek,xt_path_relativek,xt_path_urlk){
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
		                url:basePath+'/xtCommonController/upload',
		                timeout:600000,/**设置超时时间10十分钟**/
		                waitMsg:'正在上传中，请稍后...',
		                success:function(form, action){
		                	/**
		                    var tpl = new Ext.XTemplate(
		                        'File processed on the server.<br />',
		                        'Name: {fileName}<br />',
		                        'Size: {fileSize:fileSize}'
		                    );
		                    Ext.Msg.alert('Success', tpl.apply(o.result));
		                    **/
		                    /**动态改变容器中路径用该方法**/
		                    msgTishi(action.result.data.msg);
		                    if(action.result.data.jsonID != 0){
			                    Ext.getCmp(picid).getEl().dom.src = action.result.data.jsonValue;
			                    Ext.getCmp(fieldid).setValue(action.result.data.jsonID);
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
		        	msgTishi('请选择图片');
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
