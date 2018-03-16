package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOutsourceDao;
import jehc.zxmodules.model.ZxOutsource;

/**
* 外协加工进度表 
* 2017-09-01 09:30:59  陈运芝
*/
@Repository("zxOutsourceDao")
public class ZxOutsourceDaoImpl  extends BaseDaoImpl implements ZxOutsourceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOutsource> getZxOutsourceListByCondition(Map<String,Object> condition){
		return (List<ZxOutsource>)this.getList("getZxOutsourceListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxOutsource getZxOutsourceById(String id){
		return (ZxOutsource)this.get("getZxOutsourceById", id);
	}
	/**
	* 添加
	* @param zx_outsource 
	* @return
	*/
	public int addZxOutsource(ZxOutsource zxOutsource){
		return this.add("addZxOutsource", zxOutsource);
	}
	/**
	* 修改
	* @param zx_outsource 
	* @return
	*/
	public int updateZxOutsource(ZxOutsource zxOutsource){
		return this.update("updateZxOutsource", zxOutsource);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_outsource 
	* @return
	*/
	public int updateZxOutsourceBySelective(ZxOutsource zxOutsource){
		return this.update("updateZxOutsourceBySelective", zxOutsource);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOutsource(Map<String,Object> condition){
		return this.del("delZxOutsource", condition);
	}
	/**
	* 批量添加
	* @param zx_outsourceList 
	* @return
	*/
	public int addBatchZxOutsource(List<ZxOutsource> zxOutsourceList){
		return this.add("addBatchZxOutsource", zxOutsourceList);
	}
	/**
	* 批量修改
	* @param zx_outsourceList 
	* @return
	*/
	public int updateBatchZxOutsource(List<ZxOutsource> zxOutsourceList){
		return this.update("updateBatchZxOutsource", zxOutsourceList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_outsourceList 
	* @return
	*/
	public int updateBatchZxOutsourceBySelective(List<ZxOutsource> zxOutsourceList){
		return this.update("updateBatchZxOutsourceBySelective", zxOutsourceList);
	}
}
