package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttOrderbybuyService;
import jehc.zxmodules.dao.ZttOrderbybuyDao;
import jehc.zxmodules.model.ZttOrderbybuy;

/**
* 外协单表 
* 2018-03-21 10:45:03  季建吉
*/
@Service("zttOrderbybuyService")
public class ZttOrderbybuyServiceImpl extends BaseService implements ZttOrderbybuyService{
	@Autowired
	private ZttOrderbybuyDao zttOrderbybuyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttOrderbybuy> getZttOrderbybuyListByCondition(Map<String,Object> condition){
		try{
			return zttOrderbybuyDao.getZttOrderbybuyListByCondition(condition);
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
	public ZttOrderbybuy getZttOrderbybuyById(String id){
		try{
			ZttOrderbybuy zttOrderbybuy = zttOrderbybuyDao.getZttOrderbybuyById(id);
			return zttOrderbybuy;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_orderbybuy 
	* @return
	*/
	public int addZttOrderbybuy(ZttOrderbybuy zttOrderbybuy){
		int i = 0;
		try {
			i = zttOrderbybuyDao.addZttOrderbybuy(zttOrderbybuy);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_orderbybuy 
	* @return
	*/
	public int updateZttOrderbybuy(ZttOrderbybuy zttOrderbybuy){
		int i = 0;
		try {
			i = zttOrderbybuyDao.updateZttOrderbybuy(zttOrderbybuy);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_orderbybuy 
	* @return
	*/
	public int updateZttOrderbybuyBySelective(ZttOrderbybuy zttOrderbybuy){
		int i = 0;
		try {
			i = zttOrderbybuyDao.updateZttOrderbybuyBySelective(zttOrderbybuy);
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
	public int delZttOrderbybuy(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttOrderbybuyDao.delZttOrderbybuy(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int addBatchZttOrderbybuy(List<ZttOrderbybuy> zttOrderbybuyList){
		int i = 0;
		try {
			i = zttOrderbybuyDao.addBatchZttOrderbybuy(zttOrderbybuyList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int updateBatchZttOrderbybuy(List<ZttOrderbybuy> zttOrderbybuyList){
		int i = 0;
		try {
			i = zttOrderbybuyDao.updateBatchZttOrderbybuy(zttOrderbybuyList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_orderbybuyList 
	* @return
	*/
	public int updateBatchZttOrderbybuyBySelective(List<ZttOrderbybuy> zttOrderbybuyList){
		int i = 0;
		try {
			i = zttOrderbybuyDao.updateBatchZttOrderbybuyBySelective(zttOrderbybuyList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
