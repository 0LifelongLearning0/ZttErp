package jehc.xtmodules.xtdao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.xtmodules.xtdao.XtUnitDao;
import jehc.xtmodules.xtmodel.XtUnit;

/**
* 商品(产品)单位 
* 2015-05-24 08:43:08  邓纯杰
*/
@Repository("xtUnitDao")
public class XtUnitDaoImpl  extends BaseDaoImpl implements XtUnitDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<XtUnit> getXtUnitListByCondition(Map<String,Object> condition){
		return (List<XtUnit>)this.getList("getXtUnitListByCondition",condition);
	}
	/**
	* 查询对象
	* @param xt_unit_id 
	* @return
	*/
	public XtUnit getXtUnitById(String xt_unit_id){
		return (XtUnit)this.get("getXtUnitById", xt_unit_id);
	}
	/**
	* 添加
	* @param xt_unit 
	* @return
	*/
	public int addXtUnit(XtUnit xt_Unit){
		return this.add("addXtUnit", xt_Unit);
	}
	/**
	* 修改
	* @param xt_unit 
	* @return
	*/
	public int updateXtUnit(XtUnit xt_Unit){
		return this.update("updateXtUnit", xt_Unit);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delXtUnit(Map<String,Object> condition){
		return this.del("delXtUnit", condition);
	}
}
