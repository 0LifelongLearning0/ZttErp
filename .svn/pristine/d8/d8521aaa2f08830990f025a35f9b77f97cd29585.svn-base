package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxProjectDao;
import jehc.zxmodules.model.ZxProject;

/**
* 项目管理表 
* 2017-08-28 14:15:35  陈运芝
*/
@Repository("zxProjectDao")
public class ZxProjectDaoImpl  extends BaseDaoImpl implements ZxProjectDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxProject> getZxProjectListByCondition(Map<String,Object> condition){
		return (List<ZxProject>)this.getList("getZxProjectListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProject getZxProjectById(String id){
		return (ZxProject)this.get("getZxProjectById", id);
	}
	/**
	* 添加
	* @param zx_project 
	* @return
	*/
	public int addZxProject(ZxProject zxProject){
		return this.add("addZxProject", zxProject);
	}
	/**
	* 修改
	* @param zx_project 
	* @return
	*/
	public int updateZxProject(ZxProject zxProject){
		return this.update("updateZxProject", zxProject);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_project 
	* @return
	*/
	public int updateZxProjectBySelective(ZxProject zxProject){
		return this.update("updateZxProjectBySelective", zxProject);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProject(Map<String,Object> condition){
		return this.del("delZxProject", condition);
	}
	/**
	* 批量添加
	* @param zx_projectList 
	* @return
	*/
	public int addBatchZxProject(List<ZxProject> zxProjectList){
		return this.add("addBatchZxProject", zxProjectList);
	}
	/**
	* 批量修改
	* @param zx_projectList 
	* @return
	*/
	public int updateBatchZxProject(List<ZxProject> zxProjectList){
		return this.update("updateBatchZxProject", zxProjectList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_projectList 
	* @return
	*/
	public int updateBatchZxProjectBySelective(List<ZxProject> zxProjectList){
		return this.update("updateBatchZxProjectBySelective", zxProjectList);
	}
}
