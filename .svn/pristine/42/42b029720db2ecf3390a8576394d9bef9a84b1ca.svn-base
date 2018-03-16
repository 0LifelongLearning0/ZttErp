//返回r
function goback(){
	tlocation("../zxCarController/loadZxCar");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function addZxCar(){
	submitBForm('defaultForm','../zxCarController/addZxCar','../zxCarController/loadZxCar');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});
InitBDataCombo("zx_car_status","state");
/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用**/
initBFileRight('car_img','car_img_pic',1);
/**初始化附件右键菜单结束**/


