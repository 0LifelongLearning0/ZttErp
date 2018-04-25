package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.model.ZttProcessproduct;
import jehc.zxmodules.service.ZttProcessproductService;
import java.util.HashMap;
import java.util.ArrayList;
import jehc.xtmodules.xtcore.allutils.StringUtil;
import jehc.zxmodules.service.ZttProcessproductParentService;
import jehc.zxmodules.service.ZttOrderService;
import jehc.zxmodules.dao.ZttProcessproductParentDao;
import jehc.zxmodules.model.ZttProcessproductParent;

/**
* 机械加工工艺过程母表 
* 2018-04-24 14:27:01  季建吉
*/
@Service("zttProcessproductParentService")
public class ZttProcessproductParentServiceImpl extends BaseService implements ZttProcessproductParentService{
	@Autowired
	private ZttProcessproductParentDao zttProcessproductParentDao;
	@Autowired
	private ZttProcessproductService zttProcessproductService;
	@Autowired
	private ZttOrderService ZttOrderService;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttProcessproductParent> getZttProcessproductParentListByCondition(Map<String,Object> condition){
		try{
			return zttProcessproductParentDao.getZttProcessproductParentListByCondition(condition);
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
	public ZttProcessproductParent getZttProcessproductParentById(String id){
		try{
			ZttProcessproductParent zttProcessproductParent = zttProcessproductParentDao.getZttProcessproductParentById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("parentId", id);
			List<ZttProcessproduct> zttProcessproduct = zttProcessproductService.getZttProcessproductListByCondition(condition);
			zttProcessproductParent.setZttProcessproduct(zttProcessproduct);
			return zttProcessproductParent;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int addZttProcessproductParent(ZttProcessproductParent zttProcessproductParent){
		int i = 0;
		try {
			i = zttProcessproductParentDao.addZttProcessproductParent(zttProcessproductParent);
			double amount=ZttOrderService.getZttOrderById(zttProcessproductParent.getOrder_id()).getAmount();
			List<ZttProcessproduct> zttProcessproductTempList = zttProcessproductParent.getZttProcessproduct();
			List<ZttProcessproduct> zttProcessproductList = new ArrayList<ZttProcessproduct>();
			for(int j = 0; j < zttProcessproductTempList.size(); j++){
					zttProcessproductTempList.get(j).setId(toUUID());
					zttProcessproductTempList.get(j).setParentId(zttProcessproductParent.getId());
					double single_price=zttProcessproductTempList.get(j).getSingle_price();
					zttProcessproductTempList.get(j).setSum_price(amount*single_price);
					zttProcessproductList.add(zttProcessproductTempList.get(j));
			}
			if(!zttProcessproductList.isEmpty()&&zttProcessproductList.size()>0){
				zttProcessproductService.addBatchZttProcessproduct(zttProcessproductList);
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
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int updateZttProcessproductParent(ZttProcessproductParent zttProcessproductParent){
		int i = 0;
		try {
			i = zttProcessproductParentDao.updateZttProcessproductParent(zttProcessproductParent);
			List<ZttProcessproduct> zttProcessproductList = zttProcessproductParent.getZttProcessproduct();
			List<ZttProcessproduct> zttProcessproductAddList = new ArrayList<ZttProcessproduct>();
			List<ZttProcessproduct> zttProcessproductUpdateList = new ArrayList<ZttProcessproduct>();
			for(int j = 0; j < zttProcessproductList.size(); j++){
				if(zttProcessproductParent.getZttProcessproduct_removed_flag().indexOf(","+j+",") == -1){
					if(StringUtil.isEmpty(zttProcessproductList.get(j).getId())){
						zttProcessproductList.get(j).setId(toUUID());
						zttProcessproductAddList.add(zttProcessproductList.get(j));
					}else{
						zttProcessproductUpdateList.add(zttProcessproductList.get(j));
					}
				}
			}
			if(!zttProcessproductAddList.isEmpty()&&zttProcessproductAddList.size()>0){
				zttProcessproductService.addBatchZttProcessproduct(zttProcessproductAddList);
			}
			if(!zttProcessproductUpdateList.isEmpty()&&zttProcessproductUpdateList.size()>0){
				zttProcessproductService.updateBatchZttProcessproduct(zttProcessproductUpdateList);
			}
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_processproduct_parent 
	* @return
	*/
	public int updateZttProcessproductParentBySelective(ZttProcessproductParent zttProcessproductParent){
		int i = 0;
		try {
			i = zttProcessproductParentDao.updateZttProcessproductParentBySelective(zttProcessproductParent);
			List<ZttProcessproduct> zttProcessproductList = zttProcessproductParent.getZttProcessproduct();
			List<ZttProcessproduct> zttProcessproductAddList = new ArrayList<ZttProcessproduct>();
			List<ZttProcessproduct> zttProcessproductUpdateList = new ArrayList<ZttProcessproduct>();
			for(int j = 0; j < zttProcessproductList.size(); j++){
				if(zttProcessproductParent.getZttProcessproduct_removed_flag().indexOf(","+j+",") == -1){
					if(StringUtil.isEmpty(zttProcessproductList.get(j).getId())){
						zttProcessproductList.get(j).setId(toUUID());
						zttProcessproductAddList.add(zttProcessproductList.get(j));
					}else{
						zttProcessproductUpdateList.add(zttProcessproductList.get(j));
					}
				}
			}
			if(!zttProcessproductAddList.isEmpty()&&zttProcessproductAddList.size()>0){
				zttProcessproductService.addBatchZttProcessproduct(zttProcessproductAddList);
			}
			if(!zttProcessproductUpdateList.isEmpty()&&zttProcessproductUpdateList.size()>0){
				zttProcessproductService.updateBatchZttProcessproductBySelective(zttProcessproductUpdateList);
			}
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
	public int delZttProcessproductParent(Map<String,Object> condition){
		int i = 0;
		try {
			String[] idList= (String[])condition.get("id");
			for(String id:idList){
				zttProcessproductService.delZttProcessproductByForeignKey(id);
			}
			i = zttProcessproductParentDao.delZttProcessproductParent(condition);
			
			
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int addBatchZttProcessproductParent(List<ZttProcessproductParent> zttProcessproductParentList){
		int i = 0;
		try {
			i = zttProcessproductParentDao.addBatchZttProcessproductParent(zttProcessproductParentList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int updateBatchZttProcessproductParent(List<ZttProcessproductParent> zttProcessproductParentList){
		int i = 0;
		try {
			i = zttProcessproductParentDao.updateBatchZttProcessproductParent(zttProcessproductParentList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_processproduct_parentList 
	* @return
	*/
	public int updateBatchZttProcessproductParentBySelective(List<ZttProcessproductParent> zttProcessproductParentList){
		int i = 0;
		try {
			i = zttProcessproductParentDao.updateBatchZttProcessproductParentBySelective(zttProcessproductParentList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
