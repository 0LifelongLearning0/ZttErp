package jehc.zxmodules.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.xtmodules.xtcore.util.UUID;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxOfficeInventoryService;
import jehc.zxmodules.dao.ZxOfficeInventoryDao;
import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxOfficeInventoryAdd;
import jehc.zxmodules.model.ZxOfficeInventoryShow;

/**
* 办公用品库存表 
* 2017-12-06 11:20:49  季建吉
*/
@Service("zxOfficeInventoryService")
public class ZxOfficeInventoryServiceImpl extends BaseService implements ZxOfficeInventoryService{
	@Autowired
	private ZxOfficeInventoryDao zxOfficeInventoryDao;
	private List<String> listid=null;
	private List<String> listclassfyid=null;
	private List<ZxOfficeInventoryShow> listzclick=null;
	/**
	* 得到用品
	* @param condition 
	* @return
	*/
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryClick(String id){
		try{
			ZxOfficeClassify ZxOfficeClassify=null;
			listid=new ArrayList<String>();
			listzclick=new ArrayList<ZxOfficeInventoryShow>();
			listclassfyid=getZxOfficeClassfyById(id);
			for(int i = 0; i < listclassfyid.size(); i++){
				List<ZxOfficeInventoryShow> listzc=zxOfficeInventoryDao.getZxOfficeInventoryClickById(listclassfyid.get(i));
				for(int j = 0; j < listzc.size(); j++){
					listzclick.add(listzc.get(j));
				}
			}
			return listzclick;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	
	/**
	* 得到补充用品信息
	* @param id
	* @return
	*/
	public ZxOfficeInventoryShow getZxOfficeInventoryAddById(String id){
		return zxOfficeInventoryDao.getZxOfficeInventoryAddById(id).get(0);
	}
	
	public List<String> getZxOfficeClassfyById(String id){
		List<ZxOfficeClassify> self=zxOfficeInventoryDao.getZxOfficeselfById(id);
		List<ZxOfficeClassify> list= zxOfficeInventoryDao.getZxOfficeInventoryClick(id);
			if(self.get(0).getClassify_leaf().equals("0")){
				for(int i = 0; i < list.size(); i++){
					ZxOfficeClassify zxOfficeClassify = list.get(i);
					//无子页
					if(zxOfficeClassify.getClassify_leaf().equals("0")){
						getZxOfficeClassfyById(zxOfficeClassify.getClassify_id());
					}else{
						listid.add(zxOfficeClassify.getClassify_id());
					}
				}
			}else{
				listid.add(self.get(0).getClassify_id());
			}
		return listid;
	}
	
	public List<String> getZxOfficeClassfyByIdRoot(String id){
		List<ZxOfficeClassify> list= zxOfficeInventoryDao.getZxOfficeInventoryClick(id);
		for(int i = 0; i < list.size(); i++){
			
			ZxOfficeClassify zxOfficeClassify = list.get(i);
			//无子页
			if(zxOfficeClassify.getClassify_leaf().equals("0")){
				getZxOfficeClassfyById(zxOfficeClassify.getClassify_id());
			}else{
				listid.add(zxOfficeClassify.getClassify_id());
			}
		}
		return listid;
	}
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOfficeInventoryShow> getZxOfficeInventoryListByCondition(Map<String,Object> condition){
		try{
			return zxOfficeInventoryDao.getZxOfficeInventoryListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOfficeInventory getZxOfficeInventoryById(String id){
		try{
			ZxOfficeInventory zxOfficeInventory = zxOfficeInventoryDao.getZxOfficeInventoryById(id);
			return zxOfficeInventory;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_office_inventory 
	* @return
	*/
	public int addZxOfficeInventory(ZxOfficeInventoryShow zxOfficeInventoryshow){
		int i = 0;
		try {
			//判断首次添加
			List<ZxOfficeInventory> list=zxOfficeInventoryDao.judgeZxOfficeInventory(zxOfficeInventoryshow.getOffice_id());
			
			ZxOfficeInventory zxOfficeInventory=new ZxOfficeInventory();
			zxOfficeInventory.setId(UUID.toUUID());
			zxOfficeInventory.setAmount(zxOfficeInventoryshow.getAmount()+zxOfficeInventoryshow.getAdd_amount());
			zxOfficeInventory.setOffice_id(zxOfficeInventoryshow.getOffice_id());
			zxOfficeInventory.setReason(zxOfficeInventoryshow.getReason());
			if(list.size()==0)
			{
				i = zxOfficeInventoryDao.addZxOfficeInventory(zxOfficeInventory);
			}
			else{
				zxOfficeInventory.setId(list.get(0).getId());
				
				i = zxOfficeInventoryDao.updateZxOfficeInventory(zxOfficeInventory);
			}
			
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/*补充表添加*/
	public int addZxOfficeInventoryAdd(ZxOfficeInventoryShow zxOfficeInventory){
		int i = 0;
		try {
			ZxOfficeInventoryAdd zxOfficeInventoryAdd=new ZxOfficeInventoryAdd();
			zxOfficeInventoryAdd.setId(UUID.toUUID());
			zxOfficeInventoryAdd.setOffice_id(zxOfficeInventory.getOffice_id());
			zxOfficeInventoryAdd.setAmount(zxOfficeInventory.getAdd_amount());
			zxOfficeInventoryAdd.setCreate_time(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			zxOfficeInventoryAdd.setUser_id(getXtUid());
			i = zxOfficeInventoryDao.addZxOfficeInventoryAdd(zxOfficeInventoryAdd);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_office_inventory 
	* @return
	*/
	public int updateZxOfficeInventory(ZxOfficeInventory zxOfficeInventory){
		int i = 0;
		try {
			i = zxOfficeInventoryDao.updateZxOfficeInventory(zxOfficeInventory);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office_inventory 
	* @return
	*/
	public int updateZxOfficeInventoryBySelective(ZxOfficeInventory zxOfficeInventory){
		int i = 0;
		try {
			i = zxOfficeInventoryDao.updateZxOfficeInventoryBySelective(zxOfficeInventory);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOfficeInventory(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOfficeInventoryDao.delZxOfficeInventory(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_office_inventoryList 
	* @return
	*/
	public int addBatchZxOfficeInventory(List<ZxOfficeInventory> zxOfficeInventoryList){
		int i = 0;
		try {
			i = zxOfficeInventoryDao.addBatchZxOfficeInventory(zxOfficeInventoryList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_office_inventoryList 
	* @return
	*/
	public int updateBatchZxOfficeInventory(List<ZxOfficeInventory> zxOfficeInventoryList){
		int i = 0;
		try {
			i = zxOfficeInventoryDao.updateBatchZxOfficeInventory(zxOfficeInventoryList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_inventoryList 
	* @return
	*/
	public int updateBatchZxOfficeInventoryBySelective(List<ZxOfficeInventory> zxOfficeInventoryList){
		int i = 0;
		try {
			i = zxOfficeInventoryDao.updateBatchZxOfficeInventoryBySelective(zxOfficeInventoryList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
