var loginGrid;
var loginStore;
var noticeGrid;
var noticeStore;
var rightPanel;
var centerPanel;
var leftPanel;
var line_spline;
var knowledgeGrid;
var knowledgeStore;
Ext.onReady(function(){
	reGetWidthAndHeight();
	reGetWidthAndHeight();
	var xtCompanyFormEdit = Ext.create('Ext.FormPanel',{
		xtype:'form',
		region:'center',
		defaultType:'textfield',
		autoScroll:true,
		title:'&nbsp;个人信息',
		titleAlign:'left',
		fieldDefaults:{
	        labelWidth:70,
	        labelAlign:"right",
	        flex:1,
	        margin:'4 5 4 5'
	    },
		items:[
		{
			fieldLabel:'姓名',
			xtype:'displayfield',
			readOnly:true,
			name:'xt_userinfo_realName',
			allowBlank:false,
			maxLength:50,
			anchor:'20%'
		},
		{
			fieldLabel:'登录账户',
			xtype:'textfield',
			readOnly:true,
			name:'xt_userinfo_name',
			maxLength:20,
			anchor:'20%'
		},
		{
			fieldLabel:'出生年月',
			xtype:'textfield',
			readOnly:true,
			name:'xt_userinfo_birthday',
			maxLength:20,
			anchor:'20%'
		},
		{
			fieldLabel:'籍贯',
			xtype:'textfield',
			readOnly:true,
			name:'xt_userinfo_origo',
			maxLength:20,
			anchor:'20%'
		},
		{
			fieldLabel:'手机号码',
			xtype:'textfield',
			readOnly:true,
			name:'xt_userinfo_mobile',
			maxLength:20,
			anchor:'20%'
		},
		{
			fieldLabel:'归属部门',
			xtype:'textfield',
			readOnly:true,
			name:'xt_departinfo_name',
			maxLength:20,
			anchor:'20%'
		},
		{
			fieldLabel:'当前职务',
			xtype:'textfield',
			readOnly:true,
			name:'xt_post_name',
			maxLength:20,
			anchor:'20%'
		},
		{
			fieldLabel:'电子邮件',
			xtype:'textfield',
			readOnly:true,
			name:'xt_userinfo_email',
			maxLength:20,
			anchor:'40%'
		},
		{
			fieldLabel:'家庭地址',
			xtype:'textfield',
			readOnly:true,
			name:'xt_userinfo_address',
			maxLength:200,
			anchor:'40%'
		},
		{
			fieldLabel:'个人简介',
			xtype:'textarea',
			readOnly:true,
			name:'xt_userinfo_remark',
			maxLength:500,
			anchor:'80%'
		}]
	});
	loadFormData(xtCompanyFormEdit,'../xtUserinfoController/getXtUserinfoById?xt_userinfo_id='+$('#xt_userinfo_id').val());
	Ext.create('Ext.Viewport',{
		layout:'fit',
		xtype:'viewport',
		items:xtCompanyFormEdit
	});
	/**
	initLeft();
    initRight();
    initCenter();
	Ext.create('Ext.Panel',{
	    renderTo:Ext.getBody(),
	    bodyStyle:{
		},
 		layout:"column",
		baseCls:'x-plain',
		xtype:'panel',
		frame:false,
		items:[
		      {
				columnWidth:.4,
				layout:"form",
				items:leftPanel
			  },
			  {
				columnWidth:.3,
				layout:"form",
				items:centerPanel
			  },
			  {
			    columnWidth:.3,
				layout:"form",
				items:rightPanel
			  }
			  ]
 	});**/
});

