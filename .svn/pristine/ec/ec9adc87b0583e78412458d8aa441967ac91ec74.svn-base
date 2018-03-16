package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxJudgeAgainResultDao;
import jehc.zxmodules.model.ZxJudgeAgainResult;
import jehc.zxmodules.service.ZxJudgeAgainResultService;

/**
* 供应商再评审结果 
* 2017-09-26 17:22:17  a
*/
@Service("zxJudgeAgainResultService")
public class ZxJudgeAgainResultServiceImpl extends BaseService implements ZxJudgeAgainResultService{
	@Autowired
	private ZxJudgeAgainResultDao zxJudgeAgainResultDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeAgainResult> getZxJudgeAgainResultListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeAgainResultDao.getZxJudgeAgainResultListByCondition(condition);
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
	public ZxJudgeAgainResult getZxJudgeAgainResultById(String id){
		try{
			ZxJudgeAgainResult zxJudgeAgainResult = zxJudgeAgainResultDao.getZxJudgeAgainResultById(id);
			return zxJudgeAgainResult;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_judge_again_result 
	* @return
	*/
	public int addZxJudgeAgainResult(ZxJudgeAgainResult zxJudgeAgainResult){
		int i = 0;
		try {
			i = zxJudgeAgainResultDao.addZxJudgeAgainResult(zxJudgeAgainResult);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_judge_again_result 
	* @return
	*/
	public int updateZxJudgeAgainResult(ZxJudgeAgainResult zxJudgeAgainResult){
		int i = 0;
		try {
			i = zxJudgeAgainResultDao.updateZxJudgeAgainResult(zxJudgeAgainResult);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_again_result 
	* @return
	*/
	public int updateZxJudgeAgainResultBySelective(ZxJudgeAgainResult zxJudgeAgainResult){
		int i = 0;
		try {
			i = zxJudgeAgainResultDao.updateZxJudgeAgainResultBySelective(zxJudgeAgainResult);
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
	public int delZxJudgeAgainResult(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxJudgeAgainResultDao.delZxJudgeAgainResult(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_judge_again_resultList 
	* @return
	*/
	public int addBatchZxJudgeAgainResult(List<ZxJudgeAgainResult> zxJudgeAgainResultList){
		int i = 0;
		try {
			i = zxJudgeAgainResultDao.addBatchZxJudgeAgainResult(zxJudgeAgainResultList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_judge_again_resultList 
	* @return
	*/
	public int updateBatchZxJudgeAgainResult(List<ZxJudgeAgainResult> zxJudgeAgainResultList){
		int i = 0;
		try {
			i = zxJudgeAgainResultDao.updateBatchZxJudgeAgainResult(zxJudgeAgainResultList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_again_resultList 
	* @return
	*/
	public int updateBatchZxJudgeAgainResultBySelective(List<ZxJudgeAgainResult> zxJudgeAgainResultList){
		int i = 0;
		try {
			i = zxJudgeAgainResultDao.updateBatchZxJudgeAgainResultBySelective(zxJudgeAgainResultList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
