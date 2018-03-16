package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxProcess;

/**
* 工序管理 
* 2017-09-07 22:43:21  陈运芝
*/
public interface ZxProcessDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProcess> getZxProcessListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProcess getZxProcessById(String id);
	/**
	* 添加
	* @param zx_process 
	* @return
	*/
	public int addZxProcess(ZxProcess zxProcess);
	/**
	* 修改
	* @param zx_process 
	* @return
	*/
	public int updateZxProcess(ZxProcess zxProcess);
	/**
	* 修改（根据动态条件）
	* @param zx_process 
	* @return
	*/
	public int updateZxProcessBySelective(ZxProcess zxProcess);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProcess(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_processList 
	* @return
	*/
	public int addBatchZxProcess(List<ZxProcess> zxProcessList);
	/**
	* 批量修改
	* @param zx_processList 
	* @return
	*/
	public int updateBatchZxProcess(List<ZxProcess> zxProcessList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_processList 
	* @return
	*/
	public int updateBatchZxProcessBySelective(List<ZxProcess> zxProcessList);
}
