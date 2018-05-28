package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttMouldsDeiviceService;
import jehc.zxmodules.dao.ZttMouldsDeiviceDao;
import jehc.zxmodules.model.ZttMouldsDeivice;

/**
* 工序设备 
* 2018-05-24 16:46:19  季建吉
*/
@Service("zttMouldsDeiviceService")
public class ZttMouldsDeiviceServiceImpl extends BaseService implements ZttMouldsDeiviceService{
	@Autowired
	private ZttMouldsDeiviceDao zttMouldsDeiviceDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttMouldsDeivice> getZttMouldsDeiviceListByCondition(Map<String,Object> condition){
		try{
			return zttMouldsDeiviceDao.getZttMouldsDeiviceListByCondition(condition);
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
	public ZttMouldsDeivice getZttMouldsDeiviceById(String id){
		try{
			ZttMouldsDeivice zttMouldsDeivice = zttMouldsDeiviceDao.getZttMouldsDeiviceById(id);
			return zttMouldsDeivice;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int addZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.addZttMouldsDeivice(zttMouldsDeivice);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int updateZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.updateZttMouldsDeivice(zttMouldsDeivice);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int updateZttMouldsDeiviceBySelective(ZttMouldsDeivice zttMouldsDeivice){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.updateZttMouldsDeiviceBySelective(zttMouldsDeivice);
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
	public int delZttMouldsDeivice(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.delZttMouldsDeivice(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int addBatchZttMouldsDeivice(List<ZttMouldsDeivice> zttMouldsDeiviceList){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.addBatchZttMouldsDeivice(zttMouldsDeiviceList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int updateBatchZttMouldsDeivice(List<ZttMouldsDeivice> zttMouldsDeiviceList){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.updateBatchZttMouldsDeivice(zttMouldsDeiviceList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int updateBatchZttMouldsDeiviceBySelective(List<ZttMouldsDeivice> zttMouldsDeiviceList){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.updateBatchZttMouldsDeiviceBySelective(zttMouldsDeiviceList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 根据外键删除方法
	* @param gongxu_id
	* @return
	*/
	public int delZttMouldsDeiviceByForeignKey(String gongxu_id){
		int i = 0;
		try {
			i = zttMouldsDeiviceDao.delZttMouldsDeiviceByForeignKey(gongxu_id);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
