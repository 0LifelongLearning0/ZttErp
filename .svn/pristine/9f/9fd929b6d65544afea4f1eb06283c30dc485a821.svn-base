package jehc.zxmodules.service;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxOutTime;

/**
* 外协分批到货管理 
* 2017-11-03 09:08:36  陈运芝
*/
public interface ZxOutTimeService{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutTime> getZxOutTimeListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutTime getZxOutTimeById(String id);
	/**
	* 添加
	* @param zx_out_time 
	* @return
	*/
	public int addZxOutTime(ZxOutTime zxOutTime);
	/**
	* 修改
	* @param zx_out_time 
	* @return
	*/
	public int updateZxOutTime(ZxOutTime zxOutTime);
	/**
	* 修改（根据动态条件）
	* @param zx_out_time 
	* @return
	*/
	public int updateZxOutTimeBySelective(ZxOutTime zxOutTime);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutTime(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_out_timeList 
	* @return
	*/
	public int addBatchZxOutTime(List<ZxOutTime> zxOutTimeList);
	/**
	* 批量修改
	* @param zx_out_timeList 
	* @return
	*/
	public int updateBatchZxOutTime(List<ZxOutTime> zxOutTimeList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_timeList 
	* @return
	*/
	public int updateBatchZxOutTimeBySelective(List<ZxOutTime> zxOutTimeList);
	/**
	* 根据外键删除
	* @param outsource_id
	* @return
	*/
	public int delZxOutTimeByForeignKey(String outsource_id);
}
