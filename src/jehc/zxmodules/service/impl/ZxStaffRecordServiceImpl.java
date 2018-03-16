package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxStaffRecordService;
import jehc.zxmodules.dao.ZxStaffRecordDao;
import jehc.zxmodules.model.ZxStaffRecord;

/**
* 员工档案 
* 2018-01-04 15:58:11  owen
*/
@Service("zxStaffRecordService")
public class ZxStaffRecordServiceImpl extends BaseService implements ZxStaffRecordService{
	@Autowired
	private ZxStaffRecordDao zxStaffRecordDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxStaffRecord> getZxStaffRecordListByCondition(Map<String,Object> condition){
		try{
			return zxStaffRecordDao.getZxStaffRecordListByCondition(condition);
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
	public ZxStaffRecord getZxStaffRecordById(String id){
		try{
			ZxStaffRecord zxStaffRecord = zxStaffRecordDao.getZxStaffRecordById(id);
			return zxStaffRecord;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_staff_record 
	* @return
	*/
	public int addZxStaffRecord(ZxStaffRecord zxStaffRecord){
		int i = 0;
		try {
			i = zxStaffRecordDao.addZxStaffRecord(zxStaffRecord);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_staff_record 
	* @return
	*/
	public int updateZxStaffRecord(ZxStaffRecord zxStaffRecord){
		int i = 0;
		try {
			i = zxStaffRecordDao.updateZxStaffRecord(zxStaffRecord);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_staff_record 
	* @return
	*/
	public int updateZxStaffRecordBySelective(ZxStaffRecord zxStaffRecord){
		int i = 0;
		try {
			i = zxStaffRecordDao.updateZxStaffRecordBySelective(zxStaffRecord);
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
	public int delZxStaffRecord(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxStaffRecordDao.delZxStaffRecord(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_staff_recordList 
	* @return
	*/
	public int addBatchZxStaffRecord(List<ZxStaffRecord> zxStaffRecordList){
		int i = 0;
		try {
			i = zxStaffRecordDao.addBatchZxStaffRecord(zxStaffRecordList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_staff_recordList 
	* @return
	*/
	public int updateBatchZxStaffRecord(List<ZxStaffRecord> zxStaffRecordList){
		int i = 0;
		try {
			i = zxStaffRecordDao.updateBatchZxStaffRecord(zxStaffRecordList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_staff_recordList 
	* @return
	*/
	public int updateBatchZxStaffRecordBySelective(List<ZxStaffRecord> zxStaffRecordList){
		int i = 0;
		try {
			i = zxStaffRecordDao.updateBatchZxStaffRecordBySelective(zxStaffRecordList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
