package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxApplyPhoneCardDao;
import jehc.zxmodules.model.ZxApplyPhoneCard;

/**
* 员工申请电话卡 
* 2017-12-05 14:49:41  owen
*/
@Repository("zxApplyPhoneCardDao")
public class ZxApplyPhoneCardDaoImpl  extends BaseDaoImpl implements ZxApplyPhoneCardDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardListByCondition(Map<String,Object> condition){
		return (List<ZxApplyPhoneCard>)this.getList("getZxApplyPhoneCardListByCondition",condition);
	}
	/**
	* 人力资源中心初始
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardListByConditionHR(Map<String,Object> condition){
		return (List<ZxApplyPhoneCard>)this.getList("getZxApplyPhoneCardListByConditionHR",condition);
	}
	/**
	* 查询对象
	* @param condition
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardByUserId(Map<String, Object> condition) {
		return (List<ZxApplyPhoneCard>)this.getList("getZxApplyPhoneCardByUserId",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxApplyPhoneCard getZxApplyPhoneCardById(String id){
		return (ZxApplyPhoneCard)this.get("getZxApplyPhoneCardById", id);
	}
	/**
	* 添加
	* @param zx_apply_phone_card 
	* @return
	*/
	public int addZxApplyPhoneCard(ZxApplyPhoneCard zxApplyPhoneCard){
		return this.add("addZxApplyPhoneCard", zxApplyPhoneCard);
	}
	/**
	* 修改
	* @param zx_apply_phone_card 
	* @return
	*/
	public int updateZxApplyPhoneCard(ZxApplyPhoneCard zxApplyPhoneCard){
		return this.update("updateZxApplyPhoneCard", zxApplyPhoneCard);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_apply_phone_card 
	* @return
	*/
	public int updateZxApplyPhoneCardBySelective(ZxApplyPhoneCard zxApplyPhoneCard){
		return this.update("updateZxApplyPhoneCardBySelective", zxApplyPhoneCard);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxApplyPhoneCard(Map<String,Object> condition){
		return this.del("delZxApplyPhoneCard", condition);
	}
	/**
	* 批量添加
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int addBatchZxApplyPhoneCard(List<ZxApplyPhoneCard> zxApplyPhoneCardList){
		return this.add("addBatchZxApplyPhoneCard", zxApplyPhoneCardList);
	}
	/**
	* 批量修改
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int updateBatchZxApplyPhoneCard(List<ZxApplyPhoneCard> zxApplyPhoneCardList){
		return this.update("updateBatchZxApplyPhoneCard", zxApplyPhoneCardList);
	}
	/**
	* 批量修改
	* @param condition  
	* @return
	*/
	public int updateBatchZxApplyPhoneCardById(Map<String,Object> condition){
		return this.del("updateBatchZxApplyPhoneCardById", condition);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int updateBatchZxApplyPhoneCardBySelective(List<ZxApplyPhoneCard> zxApplyPhoneCardList){
		return this.update("updateBatchZxApplyPhoneCardBySelective", zxApplyPhoneCardList);
	}
}
