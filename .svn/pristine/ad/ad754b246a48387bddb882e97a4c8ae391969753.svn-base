package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxOutsourceTime;

/**
* 外协分批到货管理 
* 2017-09-01 09:30:59  陈运芝
*/
public interface ZxOutsourceTimeDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutsourceTime> getZxOutsourceTimeListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutsourceTime getZxOutsourceTimeById(String id);
	/**
	* 添加
	* @param zx_outsource_time 
	* @return
	*/
	public int addZxOutsourceTime(ZxOutsourceTime zxOutsourceTime);
	/**
	* 修改
	* @param zx_outsource_time 
	* @return
	*/
	public int updateZxOutsourceTime(ZxOutsourceTime zxOutsourceTime);
	/**
	* 修改（根据动态条件）
	* @param zx_outsource_time 
	* @return
	*/
	public int updateZxOutsourceTimeBySelective(ZxOutsourceTime zxOutsourceTime);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutsourceTime(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_outsource_timeList 
	* @return
	*/
	public int addBatchZxOutsourceTime(List<ZxOutsourceTime> zxOutsourceTimeList);
	/**
	* 批量修改
	* @param zx_outsource_timeList 
	* @return
	*/
	public int updateBatchZxOutsourceTime(List<ZxOutsourceTime> zxOutsourceTimeList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_outsource_timeList 
	* @return
	*/
	public int updateBatchZxOutsourceTimeBySelective(List<ZxOutsourceTime> zxOutsourceTimeList);
	/**
	* 根据外键删除方法
	* @param outsource_id
	* @return
	*/
	public int delZxOutsourceTimeByForeignKey(String outsource_id);
}
