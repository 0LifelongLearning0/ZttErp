package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxJudgeApplyDao;
import jehc.zxmodules.model.ZxJudgeApply;
import jehc.zxmodules.service.ZxJudgeApplyService;

/**
* 供应商验厂申请单 
* 2017-09-25 09:27:09  g
*/
@Service("zxJudgeApplyService")
public class ZxJudgeApplyServiceImpl extends BaseService implements ZxJudgeApplyService{
	@Autowired
	private ZxJudgeApplyDao zxJudgeApplyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeApply> getZxJudgeApplyListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeApplyDao.getZxJudgeApplyListByCondition(condition);
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
	public ZxJudgeApply getZxJudgeApplyById(String id){
		try{
			ZxJudgeApply zxJudgeApply = zxJudgeApplyDao.getZxJudgeApplyById(id);
			return zxJudgeApply;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_judge_apply 
	* @return
	*/
	public int addZxJudgeApply(ZxJudgeApply zxJudgeApply){
		int i = 0;
		try {
			i = zxJudgeApplyDao.addZxJudgeApply(zxJudgeApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_judge_apply 
	* @return
	*/
	public int updateZxJudgeApply(ZxJudgeApply zxJudgeApply){
		int i = 0;
		try {
			i = zxJudgeApplyDao.updateZxJudgeApply(zxJudgeApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_apply 
	* @return
	*/
	public int updateZxJudgeApplyBySelective(ZxJudgeApply zxJudgeApply){
		int i = 0;
		try {
			i = zxJudgeApplyDao.updateZxJudgeApplyBySelective(zxJudgeApply);
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
	public int delZxJudgeApply(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxJudgeApplyDao.delZxJudgeApply(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_judge_applyList 
	* @return
	*/
	public int addBatchZxJudgeApply(List<ZxJudgeApply> zxJudgeApplyList){
		int i = 0;
		try {
			i = zxJudgeApplyDao.addBatchZxJudgeApply(zxJudgeApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_judge_applyList 
	* @return
	*/
	public int updateBatchZxJudgeApply(List<ZxJudgeApply> zxJudgeApplyList){
		int i = 0;
		try {
			i = zxJudgeApplyDao.updateBatchZxJudgeApply(zxJudgeApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_applyList 
	* @return
	*/
	public int updateBatchZxJudgeApplyBySelective(List<ZxJudgeApply> zxJudgeApplyList){
		int i = 0;
		try {
			i = zxJudgeApplyDao.updateBatchZxJudgeApplyBySelective(zxJudgeApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
