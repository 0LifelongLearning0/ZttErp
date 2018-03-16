Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tip.*',
    'Ext.tree.*'
]);
/**查询物料**/
var materialWin;
var materialWinStore;
var materialTreeGrid;
function selectMaterial(){
	initMaterialTreeGrid();
	materialWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:800,                    
		height:600, 
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'选择分类与物料信息----请双击性质为物料才可设置',
		items:materialTreeGrid
	});
	materialWin.show();
}
function initMaterialTreeGrid(){
	materialWinStore = Ext.create('top.Ext.data.TreeStore',{
    	root:{
			name:'分类',
			id:'0',
			expanded:true
		},
        proxy:{
            type:'ajax',
            method:'post',
			url:'../zxOfficeInventoryController/getZxOfficeInventoryTree',
			reader:{
				type:'json'
			},
			extraParams:{
				id:'0',
				type:encodeURI('分类'),
				expanded:true
			}
        },
        lazyFill:true
    });
	materialTreeGrid = Ext.create('top.Ext.tree.Panel', {
		useArrows : collapsibleDefined,
        reserveScrollbar:true,
        collapsible:false,
        loadMask:true,
        rootVisible:false,
        store:materialWinStore,
        animate:false,
        columnLines:true,
        frame:true,
        listeners:{ 
        	beforeitemexpand:function(node,optd){
                var id=node.data.id; 
                var type=node.data.type; 
                materialWinStore.setProxy({   
		       	   //异步从服务器上加载数据extjs会自动帮我们解析  
		           type:'ajax',  
		           url:'../zxOfficeInventoryController/getZxOfficeInventoryTree',  
		           extraParams:{id:id,type:encodeURI(type)}
		        });  
            },
            itemclick:function(node,optd){
            	var leaf = optd.data.leaf;
            	if(leaf == true){
            		
            	}
            },
            'rowdblclick':function(grid, rowIndex, e){
				var id = materialTreeGrid.getSelectionModel().selected.items[0].data.id;
				var text = materialTreeGrid.getSelectionModel().selected.items[0].data.text;
				var type = materialTreeGrid.getSelectionModel().selected.items[0].data.type;
				var num = materialTreeGrid.getSelectionModel().selected.items[0].data.num;
				var standard = materialTreeGrid.getSelectionModel().selected.items[0].data.standard;
				var amount=materialTreeGrid.getSelectionModel().selected.items[0].data.amount;
				if(type == '用品'){
					var pwStr = "[<font color=red><br>用品:"+text+"<br>"+"编号:"+num+"<br>"+"型号:"+standard+"<br></font>]";
					/*top.Ext.Msg.confirm('提示','确定要选择:<br>'+pwStr+'？',function(btn){*/
						/*if(btn == 'yes'){*/
							Ext.getCmp('office_num').setValue(num);
							Ext.getCmp('standard').setValue(standard);
							Ext.getCmp('office_name').setValue(text);
							Ext.getCmp('office_id').setValue(id);
							Ext.getCmp('amount').setValue(amount);
							materialWin.close();
					/*	}*/
				/*	});*/
				}
			}
        },
        viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
        columns:[{
            text:'ID',
            flex:2,
            hideable:false,
            hidden:true,
            sortable:true,
            dataIndex:'id'
        },{
            xtype:'treecolumn',
            text:'名称',
            flex:1,
            sortable:true,
            dataIndex:'text'
        },{
            text:'性质',
            dataIndex:'type',
            sortable:true,
            renderer:function(value){
				if(value == '分类'){
					return '分类'
				}else{
					return '<font color=red>用品</font>'
				}
			}
        },{
            text:'编号',
            dataIndex:'num'
        },{
            text:'规格型号',
            width:200,
            dataIndex:'standard'
        }]
    });
}
