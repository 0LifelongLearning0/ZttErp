package jehc.zxmodules.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jehc.lcmodules.activitiutil.ActivitiUtil;
import jehc.lcmodules.lcdao.LcApplyDao;
import jehc.lcmodules.lcmodel.LcApply;
import jehc.lcmodules.lcservice.LcApplyService;
import jehc.lcmodules.lcservice.LcApprovalService;
import jehc.lcmodules.lcservice.LcDeploymentHisService;
import jehc.xtmodules.xtcore.base.BaseAction;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtmodel.XtConstant;
import jehc.xtmodules.xtmodel.XtUserinfo;
import jehc.xtmodules.xtservice.XtPostService;
import jehc.xtmodules.xtservice.XtURService;
import jehc.xtmodules.xtservice.XtUserinfoService;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jehc.zxmodules.service.ZttOrderService;
import jehc.zxmodules.service.ZttOrderbyselfService;
import jehc.zxmodules.service.ZttPurchaseService;
import jehc.zxmodules.dao.ZttOrderDao;
import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttOrderCheckHistory;
import jehc.zxmodules.model.ZttOrdernumber;
import jehc.zxmodules.model.ZttOrdernumber_third;
import jehc.zxmodules.model.ZxGoodsApply;
import jehc.zxmodules.model.ZxGoodsApplyDetail;
import jehc.zxmodules.model.ZxUserAndDepartment;
import jehc.zxmodules.model.ztt_filerecord;
import jehc.zxmodules.model.ztt_processproduct;

