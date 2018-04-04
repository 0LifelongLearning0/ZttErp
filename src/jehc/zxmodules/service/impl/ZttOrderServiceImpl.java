package jehc.zxmodules.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.xtmodules.xtcore.util.UUID;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttOrderService;
import jehc.zxmodules.dao.ZttOrderDao;
import jehc.zxmodules.model.ZttOrder;
import jehc.zxmodules.model.ZttOrderCheckHistory;
import jehc.zxmodules.model.ZttOrdernumber;
import jehc.zxmodules.model.ZttOrdernumber_third;
import jehc.zxmodules.model.ZxGoodsApply;
import jehc.zxmodules.model.ZxGoodsApplyDetail;
import jehc.zxmodules.model.ZxUserAndDepartment;
import jehc.zxmodules.model.ztt_processproduct;

/**
* 业务人员下单表 
* 2018-03-13 09:03:34  季建吉
*/
@Service("zttOrderService")
public class ZttOrderServiceImpl extends BaseService implements ZttOrderService{
	@Autowired
	private ZttOrderDao zttOrderDao;
	
	
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
	* 添加
	* @param ztt_order 
	* @return
	*/
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
			i = zttOrderDao.updateZttOrderBySelective(zttOrder);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
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
			
			zttOrdernumber = zttOrderDao.getZttOrdernumberbyId("1");
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
			}
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
