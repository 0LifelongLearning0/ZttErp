//返回r
function goback(){
	tlocation("../zxCarController/loadZxCar");
}
/**初始化附件右键菜单开始 参数4为1表示不拥有上传和删除功能 即明细页面使用**/
initBFileRight('car_img','car_img_pic',2);
/**初始化附件右键菜单结束**/

InitBDataComboSetV("zx_car_status","state","state_");
/**配置附件回显方法开始**/
var params = {xt_attachment_id:$('#car_img').val(),field_name:'car_img'};
ajaxBFilePathBackRequest('../xtCommonController/getAttachmentPathPP',params);
/**配置附件回显方法结束**/
