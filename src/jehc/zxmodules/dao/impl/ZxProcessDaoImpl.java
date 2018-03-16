package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxProcessDao;
import jehc.zxmodules.model.ZxProcess;

/**
* 工序管理 
* 2017-09-07 22:43:21  陈运芝
*/
@Repository("zxProcessDao")
public class ZxProcessDaoImpl  extends BaseDaoImpl implements ZxProcessDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxProcess> getZxProcessListByCondition(Map<String,Object> condition){
		return (List<ZxProcess>)this.getList("getZxProcessListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProcess getZxProcessById(String id){
		return (ZxProcess)this.get("getZxProcessById", id);
	}
	/**
	* 添加
	* @param zx_process 
	* @return
	*/
	public int addZxProcess(ZxProcess zxProcess){
		return this.add("addZxProcess", zxProcess);
	}
	/**
	* 修改
	* @param zx_process 
	* @return
	*/
	public int updateZxProcess(ZxProcess zxProcess){
		return this.update("updateZxProcess", zxProcess);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_process 
	* @return
	*/
	public int updateZxProcessBySelective(ZxProcess zxProcess){
		return this.update("updateZxProcessBySelective", zxProcess);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProcess(Map<String,Object> condition){
		return this.del("delZxProcess", condition);
	}
	/**
	* 批量添加
	* @param zx_processList 
	* @return
	*/
	public int addBatchZxProcess(List<ZxProcess> zxProcessList){
		return this.add("addBatchZxProcess", zxProcessList);
	}
	/**
	* 批量修改
	* @param zx_processList 
	* @return
	*/
	public int updateBatchZxProcess(List<ZxProcess> zxProcessList){
		return this.update("updateBatchZxProcess", zxProcessList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_processList 
	* @return
	*/
	public int updateBatchZxProcessBySelective(List<ZxProcess> zxProcessList){
		return this.update("updateBatchZxProcessBySelective", zxProcessList);
	}
}
