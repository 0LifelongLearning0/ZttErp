package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxCarDao;
import jehc.zxmodules.model.ZxCar;

/**
* 车辆管理 
* 2017-09-14 10:21:06  陆建
*/
@Repository("zxCarDao")
public class ZxCarDaoImpl  extends BaseDaoImpl implements ZxCarDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxCar> getZxCarListByCondition(Map<String,Object> condition){
		return (List<ZxCar>)this.getList("getZxCarListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxCar getZxCarById(String id){
		return (ZxCar)this.get("getZxCarById", id);
	}
	/**
	* 添加
	* @param zx_car 
	* @return
	*/
	public int addZxCar(ZxCar zxCar){
		return this.add("addZxCar", zxCar);
	}
	/**
	* 修改
	* @param zx_car 
	* @return
	*/
	public int updateZxCar(ZxCar zxCar){
		return this.update("updateZxCar", zxCar);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_car 
	* @return
	*/
	public int updateZxCarBySelective(ZxCar zxCar){
		return this.update("updateZxCarBySelective", zxCar);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxCar(Map<String,Object> condition){
		return this.del("delZxCar", condition);
	}
	/**
	* 批量添加
	* @param zx_carList 
	* @return
	*/
	public int addBatchZxCar(List<ZxCar> zxCarList){
		return this.add("addBatchZxCar", zxCarList);
	}
	/**
	* 批量修改
	* @param zx_carList 
	* @return
	*/
	public int updateBatchZxCar(List<ZxCar> zxCarList){
		return this.update("updateBatchZxCar", zxCarList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_carList 
	* @return
	*/
	public int updateBatchZxCarBySelective(List<ZxCar> zxCarList){
		return this.update("updateBatchZxCarBySelective", zxCarList);
	}
}
