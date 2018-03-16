package jehc.zxmodules.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxApplyPhoneCardService;
import jehc.zxmodules.dao.ZxApplyPhoneCardDao;
import jehc.zxmodules.model.ZxApplyPhoneCard;

/**
* 员工申请电话卡 
* 2017-12-05 14:49:41  owen
*/
@Service("zxApplyPhoneCardService")
public class ZxApplyPhoneCardServiceImpl extends BaseService implements ZxApplyPhoneCardService{
	@Autowired
	private ZxApplyPhoneCardDao zxApplyPhoneCardDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardListByCondition(Map<String,Object> condition){
		try{
			return zxApplyPhoneCardDao.getZxApplyPhoneCardListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 人力资源中心分页
	* @param condition 
	* @return
	*/
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardListByConditionHR(Map<String,Object> condition){
		try{
			return zxApplyPhoneCardDao.getZxApplyPhoneCardListByConditionHR(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	
	/**
	* 查询对象
	* @param condition 
	* @return
	*/
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardByUserId(String apply_user_id){
		try{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("apply_user_id", apply_user_id);
			map.put("status", 3);
			return zxApplyPhoneCardDao.getZxApplyPhoneCardByUserId(map);
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
	public ZxApplyPhoneCard getZxApplyPhoneCardById(String id){
		try{
			ZxApplyPhoneCard zxApplyPhoneCard = zxApplyPhoneCardDao.getZxApplyPhoneCardById(id);
			return zxApplyPhoneCard;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_apply_phone_card 
	* @return
	*/
	public int addZxApplyPhoneCard(ZxApplyPhoneCard zxApplyPhoneCard){
		int i = 0;
		try {
			i = zxApplyPhoneCardDao.addZxApplyPhoneCard(zxApplyPhoneCard);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_apply_phone_card 
	* @return
	*/
	public int updateZxApplyPhoneCard(ZxApplyPhoneCard zxApplyPhoneCard){
		int i = 0;
		try {
			i = zxApplyPhoneCardDao.updateZxApplyPhoneCard(zxApplyPhoneCard);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_apply_phone_card 
	* @return
	*/
	public int updateZxApplyPhoneCardBySelective(ZxApplyPhoneCard zxApplyPhoneCard){
		int i = 0;
		try {
			i = zxApplyPhoneCardDao.updateZxApplyPhoneCardBySelective(zxApplyPhoneCard);
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
	public int delZxApplyPhoneCard(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxApplyPhoneCardDao.delZxApplyPhoneCard(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int addBatchZxApplyPhoneCard(List<ZxApplyPhoneCard> zxApplyPhoneCardList){
		int i = 0;
		try {
			i = zxApplyPhoneCardDao.addBatchZxApplyPhoneCard(zxApplyPhoneCardList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int updateBatchZxApplyPhoneCard(List<ZxApplyPhoneCard> zxApplyPhoneCardList){
		int i = 0;
		try {
			i = zxApplyPhoneCardDao.updateBatchZxApplyPhoneCard(zxApplyPhoneCardList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int updateBatchZxApplyPhoneCardBySelective(List<ZxApplyPhoneCard> zxApplyPhoneCardList){
		int i = 0;
		try {
			i = zxApplyPhoneCardDao.updateBatchZxApplyPhoneCardBySelective(zxApplyPhoneCardList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
