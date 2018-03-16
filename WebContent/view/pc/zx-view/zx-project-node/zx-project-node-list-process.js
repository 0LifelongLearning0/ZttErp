/**查询工件**/
var processWin;
var processWinStore;
var processTreeGrid;
function selectProcess(nodeId){
	initProcessTreeGrid(nodeId);
	processWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.6,                    
		height:clientHeight*0.8, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'请双击选择工序',
		items:processTreeGrid
	});
	processWin.show();
}
function initProcessTreeGrid(nodeId){
	processWinStore = Ext.create('Ext.data.TreeStore',{
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
			url:'../zxProcessController/getStaticProcessTreeGrid',
			reader:{
				type:'json'
			},
			extraParams:{id:'0',type:encodeURI('工序')}
        },
        lazyFill:true
    });
	processTreeGrid = Ext.create('top.Ext.tree.Panel', {
        reserveScrollbar:true,
        collapsible:false,
        loadMask:true,
        useArrows:false,
        rootVisible:false,
        store:processWinStore,
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
				var id = processTreeGrid.getSelectionModel().selected.items[0].data.id;
				var pid = processTreeGrid.getSelectionModel().selected.items[0].data.pid;
				var text = processTreeGrid.getSelectionModel().selected.items[0].data.text;
				var tempObject = processTreeGrid.getSelectionModel().selected.items[0].data.tempObject;
				var integerappend = processTreeGrid.getSelectionModel().selected.items[0].data.integerappend;
				var contents = processTreeGrid.getSelectionModel().selected.items[0].data.content.split('_');
				var zx_project_name = integerappend.substring(33,integerappend.length);
				var pwStr = "[<font color=red><br>工序:"+zx_project_name+"<br></font>]";
				top.Ext.Msg.confirm('提示','确定要选择:<br>'+pwStr+'？',function(btn){
					if(btn == 'yes'){
						top.Ext.getCmp(nodeId+'.process_text').setValue(text);
						top.Ext.getCmp(nodeId+'.process_id').setValue(id);
						processWin.close();
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
            text:'工序',
            flex:1,
            sortable:true,
            dataIndex:'text'
        }]
    });
}
