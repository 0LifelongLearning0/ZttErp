

var grid;
$(document)
		.ready(
				function() {
					// ///////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用）
					// 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
					var opt = {
						searchformId : 'searchForm'
					};
					var options = DataTablesPaging
							.pagingOptions({
								ajax : function(data, callback, settings) {
									datatablesCallBack(
											data,
											callback,
											settings,
											'../lcAgencyController/getAssigneeTaskPageList',
											opt);
								},// 渲染数据
								// 在第一位置追加序列号
								fnRowCallback : function(nRow, aData,
										iDisplayIndex) {
									jQuery('td:eq(1)', nRow).html(
											iDisplayIndex + 1);
									return nRow;
								},
								order : [],// 取消默认排序查询,否则复选框一列会出现小箭头
								// 列表表头字段
								colums : [
										{
											sClass : "text-center",
											width : "50px",
											data : "taskId",
											render : function(data, type, full,
													meta) {
												return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="'
														+ data
														+ ","
														+ full.state
														+ '" /><span></span></label>';
											},
											bSortable : false
										},
										{
											data : "taskId",
											width : "50px"
										},
										{
											data : 'name'
										},
										{
											data : 'apply_user'
										},
										{
											data : 'assignee'
										},
										{
											data : 'description'
										},
										{
											data : 'createTime',
											render : function(data, type, row,
													meta) {
													return GMTToStr(data);
											}
										},
										{
											data : "taskId",
											width : "150px",
											render : function(data, type, row,
													meta) {
												
												var opt = "<a href=\"javascript:completeTask('"
														+ data
														+ "','"+row.formKey+"')\"><span class='glyphicon glyphicon-eye-open' title='完成任务'></span></a>&emsp;";
												return opt;
											}
										} ]
							});
					grid = $('#datatables').dataTable(options);
					// 实现全选反选
					docheckboxall('checkall', 'checkchild');
					// 实现单击行选中
					clickrowselected('datatables');
				});

//完成任务
function completeTask(taskId,formKey){
	layer.open({
		type: 2, 
		area: ['1000px', '600px'],
		btn: ['关闭'],
	  content: "../lcTaskController/redirectPage?taskId="+taskId+'&formKey='+formKey,
	 
	}); 
	search('datatables');
	/*var record = grid.getSelectionModel().selected;
	if(record.length != 1){
		msgTishi('请选择要审批的一项！');
		return;
	}
	var formKey = record.items[0].data.formKey;
	var taskId = record.items[0].data.taskId;
	var params = {taskId:taskId};
	if(null != record.items[0].data.formKey && record.items[0].data.formKey != ''){
		reGetWidthAndHeight();
		approvalFormWin = Ext.create('Ext.Window',{
			layout:'fit',
			width:1500,                    
			height:clientHeight*0.8, 
			maximizable:true,
			minimizable:true,
			animateTarget:document.body,
			plain:true,
			modal:true,
			id:'approvalFormWin',
			title:'流程审批',
			html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="../lcTaskController/redirectPage?taskId='+taskId+'&formKey='+formKey+'"></iframe>',
			listeners:{
				minimize:function(win,opts){
					win.collapse();
				},
				close:function(){
					store.load();
				}
			}
		});
		approvalFormWin.show();
		layer.open({
			type: 2, 
			area: ['1000px', '600px'],
			btn: ['关闭'],
		  content: "../lcTaskController/redirectPage?taskId="+taskId+'&formKey='+formKey,
		 
		}); 
	}else{
		Ext.Msg.confirm('提示','确定要完成该任务？',function(btn){
			if(btn == 'yes'){
				var taskId = record.items[0].data.taskId;
				var params = {taskId:taskId};
				ajaxRequest('../lcTaskController/completeTask',grid,params,'完成该任务中！请稍后...');
			}
		});
	}*/
}
function GMTToStr(time){
    let date = new Date(time)
    let Str=date.getFullYear() + '-' +
    (date.getMonth() + 1) + '-' + 
    date.getDate() + ' ' + 
    date.getHours() + ':' + 
    date.getMinutes() + ':' + 
    date.getSeconds()
    return Str
}