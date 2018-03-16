package jehc.zxmodules.service.impl;
import java.util.List;
import java.util.Map;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jehc.zxmodules.model.ZxOutsourceTime;
import jehc.zxmodules.service.ZxOutsourceTimeService;
import java.util.HashMap;
import java.util.ArrayList;
import jehc.xtmodules.xtcore.allutils.StringUtil;
import jehc.zxmodules.service.ZxOutsourceService;
import jehc.zxmodules.dao.ZxOutsourceDao;
import jehc.zxmodules.model.ZxOutsource;

/**
* 外协加工进度表 
* 2017-09-01 09:30:59  陈运芝
*/
@Service("zxOutsourceService")
public class ZxOutsourceServiceImpl extends BaseService implements ZxOutsourceService{
	@Autowired
	private ZxOutsourceDao zxOutsourceDao;
	@Autowired
	private ZxOutsourceTimeService zxOutsourceTimeService;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<ZxOutsource> getZxOutsourceListByCondition(Map<String,Object> condition){
		try{
			return zxOutsourceDao.getZxOutsourceListByCondition(condition);
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
	public ZxOutsource getZxOutsourceById(String id){
		try{
			ZxOutsource zxOutsource = zxOutsourceDao.getZxOutsourceById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("outsource_id", id);
			List<ZxOutsourceTime> zxOutsourceTime = zxOutsourceTimeService.getZxOutsourceTimeListByCondition(condition);
			zxOutsource.setZxOutsourceTime(zxOutsourceTime);
			return zxOutsource;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_outsource 
	* @return
	*/
	public int addZxOutsource(ZxOutsource zxOutsource){
		int i = 0;
		try {
			i = zxOutsourceDao.addZxOutsource(zxOutsource);
			List<ZxOutsourceTime> zxOutsourceTimeTempList = zxOutsource.getZxOutsourceTime();
			if(null != zxOutsourceTimeTempList && zxOutsourceTimeTempList.size() > 0){
				List<ZxOutsourceTime> zxOutsourceTimeList = new ArrayList<ZxOutsourceTime>();
				for(int j = 0; j < zxOutsourceTimeTempList.size(); j++){
					if(zxOutsource.getZxOutsourceTime_removed_flag().indexOf(","+j+",") == -1){
						zxOutsourceTimeTempList.get(j).setOutsource_id(zxOutsource.getId());
						zxOutsourceTimeTempList.get(j).setId(toUUID());
						zxOutsourceTimeList.add(zxOutsourceTimeTempList.get(j));
					}
				}
				if(!zxOutsourceTimeList.isEmpty()&&zxOutsourceTimeList.size()>0){
					zxOutsourceTimeService.addBatchZxOutsourceTime(zxOutsourceTimeList);
				}
			}
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改
	* @param zx_outsource 
	* @return
	*/
	public int updateZxOutsource(ZxOutsource zxOutsource){
		int i = 0;
		try {
			i = zxOutsourceDao.updateZxOutsourceBySelective(zxOutsource);
			List<ZxOutsourceTime> zxOutsourceTimeList = zxOutsource.getZxOutsourceTime();
			if(null != zxOutsourceTimeList && zxOutsourceTimeList.size() > 0){
				List<ZxOutsourceTime> zxOutsourceTimeAddList = new ArrayList<ZxOutsourceTime>();
				List<ZxOutsourceTime> zxOutsourceTimeUpdateList = new ArrayList<ZxOutsourceTime>();
				for(int j = 0; j < zxOutsourceTimeList.size(); j++){
					if(zxOutsource.getZxOutsourceTime_removed_flag().indexOf(","+j+",") == -1){
						zxOutsourceTimeList.get(j).setOutsource_id(zxOutsource.getId());
						if(StringUtil.isEmpty(zxOutsourceTimeList.get(j).getId())){
							zxOutsourceTimeList.get(j).setId(toUUID());
							zxOutsourceTimeAddList.add(zxOutsourceTimeList.get(j));
						}else{
							zxOutsourceTimeUpdateList.add(zxOutsourceTimeList.get(j));
						}
					}
				}
				if(!zxOutsourceTimeAddList.isEmpty()&&zxOutsourceTimeAddList.size()>0){
					zxOutsourceTimeService.addBatchZxOutsourceTime(zxOutsourceTimeAddList);
				}
				if(!zxOutsourceTimeUpdateList.isEmpty()&&zxOutsourceTimeUpdateList.size()>0){
					zxOutsourceTimeService.updateBatchZxOutsourceTimeBySelective(zxOutsourceTimeUpdateList);
				}
			}
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 修改（根据动态条件）
	* @param zx_outsource 
	* @return
	*/
	public int updateZxOutsourceBySelective(ZxOutsource zxOutsource){
		int i = 0;
		try {
			i = zxOutsourceDao.updateZxOutsourceBySelective(zxOutsource);
			List<ZxOutsourceTime> zxOutsourceTimeList = zxOutsource.getZxOutsourceTime();
			List<ZxOutsourceTime> zxOutsourceTimeAddList = new ArrayList<ZxOutsourceTime>();
			List<ZxOutsourceTime> zxOutsourceTimeUpdateList = new ArrayList<ZxOutsourceTime>();
			for(int j = 0; j < zxOutsourceTimeList.size(); j++){
				if(zxOutsource.getZxOutsourceTime_removed_flag().indexOf(","+j+",") == -1){
					zxOutsourceTimeList.get(j).setOutsource_id(zxOutsource.getId());
					if(StringUtil.isEmpty(zxOutsourceTimeList.get(j).getId())){
						zxOutsourceTimeList.get(j).setId(toUUID());
						zxOutsourceTimeAddList.add(zxOutsourceTimeList.get(j));
					}else{
						zxOutsourceTimeUpdateList.add(zxOutsourceTimeList.get(j));
					}
				}
			}
			if(!zxOutsourceTimeAddList.isEmpty()&&zxOutsourceTimeAddList.size()>0){
				zxOutsourceTimeService.addBatchZxOutsourceTime(zxOutsourceTimeAddList);
			}
			if(!zxOutsourceTimeUpdateList.isEmpty()&&zxOutsourceTimeUpdateList.size()>0){
				zxOutsourceTimeService.updateBatchZxOutsourceTimeBySelective(zxOutsourceTimeUpdateList);
			}
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
	public int delZxOutsource(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOutsourceDao.delZxOutsource(condition);
			String[] idList= (String[])condition.get("id");
			for(String id:idList){
				zxOutsourceTimeService.delZxOutsourceTimeByForeignKey(id);
			}
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量添加
	* @param zx_outsourceList 
	* @return
	*/
	public int addBatchZxOutsource(List<ZxOutsource> zxOutsourceList){
		int i = 0;
		try {
			i = zxOutsourceDao.addBatchZxOutsource(zxOutsourceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_outsourceList 
	* @return
	*/
	public int updateBatchZxOutsource(List<ZxOutsource> zxOutsourceList){
		int i = 0;
		try {
			i = zxOutsourceDao.updateBatchZxOutsource(zxOutsourceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_outsourceList 
	* @return
	*/
	public int updateBatchZxOutsourceBySelective(List<ZxOutsource> zxOutsourceList){
		int i = 0;
		try {
			i = zxOutsourceDao.updateBatchZxOutsourceBySelective(zxOutsourceList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
