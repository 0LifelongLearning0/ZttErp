package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxOutApplyWorkpieceService;
import jehc.zxmodules.dao.ZxOutApplyWorkpieceDao;
import jehc.zxmodules.model.ZxOutApplyWorkpiece;

/**
* 外协申请工件详情单 
* 2017-11-01 16:34:19  陈运芝
*/
@Service("zxOutApplyWorkpieceService")
public class ZxOutApplyWorkpieceServiceImpl extends BaseService implements ZxOutApplyWorkpieceService{
	@Autowired
	private ZxOutApplyWorkpieceDao zxOutApplyWorkpieceDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutApplyWorkpiece> getZxOutApplyWorkpieceListByCondition(Map<String,Object> condition){
		try{
			return zxOutApplyWorkpieceDao.getZxOutApplyWorkpieceListByCondition(condition);
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
	public ZxOutApplyWorkpiece getZxOutApplyWorkpieceById(String id){
		try{
			ZxOutApplyWorkpiece zxOutApplyWorkpiece = zxOutApplyWorkpieceDao.getZxOutApplyWorkpieceById(id);
			return zxOutApplyWorkpiece;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int addZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece){
		int i = 0;
		try {
			i = zxOutApplyWorkpieceDao.addZxOutApplyWorkpiece(zxOutApplyWorkpiece);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int updateZxOutApplyWorkpiece(ZxOutApplyWorkpiece zxOutApplyWorkpiece){
		int i = 0;
		try {
			i = zxOutApplyWorkpieceDao.updateZxOutApplyWorkpiece(zxOutApplyWorkpiece);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_out_apply_workpiece 
	* @return
	*/
	public int updateZxOutApplyWorkpieceBySelective(ZxOutApplyWorkpiece zxOutApplyWorkpiece){
		int i = 0;
		try {
			i = zxOutApplyWorkpieceDao.updateZxOutApplyWorkpieceBySelective(zxOutApplyWorkpiece);
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
	public int delZxOutApplyWorkpiece(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOutApplyWorkpieceDao.delZxOutApplyWorkpiece(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int addBatchZxOutApplyWorkpiece(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList){
		int i = 0;
		try {
			i = zxOutApplyWorkpieceDao.addBatchZxOutApplyWorkpiece(zxOutApplyWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int updateBatchZxOutApplyWorkpiece(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList){
		int i = 0;
		try {
			i = zxOutApplyWorkpieceDao.updateBatchZxOutApplyWorkpiece(zxOutApplyWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_apply_workpieceList 
	* @return
	*/
	public int updateBatchZxOutApplyWorkpieceBySelective(List<ZxOutApplyWorkpiece> zxOutApplyWorkpieceList){
		int i = 0;
		try {
			i = zxOutApplyWorkpieceDao.updateBatchZxOutApplyWorkpieceBySelective(zxOutApplyWorkpieceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
