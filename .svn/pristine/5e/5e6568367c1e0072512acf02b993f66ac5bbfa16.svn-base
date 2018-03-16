package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxJudgeStandardDao;
import jehc.zxmodules.model.ZxJudgeStandard;
import jehc.zxmodules.service.ZxJudgeStandardService;

/**
* 供应商评定标准 
* 2017-09-21 13:16:25  guqian
*/
@Service("zxJudgeStandardService")
public class ZxJudgeStandardServiceImpl extends BaseService implements ZxJudgeStandardService{
	@Autowired
	private ZxJudgeStandardDao zxJudgeStandardDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeStandard> getZxJudgeStandardListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeStandardDao.getZxJudgeStandardListByCondition(condition);
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
	public ZxJudgeStandard getZxJudgeStandardById(String id){
		try{
			ZxJudgeStandard zxJudgeStandard = zxJudgeStandardDao.getZxJudgeStandardById(id);
			return zxJudgeStandard;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_judge_standard 
	* @return
	*/
	public int addZxJudgeStandard(ZxJudgeStandard zxJudgeStandard){
		int i = 0;
		try {
			i = zxJudgeStandardDao.addZxJudgeStandard(zxJudgeStandard);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_judge_standard 
	* @return
	*/
	public int updateZxJudgeStandard(ZxJudgeStandard zxJudgeStandard){
		int i = 0;
		try {
			i = zxJudgeStandardDao.updateZxJudgeStandard(zxJudgeStandard);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_standard 
	* @return
	*/
	public int updateZxJudgeStandardBySelective(ZxJudgeStandard zxJudgeStandard){
		int i = 0;
		try {
			i = zxJudgeStandardDao.updateZxJudgeStandardBySelective(zxJudgeStandard);
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
	public int delZxJudgeStandard(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxJudgeStandardDao.delZxJudgeStandard(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_judge_standardList 
	* @return
	*/
	public int addBatchZxJudgeStandard(List<ZxJudgeStandard> zxJudgeStandardList){
		int i = 0;
		try {
			i = zxJudgeStandardDao.addBatchZxJudgeStandard(zxJudgeStandardList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_judge_standardList 
	* @return
	*/
	public int updateBatchZxJudgeStandard(List<ZxJudgeStandard> zxJudgeStandardList){
		int i = 0;
		try {
			i = zxJudgeStandardDao.updateBatchZxJudgeStandard(zxJudgeStandardList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_standardList 
	* @return
	*/
	public int updateBatchZxJudgeStandardBySelective(List<ZxJudgeStandard> zxJudgeStandardList){
		int i = 0;
		try {
			i = zxJudgeStandardDao.updateBatchZxJudgeStandardBySelective(zxJudgeStandardList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	public List<Map<String,String>> getDepListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeStandardDao.getDepListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
}
