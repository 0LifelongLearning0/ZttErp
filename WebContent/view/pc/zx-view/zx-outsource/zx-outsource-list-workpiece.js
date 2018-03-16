/**查询工件**/
var workpieceWin;
var workpieceWinStore;
var workpieceTreeGrid;
function selectWorkpiece(){
	initWorkpieceTreeGrid();
	workpieceWin = Ext.create('top.Ext.Window',{
		layout:'fit',
		width:clientWidth*0.6,                    
		height:clientHeight*0.8, 
		maximizable:true,
		minimizable:true,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'选择项目与工件信息----请双击性质为工件才可设置',
		items:workpieceTreeGrid
	});
	workpieceWin.show();
}
function initWorkpieceTreeGrid(){
	workpieceWinStore = Ext.create('Ext.data.TreeStore',{
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
			url:'../zxProjectController/getStaticProjectAndWorkpieceTreeGrid',
			reader:{
				type:'json'
			},
			extraParams:{id:'0',type:encodeURI('项目')}
        },
        lazyFill:true
    });
	workpieceTreeGrid = Ext.create('top.Ext.tree.Panel', {
        reserveScrollbar:true,
        collapsible:false,
        loadMask:true,
        useArrows:false,
        rootVisible:false,
        store:workpieceWinStore,
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
				var id = workpieceTreeGrid.getSelectionModel().selected.items[0].data.id;
				var text = workpieceTreeGrid.getSelectionModel().selected.items[0].data.text;
				var tempObject = workpieceTreeGrid.getSelectionModel().selected.items[0].data.tempObject;
				var integerappend = workpieceTreeGrid.getSelectionModel().selected.items[0].data.integerappend;
				if(tempObject == '工件'){
					var contents = workpieceTreeGrid.getSelectionModel().selected.items[0].data.content.split('_');
					var zx_project_name = integerappend.substring(33,integerappend.length);
					var pwStr = "[<font color=red><br>项目:"+zx_project_name+"<br>"+"工件:"+text+"<br></font>]";
					top.Ext.Msg.confirm('提示','确定要选择:<br>'+pwStr+'？',function(btn){
						if(btn == 'yes'){
							top.Ext.getCmp('project_name').setValue(zx_project_name);
							top.Ext.getCmp('workpiece_num').setValue(contents[0]);
							top.Ext.getCmp('workpiece_unit').setValue(contents[1]);
							top.Ext.getCmp('workpiece_name').setValue(text);
							top.Ext.getCmp('workpiece_id').setValue(id);
							workpieceWin.close();
						}
					});
				}
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
            text:'名称',
            flex:1,
            sortable:true,
            dataIndex:'text'
        },{
            text:'性质',
            dataIndex:'tempObject',
            sortable:true,
            renderer:function(value){
				if(value == '项目'){
					return '项目'
				}else{
					return '<font color=red>工件</font>'
				}
			}
        },{
            text:'编号',
            flex:1,
            dataIndex:'content',
            renderer:function(value){
            	var vals = value.split('_');
            	if(vals.length > 1){
            		return vals[0];
            	}else{
            		return value;
            	}
            }
        },{
            text:'单位',
            flex:1,
            dataIndex:'content',
            renderer:function(value){
            	var vals = value.split('_');
            	if(vals.length > 1){
            		return vals[1];
            	}else{
            		return value;
            	}
            }
        }]
    });
}
