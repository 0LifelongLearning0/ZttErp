package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttProcessproductDao;
import jehc.zxmodules.model.ZttProcessproduct;

/**
* 机械加工工艺过程表 
* 2018-04-24 14:27:01  季建吉
*/
@Repository("zttProcessproductDao")
public class ZttProcessproductDaoImpl  extends BaseDaoImpl implements ZttProcessproductDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttProcessproduct> getZttProcessproductListByCondition(Map<String,Object> condition){
		return (List<ZttProcessproduct>)this.getList("getZttProcessproductListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttProcessproduct getZttProcessproductById(String id){
		return (ZttProcessproduct)this.get("getZttProcessproductById", id);
	}
	/**
	* 添加
	* @param ztt_processproduct 
	* @return
	*/
	public int addZttProcessproduct(ZttProcessproduct zttProcessproduct){
		return this.add("addZttProcessproduct", zttProcessproduct);
	}
	/**
	* 修改
	* @param ztt_processproduct 
	* @return
	*/
	public int updateZttProcessproduct(ZttProcessproduct zttProcessproduct){
		return this.update("updateZttProcessproduct", zttProcessproduct);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_processproduct 
	* @return
	*/
	public int updateZttProcessproductBySelective(ZttProcessproduct zttProcessproduct){
		return this.update("updateZttProcessproductBySelective", zttProcessproduct);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttProcessproduct(Map<String,Object> condition){
		return this.del("delZttProcessproduct", condition);
	}
	/**
	* 批量添加
	* @param ztt_processproductList 
	* @return
	*/
	public int addBatchZttProcessproduct(List<ZttProcessproduct> zttProcessproductList){
		return this.add("addBatchZttProcessproduct", zttProcessproductList);
	}
	/**
	* 批量修改
	* @param ztt_processproductList 
	* @return
	*/
	public int updateBatchZttProcessproduct(List<ZttProcessproduct> zttProcessproductList){
		return this.update("updateBatchZttProcessproduct", zttProcessproductList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_processproductList 
	* @return
	*/
	public int updateBatchZttProcessproductBySelective(List<ZttProcessproduct> zttProcessproductList){
		return this.update("updateBatchZttProcessproductBySelective", zttProcessproductList);
	}
	/**
	* 根据外键删除方法
	* @param parentId
	* @return
	*/
	public int delZttProcessproductByForeignKey(String parentId){
		return this.del("delZttProcessproductByForeignKey", parentId);
	}
}
