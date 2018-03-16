package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxStaffRecordDao;
import jehc.zxmodules.model.ZxStaffRecord;

/**
* 员工档案 
* 2018-01-04 15:58:11  owen
*/
@Repository("zxStaffRecordDao")
public class ZxStaffRecordDaoImpl  extends BaseDaoImpl implements ZxStaffRecordDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxStaffRecord> getZxStaffRecordListByCondition(Map<String,Object> condition){
		return (List<ZxStaffRecord>)this.getList("getZxStaffRecordListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxStaffRecord getZxStaffRecordById(String id){
		return (ZxStaffRecord)this.get("getZxStaffRecordById", id);
	}
	/**
	* 添加
	* @param zx_staff_record 
	* @return
	*/
	public int addZxStaffRecord(ZxStaffRecord zxStaffRecord){
		return this.add("addZxStaffRecord", zxStaffRecord);
	}
	/**
	* 修改
	* @param zx_staff_record 
	* @return
	*/
	public int updateZxStaffRecord(ZxStaffRecord zxStaffRecord){
		return this.update("updateZxStaffRecord", zxStaffRecord);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_staff_record 
	* @return
	*/
	public int updateZxStaffRecordBySelective(ZxStaffRecord zxStaffRecord){
		return this.update("updateZxStaffRecordBySelective", zxStaffRecord);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxStaffRecord(Map<String,Object> condition){
		return this.del("delZxStaffRecord", condition);
	}
	/**
	* 批量添加
	* @param zx_staff_recordList 
	* @return
	*/
	public int addBatchZxStaffRecord(List<ZxStaffRecord> zxStaffRecordList){
		return this.add("addBatchZxStaffRecord", zxStaffRecordList);
	}
	/**
	* 批量修改
	* @param zx_staff_recordList 
	* @return
	*/
	public int updateBatchZxStaffRecord(List<ZxStaffRecord> zxStaffRecordList){
		return this.update("updateBatchZxStaffRecord", zxStaffRecordList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_staff_recordList 
	* @return
	*/
	public int updateBatchZxStaffRecordBySelective(List<ZxStaffRecord> zxStaffRecordList){
		return this.update("updateBatchZxStaffRecordBySelective", zxStaffRecordList);
	}
}
