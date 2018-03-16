var zxMeetingUserWin;
var xtUserinfoGrid;
var xtUserinfoStore;
var xtUserinfoGrided;
var xtUserinfoSotreed;
var xtDpPanel;
var xtDpStore;
function addZxMeetingUserinfo(meeting_id,type){
	initXtUserinfoGrid(meeting_id);
	initXtUserinfoGrided(meeting_id);
	initXtDpPanel();
	reGetWidthAndHeight();
	var buttons = new Array();
	if(type == '1'){
		var btn1 = {
				text:'上传附件',
				itemId:'upload',
				handler:function(button){
					button.up('window').close();
					addZxMeetingAttach(meeting_id);
				} 
			}
		buttons.push(btn1);
	}
	var btn2 = {
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			} 
		}
	buttons.push(btn2);

	zxMeetingUserWin = Ext.create('top.Ext.Window',{
		layout:'border', 
		maximizable:true,
		minimizable:true,
		maximized:false,
		plain:true,
		modal:true,
		width:clientWidth * 0.8,                    
		height:clientHeight * 1.1, 
		headerPosition:'top',
		title:'添加参会人员',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:[xtDpPanel,
			  {
			  	region:'center',
			  	items:[
			  	{
			  		items:xtUserinfoGrid
			  	},
			  	{
			  		items:xtUserinfoGrided
			  	}
			  	]
			  }
			  ],
		buttons:buttons
	});
	zxMeetingUserWin.setTitle("参会人员选择");
	zxMeetingUserWin.show();
}

/**待导入用户**/
function initXtUserinfoGrid(meeting_id){
	reGetWidthAndHeight();
	xtUserinfoStore = getGridJsonStore('../xtRoleinfoController/getUserinfoListByCondition',[]);
	xtUserinfoGrid = Ext.create('top.Ext.grid.Panel',{
		region:'north',
		store:xtUserinfoStore,
		height:document.documentElement.clientHeight*0.55,
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		selType:'checkboxmodel',
		title:'待添加用户',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		loadMask:{
			msg:'正在加载...'
		},
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'用户名',
				flex:1,
				dataIndex:'xt_userinfo_name'
			},
			{
				header:'真实姓名',
				flex:1,
				dataIndex:'xt_userinfo_realName'
			},
			{
				header:'性别',
				dataIndex:'xt_userinfo_sex',
				renderer:function(value){
					if(value == 0){
						return '男'
					}else{
						return '女'
					}
				}
			},
			{
				header:'籍贯',
				dataIndex:'xt_userinfo_origo',
				renderer:function(value){
					if(value == ''){
						return '∨'
					}else{
						return value;
					}
				}
			},
			{
				header:'岗位',
				dataIndex:'xt_post_name',
				renderer:function(value){
					if(value == ''){
						return '—'
					}else{
						return value;
					}
				}
			},
			{
				header:'部门',
				flex:1,
				dataIndex:'xt_departinfo_name',
				renderer:function(value){
					if(value == ''){
						return '—'
					}else{
						return value;
					}
				}
			},
			{
				header:'状态',
				dataIndex:'xt_userinfo_isDelete',
				renderer:function(value){
					if(value == 0){
						return '在职'
					}else{
						return '离职'
					}
				}
			}
		],
		tbar:[
			 {
				text:'添加必到人员',
				tooltip:'添加必到人员',
				scope:this,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addMeetingUser(meeting_id,1);
				}
			 },
			 {
				text:'添加邀请人员',
				tooltip:'添加邀请人员',
				scope:this,
				cls:'addBtn',
				icon:addIcon,
				handler:function(){
					addMeetingUser(meeting_id,0);
				}
			 }
		],
		bbar:getGridTopBBar(xtUserinfoStore)
	});
}

