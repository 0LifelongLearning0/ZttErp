package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxJudgeUserDao;
import jehc.zxmodules.model.ZxJudgeUser;
import jehc.zxmodules.service.ZxJudgeUserService;

/**
* 供应商评定考核人 
* 2017-09-22 11:35:03  guqian
*/
@Service("zxJudgeUserService")
public class ZxJudgeUserServiceImpl extends BaseService implements ZxJudgeUserService{
	@Autowired
	private ZxJudgeUserDao zxJudgeUserDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxJudgeUser> getZxJudgeUserListByCondition(Map<String,Object> condition){
		try{
			return zxJudgeUserDao.getZxJudgeUserListByCondition(condition);
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
	public ZxJudgeUser getZxJudgeUserById(String id){
		try{
			ZxJudgeUser zxJudgeUser = zxJudgeUserDao.getZxJudgeUserById(id);
			return zxJudgeUser;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_judge_user 
	* @return
	*/
	public int addZxJudgeUser(ZxJudgeUser zxJudgeUser){
		int i = 0;
		try {
			i = zxJudgeUserDao.addZxJudgeUser(zxJudgeUser);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_judge_user 
	* @return
	*/
	public int updateZxJudgeUser(ZxJudgeUser zxJudgeUser){
		int i = 0;
		try {
			i = zxJudgeUserDao.updateZxJudgeUser(zxJudgeUser);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_judge_user 
	* @return
	*/
	public int updateZxJudgeUserBySelective(ZxJudgeUser zxJudgeUser){
		int i = 0;
		try {
			i = zxJudgeUserDao.updateZxJudgeUserBySelective(zxJudgeUser);
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
	public int delZxJudgeUser(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxJudgeUserDao.delZxJudgeUser(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_judge_userList 
	* @return
	*/
	public int addBatchZxJudgeUser(List<ZxJudgeUser> zxJudgeUserList){
		int i = 0;
		try {
			i = zxJudgeUserDao.addBatchZxJudgeUser(zxJudgeUserList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_judge_userList 
	* @return
	*/
	public int updateBatchZxJudgeUser(List<ZxJudgeUser> zxJudgeUserList){
		int i = 0;
		try {
			i = zxJudgeUserDao.updateBatchZxJudgeUser(zxJudgeUserList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_judge_userList 
	* @return
	*/
	public int updateBatchZxJudgeUserBySelective(List<ZxJudgeUser> zxJudgeUserList){
		int i = 0;
		try {
			i = zxJudgeUserDao.updateBatchZxJudgeUserBySelective(zxJudgeUserList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
