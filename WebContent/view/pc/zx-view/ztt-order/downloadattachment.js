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