/**已导入用户**/
function initXtUserinfoGrided(meeting_id){
	reGetWidthAndHeight();
	xtUserinfoStoreed = getGridJsonStore('../zxMeetingUserController/getZxMeetingUserList?meeting_id=' + meeting_id,[]);
	xtUserinfoGrided = Ext.create('top.Ext.grid.Panel',{
		region:'center',
		store:xtUserinfoStoreed,
		height:document.documentElement.clientHeight*0.54,
		style:'margin-left:auto;margin-right:auto;margin-bottom:auto;',
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		collapsible:false,
		autoScroll:true,
		border:false,
		selType:'checkboxmodel',
		/**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
		title:'已添加用户',
		viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		loadMask:{
			msg:'正在加载...'
		},
		columns:[
			{
				header:'序号',
				width:77,
				xtype:'rownumberer'
			},
			{
				header:'ID',
				flex:1,
				hidden:true,
				dataIndex:'id'
			},
			{
				header:'用户名',
				flex:1,
				dataIndex:'user_name'
			},
			{
				header:'真实姓名',
				flex:1,
				dataIndex:'user_realname'
			},
			{
				header:'类型',
				flex:1,
				dataIndex:'type',
				renderer:function(value){
					if(value == 1){
						return '必到';
					}else if(value == 0){
						return '邀请';
					}
				}
			},
			{
				header:'接受邀请',
				flex:1,
				dataIndex:'is_accept',
				renderer:function(value){
					if(value == '1'){
						return '是';
					}else if(value == '0'){
						return '否';
					}else{
						return '<font color="red">未处理 </font>';
					}
				}
			},
			{
				header:'备注',
				flex:1,
				dataIndex:'remark'
			}
		],
		tbar:[
			 {
				text:'移除用户',
				tooltip:'移除用户',
				scope:this,
				cls:'delBtn',
				icon:delIcon,
				handler:function(){
					delMeetingUser();
				}
			 }
		],
		bbar:getGridTopBBar(xtUserinfoStoreed)
	});
}


function initXtDpPanel(){
	//1创建store
	xtDpStore = Ext.create('Ext.data.TreeStore', {  
	     root:{  
              expanded:true  
         },
         proxy:{  
                type:'ajax',  
                url:'../xtCommonController/getXtOrgTree',  
                reader:{  
                    type:'json',  
                    rootProperty:'items'  
                },
				extraParams:{id:'0',type:encodeURI('部门')}  
         }  
	});  
	//2创建treePanel
	xtDpPanel = Ext.create('top.Ext.tree.Panel',{   
		region:'west',
        store:xtDpStore,  
        autoEncode:true,//提交时是否自动编码   
        rootVisible:false,  
        width:200,
        collapsible:true,
        title:'组织机构',
        /**新方法使用开始**/  
        scrollable:true,  
        scrollable:'x',
        scrollable:'y',
        listeners:{  
            beforeitemexpand:function(node,optd){  
            	//展开节点之前触发  
                var id=node.data.id;  
                var type=node.data.type; 
                xtDpStore.setProxy({   
                	//异步从服务器上加载数据  extjs会自动帮我们解析  
                    type:'ajax',  
                    url:'../xtCommonController/getXtOrgTree',  
                    extraParams:{id:id,type:encodeURI(type)}
                 });  
            },
            itemclick:function(node,optd){
            	var leaf = optd.data.leaf;
            	menuClick(optd);
            }  
        }
    });  
}

/**导入用户**/
function addMeetingUser(meeting_id,type){
	var model = xtUserinfoGrid.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择待添加用户');
		return;
	}
	var xt_userinfo_id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == xt_userinfo_id){
			xt_userinfo_id=model.selected.items[i].data.xt_userinfo_id;
		}else{
			xt_userinfo_id=xt_userinfo_id+","+model.selected.items[i].data.xt_userinfo_id;
		}
	}
	top.Ext.Msg.confirm('提示','确定导入所选用户？',function(btn){
		if(btn == 'yes'){
			var params = {xt_userinfo_id:xt_userinfo_id,meeting_id:meeting_id,type:type};
			showWaitMsg("正在导入中...");
			Ext.Ajax.request({  
				params:params, 
			    url:'../zxMeetingUserController/addBatchZxMeetingUser',  
			    method:'post',  
			    success:function(response,opts){
			    	hideWaitMsg();
			    	var obj=Ext.decode(response.responseText);  
	       			top.Ext.example.msg('提示', obj.msg);//提示之后消失
					xtUserinfoGrid.getStore().reload();
					xtUserinfoGrided.getStore().reload();
			    },  
			    failure:function(response,opts){  
			    	hideWaitMsg();
			    }  
			});
		}
	});
}


/**移除用户**/
function delMeetingUser(){
	var model = xtUserinfoGrided.getSelectionModel();
	if(model.selected.length == 0){
		msgTishi('请选择要移除的用户');
		return;
	}
	var id;
	for(var i = 0; i < model.selected.length; i++){
		if(null == xt_userinfo_id){
			id=model.selected.items[i].data.id;
		}else{
			id=id+","+model.selected.items[i].data.id;
		}
	}
	top.Ext.Msg.confirm('提示','确定移除所选用户？',function(btn){
		if(btn == 'yes'){
			var params = {id:id};
			showWaitMsg("正在移除用户中...");
			Ext.Ajax.request({  
				params:params, 
			    url:'../zxMeetingUserController/delBatchZxMeetingUser',  
			    method:'post',  
			    success:function(response,opts){
			    	hideWaitMsg();
			    	var obj=Ext.decode(response.responseText);  
	       			top.Ext.example.msg('提示', obj.msg);//提示之后消失
					xtUserinfoGrid.getStore().reload();
					xtUserinfoGrided.getStore().reload();
			    },  
			    failure:function(response,opts){  
			    	hideWaitMsg();
			    }  
			});
		}
	});
}



//菜单点击事件
function menuClick(node){
 	var id = node.data.id;
 	var type = node.data.type;
 	var parm = {id:id,type:encodeURI(type)};
 	load(xtUserinfoGrid,parm);
 	load(xtUserinfoGrided,parm);
}