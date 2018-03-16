package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxMachineService;
import jehc.zxmodules.dao.ZxMachineDao;
import jehc.zxmodules.model.ZxMachine;

/**
* 加工单位 
* 2017-08-28 17:21:04  陈运芝
*/
@Service("zxMachineService")
public class ZxMachineServiceImpl extends BaseService implements ZxMachineService{
	@Autowired
	private ZxMachineDao zxMachineDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMachine> getZxMachineListByCondition(Map<String,Object> condition){
		try{
			return zxMachineDao.getZxMachineListByCondition(condition);
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
	public ZxMachine getZxMachineById(String id){
		try{
			ZxMachine zxMachine = zxMachineDao.getZxMachineById(id);
			return zxMachine;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_machine 
	* @return
	*/
	public int addZxMachine(ZxMachine zxMachine){
		int i = 0;
		try {
			i = zxMachineDao.addZxMachine(zxMachine);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_machine 
	* @return
	*/
	public int updateZxMachine(ZxMachine zxMachine){
		int i = 0;
		try {
			i = zxMachineDao.updateZxMachine(zxMachine);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_machine 
	* @return
	*/
	public int updateZxMachineBySelective(ZxMachine zxMachine){
		int i = 0;
		try {
			i = zxMachineDao.updateZxMachineBySelective(zxMachine);
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
	public int delZxMachine(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxMachineDao.delZxMachine(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_machineList 
	* @return
	*/
	public int addBatchZxMachine(List<ZxMachine> zxMachineList){
		int i = 0;
		try {
			i = zxMachineDao.addBatchZxMachine(zxMachineList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_machineList 
	* @return
	*/
	public int updateBatchZxMachine(List<ZxMachine> zxMachineList){
		int i = 0;
		try {
			i = zxMachineDao.updateBatchZxMachine(zxMachineList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_machineList 
	* @return
	*/
	public int updateBatchZxMachineBySelective(List<ZxMachine> zxMachineList){
		int i = 0;
		try {
			i = zxMachineDao.updateBatchZxMachineBySelective(zxMachineList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
