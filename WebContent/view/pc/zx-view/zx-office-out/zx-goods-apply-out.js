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
                    '<input type="hidden" name="zxGoodsApplyDetail['+i+'].goods_id"  value="'+document.getElementById("zxGoodsApplyDetail["+i+"].goods_id").value+'"/>'+
                    document.getElementById("zxGoodsApplyDetail["+i+"].office_name").value,
                     document.getElementById("zxGoodsApplyDetail["+i+"].standard").value,
                     '<input type="hidden" name="zxGoodsApplyDetail['+i+'].amount" value="'+document.getElementById("zxGoodsApplyDetail["+i+"].amount").value+'"/>'+
                     document.getElementById("zxGoodsApplyDetail["+i+"].amount").value,
                    document.getElementById("zxGoodsApplyDetail["+i+"].reason").value
                ]).draw();
                
	}
	
});

//返回r
function goback(){
	tlocation("../zxOfficeOutController/loadZxOfficeOut");
}
$('#defaultForm').bootstrapValidator({
	message:'此值不是有效的'
});
//保存
function updateZxGoodsApply(){
	submitBForm('defaultForm','../zxGoodsApplyController/outZxGoodsApply','../zxGoodsApplyController/loadZxGoodsApply');
}


