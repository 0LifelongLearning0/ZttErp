package jehc.zxmodules.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.base.BaseService;
import jehc.xtmodules.xtcore.util.DateUtils;
import jehc.xtmodules.xtcore.util.ExceptionUtil;
import jehc.zxmodules.dao.ZxBuyProgressDao;
import jehc.zxmodules.model.ZxBuyProgress;
import jehc.zxmodules.model.ZxBuyTime;
import jehc.zxmodules.service.ZxBuyProgressService;
import jehc.zxmodules.service.ZxBuyTimeService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 采购件进度表 
* 2017-10-28 15:56:49  陈运芝
*/
@Service("zxBuyProgressService")
public class ZxBuyProgressServiceImpl extends BaseService implements ZxBuyProgressService{
	@Autowired
	private ZxBuyProgressDao zxBuyProgressDao;
	@Autowired
	private ZxBuyTimeService zxBuyTimeService;
	/**
	* 分页
	* @param condition 
	* @return
	*/
	public List<Map<String,Object>> getZxBuyProgressListByCondition(Map<String,Object> condition){
		try{
			return zxBuyProgressDao.getZxBuyProgressListByCondition(condition);
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
	public ZxBuyProgress getZxBuyProgressById(String id){
		try{
			ZxBuyProgress zxBuyProgress = zxBuyProgressDao.getZxBuyProgressById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("buy_id", id);
			List<ZxBuyTime> zxBuyTime = zxBuyTimeService.getZxBuyTimeListByCondition(condition);
			zxBuyProgress.setZxBuyTime(zxBuyTime);
			return zxBuyProgress;
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
	public Map<String,Object> getMapZxBuyProgressById(String id){
		try{
			Map<String,Object> zxBuyProgress = zxBuyProgressDao.getMapZxBuyProgressById(id);
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("buy_id", id);
			List<ZxBuyTime> zxBuyTime = zxBuyTimeService.getZxBuyTimeListByCondition(condition);
			zxBuyProgress.put("zxBuyTime",zxBuyTime);
			return zxBuyProgress;
		} catch (Exception e) {
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
	}
	/**
	* 添加
	* @param zx_buy_progress 
	* @return
	*/
	public int addZxBuyProgress(ZxBuyProgress zxBuyProgress){
		int i = 0;
		try {
			i = zxBuyProgressDao.addZxBuyProgress(zxBuyProgress);
			List<ZxBuyTime> zxBuyTimeTempList = zxBuyProgress.getZxBuyTime();
			if(null != zxBuyTimeTempList && zxBuyTimeTempList.size() > 0){
				List<ZxBuyTime> zxBuyTimeList = new ArrayList<ZxBuyTime>();
				for(int j = 0; j < zxBuyTimeTempList.size(); j++){
					if(zxBuyProgress.getZxBuyTime_removed_flag().indexOf(","+j+",") == -1){
						zxBuyTimeTempList.get(j).setBuy_id(zxBuyProgress.getId());
						zxBuyTimeTempList.get(j).setId(toUUID());
						zxBuyTimeList.add(zxBuyTimeTempList.get(j));
					}
				}
				if(!zxBuyTimeList.isEmpty()&&zxBuyTimeList.size()>0){
					zxBuyTimeService.addBatchZxBuyTime(zxBuyTimeList);
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
	* @param zx_buy_progress 
	* @return
	*/
	public int updateZxBuyProgress(ZxBuyProgress zxBuyProgress){
		int i = 0;
		try {
			i = zxBuyProgressDao.updateZxBuyProgressBySelective(zxBuyProgress);
			List<ZxBuyTime> zxBuyTimeList = zxBuyProgress.getZxBuyTime();
			if(null != zxBuyTimeList && zxBuyTimeList.size() > 0){
				List<ZxBuyTime> zxBuyTimeAddList = new ArrayList<ZxBuyTime>();
				List<ZxBuyTime> zxBuyTimeUpdateList = new ArrayList<ZxBuyTime>();
				BigDecimal realAmount = new BigDecimal(0);
				BigDecimal inAmount = new BigDecimal(0);
				BigDecimal outAmount = new BigDecimal(0);
				Date inStartTime = null;
				Date inEndTime = null;
				Date outStartTime = null;
				Date outEndTime = null;
				for(int j = 0; j < zxBuyTimeList.size(); j++){
					if(zxBuyProgress.getZxBuyTime_removed_flag().indexOf(","+j+",") == -1){
						zxBuyTimeList.get(j).setBuy_id(zxBuyProgress.getId());
						if(StringUtils.isBlank(zxBuyTimeList.get(j).getId())){
							zxBuyTimeList.get(j).setId(toUUID());
							zxBuyTimeAddList.add(zxBuyTimeList.get(j));
						}else{
							zxBuyTimeUpdateList.add(zxBuyTimeList.get(j));
						}
						realAmount = realAmount.add(new BigDecimal(zxBuyTimeList.get(j).getReal_amount()));
						if(StringUtils.isNotBlank(zxBuyTimeList.get(j).getIn_warehouse_date())){
							if(null == inEndTime){
								inEndTime = DateUtils.parseDate(zxBuyTimeList.get(j).getIn_warehouse_date());
							}
							inStartTime = DateUtils.parseDate(zxBuyTimeList.get(j).getIn_warehouse_date());
							if(inEndTime.compareTo(inStartTime) < 0){
								inEndTime = inStartTime;
							}
							inAmount = inAmount.add(new BigDecimal(zxBuyTimeList.get(j).getIn_warehouse_amount()));
							if(StringUtils.isNotBlank(zxBuyTimeList.get(j).getOut_warehouse_date())){
								if(null == outEndTime){
									outEndTime = DateUtils.parseDate(zxBuyTimeList.get(j).getOut_warehouse_date());
								}
								outStartTime = DateUtils.parseDate(zxBuyTimeList.get(j).getOut_warehouse_date());
								if(outEndTime.compareTo(outStartTime) < 0){
									outEndTime = outStartTime;
								}
								outAmount = outAmount.add(new BigDecimal(zxBuyTimeList.get(j).getOut_warehouse_amount()));
							}
						}
					}
				}
				if(!zxBuyTimeAddList.isEmpty()&&zxBuyTimeAddList.size()>0){
					zxBuyTimeService.addBatchZxBuyTime(zxBuyTimeAddList);
				}
				if(!zxBuyTimeUpdateList.isEmpty()&&zxBuyTimeUpdateList.size()>0){
					zxBuyTimeService.updateBatchZxBuyTimeBySelective(zxBuyTimeUpdateList);
				}
				zxBuyProgress.setReal_amount(realAmount.doubleValue());
				if(null != inEndTime){
					zxBuyProgress.setIn_warehouse_date(DateUtils.formatDateTime(inEndTime));
					zxBuyProgress.setIn_warehouse_amount(inAmount.doubleValue());
					zxBuyProgress.setStatus("3");
				}
				if(null != outEndTime){
					zxBuyProgress.setOut_warehouse_date(DateUtils.formatDateTime(outEndTime));
					zxBuyProgress.setOut_warehouse_amount(outAmount.doubleValue());
					ZxBuyProgress progress = getZxBuyProgressById(zxBuyProgress.getId());
					if(outAmount.compareTo(new BigDecimal(progress.getBuy_amount())) == 0){
						zxBuyProgress.setStatus("4");
					}
				}
				i = zxBuyProgressDao.updateZxBuyProgressBySelective(zxBuyProgress);
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
	* @param zx_buy_progress 
	* @return
	*/
	public int updateZxBuyProgressBySelective(ZxBuyProgress zxBuyProgress){
		int i = 0;
		try {
			i = zxBuyProgressDao.updateZxBuyProgressBySelective(zxBuyProgress);
			List<ZxBuyTime> zxBuyTimeList = zxBuyProgress.getZxBuyTime();
			List<ZxBuyTime> zxBuyTimeAddList = new ArrayList<ZxBuyTime>();
			List<ZxBuyTime> zxBuyTimeUpdateList = new ArrayList<ZxBuyTime>();
			for(int j = 0; j < zxBuyTimeList.size(); j++){
				if(zxBuyProgress.getZxBuyTime_removed_flag().indexOf(","+j+",") == -1){
					zxBuyTimeList.get(j).setBuy_id(zxBuyProgress.getId());
					if(StringUtils.isEmpty(zxBuyTimeList.get(j).getId())){
						zxBuyTimeList.get(j).setId(toUUID());
						zxBuyTimeAddList.add(zxBuyTimeList.get(j));
					}else{
						zxBuyTimeUpdateList.add(zxBuyTimeList.get(j));
					}
				}
			}
			if(!zxBuyTimeAddList.isEmpty()&&zxBuyTimeAddList.size()>0){
				zxBuyTimeService.addBatchZxBuyTime(zxBuyTimeAddList);
			}
			if(!zxBuyTimeUpdateList.isEmpty()&&zxBuyTimeUpdateList.size()>0){
				zxBuyTimeService.updateBatchZxBuyTimeBySelective(zxBuyTimeUpdateList);
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
	public int delZxBuyProgress(Map<String,Object> condition){
		int i = 0;
		try {
			i = zxBuyProgressDao.delZxBuyProgress(condition);
			String[] idList= (String[])condition.get("id");
			for(String id:idList){
				zxBuyTimeService.delZxBuyTimeByForeignKey(id);
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
	* @param zx_buy_progressList 
	* @return
	*/
	public int addBatchZxBuyProgress(List<ZxBuyProgress> zxBuyProgressList){
		int i = 0;
		try {
			i = zxBuyProgressDao.addBatchZxBuyProgress(zxBuyProgressList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改
	* @param zx_buy_progressList 
	* @return
	*/
	public int updateBatchZxBuyProgress(List<ZxBuyProgress> zxBuyProgressList){
		int i = 0;
		try {
			i = zxBuyProgressDao.updateBatchZxBuyProgress(zxBuyProgressList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
	/**
	* 批量修改（根据动态条件）
	* @param zx_buy_progressList 
	* @return
	*/
	public int updateBatchZxBuyProgressBySelective(List<ZxBuyProgress> zxBuyProgressList){
		int i = 0;
		try {
			i = zxBuyProgressDao.updateBatchZxBuyProgressBySelective(zxBuyProgressList);
		} catch (Exception e) {
			i = 0;
			/**方案一加上这句话这样程序异常时才能被aop捕获进而回滚**/
			throw new ExceptionUtil(e.getMessage(),e.getCause());
		}
		return i;
	}
}
