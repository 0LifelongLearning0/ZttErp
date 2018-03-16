package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZxSixSContentService;
import jehc.zxmodules.dao.ZxSixSContentDao;
import jehc.zxmodules.model.ZxSixSContent;

/**
* 6S待办内容 
* 2017-11-01 10:20:06  a
*/
@Service("zxSixSContentService")
public class ZxSixSContentServiceImpl extends BaseService implements ZxSixSContentService{
	@Autowired
	private ZxSixSContentDao zxSixSContentDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxSixSContent> getZxSixSContentListByCondition(Map<String,Object> condition){
		try{
			return zxSixSContentDao.getZxSixSContentListByCondition(condition);
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param id 
	* @return
	*/
	public ZxSixSContent getZxSixSContentById(String id){
		try{
			ZxSixSContent zxSixSContent = zxSixSContentDao.getZxSixSContentById(id);
			return zxSixSContent;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_six_s_content 
	* @return
	*/
	public int addZxSixSContent(ZxSixSContent zxSixSContent){
		int i = 0;
		try {
			i = zxSixSContentDao.addZxSixSContent(zxSixSContent);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_six_s_content 
	* @return
	*/
	public int updateZxSixSContent(ZxSixSContent zxSixSContent){
		int i = 0;
		try {
			i = zxSixSContentDao.updateZxSixSContent(zxSixSContent);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_six_s_content 
	* @return
	*/
	public int updateZxSixSContentBySelective(ZxSixSContent zxSixSContent){
		int i = 0;
		try {
			i = zxSixSContentDao.updateZxSixSContentBySelective(zxSixSContent);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZxSixSContent(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxSixSContentDao.delZxSixSContent(condition);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_six_s_contentList 
	* @return
	*/
	public int addBatchZxSixSContent(List<ZxSixSContent> zxSixSContentList){
		int i = 0;
		try {
			i = zxSixSContentDao.addBatchZxSixSContent(zxSixSContentList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_six_s_contentList 
	* @return
	*/
	public int updateBatchZxSixSContent(List<ZxSixSContent> zxSixSContentList){
		int i = 0;
		try {
			i = zxSixSContentDao.updateBatchZxSixSContent(zxSixSContentList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_six_s_contentList 
	* @return
	*/
	public int updateBatchZxSixSContentBySelective(List<ZxSixSContent> zxSixSContentList){
		int i = 0;
		try {
			i = zxSixSContentDao.updateBatchZxSixSContentBySelective(zxSixSContentList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
