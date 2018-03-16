var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var options = DataTablesPaging.pagingOptions({
	ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../lcApprovalController/getLcApprovalListByCondition',null);},//渲染数据
		//在第一位置追加序列号
		fnRowCallback:function(nRow, aData, iDisplayIndex){
			jQuery('td:eq(0)', nRow).html(iDisplayIndex +1);  
			return nRow;
	},
	order:[],//取消默认排序查询,否则复选框一列会出现小箭头
	//列表表头字段
	colums:[
		{
			sClass:"text-center",
			width:"50px",
			data:"lc_approval_id",
			render:function (data, type, full, meta) {
				return '';
			},
			bSortable:false
		},
		{
			data:'lc_status_id',
			render:function(data, type, row, meta) {
				if(data == "yes"){
					return "同意";
				}else if(data == "no"){
					return "驳回";
				}else if(data == "2"){
					return "已关闭";
				}
			}
		},
		{
			data:'lc_approval_remark'
		},
		{
			data:'lc_approval_time',
			render:function(data, type, row, meta) {
				return dateformat(data); 
			}
		},
		{
			data:'xt_userinfo_realName'
		}
	]
	});
	grid=$('#datatables').dataTable(options);
});
