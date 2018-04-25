//返回r
function goback(){
	tlocation("../zttProcessproductParentController/loadZttProcessproductParent");
}

$(document).ready(function(){
	var size=document.getElementById("size").value;
	var index = parent.layer.getFrameIndex(window.name); 
             t = $("#example").DataTable({
                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });
             for(var i=0;i<size;i++){
                 var index= document.getElementById("ztt_processproduct["+i+"].processname").value;
                 var select;
                 if(index==1){
             		select="下料";
             	}else if(index==2){
             		select="普车加工";
             	}else if(index==3){
             		select="数车加工";
             	}else if(index==4){
             		select="加工中心";
             	}else if(index==5){
             		select="火花机";
             	}else if(index==6){
             		select="钳工";
             	}else if(index==6){
             		select="线切割";
             	}else if(index==6){
             		select="外协加工";
             	}
                     var counter = 0;
                          t.row.add([
                              i+1,
                              '<input type="hidden"/>'+select,
                              document.getElementById("ztt_processproduct["+i+"].processcontent").value,
                               document.getElementById("ztt_processproduct["+i+"].equipment").value,
                              document.getElementById("ztt_processproduct["+i+"].tooling").value,
                              document.getElementById("ztt_processproduct["+i+"].single_price").value,
                              document.getElementById("ztt_processproduct["+i+"].sum_price").value
                          ]).draw();
                          
          	}
            });