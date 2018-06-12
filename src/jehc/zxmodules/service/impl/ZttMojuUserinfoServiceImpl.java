package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.service.ZttMojuUserinfoService;
import jehc.zxmodules.dao.ZttMojuUserinfoDao;
import jehc.zxmodules.model.ZttMojuUserinfo;

/**
* 模具部车间员工信息表 
* 2018-05-29 13:39:52  季建吉
*/
@Service("zttMojuUserinfoService")
public class ZttMojuUserinfoServiceImpl extends BaseService implements ZttMojuUserinfoService{
	@Autowired
	private ZttMojuUserinfoDao zttMojuUserinfoDao;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZttMojuUserinfo> getZttMojuUserinfoListByCondition(Map<String,Object> condition){
		try{
			return zttMojuUserinfoDao.getZttMojuUserinfoListByCondition(condition);
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 查询对象
	* @param xt_userinfo_id 
	* @return
	*/
	public ZttMojuUserinfo getZttMojuUserinfoById(String xt_userinfo_id){
		try{
			ZttMojuUserinfo zttMojuUserinfo = zttMojuUserinfoDao.getZttMojuUserinfoById(xt_userinfo_id);
			return zttMojuUserinfo;
		} catch (Exception e) {
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int addZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo){
		int i = 0;
		try {
			i = zttMojuUserinfoDao.addZttMojuUserinfo(zttMojuUserinfo);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int updateZttMojuUserinfo(ZttMojuUserinfo zttMojuUserinfo){
		int i = 0;
		try {
			i = zttMojuUserinfoDao.updateZttMojuUserinfo(zttMojuUserinfo);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param ztt_moju_userinfo 
	* @return
	*/
	public int updateZttMojuUserinfoBySelective(ZttMojuUserinfo zttMojuUserinfo){
		int i = 0;
		try {
			i = zttMojuUserinfoDao.updateZttMojuUserinfoBySelective(zttMojuUserinfo);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 删除
	* @param condition 
	* @return
	*/
	public int delZttMojuUserinfo(Map<String,Object> condition){
		int i = 0;
		try {
			i = zttMojuUserinfoDao.delZttMojuUserinfo(condition);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int addBatchZttMojuUserinfo(List<ZttMojuUserinfo> zttMojuUserinfoList){
		int i = 0;
		try {
			i = zttMojuUserinfoDao.addBatchZttMojuUserinfo(zttMojuUserinfoList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int updateBatchZttMojuUserinfo(List<ZttMojuUserinfo> zttMojuUserinfoList){
		int i = 0;
		try {
			i = zttMojuUserinfoDao.updateBatchZttMojuUserinfo(zttMojuUserinfoList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param ztt_moju_userinfoList 
	* @return
	*/
	public int updateBatchZttMojuUserinfoBySelective(List<ZttMojuUserinfo> zttMojuUserinfoList){
		int i = 0;
		try {
			i = zttMojuUserinfoDao.updateBatchZttMojuUserinfoBySelective(zttMojuUserinfoList);
		} catch (Exception e) {
			i = 0;
			/**捕捉异常并回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
