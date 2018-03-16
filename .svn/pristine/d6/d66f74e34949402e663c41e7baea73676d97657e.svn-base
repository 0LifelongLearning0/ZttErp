package jehc.xtmodules.xtcore.util.quartz.task;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jehc.xtmodules.xtcore.util.CommonUtils;
import jehc.xtmodules.xtcore.util.UUID;
import jehc.xtmodules.xtcore.util.springutil.SpringUtil;
import jehc.zxmodules.model.ZxJudgeAgainResult;
import jehc.zxmodules.model.ZxSupplier;
import jehc.zxmodules.service.ZxJudgeAgainResultService;
import jehc.zxmodules.service.ZxSupplierService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 添加再评审
 * @author Administrator
 *
 */
public class Zx_Judge_Again_Task extends Thread{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 业务逻辑处理
	 */
	public void service() {
		new Zx_Judge_Again_Task().start();
	}
	
	public void run(){
		try {
			excute();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void excute(){
		logger.info("----------开始添加再评审--------------");
		addResult();
	}
	
	private void addResult(){
		ZxSupplierService zxSupplierService = (ZxSupplierService)SpringUtil.getBean("zxSupplierService");
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("state", 1);
		List<ZxSupplier> suppliers = zxSupplierService.getZxSupplierListByCondition(condition);
		if(suppliers != null&&!suppliers.isEmpty()){
			Calendar cal = Calendar.getInstance();
			int months = cal.get(Calendar.YEAR) * 12 + cal.get(Calendar.MONTH) + 1;
			String date = CommonUtils.getSimpleDateFormat();
			
			ZxJudgeAgainResultService zxJudgeAgainResultService = (ZxJudgeAgainResultService)SpringUtil.getBean("zxJudgeAgainResultService");
			List<ZxSupplier> list1 = new ArrayList<ZxSupplier>();
			List<ZxJudgeAgainResult> list2 = new ArrayList<ZxJudgeAgainResult>();
			
			for(ZxSupplier supplier:suppliers){
				if(supplier.getYc_num() > 0&&StringUtils.isNoneBlank(supplier.getJudge_cycle())){
					condition = new HashMap<String, Object>();
					condition.put("state", 1);
					condition.put("supplier_id", supplier.getId());
					condition.put("order_by_judge_date", 1);
					List<ZxJudgeAgainResult> agains = zxJudgeAgainResultService.getZxJudgeAgainResultListByCondition(condition);
					if(agains != null&&!agains.isEmpty()){
						ZxJudgeAgainResult recentResult = agains.get(0);
						int cycle = 1;
						if(supplier.getJudge_cycle().equals("1")){
							cycle = 12;
						}else if(supplier.getJudge_cycle().equals("2")){
							cycle = 4;
						}
						
						if(recentResult.getJudge_date() + cycle <= months){
							ZxJudgeAgainResult again = new ZxJudgeAgainResult();
							again.setId(UUID.toUUID());
							again.setSupplier_id(supplier.getId());
							again.setJudge_date(months);
							again.setStatus("1");
							again.setState("1");
							again.setCreate_date(date);
							list2.add(again);
							
							supplier.setIs_judge("1");
							list1.add(supplier);
						}
					}else{
						ZxJudgeAgainResult again = new ZxJudgeAgainResult();
						again.setId(UUID.toUUID());
						again.setSupplier_id(supplier.getId());
						again.setJudge_date(months + 1);
						again.setStatus("1");
						again.setState("1");
						again.setCreate_date(date);
						list2.add(again);
						
						supplier.setIs_judge("1");
						list1.add(supplier);
					}
				}
			}
			
			if(!list1.isEmpty())zxSupplierService.updateBatchZxSupplier(list1);
			if(!list2.isEmpty())zxJudgeAgainResultService.addBatchZxJudgeAgainResult(list2);
		}
	}
}
