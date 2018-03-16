var grid;
$(document).ready(function() {
	/////////////jehc扩展属性目的可方便使用（boot.js文件datatablesCallBack方法使用） 如弹窗分页查找根据条件 可能此时的form发生变化 此时 可以解决该类问题
	var opt = {
			searchformId:'searchForm'
		};
	var options = DataTablesPaging.pagingOptions({
		ajax:function (data, callback, settings){datatablesCallBack(data, callback, settings,'../xtDataAuthorityController/getUserinfoListByCondition',opt);},//渲染数据
			//在第一位置追加序列号
			fnRowCallback:function(nRow, aData, iDisplayIndex){
				jQuery('td:eq(1)', nRow).html(iDisplayIndex +1);  
				return nRow;
		},
		order:[],//取消默认排序查询,否则复选框一列会出现小箭头
		//列表表头字段
		colums:[
			{
				sClass:"text-center",
				width:"50px",
				data:"xt_userinfo_id",
				render:function (data, type, full, meta) {
					return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input type="checkbox" name="checkId" class="checkchild " value="' + data +','+full.xt_userinfo_realName+'" /><span></span></label>';
				},
				bSortable:false
			},
			{
				data:"xt_userinfo_id",
				width:"150px"
			},
			{
				data:'xt_userinfo_realName'
			}
		]
	});
	grid=$('#datatables').dataTable(options);
	//实现单击行选中
	clickrowselected('datatables');
});
//返回r
function goback(){
	tlocation("../zxChangeContractController/toZxChangeContractAdd");
}
function ZxChangeContractUserChoose(){
	if(returncheckedLength('checkchild') != 1){
		toastrBoot(4,"请选择一个员工");
		return;
	}
	var strs = $(".checkchild:checked").val();
	var str = strs.split(",");
	var id = str[0];
	var user_name = str[1];
	msgTishCallFnBoot("确定要选择【<font color=red>"+user_name+"</font>】？",function(){
		/*$("#xt_user_id").val(id);
		$("#user_name").val(user_name);*/
		tlocation("../zxChangeContractController/toZxChangeContractAdd?xt_user_id="+id);
	})
}