/**
* 业务人员下单表 
* 2018-03-13 09:03:34  季建吉
*/
@Service("zttOrderService")
public class ZttOrderServiceImpl extends BaseService implements ZttOrderService{
	@Autowired
	private ZttOrderDao zttOrderDao;
	@Autowired
	private LcApplyDao lcApplyDao;
	@Autowired
	private XtUserinfoService xtUserinfoService;
	@Autowired
	private XtURService xtURService;
	@Autowired
	private LcDeploymentHisService lc_Deployment_HisService;
	@Autowired
	private ActivitiUtil activitiUtil;
	@Autowired
	private LcApplyService lcApplyService;
	@Autowired
	private LcApprovalService lc_ApprovalService;
	@Autowired
	private XtPostService XtPostService;
	
	
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttOrder> getZttOrderListByCondition(Map<String,Object> condition){
		try{
			return zttOrderDao.getZttOrderListByCondition(condition);
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrder getZttOrderById(String id){
		try{
			ZttOrder zttOrder = zttOrderDao.getZttOrderById(id);
			return zttOrder;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	public String getmaxerp(String id){
		try{
			int erp=Integer.parseInt(zttOrderDao.ZttOrdernumber_max(id));
			int erp1=Integer.parseInt(zttOrderDao.ZttOrdernumber_max_purchase(id));
			int maxerp=erp>erp1?erp:erp1+1;
			return maxerp+"";
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttOrder getprocessingtechnicById(String id){
		try{
			ZttOrder zttOrder = zttOrderDao.getZttOrderById(id);
			/*ZxUserAndDepartment zxUserAndDepartment=zttOrderDao.getUserAndDepartment(zxGoodsApply.getUser_id());*/
			List<ztt_processproduct> ztt_processproductDetail = zttOrderDao.getprocessingtechnicById(id);
			zttOrder.setZtt_processproduct(ztt_processproductDetail);
			return zttOrder;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询历史对象
	* @param id 
	* @return
	*/
	public List<ZttOrderCheckHistory> getprocessinghisById(Map<String,Object> condition){
		try{
			List<ZttOrderCheckHistory> list = zttOrderDao.getZttOrderhisById(condition);
			return list;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询未申请对象
	* @param id 
	* @return
	*/
	public List<ZttOrderCheckHistory> getZttOrderNotApply(Map<String,Object> condition){
		try{
			List<ZttOrderCheckHistory> list = zttOrderDao.getZttOrderhisById(condition);
			return list;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	public List<ztt_filerecord> getfilerecordById(Map<String,Object> condition){
		try{
			List<ztt_filerecord> list = zttOrderDao.getfilerecordById(condition);
			return list;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addZttOrderfileRecord(ztt_filerecord ztt_filerecord){
		int i = 0;
		try {
			i = zttOrderDao.addZttOrderfileRecord(ztt_filerecord);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	public int addZttOrderCheckHistory(ZttOrderCheckHistory ZttOrderCheckHistory){
		int i = 0;
		try {
			i = zttOrderDao.addZttOrderCheckHistory(ZttOrderCheckHistory);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addZttOrder(ZttOrder zttOrder){
		int i = 0;
		try {
			double price=zttOrder.getSingle_price();
			double amount=zttOrder.getAmount();
			double sum=price*amount;
			zttOrder.setSum_price(sum);
			i = zttOrderDao.addZttOrder(zttOrder);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 添加
	* @param ztt_order 
	* @return
	*/
	public int addztt_processproduct(ZttOrder zttOrder){
		int i = 0;
		try {
			List<ztt_processproduct> ztt_processproduct = zttOrder.getZtt_processproduct();
			List<ztt_processproduct> zxGoodsApplyDetailList = new ArrayList<ztt_processproduct>();
			for(int j = 0; j < ztt_processproduct.size(); j++){
				ztt_processproduct.get(j).setSum_price(zttOrder.getAmount()*ztt_processproduct.get(j).getSingle_price());
				ztt_processproduct.get(j).setId(UUID.toUUID());
				ztt_processproduct.get(j).setOrder_id(zttOrder.getId());
				i=zttOrderDao.addztt_processproduct(ztt_processproduct.get(j));
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_order 
	* @return
	*/
	public int updateztt_processproduct(ZttOrder zttOrder){
		int i = 0;
		try {
			List<ztt_processproduct> ztt_processproduct = zttOrder.getZtt_processproduct();
			for(int j = 0; j < ztt_processproduct.size(); j++){
				ztt_processproduct.get(j).setQualified_date(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				i = zttOrderDao.updateztt_processproductBySelective(ztt_processproduct.get(j));
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrder(ZttOrder zttOrder){
		int i = 0;
		try {
			i = zttOrderDao.updateZttOrder(zttOrder);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_order 
	* @return
	*/
	public int updateZttOrderBySelective(ZttOrder zttOrder){
		int i = 0;
		try {
			double amount=zttOrder.getAmount();
			double Cost_single_price=zttOrder.getCost_single_price();
			double Single_price=zttOrder.getSingle_price();
			double sum_price=Single_price*amount;
			double cost_sum_price=amount*Cost_single_price;
			zttOrder.setCost_sum_price(cost_sum_price);
			zttOrder.setSum_price(sum_price);
			i = zttOrderDao.updateZttOrderBySelective(zttOrder);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	//得到当前最大工令号
	public String selectmax_id(ZttOrder zttOrder){
		int max_Ordernumber_third=zttOrderDao.selectmax_id(zttOrder.getId()).getOrdernumber_third();
		String third=(max_Ordernumber_third+1)+"";
		ZttOrdernumber zttOrdernumber = zttOrderDao.getZttOrdernumberbyId("1");
		String first = zttOrdernumber.getOrdernumber_first();
		String second=zttOrdernumber.getOrdernumber_second();
		return first+"-"+second+"-"+third;
		
	}
	public int selectmax_id_int(ZttOrder zttOrder){
		int max_Ordernumber_third=zttOrderDao.selectmax_id(zttOrder.getId()).getOrdernumber_third();
		return max_Ordernumber_third;
		
	}
	public int toApply(String apply_id,String id,String product_order_number){
		int i = 0;
		if (null != id && !"".equals(id)) {
			
			String dep_user_id = null;
			Map<String, Object> conditionr = new HashMap<String, Object>();
			conditionr.put("flag", 1);
			List<XtUserinfo> xtUserinfoList = xtURService.getXtURListByCondition(conditionr);
			ZttOrder zttOrder =getZttOrderById(id);
			apply_id=zttOrder.getApply_id();
			String order_number=null;
			XtConstant Xt_Constant = getXtConstantCache("ZttOrderApply");
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("xt_constant_id", Xt_Constant.getXt_constant_id());
			String lc_his_id = lc_Deployment_HisService.getLcDeploymentHisNewUnique(condition).getId();
			LcApply lc_Apply = new LcApply();
			Map<String, Object> variables = new HashMap<String, Object>();
			
			variables.put("taskType", "业务人员下单流程");
			variables.put("owner", apply_id);
			variables.put("taskkind", "ztt_sales");
			lc_Apply.setLc_apply_title(
					getXtU().getXt_userinfo_realName() + "于" + getSimpleDateFormat() + "，提交了一条部门申请申请流程");
			lc_Apply.setLc_apply_model_biz_id(zttOrder.getId());
			if (activitiUtil.addApply(lc_his_id, zttOrder.getId(), variables, lc_Apply)) {
				zttOrder.setState("1");
				zttOrder.setProduct_order_number(order_number);
				i =updateZttOrderBySelective(zttOrder);

			}
		}
		return i;
	}
	/**
	* 生成工令号
	* @param ztt_order 
	* @return
	*/
	public String add_ordernumber(ZttOrder zttOrder){
		ZttOrdernumber zttOrdernumber = null;
		String first;
		String insert = null;
		try {
			String Product_order_number=zttOrder.getProduct_order_number();
			int Product_order_number_int=Integer.parseInt(Product_order_number.substring(6, Product_order_number.length()));
			ZttOrdernumber_third zttOrdernumber_thirdadd=new ZttOrdernumber_third();
			zttOrdernumber_thirdadd.setOrder_id(zttOrder.getId());
			zttOrdernumber_thirdadd.setOrdernumber_third(Product_order_number_int);
			zttOrderDao.addZttOrdnum(zttOrdernumber_thirdadd);
			/*zttOrdernumber = zttOrderDao.getZttOrdernumberbyId("1");
			first = zttOrdernumber.getOrdernumber_first();
			String second=zttOrdernumber.getOrdernumber_second();
			ZttOrdernumber_third zttOrdernumber_third=zttOrderDao.getzttordernumberthirdbyId(zttOrder.getId());
			ZttOrdernumber_third zttOrdernumber_thirdadd=new ZttOrdernumber_third();
			if(zttOrdernumber_third==null){
				
				zttOrdernumber_thirdadd=zttOrderDao.selectmax_id(zttOrder.getId());
				int third=zttOrdernumber_thirdadd.getOrdernumber_third();
				int thirdnow=third+1;
				zttOrdernumber_thirdadd.setOrdernumber_third(thirdnow);
				zttOrdernumber_thirdadd.setOrder_id(zttOrder.getId());
				zttOrderDao.addZttOrdnum(zttOrdernumber_thirdadd);
				insert = first+"-"+second+"-"+thirdnow+"";
			}*/
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return insert;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrder(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttOrderDao.delZttOrder(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrderTask(String bussiness_id){
		int i = 0;
		List<LcApply> LcApply=lcApplyDao.getLcApplyByBussinessId(bussiness_id.split(",")[0]);
		for(int j=0;j<LcApply.size();j++){
			lcApplyDao.update_act_ru_task(LcApply.get(j));
		}
		
		try {
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttOrdnum(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttOrderDao.delZttOrdnum(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_orderList 
	* @return
	*/
	public int addBatchZttOrder(List<ZttOrder> zttOrderList){
		int i = 0;
		try {
			i = zttOrderDao.addBatchZttOrder(zttOrderList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrder(List<ZttOrder> zttOrderList){
		int i = 0;
		try {
			i = zttOrderDao.updateBatchZttOrder(zttOrderList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderList 
	* @return
	*/
	public int updateBatchZttOrderBySelective(List<ZttOrder> zttOrderList){
		int i = 0;
		try {
			i = zttOrderDao.updateBatchZttOrderBySelective(zttOrderList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
