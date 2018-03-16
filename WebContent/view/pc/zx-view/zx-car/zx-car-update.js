//返回r
function goback(){
	tlocation("../zxCarController/loadZxCar");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxCar(){
	submitBForm('defaultForm','../zxCarController/updateZxCar','../zxCarController/loadZxCar');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
	setDate("buy_time",null,new Date());
	InitBDataComboSetV("zx_car_status","state","state_");
});
/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
initBFileRight('car_img','car_img_pic',1);
/**初始化附件右键菜单结束**/

/**配置附件回显方法开始**/
var params = {xt_attachment_id:$('#car_img').val(),field_name:'car_img'};
ajaxBFilePathBackRequest('../xtCommonController/getAttachmentPathPP',params);
/**配置附件回显方法结束**/
