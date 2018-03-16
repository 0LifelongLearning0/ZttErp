package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxProjectWokingDao;
import jehc.zxmodules.model.ZxProjectWoking;

/**
* 项目节点工时记录表 
* 2017-09-07 23:52:08  陈运芝
*/
@Repository("zxProjectWokingDao")
public class ZxProjectWokingDaoImpl  extends BaseDaoImpl implements ZxProjectWokingDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxProjectWoking> getZxProjectWokingListByCondition(Map<String,Object> condition){
		return (List<ZxProjectWoking>)this.getList("getZxProjectWokingListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProjectWoking getZxProjectWokingById(String id){
		return (ZxProjectWoking)this.get("getZxProjectWokingById", id);
	}
	/**
	* 添加
	* @param zx_project_woking 
	* @return
	*/
	public int addZxProjectWoking(ZxProjectWoking zxProjectWoking){
		return this.add("addZxProjectWoking", zxProjectWoking);
	}
	/**
	* 修改
	* @param zx_project_woking 
	* @return
	*/
	public int updateZxProjectWoking(ZxProjectWoking zxProjectWoking){
		return this.update("updateZxProjectWoking", zxProjectWoking);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_project_woking 
	* @return
	*/
	public int updateZxProjectWokingBySelective(ZxProjectWoking zxProjectWoking){
		return this.update("updateZxProjectWokingBySelective", zxProjectWoking);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProjectWoking(Map<String,Object> condition){
		return this.del("delZxProjectWoking", condition);
	}
	/**
	* 批量添加
	* @param zx_project_wokingList 
	* @return
	*/
	public int addBatchZxProjectWoking(List<ZxProjectWoking> zxProjectWokingList){
		return this.add("addBatchZxProjectWoking", zxProjectWokingList);
	}
	/**
	* 批量修改
	* @param zx_project_wokingList 
	* @return
	*/
	public int updateBatchZxProjectWoking(List<ZxProjectWoking> zxProjectWokingList){
		return this.update("updateBatchZxProjectWoking", zxProjectWokingList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_project_wokingList 
	* @return
	*/
	public int updateBatchZxProjectWokingBySelective(List<ZxProjectWoking> zxProjectWokingList){
		return this.update("updateBatchZxProjectWokingBySelective", zxProjectWokingList);
	}
	/**
	* 根据外键删除方法
	* @param node_id
	* @return
	*/
	public int delZxProjectWokingByForeignKey(String node_id){
		return this.del("delZxProjectWokingByForeignKey", node_id);
	}
}
