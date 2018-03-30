//返回r
var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	var size=document.getElementById("size").value;
	 t = $("#example").DataTable({
                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });
	for(var i=0;i<size;i++){
       
           var counter = 0;
                t.row.add([
                    i+1,
                   document.getElementById("ztt_processproduct["+i+"].processname").value,
                     document.getElementById("ztt_processproduct["+i+"].processcontent").value,
                     document.getElementById("ztt_processproduct["+i+"].equipment").value,
                    document.getElementById("ztt_processproduct["+i+"].tooling").value,
                    document.getElementById("ztt_processproduct["+i+"].single_price").value,
                    document.getElementById("ztt_processproduct["+i+"].sum_price").value,
                    document.getElementById("producter_name").value,
                    document.getElementById("ztt_processproduct["+i+"].qualified_number").value,
                    document.getElementById("ztt_processproduct["+i+"].qualified_date").value,
                ]).draw();
                
	}
	
});


