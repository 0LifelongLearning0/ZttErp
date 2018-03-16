package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxProcessService;
import jehc.zxmodules.dao.ZxProcessDao;
import jehc.zxmodules.model.ZxProcess;

/**
* 工序管理 
* 2017-09-07 22:43:21  陈运芝
*/
@Service("zxProcessService")
public class ZxProcessServiceImpl extends BaseService implements ZxProcessService{
	@Autowired
	private ZxProcessDao zxProcessDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProcess> getZxProcessListByCondition(Map<String,Object> condition){
		try{
			return zxProcessDao.getZxProcessListByCondition(condition);
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
	public ZxProcess getZxProcessById(String id){
		try{
			ZxProcess zxProcess = zxProcessDao.getZxProcessById(id);
			return zxProcess;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_process 
	* @return
	*/
	public int addZxProcess(ZxProcess zxProcess){
		int i = 0;
		try {
			i = zxProcessDao.addZxProcess(zxProcess);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_process 
	* @return
	*/
	public int updateZxProcess(ZxProcess zxProcess){
		int i = 0;
		try {
			i = zxProcessDao.updateZxProcess(zxProcess);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_process 
	* @return
	*/
	public int updateZxProcessBySelective(ZxProcess zxProcess){
		int i = 0;
		try {
			i = zxProcessDao.updateZxProcessBySelective(zxProcess);
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
	public int delZxProcess(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxProcessDao.delZxProcess(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_processList 
	* @return
	*/
	public int addBatchZxProcess(List<ZxProcess> zxProcessList){
		int i = 0;
		try {
			i = zxProcessDao.addBatchZxProcess(zxProcessList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_processList 
	* @return
	*/
	public int updateBatchZxProcess(List<ZxProcess> zxProcessList){
		int i = 0;
		try {
			i = zxProcessDao.updateBatchZxProcess(zxProcessList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_processList 
	* @return
	*/
	public int updateBatchZxProcessBySelective(List<ZxProcess> zxProcessList){
		int i = 0;
		try {
			i = zxProcessDao.updateBatchZxProcessBySelective(zxProcessList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
