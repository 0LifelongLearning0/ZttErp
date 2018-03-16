package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxCarApplyService;
import jehc.zxmodules.dao.ZxCarApplyDao;
import jehc.zxmodules.model.ZxCarApply;

/**
* 车辆审批表 
* 2017-09-21 13:46:34  陈运芝
*/
@Service("zxCarApplyService")
public class ZxCarApplyServiceImpl extends BaseService implements ZxCarApplyService{
	@Autowired
	private ZxCarApplyDao zxCarApplyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxCarApply> getZxCarApplyListByCondition(Map<String,Object> condition){
		try{
			return zxCarApplyDao.getZxCarApplyListByCondition(condition);
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
	public ZxCarApply getZxCarApplyById(String id){
		try{
			ZxCarApply zxCarApply = zxCarApplyDao.getZxCarApplyById(id);
			return zxCarApply;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_car_apply 
	* @return
	*/
	public int addZxCarApply(ZxCarApply zxCarApply){
		int i = 0;
		try {
			i = zxCarApplyDao.addZxCarApply(zxCarApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_car_apply 
	* @return
	*/
	public int updateZxCarApply(ZxCarApply zxCarApply){
		int i = 0;
		try {
			i = zxCarApplyDao.updateZxCarApply(zxCarApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_car_apply 
	* @return
	*/
	public int updateZxCarApplyBySelective(ZxCarApply zxCarApply){
		int i = 0;
		try {
			i = zxCarApplyDao.updateZxCarApplyBySelective(zxCarApply);
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
	public int delZxCarApply(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxCarApplyDao.delZxCarApply(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_car_applyList 
	* @return
	*/
	public int addBatchZxCarApply(List<ZxCarApply> zxCarApplyList){
		int i = 0;
		try {
			i = zxCarApplyDao.addBatchZxCarApply(zxCarApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_car_applyList 
	* @return
	*/
	public int updateBatchZxCarApply(List<ZxCarApply> zxCarApplyList){
		int i = 0;
		try {
			i = zxCarApplyDao.updateBatchZxCarApply(zxCarApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_car_applyList 
	* @return
	*/
	public int updateBatchZxCarApplyBySelective(List<ZxCarApply> zxCarApplyList){
		int i = 0;
		try {
			i = zxCarApplyDao.updateBatchZxCarApplyBySelective(zxCarApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
