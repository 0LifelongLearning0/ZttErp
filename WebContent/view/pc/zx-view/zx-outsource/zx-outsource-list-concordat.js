
/**查询采购合同**/
var concordatWin;
var concordatWinStore;
var concordatTreeGrid;
function selectConcordat(){
	initConcordatTreeGrid();
	concordatWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.6,                    
		height:clientHeight*0.8, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'采购合同列表----请双击选择合同',
		items:concordatTreeGrid
	});
	concordatWin.show();
}

function initConcordatTreeGrid(){
	concordatWinStore = Ext.create('Ext.data.TreeStore',{
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
			url:'../zxConcordatController/getStaticConcordatTreeGrid',
			reader:{
				type:'json'
			},
			extraParams:{id:'0',type:encodeURI('合同')}
        },
        lazyFill:true
    });
	concordatTreeGrid = Ext.create('top.Ext.tree.Panel', {
        reserveScrollbar:true,
        collapsible:false,
        loadMask:true,
        useArrows:false,
        rootVisible:false,
        store:concordatWinStore,
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
				var id = concordatTreeGrid.getSelectionModel().selected.items[0].data.id;
				var text = concordatTreeGrid.getSelectionModel().selected.items[0].data.text;
				var tempObject = concordatTreeGrid.getSelectionModel().selected.items[0].data.tempObject;
				var obStr = "[<font color=red><br>合同:"+tempObject+"<br>"+"编号:"+text+"<br></font>]";
				top.Ext.Msg.confirm('提示','确定要选择:<br>'+obStr+'？',function(btn){
					if(btn == 'yes'){
						top.Ext.getCmp('concordat_num').setValue(text);
						top.Ext.getCmp('concordat_id').setValue(id);
						concordatWin.close();
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
            text:'合同编号',
            flex:1,
            sortable:true,
            dataIndex:'text'
        },{
            text:'合同标题',
            dataIndex:'tempObject',
            sortable:true,
            renderer:function(value){
				return value;
			}
        },{
            text:'合同说明',
            flex:1,
            dataIndex:'content',
            renderer:function(value){
            	return value;
            }
        }]
    });
}