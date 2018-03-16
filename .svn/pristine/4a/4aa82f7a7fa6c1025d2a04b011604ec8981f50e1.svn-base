package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxProjectNode;

/**
* 项目节点控制表 
* 2017-09-07 23:52:08  陈运芝
*/
public interface ZxProjectNodeService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProjectNode> getZxProjectNodeListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProjectNode getZxProjectNodeById(String id);
	/**
	* 添加
	* @param zx_project_node 
	* @return
	*/
	public int addZxProjectNode(ZxProjectNode zxProjectNode);
	/**
	* 修改
	* @param zx_project_node 
	* @return
	*/
	public int updateZxProjectNode(ZxProjectNode zxProjectNode);
	/**
	* 修改（根据动态条件）
	* @param zx_project_node 
	* @return
	*/
	public int updateZxProjectNodeBySelective(ZxProjectNode zxProjectNode);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProjectNode(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_project_nodeList 
	* @return
	*/
	public int addBatchZxProjectNode(List<ZxProjectNode> zxProjectNodeList);
	/**
	* 批量修改
	* @param zx_project_nodeList 
	* @return
	*/
	public int updateBatchZxProjectNode(List<ZxProjectNode> zxProjectNodeList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_project_nodeList 
	* @return
	*/
	public int updateBatchZxProjectNodeBySelective(List<ZxProjectNode> zxProjectNodeList);
}
