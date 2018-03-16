package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxProjectNodeDao;
import jehc.zxmodules.model.ZxProjectNode;

/**
* 项目节点控制表 
* 2017-09-07 23:52:08  陈运芝
*/
@Repository("zxProjectNodeDao")
public class ZxProjectNodeDaoImpl  extends BaseDaoImpl implements ZxProjectNodeDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxProjectNode> getZxProjectNodeListByCondition(Map<String,Object> condition){
		return (List<ZxProjectNode>)this.getList("getZxProjectNodeListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProjectNode getZxProjectNodeById(String id){
		return (ZxProjectNode)this.get("getZxProjectNodeById", id);
	}
	/**
	* 添加
	* @param zx_project_node 
	* @return
	*/
	public int addZxProjectNode(ZxProjectNode zxProjectNode){
		return this.add("addZxProjectNode", zxProjectNode);
	}
	/**
	* 修改
	* @param zx_project_node 
	* @return
	*/
	public int updateZxProjectNode(ZxProjectNode zxProjectNode){
		return this.update("updateZxProjectNode", zxProjectNode);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_project_node 
	* @return
	*/
	public int updateZxProjectNodeBySelective(ZxProjectNode zxProjectNode){
		return this.update("updateZxProjectNodeBySelective", zxProjectNode);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProjectNode(Map<String,Object> condition){
		return this.del("delZxProjectNode", condition);
	}
	/**
	* 批量添加
	* @param zx_project_nodeList 
	* @return
	*/
	public int addBatchZxProjectNode(List<ZxProjectNode> zxProjectNodeList){
		return this.add("addBatchZxProjectNode", zxProjectNodeList);
	}
	/**
	* 批量修改
	* @param zx_project_nodeList 
	* @return
	*/
	public int updateBatchZxProjectNode(List<ZxProjectNode> zxProjectNodeList){
		return this.update("updateBatchZxProjectNode", zxProjectNodeList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_project_nodeList 
	* @return
	*/
	public int updateBatchZxProjectNodeBySelective(List<ZxProjectNode> zxProjectNodeList){
		return this.update("updateBatchZxProjectNodeBySelective", zxProjectNodeList);
	}
}
