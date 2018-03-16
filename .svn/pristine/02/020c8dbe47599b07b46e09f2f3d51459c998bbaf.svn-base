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
                   document.getElementById("zxGoodsApplyDetail["+i+"].office_name").value,
                     document.getElementById("zxGoodsApplyDetail["+i+"].standard").value,
                     document.getElementById("zxGoodsApplyDetail["+i+"].amount").value,
                    document.getElementById("zxGoodsApplyDetail["+i+"].reason").value
                ]).draw();
                
	}
	
});


function goback(){
	tlocation("../zxGoodsApplyController/loadZxGoodsApply");
}

