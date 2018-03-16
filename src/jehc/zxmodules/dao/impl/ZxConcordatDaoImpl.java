package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxConcordatDao;
import jehc.zxmodules.model.ZxConcordat;

/**
* 合同管理 
* 2017-08-31 17:21:48  陈运芝
*/
@Repository("zxConcordatDao")
public class ZxConcordatDaoImpl  extends BaseDaoImpl implements ZxConcordatDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxConcordat> getZxConcordatListByCondition(Map<String,Object> condition){
		return (List<ZxConcordat>)this.getList("getZxConcordatListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxConcordat getZxConcordatById(String id){
		return (ZxConcordat)this.get("getZxConcordatById", id);
	}
	/**
	* 添加
	* @param zx_concordat 
	* @return
	*/
	public int addZxConcordat(ZxConcordat zxConcordat){
		return this.add("addZxConcordat", zxConcordat);
	}
	/**
	* 修改
	* @param zx_concordat 
	* @return
	*/
	public int updateZxConcordat(ZxConcordat zxConcordat){
		return this.update("updateZxConcordat", zxConcordat);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_concordat 
	* @return
	*/
	public int updateZxConcordatBySelective(ZxConcordat zxConcordat){
		return this.update("updateZxConcordatBySelective", zxConcordat);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxConcordat(Map<String,Object> condition){
		return this.del("delZxConcordat", condition);
	}
	/**
	* 批量添加
	* @param zx_concordatList 
	* @return
	*/
	public int addBatchZxConcordat(List<ZxConcordat> zxConcordatList){
		return this.add("addBatchZxConcordat", zxConcordatList);
	}
	/**
	* 批量修改
	* @param zx_concordatList 
	* @return
	*/
	public int updateBatchZxConcordat(List<ZxConcordat> zxConcordatList){
		return this.update("updateBatchZxConcordat", zxConcordatList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_concordatList 
	* @return
	*/
	public int updateBatchZxConcordatBySelective(List<ZxConcordat> zxConcordatList){
		return this.update("updateBatchZxConcordatBySelective", zxConcordatList);
	}
}