/**初始化登录信息**/
function initLoginGrid(){
	loginStore = getGridJsonStore('../xtLoginLogsController/getXtLoginLogsListByCondition?flag=1&limit=11',[]);
	loginGrid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:loginStore,
		hideHeaders:true,
		viewConfig:{
			emptyText:'暂无数据',
			rowLines:true
		},
		loadMask:{
			msg:'正在加载...'
		},
		columns:[
			{
				header:'IP',
				align:'left',
				flex:1,
				dataIndex:'xt_login_logIP'
			},
			{
				header:'登录时间',
				flex:1,
				align:'right',
				dataIndex:'xt_login_logtime'
			}
		]
	});
}
function initLeft(){
	var text = "Bootstrap Extjs6.2.0技术扁平化风格；<br>"+
				"采用平台统一监控如JVM，内存，CPU等；<br>"+
				"支持多数据库如Oracle，Mysql，DB2，Sqlserver等；<br>"+
				"公司，部门，岗位，组织机构，数据权限；<br>"+
				"附件上传如Html5，Extjs上传方式等；<br>"+
				"触屏端支持；<br>"+
				"简单易用，代码风格统一；<br>"+
				"支持菜单管理，平台路径配置，记录问题知识；<br>"+
				"动态调度器配置及使用；<br>"+
				"支持各类报表；<br>"+
				"拥有数据库管理工具；<br>"+
				"数据库信息，数据库库表结构，索引等；<br>"+
				"采用SSO统一认证平台实现登陆；<br>"+				
				"拥有OA，CRM等功能；<br>"+
				"短信配置；<br>"+
				"物品单位；<br>"+
				"省市区县；<br>"+
				"平台公告；<br>"+
				"平台分层结构清晰，代码易读，规范；<br>"+
				"同时拥有了电子商务基础（OTP）功能；<br>"+
				"支持客户关系平台，采用前端+后端技术；<br>"+
				
				"<font color=red>版本为：v1.0.0</font>";
	leftPanel = Ext.create('Ext.Panel',{
    defaults:{frame:true,style:'margin-right:10px;margin-bottom:10px;'/**,style:'margin-left:auto;margin-right:10px;margin-top:10px;'**/},
    items:[{
          title:'最新更新',
          html:text,
	   	  bbar:['->',{
			 	xtype:'label',
				text:'更 多...',
				listeners:{
	            	click:{
			            element:'el',
			            fn:function(){
			            }
			        },
         	 	scope:this
        	   }
		 }]
      }]
	});
}
function initCenter(){
	var text = "框架采用Spring MVC Mybatis Extjs6.2.0；<br>"+
				"代码生成器，生成基础的增删改查；<br>"+
				"采用开源方式；<br>"+
				"用户，角色，组织机构，导入功能；<br>"+
				"支持全文检索Solr技术；<br>"+
				"统一查询方式；<br>"+
				"日志如登陆日志，操作日志，异常日志，启动日志等；<br>"+
				"支持统一事务处理；<br>"+
				"支持全新的流程设计器；<br>"+
				"打印，导出等功能；<br>"+
				"服务接口；<br>"+
				"跨数据源访问；<br>"+
				"支持restful风格；<br>"+
				"同时融入了移动端开发；<br>"+				
				"增强平台分页功能采用PageHelper技术；<br>"+
				"采用Activiti开源工作流引擎；<br>"+
				"前端支持多种控件如TreeGrid，普通Tree，Window,下拉Tree等；<br>"+
				"支持统一上传功能；<br>"+
				"拥有核心团队开发；<br>"+
				"支持电商平台；<br>"+
				"支持办公平台；";
	centerPanel = Ext.create('Ext.Panel',{
    defaults:{frame:true,style:'margin-right:10px;margin-bottom:10px;'/**,style:'margin-left:auto;margin-right:10px;margin-top:10px;'**/},
    items:[{
          title:'平台公告',
          html:text,
	   	  bbar:['->',{
			 	xtype:'label',
				text:'更 多...',
				listeners:{
	            	click:{
			            element:'el',
			            fn:function(){
			            }
			        },
         	 	scope:this
        	   }
		 }]
      }]
	});
}
function initRight(){
	initLoginGrid();
	rightPanel = Ext.create('Ext.Panel',{
	    region:'center',
	    defaults:{frame:true,style:'margin-right:0px;margin-bottom:10px;'/**,style:'margin-left:auto;margin-right:10px;margin-top:10px;'**/},
	    items:[
	          /**登录日志模块开始**/
	          {
	          title:'登录日志',
	          items:loginGrid,
			  bbar:['->',{
					 	xtype:'label',
						text:'刷新...',
						listeners:{
			            	click:{
					            element:'el',
					            fn:function(){
					            	loginGrid.getStore().reload();
					            }
					        },
		         	 	scope:this
		        	   }
				 }]
	          }
	          /**登录日志模块结束**/	                 
	    ]
	});
}