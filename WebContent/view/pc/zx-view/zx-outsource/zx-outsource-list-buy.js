
/**查询采购订单**/
var orderBuyWin;
var orderBuyWinStore;
var orderBuyTreeGrid;
function selectOrderBuy(){
	initOrderBuyTreeGrid();
	orderBuyWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.6,                    
		height:clientHeight*0.8, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'采购订单列表----请双击选择订单',
		items:orderBuyTreeGrid
	});
	orderBuyWin.show();
}

function initOrderBuyTreeGrid(){
	orderBuyWinStore = Ext.create('Ext.data.TreeStore',{
    	root:{
			name:'一级',
			id:'0',
			expanded:true
		},
		/**此处一定要设置否则全部展开节点无效**/
		autoLoad:true,
        proxy:{
            type:'ajax',
            method:'post',
			url:'../zxOrderBuyController/getStaticOrderBuyTreeGrid',
			reader:{
				type:'json'
			},
			extraParams:{id:'0',type:encodeURI('订单')}
        },
        lazyFill:true
    });
	orderBuyTreeGrid = Ext.create('top.Ext.tree.Panel', {
        reserveScrollbar:true,
        collapsible:false,
        loadMask:true,
        useArrows:false,
        rootVisible:false,
        store:orderBuyWinStore,
        animate:false,
        columnLines:true,
        frame:true,
        listeners:{ 
            itemclick:function(node,optd){
            	var leaf = optd.data.leaf;
            	if(leaf == true){
            		
            	}
            }
        },
        viewConfig:{
			emptyText:'暂无数据',
			stripeRows:true
		},
		listeners:{
			'rowdblclick':function(grid, rowIndex, e){
				var id = orderBuyTreeGrid.getSelectionModel().selected.items[0].data.id;
				var text = orderBuyTreeGrid.getSelectionModel().selected.items[0].data.text;
				var tempObject = orderBuyTreeGrid.getSelectionModel().selected.items[0].data.tempObject;
				var obStr = "[<font color=red><br>订单:"+tempObject+"<br>"+"编号:"+text+"<br></font>]";
				top.Ext.Msg.confirm('提示','确定要选择:<br>'+obStr+'？',function(btn){
					if(btn == 'yes'){
						top.Ext.getCmp('buy_num').setValue(text);
						top.Ext.getCmp('buy_id').setValue(id);
						orderBuyWin.close();
					}
				});
			}
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
            text:'订单编号',
            flex:1,
            sortable:true,
            dataIndex:'text'
        },{
            text:'订单标题',
            dataIndex:'tempObject',
            sortable:true,
            renderer:function(value){
				return value;
			}
        },{
            text:'订单说明',
            flex:1,
            dataIndex:'content',
            renderer:function(value){
            	return value;
            }
        }]
    });
}