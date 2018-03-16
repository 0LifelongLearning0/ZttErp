var numbers=-1;
var t;
var counter;
$(document).ready(function(){
	var apply_id=document.getElementById("apply_id").value;
	var task_id=document.getElementById("task_id").value;
	var jsonstr=eval('(' + getbyapplyid(apply_id) + ')').data.zxGoodsApplyDetail;
	t = $("#example").DataTable({
                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });
	  $.each( jsonstr, function(index, content)
                { 
                t.row.add([
                    index+1,
                    content.office_name,
                    content.standard,
                    content.amount,
                    content.reason
                ]).draw();
              });
	 
         /*  var counter = 0;
                t.row.add([
                    i+1,
                    document.getElementById("zxGoodsApplyDetail["+i+"].office_name").value,
                     document.getElementById("zxGoodsApplyDetail["+i+"].standard").value,
                     document.getElementById("zxGoodsApplyDetail["+i+"].amount").value,
                    document.getElementById("zxGoodsApplyDetail["+i+"].reason").value
                ]).draw();*/
                
	
});


//返回r
function goback(){
	tlocation("../zxGoodsApplyController/loadZxGoodsApply");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});

