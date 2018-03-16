package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxOfficeDao;
import jehc.zxmodules.model.ZxOffice;
import jehc.zxmodules.model.ZxOfficeClassify;
import jehc.zxmodules.model.ZxOfficeInventoryShow;

/**
* 办公用品管理 
* 2018-01-11 13:16:08  季建吉
*/
@Repository("zxOfficeDao")
public class ZxOfficeDaoImpl  extends BaseDaoImpl implements ZxOfficeDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxOffice> getZxOfficeListByCondition(Map<String,Object> condition){
		return (List<ZxOffice>)this.getList("getZxOfficeListByCondition",condition);
	}
	
	/**
	* 查询对象
	* @param office_id 
	* @return
	*/
	public ZxOffice getZxOfficeById(String office_id){
		return (ZxOffice)this.get("getZxOfficeById", office_id);
	}
	
	public List<ZxOffice> getZxOfficeByClassifyId(String classify_id){
		return (List<ZxOffice>)this.getList("getZxOfficeByClassifyId", classify_id);
	}
	/**
	* 添加
	* @param zx_office 
	* @return
	*/
	public int addZxOffice(ZxOffice zxOffice){
		return this.add("addZxOffice", zxOffice);
	}
	/**
	* 修改
	* @param zx_office 
	* @return
	*/
	public int updateZxOffice(ZxOffice zxOffice){
		return this.update("updateZxOffice", zxOffice);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_office 
	* @return
	*/
	public int updateZxOfficeBySelective(ZxOffice zxOffice){
		return this.update("updateZxOfficeBySelective", zxOffice);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxOffice(Map<String,Object> condition){
		return this.del("delZxOffice", condition);
	}
	/**
	* 批量添加
	* @param zx_officeList 
	* @return
	*/
	public int addBatchZxOffice(List<ZxOffice> zxOfficeList){
		return this.add("addBatchZxOffice", zxOfficeList);
	}
	/**
	* 批量修改
	* @param zx_officeList 
	* @return
	*/
	public int updateBatchZxOffice(List<ZxOffice> zxOfficeList){
		return this.update("updateBatchZxOffice", zxOfficeList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_officeList 
	* @return
	*/
	public int updateBatchZxOfficeBySelective(List<ZxOffice> zxOfficeList){
		return this.update("updateBatchZxOfficeBySelective", zxOfficeList);
	}
}
