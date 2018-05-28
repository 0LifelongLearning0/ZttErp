var tab;
var number;
var attachment;
var json;
var count;
function downloadFile(number){
   /* if(fileName){
    	var id= document.getElementById("download").value;
    		var attachment='['+parent.document.getElementById(id).value+']';
    		tab
    		
    	
    }*/
	
	if(count>0){
		layer.alert("一次只能删除一个");
	}else{
		 $("#option"+number).remove();  
		 var numberint=parseInt(number);
		 var id= document.getElementById("download").value;
			json.splice(numberint,1);
			var s=JSON.stringify(json).replace(/\[|]/g,'');
			parent.document.getElementById("attachmentbefore").value=s;
	}
	count++;
	
}
$(function(){
	count=0;
	tab= $("#datatables");
	var id= document.getElementById("download").value;
	var vTr= "<tr><td>text</td><td>text</td><td>text</td></tr>"
		attachment='['+parent.document.getElementById(id).value+']';
	json=$.parseJSON(attachment);
	number=0;
	$.each(json,function(name,value) {
		var path=value.path.split("-----");
		var opt="<a href=\"javascript:downloadFile('"+ number +"')\"><span class='glyphicon glyphicon-trash' title='删除'></span></a>&emsp;";
		var vTr= "<tr id="+"option"+number+"><td>"+name+"</td><td>"+path[1]+"</td><td>"+opt+"</td></tr>"
		tab.append(vTr);
		number++;
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
