var zxOfficeWinDetail;
var zxOfficeFormDetail;
function detailZxOffice(){
	var record = d3.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要查看明细的项！');
		return;
	}
	initZxOfficeFormDetail();
	zxOfficeWinDetail = Ext.create('Ext.Window',{
		layout:'fit',
		width:300,
		height:250,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'明细信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxOfficeFormDetail,
		buttons:[{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxOfficeWinDetail.show();
	
	loadFormData(zxOfficeFormDetail,'../zxOfficeController/getZxOfficeById?office_id='+ record.items[0].data.office_id);
}
function initZxOfficeFormDetail(){
	zxOfficeFormDetail = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		/**新方法使用开始**/
		labelWidth:100,
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
			name:'office_id',
			allowBlank:false,
			maxLength:32,
			anchor:'100%'
		},
		{
			fieldLabel:'分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类',
			xtype:'treepicker',
			displayField:'text',
			anchor:'100%',
			hiddenName:'classify_id',
			name:'classify_id',
			minPickerHeight:200,
			maxHeight:200,
			editable:false,
			allowBlank:false,
			store:Ext.create('Ext.data.TreeStore',{
				fields:['id','text'],
				root:{
					text:'一级分类',
					id:'0',
					expanded:true
				},
				proxy:{
					type:'ajax',
					url:'../zxOfficeClassifyController/getZxOfficeClassifyTree',
					reader:{
						type:'json'
					}
				}
			})
		},
		{
			fieldLabel:'名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称',
			xtype:'textfield',
			name:'name',
			maxLength:255,
			anchor:'100%'
		},
		{
			fieldLabel:'单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位',
			xtype:'textfield',
			name:'unit',
			maxLength:10,
			anchor:'100%'
		}
		
		]
	});
}
