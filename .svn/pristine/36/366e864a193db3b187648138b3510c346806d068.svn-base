package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxJudgeResultDao;
import jehc.zxmodules.model.ZxJudgeResult;
import jehc.zxmodules.service.ZxJudgeResultService;

/**
* 供应商验厂结果 
* 2017-09-22 11:04:19  guqian
*/
@Service("zxJudgeResultService")
public class ZxJudgeResultServiceImpl extends BaseService implements ZxJudgeResultService{
	@Autowired
	private ZxJudgeResultDao zxJudgeResultDao;
	
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeResult> getZxJudgeResultListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeResultDao.getZxJudgeResultListByCondition(condition);
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
	public ZxJudgeResult getZxJudgeResultById(String id){
		try{
			ZxJudgeResult zxJudgeResult = zxJudgeResultDao.getZxJudgeResultById(id);
			return zxJudgeResult;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_judge_result 
	* @return
	*/
	public int addZxJudgeResult(ZxJudgeResult zxJudgeResult){
		int i = 0;
		try {
			i = zxJudgeResultDao.addZxJudgeResult(zxJudgeResult);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_judge_result 
	* @return
	*/
	public int updateZxJudgeResult(ZxJudgeResult zxJudgeResult){
		int i = 0;
		try {
			i = zxJudgeResultDao.updateZxJudgeResult(zxJudgeResult);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_result 
	* @return
	*/
	public int updateZxJudgeResultBySelective(ZxJudgeResult zxJudgeResult){
		int i = 0;
		try {
			i = zxJudgeResultDao.updateZxJudgeResultBySelective(zxJudgeResult);
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
	public int delZxJudgeResult(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxJudgeResultDao.delZxJudgeResult(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_judge_resultList 
	* @return
	*/
	public int addBatchZxJudgeResult(List<ZxJudgeResult> zxJudgeResultList){
		int i = 0;
		try {
			i = zxJudgeResultDao.addBatchZxJudgeResult(zxJudgeResultList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_judge_resultList 
	* @return
	*/
	public int updateBatchZxJudgeResult(List<ZxJudgeResult> zxJudgeResultList){
		int i = 0;
		try {
			i = zxJudgeResultDao.updateBatchZxJudgeResult(zxJudgeResultList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_resultList 
	* @return
	*/
	public int updateBatchZxJudgeResultBySelective(List<ZxJudgeResult> zxJudgeResultList){
		int i = 0;
		try {
			i = zxJudgeResultDao.updateBatchZxJudgeResultBySelective(zxJudgeResultList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
