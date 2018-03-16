
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
                   document.getElementById("zxPurchaseApplyDetail["+i+"].name").value,
                     document.getElementById("zxPurchaseApplyDetail["+i+"].standard").value,
                     document.getElementById("zxPurchaseApplyDetail["+i+"].amount").value,
                    document.getElementById("zxPurchaseApplyDetail["+i+"].estimated_price").value,
                    document.getElementById("zxPurchaseApplyDetail["+i+"].reason").value
                ]).draw();
                
	}
	
});

//返回r
function goback(){
	tlocation("../zxPurchaseApplyController/loadZxPurchaseApply");
}