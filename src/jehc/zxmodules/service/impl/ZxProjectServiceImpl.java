package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxProjectService;
import jehc.zxmodules.dao.ZxProjectDao;
import jehc.zxmodules.model.ZxProject;

/**
* 项目管理表 
* 2017-08-28 14:15:35  陈运芝
*/
@Service("zxProjectService")
public class ZxProjectServiceImpl extends BaseService implements ZxProjectService{
	@Autowired
	private ZxProjectDao zxProjectDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxProject> getZxProjectListByCondition(Map<String,Object> condition){
		try{
			return zxProjectDao.getZxProjectListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxProject getZxProjectById(String id){
		try{
			ZxProject zxProject = zxProjectDao.getZxProjectById(id);
			return zxProject;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_project 
	* @return
	*/
	public int addZxProject(ZxProject zxProject){
		int i = 0;
		try {
			i = zxProjectDao.addZxProject(zxProject);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_project 
	* @return
	*/
	public int updateZxProject(ZxProject zxProject){
		int i = 0;
		try {
			i = zxProjectDao.updateZxProject(zxProject);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_project 
	* @return
	*/
	public int updateZxProjectBySelective(ZxProject zxProject){
		int i = 0;
		try {
			i = zxProjectDao.updateZxProjectBySelective(zxProject);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxProject(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxProjectDao.delZxProject(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_projectList 
	* @return
	*/
	public int addBatchZxProject(List<ZxProject> zxProjectList){
		int i = 0;
		try {
			i = zxProjectDao.addBatchZxProject(zxProjectList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_projectList 
	* @return
	*/
	public int updateBatchZxProject(List<ZxProject> zxProjectList){
		int i = 0;
		try {
			i = zxProjectDao.updateBatchZxProject(zxProjectList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_projectList 
	* @return
	*/
	public int updateBatchZxProjectBySelective(List<ZxProject> zxProjectList){
		int i = 0;
		try {
			i = zxProjectDao.updateBatchZxProjectBySelective(zxProjectList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
