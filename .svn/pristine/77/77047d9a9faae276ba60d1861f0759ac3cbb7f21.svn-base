package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxProjectWoking;

/**
* 项目节点工时记录表 
* 2017-09-07 23:52:08  陈运芝
*/
public interface ZxProjectWokingDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProjectWoking> getZxProjectWokingListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProjectWoking getZxProjectWokingById(String id);
	/**
	* 添加
	* @param zx_project_woking 
	* @return
	*/
	public int addZxProjectWoking(ZxProjectWoking zxProjectWoking);
	/**
	* 修改
	* @param zx_project_woking 
	* @return
	*/
	public int updateZxProjectWoking(ZxProjectWoking zxProjectWoking);
	/**
	* 修改（根据动态条件）
	* @param zx_project_woking 
	* @return
	*/
	public int updateZxProjectWokingBySelective(ZxProjectWoking zxProjectWoking);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProjectWoking(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_project_wokingList 
	* @return
	*/
	public int addBatchZxProjectWoking(List<ZxProjectWoking> zxProjectWokingList);
	/**
	* 批量修改
	* @param zx_project_wokingList 
	* @return
	*/
	public int updateBatchZxProjectWoking(List<ZxProjectWoking> zxProjectWokingList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_project_wokingList 
	* @return
	*/
	public int updateBatchZxProjectWokingBySelective(List<ZxProjectWoking> zxProjectWokingList);
	/**
	* 根据外键删除方法
	* @param node_id
	* @return
	*/
	public int delZxProjectWokingByForeignKey(String node_id);
}
