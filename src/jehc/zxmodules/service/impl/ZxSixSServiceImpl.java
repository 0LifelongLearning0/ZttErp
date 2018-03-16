package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxSixSService;
import jehc.zxmodules.dao.ZxSixSDao;
import jehc.zxmodules.model.ZxSixS;

/**
* 6S待办事项 
* 2017-11-01 10:30:02  a
*/
@Service("zxSixSService")
public class ZxSixSServiceImpl extends BaseService implements ZxSixSService{
	@Autowired
	private ZxSixSDao zxSixSDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxSixS> getZxSixSListByCondition(Map<String,Object> condition){
		try{
			return zxSixSDao.getZxSixSListByCondition(condition);
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
	public ZxSixS getZxSixSById(String id){
		try{
			ZxSixS zxSixS = zxSixSDao.getZxSixSById(id);
			return zxSixS;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_six_s 
	* @return
	*/
	public int addZxSixS(ZxSixS zxSixS){
		int i = 0;
		try {
			i = zxSixSDao.addZxSixS(zxSixS);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_six_s 
	* @return
	*/
	public int updateZxSixS(ZxSixS zxSixS){
		int i = 0;
		try {
			i = zxSixSDao.updateZxSixS(zxSixS);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_six_s 
	* @return
	*/
	public int updateZxSixSBySelective(ZxSixS zxSixS){
		int i = 0;
		try {
			i = zxSixSDao.updateZxSixSBySelective(zxSixS);
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
	public int delZxSixS(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxSixSDao.delZxSixS(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_six_sList 
	* @return
	*/
	public int addBatchZxSixS(List<ZxSixS> zxSixSList){
		int i = 0;
		try {
			i = zxSixSDao.addBatchZxSixS(zxSixSList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_six_sList 
	* @return
	*/
	public int updateBatchZxSixS(List<ZxSixS> zxSixSList){
		int i = 0;
		try {
			i = zxSixSDao.updateBatchZxSixS(zxSixSList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_six_sList 
	* @return
	*/
	public int updateBatchZxSixSBySelective(List<ZxSixS> zxSixSList){
		int i = 0;
		try {
			i = zxSixSDao.updateBatchZxSixSBySelective(zxSixSList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
