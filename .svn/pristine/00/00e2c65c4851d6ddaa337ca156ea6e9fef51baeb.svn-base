package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxSixSDao;
import jehc.zxmodules.model.ZxSixS;

/**
* 6S待办事项 
* 2017-11-01 10:30:02  a
*/
@Repository("zxSixSDao")
public class ZxSixSDaoImpl  extends BaseDaoImpl implements ZxSixSDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxSixS> getZxSixSListByCondition(Map<String,Object> condition){
		return (List<ZxSixS>)this.getList("getZxSixSListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxSixS getZxSixSById(String id){
		return (ZxSixS)this.get("getZxSixSById", id);
	}
	/**
	* 添加
	* @param zx_six_s 
	* @return
	*/
	public int addZxSixS(ZxSixS zxSixS){
		return this.add("addZxSixS", zxSixS);
	}
	/**
	* 修改
	* @param zx_six_s 
	* @return
	*/
	public int updateZxSixS(ZxSixS zxSixS){
		return this.update("updateZxSixS", zxSixS);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_six_s 
	* @return
	*/
	public int updateZxSixSBySelective(ZxSixS zxSixS){
		return this.update("updateZxSixSBySelective", zxSixS);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxSixS(Map<String,Object> condition){
		return this.del("delZxSixS", condition);
	}
	/**
	* 批量添加
	* @param zx_six_sList 
	* @return
	*/
	public int addBatchZxSixS(List<ZxSixS> zxSixSList){
		return this.add("addBatchZxSixS", zxSixSList);
	}
	/**
	* 批量修改
	* @param zx_six_sList 
	* @return
	*/
	public int updateBatchZxSixS(List<ZxSixS> zxSixSList){
		return this.update("updateBatchZxSixS", zxSixSList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_six_sList 
	* @return
	*/
	public int updateBatchZxSixSBySelective(List<ZxSixS> zxSixSList){
		return this.update("updateBatchZxSixSBySelective", zxSixSList);
	}
}
