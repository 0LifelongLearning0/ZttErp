function downloadFile(fileName){
    if(fileName){
        var form=$("<form>");//定义一个form表单
        form.attr("style","display:none");
        form.attr("target","");
        form.attr("method","post");
        form.attr("action",'../zttOrderController/downloadfile');
        var fileInput=$("<input>");
        fileInput.attr("type","hidden");
        fileInput.attr("id","fileName");//设置属性的名字
        fileInput.attr("name","fileName");//设置属性的名字
        fileInput.attr("value",fileName);//设置属性的值
        $("body").append(form);//将表单放置在web中
        form.append(fileInput);
        form.submit();//表单提交   
        //form.remove();
    }
}
$(function(){
	var tab= $("#datatables");
	var vTr= "<tr><td>text</td><td>text</td><td>text</td></tr>"
		var attachment='['+parent.$('#attachment').html()+']';
	var json=$.parseJSON(attachment);
	$.each(json,function(name,value) {
		var path=value.path.split("-----");
		var opt="<a href=\"javascript:downloadFile('"+ value.path +"')\"><span class='glyphicon glyphicon-arrow-down' title='下载'></span></a>&emsp;";
		var vTr= "<tr><td>"+name+"</td><td>"+path[1]+"</td><td>"+opt+"</td></tr>"
		tab.append(vTr);
		});
	
	/*var tr = document.createElement("tr");
	var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tab.appendChild(tr);
    td3.innerHTML = "<input type='button' value='删除'/>"*/

	
	
	
	
})
