//返回r
function goback(){
	tlocation("../lcProcessController/loadLcProcess");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateLcProcess(){
	submitBForm('defaultForm','../lcProcessController/updateLcProcess','../lcProcessController/loadLcProcess');
}
//初始化日期选择器
$(document).ready(function(){
	datetimeInit();
});

/**初始化附件右键菜单开始 参数4为1表示拥有上传和删除功能 即新增和编辑页面使用
 *
 * fieldid:附件编号
 * picid:附件上传后回显图片对象编号
 * validateparameter:校验非法参数组装字符串
 * validateSize:校验大小
 * xt_path_absolutek:平台路径配置中心键（自定义上传对绝路径使用）
 * xt_path_urlk:平台路径配置中心键（自定义上传路径 自定义URL地址）
 * xt_path_relativek:平台路径配置中心键（自定义上传相对路径）
 * llowedFileExtensions:['jpg','gif','png']**/
initBFileRight('xt_attachment','xt_attachment_pic',1,null,null,"ActivitiLcFtp");

/**初始化附件右键菜单结束**/

/**配置附件回显方法开始**/
var params = {xt_attachment_id:$('#xt_attachment').val(),field_name:'xt_attachment'};
ajaxBFilePathBackRequest('../xtCommonController/getAttachmentPathPP',params);
/**配置附件回显方法结束**/

InitconstantListSetV(3,'xt_constant_id','xt_constant_id_');