var zxLoanBillWinAdd;
var zxLoanBillFormAdd;
var zxLoanBillFormAddFieldSet;
var zxLoanBillBaseInfoFormAddFieldSet;
function addZxLoanBill(){
	initZxLoanBillFormAdd();
	zxLoanBillWinAdd = Ext.create('Ext.Window',{
		layout:'fit',
		width:780,
		height:400,
		maximizable:false,
		minimizable:false,
		animateTarget:document.body,
		plain:true,
		modal:true,
		title:'添加信息',
		listeners:{
			minimize:function(win,opts){
				if(!win.collapse()){
					win.collapse();
				}else{
					win.expand();
				}
			}
		},
		items:zxLoanBillFormAdd,
		buttons:[{
			text:'保存',
			itemId:'save',
			handler:function(button){
				submitForm(zxLoanBillFormAdd,'../zxLoanBillController/addZxLoanBill',grid,zxLoanBillWinAdd,false,true);
			}
		},{
			text:'关闭',
			itemId:'close',
			handler:function(button){
				button.up('window').close();
			}
		}]
	});
	zxLoanBillWinAdd.show();
	Ext.getCmp('user_id').setValue(xt_userinfo_id);
	Ext.getCmp('user_name').setValue(sys_pt_user_name);
	Ext.getCmp('zxcardepart').setValue(sys_pt_departinfo_name);
}
function initZxLoanBillFormAdd(){
	zxLoanBillFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
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
					name:'user_name',
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
	
	zxLoanBillBaseInfoFormAddFieldSet = Ext.create('Ext.form.FieldSet',{
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
			fieldLabel:'申请状态',
			xtype:"combo",
			queryMode:'local', 
			store:zx_loan_bill_status,
			triggerAction:"all",
			hidden:true,
            editable:false,
			allowBlank:false,
            emptyText:'请选择',
            valueField:"xt_data_dictionary_value",
            displayField:"xt_data_dictionary_name",
			name:'status',
			value : '1',
			maxLength:32,
			width:320
		},
        {
			layout:"column",
			items:[
				{
					fieldLabel:'预计结算日',
					xtype:'datefield',
					format:'Y-m-d',
					editable:false,//点击文本弹出时间控件
					name:'estimate_settle_date',
					allowBlank:false,
					maxLength:10,
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
					maxLength:100,
					width:500,
					anchor:'100%',
					readOnly:true
				},
				{
					xtype:'numberfield',
					fieldLabel:'借款金额',
					name:'balance',
					id:'balance',
					decimalPrecision:2, // 精确到小数点后两位
					maxValue:10000,// 最大值
					minValue:1, // 最小值
				//	hideTrigger:true,//隐藏上下调节按钮
					allowBlank:false,
					maxLength:20,
					width:200,
					//enableKeyEvents:true,//支持keyup事件
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

	zxLoanBillFormAdd = Ext.create('Ext.FormPanel',{
		xtype:'form',
		waitMsgTarget:true,
		defaultType:'textfield',
		autoScroll:true,
		/** 新方法使用开始* */
		scrollable:true,
		scrollable:'x',
		scrollable:'y',
		/** 新方法使用结束* */
		fieldDefaults:{
			labelWidth:70,
			labelAlign:'left',
			flex:1,
			margin:'2 5 4 5'
		},
		items:[
			zxLoanBillFormAddFieldSet,
			zxLoanBillBaseInfoFormAddFieldSet
		]
	});
}

function numtochinese(Num) {
	Num = Num + "";
	for (i = Num.length - 1; i >= 0; i--) {
		Num = Num.replace(",", "")// 替换tomoney()中的“,”
		Num = Num.replace(" ", "")// 替换tomoney()中的空格
	}

	Num = Num.replace("￥", "")// 替换掉可能出现的￥字符
	if (isNaN(Num)) {
		// 验证输入的字符是否为数字
		//alert("请检查小写金额是否正确");
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
