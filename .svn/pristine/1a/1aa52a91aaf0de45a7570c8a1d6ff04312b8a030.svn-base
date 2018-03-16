package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxMachine;

/**
* 加工单位 
* 2017-08-28 17:21:04  陈运芝
*/
public interface ZxMachineService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMachine> getZxMachineListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxMachine getZxMachineById(String id);
	/**
	* 添加
	* @param zx_machine 
	* @return
	*/
	public int addZxMachine(ZxMachine zxMachine);
	/**
	* 修改
	* @param zx_machine 
	* @return
	*/
	public int updateZxMachine(ZxMachine zxMachine);
	/**
	* 修改（根据动态条件）
	* @param zx_machine 
	* @return
	*/
	public int updateZxMachineBySelective(ZxMachine zxMachine);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxMachine(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_machineList 
	* @return
	*/
	public int addBatchZxMachine(List<ZxMachine> zxMachineList);
	/**
	* 批量修改
	* @param zx_machineList 
	* @return
	*/
	public int updateBatchZxMachine(List<ZxMachine> zxMachineList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_machineList 
	* @return
	*/
	public int updateBatchZxMachineBySelective(List<ZxMachine> zxMachineList);
}
