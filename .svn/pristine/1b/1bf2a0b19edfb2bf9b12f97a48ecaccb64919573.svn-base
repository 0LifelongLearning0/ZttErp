var zxMeetingRecordAttachWin;
var zxMeetingRecordAttachForm;
function changeZxMeetingRecordAttach(meeting_id){
	index = 1;
	initZxMeetingRecordAttachForm(meeting_id);
	zxMeetingRecordAttachWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,                    
		height:400,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxMeetingRecordAttachForm,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxMeetingRecordAttachWin.show();
	
	$.post('../zxMeetingController/getUserAndAttach',{meeting_id:meeting_id}, function(data) {
		var json = eval('('+ data +')');
		var zxAttachs = json.zxAttachs;
		if(zxAttachs != null&&zxAttachs != ''){
			var _item = Ext.getCmp('myattachitems');
			for(var i = 0;i < zxAttachs.length;i++){
				if(zxAttachs[i].type == '2'){
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
	                Ext.getCmp(id_pic).setValue(zxAttachs[i].xt_attachment_id);
	                initFileRight5(id_pic,id_pic_pic,2,1,meeting_id,2);
				}
			}
			
			_item.remove(Ext.getCmp('xt_meeting_pic_pic_add')); 
			var addbtn = {
				xtype:'box', 
				id:'xt_meeting_pic_pic_add', 
				margin:'2 5 4 70', 
				autoEl:{
					tag:'img',
					onclick:"addfield('"+ meeting_id +"')",
					src:addattachhimg
				}
			};
			_item.add(addbtn);
			_item.doLayout(true);
		}
	});
}

function addfield(meeting_id){
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
	initFileRight3(id_pic,id_pic_pic,2,1,meeting_id,2);
	Ext.getCmp('myattachitems').remove(Ext.getCmp('xt_meeting_pic_pic_add')); 
	var addbtn = {
		xtype:'box', 
		id:'xt_meeting_pic_pic_add', 
		margin:'2 5 4 70', 
		autoEl:{
			tag:'img',
			onclick:"addfield('"+ meeting_id +"')",
			src:addattachhimg
		}
	};
	_item.add(addbtn);
	_item.doLayout(true);
}

function initZxMeetingRecordAttachForm(meeting_id){
	var items = new Array();
	var t1 = {
			fieldLabel:'附件编号',
			xtype:'textfield',
			hidden:true,
			id:'xt_meeting_pic_add',
			name:'xt_meeting_pic_add',
			maxLength:32,
			anchor:'100%'
		};
	var t2 = {
			title:'会议记录',
			xtype:'fieldset',
			id:'myattachitems',
			items:[{
				xtype:'box', 
				id:'xt_meeting_pic_pic_add', 
				margin:'2 5 4 70', 
				autoEl:{
					tag:'img',
					onclick:"addfield('"+ meeting_id +"')",
					src:addattachhimg
				}
			}]
		};
	items.push(t1);
	items.push(t2);
	
	zxMeetingRecordAttachForm = Ext.create('Ext.FormPanel',{
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
		items:items
	});
}
