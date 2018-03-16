package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxOfficeClassifyService;
import jehc.zxmodules.dao.ZxOfficeClassifyDao;
import jehc.zxmodules.model.ZxMaterialClassify;
import jehc.zxmodules.model.ZxOfficeClassify;

/**
* 办公用品分类 
* 2017-11-30 08:41:46  季建吉
*/
@Service("zxOfficeClassifyService")
public class ZxOfficeClassifyServiceImpl extends BaseService implements ZxOfficeClassifyService{
	@Autowired
	private ZxOfficeClassifyDao zxOfficeClassifyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOfficeClassify> getZxOfficeClassifyListByCondition(Map<String,Object> condition){
		try{
			return zxOfficeClassifyDao.getZxOfficeClassifyListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	 * 查找所有根分类
	 * @return
	 */
	public List<ZxOfficeClassify> getZxOfficeClassifyList(Map<String, Object> condition){
		try {
			return zxOfficeClassifyDao.getZxOfficeClassifyList();
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
	public List<ZxOfficeClassify> getZxOfficeClassifyListAll(Map<String, Object> condition) {
		System.out.println("11");
		
		
		try {
			System.out.println("11");
			return zxOfficeClassifyDao.getZxOfficeClassifyListAll(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	 * 查找父分类下的子分类
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean getZxOfficeClassifyByParent(ZxOfficeClassify zxOfficeClassify){
		boolean flag=true;
		List<ZxOfficeClassify> list=zxOfficeClassifyDao.getZxOfficeClassifyByParent(zxOfficeClassify.getClassify_parentId());
		for(int i=0;i<list.size();i++){
			if(list.get(i).getClassify_name().equals(zxOfficeClassify.getClassify_name())){
				flag=false;
			}
			
		}
		return flag;
	}
	/**
	 * 查找所有根分类
	 * @return
	 */
	public List<ZxOfficeClassify> getZxOfficeClassifyByList() {
		try {
			return zxOfficeClassifyDao.getZxOfficeClassifyList();
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_office_classify 
	* @return
	*/
	public int addZxOfficeClassify(ZxOfficeClassify zxOfficeClassify){
		int i = 0;
		try {
			i = zxOfficeClassifyDao.addZxOfficeClassify(zxOfficeClassify);
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
	* 修改子页
	* @param zx_office_classify 
	* @return
	*/
	public int updateZxOfficeClassifyLeaf(ZxOfficeClassify zxOfficeClassify){
		int i = 0;
		try {
			String classfy_id=zxOfficeClassify.getClassify_parentId();
			i = zxOfficeClassifyDao.updateZxOfficeClassifyLeaf(classfy_id);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_office_classify 
	* @return
	*/
	public int updateZxOfficeClassify(ZxOfficeClassify zxOfficeClassify){
		int i = 0;
		try {
			i = zxOfficeClassifyDao.updateZxOfficeClassify(zxOfficeClassify);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office_classify 
	* @return
	*/
	public int updateZxOfficeClassifyBySelective(ZxOfficeClassify zxOfficeClassify){
		int i = 0;
		try {
			i = zxOfficeClassifyDao.updateZxOfficeClassifyBySelective(zxOfficeClassify);
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
	public int delZxOfficeClassify(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOfficeClassifyDao.delZxOfficeClassify(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_office_classifyList 
	* @return
	*/
	public int addBatchZxOfficeClassify(List<ZxOfficeClassify> zxOfficeClassifyList){
		int i = 0;
		try {
			i = zxOfficeClassifyDao.addBatchZxOfficeClassify(zxOfficeClassifyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_office_classifyList 
	* @return
	*/
	public int updateBatchZxOfficeClassify(List<ZxOfficeClassify> zxOfficeClassifyList){
		int i = 0;
		try {
			i = zxOfficeClassifyDao.updateBatchZxOfficeClassify(zxOfficeClassifyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_classifyList 
	* @return
	*/
	public int updateBatchZxOfficeClassifyBySelective(List<ZxOfficeClassify> zxOfficeClassifyList){
		int i = 0;
		try {
			i = zxOfficeClassifyDao.updateBatchZxOfficeClassifyBySelective(zxOfficeClassifyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	/**
	 * 查找非父菜单分类
	 * @return
	 */
	public List<ZxOfficeClassify> getZxOfficeClassifyListAllChild(Map<String, Object> condition) {
		try {
			return zxOfficeClassifyDao.getZxOfficeClassifyListAllChild(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	@Override
	public List<ZxOfficeClassify> getZxMaterialClassifyListChild() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ZxOfficeClassify getZxOfficeClassifyById(String classify_id) {
		try{
			ZxOfficeClassify zxOfficeClassify = zxOfficeClassifyDao.getZxOfficeClassifyById(classify_id);
			return zxOfficeClassify;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	public void test()
	{
		System.out.println("11");
	}
}
