var zxMeetingAttachWin;
var zxMeetingAttachForm;
function viewZxMeetingAttach(meeting_id){
	index = 1;
	initZxMeetingAttachForm(meeting_id);
	zxMeetingAttachWin = Ext.create('Ext.Window',{
		layout:'fit',
		width:600,                    
		height:400,
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'附件',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxMeetingAttachForm,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxMeetingAttachWin.show();
	
	$.post('../zxMeetingController/getUserAndAttach',{meeting_id:meeting_id}, function(data) {
		var json = eval('('+ data +')');
		var zxAttachs = json.zxAttachs;
		if(zxAttachs != null&&zxAttachs != ''){
			var _item_1 = Ext.getCmp('myattachpreviewitems');
			var _item_2 = Ext.getCmp('myattachrecorditems');
			for(var i = 0;i < zxAttachs.length;i++){
				var id_pic = 'zx_meeting_pic' + index;
				var id_pic_pic = 'zx_meeting_pic_pic' + index;
				index++;
				var t_pic = {
						xtype:'box', 
						id:id_pic_pic, 
						margin:'2 5 4 70',
						html:'<font style="font-size:16px;font-weight:bold;line-height:30px;">' + zxAttachs[i].filename +'</font>',
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
				if(zxAttachs[i].type == '1'){
					_item_1.add(t_pic);
					_item_1.add(t_pic_pic);
				}else if(zxAttachs[i].type == '2'){
					_item_2.add(t_pic);
					_item_2.add(t_pic_pic);
				}
				Ext.getCmp(id_pic).setValue(zxAttachs[i].xt_attachment_id);
                initFileRight4(id_pic,id_pic_pic);
			}
			_item_1.doLayout(true);
			_item_2.doLayout(true);
		}
	});
}

function initZxMeetingAttachForm(meeting_id){
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
			title:'会议附件',
			xtype:'fieldset',
			id:'myattachpreviewitems',
			items:[]
		};
	var t3 = {
			title:'会议记录',
			xtype:'fieldset',
			id:'myattachrecorditems',
			items:[]
		};
	items.push(t1);
	items.push(t2);
	items.push(t3);
	
	zxMeetingAttachForm = Ext.create('Ext.FormPanel',{
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

function initFileRight4(fieldid,picid){
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
