package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZttMouldsDeiviceDao;
import jehc.zxmodules.model.ZttMouldsDeivice;

/**
* 工序设备 
* 2018-05-24 16:46:19  季建吉
*/
@Repository("zttMouldsDeiviceDao")
public class ZttMouldsDeiviceDaoImpl  extends BaseDaoImpl implements ZttMouldsDeiviceDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZttMouldsDeivice> getZttMouldsDeiviceListByCondition(Map<String,Object> condition){
		return (List<ZttMouldsDeivice>)this.getList("getZttMouldsDeiviceListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttMouldsDeivice getZttMouldsDeiviceById(String id){
		return (ZttMouldsDeivice)this.get("getZttMouldsDeiviceById", id);
	}
	/**
	* 添加
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int addZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice){
		return this.add("addZttMouldsDeivice", zttMouldsDeivice);
	}
	/**
	* 修改
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int updateZttMouldsDeivice(ZttMouldsDeivice zttMouldsDeivice){
		return this.update("updateZttMouldsDeivice", zttMouldsDeivice);
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_moulds_deivice 
	* @return
	*/
	public int updateZttMouldsDeiviceBySelective(ZttMouldsDeivice zttMouldsDeivice){
		return this.update("updateZttMouldsDeiviceBySelective", zttMouldsDeivice);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttMouldsDeivice(Map<String,Object> condition){
		return this.del("delZttMouldsDeivice", condition);
	}
	/**
	* 批量添加
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int addBatchZttMouldsDeivice(List<ZttMouldsDeivice> zttMouldsDeiviceList){
		return this.add("addBatchZttMouldsDeivice", zttMouldsDeiviceList);
	}
	/**
	* 批量修改
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int updateBatchZttMouldsDeivice(List<ZttMouldsDeivice> zttMouldsDeiviceList){
		return this.update("updateBatchZttMouldsDeivice", zttMouldsDeiviceList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moulds_deiviceList 
	* @return
	*/
	public int updateBatchZttMouldsDeiviceBySelective(List<ZttMouldsDeivice> zttMouldsDeiviceList){
		return this.update("updateBatchZttMouldsDeiviceBySelective", zttMouldsDeiviceList);
	}
	/**
	* 根据外键删除方法
	* @param gongxu_id
	* @return
	*/
	public int delZttMouldsDeiviceByForeignKey(String gongxu_id){
		return this.del("delZttMouldsDeiviceByForeignKey", gongxu_id);
	}
}
