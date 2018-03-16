var zxLoanBillWinEdit;
var zxLoanBillFormEdit;
function updateZxLoanBill(){
	var record = grid.getSelectionModel().selected;
	if(record.length == 0){
		msgTishi('请选择要修改的一项！');
		return;
	}
	if(record.items[0].data.status != '1'){
		msgTishi('只有待申请状态数据可修改！');
		return;
	}
	initZxLoanBillFormEdit();
	zxLoanBillWinEdit = Ext.create('Ext.Window',{
		layout:'fit',
		width:780,
		height:400,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'编辑信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxLoanBillFormEdit,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxLoanBillFormEdit,'../zxLoanBillController/updateZxLoanBill',grid,zxLoanBillWinEdit,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxLoanBillWinEdit.show();
	
	loadFormDataCallBack(zxLoanBillFormEdit,'../zxLoanBillController/getZxLoanBillById?id='+ record.items[0].data.id,callFnUpdate);
}
function initZxLoanBillFormEdit(){
	
	zxLoanBillFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'借款人信息',
		items:[
        {
			layout:"column",
			items:[
				{
					fieldLabel:'借款人',
					xtype:'textfield',
					name:'user_id',
					hidden:true,
					id:'user_id',
					maxLength:32,
					width:320
				},
				{
					fieldLabel:'借款人',
					xtype:'textfield',
					id:'user_name',
					allowBlank:false,
					readOnly:true,
					maxLength:255,
					width:350
				},
				{
					fieldLabel:'部门',
					xtype:'textfield',
					name:'zxcardepart',
					id:'zxcardepart',
					maxLength:255,
					width:350,
					readOnly:true
				}
			]
		}
	]
	});
	
	zxLoanBillBaseInfoFormEditFieldSet = Ext.create('Ext.form.FieldSet',{
		anchor:'100%',
		title:'基础信息',
		items:[
		{
			fieldLabel:'借款理由',
			xtype:'textfield',
			name:'reason',
			maxLength:255,
			width:710
		},
        {
			layout:"column",
			items:[
				{
					fieldLabel:'预计结算日',
					xtype:'datefield',
					format:'Y-m-d',
					name:'estimate_settle_date',
					editable:false,//点击文本弹出时间控件
					allowBlank:false,
					maxLength:19,
					width:710
				}
			]
		},{
			layout:"column",
			items:[
				{
					fieldLabel:'中文大写',
					xtype:'textfield',
					name:'balance_cn',
					id:'balance_cn',
					allowBlank:false,
					readOnly:true,
					maxLength:100,
					width:500,
					anchor:'100%'
				},
				{
					xtype:'numberfield',
					fieldLabel:'借款金额',
					name:'balance',
					id:'balance',
					decimalPrecision:2, // 精确到小数点后两位
					maxValue:10000,// 最大值
					minValue:1, // 最小值
					allowBlank:false,
					maxLength:20,
					width:200,
			          listeners:{                 
			        	  change:function(){        
			            	  var big = numtochinese(Ext.getCmp('balance').getValue());
			            	  Ext.getCmp('balance_cn').setValue(big);
			              }               
			          }
				}
			]
		}
	]
	});
	zxLoanBillFormEdit = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		/**新方法使用开始**/
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		/**新方法使用结束**/
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
			zxLoanBillFormEditFieldSet,
			zxLoanBillBaseInfoFormEditFieldSet
		]
	});
}
function callFnUpdate(form, action){
	var borrower = action.result.data.borrower;
	if(null != borrower){
		Ext.getCmp('user_name').setValue(borrower.xt_userinfo_realName);
		Ext.getCmp('zxcardepart').setValue(borrower.xt_departinfo_name);
	}
}
function numtochinese(Num) {
	Num = Num + "";
	for (i = Num.length - 1; i >= 0; i--) {
		Num = Num.replace(",", "")// 替换tomoney()中的“,”
		Num = Num.replace(" ", "")// 替换tomoney()中的空格
	}

	Num = Num.replace("￥", "")// 替换掉可能出现的￥字符
	if (isNaN(Num)) {
		return;
	}
	// ---字符处理完毕，开始转换，转换采用前后两部分分别转换---//
	part = String(Num).split(".");
	newchar = "";
	// 小数点前进行转化
	for (i = part[0].length - 1; i >= 0; i--) {
		if (part[0].length > 10) {
			alert("位数过大，无法计算");
			return "";
		}// 若数量超过拾亿单位，提示
		tmpnewchar = ""
		perchar = part[0].charAt(i);
		switch (perchar) {
		case "0":
			tmpnewchar = "零" + tmpnewchar;
			break;
		case "1":
			tmpnewchar = "壹" + tmpnewchar;
			break;
		case "2":
			tmpnewchar = "贰" + tmpnewchar;
			break;
		case "3":
			tmpnewchar = "叁" + tmpnewchar;
			break;
		case "4":
			tmpnewchar = "肆" + tmpnewchar;
			break;
		case "5":
			tmpnewchar = "伍" + tmpnewchar;
			break;
		case "6":
			tmpnewchar = "陆" + tmpnewchar;
			break;
		case "7":
			tmpnewchar = "柒" + tmpnewchar;
			break;
		case "8":
			tmpnewchar = "捌" + tmpnewchar;
			break;
		case "9":
			tmpnewchar = "玖" + tmpnewchar;
			break;
		}
		switch (part[0].length - i - 1) {
		case 0:
			tmpnewchar = tmpnewchar + "元";
			break;
		case 1:
			if (perchar != 0)
				tmpnewchar = tmpnewchar + "拾";
			break;
		case 2:
			if (perchar != 0)
				tmpnewchar = tmpnewchar + "佰";
			break;
		case 3:
			if (perchar != 0)
				tmpnewchar = tmpnewchar + "仟";
			break;
		case 4:
			tmpnewchar = tmpnewchar + "万";
			break;
		case 5:
			if (perchar != 0)
				tmpnewchar = tmpnewchar + "拾";
			break;
		case 6:
			if (perchar != 0)
				tmpnewchar = tmpnewchar + "佰";
			break;
		case 7:
			if (perchar != 0)
				tmpnewchar = tmpnewchar + "仟";
			break;
		case 8:
			tmpnewchar = tmpnewchar + "亿";
			break;
		case 9:
			tmpnewchar = tmpnewchar + "拾";
			break;
		}
		newchar = tmpnewchar + newchar;
	}
	// 小数点之后进行转化
	if (Num.indexOf(".") != -1) {
		if (part[1].length > 2) {
		//	alert("小数点之后只能保留两位,系统将自动截段");
			part[1] = part[1].substr(0, 2)
		}
		for (i = 0; i < part[1].length; i++) {
			tmpnewchar = ""
			perchar = part[1].charAt(i)
			switch (perchar) {
			case "0":
				tmpnewchar = "零" + tmpnewchar;
				break;
			case "1":
				tmpnewchar = "壹" + tmpnewchar;
				break;
			case "2":
				tmpnewchar = "贰" + tmpnewchar;
				break;
			case "3":
				tmpnewchar = "叁" + tmpnewchar;
				break;
			case "4":
				tmpnewchar = "肆" + tmpnewchar;
				break;
			case "5":
				tmpnewchar = "伍" + tmpnewchar;
				break;
			case "6":
				tmpnewchar = "陆" + tmpnewchar;
				break;
			case "7":
				tmpnewchar = "柒" + tmpnewchar;
				break;
			case "8":
				tmpnewchar = "捌" + tmpnewchar;
				break;
			case "9":
				tmpnewchar = "玖" + tmpnewchar;
				break;
			}
			if (i == 0)
				tmpnewchar = tmpnewchar + "角";
			if (i == 1)
				tmpnewchar = tmpnewchar + "分";
			newchar = newchar + tmpnewchar;
		}
	}
	// 替换所有无用汉字
	while (newchar.search("零零") != -1)
		newchar = newchar.replace("零零", "零");
	newchar = newchar.replace("零亿", "亿");
	newchar = newchar.replace("亿万", "亿");
	newchar = newchar.replace("零万", "万");
	newchar = newchar.replace("零元", "元");
	newchar = newchar.replace("零角", "");
	newchar = newchar.replace("零分", "");

	if (newchar.charAt(newchar.length - 1) == "元"
			|| newchar.charAt(newchar.length - 1) == "角")
		newchar = newchar + "整"
	return newchar;
}
