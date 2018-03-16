package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxBuyApplyService;
import jehc.zxmodules.dao.ZxBuyApplyDao;
import jehc.zxmodules.model.ZxBuyApply;

/**
* 采购申请单 
* 2017-10-26 10:41:49  陈运芝
*/
@Service("zxBuyApplyService")
public class ZxBuyApplyServiceImpl extends BaseService implements ZxBuyApplyService{
	@Autowired
	private ZxBuyApplyDao zxBuyApplyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxBuyApply> getZxBuyApplyListByCondition(Map<String,Object> condition){
		try{
			return zxBuyApplyDao.getZxBuyApplyListByCondition(condition);
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
	public ZxBuyApply getZxBuyApplyById(String id){
		try{
			ZxBuyApply zxBuyApply = zxBuyApplyDao.getZxBuyApplyById(id);
			return zxBuyApply;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_buy_apply 
	* @return
	*/
	public int addZxBuyApply(ZxBuyApply zxBuyApply){
		int i = 0;
		try {
			i = zxBuyApplyDao.addZxBuyApply(zxBuyApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_buy_apply 
	* @return
	*/
	public int updateZxBuyApply(ZxBuyApply zxBuyApply){
		int i = 0;
		try {
			i = zxBuyApplyDao.updateZxBuyApply(zxBuyApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_buy_apply 
	* @return
	*/
	public int updateZxBuyApplyBySelective(ZxBuyApply zxBuyApply){
		int i = 0;
		try {
			i = zxBuyApplyDao.updateZxBuyApplyBySelective(zxBuyApply);
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
	public int delZxBuyApply(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxBuyApplyDao.delZxBuyApply(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_buy_applyList 
	* @return
	*/
	public int addBatchZxBuyApply(List<ZxBuyApply> zxBuyApplyList){
		int i = 0;
		try {
			i = zxBuyApplyDao.addBatchZxBuyApply(zxBuyApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_buy_applyList 
	* @return
	*/
	public int updateBatchZxBuyApply(List<ZxBuyApply> zxBuyApplyList){
		int i = 0;
		try {
			i = zxBuyApplyDao.updateBatchZxBuyApply(zxBuyApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_applyList 
	* @return
	*/
	public int updateBatchZxBuyApplyBySelective(List<ZxBuyApply> zxBuyApplyList){
		int i = 0;
		try {
			i = zxBuyApplyDao.updateBatchZxBuyApplyBySelective(zxBuyApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
