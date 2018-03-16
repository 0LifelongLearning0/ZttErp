package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxProject;

/**
* 项目管理表 
* 2017-08-28 14:15:35  陈运芝
*/
public interface ZxProjectDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProject> getZxProjectListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProject getZxProjectById(String id);
	/**
	* 添加
	* @param zx_project 
	* @return
	*/
	public int addZxProject(ZxProject zxProject);
	/**
	* 修改
	* @param zx_project 
	* @return
	*/
	public int updateZxProject(ZxProject zxProject);
	/**
	* 修改（根据动态条件）
	* @param zx_project 
	* @return
	*/
	public int updateZxProjectBySelective(ZxProject zxProject);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProject(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_projectList 
	* @return
	*/
	public int addBatchZxProject(List<ZxProject> zxProjectList);
	/**
	* 批量修改
	* @param zx_projectList 
	* @return
	*/
	public int updateBatchZxProject(List<ZxProject> zxProjectList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_projectList 
	* @return
	*/
	public int updateBatchZxProjectBySelective(List<ZxProject> zxProjectList);
}
