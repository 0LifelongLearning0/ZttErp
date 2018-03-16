package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxJudgeAttachService;
import jehc.zxmodules.dao.ZxJudgeAttachDao;
import jehc.zxmodules.model.ZxJudgeAttach;

/**
* 供应商评定附件 
* 2017-09-30 16:08:00  a
*/
@Service("zxJudgeAttachService")
public class ZxJudgeAttachServiceImpl extends BaseService implements ZxJudgeAttachService{
	@Autowired
	private ZxJudgeAttachDao zxJudgeAttachDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeAttach> getZxJudgeAttachListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeAttachDao.getZxJudgeAttachListByCondition(condition);
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
	public ZxJudgeAttach getZxJudgeAttachById(String id){
		try{
			ZxJudgeAttach zxJudgeAttach = zxJudgeAttachDao.getZxJudgeAttachById(id);
			return zxJudgeAttach;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_judge_attach 
	* @return
	*/
	public int addZxJudgeAttach(ZxJudgeAttach zxJudgeAttach){
		int i = 0;
		try {
			i = zxJudgeAttachDao.addZxJudgeAttach(zxJudgeAttach);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_judge_attach 
	* @return
	*/
	public int updateZxJudgeAttach(ZxJudgeAttach zxJudgeAttach){
		int i = 0;
		try {
			i = zxJudgeAttachDao.updateZxJudgeAttach(zxJudgeAttach);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_attach 
	* @return
	*/
	public int updateZxJudgeAttachBySelective(ZxJudgeAttach zxJudgeAttach){
		int i = 0;
		try {
			i = zxJudgeAttachDao.updateZxJudgeAttachBySelective(zxJudgeAttach);
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
	public int delZxJudgeAttach(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxJudgeAttachDao.delZxJudgeAttach(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_judge_attachList 
	* @return
	*/
	public int addBatchZxJudgeAttach(List<ZxJudgeAttach> zxJudgeAttachList){
		int i = 0;
		try {
			i = zxJudgeAttachDao.addBatchZxJudgeAttach(zxJudgeAttachList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_judge_attachList 
	* @return
	*/
	public int updateBatchZxJudgeAttach(List<ZxJudgeAttach> zxJudgeAttachList){
		int i = 0;
		try {
			i = zxJudgeAttachDao.updateBatchZxJudgeAttach(zxJudgeAttachList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_attachList 
	* @return
	*/
	public int updateBatchZxJudgeAttachBySelective(List<ZxJudgeAttach> zxJudgeAttachList){
		int i = 0;
		try {
			i = zxJudgeAttachDao.updateBatchZxJudgeAttachBySelective(zxJudgeAttachList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
