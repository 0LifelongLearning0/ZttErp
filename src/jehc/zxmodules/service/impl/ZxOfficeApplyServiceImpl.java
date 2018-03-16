package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxOfficeApplyService;
import jehc.zxmodules.dao.ZxOfficeApplyDao;
import jehc.zxmodules.model.ZxOfficeApply;
import jehc.zxmodules.model.ZxOfficeApplyShow;
import jehc.zxmodules.model.ZxOfficeInventory;
import jehc.zxmodules.model.ZxUserAndDepartment;

/**
* 办公用品申请表 
* 2017-12-05 15:17:15  季建吉
*/
@Service("zxOfficeApplyService")
public class ZxOfficeApplyServiceImpl extends BaseService implements ZxOfficeApplyService{
	@Autowired
	private ZxOfficeApplyDao zxOfficeApplyDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOfficeApplyShow> getZxOfficeApplyListByCondition(Map<String,Object> condition){
		try{
			return zxOfficeApplyDao.getZxOfficeApplyListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 发放分页
	* @param condition 
	* @return
	*/
	public List<ZxOfficeApplyShow> getZxOfficeOutListByCondition(Map<String,Object> condition){
		try{
			return zxOfficeApplyDao.getZxOfficeOutListByCondition(condition);
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
	public ZxOfficeApplyShow getZxOfficeApplyById(String id){
		try{
			ZxOfficeApplyShow ZxOfficeApplyShow = zxOfficeApplyDao.getZxOfficeApplyById(id);
			if("06e4075e00a841c8a14fef92e0e007f6".equals(ZxOfficeApplyShow.getUser_id())){
				
			}else{
				ZxUserAndDepartment zxUserAndDepartment=zxOfficeApplyDao.getUserAndDepartment(ZxOfficeApplyShow.getUser_id());
				ZxOfficeApplyShow.setUser_name(zxUserAndDepartment.getUser_name());
				ZxOfficeApplyShow.setDepartment_name(zxUserAndDepartment.getDepartment());
			}
			
			return ZxOfficeApplyShow;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_office_apply 
	* @return
	*/
	public int addZxOfficeApply(ZxOfficeApply zxOfficeApply){
		int i = 0;
		try {
			i = zxOfficeApplyDao.addZxOfficeApply(zxOfficeApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApply(ZxOfficeApply zxOfficeApply){
		int i = 0;
		try {
			i = zxOfficeApplyDao.updateZxOfficeApply(zxOfficeApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	
	
	/**
	* 修改状态
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeOut(ZxOfficeApply zxOfficeApply){
		int i = 0;
		try {
			i = zxOfficeApplyDao.updateZxOfficeApply(zxOfficeApply);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改库存
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeOutInventory(ZxOfficeInventory zxOfficeInventory){
		int i = 0;
		try {
			i = zxOfficeApplyDao.updateZxOfficeOutInventory(zxOfficeInventory);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApplyProof(String id){
		int i = 0;
		try {
			i = zxOfficeApplyDao.updateZxOfficeApplyProof(id);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office_apply 
	* @return
	*/
	public int updateZxOfficeApplyBySelective(ZxOfficeApply zxOfficeApply){
		int i = 0;
		try {
			i = zxOfficeApplyDao.updateZxOfficeApplyBySelective(zxOfficeApply);
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
	public int delZxOfficeApply(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOfficeApplyDao.delZxOfficeApply(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_office_applyList 
	* @return
	*/
	public int addBatchZxOfficeApply(List<ZxOfficeApply> zxOfficeApplyList){
		int i = 0;
		try {
			i = zxOfficeApplyDao.addBatchZxOfficeApply(zxOfficeApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_office_applyList 
	* @return
	*/
	public int updateBatchZxOfficeApply(List<ZxOfficeApply> zxOfficeApplyList){
		int i = 0;
		try {
			i = zxOfficeApplyDao.updateBatchZxOfficeApply(zxOfficeApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_office_applyList 
	* @return
	*/
	public int updateBatchZxOfficeApplyBySelective(List<ZxOfficeApply> zxOfficeApplyList){
		int i = 0;
		try {
			i = zxOfficeApplyDao.updateBatchZxOfficeApplyBySelective(zxOfficeApplyList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
