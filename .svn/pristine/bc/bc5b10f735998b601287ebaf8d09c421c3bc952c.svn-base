package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxProjectWokingService;
import jehc.zxmodules.dao.ZxProjectWokingDao;
import jehc.zxmodules.model.ZxProjectWoking;

/**
* 项目节点工时记录表 
* 2017-09-07 23:52:08  陈运芝
*/
@Service("zxProjectWokingService")
public class ZxProjectWokingServiceImpl extends BaseService implements ZxProjectWokingService{
	@Autowired
	private ZxProjectWokingDao zxProjectWokingDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProjectWoking> getZxProjectWokingListByCondition(Map<String,Object> condition){
		try{
			return zxProjectWokingDao.getZxProjectWokingListByCondition(condition);
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
	public ZxProjectWoking getZxProjectWokingById(String id){
		try{
			ZxProjectWoking zxProjectWoking = zxProjectWokingDao.getZxProjectWokingById(id);
			return zxProjectWoking;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_project_woking 
	* @return
	*/
	public int addZxProjectWoking(ZxProjectWoking zxProjectWoking){
		int i = 0;
		try {
			i = zxProjectWokingDao.addZxProjectWoking(zxProjectWoking);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_project_woking 
	* @return
	*/
	public int updateZxProjectWoking(ZxProjectWoking zxProjectWoking){
		int i = 0;
		try {
			i = zxProjectWokingDao.updateZxProjectWoking(zxProjectWoking);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_project_woking 
	* @return
	*/
	public int updateZxProjectWokingBySelective(ZxProjectWoking zxProjectWoking){
		int i = 0;
		try {
			i = zxProjectWokingDao.updateZxProjectWokingBySelective(zxProjectWoking);
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
	public int delZxProjectWoking(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxProjectWokingDao.delZxProjectWoking(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_project_wokingList 
	* @return
	*/
	public int addBatchZxProjectWoking(List<ZxProjectWoking> zxProjectWokingList){
		int i = 0;
		try {
			i = zxProjectWokingDao.addBatchZxProjectWoking(zxProjectWokingList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_project_wokingList 
	* @return
	*/
	public int updateBatchZxProjectWoking(List<ZxProjectWoking> zxProjectWokingList){
		int i = 0;
		try {
			i = zxProjectWokingDao.updateBatchZxProjectWoking(zxProjectWokingList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_project_wokingList 
	* @return
	*/
	public int updateBatchZxProjectWokingBySelective(List<ZxProjectWoking> zxProjectWokingList){
		int i = 0;
		try {
			i = zxProjectWokingDao.updateBatchZxProjectWokingBySelective(zxProjectWokingList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 根据外键删除方法
	* @param node_id
	* @return
	*/
	public int delZxProjectWokingByForeignKey(String node_id){
		int i = 0;
		try {
			i = zxProjectWokingDao.delZxProjectWokingByForeignKey(node_id);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
