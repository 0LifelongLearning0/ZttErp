package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxTrainApplyService;
import jehc.zxmodules.dao.ZxTrainApplyDao;
import jehc.zxmodules.model.ZxTrainApply;

/**
* 员工培训申请表 
* 2017-12-15 09:26:46  季建吉
*/
@Service("zxTrainApplyService")
public class ZxTrainApplyServiceImpl extends BaseService implements ZxTrainApplyService{
	@Autowired
	private ZxTrainApplyDao zxTrainApplyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxTrainApply> getZxTrainApplyListByCondition(Map<String,Object> condition){
		try{
			return zxTrainApplyDao.getZxTrainApplyListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxTrainApply> getZxTrainApproveListByCondition(Map<String,Object> condition){
		try{
			return zxTrainApplyDao.getZxTrainApproveListByCondition(condition);
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
	public ZxTrainApply getZxTrainApplyById(String id){
		try{
			ZxTrainApply zxTrainApply = zxTrainApplyDao.getZxTrainApplyById(id);
			return zxTrainApply;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_train_apply 
	* @return
	*/
	public int addZxTrainApply(ZxTrainApply zxTrainApply){
		int i = 0;
		try {
			i = zxTrainApplyDao.addZxTrainApply(zxTrainApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	/**
	* 通过申请
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApplyApply(ZxTrainApply zxTrainApply){
		int i = 0;
		try {
			i = zxTrainApplyDao.updateZxTrainApplyApply(zxTrainApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 通过培训 
	* @param zx_train_apply 
	* @return
	*/
	public int updateapproveZxTrainApprove(ZxTrainApply zxTrainApply){
		int i = 0;
		try {
			i = zxTrainApplyDao.updateapproveZxTrainApprove(zxTrainApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApply(ZxTrainApply zxTrainApply){
		int i = 0;
		try {
			i = zxTrainApplyDao.updateZxTrainApply(zxTrainApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_train_apply 
	* @return
	*/
	public int updateZxTrainApplyBySelective(ZxTrainApply zxTrainApply){
		int i = 0;
		try {
			i = zxTrainApplyDao.updateZxTrainApplyBySelective(zxTrainApply);
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
	public int delZxTrainApply(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxTrainApplyDao.delZxTrainApply(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_train_applyList 
	* @return
	*/
	public int addBatchZxTrainApply(List<ZxTrainApply> zxTrainApplyList){
		int i = 0;
		try {
			i = zxTrainApplyDao.addBatchZxTrainApply(zxTrainApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_train_applyList 
	* @return
	*/
	public int updateBatchZxTrainApply(List<ZxTrainApply> zxTrainApplyList){
		int i = 0;
		try {
			i = zxTrainApplyDao.updateBatchZxTrainApply(zxTrainApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_train_applyList 
	* @return
	*/
	public int updateBatchZxTrainApplyBySelective(List<ZxTrainApply> zxTrainApplyList){
		int i = 0;
		try {
			i = zxTrainApplyDao.updateBatchZxTrainApplyBySelective(zxTrainApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
