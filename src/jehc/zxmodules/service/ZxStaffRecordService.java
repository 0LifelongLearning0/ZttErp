package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxStaffRecord;

/**
* 员工档案 
* 2018-01-04 15:58:11  owen
*/
public interface ZxStaffRecordService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxStaffRecord> getZxStaffRecordListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxStaffRecord getZxStaffRecordById(String id);
	/**
	* 添加
	* @param zx_staff_record 
	* @return
	*/
	public int addZxStaffRecord(ZxStaffRecord zxStaffRecord);
	/**
	* 修改
	* @param zx_staff_record 
	* @return
	*/
	public int updateZxStaffRecord(ZxStaffRecord zxStaffRecord);
	/**
	* 修改（根据动态条件）
	* @param zx_staff_record 
	* @return
	*/
	public int updateZxStaffRecordBySelective(ZxStaffRecord zxStaffRecord);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxStaffRecord(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_staff_recordList 
	* @return
	*/
	public int addBatchZxStaffRecord(List<ZxStaffRecord> zxStaffRecordList);
	/**
	* 批量修改
	* @param zx_staff_recordList 
	* @return
	*/
	public int updateBatchZxStaffRecord(List<ZxStaffRecord> zxStaffRecordList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_staff_recordList 
	* @return
	*/
	public int updateBatchZxStaffRecordBySelective(List<ZxStaffRecord> zxStaffRecordList);
}
