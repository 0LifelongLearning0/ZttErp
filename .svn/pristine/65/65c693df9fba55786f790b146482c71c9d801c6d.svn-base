package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxMaterialClassifyDao;
import jehc.zxmodules.model.ZxMaterialClassify;
import jehc.zxmodules.service.ZxMaterialClassifyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 物料分类 
* 2017-08-30 08:30:12  陈运芝
*/
@Service("zxMaterialClassifyService")
public class ZxMaterialClassifyServiceImpl extends BaseService implements ZxMaterialClassifyService{
	@Autowired
	private ZxMaterialClassifyDao zxMaterialClassifyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxMaterialClassify> getZxMaterialClassifyListByCondition(Map<String,Object> condition){
		try{
			return zxMaterialClassifyDao.getZxMaterialClassifyListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}

	/**
	 * 查找所有根分类
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyList(){
		try {
			return zxMaterialClassifyDao.getZxMaterialClassifyList();
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	
	/**
	 * 查找非父菜单分类
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyListAllChild(Map<String, Object> condition){
		try {
			return zxMaterialClassifyDao.getZxMaterialClassifyListAllChild(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	
	/**
	 * 查找子分类
	 * @param condition
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyListChild(){
		try {
			return zxMaterialClassifyDao.getZxMaterialClassifyListChild();
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}

	/**
	 * 查询所有分类
	 * @param condition
	 * @return
	 */
	public List<ZxMaterialClassify> getZxMaterialClassifyListAll(Map<String, Object> condition){
		try {
			return zxMaterialClassifyDao.getZxMaterialClassifyListAll(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param classify_id 
	* @return
	*/
	public ZxMaterialClassify getZxMaterialClassifyById(String classify_id){
		try{
			ZxMaterialClassify zxMaterialClassify = zxMaterialClassifyDao.getZxMaterialClassifyById(classify_id);
			return zxMaterialClassify;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_material_classify 
	* @return
	*/
	public int addZxMaterialClassify(ZxMaterialClassify zxMaterialClassify){
		int i = 0;
		try {
			i = zxMaterialClassifyDao.addZxMaterialClassify(zxMaterialClassify);
			aBLogs("物料分类类", "添加", "执行添加分类成功");
		} catch (Exception e) {
			i = 0;
			aBLogs("物料分类类", "添加", "执行修改分类失败");
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_material_classify 
	* @return
	*/
	public int updateZxMaterialClassify(ZxMaterialClassify zxMaterialClassify){
		int i = 0;
		try {
			i = zxMaterialClassifyDao.updateZxMaterialClassify(zxMaterialClassify);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_material_classify 
	* @return
	*/
	public int updateZxMaterialClassifyBySelective(ZxMaterialClassify zxMaterialClassify){
		int i = 0;
		try {
			i = zxMaterialClassifyDao.updateZxMaterialClassifyBySelective(zxMaterialClassify);
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
	public int delZxMaterialClassify(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxMaterialClassifyDao.delZxMaterialClassify(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_material_classifyList 
	* @return
	*/
	public int addBatchZxMaterialClassify(List<ZxMaterialClassify> zxMaterialClassifyList){
		int i = 0;
		try {
			i = zxMaterialClassifyDao.addBatchZxMaterialClassify(zxMaterialClassifyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_material_classifyList 
	* @return
	*/
	public int updateBatchZxMaterialClassify(List<ZxMaterialClassify> zxMaterialClassifyList){
		int i = 0;
		try {
			i = zxMaterialClassifyDao.updateBatchZxMaterialClassify(zxMaterialClassifyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_material_classifyList 
	* @return
	*/
	public int updateBatchZxMaterialClassifyBySelective(List<ZxMaterialClassify> zxMaterialClassifyList){
		int i = 0;
		try {
			i = zxMaterialClassifyDao.updateBatchZxMaterialClassifyBySelective(zxMaterialClassifyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
