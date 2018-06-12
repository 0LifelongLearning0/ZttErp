package jehc.zxmodules.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.allutils.StringUtil;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.xtmodules.xtcore.util.UUID;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttPurchaseService;
import jehc.zxmodules.service.ZttPurchaseSonService;
import jehc.zxmodules.dao.ZttPurchaseDao;
import jehc.zxmodules.model.ZttPurchase;
import jehc.zxmodules.model.ZttPurchaseSon;

/**
* 采购台账 
* 2018-04-03 12:43:49  季建吉
*/
@Service("zttPurchaseService")
public class ZttPurchaseServiceImpl extends BaseService implements ZttPurchaseService{
	@Autowired
	private ZttPurchaseDao zttPurchaseDao;
	@Autowired
	private ZttPurchaseSonService zttPurchaseSonService;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttPurchase> getZttPurchaseListByCondition(Map<String,Object> condition){
		try{
			return zttPurchaseDao.getZttPurchaseListByCondition(condition);
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
	public ZttPurchase getZttPurchaseById(String id){
		try{
			ZttPurchase zttPurchase = zttPurchaseDao.getZttPurchaseById(id);
			if(zttPurchase==null){
				System.out.println();
			}else{
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("parent_id", id);
				List<ZttPurchaseSon> zttPurchaseSon = zttPurchaseSonService.getZttPurchaseSonListByCondition(condition);
				zttPurchase.setZttPurchaseSon(zttPurchaseSon);
			}
			return zttPurchase;
		} catch (Exception e) {
			
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_purchase 
	* @return
	*/
	public int addZttPurchase(ZttPurchase zttPurchase1){
		int i = 0;
		try {
		/*	i = zttPurchaseDao.addZttPurchase(zttPurchase);*/
			List<ZttPurchaseSon> zttPurchaseSonTempList = zttPurchase1.getZttPurchaseSon();
			List<ZttPurchase> zttPurchaseList = new ArrayList<ZttPurchase>();
			
			for(int j = 0; j < zttPurchaseSonTempList.size(); j++){
				ZttPurchase ZttPurchase=new ZttPurchase();
				ZttPurchase.setId(UUID.toUUID());
				ZttPurchase.setProduct_order_number(zttPurchaseSonTempList.get(j).getProduct_order_number());
				ZttPurchase.setAmount(zttPurchaseSonTempList.get(j).getAmount());
				ZttPurchase.setProject(zttPurchaseSonTempList.get(j).getProject());
				ZttPurchase.setApply_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				ZttPurchase.setAttachment(zttPurchaseSonTempList.get(j).getAttachment());
				ZttPurchase.setApply_id(zttPurchase1.getApply_id());
				ZttPurchase.setUnit(zttPurchaseSonTempList.get(j).getUnit());
				ZttPurchase.setPurchase_name(zttPurchaseSonTempList.get(j).getName());
				ZttPurchase.setPurchase_stardard(zttPurchaseSonTempList.get(j).getPurchase_stardard());
				ZttPurchase.setMaterial(zttPurchaseSonTempList.get(j).getMaterial());
				ZttPurchase.setHope_end_data(zttPurchaseSonTempList.get(j).getHope_end_data());
				ZttPurchase.setAttachment(zttPurchaseSonTempList.get(j).getAttachment());
				ZttPurchase.setComment(zttPurchaseSonTempList.get(j).getComment());
				ZttPurchase.setState("0");
				zttPurchaseList.add(ZttPurchase);
			}
			if(!zttPurchaseList.isEmpty()&&zttPurchaseList.size()>0){
				i=addBatchZttPurchase(zttPurchaseList);
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
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchase(ZttPurchase zttPurchase){
		int i = 0;
		try {
			i = zttPurchaseDao.updateZttPurchase(zttPurchase);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_purchase 
	* @return
	*/
	public int updateZttPurchaseBySelective(ZttPurchase zttPurchase){
		int i = 0;
		try {
			double cost_single_price=zttPurchase.getCost_single_price();
			double amount=zttPurchase.getAmount();
			zttPurchase.setCost_sum_price(cost_single_price*amount);
			i = zttPurchaseDao.updateZttPurchaseBySelective(zttPurchase);
			
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	public int updateZttPurchaseBySelective1(ZttPurchase zttPurchase){
		int i = 0;
		try {
			i = zttPurchaseDao.updateZttPurchaseBySelective(zttPurchase);
			
			
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
	public int delZttPurchase(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttPurchaseDao.delZttPurchase(condition);
			String[] idList= (String[])condition.get("id");
			for(String id:idList){
				zttPurchaseSonService.delZttPurchaseSonByForeignKey(id);
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_purchaseList 
	* @return
	*/
	public int addBatchZttPurchase(List<ZttPurchase> zttPurchaseList){
		int i = 0;
		try {
			i = zttPurchaseDao.addBatchZttPurchase(zttPurchaseList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchase(List<ZttPurchase> zttPurchaseList){
		int i = 0;
		try {
			i = zttPurchaseDao.updateBatchZttPurchase(zttPurchaseList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_purchaseList 
	* @return
	*/
	public int updateBatchZttPurchaseBySelective(List<ZttPurchase> zttPurchaseList){
		int i = 0;
		try {
			i = zttPurchaseDao.updateBatchZttPurchaseBySelective(zttPurchaseList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
