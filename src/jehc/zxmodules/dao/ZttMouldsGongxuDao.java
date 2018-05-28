package jehc.zxmodules.dao;
import java.util.List;
import java.util.Map;
import jehc.zxmodules.model.ZttMouldsGongxu;

/**
* 模具部工序 
* 2018-05-24 16:46:19  季建吉
*/
public interface ZttMouldsGongxuDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttMouldsGongxu> getZttMouldsGongxuListByCondition(Map<String,Object> condition);
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZttMouldsGongxu getZttMouldsGongxuById(String id);
	/**
	* 添加
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int addZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu);
	/**
	* 修改
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int updateZttMouldsGongxu(ZttMouldsGongxu zttMouldsGongxu);
	/**
	* 修改（根据动态条件）
	* @param ztt_moulds_gongxu 
	* @return
	*/
	public int updateZttMouldsGongxuBySelective(ZttMouldsGongxu zttMouldsGongxu);
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttMouldsGongxu(Map<String,Object> condition);
	/**
	* 批量添加
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int addBatchZttMouldsGongxu(List<ZttMouldsGongxu> zttMouldsGongxuList);
	/**
	* 批量修改
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int updateBatchZttMouldsGongxu(List<ZttMouldsGongxu> zttMouldsGongxuList);
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moulds_gongxuList 
	* @return
	*/
	public int updateBatchZttMouldsGongxuBySelective(List<ZttMouldsGongxu> zttMouldsGongxuList);
}
