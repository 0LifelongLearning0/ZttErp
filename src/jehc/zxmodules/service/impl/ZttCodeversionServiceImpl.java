package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttCodeversionService;
import jehc.zxmodules.dao.ZttCodeversionDao;
import jehc.zxmodules.model.ZttCodeversion;

/**
* 代码版本控制 
* 2018-04-17 12:58:09  季建吉
*/
@Service("zttCodeversionService")
public class ZttCodeversionServiceImpl extends BaseService implements ZttCodeversionService{
	@Autowired
	private ZttCodeversionDao zttCodeversionDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttCodeversion> getZttCodeversionListByCondition(Map<String,Object> condition){
		try{
			return zttCodeversionDao.getZttCodeversionListByCondition(condition);
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
	public ZttCodeversion getZttCodeversionById(String id){
		try{
			ZttCodeversion zttCodeversion = zttCodeversionDao.getZttCodeversionById(id);
			return zttCodeversion;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_codeversion 
	* @return
	*/
	public int addZttCodeversion(ZttCodeversion zttCodeversion){
		int i = 0;
		try {
			i = zttCodeversionDao.addZttCodeversion(zttCodeversion);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_codeversion 
	* @return
	*/
	public int updateZttCodeversion(ZttCodeversion zttCodeversion){
		int i = 0;
		try {
			i = zttCodeversionDao.updateZttCodeversion(zttCodeversion);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_codeversion 
	* @return
	*/
	public int updateZttCodeversionBySelective(ZttCodeversion zttCodeversion){
		int i = 0;
		try {
			i = zttCodeversionDao.updateZttCodeversionBySelective(zttCodeversion);
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
	public int delZttCodeversion(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttCodeversionDao.delZttCodeversion(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_codeversionList 
	* @return
	*/
	public int addBatchZttCodeversion(List<ZttCodeversion> zttCodeversionList){
		int i = 0;
		try {
			i = zttCodeversionDao.addBatchZttCodeversion(zttCodeversionList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_codeversionList 
	* @return
	*/
	public int updateBatchZttCodeversion(List<ZttCodeversion> zttCodeversionList){
		int i = 0;
		try {
			i = zttCodeversionDao.updateBatchZttCodeversion(zttCodeversionList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_codeversionList 
	* @return
	*/
	public int updateBatchZttCodeversionBySelective(List<ZttCodeversion> zttCodeversionList){
		int i = 0;
		try {
			i = zttCodeversionDao.updateBatchZttCodeversionBySelective(zttCodeversionList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
