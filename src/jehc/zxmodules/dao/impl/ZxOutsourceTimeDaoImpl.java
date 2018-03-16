package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOutsourceTimeDao;
import jehc.zxmodules.model.ZxOutsourceTime;

/**
* 外协分批到货管理 
* 2017-09-01 09:30:59  陈运芝
*/
@Repository("zxOutsourceTimeDao")
public class ZxOutsourceTimeDaoImpl  extends BaseDaoImpl implements ZxOutsourceTimeDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOutsourceTime> getZxOutsourceTimeListByCondition(Map<String,Object> condition){
		return (List<ZxOutsourceTime>)this.getList("getZxOutsourceTimeListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutsourceTime getZxOutsourceTimeById(String id){
		return (ZxOutsourceTime)this.get("getZxOutsourceTimeById", id);
	}
	/**
	* 添加
	* @param zx_outsource_time 
	* @return
	*/
	public int addZxOutsourceTime(ZxOutsourceTime zxOutsourceTime){
		return this.add("addZxOutsourceTime", zxOutsourceTime);
	}
	/**
	* 修改
	* @param zx_outsource_time 
	* @return
	*/
	public int updateZxOutsourceTime(ZxOutsourceTime zxOutsourceTime){
		return this.update("updateZxOutsourceTime", zxOutsourceTime);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_outsource_time 
	* @return
	*/
	public int updateZxOutsourceTimeBySelective(ZxOutsourceTime zxOutsourceTime){
		return this.update("updateZxOutsourceTimeBySelective", zxOutsourceTime);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutsourceTime(Map<String,Object> condition){
		return this.del("delZxOutsourceTime", condition);
	}
	/**
	* 批量添加
	* @param zx_outsource_timeList 
	* @return
	*/
	public int addBatchZxOutsourceTime(List<ZxOutsourceTime> zxOutsourceTimeList){
		return this.add("addBatchZxOutsourceTime", zxOutsourceTimeList);
	}
	/**
	* 批量修改
	* @param zx_outsource_timeList 
	* @return
	*/
	public int updateBatchZxOutsourceTime(List<ZxOutsourceTime> zxOutsourceTimeList){
		return this.update("updateBatchZxOutsourceTime", zxOutsourceTimeList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_outsource_timeList 
	* @return
	*/
	public int updateBatchZxOutsourceTimeBySelective(List<ZxOutsourceTime> zxOutsourceTimeList){
		return this.update("updateBatchZxOutsourceTimeBySelective", zxOutsourceTimeList);
	}
	/**
	* 根据外键删除方法
	* @param outsource_id
	* @return
	*/
	public int delZxOutsourceTimeByForeignKey(String outsource_id){
		return this.del("delZxOutsourceTimeByForeignKey", outsource_id);
	}
}
