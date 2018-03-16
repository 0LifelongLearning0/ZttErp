package jehc.zxmodules.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.allutils.StringUtil;
import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.DateUtils;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxOutProgressDao;
import jehc.zxmodules.model.ZxOutProgress;
import jehc.zxmodules.model.ZxOutTime;
import jehc.zxmodules.service.ZxOutProgressService;
import jehc.zxmodules.service.ZxOutTimeService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 外协加工进度表 
* 2017-11-03 09:08:36  陈运芝
*/
@Service("zxOutProgressService")
public class ZxOutProgressServiceImpl extends BaseService implements ZxOutProgressService{
	@Autowired
	private ZxOutProgressDao zxOutProgressDao;
	@Autowired
	private ZxOutTimeService zxOutTimeService;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<Map<String,Object>> getZxOutProgressListByCondition(Map<String,Object> condition){
		try{
			return zxOutProgressDao.getZxOutProgressListByCondition(condition);
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
	public ZxOutProgress getZxOutProgressById(String id){
		try{
			ZxOutProgress zxOutProgress = zxOutProgressDao.getZxOutProgressById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("outsource_id", id);
			List<ZxOutTime> zxOutTime = zxOutTimeService.getZxOutTimeListByCondition(condition);
			zxOutProgress.setZxOutTime(zxOutTime);
			return zxOutProgress;
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
	public Map<String,Object> getMapZxOutProgressById(String id){
		try{
			Map<String, Object> zxOutProgress = zxOutProgressDao.getMapZxOutProgressById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("outsource_id", id);
			List<ZxOutTime> zxOutTime = zxOutTimeService.getZxOutTimeListByCondition(condition);
			zxOutProgress.put("zxOutTime",zxOutTime);
			return zxOutProgress;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_out_progress 
	* @return
	*/
	public int addZxOutProgress(ZxOutProgress zxOutProgress){
		int i = 0;
		try {
			i = zxOutProgressDao.addZxOutProgress(zxOutProgress);
			List<ZxOutTime> zxOutTimeTempList = zxOutProgress.getZxOutTime();
			List<ZxOutTime> zxOutTimeList = new ArrayList<ZxOutTime>();
			for(int j = 0; j < zxOutTimeTempList.size(); j++){
				if(zxOutProgress.getZxOutTime_removed_flag().indexOf(","+j+",") == -1){
					zxOutTimeTempList.get(j).setOut_id(zxOutProgress.getId());
					zxOutTimeTempList.get(j).setId(toUUID());
					zxOutTimeList.add(zxOutTimeTempList.get(j));
				}
			}
			if(!zxOutTimeList.isEmpty()&&zxOutTimeList.size()>0){
				zxOutTimeService.addBatchZxOutTime(zxOutTimeList);
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
	* @param zx_out_progress 
	* @return
	*/
	public int updateZxOutProgress(ZxOutProgress zxOutProgress){
		int i = 0;
		try {
			i = zxOutProgressDao.updateZxOutProgressBySelective(zxOutProgress);
			List<ZxOutTime> zxOutTimeList = zxOutProgress.getZxOutTime();
			if(null != zxOutTimeList && zxOutTimeList.size() > 0){
				List<ZxOutTime> zxOutTimeAddList = new ArrayList<ZxOutTime>();
				List<ZxOutTime> zxOutTimeUpdateList = new ArrayList<ZxOutTime>();
				BigDecimal realAmount = new BigDecimal(0);
				BigDecimal inAmount = new BigDecimal(0);
				BigDecimal outAmount = new BigDecimal(0);
				Date inStartTime = null;
				Date inEndTime = null;
				Date outStartTime = null;
				Date outEndTime = null;
				for(int j = 0; j < zxOutTimeList.size(); j++){
					if(zxOutProgress.getZxOutTime_removed_flag().indexOf(","+j+",") == -1){
						zxOutTimeList.get(j).setOut_id(zxOutProgress.getId());
						if(StringUtils.isBlank(zxOutTimeList.get(j).getId())){
							zxOutTimeList.get(j).setId(toUUID());
							zxOutTimeAddList.add(zxOutTimeList.get(j));
						}else{
							zxOutTimeUpdateList.add(zxOutTimeList.get(j));
						}
						realAmount = realAmount.add(new BigDecimal(zxOutTimeList.get(j).getReal_amount()));
						if(StringUtils.isNotBlank(zxOutTimeList.get(j).getIn_warehouse_date())){
							if(null == inEndTime){
								inEndTime = DateUtils.parseDate(zxOutTimeList.get(j).getIn_warehouse_date());
							}
							inStartTime = DateUtils.parseDate(zxOutTimeList.get(j).getIn_warehouse_date());
							if(inEndTime.compareTo(inStartTime) < 0){
								inEndTime = inStartTime;
							}
							inAmount = inAmount.add(new BigDecimal(zxOutTimeList.get(j).getIn_warehouse_amount()));
							if(StringUtils.isNotBlank(zxOutTimeList.get(j).getOut_warehouse_date())){
								if(null == outEndTime){
									outEndTime = DateUtils.parseDate(zxOutTimeList.get(j).getOut_warehouse_date());
								}
								outStartTime = DateUtils.parseDate(zxOutTimeList.get(j).getOut_warehouse_date());
								if(outEndTime.compareTo(outStartTime) < 0){
									outEndTime = outStartTime;
								}
								outAmount = outAmount.add(new BigDecimal(zxOutTimeList.get(j).getOut_warehouse_amount()));
							}
						}
					}
				}
				if(!zxOutTimeAddList.isEmpty()&&zxOutTimeAddList.size()>0){
					zxOutTimeService.addBatchZxOutTime(zxOutTimeAddList);
				}
				if(!zxOutTimeUpdateList.isEmpty()&&zxOutTimeUpdateList.size()>0){
					zxOutTimeService.updateBatchZxOutTimeBySelective(zxOutTimeUpdateList);
				}
				zxOutProgress.setReal_amount(realAmount.doubleValue());
				if(null != inEndTime){
					zxOutProgress.setIn_warehouse_date(DateUtils.formatDateTime(inEndTime));
					zxOutProgress.setIn_warehouse_amount(inAmount.doubleValue());
					zxOutProgress.setStatus("3");
				}
				if(null != outEndTime){
					zxOutProgress.setOut_warehouse_date(DateUtils.formatDateTime(outEndTime));
					zxOutProgress.setOut_warehouse_amount(outAmount.doubleValue());
					ZxOutProgress progress = getZxOutProgressById(zxOutProgress.getId());
					if(outAmount.compareTo(new BigDecimal(progress.getOut_amount())) == 0){
						zxOutProgress.setStatus("4");
					}
				}
				i = zxOutProgressDao.updateZxOutProgressBySelective(zxOutProgress);
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
	* @param zx_out_progress 
	* @return
	*/
	public int updateZxOutProgressBySelective(ZxOutProgress zxOutProgress){
		int i = 0;
		try {
			i = zxOutProgressDao.updateZxOutProgressBySelective(zxOutProgress);
			List<ZxOutTime> zxOutTimeList = zxOutProgress.getZxOutTime();
			List<ZxOutTime> zxOutTimeAddList = new ArrayList<ZxOutTime>();
			List<ZxOutTime> zxOutTimeUpdateList = new ArrayList<ZxOutTime>();
			for(int j = 0; j < zxOutTimeList.size(); j++){
				if(zxOutProgress.getZxOutTime_removed_flag().indexOf(","+j+",") == -1){
					zxOutTimeList.get(j).setOut_id(zxOutProgress.getId());
					if(StringUtil.isEmpty(zxOutTimeList.get(j).getId())){
						zxOutTimeList.get(j).setId(toUUID());
						zxOutTimeAddList.add(zxOutTimeList.get(j));
					}else{
						zxOutTimeUpdateList.add(zxOutTimeList.get(j));
					}
				}
			}
			if(!zxOutTimeAddList.isEmpty()&&zxOutTimeAddList.size()>0){
				zxOutTimeService.addBatchZxOutTime(zxOutTimeAddList);
			}
			if(!zxOutTimeUpdateList.isEmpty()&&zxOutTimeUpdateList.size()>0){
				zxOutTimeService.updateBatchZxOutTimeBySelective(zxOutTimeUpdateList);
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
	public int delZxOutProgress(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxOutProgressDao.delZxOutProgress(condition);
			String[] idList= (String[])condition.get("id");
			for(String id:idList){
				zxOutTimeService.delZxOutTimeByForeignKey(id);
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
	* @param zx_out_progressList 
	* @return
	*/
	public int addBatchZxOutProgress(List<ZxOutProgress> zxOutProgressList){
		int i = 0;
		try {
			i = zxOutProgressDao.addBatchZxOutProgress(zxOutProgressList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_out_progressList 
	* @return
	*/
	public int updateBatchZxOutProgress(List<ZxOutProgress> zxOutProgressList){
		int i = 0;
		try {
			i = zxOutProgressDao.updateBatchZxOutProgress(zxOutProgressList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_out_progressList 
	* @return
	*/
	public int updateBatchZxOutProgressBySelective(List<ZxOutProgress> zxOutProgressList){
		int i = 0;
		try {
			i = zxOutProgressDao.updateBatchZxOutProgressBySelective(zxOutProgressList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
