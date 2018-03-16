package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxWorkpieceService;
import jehc.zxmodules.dao.ZxWorkpieceDao;
import jehc.zxmodules.model.ZxWorkpiece;

/**
* 工件管理 
* 2017-08-31 12:54:14  陈运芝
*/
@Service("zxWorkpieceService")
public class ZxWorkpieceServiceImpl extends BaseService implements ZxWorkpieceService{
	@Autowired
	private ZxWorkpieceDao zxWorkpieceDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxWorkpiece> getZxWorkpieceListByCondition(Map<String,Object> condition){
		try{
			return zxWorkpieceDao.getZxWorkpieceListByCondition(condition);
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
	public ZxWorkpiece getZxWorkpieceById(String id){
		try{
			ZxWorkpiece zxWorkpiece = zxWorkpieceDao.getZxWorkpieceById(id);
			return zxWorkpiece;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_workpiece 
	* @return
	*/
	public int addZxWorkpiece(ZxWorkpiece zxWorkpiece){
		int i = 0;
		try {
			i = zxWorkpieceDao.addZxWorkpiece(zxWorkpiece);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_workpiece 
	* @return
	*/
	public int updateZxWorkpiece(ZxWorkpiece zxWorkpiece){
		int i = 0;
		try {
			i = zxWorkpieceDao.updateZxWorkpiece(zxWorkpiece);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_workpiece 
	* @return
	*/
	public int updateZxWorkpieceBySelective(ZxWorkpiece zxWorkpiece){
		int i = 0;
		try {
			i = zxWorkpieceDao.updateZxWorkpieceBySelective(zxWorkpiece);
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
	public int delZxWorkpiece(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxWorkpieceDao.delZxWorkpiece(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_workpieceList 
	* @return
	*/
	public int addBatchZxWorkpiece(List<ZxWorkpiece> zxWorkpieceList){
		int i = 0;
		try {
			i = zxWorkpieceDao.addBatchZxWorkpiece(zxWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_workpieceList 
	* @return
	*/
	public int updateBatchZxWorkpiece(List<ZxWorkpiece> zxWorkpieceList){
		int i = 0;
		try {
			i = zxWorkpieceDao.updateBatchZxWorkpiece(zxWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_workpieceList 
	* @return
	*/
	public int updateBatchZxWorkpieceBySelective(List<ZxWorkpiece> zxWorkpieceList){
		int i = 0;
		try {
			i = zxWorkpieceDao.updateBatchZxWorkpieceBySelective(zxWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
