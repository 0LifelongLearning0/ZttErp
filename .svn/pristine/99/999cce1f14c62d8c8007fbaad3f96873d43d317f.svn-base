package jehc.zxmodules.dao.impl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import jehc.xtmodules.xtcore.base.impl.BaseDaoImpl;
import jehc.zxmodules.dao.ZxSixSContentDao;
import jehc.zxmodules.model.ZxSixSContent;

/**
* 6S待办内容 
* 2017-11-01 10:20:06  a
*/
@Repository("zxSixSContentDao")
public class ZxSixSContentDaoImpl  extends BaseDaoImpl implements ZxSixSContentDao{
	/**
	* 分页
	* @param condition 
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<ZxSixSContent> getZxSixSContentListByCondition(Map<String,Object> condition){
		return (List<ZxSixSContent>)this.getList("getZxSixSContentListByCondition",condition);
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxSixSContent getZxSixSContentById(String id){
		return (ZxSixSContent)this.get("getZxSixSContentById", id);
	}
	/**
	* 添加
	* @param zx_six_s_content 
	* @return
	*/
	public int addZxSixSContent(ZxSixSContent zxSixSContent){
		return this.add("addZxSixSContent", zxSixSContent);
	}
	/**
	* 修改
	* @param zx_six_s_content 
	* @return
	*/
	public int updateZxSixSContent(ZxSixSContent zxSixSContent){
		return this.update("updateZxSixSContent", zxSixSContent);
	}
	/**
	* 修改（根据动态条件）
	* @param zx_six_s_content 
	* @return
	*/
	public int updateZxSixSContentBySelective(ZxSixSContent zxSixSContent){
		return this.update("updateZxSixSContentBySelective", zxSixSContent);
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxSixSContent(Map<String,Object> condition){
		return this.del("delZxSixSContent", condition);
	}
	/**
	* 批量添加
	* @param zx_six_s_contentList 
	* @return
	*/
	public int addBatchZxSixSContent(List<ZxSixSContent> zxSixSContentList){
		return this.add("addBatchZxSixSContent", zxSixSContentList);
	}
	/**
	* 批量修改
	* @param zx_six_s_contentList 
	* @return
	*/
	public int updateBatchZxSixSContent(List<ZxSixSContent> zxSixSContentList){
		return this.update("updateBatchZxSixSContent", zxSixSContentList);
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_six_s_contentList 
	* @return
	*/
	public int updateBatchZxSixSContentBySelective(List<ZxSixSContent> zxSixSContentList){
		return this.update("updateBatchZxSixSContentBySelective", zxSixSContentList);
	}
}
