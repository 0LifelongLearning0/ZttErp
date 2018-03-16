var zxMeetingWinDetail;
var zxMeetingFormDetail;
function detailZxMeeting(type){
	index = 1;
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	
	var id;
	if(type==1){
		id = record.items[0].data.id;
	}else if(type==2){
		id = record.items[0].data.meeting_id;
	}
	initZxMeetingFormDetail();
	reGetWidthAndHeight();
	zxMeetingWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:clientWidth * 0.9,                    
		height:clientHeight * 0.9,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'会议详情',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxMeetingFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxMeetingWinDetail.show();
	
	loadFormData(zxMeetingFormDetail,'../zxMeetingController/getZxMeetingById?id=' + id);
	
	$.post('../zxMeetingController/getUserAndAttach',{meeting_id:id}, function(data) {
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
							html:'<font style="font-size:16px;font-weight:bold;line-height:20px;">' + zxAttachs[i].filename +'</font>',
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
	                Ext.getCmp(id_pic).setValue(zxAttachs[i].xt_attachment_id);
					initFileRight6(id_pic,id_pic_pic);
				}
			}
			_item.doLayout(true);
		}
	});
}
function initZxMeetingFormDetail(){
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
	
	zxMeetingFormDetail = Ext.create('Ext.FormPanel',{
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
			readOnly:true,
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
				title:'附件',
				xtype:'fieldset',
				id:'myattachitems'
			},
			zxField3
		]
	});
}

function initFileRight6(fieldid,picid){
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
