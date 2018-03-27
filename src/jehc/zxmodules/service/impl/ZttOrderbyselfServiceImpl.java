package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttOrderbyselfService;
import jehc.zxmodules.dao.ZttOrderbyselfDao;
import jehc.zxmodules.model.ZttOrderbyself;

/**
* 自制单表 
* 2018-03-20 17:26:52  季建吉
*/
@Service("zttOrderbyselfService")
public class ZttOrderbyselfServiceImpl extends BaseService implements ZttOrderbyselfService{
	@Autowired
	private ZttOrderbyselfDao zttOrderbyselfDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttOrderbyself> getZttOrderbyselfListByCondition(Map<String,Object> condition){
		try{
			return zttOrderbyselfDao.getZttOrderbyselfListByCondition(condition);
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
	public ZttOrderbyself getZttOrderbyselfById(String id){
		try{
			ZttOrderbyself zttOrderbyself = zttOrderbyselfDao.getZttOrderbyselfById(id);
			return zttOrderbyself;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_orderbyself 
	* @return
	*/
	public int addZttOrderbyself(ZttOrderbyself zttOrderbyself){
		int i = 0;
		try {
			i = zttOrderbyselfDao.addZttOrderbyself(zttOrderbyself);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_orderbyself 
	* @return
	*/
	public int updateZttOrderbyself(ZttOrderbyself zttOrderbyself){
		int i = 0;
		try {
			i = zttOrderbyselfDao.updateZttOrderbyself(zttOrderbyself);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_orderbyself 
	* @return
	*/
	public int updateZttOrderbyselfBySelective(ZttOrderbyself zttOrderbyself){
		int i = 0;
		try {
			i = zttOrderbyselfDao.updateZttOrderbyselfBySelective(zttOrderbyself);
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
	public int delZttOrderbyself(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttOrderbyselfDao.delZttOrderbyself(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int addBatchZttOrderbyself(List<ZttOrderbyself> zttOrderbyselfList){
		int i = 0;
		try {
			i = zttOrderbyselfDao.addBatchZttOrderbyself(zttOrderbyselfList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int updateBatchZttOrderbyself(List<ZttOrderbyself> zttOrderbyselfList){
		int i = 0;
		try {
			i = zttOrderbyselfDao.updateBatchZttOrderbyself(zttOrderbyselfList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderbyselfList 
	* @return
	*/
	public int updateBatchZttOrderbyselfBySelective(List<ZttOrderbyself> zttOrderbyselfList){
		int i = 0;
		try {
			i = zttOrderbyselfDao.updateBatchZttOrderbyselfBySelective(zttOrderbyselfList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
