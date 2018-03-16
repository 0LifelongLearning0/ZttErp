var store;
var grid;
var approvalFormWin;
var lc_process_status_combo;
Ext.onReady(function(){
	lc_process_status_combo = Ext.create('Ext.data.SimpleStore',{ 
        fields:['value','text'],  
        data:[["yes","同意"],["no","驳回"],["2","已关闭"]]
	});
	store = getGridJsonStore('../lcAgencyController/getCandidateTaskPageList',[]);
	grid = Ext.create('Ext.grid.Panel',{
		region:'center',
		xtype:'panel',
		store:store,
		title:'查询结果',
		id:"grid",
		columnLines:true,
		selType:'cellmodel',
		multiSelect:true,
		selType:'checkboxmodel',
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
				header:'任务名称',
				locked:true,
				width:200,
				dataIndex:'name'
			}, 
			{
				header:'申请人',
				locked:true,
				dataIndex:'apply_user'
			},
			{
				header:'描述',
				width:300,
				dataIndex:'description'
			},
			{
				header:'实例编号',
				dataIndex:'processInstanceId'
			},
			{
				header:'流程定义编号',
				width:200,
				dataIndex:'processDefinitionId'
			},
			{
				header:'租户',
				dataIndex:'tenantId'
			},
			{
				header:'提交时间',
				width:200,
				dataIndex:'createTime',
				renderer:function(value){
					return Ext.util.Format.date(value, "Y-m-d H:i:s")
				}
			},
			{
				header:'操作',
				columns:[
				{
					header:'查看流程实例图',
					align:'center',
					xtype:'widgetcolumn',
					width:170,
					widget:{
		                xtype:'button',
		                text:'查看流程实例图',
		                handler:function(rec){	
		  					var id = rec.getWidgetRecord().data.processInstanceId;
		  					showLcProcessInstance(id);
					    }
		            }
				},
				{
					header:'查看流程实例审批记录',
					align:'center',
					xtype:'widgetcolumn',
					width:170,
					widget:{
		                xtype:'button',
		                text:'查看流程实例审批记录',
		                handler:function(rec){	
		  					var id = rec.getWidgetRecord().data.processInstanceId;
		  					initLcApprovalWin(id);
					    }
		            }
				}
				]
			}
		],
		tbar:[
			 {
			 	text:'签收',
				tooltip:'签收',
				cls:'addBtn',
				icon:editIcon,
				minWidth:tbarBtnMinWidth,
				handler:function(){
					claimTask();
				}
			 }
		],
		bbar:getGridBBar(store),
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
			}
		}
	});
	Ext.create('Ext.Viewport',{
		layout:'border',
		xtype:'viewport',
		items:[grid]
	});
});


function claimTask(){
	var record = grid.getSelectionModel().selected;
	if(record.length != 1){
		msgTishi('请选择要设置的一项！');
		return;
	}
	Ext.Msg.confirm('提示','确定要签收该任务？',function(btn){
		if(btn == 'yes'){
			var taskId = record.items[0].data.taskId;
			var params = {taskId:taskId,userId:xt_userinfo_id};
			ajaxRequest('../lcTaskController/claimTask',grid,params,'签收任务中！请稍后...');
		}
	});
}

/**查询操作**/
function search(){
}
