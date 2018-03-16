package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxApplyPhoneCard;

/**
* 员工申请电话卡 
* 2017-12-05 14:49:41  owen
*/
public interface ZxApplyPhoneCardService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardListByCondition(Map<String,Object> condition);
	/**
	* 人力资源中心初始
	* @param condition 
	* @return
	*/
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardListByConditionHR(Map<String,Object> condition);
	/**
	* 查询对象
	* @param apply_user_id 
	* @return
	*/
	public List<ZxApplyPhoneCard> getZxApplyPhoneCardByUserId(String apply_user_id);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxApplyPhoneCard getZxApplyPhoneCardById(String id);
	/**
	* 添加
	* @param zx_apply_phone_card 
	* @return
	*/
	public int addZxApplyPhoneCard(ZxApplyPhoneCard zxApplyPhoneCard);
	/**
	* 修改
	* @param zx_apply_phone_card 
	* @return
	*/
	public int updateZxApplyPhoneCard(ZxApplyPhoneCard zxApplyPhoneCard);
	/**
	* 修改（根据动态条件）
	* @param zx_apply_phone_card 
	* @return
	*/
	public int updateZxApplyPhoneCardBySelective(ZxApplyPhoneCard zxApplyPhoneCard);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxApplyPhoneCard(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int addBatchZxApplyPhoneCard(List<ZxApplyPhoneCard> zxApplyPhoneCardList);
	/**
	* 批量修改
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int updateBatchZxApplyPhoneCard(List<ZxApplyPhoneCard> zxApplyPhoneCardList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_apply_phone_cardList 
	* @return
	*/
	public int updateBatchZxApplyPhoneCardBySelective(List<ZxApplyPhoneCard> zxApplyPhoneCardList);
}
