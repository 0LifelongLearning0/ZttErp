package jehc.zxmodules.service .impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service .ZxOfficeService;
import jehc.zxmodules.dao.ZxOfficeDao;
import jehc.zxmodules.model.ZxOffice;

/**
* 办公用品管理 
* 2017-11-30 08:19:19  季建吉
*/
@Service("zxOfficeService")
public class ZxOfficeServiceImpl extends BaseService implements ZxOfficeService{
	@Autowired
	private ZxOfficeDao zxOfficeDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOffice> getZxOfficeListByCondition(Map<String,Object> condition){
		try{
			return zxOfficeDao.getZxOfficeListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param office_id 
	* @return
	*/
	public ZxOffice getZxOfficeById(String office_id){
		try{
			ZxOffice zxOffice = zxOfficeDao.getZxOfficeById(office_id);
			return zxOffice;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_office 
	* @return
	*/
	public int addZxOffice(ZxOffice zxOffice){
		int i = 0;
		try {
			i = zxOfficeDao.addZxOffice(zxOffice);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_office 
	* @return
	*/
	public int updateZxOffice(ZxOffice zxOffice){
		int i = 0;
		try {
			i = zxOfficeDao.updateZxOffice(zxOffice);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office 
	* @return
	*/
	public int updateZxOfficeBySelective(ZxOffice zxOffice){
		int i = 0;
		try {
			i = zxOfficeDao.updateZxOfficeBySelective(zxOffice);
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
	public int delZxOffice(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOfficeDao.delZxOffice(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_officeList 
	* @return
	*/
	public int addBatchZxOffice(List<ZxOffice> zxOfficeList){
		int i = 0;
		try {
			i = zxOfficeDao.addBatchZxOffice(zxOfficeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_officeList 
	* @return
	*/
	public int updateBatchZxOffice(List<ZxOffice> zxOfficeList){
		int i = 0;
		try {
			i = zxOfficeDao.updateBatchZxOffice(zxOfficeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_officeList 
	* @return
	*/
	public int updateBatchZxOfficeBySelective(List<ZxOffice> zxOfficeList){
		int i = 0;
		try {
			i = zxOfficeDao.updateBatchZxOfficeBySelective(zxOfficeList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
