package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxOutApplyService;
import jehc.zxmodules.dao.ZxOutApplyDao;
import jehc.zxmodules.model.ZxOutApply;

/**
* 外协加工申请表 
* 2017-11-01 16:31:32  陈运芝
*/
@Service("zxOutApplyService")
public class ZxOutApplyServiceImpl extends BaseService implements ZxOutApplyService{
	@Autowired
	private ZxOutApplyDao zxOutApplyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutApply> getZxOutApplyListByCondition(Map<String,Object> condition){
		try{
			return zxOutApplyDao.getZxOutApplyListByCondition(condition);
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
	public ZxOutApply getZxOutApplyById(String id){
		try{
			ZxOutApply zxOutApply = zxOutApplyDao.getZxOutApplyById(id);
			return zxOutApply;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_out_apply 
	* @return
	*/
	public int addZxOutApply(ZxOutApply zxOutApply){
		int i = 0;
		try {
			i = zxOutApplyDao.addZxOutApply(zxOutApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_out_apply 
	* @return
	*/
	public int updateZxOutApply(ZxOutApply zxOutApply){
		int i = 0;
		try {
			i = zxOutApplyDao.updateZxOutApply(zxOutApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_out_apply 
	* @return
	*/
	public int updateZxOutApplyBySelective(ZxOutApply zxOutApply){
		int i = 0;
		try {
			i = zxOutApplyDao.updateZxOutApplyBySelective(zxOutApply);
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
	public int delZxOutApply(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOutApplyDao.delZxOutApply(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_out_applyList 
	* @return
	*/
	public int addBatchZxOutApply(List<ZxOutApply> zxOutApplyList){
		int i = 0;
		try {
			i = zxOutApplyDao.addBatchZxOutApply(zxOutApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_out_applyList 
	* @return
	*/
	public int updateBatchZxOutApply(List<ZxOutApply> zxOutApplyList){
		int i = 0;
		try {
			i = zxOutApplyDao.updateBatchZxOutApply(zxOutApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_applyList 
	* @return
	*/
	public int updateBatchZxOutApplyBySelective(List<ZxOutApply> zxOutApplyList){
		int i = 0;
		try {
			i = zxOutApplyDao.updateBatchZxOutApplyBySelective(zxOutApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
