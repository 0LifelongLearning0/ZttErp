package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxConcordatService;
import jehc.zxmodules.dao.ZxConcordatDao;
import jehc.zxmodules.model.ZxConcordat;

/**
* 合同管理 
* 2017-08-31 17:21:48  陈运芝
*/
@Service("zxConcordatService")
public class ZxConcordatServiceImpl extends BaseService implements ZxConcordatService{
	@Autowired
	private ZxConcordatDao zxConcordatDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxConcordat> getZxConcordatListByCondition(Map<String,Object> condition){
		try{
			return zxConcordatDao.getZxConcordatListByCondition(condition);
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
	public ZxConcordat getZxConcordatById(String id){
		try{
			ZxConcordat zxConcordat = zxConcordatDao.getZxConcordatById(id);
			return zxConcordat;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_concordat 
	* @return
	*/
	public int addZxConcordat(ZxConcordat zxConcordat){
		int i = 0;
		try {
			i = zxConcordatDao.addZxConcordat(zxConcordat);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_concordat 
	* @return
	*/
	public int updateZxConcordat(ZxConcordat zxConcordat){
		int i = 0;
		try {
			i = zxConcordatDao.updateZxConcordat(zxConcordat);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_concordat 
	* @return
	*/
	public int updateZxConcordatBySelective(ZxConcordat zxConcordat){
		int i = 0;
		try {
			i = zxConcordatDao.updateZxConcordatBySelective(zxConcordat);
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
	public int delZxConcordat(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxConcordatDao.delZxConcordat(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_concordatList 
	* @return
	*/
	public int addBatchZxConcordat(List<ZxConcordat> zxConcordatList){
		int i = 0;
		try {
			i = zxConcordatDao.addBatchZxConcordat(zxConcordatList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_concordatList 
	* @return
	*/
	public int updateBatchZxConcordat(List<ZxConcordat> zxConcordatList){
		int i = 0;
		try {
			i = zxConcordatDao.updateBatchZxConcordat(zxConcordatList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_concordatList 
	* @return
	*/
	public int updateBatchZxConcordatBySelective(List<ZxConcordat> zxConcordatList){
		int i = 0;
		try {
			i = zxConcordatDao.updateBatchZxConcordatBySelective(zxConcordatList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
