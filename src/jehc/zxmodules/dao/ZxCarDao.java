package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZxCar;

/**
* 车辆管理 
* 2017-09-14 10:21:06  陆建
*/
public interface ZxCarDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxCar> getZxCarListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxCar getZxCarById(String id);
	/**
	* 添加
	* @param zx_car 
	* @return
	*/
	public int addZxCar(ZxCar zxCar);
	/**
	* 修改
	* @param zx_car 
	* @return
	*/
	public int updateZxCar(ZxCar zxCar);
	/**
	* 修改（根据动态条件）
	* @param zx_car 
	* @return
	*/
	public int updateZxCarBySelective(ZxCar zxCar);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxCar(Map<String,Object> condition);
	/**
	* 批量添加
	* @param zx_carList 
	* @return
	*/
	public int addBatchZxCar(List<ZxCar> zxCarList);
	/**
	* 批量修改
	* @param zx_carList 
	* @return
	*/
	public int updateBatchZxCar(List<ZxCar> zxCarList);
	/**
	* 批量修改（根据动态条件）
	* @param zx_carList 
	* @return
	*/
	public int updateBatchZxCarBySelective(List<ZxCar> zxCarList);
}
