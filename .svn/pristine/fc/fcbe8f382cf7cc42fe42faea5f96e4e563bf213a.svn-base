package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxMachineDao;
import jehc.zxmodules.model.ZxMachine;

/**
* 加工单位 
* 2017-08-28 17:21:04  陈运芝
*/
@Repository("zxMachineDao")
public class ZxMachineDaoImpl  extends BaseDaoImpl implements ZxMachineDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxMachine> getZxMachineListByCondition(Map<String,Object> condition){
		return (List<ZxMachine>)this.getList("getZxMachineListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMachine getZxMachineById(String id){
		return (ZxMachine)this.get("getZxMachineById", id);
	}
	/**
	* 添加
	* @param zx_machine 
	* @return
	*/
	public int addZxMachine(ZxMachine zxMachine){
		return this.add("addZxMachine", zxMachine);
	}
	/**
	* 修改
	* @param zx_machine 
	* @return
	*/
	public int updateZxMachine(ZxMachine zxMachine){
		return this.update("updateZxMachine", zxMachine);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_machine 
	* @return
	*/
	public int updateZxMachineBySelective(ZxMachine zxMachine){
		return this.update("updateZxMachineBySelective", zxMachine);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMachine(Map<String,Object> condition){
		return this.del("delZxMachine", condition);
	}
	/**
	* 批量添加
	* @param zx_machineList 
	* @return
	*/
	public int addBatchZxMachine(List<ZxMachine> zxMachineList){
		return this.add("addBatchZxMachine", zxMachineList);
	}
	/**
	* 批量修改
	* @param zx_machineList 
	* @return
	*/
	public int updateBatchZxMachine(List<ZxMachine> zxMachineList){
		return this.update("updateBatchZxMachine", zxMachineList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_machineList 
	* @return
	*/
	public int updateBatchZxMachineBySelective(List<ZxMachine> zxMachineList){
		return this.update("updateBatchZxMachineBySelective", zxMachineList);
	}
}
