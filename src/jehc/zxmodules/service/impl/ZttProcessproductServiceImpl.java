package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttProcessproductService;
import jehc.zxmodules.dao.ZttProcessproductDao;
import jehc.zxmodules.model.ZttProcessproduct;

/**
* 机械加工工艺过程表 
* 2018-04-24 14:27:01  季建吉
*/
@Service("zttProcessproductService")
public class ZttProcessproductServiceImpl extends BaseService implements ZttProcessproductService{
	@Autowired
	private ZttProcessproductDao zttProcessproductDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttProcessproduct> getZttProcessproductListByCondition(Map<String,Object> condition){
		try{
			return zttProcessproductDao.getZttProcessproductListByCondition(condition);
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttProcessproduct getZttProcessproductById(String id){
		try{
			ZttProcessproduct zttProcessproduct = zttProcessproductDao.getZttProcessproductById(id);
			return zttProcessproduct;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_processproduct 
	* @return
	*/
	public int addZttProcessproduct(ZttProcessproduct zttProcessproduct){
		int i = 0;
		try {
			i = zttProcessproductDao.addZttProcessproduct(zttProcessproduct);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_processproduct 
	* @return
	*/
	public int updateZttProcessproduct(ZttProcessproduct zttProcessproduct){
		int i = 0;
		try {
			i = zttProcessproductDao.updateZttProcessproduct(zttProcessproduct);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_processproduct 
	* @return
	*/
	public int updateZttProcessproductBySelective(ZttProcessproduct zttProcessproduct){
		int i = 0;
		try {
			i = zttProcessproductDao.updateZttProcessproductBySelective(zttProcessproduct);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttProcessproduct(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttProcessproductDao.delZttProcessproduct(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_processproductList 
	* @return
	*/
	public int addBatchZttProcessproduct(List<ZttProcessproduct> zttProcessproductList){
		int i = 0;
		try {
			i = zttProcessproductDao.addBatchZttProcessproduct(zttProcessproductList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_processproductList 
	* @return
	*/
	public int updateBatchZttProcessproduct(List<ZttProcessproduct> zttProcessproductList){
		int i = 0;
		try {
			i = zttProcessproductDao.updateBatchZttProcessproduct(zttProcessproductList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_processproductList 
	* @return
	*/
	public int updateBatchZttProcessproductBySelective(List<ZttProcessproduct> zttProcessproductList){
		int i = 0;
		try {
			i = zttProcessproductDao.updateBatchZttProcessproductBySelective(zttProcessproductList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 根据外键删除方法
	* @param parentId
	* @return
	*/
	public int delZttProcessproductByForeignKey(String parentId){
		int i = 0;
		try {
			i = zttProcessproductDao.delZttProcessproductByForeignKey(parentId);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
